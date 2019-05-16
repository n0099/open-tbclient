package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements Runnable {
    final /* synthetic */ Context aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.aas = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.l(this.aas);
    }
}
