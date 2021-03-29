package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainerContext f8470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f8471b;

    public g(a aVar, IXAdContainerContext iXAdContainerContext) {
        this.f8471b = aVar;
        this.f8470a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8471b.a(this.f8470a);
    }
}
