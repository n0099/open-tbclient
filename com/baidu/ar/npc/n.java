package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4226a;

    public n(ArBridge arBridge) {
        this.f4226a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4226a.nativeOnResume();
    }
}
