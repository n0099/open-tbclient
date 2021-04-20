package com.alipay.android.phone.mrpc.core;

import android.content.Context;
/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ aa f1684a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f1685b;

    public i(h hVar, aa aaVar) {
        this.f1685b = hVar;
        this.f1684a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f1684a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.f1685b.f1683a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f1684a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f1684a.c();
    }
}
