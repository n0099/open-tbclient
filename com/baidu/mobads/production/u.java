package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes7.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f2431a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f2431a = iXAdContainer;
        this.b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.b;
        bVar.b(this.f2431a, this.b);
    }
}
