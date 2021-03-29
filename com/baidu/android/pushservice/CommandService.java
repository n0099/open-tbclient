package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
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
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        m.a("CommandService#onStartCommand#action = " + action, this);
        try {
        } catch (RuntimeException e2) {
            new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
        }
        if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action)) {
            m.a("push_passthrough: receive click action", getApplicationContext());
            new b.a(this).a("0").b(intent.hasExtra("msg_id") ? intent.getStringExtra("msg_id") : null).a(System.currentTimeMillis()).b(601011L).a();
            stopSelf();
            return 2;
        }
        if (!"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            stopSelf();
            return 2;
        }
        ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(getApplicationContext(), action, intent.getStringExtra("msg_id"), intent.getStringExtra(Constants.APP_ID), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
