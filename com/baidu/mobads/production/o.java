package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes4.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f2470a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = lVar;
        this.f2470a = iXAdContainer;
        this.b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.c.b;
        aVar.d(this.f2470a, this.b);
    }
}
