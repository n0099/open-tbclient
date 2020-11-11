package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ArBridge arBridge) {
        this.f1218a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1218a.l = false;
        this.f1218a.nativeOnResumeByUser();
    }
}
