package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class Overlay {
    protected a listener;
    public com.baidu.mapsdkplatform.comapi.map.h type;
    String v = System.currentTimeMillis() + BaseRequestAction.SPLITE + hashCode();
    int w;
    boolean x;
    Bundle y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void a(Overlay overlay);

        void b(Overlay overlay);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i));
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.v);
        bundle.putInt("type", this.type.ordinal());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.v);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt("visibility", this.x ? 1 : 0);
        bundle.putInt("z_index", this.w);
        return bundle;
    }

    public Bundle getExtraInfo() {
        return this.y;
    }

    public int getZIndex() {
        return this.w;
    }

    public boolean isVisible() {
        return this.x;
    }

    public void remove() {
        this.listener.a(this);
    }

    public void setExtraInfo(Bundle bundle) {
        this.y = bundle;
    }

    public void setVisible(boolean z) {
        this.x = z;
        this.listener.b(this);
    }

    public void setZIndex(int i) {
        this.w = i;
        this.listener.b(this);
    }
}
