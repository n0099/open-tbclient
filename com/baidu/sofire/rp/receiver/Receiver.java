package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.rp.f.a;
import com.baidu.sofire.rp.f.b;
/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        b.at(context).a();
                    } else if (action.equals("com.b.r.p") && intent != null) {
                        a.a(context, new com.baidu.sofire.rp.a.a(context).b() * 3600000);
                        b at = b.at(context);
                        Message message = new Message();
                        message.what = 2;
                        at.QP.QL.sendMessage(message);
                    }
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }
}
