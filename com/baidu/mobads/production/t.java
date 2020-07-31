package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes20.dex */
class t implements Runnable {
    final /* synthetic */ IXAdContainer a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.a = iXAdContainer;
        this.b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.b;
        bVar.a(this.a, this.b);
    }
}
