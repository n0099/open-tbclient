package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f4175b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4176c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4177d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4178e;

    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.f4178e = arBridge;
        this.f4174a = str;
        this.f4175b = hashMap;
        this.f4176c = i;
        this.f4177d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4178e.nativeDestroyCase();
        this.f4178e.setGLJniEnv();
        ArBridge arBridge = this.f4178e;
        arBridge.nativeCreateCase(this.f4174a, arBridge.getCaseId(), this.f4175b, this.f4176c, this.f4177d);
    }
}
