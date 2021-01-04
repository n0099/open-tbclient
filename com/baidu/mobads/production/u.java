package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes3.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3515a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3516b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f3515a = iXAdContainer;
        this.f3516b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.f3508b;
        bVar.b(this.f3515a, this.f3516b);
    }
}
