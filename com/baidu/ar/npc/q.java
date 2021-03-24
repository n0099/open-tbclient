package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4201a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4202b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4203c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4204d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4205e;

    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.f4205e = arBridge;
        this.f4201a = i;
        this.f4202b = i2;
        this.f4203c = hashMap;
        this.f4204d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f4201a;
        if (-1 == i) {
            ArBridge arBridge = this.f4205e;
            arBridge.sendMessageToEngine(this.f4202b, arBridge.getMessageID(), this.f4203c, this.f4204d);
            return;
        }
        this.f4205e.sendMessageToEngine(this.f4202b, i, this.f4203c, this.f4204d);
    }
}
