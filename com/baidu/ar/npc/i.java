package com.baidu.ar.npc;
/* loaded from: classes4.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1290a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1290a.k = this.f1290a.nativeGetFps();
    }
}
