package com.alipay.sdk.data;

import android.content.Context;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f1903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1904b;

    public b(a aVar, Context context) {
        this.f1904b = aVar;
        this.f1903a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f1903a);
            if (a2 != null) {
                this.f1904b.b(a2.b());
                this.f1904b.i();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
