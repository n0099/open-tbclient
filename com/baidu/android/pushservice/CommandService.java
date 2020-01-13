package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class CommandService extends Service {
    private void a(Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.startsWith("com.baidu.android.pushservice.action")) {
            return;
        }
        String c = l.c(this, getPackageName(), action);
        if (TextUtils.isEmpty(c)) {
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
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            intent.setPackage(stringExtra);
            intent.setClassName(stringExtra, "com.baidu.android.pushservice.PushService");
            intent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
            intent.putExtra("bd.cross.request.SENDING", false);
            getApplicationContext().startService(intent);
        } catch (Exception e) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
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
            l.b("CommandService#onStartCommand#action = " + action, this);
            try {
                if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(action) || "com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(action)) {
                    l.b("push_passthrough: receive  click delete and notified action", getApplicationContext());
                    com.baidu.android.pushservice.g.i.a(getApplicationContext(), intent.hasExtra("msg_id") ? intent.getStringExtra("msg_id") : null, intent.hasExtra(Constants.APP_ID) ? intent.getStringExtra(Constants.APP_ID) : null, action);
                    if (intent.getBooleanExtra("self_insert", false)) {
                        new m(this).a();
                    }
                    stopSelf();
                } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    String stringExtra = intent.getStringExtra(Constants.APP_ID);
                    String stringExtra2 = intent.getStringExtra("msg_id");
                    ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(getApplicationContext(), action, stringExtra2, stringExtra, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                    if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action)) {
                        m.a(getApplicationContext(), stringExtra2, "010203");
                    } else if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        m.a(getApplicationContext(), stringExtra2, "010204");
                    }
                    stopSelf();
                } else {
                    if ("reflect_receiver".equals(intent.hasExtra("command_type") ? intent.getStringExtra("command_type") : null)) {
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
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
