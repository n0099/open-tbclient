package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f3071a = 0;
    private int b = 0;
    private int c = 1;
    private ArrayList<LatLng> d = new ArrayList<>();

    public void a() {
        this.f3071a = 0;
        this.b = 0;
        this.d = new ArrayList<>();
    }

    public void a(Bundle bundle, int i) {
        a();
        if (bundle != null) {
            this.c = i;
            this.f3071a = bundle.getInt("totaldistance");
            this.b = bundle.getInt("totaltime");
            double[] doubleArray = bundle.getDoubleArray("ptShapeX");
            double[] doubleArray2 = bundle.getDoubleArray("ptShapeY");
            if (doubleArray != null && doubleArray2 != null) {
                LatLng latLng = new LatLng(0.0d, 0.0d);
                for (int i2 = 0; i2 < doubleArray.length; i2++) {
                    LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(doubleArray2[i2], doubleArray[i2]));
                    if (Math.abs(latLng.longitude - gcjToBaidu.longitude) >= 1.0E-6d || Math.abs(latLng.latitude - gcjToBaidu.latitude) >= 1.0E-6d) {
                        this.d.add(gcjToBaidu);
                        latLng = gcjToBaidu;
                    }
                }
            }
        }
    }

    public int b() {
        return this.f3071a;
    }
}
