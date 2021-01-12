package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes6.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HashMap f1561a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1562b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.f1562b = arBridge;
        this.f1561a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1562b.nativeSetTargetInfo(this.f1561a);
    }
}
