package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes14.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdContainer f3476a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f3477b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.c = qVar;
        this.f3476a = iXAdContainer;
        this.f3477b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        bVar = this.c.f3471b;
        bVar.a(this.f3476a, this.f3477b);
    }
}
