package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4288a;

    public i(ArBridge arBridge) {
        this.f4288a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArBridge arBridge = this.f4288a;
        arBridge.k = arBridge.nativeGetFps();
    }
}
