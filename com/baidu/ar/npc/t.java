package com.baidu.ar.npc;

import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4317a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4318b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f4319c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4320d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f4321e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4322f;

    public t(ArBridge arBridge, String str, int i2, HashMap hashMap, int i3, int i4) {
        this.f4322f = arBridge;
        this.f4317a = str;
        this.f4318b = i2;
        this.f4319c = hashMap;
        this.f4320d = i3;
        this.f4321e = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4322f.nativeCreateCase(this.f4317a, this.f4318b, this.f4319c, this.f4320d, this.f4321e);
    }
}
