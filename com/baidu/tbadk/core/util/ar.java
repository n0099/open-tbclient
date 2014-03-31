package com.baidu.tbadk.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class ar extends BroadcastReceiver {
    final /* synthetic */ aq a;

    private ar(aq aqVar) {
        this.a = aqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(aq aqVar, byte b) {
        this(aqVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
