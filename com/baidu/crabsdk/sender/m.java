package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Runnable {
    final /* synthetic */ Context Ty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.Ty = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            n.pq();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
