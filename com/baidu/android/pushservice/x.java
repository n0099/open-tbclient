package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.message.PublicMsg;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class x {
    private PushService a;
    private ExecutorService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PushService pushService) {
        this.a = pushService;
        a.a(pushService);
        y.a();
        this.b = Executors.newFixedThreadPool(5, new com.baidu.android.pushservice.util.c("PushService-ApiThreadPool"));
    }

    private void a(com.baidu.android.pushservice.a.b bVar) {
        this.b.submit(bVar);
    }

    private void b(Intent intent) {
        com.baidu.android.pushservice.a.h hVar = new com.baidu.android.pushservice.a.h(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_BIND_NAME);
        a(new com.baidu.android.pushservice.a.d(hVar, this.a, intent.getIntExtra(PushConstants.EXTRA_BIND_STATUS, 0), stringExtra));
    }

    private void c(Intent intent) {
        a(new com.baidu.android.pushservice.a.q(new com.baidu.android.pushservice.a.h(intent), this.a));
    }

    private void d(Intent intent) {
        c a;
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
        a(new com.baidu.android.pushservice.a.i(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getIntExtra(PushConstants.EXTRA_FETCH_TYPE, 1), intent.getIntExtra(PushConstants.EXTRA_FETCH_NUM, 1)));
    }

    private void f(Intent intent) {
        a(new com.baidu.android.pushservice.a.e(new com.baidu.android.pushservice.a.h(intent), this.a));
    }

    private void g(Intent intent) {
        a(new com.baidu.android.pushservice.a.g(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringArrayExtra(PushConstants.EXTRA_MSG_IDS)));
    }

    private void h(Intent intent) {
        a(new com.baidu.android.pushservice.a.k(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringExtra(PushConstants.EXTRA_GID)));
    }

    private void i(Intent intent) {
        a(new com.baidu.android.pushservice.a.n(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringExtra(PushConstants.EXTRA_GID)));
    }

    private void j(Intent intent) {
        a(new com.baidu.android.pushservice.a.l(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringExtra(PushConstants.EXTRA_GID)));
    }

    private void k(Intent intent) {
        a(new com.baidu.android.pushservice.a.m(new com.baidu.android.pushservice.a.h(intent), this.a));
    }

    private void l(Intent intent) {
        a(new com.baidu.android.pushservice.a.j(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringExtra(PushConstants.EXTRA_GID), intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_TYPE, 1), intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_NUM, 1)));
    }

    private void m(Intent intent) {
        a(new com.baidu.android.pushservice.a.f(new com.baidu.android.pushservice.a.h(intent), this.a, intent.getStringExtra(PushConstants.EXTRA_GID)));
    }

    private void n(Intent intent) {
        a(new com.baidu.android.pushservice.a.o(new com.baidu.android.pushservice.a.h(intent), this.a));
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
            y.a().a((Context) this.a, true);
            return true;
        } else if (PushConstants.ACTION_METHOD.equals(action)) {
            String stringExtra = intent.getStringExtra("method_version");
            if (stringExtra == null || "V1".equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_METHOD);
                if (PushConstants.METHOD_BIND.equals(stringExtra2)) {
                    b(intent);
                    return true;
                } else if (PushConstants.METHOD_UNBIND.equals(stringExtra2)) {
                    c(intent);
                    return true;
                } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(stringExtra2)) {
                    d(intent);
                    return true;
                } else if (PushConstants.METHOD_FETCH.equals(stringExtra2)) {
                    e(intent);
                    return true;
                } else if (PushConstants.METHOD_COUNT.equals(stringExtra2)) {
                    f(intent);
                    return true;
                } else if (PushConstants.METHOD_DELETE.equals(stringExtra2)) {
                    g(intent);
                    return true;
                } else if (PushConstants.METHOD_GBIND.equals(stringExtra2)) {
                    h(intent);
                    return true;
                } else if (PushConstants.METHOD_GUNBIND.equals(stringExtra2)) {
                    i(intent);
                    return true;
                } else if (PushConstants.METHOD_GINFO.equals(stringExtra2)) {
                    j(intent);
                    return true;
                } else if (PushConstants.METHOD_GLIST.equals(stringExtra2)) {
                    k(intent);
                    return true;
                } else if (PushConstants.METHOD_FETCHGMSG.equals(stringExtra2)) {
                    l(intent);
                    return true;
                } else if (PushConstants.METHOD_COUNTGMSG.equals(stringExtra2)) {
                    m(intent);
                    return true;
                } else if (PushConstants.METHOD_ONLINE.equals(stringExtra2)) {
                    n(intent);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
