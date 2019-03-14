package com.baidu.crabsdk.sender;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements Runnable {
    final /* synthetic */ Context acy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context) {
        this.acy = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            h.o(this.acy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
