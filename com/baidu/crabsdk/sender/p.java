package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class p implements Runnable {
    final /* synthetic */ Context SO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.SO = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.SO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
