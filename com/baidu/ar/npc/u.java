package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes4.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HashMap f1559a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1560b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.f1560b = arBridge;
        this.f1559a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1560b.nativeSetTargetInfo(this.f1559a);
    }
}
