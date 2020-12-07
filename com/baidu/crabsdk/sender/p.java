package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class p implements Runnable {
    final /* synthetic */ Context arn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        this.arn = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.n(this.arn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
