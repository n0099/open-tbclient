package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MapStatusUpdate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o = "MapStatusUpdate";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f40234a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f40235b;

    /* renamed from: c  reason: collision with root package name */
    public LatLngBounds f40236c;

    /* renamed from: d  reason: collision with root package name */
    public int f40237d;

    /* renamed from: e  reason: collision with root package name */
    public int f40238e;

    /* renamed from: f  reason: collision with root package name */
    public float f40239f;

    /* renamed from: g  reason: collision with root package name */
    public int f40240g;

    /* renamed from: h  reason: collision with root package name */
    public int f40241h;

    /* renamed from: i  reason: collision with root package name */
    public float f40242i;
    public Point j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1074316518, "Lcom/baidu/mapapi/map/MapStatusUpdate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1074316518, "Lcom/baidu/mapapi/map/MapStatusUpdate;");
        }
    }

    public MapStatusUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    public MapStatusUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = i2;
    }

    private float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f2)) == null) ? (float) (Math.pow(2.0d, 18.0f - f2) / (SysOSUtil.getDensityDpi() / 310.0f)) : invokeF.floatValue;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, this, latLngBounds, eVar, i2, i3)) == null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
            return eVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), i2, i3);
        }
        return invokeLLII.floatValue;
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, mapStatus)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
            synchronized (this) {
                mapStatusUpdate.f40234a = mapStatus;
                mapStatusUpdate.f40236c = this.f40236c;
                mapStatusUpdate.k = this.k;
                mapStatusUpdate.l = this.l;
                mapStatusUpdate.m = this.m;
                mapStatusUpdate.n = this.n;
            }
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, float f2) {
        InterceptResult invokeCommon;
        double latitudeE6;
        double latitudeE62;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{latLngBounds, eVar, Float.valueOf(f2)})) == null) {
            if (latLngBounds == null || eVar == null) {
                return null;
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
            int i2 = this.k;
            double d2 = i2 * f2;
            int i3 = this.m;
            double d3 = i3 * f2;
            double d4 = this.l * f2;
            double d5 = this.n * f2;
            double longitudeE6 = i2 > i3 ? ll2mc.getLongitudeE6() - ((d2 - d3) / 2.0d) : i2 < i3 ? ll2mc.getLongitudeE6() + ((d3 - d2) / 2.0d) : ll2mc.getLongitudeE6();
            int i4 = this.l;
            int i5 = this.n;
            if (i4 < i5) {
                latitudeE62 = ll2mc.getLatitudeE6() - ((d5 - d4) / 2.0d);
            } else if (i4 <= i5) {
                latitudeE6 = ll2mc.getLatitudeE6();
                return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
            } else {
                latitudeE62 = ll2mc.getLatitudeE6();
                d4 -= d5;
            }
            latitudeE6 = latitudeE62 + (d4 / 2.0d);
            return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
        }
        return (LatLng) invokeCommon.objValue;
    }

    private boolean a(int i2, int i3, int i4, int i5, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), eVar})) == null) {
            MapStatusUpdate G = eVar.G();
            return (G != null && i2 == G.k && i3 == G.l && i4 == G.m && i5 == G.n) ? false : true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, latLngBounds, eVar)) == null) {
            MapStatusUpdate G = eVar.G();
            if (G == null) {
                return true;
            }
            LatLng latLng = latLngBounds.southwest;
            double d2 = latLng.latitude;
            double d3 = latLng.longitude;
            LatLng latLng2 = latLngBounds.northeast;
            double d4 = latLng2.latitude;
            double d5 = latLng2.longitude;
            LatLngBounds latLngBounds2 = G.f40236c;
            LatLng latLng3 = latLngBounds2.southwest;
            double d6 = latLng3.latitude;
            double d7 = latLng3.longitude;
            LatLng latLng4 = latLngBounds2.northeast;
            return (d2 == d6 && d3 == d7 && d4 == latLng4.latitude && d5 == latLng4.longitude) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.e eVar, MapStatus mapStatus) {
        InterceptResult invokeLL;
        MapStatus mapStatus2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, mapStatus)) == null) {
            if (eVar == null || mapStatus == null) {
                return null;
            }
            switch (this.p) {
                case 1:
                    return this.f40234a;
                case 2:
                    return new MapStatus(mapStatus.rotate, this.f40235b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
                case 3:
                    LatLngBounds latLngBounds = this.f40236c;
                    if (latLngBounds == null) {
                        return null;
                    }
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                    GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f40236c.northeast);
                    double longitudeE6 = ll2mc.getLongitudeE6();
                    double latitudeE6 = ll2mc2.getLatitudeE6();
                    double longitudeE62 = ll2mc2.getLongitudeE6();
                    int latitudeE62 = (int) ll2mc.getLatitudeE6();
                    WinRound winRound = mapStatus.f40222a.j;
                    return new MapStatus(mapStatus.rotate, this.f40236c.getCenter(), mapStatus.overlook, eVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top), mapStatus.targetScreen, null);
                case 4:
                    return new MapStatus(mapStatus.rotate, this.f40235b, mapStatus.overlook, this.f40239f, mapStatus.targetScreen, null);
                case 5:
                    GeoPoint b2 = eVar.b((eVar.H() / 2) + this.f40240g, (eVar.I() / 2) + this.f40241h);
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b2), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b2.getLongitudeE6(), b2.getLatitudeE6(), null);
                case 6:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.f40242i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 7:
                    Point point = this.j;
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(point.x, point.y)), mapStatus.overlook, mapStatus.zoom + this.f40242i, this.j, null);
                case 8:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f40239f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 9:
                    LatLngBounds latLngBounds2 = this.f40236c;
                    if (latLngBounds2 == null) {
                        return null;
                    }
                    GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                    GeoPoint ll2mc4 = CoordUtil.ll2mc(this.f40236c.northeast);
                    return new MapStatus(mapStatus.rotate, this.f40236c.getCenter(), mapStatus.overlook, eVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.f40237d, this.f40238e), mapStatus.targetScreen, null);
                case 10:
                    if (this.f40236c == null) {
                        return null;
                    }
                    int H = (eVar.H() - this.k) - this.m;
                    if (H < 0) {
                        H = eVar.H();
                    }
                    int I = (eVar.I() - this.l) - this.n;
                    if (I < 0) {
                        I = eVar.I();
                    }
                    float a2 = a(this.f40236c, eVar, H, I);
                    LatLng a3 = a(this.f40236c, eVar, a(a2));
                    if (a3 == null) {
                        return null;
                    }
                    boolean a4 = a(this.f40236c, eVar);
                    boolean a5 = a(this.k, this.l, this.m, this.n, eVar);
                    if (a4 || a5) {
                        mapStatus2 = new MapStatus(mapStatus.rotate, a3, mapStatus.overlook, a2, null, null);
                        eVar.a(a(mapStatus2));
                    } else if (eVar.G() == null) {
                        return null;
                    } else {
                        mapStatus2 = eVar.G().f40234a;
                    }
                    return mapStatus2;
                case 11:
                    if (this.f40236c == null) {
                        return null;
                    }
                    WinRound winRound2 = mapStatus.winRound;
                    int abs = Math.abs(winRound2.right - winRound2.left);
                    int abs2 = Math.abs(winRound2.bottom - winRound2.top);
                    GeoPoint ll2mc5 = CoordUtil.ll2mc(this.f40236c.southwest);
                    GeoPoint ll2mc6 = CoordUtil.ll2mc(this.f40236c.northeast);
                    double longitudeE63 = ll2mc5.getLongitudeE6();
                    double latitudeE63 = ll2mc6.getLatitudeE6();
                    double longitudeE64 = ll2mc6.getLongitudeE6();
                    double latitudeE64 = ll2mc5.getLatitudeE6();
                    float a6 = eVar.a((int) longitudeE63, (int) latitudeE63, (int) longitudeE64, (int) latitudeE64, (abs - this.k) - this.m, (abs2 - this.l) - Math.abs(this.n));
                    if (a6 == 0.0f) {
                        return null;
                    }
                    Point a7 = eVar.a(CoordUtil.ll2mc(this.f40236c.northeast));
                    Point a8 = eVar.a(CoordUtil.ll2mc(this.f40236c.southwest));
                    if (Math.abs(a7.y) < Math.abs(this.n)) {
                        a6 -= this.n / abs2;
                    }
                    if (longitudeE63 == longitudeE64 && latitudeE63 == latitudeE64) {
                        a6 = mapStatus.zoom;
                    }
                    int i2 = abs / 2;
                    int i3 = a8.y;
                    int i4 = abs2 - i3;
                    int i5 = this.n;
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(i2, i4 > i5 ? ((((abs2 / 2) + 0) + (i5 / 2)) - (this.l / 2)) + 50 : (((((abs2 / 2) + 0) + ((i5 - (abs2 - i3)) / 2)) + (i5 / 2)) - (this.l / 2)) + 50)), mapStatus.overlook, a6, mapStatus.targetScreen, null);
                default:
                    return null;
            }
        }
        return (MapStatus) invokeLL.objValue;
    }
}
