package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class MapStatusUpdate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String o = "MapStatusUpdate";
    public transient /* synthetic */ FieldHolder $fh;
    public MapStatus a;
    public LatLng b;
    public LatLngBounds c;
    public int d;
    public int e;
    public float f;
    public int g;
    public int h;
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

    private MapStatusUpdate a(MapStatus mapStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, mapStatus)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
            synchronized (this) {
                mapStatusUpdate.a = mapStatus;
                mapStatusUpdate.c = this.c;
                mapStatusUpdate.k = this.k;
                mapStatusUpdate.l = this.l;
                mapStatusUpdate.m = this.m;
                mapStatusUpdate.n = this.n;
            }
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    private float a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f)) == null) {
            return (float) (Math.pow(2.0d, 18.0f - f) / (SysOSUtil.getDensityDpi() / 310.0f));
        }
        return invokeF.floatValue;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, this, latLngBounds, dVar, i, i2)) == null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
            return dVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), i, i2);
        }
        return invokeLLII.floatValue;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar, float f) {
        InterceptResult invokeCommon;
        double longitudeE6;
        double latitudeE6;
        double latitudeE62;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{latLngBounds, dVar, Float.valueOf(f)})) == null) {
            if (latLngBounds != null && dVar != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
                int i = this.k;
                double d = i * f;
                int i2 = this.m;
                double d2 = i2 * f;
                double d3 = this.l * f;
                double d4 = this.n * f;
                if (i > i2) {
                    longitudeE6 = ll2mc.getLongitudeE6() - ((d - d2) / 2.0d);
                } else if (i < i2) {
                    longitudeE6 = ll2mc.getLongitudeE6() + ((d2 - d) / 2.0d);
                } else {
                    longitudeE6 = ll2mc.getLongitudeE6();
                }
                int i3 = this.l;
                int i4 = this.n;
                if (i3 < i4) {
                    latitudeE62 = ll2mc.getLatitudeE6() - ((d4 - d3) / 2.0d);
                } else if (i3 > i4) {
                    latitudeE62 = ll2mc.getLatitudeE6();
                    d3 -= d4;
                } else {
                    latitudeE6 = ll2mc.getLatitudeE6();
                    return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
                }
                latitudeE6 = latitudeE62 + (d3 / 2.0d);
                return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
            }
            return null;
        }
        return (LatLng) invokeCommon.objValue;
    }

    private boolean a(int i, int i2, int i3, int i4, com.baidu.mapsdkplatform.comapi.map.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), dVar})) == null) {
            MapStatusUpdate F = dVar.F();
            if (F == null || i != F.k || i2 != F.l || i3 != F.m || i4 != F.n) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, latLngBounds, dVar)) == null) {
            MapStatusUpdate F = dVar.F();
            if (F == null) {
                return true;
            }
            LatLng latLng = latLngBounds.southwest;
            double d = latLng.latitude;
            double d2 = latLng.longitude;
            LatLng latLng2 = latLngBounds.northeast;
            double d3 = latLng2.latitude;
            double d4 = latLng2.longitude;
            LatLngBounds latLngBounds2 = F.c;
            LatLng latLng3 = latLngBounds2.southwest;
            double d5 = latLng3.latitude;
            double d6 = latLng3.longitude;
            LatLng latLng4 = latLngBounds2.northeast;
            double d7 = latLng4.latitude;
            double d8 = latLng4.longitude;
            if (d == d5 && d2 == d6 && d3 == d7 && d4 == d8) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.d dVar, MapStatus mapStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, mapStatus)) == null) {
            if (dVar == null || mapStatus == null) {
                return null;
            }
            switch (this.p) {
                case 1:
                    return this.a;
                case 2:
                    return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
                case 3:
                    LatLngBounds latLngBounds = this.c;
                    if (latLngBounds == null) {
                        return null;
                    }
                    GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                    GeoPoint ll2mc2 = CoordUtil.ll2mc(this.c.northeast);
                    double longitudeE6 = ll2mc.getLongitudeE6();
                    double latitudeE6 = ll2mc2.getLatitudeE6();
                    double longitudeE62 = ll2mc2.getLongitudeE6();
                    int latitudeE62 = (int) ll2mc.getLatitudeE6();
                    WinRound winRound = mapStatus.a.j;
                    return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, dVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top), mapStatus.targetScreen, null);
                case 4:
                    return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, this.f, mapStatus.targetScreen, null);
                case 5:
                    GeoPoint b = dVar.b((dVar.H() / 2) + this.g, (dVar.I() / 2) + this.h);
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b.getLongitudeE6(), b.getLatitudeE6(), null);
                case 6:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 7:
                    Point point = this.j;
                    return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(dVar.b(point.x, point.y)), mapStatus.overlook, mapStatus.zoom + this.i, this.j, null);
                case 8:
                    return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
                case 9:
                    LatLngBounds latLngBounds2 = this.c;
                    if (latLngBounds2 == null) {
                        return null;
                    }
                    GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                    GeoPoint ll2mc4 = CoordUtil.ll2mc(this.c.northeast);
                    return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, dVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.d, this.e), mapStatus.targetScreen, null);
                case 10:
                    if (this.c == null) {
                        return null;
                    }
                    int H = (dVar.H() - this.k) - this.m;
                    if (H < 0) {
                        H = dVar.H();
                        Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                    }
                    int I = (dVar.I() - this.l) - this.n;
                    if (I < 0) {
                        I = dVar.I();
                        Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                    }
                    float a = a(this.c, dVar, H, I);
                    LatLng a2 = a(this.c, dVar, a(a));
                    if (a2 == null) {
                        Log.e(o, "Bound center error");
                        return null;
                    }
                    boolean a3 = a(this.c, dVar);
                    boolean a4 = a(this.k, this.l, this.m, this.n, dVar);
                    if (!a3 && !a4) {
                        if (dVar.F() == null) {
                            return null;
                        }
                        return dVar.F().a;
                    }
                    MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, a2, mapStatus.overlook, a, null, null);
                    dVar.a(a(mapStatus2));
                    return mapStatus2;
                case 11:
                    if (this.c == null) {
                        return null;
                    }
                    int H2 = (dVar.H() - this.k) - this.m;
                    if (H2 < 0) {
                        H2 = dVar.H();
                        Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                    }
                    int I2 = (dVar.I() - this.l) - this.n;
                    if (I2 < 0) {
                        I2 = dVar.I();
                        Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                    }
                    GeoPoint ll2mc5 = CoordUtil.ll2mc(this.c.southwest);
                    GeoPoint ll2mc6 = CoordUtil.ll2mc(this.c.northeast);
                    return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, dVar.a((int) ll2mc5.getLongitudeE6(), (int) ll2mc6.getLatitudeE6(), (int) ll2mc6.getLongitudeE6(), (int) ll2mc5.getLatitudeE6(), H2, I2), new Point(this.k + (H2 / 2), this.l + (I2 / 2)), null);
                default:
                    return null;
            }
        }
        return (MapStatus) invokeLL.objValue;
    }
}
