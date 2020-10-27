package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1229a;
    final /* synthetic */ ArBridge.d b;
    final /* synthetic */ ArBridge c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ArBridge arBridge, int i, ArBridge.d dVar) {
        this.c = arBridge;
        this.f1229a = i;
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f1229a, -1, this.b);
        list = this.c.e;
        list.add(aVar);
    }
}
