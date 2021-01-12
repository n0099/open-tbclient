package com.baidu.ar.npc;
/* loaded from: classes6.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.f1540a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1540a.nativeReset();
    }
}
