package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4207a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4209c;

    public r(ArBridge arBridge, int i, ArBridge.d dVar) {
        this.f4209c = arBridge;
        this.f4207a = i;
        this.f4208b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f4207a, -1, this.f4208b);
        list = this.f4209c.f4082e;
        list.add(aVar);
    }
}
