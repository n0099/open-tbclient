package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ Context acD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.acD = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.acD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
