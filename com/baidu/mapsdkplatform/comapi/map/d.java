package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.al;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class d implements com.baidu.mapsdkplatform.comjni.a.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int C = 0;
    public static int D = 0;
    public static float d = 1096.0f;
    public static long j = 0;
    public static final String l = "d";
    public transient /* synthetic */ FieldHolder $fh;
    public l A;
    public m B;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public long I;
    public long J;
    public boolean K;
    public Queue<a> L;
    public boolean M;
    public boolean N;
    public boolean O;
    public MapController P;
    public LocationOverlay Q;
    public com.baidu.platform.comapi.map.d R;
    public boolean S;
    public float a;
    public float b;
    public float c;
    public boolean e;
    public boolean f;
    public boolean g;
    public List<al> h;
    public AppBaseMap i;
    public MapStatusUpdate k;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public ac v;
    public ab w;
    public List<c> x;
    public HashMap<MapLayer, c> y;
    public aa z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(724782096, "Lcom/baidu/mapsdkplatform/comapi/map/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(724782096, "Lcom/baidu/mapsdkplatform/comapi/map/d;");
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bundle a;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
        }
    }

    public d(Context context, MapSurfaceView mapSurfaceView, v vVar, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mapSurfaceView, vVar, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 21.0f;
        this.b = 4.0f;
        this.c = 21.0f;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = true;
        this.e = true;
        this.f = true;
        this.g = false;
        this.t = true;
        this.u = false;
        this.G = false;
        this.H = false;
        this.I = 0L;
        this.J = 0L;
        this.K = false;
        this.L = new LinkedList();
        this.k = null;
        this.M = false;
        this.N = false;
        this.O = false;
        this.S = false;
        this.h = new CopyOnWriteArrayList();
        MapController mapController = new MapController();
        this.P = mapController;
        mapController.initAppBaseMap();
        a(this.P);
        mapSurfaceView.setMapController(this.P);
        this.i = this.P.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.P.getMapId());
        U();
        a(vVar);
        this.P.getBaseMap().SetSDKLayerCallback(this);
        this.P.onResume();
    }

    public d(Context context, MapTextureView mapTextureView, v vVar, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mapTextureView, vVar, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 21.0f;
        this.b = 4.0f;
        this.c = 21.0f;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = true;
        this.e = true;
        this.f = true;
        this.g = false;
        this.t = true;
        this.u = false;
        this.G = false;
        this.H = false;
        this.I = 0L;
        this.J = 0L;
        this.K = false;
        this.L = new LinkedList();
        this.k = null;
        this.M = false;
        this.N = false;
        this.O = false;
        this.S = false;
        this.h = new CopyOnWriteArrayList();
        MapController mapController = new MapController();
        this.P = mapController;
        mapController.initAppBaseMap();
        a(this.P);
        mapTextureView.attachBaseMapController(this.P);
        this.i = this.P.getBaseMap();
        U();
        this.i = this.P.getBaseMap();
        a(vVar);
        this.P.getBaseMap().SetSDKLayerCallback(this);
        this.P.onResume();
    }

    private void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                C = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
                D = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", C);
                jSONObject2.put("y", C);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("dataset", jSONArray);
                if (this.R != null) {
                    this.R.setData(jSONObject.toString());
                    this.R.UpdateOverlay();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MapBaseIndoorMapInfo r() {
        InterceptResult invokeV;
        String GetFocusedBaseIndoorMapInfo;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            String str3 = "";
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null || (GetFocusedBaseIndoorMapInfo = appBaseMap.GetFocusedBaseIndoorMapInfo()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            try {
                JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
                str2 = jSONObject.optString("focusindoorid");
                try {
                    str3 = jSONObject.optString("curfloor");
                    JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.get(i).toString());
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    str = str3;
                    str3 = str2;
                    e.printStackTrace();
                    String str4 = str;
                    str2 = str3;
                    str3 = str4;
                    return new MapBaseIndoorMapInfo(str2, str3, arrayList);
                }
            } catch (JSONException e2) {
                e = e2;
                str = "";
            }
            return new MapBaseIndoorMapInfo(str2, str3, arrayList);
        }
        return (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    private void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (!this.q && !this.n && !this.m && !this.r) {
                float f = this.c;
                this.a = f;
                MapController mapController = this.P;
                if (mapController != null) {
                    mapController.mMaxZoomLevel = f;
                    return;
                }
                return;
            }
            if (this.a > 20.0f) {
                this.a = 20.0f;
                MapController mapController2 = this.P;
                if (mapController2 != null) {
                    mapController2.mMaxZoomLevel = 20.0f;
                }
            }
            if (D().a > 20.0f) {
                x D2 = D();
                D2.a = 20.0f;
                a(D2);
            }
        }
    }

    public LatLngBounds E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return null;
            }
            Bundle mapStatusLimits = appBaseMap.getMapStatusLimits();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("minCoory"), mapStatusLimits.getInt("maxCoorx")))).include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("maxCoory"), mapStatusLimits.getInt("minCoorx"))));
            return builder.build();
        }
        return (LatLngBounds) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || this.i == null) {
            return;
        }
        synchronized (this.x) {
            for (c cVar : this.x) {
                if (!(cVar instanceof b) && !(cVar instanceof l)) {
                    this.i.ShowLayers(cVar.a, true);
                }
                this.i.ShowLayers(cVar.a, false);
            }
        }
        this.i.ShowTrafficMap(false);
    }

    private void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.x = new CopyOnWriteArrayList();
            this.y = new HashMap<>();
            aa aaVar = new aa();
            this.z = aaVar;
            a(aaVar);
            this.y.put(MapLayer.MAP_LAYER_OVERLAY, this.z);
            o(false);
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap != null) {
                appBaseMap.setDEMEnable(false);
            }
        }
    }

    private void V() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && (mapController = this.P) != null && !mapController.mIsMoving) {
            mapController.mIsMoving = true;
            mapController.mIsAnimating = false;
            if (this.h != null) {
                x D2 = D();
                for (int i = 0; i < this.h.size(); i++) {
                    al alVar = this.h.get(i);
                    if (alVar != null) {
                        alVar.a(D2);
                    }
                }
            }
        }
    }

    public void A() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mapController = this.P) != null && !mapController.mIsMoving && !mapController.mIsAnimating) {
            mapController.mIsAnimating = true;
            if (this.h == null) {
                return;
            }
            x D2 = D();
            for (int i = 0; i < this.h.size(); i++) {
                al alVar = this.h.get(i);
                if (alVar != null) {
                    alVar.a(D2);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || this.i == null) {
            return;
        }
        synchronized (this.x) {
            for (c cVar : this.x) {
                this.i.ShowLayers(cVar.a, false);
            }
        }
    }

    private long a(MapLayer mapLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, mapLayer)) == null) {
            if (this.i == null) {
                return -1L;
            }
            int i = e.a[mapLayer.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return -1L;
                        }
                        return this.i.getLayerIDByTag("basepoi");
                    }
                    return this.i.getLayerIDByTag("poiindoormarklayer");
                }
                aa aaVar = this.z;
                if (aaVar == null) {
                    return -1L;
                }
                return aaVar.a;
            }
            LocationOverlay locationOverlay = this.Q;
            if (locationOverlay == null) {
                return -1L;
            }
            return locationOverlay.mLayerID;
        }
        return invokeL.longValue;
    }

    public boolean g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            long layerIDByTag = appBaseMap.getLayerIDByTag("carnavinode");
            long layerIDByTag2 = this.i.getLayerIDByTag(MapController.ANDROID_SDK_LAYER_TAG);
            if (layerIDByTag == 0 || layerIDByTag2 == 0) {
                return false;
            }
            if (z) {
                if (this.O) {
                    return false;
                }
                boolean SwitchLayer = this.i.SwitchLayer(layerIDByTag, layerIDByTag2);
                this.O = true;
                return SwitchLayer;
            } else if (!this.O) {
                return false;
            } else {
                boolean SwitchLayer2 = this.i.SwitchLayer(layerIDByTag2, layerIDByTag);
                this.O = false;
                return SwitchLayer2;
            }
        }
        return invokeZ.booleanValue;
    }

    private void a(c cVar) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, this, cVar) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        cVar.a = appBaseMap.AddLayer(cVar.c, cVar.d, cVar.b);
        synchronized (this.x) {
            this.x.add(cVar);
        }
    }

    private boolean i(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bundle)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.addSDKTileData(bundle);
        }
        return invokeL.booleanValue;
    }

    private boolean j(Bundle bundle) {
        InterceptResult invokeL;
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bundle)) == null) {
            if (bundle == null || (appBaseMap = this.i) == null) {
                return false;
            }
            boolean updateSDKTile = appBaseMap.updateSDKTile(bundle);
            if (updateSDKTile) {
                i(updateSDKTile);
                this.i.UpdateLayers(this.v.a);
            }
            return updateSDKTile;
        }
        return invokeL.booleanValue;
    }

    public void A(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setOverlookGestureEnable(z);
        this.s = z;
    }

    public void B(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (mapController = this.P) != null) {
            mapController.isSetMapStatusByUsr = z;
        }
    }

    public void C(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (appBaseMap = this.i) != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basepoi"), z);
        }
    }

    public void D(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (appBaseMap = this.i) != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("poiindoormarklayer"), z);
        }
    }

    public void b(int i) {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.setHeatMapFrameAnimationIndex(lVar.a, i);
        }
    }

    public void c(int i) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i) == null) && (appBaseMap = this.i) != null) {
            appBaseMap.setFontSizeLevel(i);
        }
    }

    public void d(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048640, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.i.ShowLayers(appBaseMap.getLayerIDByTag("opgrid"), z);
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048642, this, bundle) != null) || this.i == null) {
            return;
        }
        g(bundle);
        d(bundle);
        this.i.updateOneOverlayItem(bundle);
    }

    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048644, this, bundle) != null) || this.i == null) {
            return;
        }
        g(bundle);
        this.i.removeOneOverlayItem(bundle);
    }

    public void h(Bundle bundle) {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048651, this, bundle) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.initHeatMapData(lVar.a, bundle);
        }
    }

    public void k(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048657, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.r = z;
        appBaseMap.ShowHotMap(z, 0);
    }

    public void l(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048659, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.m = z;
        appBaseMap.ShowTrafficMap(z);
    }

    public void m(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048661, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.setDrawHouseHeightEnable(z);
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048672, this, z) != null) || this.i == null) {
            return;
        }
        if (this.A == null) {
            l lVar = new l();
            this.A = lVar;
            a(lVar);
        }
        this.q = z;
        this.i.ShowLayers(this.A.a, z);
    }

    public void s(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048673, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setCanTouchMove(z);
        this.e = z;
    }

    public void t(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048675, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setEnableZoom(z);
        this.f = z;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.P.setInertialAnimation(z);
        }
    }

    public void v(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048680, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setDoubleClickZoom(z);
    }

    public void w(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048681, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setTwoTouchClickZoomEnabled(z);
    }

    public void x(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048683, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setEnlargeCenterWithDoubleClickEnable(z);
    }

    public void y(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048685, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.setFlingEnable(z);
    }

    public void z(boolean z) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048687, this, z) != null) || (mapController = this.P) == null) {
            return;
        }
        mapController.set3DGestureEnable(z);
        this.t = z;
    }

    private void a(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, vVar) == null) {
            if (vVar == null) {
                vVar = new v();
            }
            x xVar = vVar.a;
            boolean z = vVar.f;
            this.s = z;
            this.t = vVar.d;
            this.e = vVar.e;
            this.f = vVar.g;
            A(z);
            z(this.t);
            s(this.e);
            t(this.f);
            this.i.SetMapStatus(xVar.a(this));
            this.i.SetMapControlMode(u.a.ordinal());
            boolean z2 = vVar.b;
            this.o = z2;
            if (z2) {
                if (this.R == null) {
                    this.R = new com.baidu.platform.comapi.map.d(this.i);
                    MapViewInterface mapView = this.P.getMapView();
                    if (mapView != null) {
                        mapView.addOverlay(this.R);
                        S();
                    }
                }
                this.i.ShowLayers(this.R.mLayerID, true);
                this.i.ResetImageRes();
            }
            int i = vVar.c;
            if (i == 2) {
                a(true);
            }
            if (i == 3) {
                if (B()) {
                    C(false);
                }
                if (C()) {
                    D(false);
                }
                j(false);
                o(false);
            }
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            if (bundle.get("param") != null) {
                Bundle bundle2 = (Bundle) bundle.get("param");
                int i = bundle2.getInt("type");
                if (i == i.d.ordinal()) {
                    bundle2.putLong("layer_addr", this.z.a);
                    return;
                } else if (i >= i.f.ordinal()) {
                    bundle2.putLong("layer_addr", this.z.a);
                    return;
                } else if (i == i.b.ordinal()) {
                    bundle2.putLong("layer_addr", this.z.a);
                    return;
                } else {
                    bundle2.putLong("layer_addr", this.z.a);
                    return;
                }
            }
            int i2 = bundle.getInt("type");
            if (i2 == i.d.ordinal()) {
                bundle.putLong("layer_addr", this.z.a);
            } else if (i2 >= i.f.ordinal()) {
                bundle.putLong("layer_addr", this.z.a);
            } else if (i2 == i.b.ordinal()) {
                bundle.putLong("layer_addr", this.z.a);
            } else {
                bundle.putLong("layer_addr", this.z.a);
            }
        }
    }

    private void a(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, mapController) == null) {
            if (!com.baidu.platform.comapi.b.a()) {
                synchronized (com.baidu.platform.comapi.b.class) {
                }
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", 12.0d);
            bundle.putDouble("centerptx", 1.295815798E7d);
            bundle.putDouble("centerpty", 4825999.74d);
            bundle.putDouble("centerptz", 0.0d);
            bundle.putInt("left", 0);
            bundle.putInt("top", 0);
            int screenHeight = SysOSUtil.getInstance().getScreenHeight();
            bundle.putInt("right", SysOSUtil.getInstance().getScreenWidth());
            bundle.putInt("bottom", screenHeight);
            bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
            bundle.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
            bundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
            bundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
            bundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
            bundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
            bundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
            bundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
            mapController.initMapResources(bundle);
        }
    }

    private void a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            try {
                Class<?> cls = Class.forName(str);
                cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j2));
            } catch (Exception unused) {
            }
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap != null) {
                return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basepoi"));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap != null) {
                return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("poiindoormarklayer"));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public x D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return null;
            }
            Bundle GetMapStatus = appBaseMap.GetMapStatus();
            x xVar = new x();
            xVar.a(GetMapStatus);
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public MapStatusUpdate F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return (MapStatusUpdate) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap != null) {
                appBaseMap.getFontSizeLevel();
                return 1;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public x J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return null;
            }
            Bundle GetMapStatus = appBaseMap.GetMapStatus(false);
            x xVar = new x();
            xVar.a(GetMapStatus);
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public double K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return D().m;
        }
        return invokeV.doubleValue;
    }

    public float[] M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return null;
            }
            return appBaseMap.getProjectionMatrix();
        }
        return (float[]) invokeV.objValue;
    }

    public float[] N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return null;
            }
            return appBaseMap.getViewMatrix();
        }
        return (float[]) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.S) {
                return "";
            }
            return VersionInfo.MAP_APPROVAL_NUMBER;
        }
        return (String) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.S) {
                return "";
            }
            return VersionInfo.MAP_MAPPING_QUALIFICATION;
        }
        return (String) invokeV.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.S) {
                return "";
            }
            return VersionInfo.MAP_COPYRIGHT;
        }
        return (String) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return 0;
            }
            return appBaseMap.getMapLanguage();
        }
        return invokeV.intValue;
    }

    public AppBaseMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.i;
        }
        return (AppBaseMap) invokeV.objValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            MapController mapController = this.P;
            if (mapController != null) {
                return mapController.mMaxZoomLevel;
            }
            return this.a;
        }
        return invokeV.floatValue;
    }

    public void e() {
        AppBaseMap appBaseMap;
        ac acVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (appBaseMap = this.i) != null && (acVar = this.v) != null) {
            appBaseMap.RemoveLayer(acVar.a);
            this.x.remove(this.v);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            ac acVar = this.v;
            if (acVar != null && (appBaseMap = this.i) != null) {
                return appBaseMap.cleanSDKTileDataCache(acVar.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (this.i == null) {
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (this.i == null) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basemap"));
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.getDrawHouseHeightEnable();
        }
        return invokeV.booleanValue;
    }

    public void n() {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048663, this) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.ClearSDKLayer(this.z.a);
    }

    public void o() {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.startHeatMapFrameAnimation(lVar.a);
        }
    }

    public void p() {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.stopHeatMapFrameAnimation(lVar.a);
        }
    }

    public void q() {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.clearHeatMapLayerCache(lVar.a);
            this.i.UpdateLayers(this.A.a);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.IsBaseIndoorMapMode();
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        AppBaseMap appBaseMap;
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (appBaseMap = this.i) != null && (lVar = this.A) != null) {
            appBaseMap.UpdateLayers(lVar.a);
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (!this.P.mIsMapLoadFinish) {
                return 12.0f;
            }
            if (this.i == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", i);
            bundle.putInt("right", i3);
            bundle.putInt("bottom", i4);
            bundle.putInt("top", i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("left", 0);
            bundle2.putInt("bottom", i6);
            bundle2.putInt("right", i5);
            bundle2.putInt("top", 0);
            return this.i.GetFZoomToBoundF(bundle, bundle2);
        }
        return invokeCommon.floatValue;
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{bundle, Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            l lVar = this.A;
            if (lVar != null && j2 == lVar.a && this.B != null) {
                bundle.putBundle("param", this.B.a(bundle.getInt("index"), bundle.getInt("zoom")));
                return this.A.e;
            }
            ac acVar = this.v;
            if (acVar != null && j2 == acVar.a) {
                bundle.putBundle("param", this.w.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom"), null));
                return this.v.e;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public Point a(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, geoPoint)) == null) {
            com.baidu.platform.comapi.basestruct.Point pixels = this.P.getMapView().getProjection().toPixels(geoPoint, null);
            if (pixels != null) {
                return new Point(pixels.getIntX(), pixels.getIntY());
            }
            return new Point();
        }
        return (Point) invokeL.objValue;
    }

    public void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) && bundle != null && bundle.containsKey("encodedPoints") && bundle.containsKey("encodePointType") && bundle.getInt("encodePointType") == EncodePointType.BUILDINGINFO.ordinal()) {
            a(bundle, bundle.getString("encodedPoints"));
        }
    }

    public void e(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048643, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        if (z) {
            if (!this.M) {
                appBaseMap.SwitchLayer(appBaseMap.getLayerIDByTag("indoorlayer"), this.z.a);
                this.M = true;
            }
        } else if (this.M) {
            appBaseMap.SwitchLayer(this.z.a, appBaseMap.getLayerIDByTag("indoorlayer"));
            this.M = false;
        }
    }

    public void f(boolean z) {
        AppBaseMap appBaseMap;
        LocationOverlay locationOverlay;
        LocationOverlay locationOverlay2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048645, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        if (z) {
            if (!this.N && (locationOverlay2 = this.Q) != null) {
                appBaseMap.SwitchLayer(this.z.a, locationOverlay2.mLayerID);
                this.N = true;
            }
        } else if (this.N && (locationOverlay = this.Q) != null) {
            appBaseMap.SwitchLayer(locationOverlay.mLayerID, this.z.a);
            this.N = false;
        }
    }

    public void h(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048652, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        if (this.R == null) {
            this.R = new com.baidu.platform.comapi.map.d(appBaseMap);
            MapViewInterface mapView = this.P.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.R);
                S();
            }
        }
        this.i.ShowLayers(this.R.mLayerID, z);
    }

    public void n(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048664, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.o = z;
        if (this.R == null) {
            this.R = new com.baidu.platform.comapi.map.d(appBaseMap);
            MapViewInterface mapView = this.P.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.R);
                S();
            }
        }
        this.i.ShowLayers(this.R.mLayerID, z);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048666, this, z) != null) || this.i == null) {
            return;
        }
        if (z) {
            this.a = 22.0f;
            this.c = 22.0f;
            MapController mapController = this.P;
            if (mapController != null) {
                mapController.mMaxZoomLevel = 22.0f;
            }
        } else {
            this.a = 21.0f;
            this.c = 21.0f;
            MapController mapController2 = this.P;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 21.0f;
            }
        }
        this.i.ShowBaseIndoorMap(z);
    }

    public void p(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048668, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.S = z;
        appBaseMap.setCustomStyleEnable(z);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b a2 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
            a2.a("CustomMap setMapCustomEnable enable = " + z);
        }
    }

    public void q(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048670, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        this.p = z;
        LocationOverlay locationOverlay = this.Q;
        if (locationOverlay == null) {
            MapViewInterface mapView = this.P.getMapView();
            if (mapView != null) {
                LocationOverlay locationOverlay2 = new LocationOverlay(this.i);
                this.Q = locationOverlay2;
                mapView.addOverlay(locationOverlay2);
                return;
            }
            return;
        }
        appBaseMap.ShowLayers(locationOverlay.mLayerID, z);
    }

    public Point a(GeoPoint geoPoint, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, geoPoint, i)) == null) {
            com.baidu.platform.comapi.basestruct.Point pixels = this.P.getMapView().getProjection().toPixels(geoPoint, i, null);
            if (pixels != null) {
                return new Point(pixels.getIntX(), pixels.getIntY());
            }
            return new Point();
        }
        return (Point) invokeLI.objValue;
    }

    public ArrayList<LatLng> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return new y().a(str);
        }
        return (ArrayList) invokeL.objValue;
    }

    public void b(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z) == null) && (appBaseMap = this.i) != null) {
            appBaseMap.setDEMEnable(z);
        }
    }

    public void c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048636, this, bundle) != null) || this.i == null) {
            return;
        }
        g(bundle);
        d(bundle);
        this.i.addOneOverlayItem(bundle);
    }

    public void i(boolean z) {
        AppBaseMap appBaseMap;
        ac acVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (appBaseMap = this.i) != null && (acVar = this.v) != null) {
            appBaseMap.ShowLayers(acVar.a, z);
        }
    }

    public void j(boolean z) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048655, this, z) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basemap"), z);
    }

    public void a(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.a = f;
            this.c = f;
            this.b = f2;
            MapController mapController = this.P;
            if (mapController != null) {
                mapController.setMaxAndMinZoomLevel(f, f2);
            }
            if (this.i != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("maxLevel", (int) f);
                bundle.putInt("minLevel", (int) f2);
                this.i.setMaxAndMinZoomLevel(bundle);
            }
        }
    }

    public void a(int i) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.CleanCache(i);
    }

    public void b(Bundle[] bundleArr) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, bundleArr) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.removeOverlayItems(bundleArr);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.u = z;
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) {
            this.E = i;
            this.F = i2;
        }
    }

    public GeoPoint b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048629, this, i, i2)) == null) {
            return this.P.getMapView().getProjection().fromPixels(i, i2);
        }
        return (GeoPoint) invokeII.objValue;
    }

    public void a(long j2, long j3, long j4, long j5, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z)}) != null) || this.i == null) {
        }
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, bitmap) != null) || this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", C);
            jSONObject2.put("y", D);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgData", allocate.array());
            bundle3.putString("imgKey", bitmap.hashCode() + "_" + System.currentTimeMillis());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            bundle2.putBundle("iconData", bundle3);
            bundle = bundle2;
        }
        if (this.R != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                this.R.setData(jSONObject.toString());
            }
            if (bundle != null) {
                this.R.setParam(bundle);
            }
            this.R.UpdateOverlay();
        }
    }

    public LatLngBounds b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, bundle)) == null) {
            if (bundle == null) {
                return null;
            }
            int i = bundle.getInt("type");
            String string = bundle.getString("encodedPoints");
            LatLngBounds build = new LatLngBounds.Builder().build();
            if (string != null && string.length() > 0 && i == i.l.ordinal()) {
                ArrayList<LatLng> a2 = a(string);
                if (a2 == null) {
                    return null;
                }
                int size = a2.size();
                double[] dArr = new double[size];
                double[] dArr2 = new double[size];
                for (int i2 = 0; i2 < size; i2++) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(a2.get(i2));
                    dArr[i2] = ll2mc.getLongitudeE6();
                    dArr2[i2] = ll2mc.getLatitudeE6();
                }
                Point point = new Point();
                GeoPoint ll2mc2 = CoordUtil.ll2mc(a2.get(0));
                Rect rect = new Rect((int) ll2mc2.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc2.getLatitudeE6());
                for (int i3 = 1; i3 < size; i3++) {
                    int i4 = (int) dArr[i3];
                    point.x = i4;
                    point.y = (int) dArr2[i3];
                    rect.set(Math.min(rect.left, i4), Math.max(rect.top, point.y), Math.max(rect.right, point.x), Math.min(rect.bottom, point.y));
                }
                GeoPoint geoPoint = new GeoPoint(rect.bottom, rect.left);
                GeoPoint geoPoint2 = new GeoPoint(rect.top, rect.right);
                return new LatLngBounds.Builder().include(CoordUtil.mc2ll(geoPoint)).include(CoordUtil.mc2ll(geoPoint2)).build();
            }
            return build;
        }
        return (LatLngBounds) invokeL.objValue;
    }

    public void a(Bundle bundle, String str) {
        ArrayList<LatLng> a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048609, this, bundle, str) != null) || bundle == null || str == null || str.length() <= 0 || (a2 = a(str)) == null) {
            return;
        }
        int size = a2.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mc = CoordUtil.ll2mc(a2.get(i));
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(a2.get(0));
        bundle.putDouble("location_x", ll2mc2.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc2.getLatitudeE6());
        if (bundle.getInt("has_dotted_stroke") == 1) {
            bundle.putDouble("dotted_stroke_location_x", ll2mc2.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", ll2mc2.getLatitudeE6());
        }
    }

    public void a(MapLayer mapLayer, MapLayer mapLayer2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048610, this, mapLayer, mapLayer2) != null) || this.i == null) {
            return;
        }
        long a2 = a(mapLayer);
        long a3 = a(mapLayer2);
        if (a2 != -1 && a3 != -1) {
            this.i.SwitchLayer(a2, a3);
        }
    }

    public void b(String str, String str2) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048631, this, str, str2) != null) || (appBaseMap = this.i) == null) {
            return;
        }
        appBaseMap.initCustomStyle(str, str2);
    }

    public void a(MapLayer mapLayer, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048611, this, mapLayer, z) != null) || this.i == null) {
            return;
        }
        long a2 = a(mapLayer);
        if (a2 == -1) {
            return;
        }
        this.i.SetLayersClickable(a2, z);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, mapStatusUpdate) == null) {
            this.k = mapStatusUpdate;
        }
    }

    public void a(LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, latLngBounds) == null) && latLngBounds != null && this.i != null) {
            LatLng latLng = latLngBounds.northeast;
            LatLng latLng2 = latLngBounds.southwest;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            int longitudeE6 = (int) ll2mc2.getLongitudeE6();
            int latitudeE6 = (int) ll2mc.getLatitudeE6();
            Bundle bundle = new Bundle();
            bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
            bundle.putInt("minCoory", (int) ll2mc2.getLatitudeE6());
            bundle.putInt("minCoorx", longitudeE6);
            bundle.putInt("maxCoory", latitudeE6);
            this.i.setMapStatusLimits(bundle);
        }
    }

    public void a(ab abVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, abVar) == null) {
            this.w = abVar;
        }
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, mVar) == null) {
            this.B = mVar;
        }
    }

    public void a(x xVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, xVar) == null) && this.i != null && xVar != null) {
            Bundle a2 = xVar.a(this);
            a2.putInt("animation", 0);
            a2.putInt("animatime", 0);
            V();
            this.i.SetMapStatus(a2);
        }
    }

    public void a(x xVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048617, this, xVar, i) == null) && this.i != null && xVar != null) {
            Bundle a2 = xVar.a(this);
            a2.putInt("animation", 1);
            a2.putInt("animatime", i);
            if (this.K) {
                this.L.add(new a(a2));
                return;
            }
            A();
            this.i.SetMapStatus(a2);
        }
    }

    public void a(al alVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, alVar) == null) && alVar != null && this.h != null) {
            this.P.registMapViewListener(alVar);
            this.h.add(alVar);
        }
    }

    public void a(String str, Bundle bundle) {
        LocationOverlay locationOverlay;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048619, this, str, bundle) != null) || (locationOverlay = this.Q) == null) {
            return;
        }
        locationOverlay.setData(str);
        this.Q.setParam(bundle);
        this.Q.UpdateOverlay();
    }

    public void a(List<OverlayLocationData> list) {
        LocationOverlay locationOverlay;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, list) != null) || (locationOverlay = this.Q) == null) {
            return;
        }
        locationOverlay.setLocationLayerData(list);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048621, this, z) != null) || this.i == null) {
            return;
        }
        this.n = z;
        T();
        this.i.ShowSatelliteMap(this.n);
        MapController mapController = this.P;
        if (mapController != null) {
            if (z) {
                mapController.setMapTheme(2, new Bundle());
            } else {
                mapController.setMapTheme(1, new Bundle());
            }
        }
    }

    public void a(Bundle[] bundleArr) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, bundleArr) == null) && (appBaseMap = this.i) != null && bundleArr != null) {
            appBaseMap.addOverlayItems(bundleArr, bundleArr.length);
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048623, this, j2)) == null) {
            synchronized (this.x) {
                Iterator<c> it = this.x.iterator();
                while (it.hasNext()) {
                    if (it.next().a == j2) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean a(Point point) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, point)) == null) {
            if (point != null && this.i != null && (i = point.x) >= 0 && (i2 = point.y) >= 0) {
                C = i;
                D = i2;
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("x", C);
                    jSONObject2.put("y", D);
                    jSONObject2.put("hidetime", 1000);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("dataset", jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (this.R != null) {
                    if (!TextUtils.isEmpty(jSONObject.toString())) {
                        this.R.setData(jSONObject.toString());
                    }
                    this.R.UpdateOverlay();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, bundle)) == null) {
            if (this.i == null) {
                return false;
            }
            ac acVar = new ac();
            this.v = acVar;
            long AddLayer = this.i.AddLayer(acVar.c, acVar.d, acVar.b);
            if (AddLayer != 0) {
                this.v.a = AddLayer;
                synchronized (this.x) {
                    this.x.add(this.v);
                }
                bundle.putLong("sdktileaddr", AddLayer);
                if (i(bundle) && j(bundle)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048626, this, str, str2)) == null) {
            AppBaseMap appBaseMap = this.i;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.SwitchBaseIndoorMapFloor(str, str2);
        }
        return invokeLL.booleanValue;
    }
}
