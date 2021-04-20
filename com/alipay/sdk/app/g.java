package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1837a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f1839c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PayTask f1840d;

    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.f1840d = payTask;
        this.f1837a = str;
        this.f1838b = z;
        this.f1839c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1839c.onPayResult(this.f1840d.h5Pay(this.f1837a, this.f1838b));
    }
}
