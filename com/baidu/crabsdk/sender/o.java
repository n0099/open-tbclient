package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ Context QZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.QZ = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.o(this.QZ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
