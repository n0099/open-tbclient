package com.baidu.android.pushservice.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h.u;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public class p {
    private final Context a;
    private g b;
    private final n c;

    public p(Context context) {
        this.a = context;
        this.c = new n(context);
        this.b = g.a(context);
    }

    public static long a(Context context, b bVar) {
        return com.baidu.android.pushservice.h.o.a(context, bVar);
    }

    public static long a(Context context, f fVar) {
        return com.baidu.android.pushservice.h.o.a(context, fVar);
    }

    public static long a(Context context, h hVar) {
        return com.baidu.android.pushservice.h.o.a(context, hVar);
    }

    public static long a(Context context, i iVar) {
        return com.baidu.android.pushservice.h.o.a(context, iVar);
    }

    public static long a(Context context, j jVar) {
        return com.baidu.android.pushservice.h.o.a(context, jVar);
    }

    public static long a(Context context, String str, int i, String str2) {
        h hVar = new h();
        hVar.e = System.currentTimeMillis();
        hVar.f = com.baidu.android.pushservice.f.a.b.c(context);
        hVar.g = i;
        hVar.j = str2;
        hVar.d = str;
        return a(context, hVar);
    }

    public static String a(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static void a(final Context context, final String str) {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("insertNetworkInfo", (short) 95) { // from class: com.baidu.android.pushservice.f.p.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
                if (System.currentTimeMillis() - sharedPreferences.getLong(str, 0L) < 1800000) {
                    return;
                }
                p.a(context, str, 0, str.equals("039912") ? u.v(context) : u.w(context));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str, System.currentTimeMillis());
                edit.commit();
            }
        });
    }

    public static void a(Context context, Throwable th) {
        f fVar = new f();
        fVar.d = "040102";
        fVar.e = System.currentTimeMillis();
        fVar.f = com.baidu.android.pushservice.f.a.b.c(context);
        fVar.a = b(context, th);
        a(context, fVar);
    }

    public static long b(Context context, h hVar) {
        return com.baidu.android.pushservice.h.o.b(context, hVar);
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
        fVar.f = com.baidu.android.pushservice.f.a.b.c(context);
        fVar.a = str;
        a(context, fVar);
    }

    private boolean b() {
        if (PushSettings.i(this.a) || this.b.c()) {
            return false;
        }
        return System.currentTimeMillis() - com.baidu.android.pushservice.h.h.c(this.a) > (PushSettings.h(this.a) ? (long) PushSettings.g(this.a) : 43200000L);
    }

    public void a() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public void a(boolean z, com.baidu.android.pushservice.h.g gVar) {
        if (this.b == null) {
            this.b = g.a(this.a);
        }
        this.b.a(gVar);
        if (z || b()) {
            this.b.b(z);
        }
    }
}
