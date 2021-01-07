package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes3.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HashMap f1553a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.f1554b = arBridge;
        this.f1553a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1554b.nativeSetTargetInfo(this.f1553a);
    }
}
