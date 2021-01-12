package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes6.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.c f1551a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1552b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f1552b = arBridge;
        this.f1551a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1551a.a(null);
    }
}
