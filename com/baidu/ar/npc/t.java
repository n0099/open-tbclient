package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4247a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4249c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4250d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4251e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4252f;

    public t(ArBridge arBridge, String str, int i, HashMap hashMap, int i2, int i3) {
        this.f4252f = arBridge;
        this.f4247a = str;
        this.f4248b = i;
        this.f4249c = hashMap;
        this.f4250d = i2;
        this.f4251e = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4252f.nativeCreateCase(this.f4247a, this.f4248b, this.f4249c, this.f4250d, this.f4251e);
    }
}
