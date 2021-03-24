package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4190a;

    public n(ArBridge arBridge) {
        this.f4190a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4190a.nativeOnResume();
    }
}
