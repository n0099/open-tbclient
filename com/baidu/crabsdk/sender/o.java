package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ Context acE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.acE = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.acE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
