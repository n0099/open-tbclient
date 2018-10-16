package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class i implements Runnable {
    final /* synthetic */ Context YK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.YK = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.l(this.YK);
    }
}
