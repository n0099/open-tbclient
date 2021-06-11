package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes2.dex */
public final class RoleOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7407a = "RoleOptions";

    /* renamed from: b  reason: collision with root package name */
    public String f7408b;

    /* renamed from: c  reason: collision with root package name */
    public int f7409c;

    /* renamed from: d  reason: collision with root package name */
    public String f7410d;

    /* renamed from: e  reason: collision with root package name */
    public String f7411e;

    /* renamed from: f  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7412f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f7413g;

    /* renamed from: h  reason: collision with root package name */
    public String f7414h;

    /* renamed from: i  reason: collision with root package name */
    public String f7415i;
    public LatLng j;
    public String k;
    public String l;
    public LatLng m;
    public String n;
    public String o;

    public RoleOptions() {
        this.f7408b = null;
        this.f7409c = 0;
        this.f7410d = null;
        this.f7411e = null;
        SyncCoordinateConverter.CoordType coordType = SyncCoordinateConverter.CoordType.BD09LL;
        this.f7412f = coordType;
        this.f7408b = null;
        this.f7409c = 0;
        this.f7410d = null;
        this.f7411e = null;
        this.f7413g = null;
        this.f7414h = null;
        this.f7415i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f7412f = coordType;
    }

    private LatLng a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f7412f).coord(latLng).convert();
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7412f;
    }

    public String getDriverId() {
        return this.f7410d;
    }

    public LatLng getDriverPosition() {
        return this.m;
    }

    public String getDriverPositionName() {
        return this.o;
    }

    public String getDriverPositionPoiUid() {
        return this.n;
    }

    public LatLng getEndPosition() {
        return this.j;
    }

    public String getEndPositionName() {
        return this.l;
    }

    public String getEndPositionPoiUid() {
        return this.k;
    }

    public String getOrderId() {
        return this.f7408b;
    }

    public int getRoleType() {
        return this.f7409c;
    }

    public LatLng getStartPosition() {
        return this.f7413g;
    }

    public String getStartPositionName() {
        return this.f7415i;
    }

    public String getStartPositionPoiUid() {
        return this.f7414h;
    }

    public String getUserId() {
        return this.f7411e;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f7412f = coordType;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: CoordType only can be BD09LL or COMMON, please check!");
    }

    public RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: driverId is null");
        }
        this.f7410d = str;
        return this;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.m = null;
            return this;
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f7412f) {
            latLng = a(latLng);
        }
        this.m = latLng;
        return this;
    }

    public RoleOptions setDriverPositionName(String str) {
        this.o = str;
        return this;
    }

    public RoleOptions setDriverPositionPoiUid(String str) {
        this.n = str;
        return this;
    }

    public RoleOptions setEndPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7412f) {
                latLng = a(latLng);
            }
            this.j = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: endPosition is null, must be applied!");
    }

    public RoleOptions setEndPositionName(String str) {
        this.l = str;
        return this;
    }

    public RoleOptions setEndPositionPoiUid(String str) {
        this.k = str;
        return this;
    }

    public RoleOptions setOrderId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: orderId is null.");
        }
        this.f7408b = str;
        return this;
    }

    public RoleOptions setRoleType(int i2) {
        if (i2 == 0) {
            this.f7409c = i2;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: role type is invalid: " + i2);
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7412f) {
                latLng = a(latLng);
            }
            this.f7413g = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: StartPosition is null, must be applied!");
    }

    public RoleOptions setStartPositionName(String str) {
        this.f7415i = str;
        return this;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        this.f7414h = str;
        return this;
    }

    public RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: user id is null");
        }
        this.f7411e = str;
        return this;
    }
}
