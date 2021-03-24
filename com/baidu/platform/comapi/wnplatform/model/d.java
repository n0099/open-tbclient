package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f10319a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f10320b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f10321c = 1;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<LatLng> f10322d = new ArrayList<>();

    public void a() {
        this.f10319a = 0;
        this.f10320b = 0;
        this.f10322d = new ArrayList<>();
    }

    public int b() {
        return this.f10319a;
    }

    public void a(Bundle bundle, int i) {
        a();
        if (bundle == null) {
            return;
        }
        this.f10321c = i;
        this.f10319a = bundle.getInt("totaldistance");
        this.f10320b = bundle.getInt("totaltime");
        double[] doubleArray = bundle.getDoubleArray("ptShapeX");
        double[] doubleArray2 = bundle.getDoubleArray("ptShapeY");
        if (doubleArray == null || doubleArray2 == null) {
            return;
        }
        LatLng latLng = new LatLng(0.0d, 0.0d);
        for (int i2 = 0; i2 < doubleArray.length; i2++) {
            LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(doubleArray2[i2], doubleArray[i2]));
            if (Math.abs(latLng.longitude - gcjToBaidu.longitude) >= 1.0E-6d || Math.abs(latLng.latitude - gcjToBaidu.latitude) >= 1.0E-6d) {
                this.f10322d.add(gcjToBaidu);
                latLng = gcjToBaidu;
            }
        }
    }
}
