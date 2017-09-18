package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class CommandService extends Service {
    private void a(Intent intent) {
        String c = p.c(this, getPackageName(), intent.getAction());
        p.b("CommandService#onStartCommand#reflectReceiver#recevier = " + c, this);
        if (TextUtils.isEmpty(c)) {
            com.baidu.android.pushservice.g.a.b("CommandService", " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            Class<?> cls = Class.forName(c);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            String[] strArr = {"android.content.Context", "android.content.Intent"};
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(getPackageName(), c);
            method.invoke(newInstance, getApplicationContext(), intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("CommandService", e);
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
            String stringExtra2 = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            intent.setPackage(stringExtra2);
            intent.setClassName(stringExtra2, stringExtra);
            intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
            intent.putExtra("bd.cross.request.SENDING", false);
            getApplicationContext().startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("CommandService", e);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.baidu.android.pushservice.g.a.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        com.baidu.android.pushservice.g.a.c("CommandService", "-- CommandService oncreate -- ");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            com.baidu.android.pushservice.g.a.c("CommandService", "action = " + action);
            p.b("CommandService#onStartCommand#action = " + action, this);
            try {
                if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
                    p.b("push_passthrough: receive  click delete and notified action", getApplicationContext());
                    com.baidu.android.pushservice.g.a.c("CommandService", "handle passthrough notification " + action);
                    k.a(getApplicationContext(), intent.hasExtra(PbActivityConfig.KEY_MSG_ID) ? intent.getStringExtra(PbActivityConfig.KEY_MSG_ID) : null, intent.hasExtra("app_id") ? intent.getStringExtra("app_id") : null, action);
                    if (intent.getBooleanExtra("self_insert", false)) {
                        new com.baidu.android.pushservice.h.p(this).a();
                    }
                    stopSelf();
                } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    String stringExtra = intent.getStringExtra("app_id");
                    String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_MSG_ID);
                    ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(getApplicationContext(), action, stringExtra2, stringExtra);
                    if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action)) {
                        com.baidu.android.pushservice.h.p.a(getApplicationContext(), stringExtra2, "010203");
                    } else if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        com.baidu.android.pushservice.h.p.a(getApplicationContext(), stringExtra2, "010204");
                    }
                    stopSelf();
                } else {
                    if (intent.hasExtra("command_type")) {
                        r0 = intent.getStringExtra("command_type");
                        com.baidu.android.pushservice.g.a.c("CommandService", "-- command_type -- " + r0);
                    }
                    if ("reflect_receiver".equals(r0)) {
                        a(intent);
                    } else if (intent.hasExtra("bd.cross.request.COMMAND_TYPE")) {
                        String stringExtra3 = intent.getStringExtra("bd.cross.request.COMMAND_TYPE");
                        if ("bd.cross.command.MESSAGE_DELIVER".equals(stringExtra3)) {
                            a(intent);
                        } else if ("bd.cross.command.MESSAGE_ACK".equals(stringExtra3)) {
                            b(intent);
                        }
                    }
                    stopSelf();
                }
            } catch (RuntimeException e) {
                com.baidu.android.pushservice.g.a.e("CommandService", "runtime e: " + e);
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
