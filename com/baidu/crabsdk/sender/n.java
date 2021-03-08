package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class n implements Runnable {
    final /* synthetic */ Context asl;
    final /* synthetic */ Throwable asn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.asl = context;
        this.asn = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.asl, i.e(g.a(this.asl, this.asn, false)));
            k.n(this.asl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
