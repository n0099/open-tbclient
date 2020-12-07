package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context arn;
    final /* synthetic */ Throwable aro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.arn = context;
        this.aro = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.arn, i.e(g.a(this.arn, this.aro, false)));
            k.n(this.arn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
