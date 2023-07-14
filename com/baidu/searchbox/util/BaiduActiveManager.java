package com.baidu.searchbox.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.android.PkgUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.searchbox.active.data.ActiveTimeInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.tieba.e20;
import com.baidu.tieba.m30;
import com.baidu.util.Base64Encoder;
import com.meizu.cloud.pushsdk.notification.model.AdvertisementOption;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary4util.bdapp.Base64;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes4.dex */
public final class BaiduActiveManager {
    public static final String ACTIVE_DEVICE_BEHAVIOR_PURPOSE = "active";
    public static final String BASIC_DEVICE_BEHAVIOR_SCENE = "basic";
    public static final String CLONE_CUID = "clncuid";
    public static final String KEY_ACTIVE = "active";
    public static final String KEY_ACTIVE_REQUEST_TIME = "active_request_time";
    public static final String KEY_ACTIVE_TIME = "active_succ_time";
    public static final String KEY_TIME = "time";
    public static final String KEY_TIME_STAMP = "time_stamp";
    public static final String POST_REQUEST_KEY = "data";
    public static final String PREFS_NAME = "identity";
    public static final String RAND_ID = "randid";
    public static final int RESPONSE_CODE_DEFAULT = -1;
    public static final String TAG = "BaiduActiveManager";
    public static final String WARM_TIPS_SP_NAME = "com.baidu.searchbox.warmtips";
    public static BaiduActiveManager sActiveManager;
    public Context mContext;
    public IBaiduIdentityContext mIdentityContextImpl;
    public SharedPreferences mSettings;
    public static final boolean DEBUG = LibBLCConfig.GLOBAL_DEBUG;
    public static volatile boolean mStartRequest = false;
    public String mInvokeSource = null;
    public String mLauncherSource = null;
    public String mLauncherExt = null;
    public String mOriginalLauncherExt = null;
    public String mConfirmSource = null;
    public String mConfirmExt = null;
    public String mClnCuid = null;

    /* loaded from: classes4.dex */
    public static final class ActiveTimeParser {
        public static final String TAG = "ActiveTimeParser";
        public static ActiveTimeParser mParser;
        public DocumentBuilder mDocumentBuilder = null;

        public ActiveTimeParser() {
            init();
        }

        public static ActiveTimeParser getInstance() {
            if (mParser == null) {
                mParser = new ActiveTimeParser();
            }
            return mParser;
        }

        private void init() {
            try {
                this.mDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException unused) {
                if (BaiduActiveManager.DEBUG) {
                    Log.w(TAG, "ParserConfigurationException");
                }
            }
        }

        public String[] parse(InputStream inputStream) {
            String str;
            Document parse;
            String str2 = "0";
            if (inputStream == null) {
                return null;
            }
            try {
                parse = this.mDocumentBuilder.parse(inputStream);
                Node namedItem = parse.getElementsByTagName("appcommand").item(0).getAttributes().getNamedItem("time");
                if (namedItem == null) {
                    str = "0";
                } else {
                    str = namedItem.getNodeValue();
                }
            } catch (IOException unused) {
                str = "0";
            } catch (SAXException unused2) {
                str = "0";
            } catch (Exception unused3) {
                str = "0";
            }
            try {
                Node item = parse.getElementsByTagName("timestamp").item(0);
                if (item != null) {
                    str2 = item.getFirstChild().getNodeValue();
                }
            } catch (IOException unused4) {
                Log.w(TAG, "IOException");
                return new String[]{str2, str};
            } catch (SAXException unused5) {
                Log.w(TAG, "SAXException");
                return new String[]{str2, str};
            } catch (Exception unused6) {
                Log.w(TAG, "getDingFromXml-method-exception");
                return new String[]{str2, str};
            }
            return new String[]{str2, str};
        }
    }

    public static String getActiveUrl() {
        return String.format("%s/searchbox?action=active", HostConfig.getSearchboxHostForHttps());
    }

    public static synchronized BaiduActiveManager getInstance() {
        BaiduActiveManager baiduActiveManager;
        synchronized (BaiduActiveManager.class) {
            if (sActiveManager == null) {
                sActiveManager = new BaiduActiveManager(AppRuntime.getAppContext());
            }
            baiduActiveManager = sActiveManager;
        }
        return baiduActiveManager;
    }

    private String getRandId() {
        return new SharedPrefsWrapper("com.baidu.searchbox.warmtips").getString("randid", "");
    }

    private boolean isNeedUploadCloneCuid() {
        if (TextUtils.isEmpty(this.mClnCuid)) {
            return false;
        }
        if (TextUtils.equals(this.mClnCuid, this.mSettings.getString(CLONE_CUID, ""))) {
            return false;
        }
        return true;
    }

    public long getActiveSuccTime() {
        SharedPreferences sharedPreferences = this.mSettings;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(KEY_ACTIVE_TIME, 0L);
    }

    public String getActiveTime() {
        SharedPreferences sharedPreferences = this.mSettings;
        String str = "0";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("time", "0");
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public ActiveTimeInfo getActiveTimeInfo() {
        long j;
        long j2;
        long j3;
        SharedPreferences sharedPreferences = this.mSettings;
        if (sharedPreferences != null) {
            long j4 = sharedPreferences.getLong(KEY_ACTIVE_REQUEST_TIME, 0L);
            long j5 = this.mSettings.getLong("time_stamp", 0L);
            j3 = this.mSettings.getLong(KEY_ACTIVE_TIME, 0L);
            j = j4;
            j2 = j5;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
        }
        return new ActiveTimeInfo(j, j2, j3);
    }

    public boolean isActiveSucc() {
        SharedPreferences sharedPreferences = this.mSettings;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("active", false);
    }

    public BaiduActiveManager(Context context) {
        init(context);
    }

    private String encrypt(String str) {
        try {
            return URLEncoder.encode(new String(Base64.encode(this.mIdentityContextImpl.encryptByNativeBds(BaiduIdentityManager.getInstance().getUid(), str), 0)), "utf-8");
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "encrypt error!", e);
            }
            return "";
        }
    }

    private void init(Context context) {
        this.mContext = context;
        this.mSettings = context.getSharedPreferences("identity", 0);
        this.mIdentityContextImpl = BaiduIdentityRuntime.getBaiduIdentityContext();
    }

    public void setInvokeSource(String str) {
        this.mInvokeSource = str;
    }

    public void setLauncherSource(String str, String str2, String str3) {
        this.mLauncherSource = str;
        this.mLauncherExt = str2;
        this.mOriginalLauncherExt = str3;
    }

    private String encode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        return new String(Base64Encoder.B64Encode(str.getBytes()));
    }

    public void setConfirmSource(String str, String str2) {
        this.mConfirmSource = str;
        this.mConfirmExt = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> getActivePostData() {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "";
        String fnplusJsonString = getFnplusJsonString();
        if (DEBUG) {
            Log.d(TAG, "jsonValue= " + fnplusJsonString);
        }
        String encrypt = encrypt(BaiduIdentityManager.getInstance().getTn());
        String encrypt2 = encrypt(fnplusJsonString);
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
            str = new String(Base64Encoder.B64Encode(Long.toString(packageInfo.firstInstallTime).getBytes()));
            try {
                str2 = new String(Base64Encoder.B64Encode(Long.toString(packageInfo.lastUpdateTime).getBytes()));
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                str2 = "";
            } catch (UnsupportedOperationException e2) {
                e = e2;
                str2 = "";
            }
            try {
                if (DEBUG) {
                    Log.d(TAG, "firstInstallTime=" + packageInfo.firstInstallTime + ",lastUpdateTime=" + packageInfo.lastUpdateTime);
                }
            } catch (PackageManager.NameNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                String encode = encode(getRandId(), "none");
                String encode2 = encode(m30.f(AppRuntime.getAppContext()).e(), "none");
                String encode3 = encode(this.mInvokeSource, "none");
                String encode4 = encode(this.mLauncherSource, "none");
                String encode5 = encode(this.mLauncherExt, "none");
                String encode6 = encode(this.mConfirmSource, "none");
                String encode7 = encode(this.mConfirmExt, "none");
                if (!TextUtils.isEmpty(this.mClnCuid)) {
                }
                String encode8 = encode(String.valueOf(Build.TIME), "none");
                String encode9 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
                jSONObject = new JSONObject();
                jSONObject.put("fn", encrypt);
                jSONObject.put("fnplus", encrypt2);
                jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
                jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
                jSONObject.put("randid", encode);
                jSONObject.put("iid", encode2);
                jSONObject.put("source", encode3);
                jSONObject.put("lsr", encode4);
                jSONObject.put("lex", encode5);
                jSONObject.put("csr", encode6);
                jSONObject.put("cex", encode7);
                jSONObject.put(CLONE_CUID, str3);
                jSONObject.put("bst", encode8);
                jSONObject.put("rst", encode9);
                if (DEBUG) {
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONObject.toString());
                return linkedHashMap;
            } catch (UnsupportedOperationException e4) {
                e = e4;
                e.printStackTrace();
                String encode10 = encode(getRandId(), "none");
                String encode22 = encode(m30.f(AppRuntime.getAppContext()).e(), "none");
                String encode32 = encode(this.mInvokeSource, "none");
                String encode42 = encode(this.mLauncherSource, "none");
                String encode52 = encode(this.mLauncherExt, "none");
                String encode62 = encode(this.mConfirmSource, "none");
                String encode72 = encode(this.mConfirmExt, "none");
                if (!TextUtils.isEmpty(this.mClnCuid)) {
                }
                String encode82 = encode(String.valueOf(Build.TIME), "none");
                String encode92 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
                jSONObject = new JSONObject();
                jSONObject.put("fn", encrypt);
                jSONObject.put("fnplus", encrypt2);
                jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
                jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
                jSONObject.put("randid", encode10);
                jSONObject.put("iid", encode22);
                jSONObject.put("source", encode32);
                jSONObject.put("lsr", encode42);
                jSONObject.put("lex", encode52);
                jSONObject.put("csr", encode62);
                jSONObject.put("cex", encode72);
                jSONObject.put(CLONE_CUID, str3);
                jSONObject.put("bst", encode82);
                jSONObject.put("rst", encode92);
                if (DEBUG) {
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("data", jSONObject.toString());
                return linkedHashMap2;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e = e5;
            str = "";
            str2 = str;
        } catch (UnsupportedOperationException e6) {
            e = e6;
            str = "";
            str2 = str;
        }
        String encode102 = encode(getRandId(), "none");
        String encode222 = encode(m30.f(AppRuntime.getAppContext()).e(), "none");
        String encode322 = encode(this.mInvokeSource, "none");
        String encode422 = encode(this.mLauncherSource, "none");
        String encode522 = encode(this.mLauncherExt, "none");
        String encode622 = encode(this.mConfirmSource, "none");
        String encode722 = encode(this.mConfirmExt, "none");
        if (!TextUtils.isEmpty(this.mClnCuid)) {
            str3 = this.mClnCuid;
        }
        String encode822 = encode(String.valueOf(Build.TIME), "none");
        String encode922 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
        jSONObject = new JSONObject();
        try {
            jSONObject.put("fn", encrypt);
            jSONObject.put("fnplus", encrypt2);
            jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
            jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
            jSONObject.put("randid", encode102);
            jSONObject.put("iid", encode222);
            jSONObject.put("source", encode322);
            jSONObject.put("lsr", encode422);
            jSONObject.put("lex", encode522);
            jSONObject.put("csr", encode622);
            jSONObject.put("cex", encode722);
            jSONObject.put(CLONE_CUID, str3);
            jSONObject.put("bst", encode822);
            jSONObject.put("rst", encode922);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, "active body info: " + jSONObject.toString());
        }
        LinkedHashMap linkedHashMap22 = new LinkedHashMap();
        linkedHashMap22.put("data", jSONObject.toString());
        return linkedHashMap22;
    }

    private String getFnplusJsonString() {
        Context context = this.mContext;
        String sign = PkgUtils.getSign(context, context.getPackageName());
        if (DEBUG) {
            Log.d(TAG, "signValue= " + sign);
        }
        String md5 = MD5Utils.toMd5(sign.getBytes(), false);
        if (DEBUG) {
            Log.d(TAG, "MD5(ac)= " + md5);
        }
        String localPhotoInfo = getLocalPhotoInfo();
        String localFileSystemInfo = getLocalFileSystemInfo();
        String ipInfo = getIpInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ac", URLEncoder.encode(md5, "utf-8"));
            jSONObject.put("apn", URLEncoder.encode(localPhotoInfo, "utf-8"));
            jSONObject.put("afn", URLEncoder.encode(localFileSystemInfo, "utf-8"));
            jSONObject.put(AdvertisementOption.AD_INSTALL_PACKAGE, URLEncoder.encode(ipInfo, "utf-8"));
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalFileSystemInfo() {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Throwable th;
        String str = null;
        try {
            File[] listFiles = Environment.getExternalStorageDirectory().listFiles(new FileFilter() { // from class: com.baidu.searchbox.util.BaiduActiveManager.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !TextUtils.isEmpty(file.getName())) {
                        return true;
                    }
                    return false;
                }
            });
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.searchbox.util.BaiduActiveManager.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    return (int) (file.lastModified() - file2.lastModified());
                }
            });
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    try {
                        for (File file : listFiles) {
                            dataOutputStream.writeUTF(file.getName());
                        }
                        dataOutputStream.flush();
                        str = Util.toMd5(byteArrayOutputStream.toByteArray(), true);
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            Log.e(TAG, "getLocalFileSystemInfo fail!" + e.toString());
                        }
                        Closeables.closeSafely(dataOutputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        if (!TextUtils.isEmpty(str)) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(dataOutputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                th = th;
                Closeables.closeSafely(dataOutputStream);
                Closeables.closeSafely(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        }
        Closeables.closeSafely(dataOutputStream);
        Closeables.closeSafely(byteArrayOutputStream);
        if (!TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private AbstractHttpEntity getPostData() {
        UrlEncodedFormEntity urlEncodedFormEntity;
        String fnplusJsonString = getFnplusJsonString();
        if (DEBUG) {
            Log.d(TAG, "jsonValue= " + fnplusJsonString);
        }
        String encrypt = encrypt(BaiduIdentityManager.getInstance().getTn());
        String encrypt2 = encrypt(fnplusJsonString);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fn", encrypt);
            jSONObject.put("fnplus", encrypt2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, "active body info: " + jSONObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("data", jSONObject.toString()));
        UrlEncodedFormEntity urlEncodedFormEntity2 = null;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
        }
        try {
            urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
            return urlEncodedFormEntity;
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            urlEncodedFormEntity2 = urlEncodedFormEntity;
            e.printStackTrace();
            return urlEncodedFormEntity2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        r1 = r6.getColumnIndex("title");
        r0 = r6.getColumnIndex("_size");
        r5 = new java.io.ByteArrayOutputStream(1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
        r7 = new java.io.DataOutputStream(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0055, code lost:
        r8 = r6.getString(r1);
        r9 = r6.getString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduActiveManager.TAG, "title: " + r8 + " size: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007e, code lost:
        r7.writeUTF(r8 + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0094, code lost:
        if (r6.moveToNext() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0096, code lost:
        r7.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a1, code lost:
        r0 = com.baidu.searchbox.util.Util.toMd5(r5.toByteArray(), true);
        r17 = r6;
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a6, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00aa, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ab, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e7, code lost:
        com.baidu.android.common.logging.Log.e(com.baidu.searchbox.util.BaiduActiveManager.TAG, "getLocalPhotoInfo fail!" + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ff, code lost:
        com.baidu.android.util.io.Closeables.closeSafely(r17);
        com.baidu.android.util.io.Closeables.closeSafely(r7);
        com.baidu.android.util.io.Closeables.closeSafely(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0111, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalPhotoInfo() {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        String str2 = null;
        DataOutputStream dataOutputStream2 = null;
        try {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            Uri[] uriArr = {MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.INTERNAL_CONTENT_URI};
            String[] strArr = {"title", "_size"};
            cursor = null;
            int i = 0;
            while (true) {
                if (i < 2) {
                    try {
                        int i2 = i;
                        Cursor query = contentResolver.query(uriArr[i], strArr, null, null, "date_modified DESC LIMIT 10");
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    break;
                                }
                            } catch (Exception e) {
                                e = e;
                                byteArrayOutputStream = null;
                                dataOutputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                                dataOutputStream = null;
                            }
                        }
                        Closeables.closeSafely(query);
                        i = i2 + 1;
                        cursor = query;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        dataOutputStream = null;
                        cursor2 = cursor;
                        Closeables.closeSafely(cursor2);
                        Closeables.closeSafely(dataOutputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    str = null;
                    byteArrayOutputStream = null;
                    break;
                }
            }
            Closeables.closeSafely(cursor);
            Closeables.closeSafely(dataOutputStream2);
            Closeables.closeSafely(byteArrayOutputStream);
            str2 = str;
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActiveUBCEvent(int i, String str) {
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (i == 200) {
            str2 = BaiduActiveStatistic.UBC_VALUE_REQUEST_SUCCESS;
        } else {
            str2 = BaiduActiveStatistic.UBC_VALUE_REQUEST_FAILED;
        }
        try {
            jSONObject.put("data", str);
            jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_ACTIVE_TIME_INFO, getActiveTimeInfo());
            jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_RESPONSE_CODE, i);
            jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_PRI_ABI, DeviceUtil.CPUInfo.getPreferredABI());
            if (TextUtils.isEmpty(this.mOriginalLauncherExt)) {
                str3 = "";
            } else {
                str3 = this.mOriginalLauncherExt;
            }
            jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_ORIGINAL_DATA, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        BaiduActiveStatistic.onUBCEvent(str2, this.mLauncherSource, jSONObject.toString());
    }

    public void active(final Context context) {
        boolean z = this.mSettings.getBoolean("active", false);
        this.mClnCuid = DeviceId.getOldCUID(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d(TAG, "clone cuid: " + this.mClnCuid);
            Log.d(TAG, "active time info: " + getActiveTimeInfo());
        }
        if (z && !isNeedUploadCloneCuid()) {
            if (DEBUG) {
                Log.d(TAG, "already active");
            }
        } else if (mStartRequest) {
            if (DEBUG) {
                Log.d(TAG, "has start active request");
            }
        } else {
            mStartRequest = true;
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.util.BaiduActiveManager.1
                /* JADX WARN: Code restructure failed: missing block: B:47:0x01c8, code lost:
                    if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x01d8, code lost:
                    if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x01ea, code lost:
                    if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L46;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x01ec, code lost:
                    com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduActiveManager.TAG, "active request finished");
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x01ef, code lost:
                    r0 = com.baidu.searchbox.util.BaiduActiveManager.mStartRequest = false;
                    r14.this$0.sendActiveUBCEvent(-1, r6);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x01f7, code lost:
                    return;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    SharedPreferences.Editor edit;
                    String appendParam;
                    Map<String, String> activePostData;
                    String str;
                    ResponseBody body;
                    Process.setThreadPriority(10);
                    String str2 = null;
                    InputStream inputStream = null;
                    String str3 = null;
                    str2 = null;
                    str2 = null;
                    BaiduActiveStatistic.onUBCEvent(BaiduActiveStatistic.UBC_VALUE_REQUEST_START, BaiduActiveManager.this.mLauncherSource, null);
                    int i = -1;
                    try {
                        try {
                            edit = BaiduActiveManager.this.mSettings.edit();
                            edit.putLong(BaiduActiveManager.KEY_ACTIVE_REQUEST_TIME, System.currentTimeMillis());
                            edit.commit();
                            String str4 = (BaiduActiveManager.getActiveUrl() + "&uuid=" + BaiduIdentityUtils.getSoftwareUUID(context)) + "&udata=" + BaiduIdentityUtils.getAppType(context, context.getPackageName());
                            String preferredABI = DeviceUtil.CPUInfo.getPreferredABI();
                            if (TextUtils.isEmpty(preferredABI)) {
                                preferredABI = "none";
                            }
                            appendParam = BaiduIdentityManager.getInstance().appendParam(str4 + "&pre_abi=" + new String(Base64Encoder.B64Encode(preferredABI.getBytes())), 1);
                            if (BaiduActiveManager.DEBUG) {
                                Log.d(BaiduActiveManager.TAG, "usePrivacyPolicy: " + e20.b().h());
                                Log.d(BaiduActiveManager.TAG, "active url: QALog-" + appendParam);
                            }
                            activePostData = BaiduActiveManager.this.getActivePostData();
                            if (activePostData != null) {
                                str = activePostData.get("data");
                            } else {
                                str = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException unused) {
                    } catch (IllegalArgumentException unused2) {
                    } catch (ClientProtocolException unused3) {
                    }
                    try {
                        Response executeSync = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(appendParam)).params(activePostData).cookieManager(BaiduActiveManager.this.mIdentityContextImpl.obtainCookieManager(true, false))).enableStat(true)).requestFrom(10)).requestSubFrom(DebugConstants.HTTP_ERRCODE_VERSION_HIGH)).build().executeSync();
                        if (executeSync != null && (i = executeSync.code()) == 200 && (body = executeSync.body()) != null) {
                            try {
                                inputStream = body.byteStream();
                                String[] parse = ActiveTimeParser.getInstance().parse(inputStream);
                                if (parse != null && !TextUtils.equals(parse[0], "0")) {
                                    edit.putBoolean("active", true);
                                    edit.putString("time", parse[0]);
                                    edit.putLong("time_stamp", Long.parseLong(parse[1]));
                                    edit.putLong(BaiduActiveManager.KEY_ACTIVE_TIME, System.currentTimeMillis());
                                    if (!TextUtils.isEmpty(BaiduActiveManager.this.mClnCuid)) {
                                        edit.putString(BaiduActiveManager.CLONE_CUID, BaiduActiveManager.this.mClnCuid);
                                    }
                                    edit.commit();
                                }
                                Closeables.closeSafely(inputStream);
                            } catch (Throwable th2) {
                                Closeables.closeSafely(inputStream);
                                throw th2;
                            }
                        }
                        if (BaiduActiveManager.DEBUG) {
                            Log.d(BaiduActiveManager.TAG, "active request finished");
                        }
                        boolean unused4 = BaiduActiveManager.mStartRequest = false;
                        BaiduActiveManager.this.sendActiveUBCEvent(i, str);
                    } catch (ClientProtocolException unused5) {
                        str2 = str;
                        if (BaiduActiveManager.DEBUG) {
                            Log.d(BaiduActiveManager.TAG, "active failed, maybe net error.");
                        }
                    } catch (IOException unused6) {
                        str2 = str;
                        if (BaiduActiveManager.DEBUG) {
                            Log.d(BaiduActiveManager.TAG, "active failed, maybe net error.");
                        }
                    } catch (IllegalArgumentException unused7) {
                        str2 = str;
                        if (BaiduActiveManager.DEBUG) {
                            Log.d(BaiduActiveManager.TAG, "active failed, url is invalid.");
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = str;
                        if (BaiduActiveManager.DEBUG) {
                            Log.d(BaiduActiveManager.TAG, "active request finished");
                        }
                        boolean unused8 = BaiduActiveManager.mStartRequest = false;
                        BaiduActiveManager.this.sendActiveUBCEvent(-1, str3);
                        throw th;
                    }
                }
            }, "ActiveRequest", 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getIpInfo() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        break loop0;
                    }
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getIpInfo fail!" + e.toString());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
