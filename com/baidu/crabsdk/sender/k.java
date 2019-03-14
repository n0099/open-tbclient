package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class k implements Runnable {
    final /* synthetic */ Context acy;
    final /* synthetic */ Throwable acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, Throwable th) {
        this.acy = context;
        this.acz = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f.c(this.acy, f.j(d.a(this.acy, this.acz, false)));
            h.o(this.acy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
