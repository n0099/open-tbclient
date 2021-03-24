package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4183a;

    public i(ArBridge arBridge) {
        this.f4183a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArBridge arBridge = this.f4183a;
        arBridge.k = arBridge.nativeGetFps();
    }
}
