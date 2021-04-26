package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7367c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7368d;

    public i(HeatMap heatMap, int i2, int i3, int i4) {
        this.f7368d = heatMap;
        this.f7365a = i2;
        this.f7366b = i3;
        this.f7367c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7368d.b(this.f7365a, this.f7366b, this.f7367c);
    }
}
