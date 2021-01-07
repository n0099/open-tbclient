package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ArBridge arBridge) {
        this.f1529a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1529a.l = false;
        this.f1529a.nativeOnResumeByUser();
    }
}
