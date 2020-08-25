package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aoV;
    final /* synthetic */ Throwable aoW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aoV = context;
        this.aoW = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aoV, i.e(g.a(this.aoV, this.aoW, false)));
            k.n(this.aoV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
