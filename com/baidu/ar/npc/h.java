package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4218a;

    public h(ArBridge arBridge) {
        this.f4218a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4218a.nativeReset();
    }
}
