package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ArBridge arBridge) {
        this.f1220a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1220a.nativeOnPauseByUser();
    }
}
