package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4217a;

    public g(ArBridge arBridge) {
        this.f4217a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4217a.nativeClearScreen();
    }
}
