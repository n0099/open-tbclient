package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainerContext f2422a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar, IXAdContainerContext iXAdContainerContext) {
        this.b = bVar;
        this.f2422a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2422a);
    }
}
