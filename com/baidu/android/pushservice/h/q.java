package com.baidu.android.pushservice.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private final Context a;
    private g b;
    private final o c;

    public q(Context context) {
        this.a = context;
        this.c = new o(context);
        this.b = g.a(context);
    }

    public static long a(Context context, b bVar) {
        return com.baidu.android.pushservice.d.a.a(context, bVar);
    }

    public static long a(Context context, f fVar) {
        return com.baidu.android.pushservice.d.a.a(context, fVar);
    }

    public static long a(Context context, i iVar) {
        return com.baidu.android.pushservice.d.a.a(context, iVar);
    }

    public static long a(Context context, j jVar) {
        return com.baidu.android.pushservice.d.a.a(context, jVar);
    }

    public static long a(Context context, k kVar) {
        return com.baidu.android.pushservice.d.a.a(context, kVar);
    }

    public static long a(Context context, String str, int i, String str2) {
        i iVar = new i();
        iVar.e = System.currentTimeMillis();
        iVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        iVar.g = i;
        iVar.i = str2;
        iVar.d = str;
        return a(context, iVar);
    }

    public static long a(Context context, String str, String str2, int i, String str3) {
        b bVar = new b();
        bVar.d = str;
        bVar.j = str2;
        bVar.g = i;
        bVar.a = str3;
        bVar.e = System.currentTimeMillis();
        bVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        return a(context, bVar);
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static void a(final Context context, final String str) {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("insertNetworkInfo", (short) 95) { // from class: com.baidu.android.pushservice.h.q.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
                if (System.currentTimeMillis() - sharedPreferences.getLong(str, 0L) < 1800000) {
                    return;
                }
                q.a(context, str, 0, str.equals("039912") ? com.baidu.android.pushservice.j.p.w(context) : com.baidu.android.pushservice.j.p.x(context));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str, System.currentTimeMillis());
                edit.commit();
            }
        });
    }

    public static void a(final Context context, final String str, final String str2) {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("insertNotificationAction", (short) 90) { // from class: com.baidu.android.pushservice.h.q.2
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                k kVar = new k();
                kVar.d = str2;
                kVar.a = str;
                kVar.e = System.currentTimeMillis();
                kVar.f = com.baidu.android.pushservice.h.a.b.b(context);
                kVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a();
                kVar.h = PushSettings.b(context);
                kVar.j = context.getPackageName();
                q.a(context, kVar);
            }
        });
    }

    public static void a(Context context, Throwable th) {
        f fVar = new f();
        fVar.d = "040102";
        fVar.e = System.currentTimeMillis();
        fVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        fVar.a = b(context, th);
        a(context, fVar);
    }

    public static long b(Context context, i iVar) {
        return com.baidu.android.pushservice.d.a.b(context, iVar);
    }

    public static String b(Context context, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            obj = a + "\n" + obj;
        }
        printWriter.close();
        return obj;
    }

    public static void b(Context context, String str) {
        f fVar = new f();
        fVar.d = "040101";
        fVar.e = System.currentTimeMillis();
        fVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        fVar.a = str;
        a(context, fVar);
    }

    private boolean b() {
        if (PushSettings.i(this.a) || this.b.c()) {
            return false;
        }
        return System.currentTimeMillis() - com.baidu.android.pushservice.j.g.b(this.a) > (PushSettings.h(this.a) ? (long) PushSettings.g(this.a) : 43200000L);
    }

    public void a() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public void a(boolean z, com.baidu.android.pushservice.j.f fVar) {
        if (this.b == null) {
            this.b = g.a(this.a);
        }
        this.b.a(fVar);
        if (z || b()) {
            this.b.b(z);
        }
    }
}
