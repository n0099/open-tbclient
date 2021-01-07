package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes3.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.c f1543a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1544b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f1544b = arBridge;
        this.f1543a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1543a.a(null);
    }
}
