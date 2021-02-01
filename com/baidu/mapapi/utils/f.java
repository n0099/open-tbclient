package com.baidu.mapapi.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2963a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2964b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, int i) {
        this.f2963a = context;
        this.f2964b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread thread;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > IMConnection.RETRY_DELAY_TIMES) {
                b.a(this.f2963a);
                b.a(this.f2964b, this.f2963a);
            }
            thread = b.v;
        } while (!thread.isInterrupted());
    }
}
