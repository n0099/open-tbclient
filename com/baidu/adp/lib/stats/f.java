package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class f extends BroadcastReceiver {
    final /* synthetic */ d this$0;

    private f(d dVar) {
        this.this$0 = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(d dVar, f fVar) {
        this(dVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.a(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }
    }
}
