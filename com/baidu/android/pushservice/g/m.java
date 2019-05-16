package com.baidu.android.pushservice.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
/* loaded from: classes3.dex */
public class m {
    private final k a;

    public m(Context context) {
        this.a = new k(context);
    }

    public static long a(Context context, a aVar) {
        return com.baidu.android.pushservice.c.a.a(context, aVar);
    }

    public static long a(Context context, e eVar) {
        return com.baidu.android.pushservice.c.a.a(context, eVar);
    }

    public static long a(Context context, f fVar) {
        return com.baidu.android.pushservice.c.a.a(context, fVar);
    }

    public static long a(Context context, g gVar) {
        return com.baidu.android.pushservice.c.a.a(context, gVar);
    }

    public static long a(Context context, h hVar) {
        return com.baidu.android.pushservice.c.a.a(context, hVar);
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

    public static void a(Context context, String str) {
        e eVar = new e();
        eVar.d = "040101";
        eVar.e = System.currentTimeMillis();
        eVar.f = com.baidu.android.pushservice.g.a.b.b(context);
        eVar.a = str;
        a(context, eVar);
    }

    public static void a(final Context context, final String str, final String str2) {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("insertNotificationAction", (short) 90) { // from class: com.baidu.android.pushservice.g.m.2
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                h hVar = new h();
                hVar.d = str2;
                hVar.a = str;
                hVar.e = System.currentTimeMillis();
                hVar.f = com.baidu.android.pushservice.g.a.b.b(context);
                hVar.c = com.baidu.android.pushservice.message.a.k.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a();
                hVar.h = PushSettings.c(context);
                hVar.j = context.getPackageName();
                m.a(context, hVar);
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final int i, final String str3) {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("insertApiBehavior", (short) 90) { // from class: com.baidu.android.pushservice.g.m.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                a aVar = new a();
                aVar.d = str;
                aVar.j = str2;
                aVar.g = i;
                aVar.a = str3;
                aVar.e = System.currentTimeMillis();
                aVar.f = com.baidu.android.pushservice.g.a.b.b(context);
                m.a(context, aVar);
            }
        });
    }

    public static void a(Context context, Throwable th) {
        e eVar = new e();
        eVar.d = "040102";
        eVar.e = System.currentTimeMillis();
        eVar.f = com.baidu.android.pushservice.g.a.b.b(context);
        eVar.a = b(context, th);
        a(context, eVar);
    }

    public static long b(Context context, f fVar) {
        return com.baidu.android.pushservice.c.a.b(context, fVar);
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

    public void a() {
        if (this.a != null) {
            this.a.b();
        }
    }
}
