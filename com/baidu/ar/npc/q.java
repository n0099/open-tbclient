package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1551a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1552b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.e = arBridge;
        this.f1551a = i;
        this.f1552b = i2;
        this.c = hashMap;
        this.d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (-1 == this.f1551a) {
            this.e.sendMessageToEngine(this.f1552b, this.e.getMessageID(), this.c, this.d);
        } else {
            this.e.sendMessageToEngine(this.f1552b, this.f1551a, this.c, this.d);
        }
    }
}
