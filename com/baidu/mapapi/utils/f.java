package com.baidu.mapapi.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7402b;

    public f(Context context, int i) {
        this.f7401a = context;
        this.f7402b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.f7401a);
                b.a(this.f7402b, this.f7401a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
