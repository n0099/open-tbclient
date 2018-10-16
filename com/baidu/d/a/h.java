package com.baidu.d.a;

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
import com.baidu.d.a.e;
import com.baidu.d.a.f;
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
/* loaded from: classes6.dex */
public class h {
    private static Context a;
    private static h acK;
    private e acG = null;
    private f acH = null;
    private final Handler h = new Handler(Looper.getMainLooper()) { // from class: com.baidu.d.a.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.a) {
                b.a("handleMessage !!");
            }
            a aVar = (a) h.acJ.get(message.getData().getString("listenerKey"));
            if (b.a) {
                b.a("handleMessage listener = " + aVar);
            }
            if (aVar != null) {
                aVar.g(message.what, message.obj.toString());
            }
        }
    };
    private static i acI = null;
    private static int e = 0;
    private static Hashtable<String, a> acJ = new Hashtable<>();

    private h(Context context) {
        a = context;
        if (acI != null && !acI.isAlive()) {
            acI = null;
        }
        b.b("BaiduApiAuth SDK Version:1.0.20");
        e();
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
                    return 601;
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

    private String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        a aVar;
        String str2 = "";
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            a aVar2 = acJ.get(str);
            if (aVar2 != null) {
                aVar2.g(101, d.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
            }
        }
        if (applicationInfo.metaData == null) {
            a aVar3 = acJ.get(str);
            if (aVar3 != null) {
                aVar3.g(101, d.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
            }
            return "";
        }
        str2 = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        if ((str2 == null || str2.equals("")) && (aVar = acJ.get(str)) != null) {
            aVar.g(101, d.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        int i = -1;
        synchronized (this) {
            if (str == null) {
                str = f();
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
            acI.c();
            e--;
            if (b.a) {
                b.a("httpRequest called mAuthCounter-- = " + e);
            }
            if (e == 0) {
                acI.a();
                if (acI != null) {
                    acI = null;
                }
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
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", NetworkDef.DataType.JSON);
        hashMap.put("ak", a2);
        b.a("ak:" + a2);
        hashMap.put("mcode", c.a(a));
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
            str3 = com.baidu.android.bbalbs.common.a.a.a(a);
        } catch (Exception e2) {
        }
        b.a("cuid:" + str3);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put("version", "1.0.20");
        String str4 = "";
        try {
            str4 = c.c(a);
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        String str5 = "";
        try {
            str5 = c.a();
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
        this.acG = new e(a);
        this.acG.a(hashMap, new e.a<String>() { // from class: com.baidu.d.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.d.a.e.a
            public void a(String str6) {
                h.this.a(str6, str2);
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
            str3 = com.baidu.android.bbalbs.common.a.a.a(a);
        } catch (Exception e2) {
        }
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put("pcn", a.getPackageName());
        hashMap.put("version", "1.0.20");
        String str4 = "";
        try {
            str4 = c.c(a);
        } catch (Exception e3) {
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("macaddr", "");
        } else {
            hashMap.put("macaddr", str4);
        }
        String str5 = "";
        try {
            str5 = c.a();
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
        this.acH = new f(a);
        this.acH.a(hashMap, strArr, new f.a<String>() { // from class: com.baidu.d.a.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.d.a.f.a
            public void a(String str6) {
                h.this.a(str6, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(a, str);
        try {
            jSONObject = new JSONObject(f());
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

    public static h bn(Context context) {
        if (acK == null) {
            synchronized (h.class) {
                if (acK == null) {
                    acK = new h(context);
                }
            }
        } else if (context != null) {
            a = context;
        } else if (b.a) {
            b.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return acK;
    }

    private String c(Context context) {
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

    private void c(String str) {
        a.getSharedPreferences("authStatus_" + c(a), 0).edit().putString("status", str).commit();
    }

    private void e() {
        synchronized (h.class) {
            if (acI == null) {
                acI = new i(AuthorBox.TYPE);
                acI.start();
                while (acI.a == null) {
                    try {
                        if (b.a) {
                            b.a("wait for create auth thread.");
                        }
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String f() {
        return a.getSharedPreferences("authStatus_" + c(a), 0).getString("status", "{\"status\":601}");
    }

    public int a(final boolean z, final String str, final Hashtable<String, String> hashtable, a aVar) {
        final int i;
        synchronized (h.class) {
            final String str2 = System.currentTimeMillis() + "";
            if (aVar != null) {
                acJ.put(str2, aVar);
            }
            String a2 = a(a, str2);
            if (a2 == null || a2.equals("")) {
                i = 101;
            } else {
                e++;
                if (b.a) {
                    b.a(" mAuthCounter  ++ = " + e);
                }
                String f = f();
                if (b.a) {
                    b.a("getAuthMessage from cache:" + f);
                }
                i = a(f);
                if (i == 601) {
                    try {
                        c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                e();
                if (b.a) {
                    b.a("mThreadLooper.mHandler = " + acI.a);
                }
                if (acI == null || acI.a == null) {
                    i = -1;
                } else {
                    acI.a.post(new Runnable() { // from class: com.baidu.d.a.h.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.a) {
                                b.a("status = " + i + "; forced = " + z + "checkAK = " + h.this.b(str2));
                            }
                            if (i != 601 && !z && i != -1 && !h.this.b(str2)) {
                                if (602 != i) {
                                    if (b.a) {
                                        b.a("authenticate else  ");
                                    }
                                    h.this.a((String) null, str2);
                                    return;
                                }
                                if (b.a) {
                                    b.a("authenticate wait  ");
                                }
                                h.acI.b();
                                h.this.a((String) null, str2);
                                return;
                            }
                            if (b.a) {
                                b.a("authenticate sendAuthRequest");
                            }
                            String[] bm = c.bm(h.a);
                            if (b.a) {
                                b.a("authStrings.length:" + bm.length);
                            }
                            if (bm == null || bm.length <= 1) {
                                h.this.a(z, str, hashtable, str2);
                                return;
                            }
                            if (b.a) {
                                b.a("more sha1 auth");
                            }
                            h.this.a(z, str, hashtable, bm, str2);
                        }
                    });
                }
            }
        }
        return i;
    }

    public String a() {
        return a == null ? "" : c.a(a);
    }

    public String b(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
