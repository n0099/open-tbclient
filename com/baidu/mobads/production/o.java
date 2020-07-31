package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class o implements Runnable {
    final /* synthetic */ IXAdContainerContext a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar, IXAdContainerContext iXAdContainerContext) {
        this.b = bVar;
        this.a = iXAdContainerContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
