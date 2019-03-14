package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes5.dex */
public class GeoCoder extends l {
    private com.baidu.platform.core.b.d a = new com.baidu.platform.core.b.a();
    private boolean b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        if (this.a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
            throw new IllegalArgumentException("option or address or city can not be null");
        }
        return this.a.a(geoCodeOption);
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
            throw new IllegalArgumentException("option or mLocation can not be null");
        }
        return this.a.a(reverseGeoCodeOption);
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        if (this.a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.a.a(onGetGeoCoderResultListener);
    }
}
