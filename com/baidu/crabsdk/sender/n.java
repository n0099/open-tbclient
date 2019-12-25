package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class n implements Runnable {
    final /* synthetic */ Context QZ;
    final /* synthetic */ Throwable Ra;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.QZ = context;
        this.Ra = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.QZ, i.g(g.a(this.QZ, this.Ra, false)));
            k.o(this.QZ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
