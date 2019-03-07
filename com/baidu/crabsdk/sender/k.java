package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class k implements Runnable {
    final /* synthetic */ Context acx;
    final /* synthetic */ Throwable acy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.acx = context;
        this.acy = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.acx, f.j(d.a(this.acx, this.acy, false)));
            h.o(this.acx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
