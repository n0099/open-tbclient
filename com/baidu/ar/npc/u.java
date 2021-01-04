package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes15.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HashMap f1552a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArBridge f1553b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.f1553b = arBridge;
        this.f1552a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1553b.nativeSetTargetInfo(this.f1552a);
    }
}
