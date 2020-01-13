package com.baidu.mapapi.map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ HeatMap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HeatMap heatMap, int i, int i2, int i3) {
        this.d = heatMap;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.b(this.a, this.b, this.c);
    }
}
