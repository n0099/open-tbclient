package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainerContext f3455a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3456b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, IXAdContainerContext iXAdContainerContext) {
        this.f3456b = aVar;
        this.f3455a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3456b.a(this.f3455a);
    }
}
