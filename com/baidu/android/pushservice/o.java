package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class o extends BroadcastReceiver {
    final /* synthetic */ PushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PushService pushService) {
        this.a = pushService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.d();
    }
}
