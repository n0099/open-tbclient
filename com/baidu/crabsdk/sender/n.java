package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aaO;
    final /* synthetic */ Throwable aaP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aaO = context;
        this.aaP = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aaO, i.i(g.a(this.aaO, this.aaP, false)));
            k.o(this.aaO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
