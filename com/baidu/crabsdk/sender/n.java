package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context alb;
    final /* synthetic */ Throwable alc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.alb = context;
        this.alc = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.alb, i.d(g.a(this.alb, this.alc, false)));
            k.n(this.alb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
