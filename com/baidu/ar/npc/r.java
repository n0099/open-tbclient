package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* loaded from: classes2.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4206a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4208c;

    public r(ArBridge arBridge, int i, ArBridge.d dVar) {
        this.f4208c = arBridge;
        this.f4206a = i;
        this.f4207b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f4206a, -1, this.f4207b);
        list = this.f4208c.f4081e;
        list.add(aVar);
    }
}
