package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Runnable {
    final /* synthetic */ Context Tv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.Tv = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.Tv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
