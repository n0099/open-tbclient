package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class i extends BroadcastReceiver {
    final /* synthetic */ d this$0;

    private i(d dVar) {
        this.this$0 = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(d dVar, i iVar) {
        this(dVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.a(this.this$0);
    }
}
