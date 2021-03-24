package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HashMap f4217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4218b;

    public u(ArBridge arBridge, HashMap hashMap) {
        this.f4218b = arBridge;
        this.f4217a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4218b.nativeSetTargetInfo(this.f4217a);
    }
}
