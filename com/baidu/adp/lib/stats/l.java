package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class l extends BroadcastReceiver {
    final /* synthetic */ h this$0;

    private l(h hVar) {
        this.this$0 = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(h hVar, l lVar) {
        this(hVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        h.a(this.this$0);
    }
}
