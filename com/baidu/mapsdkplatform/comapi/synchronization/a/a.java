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
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.k;
import com.baidu.mapsdkplatform.comapi.synchronization.data.l;
import com.baidu.mapsdkplatform.comapi.synchronization.render.d;
import com.baidu.mapsdkplatform.comapi.synchronization.render.e;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes2.dex */
public class a implements k, d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7745a = "a";

    /* renamed from: b  reason: collision with root package name */
    public l f7746b;

    /* renamed from: c  reason: collision with root package name */
    public e f7747c;

    /* renamed from: d  reason: collision with root package name */
    public SynchronizationDisplayListener f7748d;

    public a(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f7746b = null;
        this.f7747c = null;
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: Context invalid, please check!");
        }
        if (baiduMap == null || !(baiduMap instanceof BaiduMap)) {
            throw new IllegalArgumentException("BDMapSDKException: BaiduMap is null or invalid, please check!");
        }
        if (!b(roleOptions)) {
            throw new IllegalArgumentException("BDMapSDKException: RoleOptions is invalid, please check!");
        }
        l lVar = new l(roleOptions, displayOptions);
        this.f7746b = lVar;
        lVar.a(this);
        e eVar = new e(context, baiduMap);
        this.f7747c = eVar;
        eVar.a(this);
    }

    private boolean a(LatLng latLng, RoleOptions roleOptions) {
        double d2;
        if (latLng == null) {
            return false;
        }
        double d3 = -180.0d;
        double d4 = 180.0d;
        double d5 = -90.0d;
        double d6 = 90.0d;
        double d7 = 0.0d;
        if (SyncCoordinateConverter.CoordType.COMMON == roleOptions.getCoordType()) {
            SyncCoordinateConverter syncCoordinateConverter = new SyncCoordinateConverter();
            LatLng convert = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(-90.0d, -180.0d)).convert();
            double d8 = convert.longitude;
            double d9 = convert.latitude;
            LatLng convert2 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(90.0d, 180.0d)).convert();
            double d10 = convert2.longitude;
            double d11 = convert2.latitude;
            LatLng convert3 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(0.0d, 0.0d)).convert();
            d7 = convert3.longitude;
            d2 = convert3.latitude;
            d4 = d10;
            d6 = d11;
            d3 = d8;
            d5 = d9;
        } else {
            d2 = 0.0d;
        }
        if (Double.valueOf(d7).compareTo(Double.valueOf(latLng.longitude)) == 0 && Double.valueOf(d2).compareTo(Double.valueOf(latLng.latitude)) == 0) {
            return false;
        }
        double d12 = latLng.longitude;
        if (d12 >= d3 && d12 <= d4) {
            double d13 = latLng.latitude;
            if (d13 >= d5 && d13 <= d6) {
                return true;
            }
        }
        return false;
    }

    private boolean a(SyncCoordinateConverter.CoordType coordType) {
        return SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType;
    }

    private boolean b(RoleOptions roleOptions) {
        if (roleOptions == null || roleOptions.getOrderId() == null || roleOptions.getOrderId().equals("") || roleOptions.getRoleType() != 0 || roleOptions.getDriverId() == null || roleOptions.getDriverId().equals("") || roleOptions.getUserId() == null || roleOptions.getUserId().equals("") || !a(roleOptions.getCoordType()) || !a(roleOptions.getStartPosition(), roleOptions)) {
            if (roleOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7745a, "The roleOptions is null");
                return false;
            }
            String str = f7745a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "The roleOptions content is: OrderId = " + roleOptions.getOrderId() + "; DriverId = " + roleOptions.getDriverId() + "; UserId = " + roleOptions.getUserId() + "; StartPosition = " + roleOptions.getStartPosition() + "; EndPosition = " + roleOptions.getEndPosition() + "; DriverPosition = " + roleOptions.getDriverPosition() + "; CoordType = " + roleOptions.getCoordType());
            return false;
        }
        return true;
    }

    private boolean e(int i2) {
        return i2 >= 0 && i2 <= 5;
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7745a, MissionEvent.MESSAGE_RESUME);
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.a();
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void a(float f2, long j) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onRoutePlanInfoFreshFinished(f2, j);
        }
    }

    public void a(int i2) {
        String str = f7745a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
        if (!e(i2)) {
            SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
            if (synchronizationDisplayListener != null) {
                synchronizationDisplayListener.onSynchronizationProcessResult(1002, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_STATE_INVALID);
            }
            i2 = 0;
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.a(i2);
        }
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.a(i2);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.a(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.render.d
    public void a(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
        }
    }

    public void a(View view) {
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.a(view);
        }
    }

    public void a(DisplayOptions displayOptions) {
        l lVar = this.f7746b;
        if (lVar == null || displayOptions == null) {
            return;
        }
        lVar.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        if (roleOptions == null || !b(roleOptions)) {
            SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
            if (synchronizationDisplayListener != null) {
                synchronizationDisplayListener.onSynchronizationProcessResult(1003, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID);
                return;
            }
            return;
        }
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.a(roleOptions);
        }
    }

    public void a(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (synchronizationDisplayListener != null) {
            this.f7748d = synchronizationDisplayListener;
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7745a, "SynchronizationDisplayListener is null, must be applied.");
            throw new IllegalArgumentException("BDMapSDKException: synchronizationDisplayListener is null");
        }
    }

    public void a(boolean z) {
        c.f7791b = z;
    }

    public void b() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7745a, MissionEvent.MESSAGE_PAUSE);
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.b();
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void b(int i2) {
        if (i2 < 2) {
            i2 = 2;
        }
        if (i2 > 30) {
            i2 = 30;
        }
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.b(i2);
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.b(i2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void b(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
        }
    }

    public void b(View view) {
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.b(view);
        }
    }

    public void b(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f7748d != null) {
            this.f7748d = null;
        }
    }

    public void c() {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7745a, "release");
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.c();
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.f();
        }
        if (this.f7748d != null) {
            this.f7748d = null;
        }
    }

    public void c(int i2) {
        if (i2 < 10) {
            i2 = 10;
        }
        if (i2 > 30) {
            i2 = 30;
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.c(i2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.k
    public void c(int i2, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f7748d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i2, str);
        }
    }

    public void c(View view) {
        l lVar = this.f7746b;
        if (lVar != null) {
            lVar.c(view);
        }
    }

    public Marker d() {
        e eVar = this.f7747c;
        if (eVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7745a, "Data manager instance is null");
            return null;
        }
        return eVar.c();
    }

    public void d(int i2) {
        if (i2 < 5) {
            i2 = 5;
        }
        if (i2 > 30) {
            i2 = 30;
        }
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.d(i2);
        }
    }

    public Marker e() {
        e eVar = this.f7747c;
        if (eVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7745a, "Data manager instance is null");
            return null;
        }
        return eVar.d();
    }

    public Marker f() {
        e eVar = this.f7747c;
        if (eVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7745a, "Data manager instance is null");
            return null;
        }
        return eVar.e();
    }

    public void g() {
        e eVar = this.f7747c;
        if (eVar != null) {
            eVar.g();
        }
    }

    public boolean h() {
        return c.f7791b;
    }
}
