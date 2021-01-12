package com.baidu.ar.npc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ArBridge arBridge) {
        this.f1537a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1537a.l = false;
        this.f1537a.nativeOnResumeByUser();
    }
}
