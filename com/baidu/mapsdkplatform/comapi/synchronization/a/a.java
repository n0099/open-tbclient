package com.baidu.mapsdkplatform.comapi.synchronization.a;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapapi.synchronization.SynchronizationDisplayListener;
import com.baidu.mapsdkplatform.comapi.synchronization.data.k;
import com.baidu.mapsdkplatform.comapi.synchronization.data.l;
import com.baidu.mapsdkplatform.comapi.synchronization.render.d;
import com.baidu.mapsdkplatform.comapi.synchronization.render.e;
/* loaded from: classes5.dex */
public class a implements k, d {
    private static final String a = a.class.getSimpleName();
    private l b;
    private e c;
    private SynchronizationDisplayListener d;

    public a(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.b = null;
        this.c = null;
        if (context == null) {
            throw new IllegalArgumentException("Context invalid, please check!");
        }
        if (baiduMap == null || !(baiduMap instanceof BaiduMap)) {
            throw new IllegalArgumentException("BaiduMap is null or invalid, please check!");
        }
        if (!b(roleOptions)) {
            throw new IllegalArgumentException("RoleOptions is invalid, please check!");
        }
        this.b = new l(roleOptions, displayOptions);
        this.b.a(this);
        this.c = new e(context, baiduMap);
        this.c.a(this);
    }

    private boolean a(LatLng latLng, RoleOptions roleOptions) {
        if (latLng == null) {
            return false;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = -180.0d;
        double d4 = 180.0d;
        double d5 = -90.0d;
        double d6 = 90.0d;
        if (SyncCoordinateConverter.CoordType.COMMON == roleOptions.getCoordType()) {
            SyncCoordinateConverter syncCoordinateConverter = new SyncCoordinateConverter();
            LatLng convert = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(-90.0d, -180.0d)).convert();
            d3 = convert.longitude;
            d5 = convert.latitude;
            LatLng convert2 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(90.0d, 180.0d)).convert();
            d4 = convert2.longitude;
            d6 = convert2.latitude;
            LatLng convert3 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(0.0d, 0.0d)).convert();
            d = convert3.longitude;
            d2 = convert3.latitude;
        }
        return !(Double.valueOf(d).compareTo(Double.valueOf(latLng.longitude)) == 0 && Double.valueOf(d2).compareTo(Double.valueOf(latLng.latitude)) == 0) && latLng.longitude >= d3 && latLng.longitude <= d4 && latLng.latitude >= d5 && latLng.latitude <= d6;
    }

    private boolean a(SyncCoordinateConverter.CoordType coordType) {
        return SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType;
    }

    private boolean b(RoleOptions roleOptions) {
        if (roleOptions == null || roleOptions.getOrderId() == null || roleOptions.getOrderId().equals("") || roleOptions.getRoleType() != 0 || roleOptions.getDriverId() == null || roleOptions.getDriverId().equals("") || roleOptions.getUserId() == null || roleOptions.getUserId().equals("") || !a(roleOptions.getCoordType()) || !a(roleOptions.getStartPosition(), roleOptions)) {
            if (roleOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The roleOptions is null");
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The roleOptions content is: OrderId = " + roleOptions.getOrderId() + "; DriverId = " + roleOptions.getDriverId() + "; UserId = " + roleOptions.getUserId() + "; StartPosition = " + roleOptions.getStartPosition() + "; EndPosition = " + roleOptions.getEndPosition() + "; DriverPosition = " + roleOptions.getDriverPosition() + "; CoordType = " + roleOptions.getCoordType());
            }
            return false;
        }
        return true;
    }

    private boolean e(int i) {
        return i >= 0 && i <= 5;
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "onResume");
        if (this.b != null) {
            this.b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void a(float f, long j) {
        if (this.d != null) {
            this.d.onRoutePlanInfoFreshFinished(f, j);
        }
    }

    public void a(int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(a, "The order state = " + i);
        if (!e(i)) {
            if (this.d != null) {
                this.d.onSynchronizationProcessResult(1002, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_STATE_INVALID);
            }
            i = 0;
        }
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.render.d
    public void a(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void a(View view) {
        if (this.b != null) {
            this.b.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        if (this.b == null || displayOptions == null) {
            return;
        }
        this.b.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        if (roleOptions == null || !b(roleOptions)) {
            if (this.d != null) {
                this.d.onSynchronizationProcessResult(1003, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID);
            }
        } else if (this.b != null) {
            this.b.a(roleOptions);
        }
    }

    public void a(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (synchronizationDisplayListener == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SynchronizationDisplayListener is null, must be applied.");
            throw new IllegalArgumentException("synchronizationDisplayListener is null");
        } else {
            this.d = synchronizationDisplayListener;
        }
    }

    public void b() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "onPause");
        if (this.b != null) {
            this.b.b();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    public void b(int i) {
        int i2 = i >= 5 ? i : 5;
        int i3 = i2 <= 30 ? i2 : 30;
        if (this.b != null) {
            this.b.b(i3);
        }
        if (this.c != null) {
            this.c.b(i3);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void b(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void b(View view) {
        if (this.b != null) {
            this.b.b(view);
        }
    }

    public void b(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.d != null) {
            this.d = null;
        }
    }

    public void c() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "release");
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.f();
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    public void c(int i) {
        int i2 = i >= 10 ? i : 10;
        int i3 = i2 <= 30 ? i2 : 30;
        if (this.c != null) {
            this.c.c(i3);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void c(int i, String str) {
        if (this.d != null) {
            this.d.onSynchronizationProcessResult(i, str);
        }
    }

    public void c(View view) {
        if (this.b != null) {
            this.b.c(view);
        }
    }

    public Marker d() {
        if (this.c == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
            return null;
        }
        return this.c.c();
    }

    public void d(int i) {
        int i2 = i >= 5 ? i : 5;
        int i3 = i2 <= 30 ? i2 : 30;
        if (this.c != null) {
            this.c.d(i3);
        }
    }

    public Marker e() {
        if (this.c == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
            return null;
        }
        return this.c.d();
    }

    public Marker f() {
        if (this.c == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Data manager instance is null");
            return null;
        }
        return this.c.e();
    }

    public void g() {
        if (this.c != null) {
            this.c.g();
        }
    }
}
