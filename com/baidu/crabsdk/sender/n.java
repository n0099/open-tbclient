package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements Runnable {
    final /* synthetic */ Context aoc;
    final /* synthetic */ Throwable aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, Throwable th) {
        this.aoc = context;
        this.aod = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.c(this.aoc, i.e(g.a(this.aoc, this.aod, false)));
            k.n(this.aoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
