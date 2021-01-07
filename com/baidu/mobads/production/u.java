package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes3.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3516a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3517b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f3516a = iXAdContainer;
        this.f3517b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.f3509b;
        bVar.b(this.f3516a, this.f3517b);
    }
}
