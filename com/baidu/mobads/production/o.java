package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainerContext f3502a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3503b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar, IXAdContainerContext iXAdContainerContext) {
        this.f3503b = bVar;
        this.f3502a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3503b.a(this.f3502a);
    }
}
