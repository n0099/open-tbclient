package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4285a;

    public f(ArBridge arBridge) {
        this.f4285a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4285a.nativeOnPauseByUser();
    }
}
