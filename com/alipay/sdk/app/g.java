package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1782a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f1784c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PayTask f1785d;

    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.f1785d = payTask;
        this.f1782a = str;
        this.f1783b = z;
        this.f1784c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1784c.onPayResult(this.f1785d.h5Pay(this.f1782a, this.f1783b));
    }
}
