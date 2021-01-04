package com.baidu.mapapi.map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2922a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2923b;
    final /* synthetic */ int c;
    final /* synthetic */ HeatMap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(HeatMap heatMap, int i, int i2, int i3) {
        this.d = heatMap;
        this.f2922a = i;
        this.f2923b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.b(this.f2922a, this.f2923b, this.c);
    }
}
