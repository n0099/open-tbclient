package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4246b;

    public s(ArBridge arBridge, ArBridge.d dVar) {
        this.f4246b = arBridge;
        this.f4245a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        list = this.f4246b.f4117e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ArBridge.a) it.next()).f4123c == this.f4245a) {
                it.remove();
            }
        }
    }
}
