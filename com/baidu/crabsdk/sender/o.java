package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ Context SK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.SK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.SK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
