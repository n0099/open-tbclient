package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class MapStatusUpdate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o = "MapStatusUpdate";
    public transient /* synthetic */ FieldHolder $fh;
    public MapStatus a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f26208b;

    /* renamed from: c  reason: collision with root package name */
    public LatLngBounds f26209c;

    /* renamed from: d  reason: collision with root package name */
    public int f26210d;

    /* renamed from: e  reason: collision with root package name */
    public int f26211e;

    /* renamed from: f  reason: collision with root package name */
    public float f26212f;

    /* renamed from: g  reason: collision with root package name */
    public int f26213g;

    /* renamed from: h  reason: collision with root package name */
    public int f26214h;
    public float i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public MapStatusUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.p = i;
    }

    private float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f2)) == null) ? (float) (Math.pow(2.0d, 18.0f - f2) / (SysOSUtil.getDensityDpi() / 310.0f)) : invokeF.floatValue;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, this, latLngBounds, eVar, i, i2)) == null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
            return eVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), i, i2);
        }
        return invokeLLII.floatValue;
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, mapStatus)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
            synchronized (this) {
                mapStatusUpdate.a = mapStatus;
                mapStatusUpdate.f26209c = this.f26209c;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{latLngBounds, eVar, Float.valueOf(f2)})) == null) {
            if (latLngBounds == null || eVar == null) {
                return null;
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
            int i = this.k;
            double d2 = i * f2;
            int i2 = this.m;
            double d3 = i2 * f2;
            double d4 = this.l * f2;
            double d5 = this.n * f2;
            double longitudeE6 = i > i2 ? ll2mc.getLongitudeE6() - ((d2 - d3) / 2.0d) : i < i2 ? ll2mc.getLongitudeE6() + ((d3 - d2) / 2.0d) : ll2mc.getLongitudeE6();
            int i3 = this.l;
            int i4 = this.n;
            if (i3 < i4) {
                latitudeE62 = ll2mc.getLatitudeE6() - ((d5 - d4) / 2.0d);
            } else if (i3 <= i4) {
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

    private boolean a(int i, int i2, int i3, int i4, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar})) == null) {
            MapStatusUpdate G = eVar.G();
            return (G != null && i == G.k && i2 == G.l && i3 == G.m && i4 == G.n) ? false : true;
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
            LatLngBounds latLngBounds2 = G.f26209c;
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
                    return this.a;
                case 2:
                    return new MapStatus(mapStatus.rotate, this.f26208b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
                case 3:
                    LatLngBounds latLngBounds = this.f26209c;
                    if (latLngBounds == null) {
                        return null;
                    }
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                    GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f26209c.northeast);
                    double longitudeE6 = ll2mc.getLongitudeE6();
                    double latitudeE6 = ll2mc2.getLatitudeE6();
                    double longitudeE62 = ll2mc2.getLongitudeE6();
                    int latitudeE62 = (int) ll2mc.getLatitudeE6();
                    WinRound winRound = mapStatus.a.j;
                    return new MapStatus(mapStatus.rotate, this.f26209c.getCenter(), mapStatus.overlook, eVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top), mapStatus.targetScreen, null);
                case 4:
                    return new MapStatus(mapStatus.rotate, this.f26208b, mapStatus.overlook, this.f26212f, mapStatus.targetScreen, null);
                case 5:
                    GeoPoint b2 = eVar.b((eVar.H() / 2) + this.f26213g, (eVar.I() / 2) + this.f26214h);
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b2), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b2.getLongitudeE6(), b2.getLatitudeE6(), null);
                case 6:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 7:
                    Point point = this.j;
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(point.x, point.y)), mapStatus.overlook, mapStatus.zoom + this.i, this.j, null);
                case 8:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f26212f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 9:
                    LatLngBounds latLngBounds2 = this.f26209c;
                    if (latLngBounds2 == null) {
                        return null;
                    }
                    GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                    GeoPoint ll2mc4 = CoordUtil.ll2mc(this.f26209c.northeast);
                    return new MapStatus(mapStatus.rotate, this.f26209c.getCenter(), mapStatus.overlook, eVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.f26210d, this.f26211e), mapStatus.targetScreen, null);
                case 10:
                    if (this.f26209c == null) {
                        return null;
                    }
                    int H = (eVar.H() - this.k) - this.m;
                    if (H < 0) {
                        H = eVar.H();
                        Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                    }
                    int I = (eVar.I() - this.l) - this.n;
                    if (I < 0) {
                        I = eVar.I();
                        Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                    }
                    float a = a(this.f26209c, eVar, H, I);
                    LatLng a2 = a(this.f26209c, eVar, a(a));
                    if (a2 == null) {
                        Log.e(o, "Bound center error");
                        return null;
                    }
                    boolean a3 = a(this.f26209c, eVar);
                    boolean a4 = a(this.k, this.l, this.m, this.n, eVar);
                    if (a3 || a4) {
                        mapStatus2 = new MapStatus(mapStatus.rotate, a2, mapStatus.overlook, a, null, null);
                        eVar.a(a(mapStatus2));
                    } else if (eVar.G() == null) {
                        return null;
                    } else {
                        mapStatus2 = eVar.G().a;
                    }
                    return mapStatus2;
                case 11:
                    if (this.f26209c == null) {
                        return null;
                    }
                    WinRound winRound2 = mapStatus.winRound;
                    int abs = Math.abs(winRound2.right - winRound2.left);
                    int abs2 = Math.abs(winRound2.bottom - winRound2.top);
                    GeoPoint ll2mc5 = CoordUtil.ll2mc(this.f26209c.southwest);
                    GeoPoint ll2mc6 = CoordUtil.ll2mc(this.f26209c.northeast);
                    double longitudeE63 = ll2mc5.getLongitudeE6();
                    double latitudeE63 = ll2mc6.getLatitudeE6();
                    double longitudeE64 = ll2mc6.getLongitudeE6();
                    double latitudeE64 = ll2mc5.getLatitudeE6();
                    float a5 = eVar.a((int) longitudeE63, (int) latitudeE63, (int) longitudeE64, (int) latitudeE64, (abs - this.k) - this.m, (abs2 - this.l) - Math.abs(this.n));
                    if (a5 == 0.0f) {
                        return null;
                    }
                    Point a6 = eVar.a(CoordUtil.ll2mc(this.f26209c.northeast));
                    Point a7 = eVar.a(CoordUtil.ll2mc(this.f26209c.southwest));
                    if (Math.abs(a6.y) < Math.abs(this.n)) {
                        a5 -= this.n / abs2;
                    }
                    if (longitudeE63 == longitudeE64 && latitudeE63 == latitudeE64) {
                        a5 = mapStatus.zoom;
                    }
                    int i = abs / 2;
                    int i2 = a7.y;
                    int i3 = abs2 - i2;
                    int i4 = this.n;
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(i, i3 > i4 ? ((((abs2 / 2) + 0) + (i4 / 2)) - (this.l / 2)) + 50 : (((((abs2 / 2) + 0) + ((i4 - (abs2 - i2)) / 2)) + (i4 / 2)) - (this.l / 2)) + 50)), mapStatus.overlook, a5, mapStatus.targetScreen, null);
                default:
                    return null;
            }
        }
        return (MapStatus) invokeLL.objValue;
    }
}
