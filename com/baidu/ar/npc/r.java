package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4242a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4243b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4244c;

    public r(ArBridge arBridge, int i, ArBridge.d dVar) {
        this.f4244c = arBridge;
        this.f4242a = i;
        this.f4243b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f4242a, -1, this.f4243b);
        list = this.f4244c.f4117e;
        list.add(aVar);
    }
}
