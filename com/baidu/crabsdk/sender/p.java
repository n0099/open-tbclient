package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class p implements Runnable {
    final /* synthetic */ Context anY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.anY = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.anY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
