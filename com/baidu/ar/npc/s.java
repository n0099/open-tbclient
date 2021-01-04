package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.d f1548a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1549b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f1549b = arBridge;
        this.f1548a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f1549b.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).c == this.f1548a) {
                it.remove();
            }
        }
    }
}
