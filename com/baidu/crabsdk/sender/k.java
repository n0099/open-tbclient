package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    final /* synthetic */ Context Tv;
    final /* synthetic */ Throwable Tw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.Tv = context;
        this.Tw = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.Tv, f.j(d.a(this.Tv, this.Tw, false)));
            h.o(this.Tv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
