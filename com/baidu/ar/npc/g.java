package com.baidu.ar.npc;
/* loaded from: classes4.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ArBridge arBridge) {
        this.f1537a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1537a.nativeClearScreen();
    }
}
