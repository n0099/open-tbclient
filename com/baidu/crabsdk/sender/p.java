package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class p implements Runnable {
    final /* synthetic */ Context aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.aqr = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.aqr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
