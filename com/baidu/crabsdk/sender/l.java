package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class l implements Runnable {
    final /* synthetic */ Context amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.amK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.k(this.amK);
    }
}
