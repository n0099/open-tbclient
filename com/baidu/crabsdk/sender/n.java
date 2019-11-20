package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {
    final /* synthetic */ Context Ku;
    final /* synthetic */ Throwable Kv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.Ku = context;
        this.Kv = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.Ku, i.g(g.a(this.Ku, this.Kv, false)));
            k.o(this.Ku);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
