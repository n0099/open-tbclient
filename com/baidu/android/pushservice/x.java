package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.common.util.Util;
import com.baidu.android.pushservice.a.z;
import com.baidu.android.pushservice.message.PublicMsg;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private Context f638a;
    private com.baidu.android.pushservice.b.f b;
    private ExecutorService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Context context) {
        this.f638a = context;
        this.b = new com.baidu.android.pushservice.b.f(context);
        a.a(context);
        y.a();
        this.c = Executors.newFixedThreadPool(5, new com.baidu.android.pushservice.util.d("PushService-ApiThreadPool"));
    }

    private String a() {
        return Util.toMd5(("com.baidu.pushservice.singelinstancev1" + DeviceId.getDeviceID(this.f638a)).getBytes(), false);
    }

    private void b(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_BIND_NAME);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_BIND_STATUS, 0);
        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_PUSH_SDK_VERSION, 0);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_BIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", bindName:" + stringExtra + ", bindStatus:" + intExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
            Log.d("RegistrationService", "apiKey:" + lVar.i);
        }
        String d = a.a(this.f638a).d(lVar.e);
        if (TextUtils.isEmpty(lVar.i) || !a.a(this.f638a).a(lVar.e, lVar.i) || TextUtils.isEmpty(d)) {
            a(new com.baidu.android.pushservice.a.f(lVar, this.f638a, intExtra, stringExtra, intExtra2));
            return;
        }
        Intent intent2 = new Intent(PushConstants.ACTION_RECEIVE);
        intent2.putExtra(PushConstants.EXTRA_METHOD, lVar.f569a);
        intent2.putExtra(PushConstants.EXTRA_ERROR_CODE, 0);
        intent2.putExtra("content", d.getBytes());
        intent2.setFlags(32);
        intent2.putExtra(PushConstants.EXTRA_BIND_STATUS, intExtra);
        intent2.setPackage(lVar.e);
        if (b.a()) {
            Log.d("RegistrationService", "> sendResult to " + lVar.e + " ,method:" + lVar.f569a + " ,errorCode : 0 ,content : " + new String(d));
        }
        this.f638a.sendBroadcast(intent2);
        Log.e("RegistrationService", "loginValue already binded, no need to bind anymore");
    }

    private void c(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_UNBIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
            Log.d("RegistrationService", "apiKey:" + lVar.i);
        }
        if (!TextUtils.isEmpty(lVar.e) && !TextUtils.isEmpty(lVar.i)) {
            a.a(this.f638a).e(lVar.e);
        }
        a(new com.baidu.android.pushservice.a.y(lVar, this.f638a));
    }

    private void d(Intent intent) {
        d a2;
        String stringExtra = intent.getStringExtra("package_name");
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_ID);
        if ((stringExtra2 == null || stringExtra2.length() == 0) && (a2 = a.a(this.f638a).a(stringExtra)) != null) {
            stringExtra2 = a2.b;
        }
        String stringExtra3 = intent.getStringExtra(PushConstants.EXTRA_USER_ID);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_UNBIND_APP ");
            Log.d("RegistrationService", "packageName:" + stringExtra);
            Log.d("RegistrationService", "appid:" + stringExtra2);
            Log.d("RegistrationService", "userid:" + stringExtra3);
        }
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l();
        lVar.f569a = "com.baidu.android.pushservice.action.UNBINDAPP";
        lVar.e = stringExtra;
        lVar.f = stringExtra2;
        lVar.g = stringExtra3;
        a(new z(lVar, this.f638a));
    }

    private void e(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_FETCH_TYPE, 1);
        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_FETCH_NUM, 1);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_FETCH ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.m(lVar, this.f638a, intExtra, intExtra2));
    }

    private void f(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_COUNT ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.h(lVar, this.f638a));
    }

    private void g(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String[] stringArrayExtra = intent.getStringArrayExtra(PushConstants.EXTRA_MSG_IDS);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_DELETE ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.k(lVar, this.f638a, stringArrayExtra));
    }

    private void h(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        if (b.a()) {
            Log.d("RegistrationService", "<<< ACTION_GBIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.o(lVar, this.f638a, stringExtra));
    }

    private void i(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_TAGS);
        if (b.a()) {
            Log.d("RegistrationService", "<<< ACTION_GBIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.w(lVar, this.f638a, stringExtra));
    }

    private void j(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_TAGS);
        if (b.a()) {
            Log.d("RegistrationService", "<<< ACTION_GBIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.j(lVar, this.f638a, stringExtra));
    }

    private void k(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        if (b.a()) {
            Log.d("RegistrationService", "<<< ACTION_GUNBIND ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.r(lVar, this.f638a, stringExtra));
    }

    private void l(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_GINFO ");
            Log.d("RegistrationService", "packageName:" + lVar.e + ", gid:" + stringExtra);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.p(lVar, this.f638a, stringExtra));
    }

    private void m(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_GLIST ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.q(lVar, this.f638a));
    }

    private void n(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        int intExtra = intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_TYPE, 1);
        int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_GROUP_FETCH_NUM, 1);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_FETCHGMSG ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
            Log.d("RegistrationService", "gid:" + stringExtra);
            Log.d("RegistrationService", "fetchType:" + intExtra);
            Log.d("RegistrationService", "fetchNum:" + intExtra2);
        }
        a(new com.baidu.android.pushservice.a.n(lVar, this.f638a, stringExtra, intExtra, intExtra2));
    }

    private void o(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_GID);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_COUNTGMSG ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
            Log.d("RegistrationService", "gid:" + stringExtra);
        }
        a(new com.baidu.android.pushservice.a.i(lVar, this.f638a, stringExtra));
    }

    private void p(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_ONLINE ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.s(lVar, this.f638a));
    }

    private void q(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_SEND ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.t(lVar, this.f638a, intent.getStringExtra(PushConstants.EXTRA_MSG)));
    }

    private void r(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        if (b.a()) {
            Log.d("RegistrationService", "<<< METHOD_SEND_MSG_TO_SERVER ");
            Log.d("RegistrationService", "packageName:" + lVar.e);
            Log.d("RegistrationService", "accessToken:" + lVar.d);
        }
        a(new com.baidu.android.pushservice.a.u(lVar, this.f638a, intent.getStringExtra(PushConstants.EXTRA_APP_ID), intent.getStringExtra(PushConstants.EXTRA_CB_URL), intent.getStringExtra(PushConstants.EXTRA_MSG)));
    }

    private void s(Intent intent) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l(intent);
        Log.d("RegistrationService", "<<< METHOD_SEND_MSG_TO_USER ");
        Log.d("RegistrationService", "packageName:" + lVar.e);
        Log.d("RegistrationService", "accessToken:" + lVar.d);
        a(new com.baidu.android.pushservice.a.v(lVar, this.f638a, intent.getStringExtra(PushConstants.EXTRA_APP_ID), intent.getStringExtra(PushConstants.EXTRA_USER_ID), intent.getStringExtra(PushConstants.EXTRA_MSG_KEY), intent.getStringExtra(PushConstants.EXTRA_MSG)));
    }

    private void t(Intent intent) {
        this.b.a();
    }

    public void a(com.baidu.android.pushservice.a.a aVar) {
        this.c.submit(aVar);
    }

    public void a(String str, int i, String str2) {
        com.baidu.android.pushservice.a.l lVar = new com.baidu.android.pushservice.a.l();
        lVar.f569a = "com.baidu.android.pushservice.action.UNBIND";
        if (i == 0) {
            lVar.i = str2;
        } else if (i == 2) {
            lVar.h = str2;
            lVar.f = str;
        }
        if (i != -1) {
            if (b.a()) {
                Log.i("RegistrationService", "Event = " + lVar);
            }
            a(new com.baidu.android.pushservice.a.y(lVar, this.f638a));
        }
    }

    public boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        if (b.a()) {
            Log.d("RegistrationService", "RegistrationSerice handleIntent : " + intent);
        }
        String action = intent.getAction();
        if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).a(this.f638a, action, intent.getData().getHost());
            return true;
        } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).a(this.f638a, action, intent.getStringExtra("msg_id"), intent.getStringExtra(PushConstants.EXTRA_APP_ID));
            return true;
        } else if ("com.baidu.android.pushservice.action.media.CLICK".equals(action) || "com.baidu.android.pushservice.action.media.DELETE".equals(action)) {
            ((PublicMsg) intent.getParcelableExtra("public_msg")).a(this.f638a, action);
            return true;
        } else if ("com.baidu.pushservice.action.TOKEN".equals(action)) {
            if (b.a()) {
                Log.d("RegistrationService", "<<< ACTION_TOKEN ");
            }
            if (!y.a().e()) {
                y.a().a(this.f638a, true);
            }
            return true;
        } else if (PushConstants.ACTION_METHOD.equals(action)) {
            String stringExtra = intent.getStringExtra("method_version");
            LocalServerSocket localServerSocket = null;
            if (stringExtra != null && !"V2".equals(stringExtra) && stringExtra.equals("V1")) {
                try {
                    localServerSocket = new LocalServerSocket(a());
                } catch (Exception e) {
                    if (b.a()) {
                        Log.d("RegistrationService", "---V1 Socket Adress (" + a() + ") in use --- @ " + this.f638a.getPackageName());
                    }
                }
                if (localServerSocket == null) {
                    Intent b = com.baidu.android.pushservice.util.n.b(this.f638a, "com.baidu.pushservice.action.start.SERVICEINFO");
                    Intent b2 = com.baidu.android.pushservice.util.n.b(this.f638a, "com.baidu.moplus.action.start.SERVICEINFO");
                    if (b == null && b2 == null) {
                        return false;
                    }
                    if (b != null) {
                        String stringExtra2 = b.getStringExtra("method_version");
                        if ("V1".equals(stringExtra2)) {
                            if (b.a()) {
                                Log.d("RegistrationService", "Method Version : " + stringExtra2);
                            }
                            return false;
                        }
                    }
                    if (b2 != null) {
                        String stringExtra3 = b2.getStringExtra("method_version");
                        if ("V1".equals(stringExtra3)) {
                            if (b.a()) {
                                Log.d("RegistrationService", "Method Version : " + stringExtra3);
                            }
                            return false;
                        }
                    }
                }
            }
            String stringExtra4 = intent.getStringExtra(PushConstants.EXTRA_METHOD);
            if (PushConstants.METHOD_BIND.equals(stringExtra4)) {
                b(intent);
                z = true;
            } else if (PushConstants.METHOD_UNBIND.equals(stringExtra4)) {
                c(intent);
                z = true;
            } else if ("com.baidu.android.pushservice.action.UNBINDAPP".equals(stringExtra4)) {
                d(intent);
                z = true;
            } else if (PushConstants.METHOD_FETCH.equals(stringExtra4)) {
                e(intent);
                z = true;
            } else if (PushConstants.METHOD_COUNT.equals(stringExtra4)) {
                f(intent);
                z = true;
            } else if (PushConstants.METHOD_DELETE.equals(stringExtra4)) {
                g(intent);
                z = true;
            } else if (PushConstants.METHOD_GBIND.equals(stringExtra4)) {
                h(intent);
                z = true;
            } else if (PushConstants.METHOD_SET_TAGS.equals(stringExtra4)) {
                i(intent);
                z = true;
            } else if (PushConstants.METHOD_DEL_TAGS.equals(stringExtra4)) {
                j(intent);
                z = true;
            } else if (PushConstants.METHOD_GUNBIND.equals(stringExtra4)) {
                k(intent);
                z = true;
            } else if (PushConstants.METHOD_GINFO.equals(stringExtra4)) {
                l(intent);
                z = true;
            } else if (PushConstants.METHOD_GLIST.equals(stringExtra4)) {
                m(intent);
                z = true;
            } else if (PushConstants.METHOD_FETCHGMSG.equals(stringExtra4)) {
                n(intent);
                z = true;
            } else if (PushConstants.METHOD_COUNTGMSG.equals(stringExtra4)) {
                o(intent);
                z = true;
            } else if (PushConstants.METHOD_ONLINE.equals(stringExtra4)) {
                p(intent);
                z = true;
            } else if (PushConstants.METHOD_SEND.equals(stringExtra4)) {
                q(intent);
                z = true;
            } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra4)) {
                t(intent);
                z = true;
            } else if (PushConstants.METHOD_SEND_MSG_TO_SERVER.equals(stringExtra4)) {
                r(intent);
                z = true;
            } else if (PushConstants.METHOD_SEND_MSG_TO_USER.equals(stringExtra4)) {
                s(intent);
                z = true;
            }
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return z;
        } else {
            return false;
        }
    }
}
