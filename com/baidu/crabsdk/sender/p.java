package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class p implements Runnable {
    final /* synthetic */ Context alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.alh = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.alh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
