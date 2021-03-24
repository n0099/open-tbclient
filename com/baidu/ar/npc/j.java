package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4184a;

    public j(ArBridge arBridge) {
        this.f4184a = arBridge;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4184a.nativeOnPause();
    }
}
