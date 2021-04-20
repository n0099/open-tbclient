package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes2.dex */
public final class RoleOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7384a = "RoleOptions";

    /* renamed from: b  reason: collision with root package name */
    public String f7385b;

    /* renamed from: c  reason: collision with root package name */
    public int f7386c;

    /* renamed from: d  reason: collision with root package name */
    public String f7387d;

    /* renamed from: e  reason: collision with root package name */
    public String f7388e;

    /* renamed from: f  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7389f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f7390g;

    /* renamed from: h  reason: collision with root package name */
    public String f7391h;
    public String i;
    public LatLng j;
    public String k;
    public String l;
    public LatLng m;
    public String n;
    public String o;

    public RoleOptions() {
        this.f7385b = null;
        this.f7386c = 0;
        this.f7387d = null;
        this.f7388e = null;
        SyncCoordinateConverter.CoordType coordType = SyncCoordinateConverter.CoordType.BD09LL;
        this.f7389f = coordType;
        this.f7385b = null;
        this.f7386c = 0;
        this.f7387d = null;
        this.f7388e = null;
        this.f7390g = null;
        this.f7391h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f7389f = coordType;
    }

    private LatLng a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f7389f).coord(latLng).convert();
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7389f;
    }

    public String getDriverId() {
        return this.f7387d;
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
        return this.f7385b;
    }

    public int getRoleType() {
        return this.f7386c;
    }

    public LatLng getStartPosition() {
        return this.f7390g;
    }

    public String getStartPositionName() {
        return this.i;
    }

    public String getStartPositionPoiUid() {
        return this.f7391h;
    }

    public String getUserId() {
        return this.f7388e;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f7389f = coordType;
            return this;
        }
        throw new IllegalArgumentException("CoordType only can be BD09LL or COMMON, please check!");
    }

    public RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("driverId is null");
        }
        this.f7387d = str;
        return this;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.m = null;
            return this;
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f7389f) {
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
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7389f) {
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
        this.f7385b = str;
        return this;
    }

    public RoleOptions setRoleType(int i) {
        if (i == 0) {
            this.f7386c = i;
            return this;
        }
        throw new IllegalArgumentException("role type is invalid: " + i);
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f7389f) {
                latLng = a(latLng);
            }
            this.f7390g = latLng;
            return this;
        }
        throw new IllegalArgumentException("StartPosition is null, must be applied!");
    }

    public RoleOptions setStartPositionName(String str) {
        this.i = str;
        return this;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        this.f7391h = str;
        return this;
    }

    public RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("user id is null");
        }
        this.f7388e = str;
        return this;
    }
}
