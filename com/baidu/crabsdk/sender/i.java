package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements Runnable {
    final /* synthetic */ Context Ty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.Ty = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.l(this.Ty);
    }
}
