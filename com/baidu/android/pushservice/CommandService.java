package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.pushservice.message.PublicMsg;
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
        if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(action)) {
            if (intent.hasExtra("msg_id")) {
                intent.getStringExtra("msg_id");
            }
            stopSelf();
            return 2;
        }
        if (!"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
            stopSelf();
            return 2;
        }
        String stringExtra = intent.getStringExtra("app_id");
        ((PublicMsg) intent.getParcelableExtra("public_msg")).handlePrivateNotification(getApplicationContext(), action, intent.getStringExtra("msg_id"), stringExtra, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"), 0, intent.getStringExtra("notification_log_ext"));
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
