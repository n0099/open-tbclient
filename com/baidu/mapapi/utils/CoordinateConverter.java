package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.location.CoordinateType;
/* loaded from: classes15.dex */
public class CoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f3061a;

    /* renamed from: b  reason: collision with root package name */
    private CoordType f3062b;

    /* loaded from: classes15.dex */
    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    private static LatLng a(LatLng latLng) {
        return a(latLng, CoordinateType.WGS84);
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    private static LatLng b(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    private static LatLng c(LatLng latLng) {
        return a(latLng, CoordinateType.BD09MC);
    }

    private static LatLng d(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f3061a == null) {
            return null;
        }
        if (this.f3062b == null) {
            this.f3062b = CoordType.GPS;
        }
        switch (this.f3062b) {
            case COMMON:
                return b(this.f3061a);
            case GPS:
                return a(this.f3061a);
            case BD09LL:
                return d(this.f3061a);
            case BD09MC:
                return c(this.f3061a);
            default:
                return null;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f3061a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f3062b = coordType;
        return this;
    }
}
