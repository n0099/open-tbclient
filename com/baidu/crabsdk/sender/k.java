package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    final /* synthetic */ Context Tw;
    final /* synthetic */ Throwable Tx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.Tw = context;
        this.Tx = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.Tw, f.j(d.a(this.Tw, this.Tx, false)));
            h.o(this.Tw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
