package com.baidu.ar.npc;
/* loaded from: classes4.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.f1289a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1289a.nativeReset();
    }
}
