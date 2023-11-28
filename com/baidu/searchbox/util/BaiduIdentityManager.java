package com.baidu.searchbox.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.browser.BrowserType;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.ax;
import com.baidu.tieba.cy;
import com.baidu.tieba.dx;
import com.baidu.tieba.ex;
import com.baidu.tieba.h4;
import com.baidu.tieba.uw;
import com.baidu.tieba.vw;
import com.baidu.tieba.ww;
import com.baidu.util.Base64Encoder;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class BaiduIdentityManager {
    public static final String CSRC = "csrc";
    public static final boolean DEBUG = LibBLCConfig.GLOBAL_DEBUG;
    public static final String DEFAULT_BD_FRAMEWORK = "1";
    public static final String KEY_LAST_TN = "lasttn";
    public static final String KEY_TN_TRACE = "tntrace";
    public static final int LIGHTAPP_TS_PARAM_LEN = 7;
    public static final String LOCINFO_STRING = "colinfo";
    public static final int MAX_LOC_WIFI_NUMBER = 15;
    public static final int MIN_LOC_WIFI_NUMBER = 6;
    public static final String PARAM_BDOS = "bdos";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_BD_FRAMEWORK = "bd_framework";
    public static final String PARAM_BD_VIP = "bd_vip";
    public static final String PARAM_BRNACH_NAME = "branchname";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CEN = "cen";
    public static final String PARAM_CMODE = "cmode";
    public static final String PARAM_CTV = "ctv";
    public static final String PARAM_CUA = "cua";
    public static final String PARAM_CUID = "cuid";
    public static final String PARAM_CUT = "cut";
    public static final String PARAM_IID = "iid";
    public static final String PARAM_LIGHTAPP_DEBUG = "debug";
    public static final String PARAM_MAPPING_SIGN = "mps";
    public static final String PARAM_MAPPING_VERSION = "mpv";
    public static final String PARAM_MATRIXSTYLE = "matrixstyle";
    public static final String PARAM_NETWORK = "network";
    public static final String PARAM_NETWORK_MODE = "p_nw";
    public static final String PARAM_OSBRANCH = "osbranch";
    public static final String PARAM_OSNAME = "osname";
    public static final String PARAM_PASSUID = "puid";
    public static final String PARAM_PU = "pu";
    public static final String PARAM_SDK_VERSION = "p_sv";
    public static final String PARAM_SERVICE = "bdbox";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_TIME_STAMP = "ts";
    public static final String PARAM_TYPE_ID = "typeid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static final String PREFS_NAME = "identity";
    public static final int PRIVACY_VERSION_V1 = 1;
    public static final Set<String> SEARCHBOX_CUSTOM_PARAMS;
    public static final int SUGGESTION_VERSION = 3;
    public static final String TAG = "BaiduIdentityManager";
    public static final String VALUE_OSNAME = "baiduboxapp";
    public static BaiduIdentityManager sIdentityManager;
    public vw customOSParam;
    public String mAndroidId;
    public CT mCT;
    @SuppressLint({"StaticFieldLeak"})
    public Context mContext;
    public ww mDeviceInfoParam;
    public String mEnUa;
    public IBaiduIdentityContext mIdentityContextImpl;
    public String mLastTn;
    public SharedPreferences mSettings;
    public String mTn;
    public String mUa;
    public String mVersionName;
    public String mEnAndroidId = null;
    public volatile String mC3Aid = null;
    public HashMap<String, String> mProcessedUa = new HashMap<>(2);

    @SuppressLint({"HardwareIds"})
    @Deprecated
    public String getImsiInfo() {
        return "";
    }

    /* renamed from: com.baidu.searchbox.util.BaiduIdentityManager$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$browser$BrowserType;

        static {
            int[] iArr = new int[BrowserType.values().length];
            $SwitchMap$com$baidu$browser$BrowserType = iArr;
            try {
                iArr[BrowserType.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.RABBIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.RABBIT_LITE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_MASTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_SLAVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_WEBVIEW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_ADLANDING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        SEARCHBOX_CUSTOM_PARAMS = hashSet;
        hashSet.add("uid");
        SEARCHBOX_CUSTOM_PARAMS.add("from");
        SEARCHBOX_CUSTOM_PARAMS.add("ua");
        SEARCHBOX_CUSTOM_PARAMS.add("ut");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_OSNAME);
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_OSBRANCH);
        SEARCHBOX_CUSTOM_PARAMS.add("pkgname");
        SEARCHBOX_CUSTOM_PARAMS.add("network");
        SEARCHBOX_CUSTOM_PARAMS.add("cfrom");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_CTV);
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_CEN);
        SEARCHBOX_CUSTOM_PARAMS.add("apinfo");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_PU);
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
            File[] listFiles = Environment.getExternalStorageDirectory().listFiles(new FileFilter() { // from class: com.baidu.searchbox.util.BaiduIdentityManager.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !TextUtils.isEmpty(file.getName())) {
                        return true;
                    }
                    return false;
                }
            });
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.searchbox.util.BaiduIdentityManager.2
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

    public void checkTnTrace() {
        Context context = this.mContext;
        if (DEBUG) {
            Log.e(TAG, "mLastTn: " + getLastTn());
            Log.e(TAG, "TnTrace: " + getTnTrace());
        }
        if (this.mIdentityContextImpl.isSelfUpdateInstalled(context)) {
            return;
        }
        this.mLastTn = getLastTn(context);
        if (DEBUG) {
            Log.e(TAG, "update mLastTn: " + this.mLastTn);
            Log.e(TAG, "update TnTrace: " + getTnTrace());
        }
    }

    public BaiduIdentityManager(Context context) {
        init(context);
    }

    private String addFromParam(String str) {
        return addParam(str, "from", getTn());
    }

    private String addPackageNameParam(String str) {
        return addParam(str, "pkgname", this.mIdentityContextImpl.getPkgName());
    }

    public static String clearCustomParams(String str) {
        return UrlUtil.deleteParam(str, SEARCHBOX_CUSTOM_PARAMS);
    }

    private String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }

    private String getApkTn(Context context) {
        String tn = this.mIdentityContextImpl.getTn(context);
        if (DEBUG) {
            Log.d(TAG, "load tn from R.raw.tnconfig, tn = " + tn);
        }
        if (TextUtils.isEmpty(tn)) {
            return "757b";
        }
        return tn;
    }

    @Deprecated
    public static synchronized BaiduIdentityManager getInstance(Context context) {
        BaiduIdentityManager baiduIdentityManager;
        synchronized (BaiduIdentityManager.class) {
            baiduIdentityManager = getInstance();
        }
        return baiduIdentityManager;
    }

    private String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "0.8";
        }
    }

    private String reverseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public String addBDVC(String str) {
        String bDVCInfo = this.mIdentityContextImpl.getBDVCInfo();
        if (TextUtils.isEmpty(bDVCInfo)) {
            return str;
        }
        return addParam(str, "bdvc", bDVCInfo);
    }

    public String addCfromParam(String str) {
        return addParam(str, "cfrom", getLastTn());
    }

    public String addLightAppFrameworkParam(String str) {
        return addParam(str, PARAM_BD_FRAMEWORK, "1");
    }

    public String addLocStringIfJoinUserExperience(String str) {
        if (this.mIdentityContextImpl.getJoinUserExperiencePreference(this.mContext)) {
            return addLocString(str, true);
        }
        return str;
    }

    public String addTsParam(String str) {
        return addParam(str, "ts", getLightAppTsParam());
    }

    public String addVipLightAppParam(String str) {
        return addParam(str, PARAM_BD_VIP, "1");
    }

    public String addZid(String str) {
        String zid = this.mIdentityContextImpl.getZid();
        if (TextUtils.isEmpty(zid)) {
            return str;
        }
        return addParam(str, "zid", dx.a(zid));
    }

    public String getApInfo(boolean z) {
        return getApInfo(z, 6);
    }

    public String getVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public String processAppSearchUrl(String str) {
        String addFromParam = addFromParam(str);
        if (DEBUG) {
            Log.d(TAG, "url: " + addFromParam);
        }
        return addFromParam;
    }

    public String processTypeSuggestionUrl(String str) {
        return addParam(str, "v", Integer.toString(3));
    }

    public String processUrl(String str) {
        return processUrl(str, true, true, 0);
    }

    public String processUrlWithoutNetwork(String str) {
        return processUrl(str, false, true, 0);
    }

    public String processUrlWithoutSid(String str) {
        return processUrl(str, true, false, 0);
    }

    private String addKey2Cen(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2.replace("_", "-");
        }
        return str + "_" + str2.replace("_", "-");
    }

    private String addUAParamNoEncode(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "/";
        }
        return str3 + str2;
    }

    private String addUserAgentParam(String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return addUAParamNoEncode(str, str2);
    }

    private String crcSign(String str, String str2) {
        return CommonUrlParamManager.crcSign(str, str2);
    }

    public String addDebugParam(String str, String str2) {
        return addParam(str, "debug", str2);
    }

    public String addLocString(String str, boolean z) {
        return addLocString(str, z, 6);
    }

    public String addParams(HashMap<String, String> hashMap, String str) {
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                str = addParam(str, str2, hashMap.get(str2));
            }
        }
        return str;
    }

    public String addSearchSourceParam(String str, String str2) {
        return addPuParam(str, "csrc", str2);
    }

    public String addServiceParam(String str, String str2) {
        return addParam(str, "service", str2);
    }

    public String appendParam(String str, int i) {
        if (uw.b().h()) {
            return urlAppendParam(str, i);
        }
        return processUrl(str);
    }

    public String deleteParams(String str, Set<String> set) {
        return UrlUtil.deleteParam(str, set);
    }

    public String getApInfo(boolean z, int i) {
        return getApInfo(z, i, "UTF-8");
    }

    public String processUserAgent(String str, BrowserType browserType) {
        String str2;
        int i = AnonymousClass3.$SwitchMap$com$baidu$browser$BrowserType[browserType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str2 = null;
                    } else {
                        str2 = "rabbit/1.0_lite";
                    }
                } else {
                    str2 = "rabbit/1.0";
                }
            } else {
                str2 = "search/1.0";
            }
        } else {
            str2 = "light/1.0";
        }
        return ex.f().c(str, str2);
    }

    public String processWebSearchUrl(String str, boolean z) {
        return processWebSearchUrl(str, 0, z);
    }

    public String processWidgetUrl(String str, String str2) {
        return processUrl(addParam(str, WarmTipsManager.WIDGET_SOURCE_VALUE, str2));
    }

    public String urlAppendParam(String str, int i) {
        return processUrl(str, true, true, i);
    }

    private String addParamByEncode(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        return UrlUtil.addParam(str, str2, dx.a(str3));
    }

    public String addLocString(String str, boolean z, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!this.mIdentityContextImpl.getPrivacySwitch(this.mContext)) {
            return str;
        }
        String apInfo = getApInfo(z, i);
        if (!TextUtils.isEmpty(apInfo)) {
            return addParam(str, "apinfo", apInfo);
        }
        return str;
    }

    public String addParam(String str, String str2, String str3) {
        return UrlUtil.addParam(str, str2, str3);
    }

    public String addParamWithUrlEncode(String str, String str2, String str3) {
        return UrlUtil.addParam(str, str2, dx.a(str3));
    }

    public String replaceParam(String str, String str2, String str3) {
        HashSet hashSet = new HashSet();
        hashSet.add(str2);
        return addParam(UrlUtil.deleteParam(str, hashSet), str2, str3);
    }

    @SuppressLint({"ApplySharedPref"})
    private void addTnTrace(String str) {
        String string = this.mSettings.getString(KEY_TN_TRACE, "");
        if (!TextUtils.isEmpty(string)) {
            str = string + "_" + str;
        }
        SharedPreferences.Editor edit = this.mSettings.edit();
        edit.putString(KEY_TN_TRACE, str);
        edit.commit();
    }

    @SuppressLint({"ApplySharedPref"})
    private String getTn(Context context) {
        String string = this.mSettings.getString("tnconfig", "");
        boolean isEmpty = TextUtils.isEmpty(string);
        boolean isNeedReloadTN = TNRuntime.INSTANCE.getTNContext().isNeedReloadTN();
        if (!isEmpty && !isNeedReloadTN) {
            if (DEBUG) {
                Log.d(TAG, " load tn from local, tn = " + string);
            }
        } else {
            string = loadTn("tnconfig", string, isEmpty, isNeedReloadTN);
        }
        if (TextUtils.isEmpty(string)) {
            return "757b";
        }
        return string;
    }

    @SuppressLint({"BDThrowableCheck"})
    private void init(Context context) {
        this.mContext = context;
        this.mSettings = context.getSharedPreferences("identity", 0);
        this.mVersionName = getVersionName(context);
        initUAS();
        this.mCT = new CT();
        this.customOSParam = new vw();
        IBaiduIdentityContext baiduIdentityContext = BaiduIdentityRuntime.getBaiduIdentityContext();
        this.mIdentityContextImpl = baiduIdentityContext;
        if (DEBUG && baiduIdentityContext == null) {
            throw new RuntimeException("BaiduIdentityContext obtain Failed !!");
        }
    }

    private ww getDeviceInfoParam() {
        if (this.mDeviceInfoParam == null) {
            synchronized (this) {
                if (this.mDeviceInfoParam == null) {
                    this.mDeviceInfoParam = new ww();
                }
            }
        }
        return this.mDeviceInfoParam;
    }

    public static synchronized BaiduIdentityManager getInstance() {
        BaiduIdentityManager baiduIdentityManager;
        synchronized (BaiduIdentityManager.class) {
            if (sIdentityManager == null) {
                sIdentityManager = new BaiduIdentityManager(AppRuntime.getAppContext());
            }
            baiduIdentityManager = sIdentityManager;
        }
        return baiduIdentityManager;
    }

    private String getLightAppTsParam() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            return valueOf.substring(valueOf.length() - 7);
        } catch (Exception unused) {
            if (DEBUG) {
                Log.d(TAG, "format lightapp ts error.");
            }
            return "";
        }
    }

    @Deprecated
    public long getActiveSuccTime() {
        return BaiduActiveManager.getInstance().getActiveSuccTime();
    }

    @Deprecated
    public String getActiveTime() {
        return BaiduActiveManager.getInstance().getActiveTime();
    }

    @SuppressLint({"BDThrowableCheck", "HardwareIds"})
    public String getAndroidId() {
        String string = ApiReplaceUtil.Overload.getString(this.mContext.getContentResolver(), HttpRequest.ANDROID_ID);
        if (TextUtils.isEmpty(string)) {
            return "0";
        }
        return string;
    }

    @Deprecated
    public String getCurrentNetTypeId() {
        return new ax().a();
    }

    public String getDeviceInfo() {
        return getDeviceInfoParam().a();
    }

    public synchronized String getEnUA() {
        return this.mEnUa;
    }

    public String getEnUid() {
        return AppCuidManager.getInstance().getEnCuid();
    }

    public String getLastTn() {
        if (this.mLastTn == null) {
            this.mLastTn = getLastTn(this.mContext);
        }
        return this.mLastTn;
    }

    public String getLocationInfo() {
        String locationInfo = this.mIdentityContextImpl.getLocationInfo(this.mContext);
        if (TextUtils.isEmpty(locationInfo)) {
            return "0.000000,0.000000,---";
        }
        return locationInfo;
    }

    public String getManufacturer() {
        return getDeviceInfoParam().c();
    }

    public String getModel() {
        return getDeviceInfoParam().d();
    }

    public String getOSVersion() {
        return getDeviceInfoParam().e();
    }

    public String getOriginUserAgent() {
        return ex.f().g();
    }

    public String getOsBranch() {
        return this.mIdentityContextImpl.getOsBranch();
    }

    public String getSwanNativeVersionGroup() {
        if (SwanDataRuntime.getISwanData() != null) {
            return SwanDataRuntime.getISwanData().getSwanNativeVersionGroup();
        }
        return null;
    }

    public String getTn() {
        if (this.mTn == null) {
            this.mTn = getTn(this.mContext);
        }
        return this.mTn;
    }

    public String getTnTrace() {
        String string = this.mSettings.getString(KEY_TN_TRACE, "");
        if (TextUtils.isEmpty(string)) {
            return getLastTn();
        }
        return string;
    }

    public synchronized String getUA() {
        return this.mUa;
    }

    public String getUid() {
        return AppCuidManager.getInstance().getCuid();
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public String getZid() {
        return this.mIdentityContextImpl.getZid();
    }

    public synchronized void initUAS() {
        this.mUa = getUA(this.mContext);
        this.mEnUa = new String(Base64Encoder.B64Encode(this.mUa.getBytes()));
    }

    @Deprecated
    public boolean isActiveSucc() {
        return BaiduActiveManager.getInstance().isActiveSucc();
    }

    @Deprecated
    public void setCUIDCookie() {
        new CuidCookieSync().setCUIDCookie();
    }

    @SuppressLint({"ApplySharedPref"})
    private String getLastTn(Context context) {
        String string = this.mSettings.getString(KEY_LAST_TN, "");
        String apkTn = getApkTn(context);
        if (!(!TextUtils.equals(string, apkTn)) && !TextUtils.isEmpty(string)) {
            if (DEBUG) {
                Log.d(TAG, "load tn from local, lastTn = " + string);
                return string;
            }
            return string;
        }
        SharedPreferences.Editor edit = this.mSettings.edit();
        edit.putString(KEY_LAST_TN, apkTn);
        edit.commit();
        addTnTrace(apkTn);
        if (DEBUG) {
            Log.d(TAG, "load tn from apk, lastTn = " + apkTn);
        }
        return apkTn;
    }

    private String getUA(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append("android");
        stringBuffer.append("_");
        stringBuffer.append(this.mVersionName);
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        String stringBuffer2 = stringBuffer.toString();
        if (DEBUG) {
            Log.d(TAG, "ua = " + stringBuffer2);
        }
        return stringBuffer2;
    }

    public String addLocParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!this.mIdentityContextImpl.getPrivacySwitch(this.mContext)) {
            return str;
        }
        String apInfo = getApInfo(false, 6);
        if (!TextUtils.isEmpty(apInfo)) {
            HashSet hashSet = new HashSet();
            hashSet.add(LOCINFO_STRING);
            String deleteParam = UrlUtil.deleteParam(str, hashSet);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", System.currentTimeMillis());
                jSONObject.put("apinfo", apInfo);
                return addParam(deleteParam, LOCINFO_STRING, dx.a(jSONObject.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
                return deleteParam;
            }
        }
        return str;
    }

    public String addSid(String str) {
        ArrayList<h4> experimentInfoList = AbTestManager.getInstance().getExperimentInfoList();
        if (experimentInfoList != null && !experimentInfoList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (h4 h4Var : experimentInfoList) {
                sb.append(h4Var.c());
                sb.append("_");
                sb.append(h4Var.b());
                sb.append("-");
            }
            return addParam(str, "sid", sb.substring(0, sb.length() - 1));
        }
        return str;
    }

    public String processUrlInJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("mode");
                String string2 = jSONObject.getString("url");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    if (string.equals("search")) {
                        return processWebSearchUrl(string2, true);
                    }
                    if (!string.equals(FileUtils.SEARCHBOX_FOLDER)) {
                        return null;
                    }
                    return processUrl(string2);
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
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
        if (com.baidu.searchbox.util.BaiduIdentityManager.DEBUG == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduIdentityManager.TAG, "title: " + r8 + " size: " + r9);
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
        if (com.baidu.searchbox.util.BaiduIdentityManager.DEBUG != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e7, code lost:
        com.baidu.android.common.logging.Log.e(com.baidu.searchbox.util.BaiduIdentityManager.TAG, "getLocalPhotoInfo fail!" + r0.toString());
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

    public String toString() {
        return "BaiduIdentityManager [mUid=" + AppCuidManager.getInstance().getCuid() + ", mEnUid=" + AppCuidManager.getInstance().getEnCuid() + ", mUa=" + this.mUa + ", mEnUa=" + this.mEnUa + ", mTn=" + getTn() + ", mLastTn=" + getLastTn() + ", mModel=" + getDeviceInfoParam().d() + ", mManufacturer=" + getDeviceInfoParam().c() + ", mOSVersion=" + getDeviceInfoParam().e() + ", mDeviceInfo=" + getDeviceInfoParam().a() + ", mEnDeviceInfo=" + getDeviceInfoParam().b() + ", mSettings=" + this.mSettings + ", mVersionName=" + this.mVersionName + ", mCtv=" + this.mCT.getVersion() + ", mProcessedUa=" + this.mProcessedUa + PreferencesUtil.RIGHT_MOUNT;
    }

    private String loadTn(String str, String str2, boolean z, boolean z2) {
        String oEMChannel = this.mIdentityContextImpl.getOEMChannel(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(oEMChannel)) {
            if (DEBUG && z2) {
                Log.d(TAG, "load tn from new clone device, tn = " + oEMChannel);
            }
            str2 = oEMChannel;
        } else if (z) {
            str2 = getLastTn();
        }
        SharedPreferences.Editor edit = this.mSettings.edit();
        edit.putString(str, str2);
        edit.commit();
        return str2;
    }

    private String processUrl(String str, boolean z, boolean z2, int i) {
        String b;
        String c;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String addParamByEncode;
        String f;
        String str7;
        String a = dx.a(getEnUA());
        String str8 = null;
        String addKey2Cen = addKey2Cen(null, "ua");
        ww deviceInfoParam = getDeviceInfoParam();
        String addServiceParam = addServiceParam(str, PARAM_SERVICE);
        if (this.mIdentityContextImpl.isAgreePrivacy()) {
            String a2 = dx.a(getEnUid());
            addKey2Cen = addKey2Cen(addKey2Cen, "uid");
            addServiceParam = addParam(addServiceParam, "uid", a2);
        }
        String addFromParam = addFromParam(addServiceParam);
        String appName = AppIdentityManager.getInstance().getAppName();
        ax axVar = new ax();
        boolean z3 = true;
        axVar.g(true);
        if (i == 1) {
            boolean z4 = false;
            if (deviceInfoParam.j()) {
                String b2 = deviceInfoParam.b();
                addKey2Cen = addKey2Cen(addKey2Cen, "ut");
                b = b2;
                f = null;
            } else {
                b = null;
                f = deviceInfoParam.f();
                z4 = true;
            }
            if (axVar.e()) {
                str4 = null;
                boolean z5 = z4;
                c = axVar.c();
                z3 = z5;
            } else {
                str4 = String.valueOf(axVar.d());
                c = null;
            }
            if (z3) {
                if (TextUtils.isEmpty(b)) {
                    str2 = crcSign(deviceInfoParam.a(), axVar.b());
                } else {
                    str2 = crcSign(deviceInfoParam.b(), axVar.c());
                }
                str7 = String.valueOf(i);
            } else {
                str2 = null;
                str7 = null;
            }
            if (uw.b().e()) {
                if (this.customOSParam.b()) {
                    str7 = String.valueOf(i);
                } else {
                    str8 = this.customOSParam.a();
                }
            }
            String str9 = str7;
            str3 = str8;
            str5 = addKey2Cen;
            str6 = str9;
            str8 = f;
        } else {
            b = deviceInfoParam.b();
            c = axVar.c();
            String addKey2Cen2 = addKey2Cen(addKey2Cen, "ut");
            if (uw.b().e()) {
                str4 = null;
                str5 = addKey2Cen2;
                str3 = this.customOSParam.a();
                str6 = null;
                str2 = null;
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = addKey2Cen2;
                str6 = null;
            }
        }
        String addParam = addParam(addCfromParam(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addPackageNameParam(addParamByEncode(addParam(addParam(addParamByEncode(addParam(addFromParam, "ua", a), "ut", b), PARAM_OSNAME, VALUE_OSNAME), PARAM_OSBRANCH, getOsBranch()), PARAM_BRNACH_NAME, appName)), "p_sv", str8), "mps", str2), "mpv", str6), "p_nw", str4), "network", c)), PARAM_CTV, this.mCT.getVersion());
        if (!TextUtils.isEmpty(str5) && !this.mCT.isDefaultCtv()) {
            addParam = addParam(addParam, PARAM_CEN, str5);
        }
        String addParam2 = addParam(addParam, "typeid", this.mIdentityContextImpl.getSearchBoxTypeId(this.mContext));
        if (this.mIdentityContextImpl.isAgreePrivacy()) {
            String passUid = this.mIdentityContextImpl.getPassUid(this.mContext);
            if (!TextUtils.isEmpty(passUid)) {
                addParam2 = addParam(addParam2, "puid", dx.a(new String(Base64Encoder.B64Encode(passUid.getBytes()))));
            }
        }
        if (z2) {
            addParam2 = addSid(addParam2);
        }
        String addBDVC = addBDVC(addParam2);
        if (this.mIdentityContextImpl.isAgreePrivacy()) {
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = getC3Aid();
            }
            if (!TextUtils.isEmpty(this.mC3Aid)) {
                addBDVC = addParam(addBDVC, "c3_aid", dx.a(this.mC3Aid));
            }
            addParamByEncode = addZid(addBDVC);
        } else {
            addParamByEncode = addParamByEncode(addBDVC, "iid", this.mIdentityContextImpl.getIid());
        }
        String addParam3 = addParam(addParamByEncode, "matrixstyle", this.mIdentityContextImpl.getMatrixstyle());
        String appMode = this.mIdentityContextImpl.getAppMode();
        if (!TextUtils.isEmpty(appMode)) {
            addParam3 = addParam(addParam3, "cmode", appMode);
        }
        return this.mIdentityContextImpl.processUrlExternal(addParamByEncode(addParam3, "bdos", str3), z);
    }

    private void saveApinfoToFileForDebug(String str) {
        File file;
        if (!DEBUG) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    file = new File(this.mContext.getFilesDir(), "apinfo.txt");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            if (file.length() > Config.FULL_TRACE_LOG_LIMIT) {
                file.delete();
                return;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
                fileOutputStream2.write((simpleDateFormat.format(date) + ", apinfo: " + str).getBytes());
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public String addPuParam(String str, String str2, String str3) {
        String urlField = UrlUtil.getUrlField(str, PARAM_PU);
        if (TextUtils.isEmpty(urlField)) {
            return addParam(str, PARAM_PU, Uri.encode(str2 + "@" + str3));
        }
        String str4 = str2 + "@";
        if (urlField.indexOf(Uri.encode(str4)) < 0 && urlField.indexOf(str4) < 0) {
            String str5 = "," + str4 + str3;
            return str.replace("pu=" + urlField, "pu=" + urlField + Uri.encode(str5));
        }
        return str;
    }

    public String appendParam(String str, int i, boolean z, boolean z2) {
        if (uw.b().h()) {
            return processUrl(str, z, z2, i);
        }
        return processUrl(str, z, z2, 0);
    }

    public String getApInfo(boolean z, int i, String str) {
        String str2;
        if (!this.mIdentityContextImpl.isDataFlowPopDialog(this.mContext)) {
            if (i < 6) {
                i = 6;
            } else if (i > 15) {
                i = 15;
            }
            str2 = this.mIdentityContextImpl.getLocString(this.mContext, i);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (z) {
                return "0";
            }
        } else if (!TextUtils.isEmpty(str)) {
            try {
                str2 = URLEncoder.encode(str2, str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            saveApinfoToFileForDebug(str2);
        }
        return str2;
    }

    public String getC3Aid() {
        if (this.mContext != null && TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = BlcSharedPrefsWrapper.getInstance().getString("cthreekey", "");
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = cy.f(this.mContext.getApplicationContext()).c();
                if (!TextUtils.isEmpty(this.mC3Aid)) {
                    BlcSharedPrefsWrapper.getInstance().putString("cthreekey", this.mC3Aid);
                }
            }
        }
        return this.mC3Aid;
    }

    @SuppressLint({"HardwareIds"})
    public String getEnAndroidId() {
        if (this.mEnAndroidId == null) {
            synchronized (this) {
                if (this.mEnAndroidId == null) {
                    String string = ApiReplaceUtil.Overload.getString(this.mContext.getContentResolver(), HttpRequest.ANDROID_ID);
                    this.mAndroidId = string;
                    if (TextUtils.isEmpty(string)) {
                        this.mAndroidId = "0";
                    }
                    this.mEnAndroidId = new String(Base64Encoder.B64Encode(this.mAndroidId.getBytes()));
                }
            }
        }
        return this.mEnAndroidId;
    }

    @SuppressLint({"WifiManagerPotentialLeak", "HardwareIds"})
    @Deprecated
    public String getWifiInfo() {
        String str;
        try {
            str = ApiReplaceUtil.getMacAddress(((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo());
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getWifiInfo fail!" + e.toString());
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
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

    public String getSid() {
        ArrayList<h4> experimentInfoList = AbTestManager.getInstance().getExperimentInfoList();
        if (experimentInfoList != null && !experimentInfoList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (h4 h4Var : experimentInfoList) {
                sb.append(h4Var.c());
                sb.append("_");
                sb.append(h4Var.b());
                sb.append("-");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

    public String processUrlWithParams(String str, Map<String, String> map) {
        String processUrl = processUrl(str, true, true, 0);
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    processUrl = addParam(processUrl, str2, map.get(str2));
                }
            }
        }
        return processUrl;
    }

    public String processWebSearchUrl(String str, int i, boolean z) {
        ax axVar;
        String a;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String f;
        boolean z2;
        String str7;
        String a2 = dx.a(getEnUid());
        String str8 = null;
        String addKey2Cen = addKey2Cen(null, "cuid");
        String a3 = dx.a(getEnUA());
        String addKey2Cen2 = addKey2Cen(addKey2Cen, PARAM_CUA);
        String appName = AppIdentityManager.getInstance().getAppName();
        boolean z3 = true;
        if (z) {
            axVar = new ax();
            axVar.g(true);
        } else {
            axVar = null;
        }
        ww deviceInfoParam = getDeviceInfoParam();
        if (i == 1) {
            if (deviceInfoParam.j()) {
                a = dx.a(deviceInfoParam.b());
                addKey2Cen2 = addKey2Cen(addKey2Cen2, PARAM_CUT);
                f = null;
                z2 = false;
            } else {
                f = deviceInfoParam.f();
                z2 = true;
                a = null;
            }
            if (axVar != null) {
                if (axVar.e()) {
                    str7 = axVar.c();
                    z3 = z2;
                    str4 = null;
                } else {
                    str4 = String.valueOf(axVar.d());
                    str7 = null;
                }
            } else {
                str7 = null;
                z3 = z2;
                str4 = null;
            }
            if (z3) {
                str8 = String.valueOf(i);
            }
            str2 = str;
            str3 = str7;
            str5 = addKey2Cen2;
            str6 = str8;
            str8 = f;
        } else {
            a = dx.a(deviceInfoParam.b());
            String addKey2Cen3 = addKey2Cen(addKey2Cen2, PARAM_CUT);
            if (axVar != null) {
                str3 = axVar.c();
                str2 = str;
                str4 = null;
            } else {
                str2 = str;
                str3 = null;
                str4 = null;
            }
            str5 = addKey2Cen3;
            str6 = str4;
        }
        String addPuParam = addPuParam(addPuParam(str2, "cuid", a2), PARAM_CUA, a3);
        if (a != null) {
            addPuParam = addPuParam(addPuParam, PARAM_CUT, a);
        }
        String addPackageNameParam = addPackageNameParam(addFromParam(addPuParam(addPuParam(addPuParam(addPuParam, PARAM_OSNAME, VALUE_OSNAME), PARAM_CTV, this.mCT.getVersion()), "cfrom", getLastTn())));
        if (!this.mCT.isDefaultCtv()) {
            addPackageNameParam = addPuParam(addPackageNameParam, PARAM_CEN, str5);
        }
        if (TextUtils.isEmpty(this.mC3Aid)) {
            this.mC3Aid = getC3Aid();
        }
        if (!TextUtils.isEmpty(this.mC3Aid)) {
            addPackageNameParam = addPuParam(addPackageNameParam, "c3_aid", dx.a(this.mC3Aid));
        }
        String processUrlExternal = this.mIdentityContextImpl.processUrlExternal(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addPackageNameParam, "p_sv", str8), "mpv", str6), "p_nw", str4), "network", str3), PARAM_BRNACH_NAME, appName), z);
        if (DEBUG) {
            Log.d(TAG, "url: " + processUrlExternal);
        }
        return processUrlExternal;
    }
}
