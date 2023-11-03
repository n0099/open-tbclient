package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class m {

    /* loaded from: classes.dex */
    public static class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, short s, Context context) {
            super(str, s);
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            m.a(this.c, new Intent());
        }
    }

    public static void a(Context context) {
        com.baidu.android.pushservice.l.d.i(context).g();
        if (!com.baidu.android.pushservice.l.d.r(context) || com.baidu.android.pushservice.l.d.q(context)) {
            int a2 = i.a(context, "key_push_launch_task_level", 0);
            if (!com.baidu.android.pushservice.s.a.a() && !Utility.d(context) && Build.VERSION.SDK_INT > 23 && a2 != 1) {
                com.baidu.android.pushservice.s.a.b(context);
                com.baidu.android.pushservice.s.a.a(context, true);
            }
            com.baidu.android.pushservice.z.e.a().a(new a("checkAndStartPushService", (short) 98, context.getApplicationContext()));
        }
    }

    public static void a(ClientEventInfo clientEventInfo, Intent intent) {
        intent.putExtra("push_start_source", clientEventInfo.getSource());
        intent.putExtra("push_start_name", clientEventInfo.getComponentName());
        intent.putExtra("push_start_action", clientEventInfo.getAction());
    }

    public static boolean a(Context context, Intent intent) {
        return b(context, intent, new ClientEventInfo());
    }

    public static boolean a(Context context, Intent intent, ClientEventInfo clientEventInfo) {
        return (clientEventInfo.getSource() == 0 || com.baidu.android.pushservice.y.c.g(context) == 0 || com.baidu.android.pushservice.y.c.g(context) == 2) ? a(context, intent, context.getPackageName()) : com.baidu.android.pushservice.y.d.d(context, clientEventInfo);
    }

    public static boolean a(Context context, Intent intent, String str) {
        com.baidu.android.pushservice.u.a.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                intent.setClassName(str, Utility.U(context) ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
                context.startService(intent);
                com.baidu.android.pushservice.u.a.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                return true;
            }
        } catch (Exception unused) {
            if (com.baidu.android.pushservice.y.c.g(context) == 2) {
                ClientEventInfo clientEventInfo = new ClientEventInfo();
                clientEventInfo.setSource(intent.getIntExtra("push_start_source", 0));
                clientEventInfo.setComponentName(intent.getStringExtra("push_start_name"));
                clientEventInfo.setAction(intent.getStringExtra("push_start_action"));
                com.baidu.android.pushservice.y.d.d(context, clientEventInfo);
            }
            if (com.baidu.android.pushservice.a.a(context.getPackageName())) {
                return false;
            }
        }
        if (!Utility.E(context) && Utility.b(context, str)) {
            try {
                String b = Utility.b(context, str, intent.getAction());
                if (!TextUtils.isEmpty(b)) {
                    intent.setClassName(str, b);
                    context.sendBroadcast(intent);
                    com.baidu.android.pushservice.u.a.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                    return true;
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.u.a.b("ServiceUtils", "START SERVICE E-2: " + e, context.getApplicationContext());
            }
            return false;
        }
        return true;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.addFlags(32);
        try {
            intent.putExtra("pkg_name", context.getPackageName());
            intent.putExtra("method_version", "V2");
            intent.putExtra(!Utility.D(context) ? "priority2" : "priority3", 0);
        } catch (Exception unused) {
        }
        return intent;
    }

    public static boolean b(Context context, Intent intent, ClientEventInfo clientEventInfo) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = b(context);
        }
        if (!com.baidu.android.pushservice.l.d.r(context) || com.baidu.android.pushservice.l.d.q(context)) {
            a(clientEventInfo, intent);
            return a(context, intent, clientEventInfo);
        }
        Utility.a(context, clientEventInfo, true);
        return com.baidu.android.pushservice.h.a(context).c(intent);
    }
}
