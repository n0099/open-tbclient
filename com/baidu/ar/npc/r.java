package com.baidu.ar.npc;

import com.baidu.ar.npc.ArBridge;
import java.util.List;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge.d f4313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4314c;

    public r(ArBridge arBridge, int i2, ArBridge.d dVar) {
        this.f4314c = arBridge;
        this.f4312a = i2;
        this.f4313b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        ArBridge.a aVar = new ArBridge.a(this.f4312a, -1, this.f4313b);
        list = this.f4314c.f4180e;
        list.add(aVar);
    }
}
