package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes2.dex */
public final class RoleOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7464a = "RoleOptions";

    /* renamed from: b  reason: collision with root package name */
    public String f7465b;

    /* renamed from: c  reason: collision with root package name */
    public int f7466c;

    /* renamed from: d  reason: collision with root package name */
    public String f7467d;

    /* renamed from: e  reason: collision with root package name */
    public String f7468e;

    /* renamed from: f  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7469f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f7470g;

    /* renamed from: h  reason: collision with root package name */
    public String f7471h;

    /* renamed from: i  reason: collision with root package name */
    public String f7472i;
    public LatLng j;
    public String k;
    public String l;
    public LatLng m;
    public String n;
    public String o;

    public RoleOptions() {
        this.f7465b = null;
        this.f7466c = 0;
        this.f7467d = null;
        this.f7468e = null;
        SyncCoordinateConverter.CoordType coordType = SyncCoordinateConverter.CoordType.BD09LL;
        this.f7469f = coordType;
        this.f7465b = null;
        this.f7466c = 0;
        this.f7467d = null;
        this.f7468e = null;
        this.f7470g = null;
        this.f7471h = null;
        this.f7472i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f7469f = coordType;
    }

    private LatLng a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f7469f).coord(latLng).convert();
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7469f;
    }

    public String getDriverId() {
        return this.f7467d;
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
        return this.f7465b;
    }

    public int getRoleType() {
        return this.f7466c;
    }

    public LatLng getStartPosition() {
        return this.f7470g;
    }

    public String getStartPositionName() {
        return this.f7472i;
    }

    public String getStartPositionPoiUid() {
        return this.f7471h;
    }

    public String getUserId() {
        return this.f7468e;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f7469f = coordType;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: CoordType only can be BD09LL or COMMON, please check!");
    }

    public RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: driverId is null");
        }
        this.f7467d = str;
        return this;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.m = null;
            return this;
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f7469f) {
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
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7469f) {
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
        this.f7465b = str;
        return this;
    }

    public RoleOptions setRoleType(int i2) {
        if (i2 == 0) {
            this.f7466c = i2;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: role type is invalid: " + i2);
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7469f) {
                latLng = a(latLng);
            }
            this.f7470g = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: StartPosition is null, must be applied!");
    }

    public RoleOptions setStartPositionName(String str) {
        this.f7472i = str;
        return this;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        this.f7471h = str;
        return this;
    }

    public RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: user id is null");
        }
        this.f7468e = str;
        return this;
    }
}
