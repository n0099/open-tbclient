package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p.k;
import com.baidu.android.pushservice.p.m;
import com.baidu.android.pushservice.p.n;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
/* loaded from: classes.dex */
public class h {
    public static h b;
    public final Context a;

    public h(Context context) {
        this.a = context;
        com.baidu.android.pushservice.k.b.a(context);
        j.a(context);
        com.baidu.android.pushservice.z.e.a();
    }

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (b == null) {
                b = new h(context);
            }
            hVar = b;
        }
        return hVar;
    }

    public final void a() {
        PushSettings.a(this.a, 0);
    }

    public final void a(Intent intent) {
        com.baidu.android.pushservice.p.e eVar;
        com.baidu.android.pushservice.p.i iVar = new com.baidu.android.pushservice.p.i(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.u.a.a("RegistrationService", "<<< METHOD_BIND ", this.a);
        String a = com.baidu.android.pushservice.k.b.a(this.a).a(iVar.c);
        if (!TextUtils.isEmpty(iVar.f) && com.baidu.android.pushservice.k.b.a(this.a).a(iVar.c, iVar.f) && !TextUtils.isEmpty(a)) {
            Intent intent2 = new Intent();
            intent2.putExtra("method", iVar.a);
            intent2.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
            intent2.putExtra("content", a.getBytes());
            intent2.putExtra("bind_status", intExtra);
            Utility.c(this.a, intent2, "com.baidu.android.pushservice.action.RECEIVE", iVar.c);
            return;
        }
        if (intent.hasExtra("bind_notify_status")) {
            eVar = new com.baidu.android.pushservice.p.e(iVar, this.a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status"));
        } else {
            eVar = new com.baidu.android.pushservice.p.e(iVar, this.a, intExtra, intExtra2);
        }
        if (a(eVar)) {
            return;
        }
        new Thread(new com.baidu.android.pushservice.p.e(iVar, this.a, intExtra, intExtra2)).start();
    }

    public boolean a(com.baidu.android.pushservice.p.a aVar) {
        try {
            com.baidu.android.pushservice.z.e.a().a(aVar);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.u.a.a("RegistrationService", e, this.a);
            return false;
        }
    }

    public final void b() {
    }

    public final void b(Intent intent) {
        com.baidu.android.pushservice.p.i iVar = new com.baidu.android.pushservice.p.i(intent);
        String stringExtra = intent.getStringExtra("tags");
        com.baidu.android.pushservice.u.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
        a(new com.baidu.android.pushservice.p.h(iVar, this.a, stringExtra));
    }

    public boolean c(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        String action = intent.getAction();
        if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            String host = intent.getData().getHost();
            if (publicMsg != null) {
                publicMsg.handle(this.a, action, host);
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (Utility.a(this.a, publicMsg2)) {
                String stringExtra = intent.getStringExtra("app_id");
                publicMsg2.handlePrivateNotification(this.a, action, intent.getStringExtra("msg_id"), stringExtra, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"), intent.getIntExtra("float_window_show_type", 0), intent.getStringExtra("notification_log_ext"));
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.METHOD".equals(action)) {
            String stringExtra2 = intent.getStringExtra("method");
            if ("method_bind".equals(stringExtra2)) {
                a(intent);
            } else if ("method_unbind".equals(stringExtra2)) {
                f(intent);
            } else if ("method_set_tags".equals(stringExtra2) || "method_set_sdk_tags".equals(stringExtra2)) {
                e(intent);
            } else if ("method_del_tags".equals(stringExtra2) || "method_del_sdk_tags".equals(stringExtra2)) {
                b(intent);
            } else if ("method_listtags".equals(stringExtra2) || "method_list_sdk_tags".equals(stringExtra2)) {
                d(intent);
            } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra2)) {
                b();
            } else if (!"com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra2)) {
                return false;
            } else {
                a();
            }
            return true;
        } else {
            return false;
        }
    }

    public final void d(Intent intent) {
        com.baidu.android.pushservice.p.i iVar = new com.baidu.android.pushservice.p.i(intent);
        com.baidu.android.pushservice.u.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.a);
        a(new k(iVar, this.a));
    }

    public final void e(Intent intent) {
        com.baidu.android.pushservice.p.i iVar = new com.baidu.android.pushservice.p.i(intent);
        String stringExtra = intent.getStringExtra("tags");
        com.baidu.android.pushservice.u.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.a);
        a(new m(iVar, this.a, stringExtra));
    }

    public final void f(Intent intent) {
        com.baidu.android.pushservice.p.i iVar = new com.baidu.android.pushservice.p.i(intent);
        com.baidu.android.pushservice.u.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.a);
        if (!TextUtils.isEmpty(iVar.c) && !TextUtils.isEmpty(iVar.f)) {
            com.baidu.android.pushservice.k.e c = com.baidu.android.pushservice.k.b.a(this.a).c(iVar.c);
            if (c != null && !TextUtils.isEmpty(c.a())) {
                iVar.d = c.a();
            }
            com.baidu.android.pushservice.k.b.a(this.a).d(iVar.c);
        }
        a(new n(iVar, this.a));
    }
}
