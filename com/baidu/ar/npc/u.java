package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes10.dex */
class u implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ ArBridge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.b = arBridge;
        this.a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.nativeSetTargetInfo(this.a);
    }
}
