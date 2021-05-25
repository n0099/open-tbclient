package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes2.dex */
public class GeoCoder extends l {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.b.d f7203a = new com.baidu.platform.core.b.a();

    /* renamed from: b  reason: collision with root package name */
    public boolean f7204b;

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.f7204b) {
            return;
        }
        this.f7204b = true;
        this.f7203a.a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        com.baidu.platform.core.b.d dVar = this.f7203a;
        if (dVar != null) {
            if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
            }
            return dVar.a(geoCodeOption);
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f7203a != null) {
            if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
            }
            return this.f7203a.a(reverseGeoCodeOption);
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        com.baidu.platform.core.b.d dVar = this.f7203a;
        if (dVar == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        dVar.a(onGetGeoCoderResultListener);
    }
}
