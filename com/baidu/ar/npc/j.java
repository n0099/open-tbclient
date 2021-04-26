package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4289a;

    public j(ArBridge arBridge) {
        this.f4289a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4289a.nativeOnPause();
    }
}
