package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context alh;
    final /* synthetic */ Throwable ali;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.alh = context;
        this.ali = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.alh, i.d(g.a(this.alh, this.ali, false)));
            k.n(this.alh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
