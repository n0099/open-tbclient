package com.baidu.ar.npc;
/* loaded from: classes15.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ArBridge arBridge) {
        this.f1531a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1531a.nativeReset();
    }
}
