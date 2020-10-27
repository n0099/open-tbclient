package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aql;
    final /* synthetic */ Throwable aqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aql = context;
        this.aqm = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aql, i.e(g.a(this.aql, this.aqm, false)));
            k.n(this.aql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
