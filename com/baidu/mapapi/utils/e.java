package com.baidu.mapapi.utils;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                a.a(this.a);
                a.a(this.b, this.a);
            }
            thread = a.v;
        } while (!thread.isInterrupted());
    }
}
