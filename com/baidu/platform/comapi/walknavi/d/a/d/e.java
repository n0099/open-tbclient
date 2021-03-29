package com.baidu.platform.comapi.walknavi.d.a.d;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f9979a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f9980b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f9981c;

    public e(d dVar, long j, long j2) {
        this.f9981c = dVar;
        this.f9979a = j;
        this.f9980b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.this.a((int) ((((float) this.f9979a) * 100.0f) / ((float) this.f9980b)));
    }
}
