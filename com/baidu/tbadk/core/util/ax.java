package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ax extends BroadcastReceiver {
    final /* synthetic */ aw this$0;

    private ax(aw awVar) {
        this.this$0 = awVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(aw awVar, ax axVar) {
        this(awVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.b();
    }
}
