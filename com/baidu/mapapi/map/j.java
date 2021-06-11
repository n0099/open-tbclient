package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7127a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7129c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7130d;

    public j(HeatMap heatMap, int i2, int i3, int i4) {
        this.f7130d = heatMap;
        this.f7127a = i2;
        this.f7128b = i3;
        this.f7129c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7130d.b(this.f7127a, this.f7128b, this.f7129c);
    }
}
