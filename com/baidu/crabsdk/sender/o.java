package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ Context Re;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.Re = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.Re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
