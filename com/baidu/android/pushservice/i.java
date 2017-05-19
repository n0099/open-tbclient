package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.c.k;
import com.baidu.android.pushservice.c.l;
import com.baidu.android.pushservice.c.m;
import com.baidu.android.pushservice.c.n;
import com.baidu.android.pushservice.c.o;
import com.baidu.android.pushservice.c.q;
import com.baidu.android.pushservice.c.r;
import com.baidu.android.pushservice.c.s;
import com.baidu.android.pushservice.c.t;
import com.baidu.android.pushservice.c.v;
import com.baidu.android.pushservice.c.w;
import com.baidu.android.pushservice.c.y;
import com.baidu.android.pushservice.c.z;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes2.dex */
public class i {
    private static i c;
    private Context a;
    private p b;

    private i(Context context) {
        this.a = context;
        com.baidu.android.pushservice.b.b.a(context);
        j.a(context);
        com.baidu.android.pushservice.g.d.a();
    }

    public static i a(Context context) {
        if (c == null) {
            c = new i(context);
        }
        return c;
    }

    private void b(Intent intent) {
        boolean a;
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("bind_name");
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_BIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", bindName:" + stringExtra + ", bindStatus:" + intExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "apiKey:" + lVar.i);
        u.b("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.a);
        String f = com.baidu.android.pushservice.b.b.a(this.a).f(lVar.e);
        if (!TextUtils.isEmpty(lVar.i) && com.baidu.android.pushservice.b.b.a(this.a).b(lVar.e, lVar.i) && !TextUtils.isEmpty(f)) {
            Intent intent2 = new Intent();
            intent2.putExtra(PushConstants.EXTRA_METHOD, lVar.a);
            intent2.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
            intent2.putExtra("content", f.getBytes());
            intent2.putExtra("bind_status", intExtra);
            com.baidu.android.pushservice.e.a.c("RegistrationService", "> sendResult to " + lVar.e + " ,method:" + lVar.a + " ,errorCode : 0 ,content : " + f);
            if (a.b() > 0) {
                p.a(this.a, "039902", 2, f);
            }
            u.b(this.a, intent2, PushConstants.ACTION_RECEIVE, lVar.e);
            u.b("RegistrationService#handleBind#returned by cacheContent = " + f, this.a);
            com.baidu.android.pushservice.e.a.d("RegistrationService", "Already binded, no need to bind anymore");
            return;
        }
        u.b("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.a);
        if (a.b() > 0) {
            p.a(this.a, "039902", 0, f);
        }
        if (intent.hasExtra("bind_notify_status")) {
            String stringExtra2 = intent.getStringExtra("bind_notify_status");
            a = a(new com.baidu.android.pushservice.c.f(lVar, this.a, intExtra, stringExtra, intExtra2, stringExtra2));
            com.baidu.android.pushservice.e.a.c("RegistrationService", " notifystatus = " + stringExtra2);
            u.b("submitApiProcessor for bind=" + lVar.toString(), this.a);
        } else {
            a = a(new com.baidu.android.pushservice.c.f(lVar, this.a, intExtra, stringExtra, intExtra2));
            u.b("submitApiProcessor for bind=" + lVar.toString(), this.a);
        }
        if (a) {
            return;
        }
        new Thread(new com.baidu.android.pushservice.c.f(lVar, this.a, intExtra, stringExtra, intExtra2)).start();
        com.baidu.android.pushservice.e.a.c("RegistrationService", "submitApiProcessor failed bind " + lVar.toString());
        u.b("submitApiProcessor failed bind " + lVar.toString(), this.a);
    }

    private void c(Intent intent) {
        com.baidu.android.pushservice.b.j.a(this.a).a((com.baidu.android.pushservice.b.a) new com.baidu.android.pushservice.b.i(intent.getStringExtra("secret_key")), true);
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("bind_name");
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_WEB_APP_BIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", bindName:" + stringExtra + ", bindStatus:" + intExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "apiKey:" + lVar.i);
        a(new com.baidu.android.pushservice.c.f(lVar, this.a, intExtra, stringExtra, intExtra2));
    }

    private void d(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("bind_name");
        int intExtra = intent.getIntExtra("bind_status", 0);
        int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
        int intExtra3 = intent.getIntExtra("sdk_client_version", 0);
        com.baidu.android.pushservice.b.g gVar = new com.baidu.android.pushservice.b.g(lVar.i, lVar.e);
        gVar.a(intExtra3);
        com.baidu.android.pushservice.b.h.a(this.a).a((com.baidu.android.pushservice.b.a) gVar, true);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_SDK_BIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", bindName:" + stringExtra + ", bindStatus:" + intExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.c.f(lVar, this.a, intExtra, stringExtra, intExtra2));
    }

    private void e(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_UNBIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "apiKey:" + lVar.i);
        if (!TextUtils.isEmpty(lVar.e) && !TextUtils.isEmpty(lVar.i)) {
            com.baidu.android.pushservice.b.f c2 = com.baidu.android.pushservice.b.b.a(this.a).c(lVar.e);
            if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                lVar.f = c2.a();
            }
            com.baidu.android.pushservice.b.b.a(this.a).g(lVar.e);
        }
        a(new y(lVar, this.a));
    }

    private void f(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_SDK_UNBIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "apiKey:" + lVar.i);
        a(new y(lVar, this.a));
    }

    private void g(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "<<< METHOD_LAPP_UNBIND ");
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "apiKey:" + lVar.i);
        a(new y(lVar, this.a));
    }

    private boolean h(Intent intent) {
        com.baidu.android.pushservice.b.f c2;
        String stringExtra = intent.getStringExtra("package_name");
        String stringExtra2 = intent.getStringExtra("app_id");
        if (TextUtils.isEmpty(stringExtra2) && (c2 = com.baidu.android.pushservice.b.b.a(this.a).c(stringExtra)) != null) {
            stringExtra2 = c2.a();
        }
        String stringExtra3 = intent.getStringExtra("user_id");
        com.baidu.android.pushservice.e.a.c("RegistrationService", "<<< METHOD_UNBIND_APP ");
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "appid:" + stringExtra2);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "userid:" + stringExtra3);
        PushSettings.c(this.a, stringExtra);
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
            com.baidu.android.pushservice.b.f c3 = com.baidu.android.pushservice.b.b.a(this.a).c(lVar.e);
            if (c3 != null && !TextUtils.isEmpty(c3.a())) {
                lVar.f = c3.a();
            }
            com.baidu.android.pushservice.b.b.a(this.a).g(lVar.e);
        }
        return a(new z(lVar, this.a));
    }

    private void i(Intent intent) {
        l lVar = new l(intent);
        int intExtra = intent.getIntExtra("fetch_type", 1);
        int intExtra2 = intent.getIntExtra("fetch_num", 1);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_FETCH ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new m(lVar, this.a, intExtra, intExtra2));
    }

    private void j(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_COUNT ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.c.h(lVar, this.a));
    }

    private void k(Intent intent) {
        l lVar = new l(intent);
        String[] stringArrayExtra = intent.getStringArrayExtra("msg_ids");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_DELETE ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new k(lVar, this.a, stringArrayExtra));
    }

    private void l(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new o(lVar, this.a, stringExtra));
    }

    private void m(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("tags");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new w(lVar, this.a, stringExtra));
    }

    private void n(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("tags");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.c.j(lVar, this.a, stringExtra));
    }

    private void o(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< ACTION_GUNBIND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new r(lVar, this.a, stringExtra));
    }

    private void p(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_GINFO ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.c.p(lVar, this.a, stringExtra));
    }

    private void q(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new s(lVar, this.a));
    }

    private void r(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_GLIST ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new q(lVar, this.a));
    }

    private void s(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        int intExtra = intent.getIntExtra("group_fetch_type", 1);
        int intExtra2 = intent.getIntExtra("group_fetch_num", 1);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_FETCHGMSG ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "gid:" + stringExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "fetchType:" + intExtra);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "fetchNum:" + intExtra2);
        a(new n(lVar, this.a, stringExtra, intExtra, intExtra2));
    }

    private void t(Intent intent) {
        l lVar = new l(intent);
        String stringExtra = intent.getStringExtra("gid");
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_COUNTGMSG ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "gid:" + stringExtra);
        a(new com.baidu.android.pushservice.c.i(lVar, this.a, stringExtra));
    }

    private void u(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_ONLINE ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new t(lVar, this.a));
    }

    private void v(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_SEND ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.c.u(lVar, this.a, intent.getStringExtra("push_ msg")));
    }

    private void w(Intent intent) {
        l lVar = new l(intent);
        com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< METHOD_SEND_MSG_TO_USER ", this.a);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "packageName:" + lVar.e);
        com.baidu.android.pushservice.e.a.c("RegistrationService", "accessToken:" + lVar.d);
        a(new v(lVar, this.a, intent.getStringExtra("app_id"), intent.getStringExtra("user_id"), intent.getStringExtra("push_ msg_key"), intent.getStringExtra("push_ msg")));
    }

    private void x(Intent intent) {
        com.baidu.android.pushservice.e.a.c("RegistrationService", "<<< handleSendAppStat ");
        if (this.b == null) {
            this.b = new p(this.a);
        }
        this.b.a();
        this.b.a(false, (com.baidu.android.pushservice.h.g) null);
    }

    private void y(Intent intent) {
        if (this.b == null) {
            this.b = new p(this.a);
        }
        this.b.a(intent.getBooleanExtra("force_send", false), (com.baidu.android.pushservice.h.g) null);
    }

    private void z(Intent intent) {
        PushSettings.a(this.a, 0);
    }

    public boolean a(Intent intent) {
        boolean z;
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return false;
        }
        com.baidu.android.pushservice.e.a.c("RegistrationService", "RegistrationSerice handleIntent : " + intent);
        String action = intent.getAction();
        u.b("handleIntent#action = " + action, this.a);
        if ("com.baidu.android.pushservice.action.OPENDEBUGMODE".equals(action)) {
            PushSettings.enableDebugMode(this.a, true);
            com.baidu.android.pushservice.e.b.a("RegistrationService", "<<<debugMode is open", this.a);
            return true;
        } else if ("com.baidu.android.pushservice.action.CLOSEDEBUGMODE".equals(action)) {
            PushSettings.enableDebugMode(this.a, false);
            com.baidu.android.pushservice.e.b.a("RegistrationService", "<<<debugMode is close", this.a);
            return true;
        } else if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).handle(this.a, action, intent.getData().getHost());
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
            if (u.b(this.a, publicMsg)) {
                publicMsg.handlePrivateNotification(this.a, action, intent.getStringExtra(PbActivityConfig.KEY_MSG_ID), intent.getStringExtra("app_id"));
                return true;
            }
            return true;
        } else if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
            u.b("push_passthrough: receive  click delete and notified action", this.a);
            com.baidu.android.pushservice.e.a.c("RegistrationService", "handle passthrough notification " + action);
            com.baidu.android.pushservice.f.k.a(this.a, intent.hasExtra(PbActivityConfig.KEY_MSG_ID) ? intent.getStringExtra(PbActivityConfig.KEY_MSG_ID) : null, intent.hasExtra("app_id") ? intent.getStringExtra("app_id") : null, action);
            return true;
        } else if ("com.baidu.android.pushservice.action.media.CLICK".equals(action) || "com.baidu.android.pushservice.action.media.DELETE".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).handleRichMediaNotification(this.a, action, intent.getStringExtra("app_id"));
            return true;
        } else if ("com.baidu.android.pushservice.action.lightapp.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.lightapp.notification.DELETE".equals(action)) {
            return true;
        } else {
            if ("com.baidu.android.pushservice.action.alarm.message".equals(action)) {
                com.baidu.android.pushservice.message.k kVar = (com.baidu.android.pushservice.message.k) intent.getSerializableExtra("tinyMessageHead");
                byte[] byteArrayExtra = intent.getByteArrayExtra("msgBody");
                kVar.a(false);
                if (com.baidu.android.pushservice.h.o.c(this.a, kVar.h()).f == 0) {
                    com.baidu.android.pushservice.h.o.d(this.a, kVar.h());
                    com.baidu.android.pushservice.e.a.c("RegistrationService", "message is invalid ");
                    return true;
                }
                com.baidu.android.pushservice.message.a.a aVar = new com.baidu.android.pushservice.message.a.a(this.a);
                if (aVar != null) {
                    aVar.a(kVar, byteArrayExtra);
                    com.baidu.android.pushservice.e.a.c("RegistrationService", "handle message that is not alarm message ");
                }
            }
            if ("com.baidu.pushservice.action.TOKEN".equals(action)) {
                com.baidu.android.pushservice.e.b.a("RegistrationService", "<<< ACTION_TOKEN ", this.a);
                if (j.a(this.a).c()) {
                    return true;
                }
                j.a(this.a).a(this.a, true, null);
                return true;
            } else if (PushConstants.ACTION_METHOD.equals(action)) {
                String stringExtra = intent.getStringExtra(PushConstants.EXTRA_METHOD);
                if (PushConstants.METHOD_BIND.equals(stringExtra)) {
                    b(intent);
                    z = true;
                } else if ("method_webapp_bind_from_deeplink".equals(stringExtra)) {
                    PushManager.startWork(this.a, 3, intent.getStringExtra("com.baidu.pushservice.webapp.apikey"));
                    z = true;
                } else if ("method_deal_webapp_bind_intent".equals(stringExtra)) {
                    c(intent);
                    z = true;
                } else if ("method_deal_lapp_bind_intent".equals(stringExtra)) {
                    z = true;
                } else if ("method_get_lapp_bind_state".equals(stringExtra)) {
                    z = true;
                } else if ("method_sdk_bind".equals(stringExtra)) {
                    d(intent);
                    z = true;
                } else if ("method_unbind".equals(stringExtra)) {
                    e(intent);
                    z = true;
                } else if ("method_sdk_unbind".equals(stringExtra)) {
                    f(intent);
                    z = true;
                } else if ("method_lapp_unbind".equals(stringExtra)) {
                    g(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(stringExtra)) {
                    h(intent);
                    z = true;
                } else if ("method_fetch".equals(stringExtra)) {
                    i(intent);
                    z = true;
                } else if ("method_count".equals(stringExtra)) {
                    j(intent);
                    z = true;
                } else if ("method_delete".equals(stringExtra)) {
                    k(intent);
                    z = true;
                } else if ("method_gbind".equals(stringExtra)) {
                    l(intent);
                    z = true;
                } else if ("method_set_tags".equals(stringExtra) || "method_set_sdk_tags".equals(stringExtra) || "method_set_lapp_tags".equals(stringExtra)) {
                    m(intent);
                    z = true;
                } else if ("method_del_tags".equals(stringExtra) || "method_del_sdk_tags".equals(stringExtra) || "method_del_lapp_tags".equals(stringExtra)) {
                    n(intent);
                    z = true;
                } else if ("method_gunbind".equals(stringExtra)) {
                    o(intent);
                    z = true;
                } else if ("method_ginfo".equals(stringExtra)) {
                    p(intent);
                    z = true;
                } else if ("method_glist".equals(stringExtra)) {
                    r(intent);
                    z = true;
                } else if ("method_listtags".equals(stringExtra) || "method_list_sdk_tags".equals(stringExtra) || "method_list_lapp_tags".equals(stringExtra)) {
                    q(intent);
                    z = true;
                } else if ("method_fetchgmsg".equals(stringExtra)) {
                    s(intent);
                    z = true;
                } else if ("method_countgmsg".equals(stringExtra)) {
                    t(intent);
                    z = true;
                } else if ("method_online".equals(stringExtra)) {
                    u(intent);
                    z = true;
                } else if ("method_send".equals(stringExtra)) {
                    v(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra)) {
                    x(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.SEND_LBS".equals(stringExtra)) {
                    y(intent);
                    z = true;
                } else if ("com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra)) {
                    z(intent);
                    z = true;
                } else if ("method_send_msg_to_user".equals(stringExtra)) {
                    w(intent);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } else {
                return false;
            }
        }
    }

    public boolean a(com.baidu.android.pushservice.c.a aVar) {
        try {
            com.baidu.android.pushservice.g.d.a().a(aVar);
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.e.b.a("RegistrationService", e, this.a);
            return false;
        }
    }
}
