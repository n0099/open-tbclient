package com.baidu.ar.npc;
/* loaded from: classes26.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1223a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1223a.k = this.f1223a.nativeGetFps();
    }
}
