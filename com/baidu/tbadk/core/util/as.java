package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class as extends BroadcastReceiver {
    final /* synthetic */ ar a;

    private as(ar arVar) {
        this.a = arVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(ar arVar, as asVar) {
        this(arVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
