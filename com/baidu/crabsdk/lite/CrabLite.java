package com.baidu.crabsdk.lite;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.crabsdk.lite.a.f;
import com.baidu.crabsdk.lite.a.h;
import com.baidu.crabsdk.lite.a.k;
import com.baidu.crabsdk.lite.a.l;
import com.baidu.crabsdk.lite.a.m;
import com.baidu.crabsdk.lite.a.n;
import com.baidu.crabsdk.lite.a.r;
import com.baidu.crabsdk.lite.sender.c;
import com.baidu.crabsdk.lite.sender.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CrabLite {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4711a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f4712b = "-1";

    /* renamed from: c  reason: collision with root package name */
    public static String f4713c = "/sdcard";

    public static void a(String str) {
        l.c(str);
        e.b(str);
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
        long currentTimeMillis;
        String str5;
        com.baidu.crabsdk.lite.b.a.c(str2, "crablite init begin: " + System.currentTimeMillis());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sdk_appkey", str);
        hashMap.put("sdk_pkgname", str2);
        hashMap.put("sdk_appvn", str3);
        hashMap.put("sdk_appvc", str4);
        a.f4714a.put(str2, hashMap);
        if (context == null) {
            str5 = "crab init error caused by applcation null value";
        } else {
            f4711a = context;
            f4713c = context.getFilesDir().getAbsolutePath();
            com.baidu.crabsdk.lite.b.a.c(str2, "FILE_PATH IS : " + f4713c);
            e(str2, f4711a);
            long currentTimeMillis2 = System.currentTimeMillis();
            a.k = false;
            str5 = "crab init end: " + currentTimeMillis2 + ", cost: " + (currentTimeMillis2 - currentTimeMillis) + "ms";
        }
        com.baidu.crabsdk.lite.b.a.d(str2, str5);
    }

    public static void c(String str, Context context) {
        l.a(context);
        n.a(str, context);
        f.b(str, context);
        h.a();
        k.a(context);
        r.b(context);
        m.a(context);
        com.baidu.crabsdk.lite.a.a.c(str, context);
    }

    public static void d(String str, Context context) {
        c.f(str, context);
    }

    public static void e(String str, Context context) {
        boolean z;
        int myPid = Process.myPid();
        com.baidu.crabsdk.lite.b.a.f(str, "CrabSDK.init from " + f4711a.getPackageName() + " with pid " + myPid);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            com.baidu.crabsdk.lite.b.a.f(str, "getRunningAppProcesses error!!");
            return;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                z = true;
                StringBuilder sb = next.processName.equals(context.getPackageName()) ? new StringBuilder("Main process ") : new StringBuilder("Sub process ");
                sb.append(next.processName);
                sb.append(".");
                com.baidu.crabsdk.lite.b.a.f(str, sb.toString());
            }
        }
        if (z) {
            d(str, context);
            c(str, context);
            com.baidu.crabsdk.lite.sender.a.c().b(context);
            q(str, context);
        }
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        g(str, str2);
    }

    public static void g(String str, String str2) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_channel", str2);
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void h(String str, boolean z) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_screenshot", Boolean.valueOf(z));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void i(String str, boolean z) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_debug", Boolean.valueOf(z));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void j(String str, boolean z) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_privacy", Boolean.valueOf(z));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void k(String str, boolean z) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_upload_immediate", Boolean.valueOf(z));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void l(String str, int i) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_all_crash_limit", Integer.valueOf(i));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void m(String str, int i) {
        HashMap<String, Object> hashMap = a.f4714a.get(str);
        if (hashMap != null) {
            hashMap.put("sdk_same_crash_limit", Integer.valueOf(i));
        } else {
            com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
        }
    }

    public static void n(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        r.g(str, str2);
    }

    public static void o(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap<String, String> e2 = r.e(str);
        e2.put(str2, str3);
        p(str, e2);
    }

    public static void p(String str, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            r.a(str, hashMap);
        }
    }

    public static void q(String str, Context context) {
        if (c.p(str)) {
            e.c(str, context);
        }
    }
}
