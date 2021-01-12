package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1553a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1554b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.e = arBridge;
        this.f1553a = i;
        this.f1554b = i2;
        this.c = hashMap;
        this.d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (-1 == this.f1553a) {
            this.e.sendMessageToEngine(this.f1554b, this.e.getMessageID(), this.c, this.d);
        } else {
            this.e.sendMessageToEngine(this.f1554b, this.f1553a, this.c, this.d);
        }
    }
}
