package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes5.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3468a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3469b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = lVar;
        this.f3468a = iXAdContainer;
        this.f3469b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.c.f3465b;
        aVar.c(this.f3468a, this.f3469b);
    }
}
