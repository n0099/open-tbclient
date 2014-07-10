package com.baidu.android.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class a extends BroadcastReceiver {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a(intent);
    }
}
