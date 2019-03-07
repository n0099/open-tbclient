package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements Runnable {
    final /* synthetic */ Context acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.acx = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.acx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
