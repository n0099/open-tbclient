package com.baidu.mapapi.utils;

import android.content.Context;
/* loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;

    public f(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.a);
                b.a(this.b, this.a);
            }
            thread = b.x;
        } while (!thread.isInterrupted());
    }
}
