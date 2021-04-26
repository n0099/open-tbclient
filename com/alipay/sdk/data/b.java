package com.alipay.sdk.data;

import android.content.Context;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1855b;

    public b(a aVar, Context context) {
        this.f1855b = aVar;
        this.f1854a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f1854a);
            if (a2 != null) {
                this.f1855b.b(a2.b());
                this.f1855b.i();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
