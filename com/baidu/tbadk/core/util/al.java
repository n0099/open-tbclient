package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class al extends BroadcastReceiver {
    final /* synthetic */ ak this$0;

    private al(ak akVar) {
        this.this$0 = akVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(ak akVar, al alVar) {
        this(akVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.b();
    }
}
