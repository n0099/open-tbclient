package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context SK;
    final /* synthetic */ Throwable SL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.SK = context;
        this.SL = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.SK, i.g(g.a(this.SK, this.SL, false)));
            k.o(this.SK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
