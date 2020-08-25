package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class p implements Runnable {
    final /* synthetic */ Context aoV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.aoV = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.aoV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
