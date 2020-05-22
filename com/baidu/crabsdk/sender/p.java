package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class p implements Runnable {
    final /* synthetic */ Context amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.amK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.amK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
