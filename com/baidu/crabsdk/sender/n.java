package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aqM;
    final /* synthetic */ Throwable aqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aqM = context;
        this.aqN = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aqM, i.e(g.a(this.aqM, this.aqN, false)));
            k.n(this.aqM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
