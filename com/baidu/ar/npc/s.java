package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4210a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4211b;

    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f4211b = arBridge;
        this.f4210a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f4211b.f4082e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).f4088c == this.f4210a) {
                it.remove();
            }
        }
    }
}
