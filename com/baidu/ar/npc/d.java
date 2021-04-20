package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4210a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f4211b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4212c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4213d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4214e;

    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.f4214e = arBridge;
        this.f4210a = str;
        this.f4211b = hashMap;
        this.f4212c = i;
        this.f4213d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4214e.nativeDestroyCase();
        this.f4214e.setGLJniEnv();
        ArBridge arBridge = this.f4214e;
        arBridge.nativeCreateCase(this.f4210a, arBridge.getCaseId(), this.f4211b, this.f4212c, this.f4213d);
    }
}
