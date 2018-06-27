package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b.f;
import com.baidu.sofire.e;
/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        f.a(context).a();
                    } else if (action.equals("com.b.r.p") && intent != null) {
                        e eVar = new e(context);
                        com.baidu.sofire.b.e.a(context, eVar.e() * 3600000);
                        f a = f.a(context);
                        Message message = new Message();
                        message.what = 2;
                        a.a.a.sendMessage(message);
                        eVar.f.putLong("re_last_ofline_time", System.currentTimeMillis());
                        eVar.f.commit();
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }
}
