package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HashMap f4253a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4254b;

    public u(ArBridge arBridge, HashMap hashMap) {
        this.f4254b = arBridge;
        this.f4253a = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4254b.nativeSetTargetInfo(this.f4253a);
    }
}
