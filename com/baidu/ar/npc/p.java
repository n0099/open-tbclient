package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4200a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4201b;

    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f4201b = arBridge;
        this.f4200a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4200a.a(null);
    }
}
