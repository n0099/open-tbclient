package com.baidu.adp.lib.stats.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class c extends BroadcastReceiver {
    final /* synthetic */ b this$0;

    private c(b bVar) {
        this.this$0 = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(b bVar, c cVar) {
        this(bVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.f(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }
    }
}
