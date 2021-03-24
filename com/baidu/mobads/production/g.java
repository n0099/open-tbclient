package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainerContext f8469a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f8470b;

    public g(a aVar, IXAdContainerContext iXAdContainerContext) {
        this.f8470b = aVar;
        this.f8469a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8470b.a(this.f8469a);
    }
}
