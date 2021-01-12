package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class p implements Runnable {
    final /* synthetic */ Context aqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.aqW = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.aqW);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
