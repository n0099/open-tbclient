package com.baidu.ar.npc;
/* loaded from: classes15.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1532a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1532a.k = this.f1532a.nativeGetFps();
    }
}
