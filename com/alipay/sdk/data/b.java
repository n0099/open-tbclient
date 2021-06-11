package com.alipay.sdk.data;

import android.content.Context;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1867a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1868b;

    public b(a aVar, Context context) {
        this.f1868b = aVar;
        this.f1867a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f1867a);
            if (a2 != null) {
                this.f1868b.b(a2.b());
                this.f1868b.i();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
