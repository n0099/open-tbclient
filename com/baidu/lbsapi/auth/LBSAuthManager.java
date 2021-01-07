package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.coremedia.iso.boxes.AuthorBox;
import com.kwai.video.player.KsMediaMeta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.24";

    /* renamed from: a  reason: collision with root package name */
    private static Context f2531a;
    private static m d = null;
    private static int e = 0;
    private static Hashtable<String, LBSAuthManagerListener> f = new Hashtable<>();
    private static LBSAuthManager g;

    /* renamed from: b  reason: collision with root package name */
    private c f2532b = null;
    private e c = null;
    private boolean h = false;
    private final Handler i = new i(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        f2531a = context;
        if (d != null && !d.isAlive()) {
            d = null;
        }
        a.b("BaiduApiAuth SDK Version:1.0.24");
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str) {
        JSONException e2;
        int i;
        JSONObject jSONObject;
        int i2;
        int i3 = -1;
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i3 = jSONObject.getInt("status");
        } catch (JSONException e3) {
            e2 = e3;
            i = i3;
        }
        try {
            if (jSONObject.has("current") && i3 == 0) {
                long j = jSONObject.getLong("current");
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - j) / 3600000.0d >= 24.0d) {
                    i2 = 601;
                } else if (this.h) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                        i2 = 601;
                    }
                }
                if (jSONObject.has("current") && i2 == 602) {
                    if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                        return 601;
                    }
                }
                return i2;
            }
            if (jSONObject.has("current")) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                }
            }
            return i2;
        } catch (JSONException e4) {
            e2 = e4;
            i = i2;
            e2.printStackTrace();
            return i;
        }
        i2 = i3;
    }

    private String a(int i) throws IOException {
        Throwable th;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        String str = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/" + i + "/cmdline"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        str = bufferedReader2.readLine();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (FileNotFoundException e2) {
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str;
                    } catch (IOException e3) {
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
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
                } catch (FileNotFoundException e4) {
                    bufferedReader2 = null;
                } catch (IOException e5) {
                    bufferedReader2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (FileNotFoundException e6) {
                bufferedReader2 = null;
                inputStreamReader = null;
            } catch (IOException e7) {
                bufferedReader2 = null;
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (FileNotFoundException e8) {
            bufferedReader2 = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (IOException e9) {
            bufferedReader2 = null;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
        }
        return str;
    }

    private String a(Context context) {
        String str = null;
        try {
            str = a(Process.myPid());
        } catch (IOException e2) {
        }
        return str != null ? str : f2531a.getPackageName();
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
            Message obtainMessage = this.i.obtainMessage();
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
                this.i.sendMessage(obtainMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
                obtainMessage.what = i;
                obtainMessage.obj = new JSONObject();
                Bundle bundle2 = new Bundle();
                bundle2.putString("listenerKey", str2);
                obtainMessage.setData(bundle2);
                this.i.sendMessage(obtainMessage);
            }
            if (d != null) {
                d.c();
            }
            e--;
            a.a("httpRequest called mAuthCounter-- = " + e);
            if (e == 0 && d != null) {
                d.a();
                d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String str2) {
        String a2 = a(f2531a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        a.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        hashMap.put("ak", a2);
        a.a("ak:" + a2);
        hashMap.put("mcode", b.a(f2531a));
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
            str3 = com.baidu.a.a.a.a.a.a(f2531a);
        } catch (Exception e2) {
            a.a("get cuid failed");
            e2.printStackTrace();
        }
        a.a("cuid:" + str3);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", f2531a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        String str4 = "";
        try {
            str4 = b.a();
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, str4);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        this.f2532b = new c(f2531a);
        this.f2532b.a(hashMap, new k(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2) {
        String a2 = a(f2531a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
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
            str3 = com.baidu.a.a.a.a.a.a(f2531a);
        } catch (Exception e2) {
        }
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", f2531a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        String str4 = "";
        try {
            str4 = b.a();
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, str4);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        this.c = new e(f2531a);
        this.c.a(hashMap, strArr, new l(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(f2531a, str);
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
        f2531a.getSharedPreferences("authStatus_" + a(f2531a), 0).edit().putString("status", str).commit();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (d == null) {
                d = new m(AuthorBox.TYPE);
                d.start();
                while (d.f2551a == null) {
                    try {
                        a.a("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String e() {
        return f2531a.getSharedPreferences("authStatus_" + a(f2531a), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (g == null) {
            synchronized (LBSAuthManager.class) {
                if (g == null) {
                    g = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            f2531a = context;
        } else if (a.f2533a) {
            a.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return g;
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        int i;
        synchronized (LBSAuthManager.class) {
            if (hashtable != null) {
                String str2 = hashtable.get("zero_auth");
                if (str2 == null) {
                    this.h = false;
                } else {
                    this.h = Integer.valueOf(str2).intValue() == 1;
                }
            } else {
                this.h = false;
            }
            String str3 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f.put(str3, lBSAuthManagerListener);
            }
            String a2 = a(f2531a, str3);
            if (a2 == null || a2.equals("")) {
                i = 101;
            } else {
                e++;
                a.a(" mAuthCounter  ++ = " + e);
                String e2 = e();
                a.a("getAuthMessage from cache:" + e2);
                i = a(e2);
                if (i == 601) {
                    try {
                        c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                d();
                if (d == null || d.f2551a == null) {
                    i = -1;
                } else {
                    a.a("mThreadLooper.mHandler = " + d.f2551a);
                    d.f2551a.post(new j(this, i, z, str3, str, hashtable));
                }
            }
        }
        return i;
    }

    public String getCUID() {
        if (f2531a == null) {
            return "";
        }
        try {
            return com.baidu.a.a.a.a.a.a(f2531a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getKey() {
        if (f2531a == null) {
            return "";
        }
        try {
            return getPublicKey(f2531a);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        return f2531a == null ? "" : b.a(f2531a);
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
