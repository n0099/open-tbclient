package com.baidu.mapapi.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3069a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f3070b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, int i) {
        this.f3069a = context;
        this.f3070b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > IMConnection.RETRY_DELAY_TIMES) {
                b.a(this.f3069a);
                b.a(this.f3070b, this.f3069a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
