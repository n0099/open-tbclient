package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainerContext f2461a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, IXAdContainerContext iXAdContainerContext) {
        this.b = aVar;
        this.f2461a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2461a);
    }
}
