package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class s implements Runnable {
    final /* synthetic */ ArBridge.d a;
    final /* synthetic */ ArBridge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.b = arBridge;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.b.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).c == this.a) {
                it.remove();
            }
        }
    }
}
