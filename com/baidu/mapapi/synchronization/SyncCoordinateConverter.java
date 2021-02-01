package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes4.dex */
public class SyncCoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2941a;

    /* renamed from: b  reason: collision with root package name */
    private CoordType f2942b;

    /* loaded from: classes4.dex */
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
        if (this.f2941a == null) {
            return null;
        }
        if (this.f2942b == null) {
            this.f2942b = CoordType.BD09LL;
        }
        switch (this.f2942b) {
            case COMMON:
                return a(this.f2941a);
            case BD09LL:
                return b(this.f2941a);
            default:
                return null;
        }
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.f2941a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.f2942b = coordType;
        return this;
    }
}
