package com.baidu.ar.npc;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f4271a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f4272b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4273c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f4274d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4275e;

    public b(ArBridge arBridge, float f2, float f3, float f4, String str) {
        this.f4275e = arBridge;
        this.f4271a = f2;
        this.f4272b = f3;
        this.f4273c = f4;
        this.f4274d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4275e.nativeSetEuler(this.f4271a, this.f4272b, this.f4273c, this.f4274d);
    }
}
