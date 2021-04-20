package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4237a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4238b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4239c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4240d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4241e;

    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.f4241e = arBridge;
        this.f4237a = i;
        this.f4238b = i2;
        this.f4239c = hashMap;
        this.f4240d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f4237a;
        if (-1 == i) {
            ArBridge arBridge = this.f4241e;
            arBridge.sendMessageToEngine(this.f4238b, arBridge.getMessageID(), this.f4239c, this.f4240d);
            return;
        }
        this.f4241e.sendMessageToEngine(this.f4238b, i, this.f4239c, this.f4240d);
    }
}
