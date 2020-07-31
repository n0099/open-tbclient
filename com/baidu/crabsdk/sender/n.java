package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class n implements Runnable {
    final /* synthetic */ Context anY;
    final /* synthetic */ Throwable anZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.anY = context;
        this.anZ = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.anY, i.e(g.a(this.anY, this.anZ, false)));
            k.n(this.anY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
