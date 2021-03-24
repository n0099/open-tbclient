package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4182a;

    public h(ArBridge arBridge) {
        this.f4182a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4182a.nativeReset();
    }
}
