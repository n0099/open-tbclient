package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4204c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4205d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4206e;

    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.f4206e = arBridge;
        this.f4202a = i;
        this.f4203b = i2;
        this.f4204c = hashMap;
        this.f4205d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f4202a;
        if (-1 == i) {
            ArBridge arBridge = this.f4206e;
            arBridge.sendMessageToEngine(this.f4203b, arBridge.getMessageID(), this.f4204c, this.f4205d);
            return;
        }
        this.f4206e.sendMessageToEngine(this.f4203b, i, this.f4204c, this.f4205d);
    }
}
