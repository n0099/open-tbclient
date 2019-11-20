package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ Context Ku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.Ku = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.Ku);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
