package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aqk;
    final /* synthetic */ Throwable aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aqk = context;
        this.aql = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aqk, i.e(g.a(this.aqk, this.aql, false)));
            k.n(this.aqk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
