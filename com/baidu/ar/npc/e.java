package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4179a;

    public e(ArBridge arBridge) {
        this.f4179a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4179a.l = false;
        this.f4179a.nativeOnResumeByUser();
    }
}
