package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i implements Runnable {
    final /* synthetic */ Context acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.acx = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.l(this.acx);
    }
}
