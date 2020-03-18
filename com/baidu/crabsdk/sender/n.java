package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context SO;
    final /* synthetic */ Throwable SQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.SO = context;
        this.SQ = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.SO, i.g(g.a(this.SO, this.SQ, false)));
            k.n(this.SO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
