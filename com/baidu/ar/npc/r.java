package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1555a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge.d f1556b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ArBridge arBridge, int i, ArBridge.d dVar) {
        this.c = arBridge;
        this.f1555a = i;
        this.f1556b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f1555a, -1, this.f1556b);
        list = this.c.e;
        list.add(aVar);
    }
}
