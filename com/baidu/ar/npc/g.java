package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4181a;

    public g(ArBridge arBridge) {
        this.f4181a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4181a.nativeClearScreen();
    }
}
