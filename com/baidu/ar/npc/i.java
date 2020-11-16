package com.baidu.ar.npc;
/* loaded from: classes7.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1225a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1225a.k = this.f1225a.nativeGetFps();
    }
}
