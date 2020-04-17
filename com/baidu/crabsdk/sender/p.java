package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class p implements Runnable {
    final /* synthetic */ Context alb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.alb = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.alb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
