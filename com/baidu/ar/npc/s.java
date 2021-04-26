package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4316b;

    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f4316b = arBridge;
        this.f4315a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f4316b.f4180e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).f4187c == this.f4315a) {
                it.remove();
            }
        }
    }
}
