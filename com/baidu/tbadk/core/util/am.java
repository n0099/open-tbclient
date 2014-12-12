package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class am extends BroadcastReceiver {
    final /* synthetic */ al this$0;

    private am(al alVar) {
        this.this$0 = alVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(al alVar, am amVar) {
        this(alVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.pm();
    }
}
