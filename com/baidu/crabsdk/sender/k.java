package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    final /* synthetic */ Context VY;
    final /* synthetic */ Throwable VZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.VY = context;
        this.VZ = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.VY, f.k(d.a(this.VY, this.VZ, false)));
            h.o(this.VY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
