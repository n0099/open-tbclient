package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {
    final /* synthetic */ h this$0;

    private j(h hVar) {
        this.this$0 = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(h hVar, j jVar) {
        this(hVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.this$0.a(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }
    }
}
