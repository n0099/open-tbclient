package com.baidu.ar.npc;
/* loaded from: classes3.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.f1531a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1531a.nativeClearScreen();
    }
}
