package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes7.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.c f1230a;
    final /* synthetic */ ArBridge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.b = arBridge;
        this.f1230a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1230a.a(null);
    }
}
