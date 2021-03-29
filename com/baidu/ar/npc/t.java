package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4212a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4214c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4215d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4216e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4217f;

    public t(ArBridge arBridge, String str, int i, HashMap hashMap, int i2, int i3) {
        this.f4217f = arBridge;
        this.f4212a = str;
        this.f4213b = i;
        this.f4214c = hashMap;
        this.f4215d = i2;
        this.f4216e = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4217f.nativeCreateCase(this.f4212a, this.f4213b, this.f4214c, this.f4215d, this.f4216e);
    }
}
