package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;
/* loaded from: classes3.dex */
public class HeatMapData {
    public double[] a;
    public double[] b;
    public double[] c;
    public float d;

    public HeatMapData(Collection<WeightedLatLng> collection, float f) {
        int size = collection.size();
        this.a = new double[size];
        this.b = new double[size];
        this.c = new double[size];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.a[i] = weightedLatLng.getPoint().x;
            this.b[i2] = weightedLatLng.getPoint().y;
            this.c[i3] = weightedLatLng.getIntensity();
            i3++;
            i2++;
            i++;
        }
        this.d = f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putDoubleArray("x_array", this.a);
        bundle.putDoubleArray("y_array", this.b);
        bundle.putDoubleArray("z_array", this.c);
        bundle.putFloat("max_intentity", this.d);
        return bundle;
    }
}
