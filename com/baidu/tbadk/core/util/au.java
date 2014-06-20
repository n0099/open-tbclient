package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class au extends BroadcastReceiver {
    final /* synthetic */ at this$0;

    private au(at atVar) {
        this.this$0 = atVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(at atVar, au auVar) {
        this(atVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.b();
    }
}
