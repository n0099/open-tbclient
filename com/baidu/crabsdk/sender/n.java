package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context KU;
    final /* synthetic */ Throwable KV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.KU = context;
        this.KV = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.KU, i.g(g.a(this.KU, this.KV, false)));
            k.o(this.KU);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
