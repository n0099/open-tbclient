package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class h extends BroadcastReceiver {
    final /* synthetic */ d this$0;

    private h(d dVar) {
        this.this$0 = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(d dVar, h hVar) {
        this(dVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("intent_data_multiprocess_type", 0);
        if (intExtra == 1) {
            if (!d.b(this.this$0)) {
                this.this$0.f();
            }
        } else if (intExtra == 2 && !d.b(this.this$0)) {
            d.c(this.this$0);
        }
    }
}
