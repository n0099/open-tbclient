package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes26.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HashMap f1235a;
    final /* synthetic */ ArBridge b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArBridge arBridge, HashMap hashMap) {
        this.b = arBridge;
        this.f1235a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.nativeSetTargetInfo(this.f1235a);
    }
}
