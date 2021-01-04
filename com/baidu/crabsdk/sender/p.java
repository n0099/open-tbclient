package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p implements Runnable {
    final /* synthetic */ Context arJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.arJ = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.arJ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
