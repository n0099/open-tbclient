package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class p implements Runnable {
    final /* synthetic */ Context aqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.aqM = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.aqM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
