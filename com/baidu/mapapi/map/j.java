package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7084a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7086c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7087d;

    public j(HeatMap heatMap, int i2, int i3, int i4) {
        this.f7087d = heatMap;
        this.f7084a = i2;
        this.f7085b = i3;
        this.f7086c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7087d.b(this.f7084a, this.f7085b, this.f7086c);
    }
}
