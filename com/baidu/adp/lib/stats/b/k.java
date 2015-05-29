package com.baidu.adp.lib.stats.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class k extends BroadcastReceiver {
    final /* synthetic */ i this$0;

    private k(i iVar) {
        this.this$0 = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(i iVar, k kVar) {
        this(iVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.setUid(intent.getStringExtra("intent_data_userid"));
            this.this$0.ix();
        }
    }
}
