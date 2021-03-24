package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4211a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4213c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4214d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4215e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4216f;

    public t(ArBridge arBridge, String str, int i, HashMap hashMap, int i2, int i3) {
        this.f4216f = arBridge;
        this.f4211a = str;
        this.f4212b = i;
        this.f4213c = hashMap;
        this.f4214d = i2;
        this.f4215e = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4216f.nativeCreateCase(this.f4211a, this.f4212b, this.f4213c, this.f4214d, this.f4215e);
    }
}
