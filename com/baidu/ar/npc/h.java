package com.baidu.ar.npc;
/* loaded from: classes7.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1224a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.f1224a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1224a.nativeReset();
    }
}
