package com.baidu.mapapi.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > IMConnection.RETRY_DELAY_TIMES) {
                b.a(this.a);
                b.a(this.b, this.a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
