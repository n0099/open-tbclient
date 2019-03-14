package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class q implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ArBridge arBridge, int i, int i2, HashMap hashMap, int i3) {
        this.e = arBridge;
        this.a = i;
        this.b = i2;
        this.c = hashMap;
        this.d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (-1 == this.a) {
            this.e.sendMessageToEngine(this.b, this.e.getMessageID(), this.c, this.d);
        } else {
            this.e.sendMessageToEngine(this.b, this.a, this.c, this.d);
        }
    }
}
