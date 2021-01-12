package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
/* loaded from: classes6.dex */
public final class RoleOptions {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2941a = RoleOptions.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private String f2942b;
    private int c;
    private String d;
    private String e;
    private SyncCoordinateConverter.CoordType f;
    private LatLng g = null;
    private String h = null;
    private String i = null;
    private LatLng j = null;
    private String k = null;
    private String l = null;
    private LatLng m = null;
    private String n = null;
    private String o = null;

    public RoleOptions() {
        this.f2942b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = SyncCoordinateConverter.CoordType.BD09LL;
        this.f2942b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = SyncCoordinateConverter.CoordType.BD09LL;
    }

    private LatLng a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f).coord(latLng).convert();
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f;
    }

    public String getDriverId() {
        return this.d;
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
        return this.f2942b;
    }

    public int getRoleType() {
        return this.c;
    }

    public LatLng getStartPosition() {
        return this.g;
    }

    public String getStartPositionName() {
        return this.i;
    }

    public String getStartPositionPoiUid() {
        return this.h;
    }

    public String getUserId() {
        return this.e;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f = coordType;
            return this;
        }
        throw new IllegalArgumentException("CoordType only can be BD09LL or COMMON, please check!");
    }

    public RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("driverId is null");
        }
        this.d = str;
        return this;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.m = null;
        } else {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f) {
                latLng = a(latLng);
            }
            this.m = latLng;
        }
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
        if (latLng == null) {
            throw new IllegalArgumentException("endPosition is null, must be applied!");
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f) {
            latLng = a(latLng);
        }
        this.j = latLng;
        return this;
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
        this.f2942b = str;
        return this;
    }

    public RoleOptions setRoleType(int i) {
        if (i != 0) {
            throw new IllegalArgumentException("role type is invalid: " + i);
        }
        this.c = i;
        return this;
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("StartPosition is null, must be applied!");
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f) {
            latLng = a(latLng);
        }
        this.g = latLng;
        return this;
    }

    public RoleOptions setStartPositionName(String str) {
        this.i = str;
        return this;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        this.h = str;
        return this;
    }

    public RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("user id is null");
        }
        this.e = str;
        return this;
    }
}
