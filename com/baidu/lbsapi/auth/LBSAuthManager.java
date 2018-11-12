package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.lbsapi.auth.HttpAsyncTask;
import com.baidu.lbsapi.auth.HttpSyncTask;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.coremedia.iso.boxes.AuthorBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes4.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.22";
    private static Context a;
    private static LooperThread d = null;
    private static int e = 0;
    private static Hashtable<String, LBSAuthManagerListener> f = new Hashtable<>();
    private static LBSAuthManager g;
    private HttpAsyncTask b = null;
    private HttpSyncTask c = null;
    private final Handler h = new Handler(Looper.getMainLooper()) { // from class: com.baidu.lbsapi.auth.LBSAuthManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (BLog.a) {
                BLog.d("handleMessage !!");
            }
            LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.f.get(message.getData().getString("listenerKey"));
            if (BLog.a) {
                BLog.d("handleMessage listener = " + lBSAuthManagerListener);
            }
            if (lBSAuthManagerListener != null) {
                lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
            }
        }
    };

    private LBSAuthManager(Context context) {
        a = context;
        if (d != null && !d.isAlive()) {
            d = null;
        }
        BLog.n("BaiduApiAuth SDK Version:1.0.22");
        d();
    }

    private int a(String str) {
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i = jSONObject.getInt("status");
            if (jSONObject.has("current") && i == 0) {
                long j = jSONObject.getLong("current");
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - j) / 3600000.0d >= 24.0d) {
                    i = 601;
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AiAppDateTimeUtil.DATE_FORMAT);
                    if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                        i = 601;
                    }
                }
            }
            if (jSONObject.has("current") && i == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                    return CODE_UNAUTHENTICATE;
                }
            }
            return i;
        } catch (JSONException e2) {
            int i2 = i;
            e2.printStackTrace();
            return i2;
        }
    }

    private String a(int i) throws IOException {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/" + i + "/cmdline"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (FileNotFoundException e2) {
                    bufferedReader = null;
                } catch (IOException e3) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (FileNotFoundException e4) {
                bufferedReader = null;
                inputStreamReader = null;
            } catch (IOException e5) {
                bufferedReader = null;
                inputStreamReader = null;
            } catch (Throwable th3) {
                inputStreamReader = null;
                th = th3;
                bufferedReader = null;
            }
        } catch (FileNotFoundException e6) {
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (IOException e7) {
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
            th = th4;
        }
        try {
            str = bufferedReader.readLine();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (FileNotFoundException e8) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (IOException e9) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str;
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        String str = null;
        try {
            str = a(myPid);
        } catch (IOException e2) {
        }
        return str == null ? a.getPackageName() : str;
    }

    private String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        LBSAuthManagerListener lBSAuthManagerListener;
        String str2 = "";
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            LBSAuthManagerListener lBSAuthManagerListener2 = f.get(str);
            if (lBSAuthManagerListener2 != null) {
                lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
            }
        }
        if (applicationInfo.metaData == null) {
            LBSAuthManagerListener lBSAuthManagerListener3 = f.get(str);
            if (lBSAuthManagerListener3 != null) {
                lBSAuthManagerListener3.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
            }
            return "";
        }
        str2 = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        if ((str2 == null || str2.equals("")) && (lBSAuthManagerListener = f.get(str)) != null) {
            lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        int i = -1;
        synchronized (this) {
            if (str == null) {
                str = e();
            }
            Message obtainMessage = this.h.obtainMessage();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
                if (!jSONObject.has("current")) {
                    jSONObject.put("current", System.currentTimeMillis());
                }
                c(jSONObject.toString());
                if (jSONObject.has("current")) {
                    jSONObject.remove("current");
                }
                i = jSONObject.getInt("status");
                obtainMessage.what = i;
                obtainMessage.obj = jSONObject.toString();
                Bundle bundle = new Bundle();
                bundle.putString("listenerKey", str2);
                obtainMessage.setData(bundle);
                this.h.sendMessage(obtainMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
                obtainMessage.what = i;
                obtainMessage.obj = new JSONObject();
                Bundle bundle2 = new Bundle();
                bundle2.putString("listenerKey", str2);
                obtainMessage.setData(bundle2);
                this.h.sendMessage(obtainMessage);
            }
            if (d != null) {
                d.looperRun();
            }
            e--;
            if (BLog.a) {
                BLog.d("httpRequest called mAuthCounter-- = " + e);
            }
            if (e == 0 && d != null) {
                d.quit();
                d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, final String str2) {
        String a2 = a(a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        BLog.d("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", NetworkDef.DataType.JSON);
        hashMap.put("ak", a2);
        BLog.d("ak:" + a2);
        hashMap.put("mcode", Cert.getAuthString(a));
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String str3 = "";
        try {
            str3 = CommonParam.getCUID(a);
        } catch (Exception e2) {
        }
        BLog.d("cuid:" + str3);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put("version", VERSION);
        String str4 = "";
        try {
            str4 = Cert.a(a);
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        String str5 = "";
        try {
            str5 = Cert.a();
        } catch (Exception e4) {
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str5);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        this.b = new HttpAsyncTask(a);
        this.b.postWithHttps(hashMap, new HttpAsyncTask.IHttpConnectionCallback<String>() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.lbsapi.auth.HttpAsyncTask.IHttpConnectionCallback
            public void httpRequest(String str6) {
                LBSAuthManager.this.a(str6, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, final String str2) {
        String a2 = a(a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", NetworkDef.DataType.JSON);
        hashMap.put("ak", a2);
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String str3 = "";
        try {
            str3 = CommonParam.getCUID(a);
        } catch (Exception e2) {
        }
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put("version", VERSION);
        String str4 = "";
        try {
            str4 = Cert.a(a);
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        String str5 = "";
        try {
            str5 = Cert.a();
        } catch (Exception e4) {
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, str5);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        this.c = new HttpSyncTask(a);
        this.c.postWithHttps(hashMap, strArr, new HttpSyncTask.IHttpConnectionCallback<String>() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.lbsapi.auth.HttpSyncTask.IHttpConnectionCallback
            public void httpRequest(String str6) {
                LBSAuthManager.this.a(str6, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(a, str);
        try {
            jSONObject = new JSONObject(e());
        } catch (JSONException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (jSONObject.has("ak")) {
            str2 = jSONObject.getString("ak");
            return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
        }
        return true;
    }

    private void c(String str) {
        a.getSharedPreferences("authStatus_" + a(a), 0).edit().putString("status", str).commit();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (d == null) {
                d = new LooperThread(AuthorBox.TYPE);
                d.start();
                while (d.a == null) {
                    try {
                        if (BLog.a) {
                            BLog.d("wait for create auth thread.");
                        }
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String e() {
        return a.getSharedPreferences("authStatus_" + a(a), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (g == null) {
            synchronized (LBSAuthManager.class) {
                if (g == null) {
                    g = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            a = context;
        } else if (BLog.a) {
            BLog.e("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return g;
    }

    public int authenticate(final boolean z, final String str, final Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        final int i;
        synchronized (LBSAuthManager.class) {
            final String str2 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f.put(str2, lBSAuthManagerListener);
            }
            String a2 = a(a, str2);
            if (a2 == null || a2.equals("")) {
                i = 101;
            } else {
                e++;
                if (BLog.a) {
                    BLog.d(" mAuthCounter  ++ = " + e);
                }
                String e2 = e();
                if (BLog.a) {
                    BLog.d("getAuthMessage from cache:" + e2);
                }
                i = a(e2);
                if (i == 601) {
                    try {
                        c(new JSONObject().put("status", CODE_AUTHENTICATING).toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                d();
                if (d == null || d.a == null) {
                    i = -1;
                } else {
                    if (BLog.a) {
                        BLog.d("mThreadLooper.mHandler = " + d.a);
                    }
                    d.a.post(new Runnable() { // from class: com.baidu.lbsapi.auth.LBSAuthManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BLog.a) {
                                BLog.d("status = " + i + "; forced = " + z + "checkAK = " + LBSAuthManager.this.b(str2));
                            }
                            if (i != 601 && !z && i != -1 && !LBSAuthManager.this.b(str2)) {
                                if (602 != i) {
                                    if (BLog.a) {
                                        BLog.d("authenticate else  ");
                                    }
                                    LBSAuthManager.this.a((String) null, str2);
                                    return;
                                }
                                if (BLog.a) {
                                    BLog.d("authenticate wait  ");
                                }
                                if (LBSAuthManager.d != null) {
                                    LBSAuthManager.d.looperWait();
                                }
                                LBSAuthManager.this.a((String) null, str2);
                                return;
                            }
                            if (BLog.a) {
                                BLog.d("authenticate sendAuthRequest");
                            }
                            String[] authStrings = Cert.getAuthStrings(LBSAuthManager.a);
                            if (BLog.a) {
                                BLog.d("authStrings.length:" + authStrings.length);
                            }
                            if (authStrings == null || authStrings.length <= 1) {
                                LBSAuthManager.this.a(z, str, hashtable, str2);
                                return;
                            }
                            if (BLog.a) {
                                BLog.d("more sha1 auth");
                            }
                            LBSAuthManager.this.a(z, str, hashtable, authStrings, str2);
                        }
                    });
                }
            }
        }
        return i;
    }

    public String getCUID() {
        if (a == null) {
            return "";
        }
        try {
            return CommonParam.getCUID(a);
        } catch (Exception e2) {
            if (BLog.a) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }

    public String getKey() {
        if (a == null) {
            return "";
        }
        try {
            return getPublicKey(a);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        return a == null ? "" : Cert.getAuthString(a);
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
