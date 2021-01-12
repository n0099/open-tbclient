package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes6.dex */
public class SyncCoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2943a;

    /* renamed from: b  reason: collision with root package name */
    private CoordType f2944b;

    /* loaded from: classes6.dex */
    public enum CoordType {
        COMMON,
        BD09LL
    }

    private static LatLng a(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    private static LatLng b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f2943a == null) {
            return null;
        }
        if (this.f2944b == null) {
            this.f2944b = CoordType.BD09LL;
        }
        switch (this.f2944b) {
            case COMMON:
                return a(this.f2943a);
            case BD09LL:
                return b(this.f2943a);
            default:
                return null;
        }
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.f2943a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.f2944b = coordType;
        return this;
    }
}
