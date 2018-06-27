package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    final /* synthetic */ Context Ty;
    final /* synthetic */ Throwable Tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.Ty = context;
        this.Tz = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.Ty, f.j(d.a(this.Ty, this.Tz, false)));
            h.o(this.Ty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
