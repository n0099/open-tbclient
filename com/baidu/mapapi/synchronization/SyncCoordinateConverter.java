package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class SyncCoordinateConverter {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7392a;

    /* renamed from: b  reason: collision with root package name */
    public CoordType f7393b;

    /* loaded from: classes2.dex */
    public enum CoordType {
        COMMON,
        BD09LL
    }

    public static LatLng a(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    public static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    public static LatLng b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f7392a == null) {
            return null;
        }
        if (this.f7393b == null) {
            this.f7393b = CoordType.BD09LL;
        }
        int i = a.f7397a[this.f7393b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return b(this.f7392a);
        }
        return a(this.f7392a);
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.f7392a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.f7393b = coordType;
        return this;
    }
}
