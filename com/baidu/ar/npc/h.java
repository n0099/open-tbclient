package com.baidu.ar.npc;
/* loaded from: classes26.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.f1222a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1222a.nativeReset();
    }
}
