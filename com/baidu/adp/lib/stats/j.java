package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ g a;

    private j(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(g gVar, j jVar) {
        this(gVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        g.a(this.a);
    }
}
