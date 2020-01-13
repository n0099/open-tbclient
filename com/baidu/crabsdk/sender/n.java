package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n implements Runnable {
    final /* synthetic */ Context Re;
    final /* synthetic */ Throwable Rf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.Re = context;
        this.Rf = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.Re, i.g(g.a(this.Re, this.Rf, false)));
            k.o(this.Re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
