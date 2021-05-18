package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7184a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7186c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7187d;

    public j(HeatMap heatMap, int i2, int i3, int i4) {
        this.f7187d = heatMap;
        this.f7184a = i2;
        this.f7185b = i3;
        this.f7186c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7187d.b(this.f7184a, this.f7185b, this.f7186c);
    }
}
