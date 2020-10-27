package com.baidu.ar.npc;
/* loaded from: classes7.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1220a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1220a.k = this.f1220a.nativeGetFps();
    }
}
