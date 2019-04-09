package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context acE;
    final /* synthetic */ Throwable acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.acE = context;
        this.acF = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.acE, i.j(g.a(this.acE, this.acF, false)));
            k.o(this.acE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
