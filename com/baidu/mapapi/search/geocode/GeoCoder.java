package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
/* loaded from: classes3.dex */
public class GeoCoder extends n {
    public com.baidu.platform.core.c.d a = new com.baidu.platform.core.c.a();
    public boolean b;

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
        com.baidu.platform.core.c.d dVar = this.a;
        if (dVar != null) {
            if (geoCodeOption != null && geoCodeOption.mAddress != null && geoCodeOption.mCity != null) {
                return dVar.a(geoCodeOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.a != null) {
            if (reverseGeoCodeOption != null && reverseGeoCodeOption.getLocation() != null) {
                return this.a.a(reverseGeoCodeOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        com.baidu.platform.core.c.d dVar = this.a;
        if (dVar != null) {
            if (onGetGeoCoderResultListener != null) {
                dVar.a(onGetGeoCoderResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }
}
