package com.baidu.adp.lib.stats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class h extends BroadcastReceiver {
    final /* synthetic */ g a;

    private h(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(g gVar, byte b) {
        this(gVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.a.a(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }
    }
}
