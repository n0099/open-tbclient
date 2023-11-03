package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.a0.m;
/* loaded from: classes.dex */
public class RegistrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.android.pushservice.t.a.a(context.getApplicationContext()).a(0);
        intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            m.a(context, intent, context.getPackageName());
        } catch (Exception unused) {
        }
    }
}
