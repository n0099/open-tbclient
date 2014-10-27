package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BroadcastReceiver {
    final /* synthetic */ f this$0;

    private h(f fVar) {
        this.this$0 = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(f fVar, h hVar) {
        this(fVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.b(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }
    }
}
