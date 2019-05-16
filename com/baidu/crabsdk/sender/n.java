package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aas;
    final /* synthetic */ Throwable aat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aas = context;
        this.aat = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aas, i.i(g.a(this.aas, this.aat, false)));
            k.o(this.aas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
