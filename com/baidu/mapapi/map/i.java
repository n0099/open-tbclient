package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7076c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7077d;

    public i(HeatMap heatMap, int i, int i2, int i3) {
        this.f7077d = heatMap;
        this.f7074a = i;
        this.f7075b = i2;
        this.f7076c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7077d.b(this.f7074a, this.f7075b, this.f7076c);
    }
}
