package com.baidu.mapapi.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7705b;

    public f(Context context, int i2) {
        this.f7704a = context;
        this.f7705b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.f7704a);
                b.a(this.f7705b, this.f7704a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
