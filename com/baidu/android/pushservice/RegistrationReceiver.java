package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes5.dex */
public class RegistrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            l.a(context, intent, context.getPackageName());
        } catch (Exception e) {
        }
    }
}
