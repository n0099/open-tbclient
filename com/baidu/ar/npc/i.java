package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4184a;

    public i(ArBridge arBridge) {
        this.f4184a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArBridge arBridge = this.f4184a;
        arBridge.k = arBridge.nativeGetFps();
    }
}
