package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ ArBridge f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ArBridge arBridge, String str, int i, HashMap hashMap, int i2, int i3) {
        this.f = arBridge;
        this.a = str;
        this.b = i;
        this.c = hashMap;
        this.d = i2;
        this.e = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.nativeCreateCase(this.a, this.b, this.c, this.d, this.e);
    }
}
