package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1795a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1796b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f1797c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PayTask f1798d;

    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.f1798d = payTask;
        this.f1795a = str;
        this.f1796b = z;
        this.f1797c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1797c.onPayResult(this.f1798d.h5Pay(this.f1795a, this.f1796b));
    }
}
