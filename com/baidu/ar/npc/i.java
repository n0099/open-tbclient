package com.baidu.ar.npc;
/* loaded from: classes3.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1533a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1533a.k = this.f1533a.nativeGetFps();
    }
}
