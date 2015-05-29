package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ag extends BroadcastReceiver {
    final /* synthetic */ af this$0;

    private ag(af afVar) {
        this.this$0 = afVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(af afVar, ag agVar) {
        this(afVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.ti();
    }
}
