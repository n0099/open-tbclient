package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.d f1549a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1550b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f1550b = arBridge;
        this.f1549a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f1550b.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).c == this.f1549a) {
                it.remove();
            }
        }
    }
}
