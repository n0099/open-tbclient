package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4180a;

    public f(ArBridge arBridge) {
        this.f4180a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4180a.nativeOnPauseByUser();
    }
}
