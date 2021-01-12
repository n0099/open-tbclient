package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes6.dex */
public class CoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2958a;

    /* renamed from: b  reason: collision with root package name */
    private CoordType f2959b;

    /* loaded from: classes6.dex */
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
        if (this.f2958a == null) {
            return null;
        }
        if (this.f2959b == null) {
            this.f2959b = CoordType.GPS;
        }
        switch (this.f2959b) {
            case COMMON:
                return b(this.f2958a);
            case GPS:
                return a(this.f2958a);
            case BD09LL:
                return d(this.f2958a);
            case BD09MC:
                return c(this.f2958a);
            default:
                return null;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f2958a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f2959b = coordType;
        return this;
    }
}
