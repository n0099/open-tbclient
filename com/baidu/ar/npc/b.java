package com.baidu.ar.npc;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4168c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f4169d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4170e;

    public b(ArBridge arBridge, float f2, float f3, float f4, String str) {
        this.f4170e = arBridge;
        this.f4166a = f2;
        this.f4167b = f3;
        this.f4168c = f4;
        this.f4169d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4170e.nativeSetEuler(this.f4166a, this.f4167b, this.f4168c, this.f4169d);
    }
}
