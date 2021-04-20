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
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
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
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.22";

    /* renamed from: a  reason: collision with root package name */
    public static Context f6349a;

    /* renamed from: d  reason: collision with root package name */
    public static m f6350d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6351e;

    /* renamed from: f  reason: collision with root package name */
    public static Hashtable<String, LBSAuthManagerListener> f6352f = new Hashtable<>();

    /* renamed from: g  reason: collision with root package name */
    public static LBSAuthManager f6353g;

    /* renamed from: b  reason: collision with root package name */
    public c f6354b = null;

    /* renamed from: c  reason: collision with root package name */
    public e f6355c = null;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f6356h = new i(this, Looper.getMainLooper());

    public LBSAuthManager(Context context) {
        f6349a = context;
        m mVar = f6350d;
        if (mVar != null && !mVar.isAlive()) {
            f6350d = null;
        }
        a.b("BaiduApiAuth SDK Version:1.0.22");
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
            if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT) && i == 0) {
                long j = jSONObject.getLong(ProgressInfo.JSON_KEY_CURRENT);
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - j) / 3600000.0d < 24.0d) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                    }
                }
                i = 601;
            }
            if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT) && i == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong(ProgressInfo.JSON_KEY_CURRENT)) / 1000 > 180.0d) {
                    return 601;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x003a */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/" + i + "/cmdline"));
        } catch (FileNotFoundException unused) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (IOException unused2) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (Throwable th2) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (FileNotFoundException unused3) {
                bufferedReader3 = 0;
            } catch (IOException unused4) {
                bufferedReader2 = 0;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (FileNotFoundException unused5) {
            inputStreamReader = null;
            bufferedReader3 = inputStreamReader;
            if (bufferedReader3 != 0) {
                bufferedReader3.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (IOException unused6) {
            inputStreamReader = null;
            bufferedReader2 = inputStreamReader;
            if (bufferedReader2 != 0) {
                bufferedReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamReader = null;
        }
        try {
            str = bufferedReader.readLine();
            bufferedReader.close();
            inputStreamReader.close();
        } catch (FileNotFoundException unused7) {
            bufferedReader3 = bufferedReader;
            if (bufferedReader3 != 0) {
            }
            if (inputStreamReader != null) {
            }
        } catch (IOException unused8) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != 0) {
            }
            if (inputStreamReader != null) {
            }
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
        fileInputStream.close();
        return str;
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
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
        } catch (IOException unused) {
        }
        return str != null ? str : f6349a.getPackageName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r6.equals("") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context, String str) {
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                LBSAuthManagerListener lBSAuthManagerListener = f6352f.get(str);
                if (lBSAuthManagerListener != null) {
                    lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
                }
            } else {
                String string = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
                if (string != null) {
                    try {
                    } catch (PackageManager.NameNotFoundException unused) {
                        str2 = string;
                        LBSAuthManagerListener lBSAuthManagerListener2 = f6352f.get(str);
                        if (lBSAuthManagerListener2 != null) {
                            lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                        }
                        return str2;
                    }
                }
                LBSAuthManagerListener lBSAuthManagerListener3 = f6352f.get(str);
                if (lBSAuthManagerListener3 != null) {
                    lBSAuthManagerListener3.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                }
                str2 = string;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        if (str == null) {
            str = e();
        }
        Message obtainMessage = this.f6356h.obtainMessage();
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has(ProgressInfo.JSON_KEY_CURRENT)) {
                jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, System.currentTimeMillis());
            }
            c(jSONObject.toString());
            if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT)) {
                jSONObject.remove(ProgressInfo.JSON_KEY_CURRENT);
            }
            i = jSONObject.getInt("status");
            obtainMessage.what = i;
            obtainMessage.obj = jSONObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.f6356h.sendMessage(obtainMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
            obtainMessage.what = i;
            obtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            obtainMessage.setData(bundle2);
            this.f6356h.sendMessage(obtainMessage);
        }
        if (f6350d != null) {
            f6350d.c();
        }
        f6351e--;
        if (a.f6357a) {
            a.a("httpRequest called mAuthCounter-- = " + f6351e);
        }
        if (f6351e == 0 && f6350d != null) {
            f6350d.a();
            f6350d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String str2) {
        String str3;
        String str4;
        String str5;
        String a2 = a(f6349a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        a.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        hashMap.put(ContentUtil.RESULT_KEY_AK, a2);
        a.a("ak:" + a2);
        hashMap.put("mcode", b.a(f6349a));
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
        try {
            str3 = CommonParam.a(f6349a);
        } catch (Exception unused) {
            str3 = "";
        }
        a.a("cuid:" + str3);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", f6349a.getPackageName());
        hashMap.put("version", VERSION);
        try {
            str4 = b.c(f6349a);
        } catch (Exception unused2) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        try {
            str5 = b.a();
        } catch (Exception unused3) {
            str5 = "";
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, str5);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        c cVar = new c(f6349a);
        this.f6354b = cVar;
        cVar.a(hashMap, new k(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2) {
        String str3;
        String str4;
        String str5;
        String a2 = a(f6349a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        hashMap.put(ContentUtil.RESULT_KEY_AK, a2);
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
        try {
            str3 = CommonParam.a(f6349a);
        } catch (Exception unused) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", f6349a.getPackageName());
        hashMap.put("version", VERSION);
        try {
            str4 = b.c(f6349a);
        } catch (Exception unused2) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        try {
            str5 = b.a();
        } catch (Exception unused3) {
            str5 = "";
        }
        if (TextUtils.isEmpty(str5)) {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, "");
        } else {
            hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, str5);
        }
        if (z) {
            hashMap.put("force", z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        e eVar = new e(f6349a);
        this.f6355c = eVar;
        eVar.a(hashMap, strArr, new l(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(f6349a, str);
        try {
            jSONObject = new JSONObject(e());
        } catch (JSONException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (jSONObject.has(ContentUtil.RESULT_KEY_AK)) {
            str2 = jSONObject.getString(ContentUtil.RESULT_KEY_AK);
            return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
        }
        return true;
    }

    private void c(String str) {
        Context context = f6349a;
        context.getSharedPreferences("authStatus_" + a(f6349a), 0).edit().putString("status", str).commit();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (f6350d == null) {
                m mVar = new m("auth");
                f6350d = mVar;
                mVar.start();
                while (f6350d.f6383a == null) {
                    try {
                        if (a.f6357a) {
                            a.a("wait for create auth thread.");
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
        Context context = f6349a;
        return context.getSharedPreferences("authStatus_" + a(f6349a), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (f6353g == null) {
            synchronized (LBSAuthManager.class) {
                if (f6353g == null) {
                    f6353g = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            f6349a = context;
        } else if (a.f6357a) {
            a.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return f6353g;
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            String str2 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                f6352f.put(str2, lBSAuthManagerListener);
            }
            String a2 = a(f6349a, str2);
            if (a2 != null && !a2.equals("")) {
                f6351e++;
                if (a.f6357a) {
                    a.a(" mAuthCounter  ++ = " + f6351e);
                }
                String e2 = e();
                if (a.f6357a) {
                    a.a("getAuthMessage from cache:" + e2);
                }
                int a3 = a(e2);
                if (a3 == 601) {
                    try {
                        c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                d();
                if (f6350d != null && f6350d.f6383a != null) {
                    if (a.f6357a) {
                        a.a("mThreadLooper.mHandler = " + f6350d.f6383a);
                    }
                    f6350d.f6383a.post(new j(this, a3, z, str2, str, hashtable));
                    return a3;
                }
                return -1;
            }
            return 101;
        }
    }

    public String getCUID() {
        Context context = f6349a;
        if (context == null) {
            return "";
        }
        try {
            return CommonParam.a(context);
        } catch (Exception e2) {
            if (a.f6357a) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }

    public String getKey() {
        Context context = f6349a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f6349a;
        return context == null ? "" : b.a(context);
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
