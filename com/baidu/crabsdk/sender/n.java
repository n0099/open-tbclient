package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aqW;
    final /* synthetic */ Throwable aqX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aqW = context;
        this.aqX = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aqW, i.e(g.a(this.aqW, this.aqX, false)));
            k.n(this.aqW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
