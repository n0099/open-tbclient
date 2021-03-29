package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4168b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4169c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f4170d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4171e;

    public b(ArBridge arBridge, float f2, float f3, float f4, String str) {
        this.f4171e = arBridge;
        this.f4167a = f2;
        this.f4168b = f3;
        this.f4169c = f4;
        this.f4170d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4171e.nativeSetEuler(this.f4167a, this.f4168b, this.f4169c, this.f4170d);
    }
}
