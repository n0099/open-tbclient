package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.d.k;
import com.baidu.android.pushservice.d.n;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes10.dex */
public class i {
    private static i b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1146a;

    private i(Context context) {
        this.f1146a = context;
        com.baidu.android.pushservice.a.b.a(context);
        j.a(context);
        com.baidu.android.pushservice.g.d.a();
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i(context);
            }
            iVar = b;
        }
        return iVar;
    }

    private void a() {
        com.baidu.android.pushservice.h.a.c.a(this.f1146a.getApplicationContext());
    }

    private void b() {
        PushSettings.a(this.f1146a, 0);
    }

    private void b(Intent intent) {
        boolean a2;
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_BIND ", this.f1146a);
        m.a("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.f1146a);
        String d = com.baidu.android.pushservice.a.b.a(this.f1146a).d(iVar.d);
        if (!TextUtils.isEmpty(iVar.g) && com.baidu.android.pushservice.a.b.a(this.f1146a).b(iVar.d, iVar.g) && !TextUtils.isEmpty(d)) {
            Intent intent2 = new Intent();
            intent2.putExtra("method", iVar.f1060a);
            intent2.putExtra("error_msg", 0);
            intent2.putExtra("content", d.getBytes());
            intent2.putExtra("bind_status", intExtra);
            m.b(this.f1146a, intent2, "com.baidu.android.pushservice.action.RECEIVE", iVar.d);
            m.a("RegistrationService#handleBind#returned by cacheContent = " + d, this.f1146a);
            return;
        }
        m.a("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.f1146a);
        if (intent.hasExtra("bind_notify_status")) {
            a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f1146a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status")));
            m.a("submitApiProcessor for bind=" + iVar.toString(), this.f1146a);
        } else {
            a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f1146a, intExtra, intExtra2));
            m.a("submitApiProcessor for bind=" + iVar.toString(), this.f1146a);
        }
        if (a2) {
            return;
        }
        new Thread(new com.baidu.android.pushservice.d.e(iVar, this.f1146a, intExtra, intExtra2)).start();
        m.a("submitApiProcessor failed bind " + iVar.toString(), this.f1146a);
    }

    private void c(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.f1146a);
        if (!TextUtils.isEmpty(iVar.d) && !TextUtils.isEmpty(iVar.g)) {
            com.baidu.android.pushservice.a.e a2 = com.baidu.android.pushservice.a.b.a(this.f1146a).a(iVar.d);
            if (a2 != null && !TextUtils.isEmpty(a2.a())) {
                iVar.e = a2.a();
            }
            com.baidu.android.pushservice.a.b.a(this.f1146a).e(iVar.d);
        }
        a(new n(iVar, this.f1146a));
    }

    private void d(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.f1146a);
        a(new com.baidu.android.pushservice.d.m(iVar, this.f1146a, stringExtra));
    }

    private void e(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_GBIND ", this.f1146a);
        a(new com.baidu.android.pushservice.d.h(iVar, this.f1146a, stringExtra));
    }

    private void f(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.f1146a);
        a(new k(iVar, this.f1146a));
    }

    public boolean a(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        String action = intent.getAction();
        m.a("handleIntent#action = " + action, this.f1146a);
        if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            String host = intent.getData().getHost();
            if (publicMsg != null) {
                publicMsg.handle(this.f1146a, action, host);
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (m.b(this.f1146a, publicMsg2)) {
                String stringExtra = intent.getStringExtra("app_id");
                publicMsg2.handlePrivateNotification(this.f1146a, action, intent.getStringExtra("msg_id"), stringExtra, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.METHOD".equals(action)) {
            String stringExtra2 = intent.getStringExtra("method");
            if ("method_bind".equals(stringExtra2)) {
                b(intent);
                return true;
            } else if ("method_unbind".equals(stringExtra2)) {
                c(intent);
                return true;
            } else if ("method_set_tags".equals(stringExtra2) || "method_set_sdk_tags".equals(stringExtra2)) {
                d(intent);
                return true;
            } else if ("method_del_tags".equals(stringExtra2) || "method_del_sdk_tags".equals(stringExtra2)) {
                e(intent);
                return true;
            } else if ("method_listtags".equals(stringExtra2) || "method_list_sdk_tags".equals(stringExtra2)) {
                f(intent);
                return true;
            } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra2)) {
                a();
                return true;
            } else if ("com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra2)) {
                b();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.android.pushservice.d.a aVar) {
        try {
            com.baidu.android.pushservice.g.d.a().a(aVar);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.a("RegistrationService", e, this.f1146a);
            new b.c(this.f1146a.getApplicationContext()).a(Log.getStackTraceString(e)).a();
            return false;
        }
    }
}
