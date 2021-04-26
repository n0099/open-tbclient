package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4309c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4310d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4311e;

    public q(ArBridge arBridge, int i2, int i3, HashMap hashMap, int i4) {
        this.f4311e = arBridge;
        this.f4307a = i2;
        this.f4308b = i3;
        this.f4309c = hashMap;
        this.f4310d = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f4307a;
        if (-1 == i2) {
            ArBridge arBridge = this.f4311e;
            arBridge.sendMessageToEngine(this.f4308b, arBridge.getMessageID(), this.f4309c, this.f4310d);
            return;
        }
        this.f4311e.sendMessageToEngine(this.f4308b, i2, this.f4309c, this.f4310d);
    }
}
