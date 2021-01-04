package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes3.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3513a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3514b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f3513a = iXAdContainer;
        this.f3514b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.f3508b;
        bVar.a(this.f3513a, this.f3514b);
    }
}
