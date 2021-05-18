package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.d.n;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    public static i f3138b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3139a;

    public i(Context context) {
        this.f3139a = context;
        com.baidu.android.pushservice.a.b.a(context);
        k.a(context);
        com.baidu.android.pushservice.h.d.a();
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f3138b == null) {
                f3138b = new i(context);
            }
            iVar = f3138b;
        }
        return iVar;
    }

    private void a() {
        com.baidu.android.pushservice.i.a.c.a(this.f3139a.getApplicationContext());
    }

    private void b() {
        PushSettings.a(this.f3139a, 0);
    }

    private void b(Intent intent) {
        boolean a2;
        StringBuilder sb;
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_BIND ", this.f3139a);
        m.a("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.f3139a);
        String d2 = com.baidu.android.pushservice.a.b.a(this.f3139a).d(iVar.f3011d);
        if (!TextUtils.isEmpty(iVar.f3014g) && com.baidu.android.pushservice.a.b.a(this.f3139a).b(iVar.f3011d, iVar.f3014g) && !TextUtils.isEmpty(d2)) {
            Intent intent2 = new Intent();
            intent2.putExtra("method", iVar.f3008a);
            intent2.putExtra("error_msg", 0);
            intent2.putExtra("content", d2.getBytes());
            intent2.putExtra("bind_status", intExtra);
            m.b(this.f3139a, intent2, "com.baidu.android.pushservice.action.RECEIVE", iVar.f3011d);
            m.a("RegistrationService#handleBind#returned by cacheContent = " + d2, this.f3139a);
            return;
        }
        m.a("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.f3139a);
        if (intent.hasExtra("bind_notify_status")) {
            a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f3139a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status")));
            sb = new StringBuilder();
        } else {
            a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f3139a, intExtra, intExtra2));
            sb = new StringBuilder();
        }
        sb.append("submitApiProcessor for bind=");
        sb.append(iVar.toString());
        m.a(sb.toString(), this.f3139a);
        if (a2) {
            return;
        }
        new Thread(new com.baidu.android.pushservice.d.e(iVar, this.f3139a, intExtra, intExtra2)).start();
        m.a("submitApiProcessor failed bind " + iVar.toString(), this.f3139a);
    }

    private void c(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.f3139a);
        if (!TextUtils.isEmpty(iVar.f3011d) && !TextUtils.isEmpty(iVar.f3014g)) {
            com.baidu.android.pushservice.a.e a2 = com.baidu.android.pushservice.a.b.a(this.f3139a).a(iVar.f3011d);
            if (a2 != null && !TextUtils.isEmpty(a2.a())) {
                iVar.f3012e = a2.a();
            }
            com.baidu.android.pushservice.a.b.a(this.f3139a).e(iVar.f3011d);
        }
        a(new n(iVar, this.f3139a));
    }

    private void d(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.f3139a);
        a(new com.baidu.android.pushservice.d.m(iVar, this.f3139a, stringExtra));
    }

    private void e(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_GBIND ", this.f3139a);
        a(new com.baidu.android.pushservice.d.h(iVar, this.f3139a, stringExtra));
    }

    private void f(Intent intent) {
        com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
        com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.f3139a);
        a(new com.baidu.android.pushservice.d.k(iVar, this.f3139a));
    }

    public boolean a(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        String action = intent.getAction();
        m.a("handleIntent#action = " + action, this.f3139a);
        if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            String host = intent.getData().getHost();
            if (publicMsg != null) {
                publicMsg.handle(this.f3139a, action, host);
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (m.b(this.f3139a, publicMsg2)) {
                String stringExtra = intent.getStringExtra(Constants.APP_ID);
                publicMsg2.handlePrivateNotification(this.f3139a, action, intent.getStringExtra("msg_id"), stringExtra, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.METHOD".equals(action)) {
            String stringExtra2 = intent.getStringExtra("method");
            if ("method_bind".equals(stringExtra2)) {
                b(intent);
            } else if ("method_unbind".equals(stringExtra2)) {
                c(intent);
            } else if ("method_set_tags".equals(stringExtra2) || "method_set_sdk_tags".equals(stringExtra2)) {
                d(intent);
            } else if ("method_del_tags".equals(stringExtra2) || "method_del_sdk_tags".equals(stringExtra2)) {
                e(intent);
            } else if ("method_listtags".equals(stringExtra2) || "method_list_sdk_tags".equals(stringExtra2)) {
                f(intent);
            } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra2)) {
                a();
            } else if (!"com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra2)) {
                return false;
            } else {
                b();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.android.pushservice.d.a aVar) {
        try {
            com.baidu.android.pushservice.h.d.a().a(aVar);
            return true;
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("RegistrationService", e2, this.f3139a);
            new b.c(this.f3139a.getApplicationContext()).a(Log.getStackTraceString(e2)).a();
            return false;
        }
    }
}
