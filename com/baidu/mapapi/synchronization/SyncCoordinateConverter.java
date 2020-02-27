package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes8.dex */
public class SyncCoordinateConverter {
    private LatLng a;
    private CoordType b;

    /* loaded from: classes8.dex */
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
        if (this.a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = CoordType.BD09LL;
        }
        switch (this.b) {
            case COMMON:
                return a(this.a);
            case BD09LL:
                return b(this.a);
            default:
                return null;
        }
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }
}
