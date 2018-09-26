package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Runnable {
    final /* synthetic */ Context VY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.VY = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.VY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
