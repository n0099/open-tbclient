package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes.dex */
public class l {
    public static Intent a(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.addFlags(32);
        try {
            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, context.getPackageName());
            intent.putExtra("method_version", "V2");
            intent.putExtra(!m.o(context) ? "priority2" : "priority3", 0);
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
        return intent;
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = a(context);
        }
        return (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) ? a(context, intent, context.getPackageName()) : com.baidu.android.pushservice.i.a(context).a(intent);
    }

    public static boolean a(Context context, Intent intent, String str) {
        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                intent.setClassName(str, m.m() ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return true;
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E: " + e2, context.getApplicationContext());
            if (com.baidu.android.pushservice.a.a(context.getPackageName())) {
                return false;
            }
        }
        if (!m.p(context) && m.e(context, str)) {
            try {
                String b2 = m.b(context, str, intent.getAction());
                if (!TextUtils.isEmpty(b2)) {
                    intent.setClassName(str, b2);
                    context.sendBroadcast(intent);
                    com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                    return true;
                }
            } catch (Exception e3) {
                com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E-2: " + e3, context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e3)).a();
            }
            return false;
        }
        return true;
    }

    public static void b(final Context context) {
        com.baidu.android.pushservice.b.d.a(context).d();
        if (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) {
            if (!com.baidu.android.pushservice.job.a.a() && !m.g(context) && (Build.VERSION.SDK_INT > 22 || (!m.e() && !m.h()))) {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.j.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.android.pushservice.job.a.a(context);
                        com.baidu.android.pushservice.job.a.a(context, true);
                    }
                }, com.baidu.android.pushservice.b.d.h() * 1000);
            }
            final Context applicationContext = context.getApplicationContext();
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("checkAndStartPushService", (short) 98) { // from class: com.baidu.android.pushservice.j.l.2
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    l.a(applicationContext, new Intent());
                }
            });
        }
    }
}
