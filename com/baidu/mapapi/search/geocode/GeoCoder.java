package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes6.dex */
public class GeoCoder extends l {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.platform.core.b.d f2868a = new com.baidu.platform.core.b.a();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2869b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.f2869b) {
            return;
        }
        this.f2869b = true;
        this.f2868a.a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        if (this.f2868a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
            throw new IllegalArgumentException("option or address or city can not be null");
        }
        return this.f2868a.a(geoCodeOption);
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f2868a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
            throw new IllegalArgumentException("option or mLocation can not be null");
        }
        return this.f2868a.a(reverseGeoCodeOption);
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        if (this.f2868a == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.f2868a.a(onGetGeoCoderResultListener);
    }
}
