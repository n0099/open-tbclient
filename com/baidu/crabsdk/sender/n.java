package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context acD;
    final /* synthetic */ Throwable acE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.acD = context;
        this.acE = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.acD, i.j(g.a(this.acD, this.acE, false)));
            k.o(this.acD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
