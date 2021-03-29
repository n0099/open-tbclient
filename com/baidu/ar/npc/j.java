package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4185a;

    public j(ArBridge arBridge) {
        this.f4185a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4185a.nativeOnPause();
    }
}
