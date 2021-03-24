package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class CoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7388a;

    /* renamed from: b  reason: collision with root package name */
    public CoordType f7389b;

    /* loaded from: classes2.dex */
    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    public static LatLng a(LatLng latLng) {
        return a(latLng, CoordinateType.WGS84);
    }

    public static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    public static LatLng b(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    public static LatLng c(LatLng latLng) {
        return a(latLng, CoordinateType.BD09MC);
    }

    public static LatLng d(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f7388a == null) {
            return null;
        }
        if (this.f7389b == null) {
            this.f7389b = CoordType.GPS;
        }
        int i = a.f7390a[this.f7389b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return c(this.f7388a);
                }
                return d(this.f7388a);
            }
            return a(this.f7388a);
        }
        return b(this.f7388a);
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f7388a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f7389b = coordType;
        return this;
    }
}
