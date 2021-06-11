package com.baidu.mapapi.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7465b;

    public f(Context context, int i2) {
        this.f7464a = context;
        this.f7465b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.f7464a);
                b.a(this.f7465b, this.f7464a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
