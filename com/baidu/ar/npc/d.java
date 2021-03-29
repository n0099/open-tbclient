package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4175a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f4176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4177c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4178d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4179e;

    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.f4179e = arBridge;
        this.f4175a = str;
        this.f4176b = hashMap;
        this.f4177c = i;
        this.f4178d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4179e.nativeDestroyCase();
        this.f4179e.setGLJniEnv();
        ArBridge arBridge = this.f4179e;
        arBridge.nativeCreateCase(this.f4175a, arBridge.getCaseId(), this.f4176b, this.f4177c, this.f4178d);
    }
}
