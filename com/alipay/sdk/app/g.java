package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f1814c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PayTask f1815d;

    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.f1815d = payTask;
        this.f1812a = str;
        this.f1813b = z;
        this.f1814c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1814c.onPayResult(this.f1815d.h5Pay(this.f1812a, this.f1813b));
    }
}
