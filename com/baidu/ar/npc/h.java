package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4183a;

    public h(ArBridge arBridge) {
        this.f4183a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4183a.nativeReset();
    }
}
