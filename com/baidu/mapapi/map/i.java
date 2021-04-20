package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7110a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7112c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7113d;

    public i(HeatMap heatMap, int i, int i2, int i3) {
        this.f7113d = heatMap;
        this.f7110a = i;
        this.f7111b = i2;
        this.f7112c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7113d.b(this.f7110a, this.f7111b, this.f7112c);
    }
}
