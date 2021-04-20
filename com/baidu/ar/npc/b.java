package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4204c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f4205d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4206e;

    public b(ArBridge arBridge, float f2, float f3, float f4, String str) {
        this.f4206e = arBridge;
        this.f4202a = f2;
        this.f4203b = f3;
        this.f4204c = f4;
        this.f4205d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4206e.nativeSetEuler(this.f4202a, this.f4203b, this.f4204c, this.f4205d);
    }
}
