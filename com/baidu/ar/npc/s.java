package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge.d f1557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1558b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f1558b = arBridge;
        this.f1557a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f1558b.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).c == this.f1557a) {
                it.remove();
            }
        }
    }
}
