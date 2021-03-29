package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes2.dex */
public final class RoleOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7349a = "RoleOptions";

    /* renamed from: b  reason: collision with root package name */
    public String f7350b;

    /* renamed from: c  reason: collision with root package name */
    public int f7351c;

    /* renamed from: d  reason: collision with root package name */
    public String f7352d;

    /* renamed from: e  reason: collision with root package name */
    public String f7353e;

    /* renamed from: f  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7354f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f7355g;

    /* renamed from: h  reason: collision with root package name */
    public String f7356h;
    public String i;
    public LatLng j;
    public String k;
    public String l;
    public LatLng m;
    public String n;
    public String o;

    public RoleOptions() {
        this.f7350b = null;
        this.f7351c = 0;
        this.f7352d = null;
        this.f7353e = null;
        SyncCoordinateConverter.CoordType coordType = SyncCoordinateConverter.CoordType.BD09LL;
        this.f7354f = coordType;
        this.f7350b = null;
        this.f7351c = 0;
        this.f7352d = null;
        this.f7353e = null;
        this.f7355g = null;
        this.f7356h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f7354f = coordType;
    }

    private LatLng a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f7354f).coord(latLng).convert();
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7354f;
    }

    public String getDriverId() {
        return this.f7352d;
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
        return this.f7350b;
    }

    public int getRoleType() {
        return this.f7351c;
    }

    public LatLng getStartPosition() {
        return this.f7355g;
    }

    public String getStartPositionName() {
        return this.i;
    }

    public String getStartPositionPoiUid() {
        return this.f7356h;
    }

    public String getUserId() {
        return this.f7353e;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f7354f = coordType;
            return this;
        }
        throw new IllegalArgumentException("CoordType only can be BD09LL or COMMON, please check!");
    }

    public RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("driverId is null");
        }
        this.f7352d = str;
        return this;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.m = null;
            return this;
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f7354f) {
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
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7354f) {
                latLng = a(latLng);
            }
            this.j = latLng;
            return this;
        }
        throw new IllegalArgumentException("endPosition is null, must be applied!");
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
            throw new IllegalArgumentException("orderId is null.");
        }
        this.f7350b = str;
        return this;
    }

    public RoleOptions setRoleType(int i) {
        if (i == 0) {
            this.f7351c = i;
            return this;
        }
        throw new IllegalArgumentException("role type is invalid: " + i);
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7354f) {
                latLng = a(latLng);
            }
            this.f7355g = latLng;
            return this;
        }
        throw new IllegalArgumentException("StartPosition is null, must be applied!");
    }

    public RoleOptions setStartPositionName(String str) {
        this.i = str;
        return this;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        this.f7356h = str;
        return this;
    }

    public RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("user id is null");
        }
        this.f7353e = str;
        return this;
    }
}
