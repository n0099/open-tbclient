package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BroadcastReceiver {
    final /* synthetic */ w a;

    private z(w wVar) {
        this.a = wVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Handler handler;
        Handler handler2;
        String str;
        if (context != null) {
            handler = this.a.f;
            if (handler == null) {
                return;
            }
            this.a.k();
            handler2 = this.a.f;
            handler2.obtainMessage(41).sendToTarget();
            str = w.a;
            ap.a(str, "wifi manager receive new wifi...");
        }
    }
}
