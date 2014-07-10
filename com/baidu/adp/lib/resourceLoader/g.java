package com.baidu.adp.lib.resourceLoader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class g extends BroadcastReceiver {
    private g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(g gVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BdResourceLoaderNetHelperStatic.a(com.baidu.adp.lib.network.willdelete.h.a());
    }
}
