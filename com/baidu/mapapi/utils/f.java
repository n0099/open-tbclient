package com.baidu.mapapi.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7437a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7438b;

    public f(Context context, int i) {
        this.f7437a = context;
        this.f7438b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.f7437a);
                b.a(this.f7438b, this.f7437a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
