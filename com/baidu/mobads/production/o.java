package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes5.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3470a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3471b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = lVar;
        this.f3470a = iXAdContainer;
        this.f3471b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.c.f3465b;
        aVar.d(this.f3470a, this.f3471b);
    }
}
