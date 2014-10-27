package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ f this$0;

    private j(f fVar) {
        this.this$0 = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(f fVar, j jVar) {
        this(fVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("intent_data_multiprocess_type", 0);
        if (intExtra == 1) {
            if (!f.b(this.this$0)) {
                this.this$0.save();
            }
        } else if (intExtra == 2 && !f.b(this.this$0)) {
            f.c(this.this$0);
        }
    }
}
