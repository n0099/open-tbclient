package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class l implements Runnable {
    final /* synthetic */ Context QZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.QZ = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.l(this.QZ);
    }
}
