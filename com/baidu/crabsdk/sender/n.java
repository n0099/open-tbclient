package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context apB;
    final /* synthetic */ Throwable apC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.apB = context;
        this.apC = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.apB, i.e(g.a(this.apB, this.apC, false)));
            k.n(this.apB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
