package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes7.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f2428a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f2428a = iXAdContainer;
        this.b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.b;
        bVar.a(this.f2428a, this.b);
    }
}
