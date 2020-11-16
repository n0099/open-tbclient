package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aqr;
    final /* synthetic */ Throwable aqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aqr = context;
        this.aqs = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aqr, i.e(g.a(this.aqr, this.aqs, false)));
            k.n(this.aqr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
