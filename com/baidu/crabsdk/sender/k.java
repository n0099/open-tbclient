package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class k implements Runnable {
    final /* synthetic */ Context YK;
    final /* synthetic */ Throwable YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.YK = context;
        this.YL = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.YK, f.j(d.a(this.YK, this.YL, false)));
            h.o(this.YK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
