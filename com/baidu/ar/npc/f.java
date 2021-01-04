package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ArBridge arBridge) {
        this.f1529a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1529a.nativeOnPauseByUser();
    }
}
