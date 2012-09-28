package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.message.PublicMsg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class w {
    private PushService a;
    private ExecutorService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PushService pushService) {
        this.a = pushService;
        a.a(pushService);
        x.a();
        this.b = Executors.newFixedThreadPool(5, new com.baidu.android.pushservice.b.c("PushService-ApiThreadPool"));
    }

    private void a(com.baidu.android.pushservice.a.b bVar) {
        this.b.submit(bVar);
    }

    private void b(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_BIND_NAME);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_BIND_STATUS, 0);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_BIND;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.d(hVar, this.a, intExtra, stringExtra));
    }

    private void c(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_UNBIND;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.q(hVar, this.a));
    }

    private void d(Intent intent) {
        b a;
        String stringExtra = intent.getStringExtra("package_name");
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_ID);
        if ((stringExtra2 == null || stringExtra2.length() == 0) && (a = a.a(this.a).a(stringExtra)) != null) {
            stringExtra2 = a.b;
        }
        String stringExtra3 = intent.getStringExtra(PushConstants.EXTRA_USER_ID);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = "com.baidu.android.pushservice.action.UNBINDAPP";
        hVar.c = stringExtra;
        hVar.d = stringExtra2;
        hVar.e = stringExtra3;
        a(new com.baidu.android.pushservice.a.r(hVar, this.a));
    }

    private void e(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_FETCH_TYPE, 1);
        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_FETCH_NUM, 1);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_FETCH;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.i(hVar, this.a, intExtra, intExtra2));
    }

    private void f(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_COUNT;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.e(hVar, this.a));
    }

    private void g(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        String[] stringArrayExtra = intent.getStringArrayExtra(PushConstants.EXTRA_MSG_IDS);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_DELETE;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.g(hVar, this.a, stringArrayExtra));
    }

    private void h(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_GBIND;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.k(hVar, this.a, stringExtra));
    }

    private void i(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_GUNBIND;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.n(hVar, this.a, stringExtra));
    }

    private void j(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_GINFO;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.l(hVar, this.a, stringExtra));
    }

    private void k(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_GLIST;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.m(hVar, this.a));
    }

    private void l(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_TYPE, 1);
        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_NUM, 1);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_FETCHGMSG;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.j(hVar, this.a, stringExtra, intExtra, intExtra2));
    }

    private void m(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_COUNTGMSG;
        hVar.c = targetPackage;
        hVar.b = stringExtra2;
        a(new com.baidu.android.pushservice.a.f(hVar, this.a, stringExtra));
    }

    private void n(Intent intent) {
        String targetPackage = ((PendingIntent) intent.getParcelableExtra(PushConstants.EXTRA_APP)).getTargetPackage();
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_ACCESS_TOKEN);
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h();
        hVar.a = PushConstants.METHOD_ONLINE;
        hVar.c = targetPackage;
        hVar.b = stringExtra;
        a(new com.baidu.android.pushservice.a.o(hVar, this.a));
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if ("com.baidu.pushservice.action.publicmsg.CLICK".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).a(this.a, action, intent.getData().getHost());
            return true;
        } else if ("com.baidu.pushservice.action.TOKEN".equals(action)) {
            x.a().a((Context) this.a, true);
            return true;
        } else if (PushConstants.ACTION_METHOD.equals(action)) {
            String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
            if (PushConstants.METHOD_BIND.equals(stringExtra)) {
                b(intent);
                return true;
            } else if (PushConstants.METHOD_UNBIND.equals(stringExtra)) {
                c(intent);
                return true;
            } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(stringExtra)) {
                d(intent);
                return true;
            } else if (PushConstants.METHOD_FETCH.equals(stringExtra)) {
                e(intent);
                return true;
            } else if (PushConstants.METHOD_COUNT.equals(stringExtra)) {
                f(intent);
                return true;
            } else if (PushConstants.METHOD_DELETE.equals(stringExtra)) {
                g(intent);
                return true;
            } else if (PushConstants.METHOD_GBIND.equals(stringExtra)) {
                h(intent);
                return true;
            } else if (PushConstants.METHOD_GUNBIND.equals(stringExtra)) {
                i(intent);
                return true;
            } else if (PushConstants.METHOD_GINFO.equals(stringExtra)) {
                j(intent);
                return true;
            } else if (PushConstants.METHOD_GLIST.equals(stringExtra)) {
                k(intent);
                return true;
            } else if (PushConstants.METHOD_FETCHGMSG.equals(stringExtra)) {
                l(intent);
                return true;
            } else if (PushConstants.METHOD_COUNTGMSG.equals(stringExtra)) {
                m(intent);
                return true;
            } else if (PushConstants.METHOD_ONLINE.equals(stringExtra)) {
                n(intent);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
