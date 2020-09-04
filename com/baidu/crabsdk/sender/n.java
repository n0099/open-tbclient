package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aoX;
    final /* synthetic */ Throwable aoY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aoX = context;
        this.aoY = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aoX, i.e(g.a(this.aoX, this.aoY, false)));
            k.n(this.aoX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
