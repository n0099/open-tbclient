package com.baidu.adp.lib.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BroadcastReceiver {
    final /* synthetic */ a this$0;

    private d(a aVar) {
        this.this$0 = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent != null && intent.getIntExtra("intent_data_multiprocess_type", 0) == 4) {
            z = this.this$0.wu;
            if (!z) {
                com.baidu.adp.lib.stats.b.i.iw().iz();
            }
        }
    }
}
