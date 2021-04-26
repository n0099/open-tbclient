package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4306b;

    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f4306b = arBridge;
        this.f4305a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4305a.a(null);
    }
}
