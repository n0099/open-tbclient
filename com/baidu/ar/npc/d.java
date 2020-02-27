package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ HashMap b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.e = arBridge;
        this.a = str;
        this.b = hashMap;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.nativeDestroyCase();
        this.e.setGLJniEnv();
        this.e.nativeCreateCase(this.a, this.e.getCaseId(), this.b, this.c, this.d);
    }
}
