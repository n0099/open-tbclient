package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes.dex */
public class ConnectReceiver extends BroadcastReceiver {
    public a a;

    /* loaded from: classes.dex */
    public interface a {
        void a(Runnable runnable);
    }

    public ConnectReceiver(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            this.a.a(new Runnable() { // from class: com.baidu.sapi2.passhost.hostsdk.service.ConnectReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Apn.handleChange(context.getApplicationContext());
                }
            });
        }
    }
}
