package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes3.dex */
class p implements Runnable {
    final /* synthetic */ ArBridge.c a;
    final /* synthetic */ ArBridge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.b = arBridge;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(null);
    }
}
