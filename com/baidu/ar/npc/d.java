package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4279a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f4280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4281c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4282d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4283e;

    public d(ArBridge arBridge, String str, HashMap hashMap, int i2, int i3) {
        this.f4283e = arBridge;
        this.f4279a = str;
        this.f4280b = hashMap;
        this.f4281c = i2;
        this.f4282d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4283e.nativeDestroyCase();
        this.f4283e.setGLJniEnv();
        ArBridge arBridge = this.f4283e;
        arBridge.nativeCreateCase(this.f4279a, arBridge.getCaseId(), this.f4280b, this.f4281c, this.f4282d);
    }
}
