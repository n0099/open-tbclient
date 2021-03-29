package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4180a;

    public e(ArBridge arBridge) {
        this.f4180a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4180a.l = false;
        this.f4180a.nativeOnResumeByUser();
    }
}
