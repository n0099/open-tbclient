package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class aj extends BroadcastReceiver {
    final /* synthetic */ ai this$0;

    private aj(ai aiVar) {
        this.this$0 = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(ai aiVar, aj ajVar) {
        this(aiVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.sF();
    }
}
