package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.c f4235a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4236b;

    public p(ArBridge arBridge, ArBridge.c cVar) {
        this.f4236b = arBridge;
        this.f4235a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4235a.a(null);
    }
}
