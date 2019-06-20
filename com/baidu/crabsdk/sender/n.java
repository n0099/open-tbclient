package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aar;
    final /* synthetic */ Throwable aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aar = context;
        this.aas = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aar, i.i(g.a(this.aar, this.aas, false)));
            k.o(this.aar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
