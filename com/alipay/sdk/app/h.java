package com.alipay.sdk.app;

import com.alipay.sdk.util.e;
/* loaded from: classes.dex */
public class h implements e.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PayTask f1841a;

    public h(PayTask payTask) {
        this.f1841a = payTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.f1841a.dismissLoading();
    }
}
