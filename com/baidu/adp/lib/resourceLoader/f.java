package com.baidu.adp.lib.resourceLoader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.network.willdelete.h;
/* loaded from: classes.dex */
class f extends BroadcastReceiver {
    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BdResourceLoaderNetHelperStatic.a(h.a());
    }
}
