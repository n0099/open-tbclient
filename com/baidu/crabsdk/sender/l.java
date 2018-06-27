package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Runnable {
    final /* synthetic */ Context Ty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.Ty = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.Ty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
