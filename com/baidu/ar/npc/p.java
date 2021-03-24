package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes2.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4200b;

    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f4200b = arBridge;
        this.f4199a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4199a.a(null);
    }
}
