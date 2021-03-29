package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7077c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7078d;

    public i(HeatMap heatMap, int i, int i2, int i3) {
        this.f7078d = heatMap;
        this.f7075a = i;
        this.f7076b = i2;
        this.f7077c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7078d.b(this.f7075a, this.f7076b, this.f7077c);
    }
}
