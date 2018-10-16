package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l implements Runnable {
    final /* synthetic */ Context YK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.YK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.YK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
