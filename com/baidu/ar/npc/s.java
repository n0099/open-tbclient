package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4210b;

    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f4210b = arBridge;
        this.f4209a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f4210b.f4081e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).f4087c == this.f4209a) {
                it.remove();
            }
        }
    }
}
