package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
/* loaded from: classes8.dex */
public class CommandService extends Service {
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
            m.a("CommandService#onStartCommand#action = " + action, this);
            try {
                if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action)) {
                    m.a("push_passthrough: receive click action", getApplicationContext());
                    new b.a(this).a("0").b(intent.hasExtra("msg_id") ? intent.getStringExtra("msg_id") : null).a(System.currentTimeMillis()).b(601011L).a();
                    stopSelf();
                } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                    ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(getApplicationContext(), action, intent.getStringExtra("msg_id"), intent.getStringExtra("app_id"), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                    stopSelf();
                } else {
                    stopSelf();
                }
            } catch (RuntimeException e) {
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e)).a();
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
