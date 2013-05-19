package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class y extends BroadcastReceiver {
    final /* synthetic */ w a;

    private y(w wVar) {
        this.a = wVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || w.b(this.a) == null) {
            return;
        }
        w.c(this.a);
    }
}
