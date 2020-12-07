package com.baidu.mapapi.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2163a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, int i) {
        this.f2163a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > IMConnection.RETRY_DELAY_TIMES) {
                b.a(this.f2163a);
                b.a(this.b, this.f2163a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
