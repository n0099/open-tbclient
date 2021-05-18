package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class Overlay {
    public boolean A;
    public Bundle B;
    public a listener;
    public com.baidu.mapsdkplatform.comapi.map.h type;
    public String y = System.currentTimeMillis() + "_" + hashCode();
    public int z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Overlay overlay);

        void b(Overlay overlay);
    }

    public static void a(int i2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i2 >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i2 >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i2 & 255) / 255.0f);
        bundle2.putFloat("alpha", (i2 >>> 24) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    public static void a(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i2));
            dArr[i2] = ll2mc.getLongitudeE6();
            dArr2[i2] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.y);
        bundle.putInt("type", this.type.ordinal());
        return bundle;
    }

    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.y);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt("visibility", this.A ? 1 : 0);
        bundle.putInt("z_index", this.z);
        return bundle;
    }

    public Bundle getExtraInfo() {
        return this.B;
    }

    public int getZIndex() {
        return this.z;
    }

    public boolean isVisible() {
        return this.A;
    }

    public void remove() {
        this.listener.a(this);
    }

    public void setExtraInfo(Bundle bundle) {
        this.B = bundle;
    }

    public void setVisible(boolean z) {
        this.A = z;
        this.listener.b(this);
    }

    public void setZIndex(int i2) {
        this.z = i2;
        this.listener.b(this);
    }
}
