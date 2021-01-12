package com.baidu.ar.npc;
/* loaded from: classes6.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ArBridge arBridge) {
        this.f1541a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1541a.k = this.f1541a.nativeGetFps();
    }
}
