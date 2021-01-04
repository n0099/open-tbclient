package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context arJ;
    final /* synthetic */ Throwable arK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.arJ = context;
        this.arK = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.arJ, i.e(g.a(this.arJ, this.arK, false)));
            k.n(this.arJ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
