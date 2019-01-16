package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class k implements Runnable {
    final /* synthetic */ Context YT;
    final /* synthetic */ Throwable YU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.YT = context;
        this.YU = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.YT, f.j(d.a(this.YT, this.YU, false)));
            h.o(this.YT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
