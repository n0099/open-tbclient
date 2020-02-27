package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.d.aa;
import com.baidu.android.pushservice.d.j;
import com.baidu.android.pushservice.d.k;
import com.baidu.android.pushservice.d.l;
import com.baidu.android.pushservice.d.n;
import com.baidu.android.pushservice.d.o;
import com.baidu.android.pushservice.d.p;
import com.baidu.android.pushservice.d.q;
import com.baidu.android.pushservice.d.r;
import com.baidu.android.pushservice.d.s;
import com.baidu.android.pushservice.d.u;
import com.baidu.android.pushservice.d.v;
import com.baidu.android.pushservice.d.w;
import com.baidu.android.pushservice.d.x;
import com.baidu.android.pushservice.d.z;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.coloros.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class h {
    private static h c;
    private Context a;
    private m b;

    private h(Context context) {
        this.a = context;
        com.baidu.android.pushservice.a.b.a(context);
        i.a(context);
        com.baidu.android.pushservice.h.d.a();
    }

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (c == null) {
                c = new h(context);
            }
            hVar = c;
        }
        return hVar;
    }

    private void b(Intent intent) {
        boolean a;
        l lVar = new l(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_BIND ", this.a);
        com.baidu.android.pushservice.i.l.b("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.a);
        String f = com.baidu.android.pushservice.a.b.a(this.a).f(lVar.e);
        if (!TextUtils.isEmpty(lVar.i) && com.baidu.android.pushservice.a.b.a(this.a).b(lVar.e, lVar.i) && !TextUtils.isEmpty(f)) {
            Intent intent2 = new Intent();
            intent2.putExtra("method", lVar.a);
            intent2.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
            intent2.putExtra("content", f.getBytes());
            intent2.putExtra("bind_status", intExtra);
            com.baidu.android.pushservice.i.l.b(this.a, intent2, PushConstants.ACTION_RECEIVE, lVar.e);
            com.baidu.android.pushservice.i.l.b("RegistrationService#handleBind#returned by cacheContent = " + f, this.a);
            return;
        }
        com.baidu.android.pushservice.i.l.b("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.a);
        if (intent.hasExtra("bind_notify_status")) {
            a = a(new com.baidu.android.pushservice.d.f(lVar, this.a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status")));
            com.baidu.android.pushservice.i.l.b("submitApiProcessor for bind=" + lVar.toString(), this.a);
        } else {
            a = a(new com.baidu.android.pushservice.d.f(lVar, this.a, intExtra, intExtra2));
            com.baidu.android.pushservice.i.l.b("submitApiProcessor for bind=" + lVar.toString(), this.a);
        }
        if (a) {
            return;
        }
        new Thread(new com.baidu.android.pushservice.d.f(lVar, this.a, intExtra, intExtra2)).start();
        com.baidu.android.pushservice.i.l.b("submitApiProcessor failed bind " + lVar.toString(), this.a);
    }

    private void c(Intent intent) {
        l lVar = new l(intent);
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        int intExtra3 = intent.getIntExtra("sdk_client_version", 0);
        com.baidu.android.pushservice.a.g gVar = new com.baidu.android.pushservice.a.g(lVar.i, lVar.e);
        gVar.a(intExtra3);
        com.baidu.android.pushservice.a.h.a(this.a).a((com.baidu.android.pushservice.a.a) gVar, true);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_SDK_BIND ", this.a);
        a(new com.baidu.android.pushservice.d.f(lVar, this.a, intExtra, intExtra2));
    }

    private void d(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.a);
        if (!TextUtils.isEmpty(lVar.e) && !TextUtils.isEmpty(lVar.i)) {
            com.baidu.android.pushservice.a.f c2 = com.baidu.android.pushservice.a.b.a(this.a).c(lVar.e);
            if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                lVar.f = c2.a();
            }
            com.baidu.android.pushservice.a.b.a(this.a).g(lVar.e);
        }
        a(new z(lVar, this.a));
    }

    private void e(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_SDK_UNBIND ", this.a);
        a(new z(lVar, this.a));
    }

    private boolean f(Intent intent) {
        com.baidu.android.pushservice.a.f c2;
        String stringExtra = intent.getStringExtra("package_name");
        String stringExtra2 = intent.getStringExtra(Constants.APP_ID);
        if (TextUtils.isEmpty(stringExtra2) && (c2 = com.baidu.android.pushservice.a.b.a(this.a).c(stringExtra)) != null) {
            stringExtra2 = c2.a();
        }
        String stringExtra3 = intent.getStringExtra("user_id");
        l lVar = new l();
        lVar.a = "com.baidu.android.pushservice.action.UNBINDAPP";
        if (!TextUtils.isEmpty(stringExtra)) {
            lVar.e = stringExtra;
        }
        if (!TextUtils.isEmpty(stringExtra2) && !"null".equals(stringExtra2)) {
            lVar.f = stringExtra2;
        }
        if (!TextUtils.isEmpty(stringExtra3) && !"null".equals(stringExtra3)) {
            lVar.g = stringExtra3;
        }
        if (!TextUtils.isEmpty(lVar.e)) {
            com.baidu.android.pushservice.a.f c3 = com.baidu.android.pushservice.a.b.a(this.a).c(lVar.e);
            if (c3 != null && !TextUtils.isEmpty(c3.a())) {
                lVar.f = c3.a();
            }
            com.baidu.android.pushservice.a.b.a(this.a).g(lVar.e);
        }
        return a(new aa(lVar, this.a));
    }

    private void g(Intent intent) {
        l lVar = new l(intent);
        int intExtra = intent.getIntExtra("fetch_type", 1);
        int intExtra2 = intent.getIntExtra("fetch_num", 1);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_FETCH ", this.a);
        a(new com.baidu.android.pushservice.d.m(lVar, this.a, intExtra, intExtra2));
    }

    private void h(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_COUNT ", this.a);
        a(new com.baidu.android.pushservice.d.h(lVar, this.a));
    }

    private void i(Intent intent) {
        l lVar = new l(intent);
        String[] stringArrayExtra = intent.getStringArrayExtra("msg_ids");
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_DELETE ", this.a);
        a(new k(lVar, this.a, stringArrayExtra));
    }

    private void j(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
        a(new o(lVar, this.a, stringExtra));
    }

    private void k(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.a);
        a(new x(lVar, this.a, stringExtra));
    }

    private void l(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
        a(new j(lVar, this.a, stringExtra));
    }

    private void m(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_GUNBIND ", this.a);
        a(new r(lVar, this.a, stringExtra));
    }

    private void n(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_GINFO ", this.a);
        a(new p(lVar, this.a, stringExtra));
    }

    private void o(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.a);
        a(new s(lVar, this.a));
    }

    private void p(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_GLIST ", this.a);
        a(new q(lVar, this.a));
    }

    private void q(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        int intExtra = intent.getIntExtra("group_fetch_type", 1);
        int intExtra2 = intent.getIntExtra("group_fetch_num", 1);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_FETCHGMSG ", this.a);
        a(new n(lVar, this.a, stringExtra, intExtra, intExtra2));
    }

    private void r(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_COUNTGMSG ", this.a);
        a(new com.baidu.android.pushservice.d.i(lVar, this.a, stringExtra));
    }

    private void s(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_ONLINE ", this.a);
        a(new u(lVar, this.a));
    }

    private void t(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_SEND ", this.a);
        a(new v(lVar, this.a, intent.getStringExtra("push_ msg")));
    }

    private void u(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_SEND_MSG_TO_USER ", this.a);
        a(new w(lVar, this.a, intent.getStringExtra(Constants.APP_ID), intent.getStringExtra("user_id"), intent.getStringExtra("push_ msg_key"), intent.getStringExtra("push_ msg")));
    }

    private void v(Intent intent) {
        if (this.b == null) {
            this.b = new m(this.a);
        }
        this.b.a();
    }

    private void w(Intent intent) {
        PushSettings.a(this.a, 0);
    }

    public boolean a(Intent intent) {
        boolean z = false;
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        String action = intent.getAction();
        com.baidu.android.pushservice.i.l.b("handleIntent#action = " + action, this.a);
        if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            String host = intent.getData().getHost();
            if (publicMsg != null) {
                publicMsg.handle(this.a, action, host);
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (com.baidu.android.pushservice.i.l.b(this.a, publicMsg2)) {
                publicMsg2.handlePrivateNotification(this.a, action, intent.getStringExtra("msg_id"), intent.getStringExtra(Constants.APP_ID), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
            com.baidu.android.pushservice.i.l.b("push_passthrough: receive  click delete and notified action", this.a);
            com.baidu.android.pushservice.g.i.a(this.a, intent.hasExtra("msg_id") ? intent.getStringExtra("msg_id") : null, intent.hasExtra(Constants.APP_ID) ? intent.getStringExtra(Constants.APP_ID) : null, action);
            return true;
        } else if ("com.baidu.pushservice.action.TOKEN".equals(action)) {
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_TOKEN ", this.a);
            if (i.a(this.a).e()) {
                return true;
            }
            i.a(this.a).a(this.a, true, null);
            return true;
        } else if (PushConstants.ACTION_METHOD.equals(action)) {
            String stringExtra = intent.getStringExtra("method");
            if (PushConstants.METHOD_BIND.equals(stringExtra)) {
                b(intent);
                z = true;
            } else if ("method_sdk_bind".equals(stringExtra)) {
                c(intent);
                z = true;
            } else if ("method_unbind".equals(stringExtra)) {
                d(intent);
                z = true;
            } else if ("method_sdk_unbind".equals(stringExtra)) {
                e(intent);
                z = true;
            } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(stringExtra)) {
                f(intent);
                z = true;
            } else if ("method_fetch".equals(stringExtra)) {
                g(intent);
                z = true;
            } else if ("method_count".equals(stringExtra)) {
                h(intent);
                z = true;
            } else if ("method_delete".equals(stringExtra)) {
                i(intent);
                z = true;
            } else if ("method_gbind".equals(stringExtra)) {
                j(intent);
                z = true;
            } else if ("method_set_tags".equals(stringExtra) || "method_set_sdk_tags".equals(stringExtra)) {
                k(intent);
                z = true;
            } else if ("method_del_tags".equals(stringExtra) || "method_del_sdk_tags".equals(stringExtra)) {
                l(intent);
                z = true;
            } else if ("method_gunbind".equals(stringExtra)) {
                m(intent);
                z = true;
            } else if ("method_ginfo".equals(stringExtra)) {
                n(intent);
                z = true;
            } else if ("method_glist".equals(stringExtra)) {
                p(intent);
                z = true;
            } else if ("method_listtags".equals(stringExtra) || "method_list_sdk_tags".equals(stringExtra)) {
                o(intent);
                z = true;
            } else if ("method_fetchgmsg".equals(stringExtra)) {
                q(intent);
                z = true;
            } else if ("method_countgmsg".equals(stringExtra)) {
                r(intent);
                z = true;
            } else if ("method_online".equals(stringExtra)) {
                s(intent);
                z = true;
            } else if ("method_send".equals(stringExtra)) {
                t(intent);
                z = true;
            } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra)) {
                v(intent);
                z = true;
            } else if ("com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra)) {
                w(intent);
                z = true;
            } else if ("method_send_msg_to_user".equals(stringExtra)) {
                u(intent);
                z = true;
            }
            return z;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.android.pushservice.d.a aVar) {
        try {
            com.baidu.android.pushservice.h.d.a().a(aVar);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.a("RegistrationService", e, this.a);
            return false;
        }
    }
}
