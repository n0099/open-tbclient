package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4284a;

    public e(ArBridge arBridge) {
        this.f4284a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4284a.l = false;
        this.f4284a.nativeOnResumeByUser();
    }
}
