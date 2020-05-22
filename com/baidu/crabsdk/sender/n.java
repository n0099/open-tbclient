package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context amK;
    final /* synthetic */ Throwable amL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.amK = context;
        this.amL = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.amK, i.e(g.a(this.amK, this.amL, false)));
            k.n(this.amK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
