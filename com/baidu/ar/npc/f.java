package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4216a;

    public f(ArBridge arBridge) {
        this.f4216a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4216a.nativeOnPauseByUser();
    }
}
