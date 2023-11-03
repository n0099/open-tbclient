package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class PushSystemNotifyReceiver extends BroadcastReceiver {
    public String a = PushSystemNotifyReceiver.class.getName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.android.pushservice.t.a.a(context.getApplicationContext()).a(4);
        intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            Utility.a(context, this.a, intent);
            com.baidu.android.pushservice.l.d.C(context.getApplicationContext());
        } catch (Exception unused) {
        }
    }
}
