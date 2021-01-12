package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainerContext f3464a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3465b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar, IXAdContainerContext iXAdContainerContext) {
        this.f3465b = bVar;
        this.f3464a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3465b.a(this.f3464a);
    }
}
