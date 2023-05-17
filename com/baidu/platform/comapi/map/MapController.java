package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.gms.common.util.GmsVersion;
import com.huawei.hms.framework.common.ExceptionCode;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MapController {
    public static /* synthetic */ Interceptable $ic = null;
    public static float A = 0.0f;
    public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
    public static boolean B = false;
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    public static final String FOOTSURFACE_LAYER_TAG = "footsurface";
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
    public static final String LOCATION_LAYER_TAG = "location";
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POPUP_LAYER_TAG = "popup";
    public static long R = 0;
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";
    public static List<AppBaseMap> W = null;
    public static boolean isCompass = false;
    public static final String k = "MapController";
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION = false;
    public static boolean y = true;
    public static float z;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public a G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public float L;
    public float M;
    public float N;
    public long O;
    public boolean P;
    public boolean Q;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long X;
    public boolean Y;
    public Handler Z;
    public int a;
    public boolean aa;
    public com.baidu.platform.comapi.map.b.b ab;
    public MapControlMode ac;
    public MapViewListener b;
    public CaptureMapListener c;
    public k d;
    public an e;
    public MapRenderModeChangeListener f;
    public EngineMsgListener g;
    public MapViewSurfaceListener h;
    public SoftReference<MapViewInterface> i;
    public boolean isSetMapStatusByUsr;
    public NaviMapViewListener j;
    public com.baidu.platform.comapi.map.b.d l;
    public boolean m;
    public boolean mHasMapObjDraging;
    public boolean mIsAnimating;
    public boolean mIsInertialAnimation;
    public boolean mIsMapLoadFinish;
    public boolean mIsMoving;
    public List<al> mListeners;
    public float mMaxZoomLevel;
    public float mMinZoomLevel;
    public boolean n;
    public int nearlyRadius;
    public int o;
    public int p;
    public boolean q;
    public MapFirstFrameCallback r;
    public boolean s;
    public AppBaseMap t;
    public long u;
    public Handler v;
    public int w;
    public int x;

    /* loaded from: classes3.dex */
    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController mapController);
    }

    public static native int CleanAfterDBClick(long j, float f, float f2);

    public static int GetAdaptKeyCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            switch (i) {
                case 19:
                    return 17;
                case 20:
                    return 19;
                case 21:
                    return 16;
                case 22:
                    return 18;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    public static native int MapProc(long j, int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4);

    public static int getScaleDis(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) {
            switch (i) {
                case 1:
                    return ExceptionCode.CRASH_EXCEPTION;
                case 2:
                    return GmsVersion.VERSION_LONGHORN;
                case 3:
                    return 2000000;
                case 4:
                    return 1000000;
                case 5:
                    return 500000;
                case 6:
                    return 200000;
                case 7:
                    return DefaultOggSeeker.MATCH_BYTE_RANGE;
                case 8:
                    return 50000;
                case 9:
                    return 25000;
                case 10:
                    return 20000;
                case 11:
                    return 10000;
                case 12:
                    return 5000;
                case 13:
                    return 2000;
                case 14:
                    return 1000;
                case 15:
                    return 500;
                case 16:
                    return 200;
                case 17:
                    return 100;
                case 18:
                    return 50;
                case 19:
                    return 20;
                case 20:
                    return 10;
                case 21:
                    return 5;
                case 22:
                    return 2;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    public boolean handlePopupClick(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048640, this, i, i2)) == null) {
            return false;
        }
        return invokeII.booleanValue;
    }

    public boolean isPressedOnPopup(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048669, this, i, i2)) == null) {
            return false;
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class HeatMapType {
        public static /* synthetic */ Interceptable $ic;
        public static final HeatMapType CEMETERY;
        public static final HeatMapType CITY;
        public static final HeatMapType SCENERY;
        public static final /* synthetic */ HeatMapType[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1004498948, "Lcom/baidu/platform/comapi/map/MapController$HeatMapType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1004498948, "Lcom/baidu/platform/comapi/map/MapController$HeatMapType;");
                    return;
                }
            }
            CITY = new HeatMapType("CITY", 0, 0);
            SCENERY = new HeatMapType("SCENERY", 1, 1);
            HeatMapType heatMapType = new HeatMapType("CEMETERY", 2, 2);
            CEMETERY = heatMapType;
            b = new HeatMapType[]{CITY, SCENERY, heatMapType};
        }

        public HeatMapType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static HeatMapType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (HeatMapType) Enum.valueOf(HeatMapType.class, str);
            }
            return (HeatMapType) invokeL.objValue;
        }

        public static HeatMapType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (HeatMapType[]) b.clone();
            }
            return (HeatMapType[]) invokeV.objValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MapControlMode {
        public static /* synthetic */ Interceptable $ic;
        public static final MapControlMode DEFAULT;
        public static final MapControlMode INDOOR;
        public static final MapControlMode STREET;
        public static final MapControlMode STREET_WAITING;
        public static final /* synthetic */ MapControlMode[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-698941424, "Lcom/baidu/platform/comapi/map/MapController$MapControlMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-698941424, "Lcom/baidu/platform/comapi/map/MapController$MapControlMode;");
                    return;
                }
            }
            DEFAULT = new MapControlMode(EngineName.DEFAULT_ENGINE, 0, 1);
            INDOOR = new MapControlMode("INDOOR", 1, 2);
            STREET = new MapControlMode("STREET", 2, 3);
            MapControlMode mapControlMode = new MapControlMode("STREET_WAITING", 3, 4);
            STREET_WAITING = mapControlMode;
            b = new MapControlMode[]{DEFAULT, INDOOR, STREET, mapControlMode};
        }

        public MapControlMode(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static MapControlMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (MapControlMode) Enum.valueOf(MapControlMode.class, str);
            }
            return (MapControlMode) invokeL.objValue;
        }

        public static MapControlMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (MapControlMode[]) b.clone();
            }
            return (MapControlMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MapLayerType {
        public static /* synthetic */ Interceptable $ic;
        public static final MapLayerType DEFAULT;
        public static final MapLayerType INDOOR;
        public static final MapLayerType SATELLITE;
        public static final MapLayerType STREET;
        public static final /* synthetic */ MapLayerType[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(358833957, "Lcom/baidu/platform/comapi/map/MapController$MapLayerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(358833957, "Lcom/baidu/platform/comapi/map/MapController$MapLayerType;");
                    return;
                }
            }
            DEFAULT = new MapLayerType(EngineName.DEFAULT_ENGINE, 0, 1);
            SATELLITE = new MapLayerType("SATELLITE", 1, 2);
            INDOOR = new MapLayerType("INDOOR", 2, 3);
            MapLayerType mapLayerType = new MapLayerType("STREET", 3, 5);
            STREET = mapLayerType;
            b = new MapLayerType[]{DEFAULT, SATELLITE, INDOOR, mapLayerType};
        }

        public MapLayerType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static MapLayerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (MapLayerType) Enum.valueOf(MapLayerType.class, str);
            }
            return (MapLayerType) invokeL.objValue;
        }

        public static MapLayerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (MapLayerType[]) b.clone();
            }
            return (MapLayerType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MapSceneMode {
        public static /* synthetic */ Interceptable $ic;
        public static final MapSceneMode DEFAULT;
        public static final MapSceneMode INDOOR;
        public static final MapSceneMode INTERNAL;
        public static final MapSceneMode POI;
        public static final MapSceneMode ROUTE;
        public static final /* synthetic */ MapSceneMode[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1814525055, "Lcom/baidu/platform/comapi/map/MapController$MapSceneMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1814525055, "Lcom/baidu/platform/comapi/map/MapController$MapSceneMode;");
                    return;
                }
            }
            DEFAULT = new MapSceneMode(EngineName.DEFAULT_ENGINE, 0, 0);
            POI = new MapSceneMode("POI", 1, 1);
            ROUTE = new MapSceneMode("ROUTE", 2, 2);
            INTERNAL = new MapSceneMode("INTERNAL", 3, 3);
            MapSceneMode mapSceneMode = new MapSceneMode("INDOOR", 4, 7);
            INDOOR = mapSceneMode;
            b = new MapSceneMode[]{DEFAULT, POI, ROUTE, INTERNAL, mapSceneMode};
        }

        public MapSceneMode(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static MapSceneMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MapSceneMode) Enum.valueOf(MapSceneMode.class, str);
            }
            return (MapSceneMode) invokeL.objValue;
        }

        public static MapSceneMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MapSceneMode[]) b.clone();
            }
            return (MapSceneMode[]) invokeV.objValue;
        }

        public int getMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MapStyleMode {
        public static /* synthetic */ Interceptable $ic;
        public static final MapStyleMode DEFAULT;
        public static final MapStyleMode FOOT_PRINT;
        public static final MapStyleMode INTERNAL;
        public static final MapStyleMode INTERNAL_SPECIAL;
        public static final MapStyleMode NAV_DAY;
        public static final MapStyleMode NAV_NIGHT;
        public static final MapStyleMode SEARCH_POI;
        public static final MapStyleMode SEARCH_ROUTE;
        public static final MapStyleMode WALK_DAY;
        public static final /* synthetic */ MapStyleMode[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(539948412, "Lcom/baidu/platform/comapi/map/MapController$MapStyleMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(539948412, "Lcom/baidu/platform/comapi/map/MapController$MapStyleMode;");
                    return;
                }
            }
            DEFAULT = new MapStyleMode(EngineName.DEFAULT_ENGINE, 0, 1);
            SEARCH_POI = new MapStyleMode("SEARCH_POI", 1, 2);
            SEARCH_ROUTE = new MapStyleMode("SEARCH_ROUTE", 2, 3);
            NAV_DAY = new MapStyleMode("NAV_DAY", 3, 4);
            NAV_NIGHT = new MapStyleMode("NAV_NIGHT", 4, 5);
            WALK_DAY = new MapStyleMode("WALK_DAY", 5, 6);
            INTERNAL = new MapStyleMode("INTERNAL", 6, 7);
            INTERNAL_SPECIAL = new MapStyleMode("INTERNAL_SPECIAL", 7, 8);
            MapStyleMode mapStyleMode = new MapStyleMode("FOOT_PRINT", 8, 9);
            FOOT_PRINT = mapStyleMode;
            b = new MapStyleMode[]{DEFAULT, SEARCH_POI, SEARCH_ROUTE, NAV_DAY, NAV_NIGHT, WALK_DAY, INTERNAL, INTERNAL_SPECIAL, mapStyleMode};
        }

        public MapStyleMode(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static MapStyleMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MapStyleMode) Enum.valueOf(MapStyleMode.class, str);
            }
            return (MapStyleMode) invokeL.objValue;
        }

        public static MapStyleMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MapStyleMode[]) b.clone();
            }
            return (MapStyleMode[]) invokeV.objValue;
        }

        public int getMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RecommendPoiScene {
        public static /* synthetic */ Interceptable $ic;
        public static final RecommendPoiScene BASE;
        public static final RecommendPoiScene INTERNATIONAL;
        public static final /* synthetic */ RecommendPoiScene[] a;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1320801060, "Lcom/baidu/platform/comapi/map/MapController$RecommendPoiScene;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1320801060, "Lcom/baidu/platform/comapi/map/MapController$RecommendPoiScene;");
                    return;
                }
            }
            BASE = new RecommendPoiScene("BASE", 0, 0);
            RecommendPoiScene recommendPoiScene = new RecommendPoiScene("INTERNATIONAL", 1, 1);
            INTERNATIONAL = recommendPoiScene;
            a = new RecommendPoiScene[]{BASE, recommendPoiScene};
        }

        public RecommendPoiScene(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static RecommendPoiScene valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RecommendPoiScene) Enum.valueOf(RecommendPoiScene.class, str);
            }
            return (RecommendPoiScene) invokeL.objValue;
        }

        public static RecommendPoiScene[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RecommendPoiScene[]) a.clone();
            }
            return (RecommendPoiScene[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RecycleMemoryLevel {
        public static /* synthetic */ Interceptable $ic;
        public static final RecycleMemoryLevel FULL;
        public static final RecycleMemoryLevel NORMAL;
        public static final /* synthetic */ RecycleMemoryLevel[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1863380924, "Lcom/baidu/platform/comapi/map/MapController$RecycleMemoryLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1863380924, "Lcom/baidu/platform/comapi/map/MapController$RecycleMemoryLevel;");
                    return;
                }
            }
            NORMAL = new RecycleMemoryLevel("NORMAL", 0, 0);
            RecycleMemoryLevel recycleMemoryLevel = new RecycleMemoryLevel("FULL", 1, 1);
            FULL = recycleMemoryLevel;
            b = new RecycleMemoryLevel[]{NORMAL, recycleMemoryLevel};
        }

        public RecycleMemoryLevel(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public static RecycleMemoryLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RecycleMemoryLevel) Enum.valueOf(RecycleMemoryLevel.class, str);
            }
            return (RecycleMemoryLevel) invokeL.objValue;
        }

        public static RecycleMemoryLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RecycleMemoryLevel[]) b.clone();
            }
            return (RecycleMemoryLevel[]) invokeV.objValue;
        }

        public int getLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public float b;
        public GeoPoint c;
        public Point d;
        public final /* synthetic */ MapController e;

        public a(MapController mapController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mapController;
            this.a = false;
            this.b = 0.0f;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = false;
                this.b = 0.0f;
                this.c = null;
                this.d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends com.baidu.platform.comapi.util.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapController mapController) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mapController;
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            boolean z;
            NaviMapViewListener naviMapViewListener;
            NaviMapViewListener naviMapViewListener2;
            k kVar;
            CaptureMapListener captureMapListener;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message.what == 4000 && (captureMapListener = this.a.c) != null) {
                    if (message.arg2 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    captureMapListener.onGetCaptureMap(z2);
                }
                if (message.what == 519 && (kVar = this.a.d) != null) {
                    kVar.a();
                }
                int i = message.what;
                if (i == 39) {
                    if (((Long) message.obj).longValue() != this.a.u) {
                        return;
                    }
                    int i2 = message.arg1;
                    if (i2 != 2) {
                        if (i2 != 100) {
                            if (i2 != 200) {
                                if (i2 != 300) {
                                    MapRenderModeChangeListener mapRenderModeChangeListener = this.a.f;
                                    if (mapRenderModeChangeListener != null) {
                                        mapRenderModeChangeListener.onMapRenderModeChange(i2);
                                    }
                                    if (this.a.isNaviMode() && (naviMapViewListener2 = this.a.j) != null) {
                                        naviMapViewListener2.onMapRenderModeChange(message.arg1);
                                    }
                                } else if (this.a.r != null) {
                                    this.a.r.onFirstFrameDrawing(this.a);
                                }
                            } else {
                                this.a.mIsMoving = false;
                            }
                        } else {
                            if (this.a.P) {
                                SoftReference<MapViewInterface> softReference = this.a.i;
                                if (softReference != null && softReference.get() != null) {
                                    com.baidu.platform.comapi.util.j.b().execute(new n(this, this.a.getMapStatus()));
                                } else {
                                    return;
                                }
                            }
                            if (this.a.Q) {
                                this.a.Q = false;
                            }
                            this.a.D = false;
                            MapController mapController = this.a;
                            mapController.mIsMoving = false;
                            mapController.mIsAnimating = false;
                            if (mapController.getMapViewListener() != null) {
                                this.a.getMapViewListener().onMapAnimationFinish();
                            }
                            if (this.a.isNaviMode() && (naviMapViewListener = this.a.j) != null) {
                                naviMapViewListener.onMapAnimationFinish();
                            }
                            MapController mapController2 = this.a;
                            if (mapController2.mListeners != null) {
                                com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = mapController2.getMapStatusInner();
                                for (int i3 = 0; i3 < this.a.mListeners.size(); i3++) {
                                    al alVar = this.a.mListeners.get(i3);
                                    if (alVar != null) {
                                        alVar.c(mapStatusInner);
                                    }
                                }
                            }
                        }
                    } else if (this.a.mListeners == null) {
                        return;
                    } else {
                        for (int i4 = 0; i4 < this.a.mListeners.size(); i4++) {
                            al alVar2 = this.a.mListeners.get(i4);
                            if (alVar2 != null) {
                                alVar2.c();
                            }
                        }
                        MapController mapController3 = this.a;
                        mapController3.mIsMoving = false;
                        mapController3.mIsAnimating = false;
                    }
                    MapController mapController4 = this.a;
                    if (!mapController4.mIsMapLoadFinish && mapController4.x > 0 && this.a.w > 0 && this.a.getMapView() != null && this.a.getMapView().getProjection() != null && this.a.getMapView().getProjection().fromPixels(0, 0) != null) {
                        this.a.mIsMapLoadFinish = true;
                        com.baidu.platform.comapi.util.j.a(new o(this), 0L);
                    }
                    if (this.a.mListeners != null) {
                        for (int i5 = 0; i5 < this.a.mListeners.size(); i5++) {
                            al alVar3 = this.a.mListeners.get(i5);
                            if (alVar3 != null) {
                                alVar3.a();
                            }
                        }
                    }
                } else if (i == 41) {
                    if (((Long) message.obj).longValue() != this.a.u) {
                        return;
                    }
                    MapController mapController5 = this.a;
                    if (mapController5.mListeners == null) {
                        return;
                    }
                    if (mapController5.mIsMoving || mapController5.mIsAnimating) {
                        com.baidu.mapsdkplatform.comapi.map.x mapStatusInner2 = this.a.getMapStatusInner();
                        for (int i6 = 0; i6 < this.a.mListeners.size(); i6++) {
                            al alVar4 = this.a.mListeners.get(i6);
                            if (alVar4 != null) {
                                alVar4.b(mapStatusInner2);
                            }
                        }
                    }
                    if (this.a.isSetMapStatusByUsr) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        if (this.a.Z != null) {
                            this.a.Z.sendMessage(obtain);
                        }
                        this.a.isSetMapStatusByUsr = false;
                    }
                } else if (i == 2082) {
                    int i7 = message.arg1;
                    if (i7 == 1003) {
                        i7 = 0;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (OpenLogUtil.isMapLogEnable()) {
                        com.baidu.mapsdkplatform.comapi.commonutils.b a = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
                        a.a("onMapRenderValidFrame isValid = " + z + "; errorCode = " + i7);
                    }
                    if (this.a.mListeners != null) {
                        for (int i8 = 0; i8 < this.a.mListeners.size(); i8++) {
                            al alVar5 = this.a.mListeners.get(i8);
                            if (alVar5 != null) {
                                alVar5.a(z, i7);
                            }
                        }
                    }
                }
                if (message.what == 512) {
                    int i9 = message.arg1;
                    if (this.a.getMapViewListener() != null) {
                        this.a.getMapViewListener().onClickedPopup(i9);
                    }
                }
                if (message.what == 50) {
                    if (OpenLogUtil.isMapLogEnable()) {
                        com.baidu.mapsdkplatform.comapi.commonutils.b a2 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
                        a2.a("EngineMeassage IndoorMap msg.what = " + message.what + "; msg.arg1 = " + message.arg1);
                    }
                    MapController mapController6 = this.a;
                    EngineMsgListener engineMsgListener = mapController6.g;
                    if (engineMsgListener != null) {
                        int i10 = message.arg1;
                        if (i10 == 1) {
                            this.a.g.onEnterIndoorMapMode(mapController6.getFocusedBaseIndoorMapInfo());
                        } else if (i10 == 0) {
                            engineMsgListener.onExitIndoorMapMode();
                        }
                    }
                    MapController mapController7 = this.a;
                    if (mapController7.mListeners == null) {
                        return;
                    }
                    IndoorMapInfo focusedBaseIndoorMapInfo = mapController7.getFocusedBaseIndoorMapInfo();
                    for (int i11 = 0; i11 < this.a.mListeners.size(); i11++) {
                        al alVar6 = this.a.mListeners.get(i11);
                        if (alVar6 != null) {
                            int i12 = message.arg1;
                            if (i12 == 0) {
                                alVar6.a(false);
                                this.a.mMaxZoomLevel = 21.0f;
                            } else if (i12 == 1) {
                                if (this.a.getMapStatus().level >= 18.0f && focusedBaseIndoorMapInfo != null) {
                                    alVar6.a(true);
                                    this.a.mMaxZoomLevel = 22.0f;
                                } else {
                                    alVar6.a(false);
                                    this.a.mMaxZoomLevel = 21.0f;
                                }
                            }
                        }
                    }
                }
                if (message.what == 51) {
                    this.a.setNetStatus(message.arg1);
                }
                if (message.what == 65301) {
                    MapController mapController8 = this.a;
                    if (mapController8.g != null) {
                        int i13 = message.arg1;
                        if (i13 == 1) {
                            mapController8.getMapBarData();
                        } else if (i13 == 0) {
                            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(774770718, "Lcom/baidu/platform/comapi/map/MapController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(774770718, "Lcom/baidu/platform/comapi/map/MapController;");
                return;
            }
        }
        W = new ArrayList();
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.E && this.t != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.I = false;
            this.N = 0.0f;
            this.L = -1.0f;
            this.M = -1.0f;
        }
    }

    public void clearUniversalLayer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && b()) {
            this.t.clearUniversalLayer();
        }
    }

    public float getAdapterZoomUnitsEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!b()) {
                return 0.0f;
            }
            return this.t.GetAdapterZoomUnitsEx();
        }
        return invokeV.floatValue;
    }

    public AppBaseMap getBaseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.t;
        }
        return (AppBaseMap) invokeV.objValue;
    }

    public CaptureMapListener getCaptureMapListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.c;
        }
        return (CaptureMapListener) invokeV.objValue;
    }

    public MapStatus getCurrentMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return a(false);
        }
        return (MapStatus) invokeV.objValue;
    }

    public float getCurrentZoomLevel() {
        InterceptResult invokeV;
        Bundle GetMapStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AppBaseMap appBaseMap = this.t;
            if (appBaseMap == null || (GetMapStatus = appBaseMap.GetMapStatus(false)) == null) {
                return 4.0f;
            }
            return (float) GetMapStatus.getDouble("level");
        }
        return invokeV.floatValue;
    }

    public com.baidu.platform.comapi.map.b.d getGestureMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.l == null) {
                this.l = new com.baidu.platform.comapi.map.b.d(this);
            }
            return this.l;
        }
        return (com.baidu.platform.comapi.map.b.d) invokeV.objValue;
    }

    public k getHideIndoorPopupListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return (k) invokeV.objValue;
    }

    public EngineMsgListener getIndoorMapListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g;
        }
        return (EngineMsgListener) invokeV.objValue;
    }

    public List<al> getListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mListeners;
        }
        return (List) invokeV.objValue;
    }

    public boolean getMapBarShowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.getMapBarData(new Bundle());
        }
        return invokeV.booleanValue;
    }

    public boolean getMapClickEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public MapControlMode getMapControlMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.ac;
        }
        return (MapControlMode) invokeV.objValue;
    }

    public long getMapId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.u;
        }
        return invokeV.longValue;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.f;
        }
        return (MapRenderModeChangeListener) invokeV.objValue;
    }

    public int getMapScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!b()) {
                return 0;
            }
            return this.t.getMapScene();
        }
        return invokeV.intValue;
    }

    public MapStatus getMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return a(true);
        }
        return (MapStatus) invokeV.objValue;
    }

    public com.baidu.mapsdkplatform.comapi.map.x getMapStatusInner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!b()) {
                return null;
            }
            Bundle GetMapStatus = this.t.GetMapStatus();
            com.baidu.mapsdkplatform.comapi.map.x xVar = new com.baidu.mapsdkplatform.comapi.map.x();
            xVar.a(GetMapStatus);
            return xVar;
        }
        return (com.baidu.mapsdkplatform.comapi.map.x) invokeV.objValue;
    }

    public int getMapTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!b()) {
                return 0;
            }
            return this.t.getMapTheme();
        }
        return invokeV.intValue;
    }

    public MapViewInterface getMapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            SoftReference<MapViewInterface> softReference = this.i;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        return (MapViewInterface) invokeV.objValue;
    }

    public MapViewListener getMapViewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.b;
        }
        return (MapViewListener) invokeV.objValue;
    }

    public MapViewSurfaceListener getMapViewSurfaceListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.h;
        }
        return (MapViewSurfaceListener) invokeV.objValue;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.j;
        }
        return (NaviMapViewListener) invokeV.objValue;
    }

    public int getSceneLayerScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public int getSceneLayerTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public int getScreenHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            MapStatus.WinRound winRound = getMapStatus().winRound;
            int i = winRound.bottom - winRound.top;
            this.x = i;
            return i;
        }
        return invokeV.intValue;
    }

    public int getScreenWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            MapStatus.WinRound winRound = getMapStatus().winRound;
            int i = winRound.right - winRound.left;
            this.w = i;
            return i;
        }
        return invokeV.intValue;
    }

    public an getStreetArrowClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.e;
        }
        return (an) invokeV.objValue;
    }

    public int getVMPMapCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.t != null) {
                Bundle bundle = new Bundle();
                bundle.putString("querytype", "map");
                this.t.GetVMPMapCityInfo(bundle);
                return bundle.getInt("code");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVMPMapCityItsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.t != null) {
                Bundle bundle = new Bundle();
                bundle.putString("querytype", "its");
                this.t.GetVMPMapCityInfo(bundle);
                return bundle.getInt("rst");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVMPMapCityLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.t != null) {
                Bundle bundle = new Bundle();
                bundle.putString("querytype", "map");
                this.t.GetVMPMapCityInfo(bundle);
                return bundle.getInt("level");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVMPMapCitySatInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.t != null) {
                Bundle bundle = new Bundle();
                bundle.putString("querytype", "sat");
                this.t.GetVMPMapCityInfo(bundle);
                return bundle.getInt("rst");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float getZoomLevel() {
        InterceptResult invokeV;
        Bundle GetMapStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            AppBaseMap appBaseMap = this.t;
            if (appBaseMap == null || (GetMapStatus = appBaseMap.GetMapStatus()) == null) {
                return 4.0f;
            }
            return (float) GetMapStatus.getDouble("level");
        }
        return invokeV.floatValue;
    }

    public int handleMapModeGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return MapMsgProc(4113, 0, 0);
        }
        return invokeV.intValue;
    }

    public void handleRightClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
        }
    }

    public void initAppBaseMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (W.size() == 0) {
                initBaseMap();
            } else {
                createByDuplicateAppBaseMap(W.get(0).GetId());
            }
        }
    }

    public void initBaseMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            AppBaseMap appBaseMap = new AppBaseMap();
            this.t = appBaseMap;
            appBaseMap.Create();
            this.u = this.t.GetId();
            List<AppBaseMap> list = W;
            if (list != null) {
                list.add(this.t);
            }
        }
    }

    public boolean is3DGestureEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.S;
        }
        return invokeV.booleanValue;
    }

    public boolean isBaseIndoorMapMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.IsBaseIndoorMapMode();
        }
        return invokeV.booleanValue;
    }

    public boolean isCanTouchMove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.V;
        }
        return invokeV.booleanValue;
    }

    public boolean isDoubleClickZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public boolean isDuplicate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.aa;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableDMoveZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableIndoor3D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (b()) {
                return this.t.isEnableIndoor3D();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.U;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean isMapAnimationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.isAnimationRunning();
        }
        return invokeV.booleanValue;
    }

    public boolean isMovedMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean isNaviMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (b()) {
                return this.t.isNaviMode();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverlookGestureEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.T;
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetArrowShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.IsStreetArrowShown();
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetCustomMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.IsStreetCustomMarkerShown();
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetPOIMarkerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.IsStreetPOIMarkerShown();
        }
        return invokeV.booleanValue;
    }

    public boolean isStreetRoadClickable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.IsStreetRoadClickable();
        }
        return invokeV.booleanValue;
    }

    public boolean isTwoTouchClickZoomEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && b()) {
            this.t.OnPause();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && b()) {
            this.t.OnResume();
        }
    }

    public void removeStreetAllCustomMarker() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048682, this) != null) || !b()) {
            return;
        }
        this.t.RemoveStreetAllCustomMarker();
    }

    public void startIndoorAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048736, this) != null) || !b()) {
            return;
        }
        this.t.StartIndoorAnimation();
    }

    public void unInitForMultiTextureView() {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && this.E && (appBaseMap = this.t) != null) {
            appBaseMap.Release();
            this.t = null;
            this.E = false;
        }
    }

    public void updateDrawFPS() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && b()) {
            this.t.updateDrawFPS();
        }
    }

    public MapController() {
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
        this.m = true;
        this.n = true;
        this.a = 0;
        this.o = 1;
        this.p = 1;
        this.q = false;
        this.s = false;
        this.t = null;
        this.u = 0L;
        this.v = null;
        this.nearlyRadius = 20;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = new a(this);
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = false;
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = 0.0f;
        this.P = false;
        this.Q = false;
        this.S = true;
        this.T = true;
        this.U = true;
        this.V = true;
        this.mIsInertialAnimation = true;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.mMaxZoomLevel = 21.0f;
        this.mMinZoomLevel = 4.0f;
        this.mIsMoving = false;
        this.mIsAnimating = false;
        this.isSetMapStatusByUsr = false;
        this.Y = false;
        this.Z = null;
        this.aa = false;
        this.ab = new com.baidu.platform.comapi.map.b.b(this);
        this.ac = MapControlMode.DEFAULT;
        this.mListeners = new CopyOnWriteArrayList();
        this.w = SysOSUtil.getInstance().getScreenWidth();
        this.x = SysOSUtil.getInstance().getScreenHeight();
        this.v = new b(this);
        this.Z = new m(this);
        d();
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        InterceptResult invokeV;
        String[] strArr;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!b()) {
                return null;
            }
            String GetFocusedBaseIndoorMapInfo = this.t.GetFocusedBaseIndoorMapInfo();
            if (!TextUtils.isEmpty(GetFocusedBaseIndoorMapInfo)) {
                try {
                    JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
                    String optString = jSONObject.optString("focusindoorid");
                    String optString2 = jSONObject.optString("curfloor");
                    int optInt = jSONObject.optInt("idrtype");
                    JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                    if (optJSONArray != null) {
                        strArr = new String[optJSONArray.length()];
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        arrayList.toArray(strArr);
                    } else {
                        strArr = null;
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("floorattribute");
                    if (optJSONArray2 != null) {
                        iArr = new int[optJSONArray2.length()];
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            iArr[i2] = optJSONArray2.optInt(i2);
                        }
                    } else {
                        iArr = null;
                    }
                    return new IndoorMapInfo(optString, optString2, strArr, iArr, optInt, jSONObject.optInt("idrguide"), jSONObject.optString("idrsearch"));
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (IndoorMapInfo) invokeV.objValue;
    }

    private MapStatus a(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, this, z2)) == null) {
            if (!b()) {
                return new MapStatus();
            }
            Bundle GetMapStatus = this.t.GetMapStatus(z2);
            if (GetMapStatus == null) {
                return new MapStatus();
            }
            MapStatus mapStatus = new MapStatus();
            mapStatus.level = (float) GetMapStatus.getDouble("level");
            mapStatus.rotation = (int) GetMapStatus.getDouble("rotation");
            mapStatus.overlooking = (int) GetMapStatus.getDouble("overlooking");
            mapStatus.centerPtX = GetMapStatus.getDouble("centerptx");
            mapStatus.centerPtY = GetMapStatus.getDouble("centerpty");
            mapStatus.centerPtZ = GetMapStatus.getDouble("centerptz");
            mapStatus.winRound.left = GetMapStatus.getInt("left");
            mapStatus.winRound.right = GetMapStatus.getInt("right");
            mapStatus.winRound.top = GetMapStatus.getInt("top");
            mapStatus.winRound.bottom = GetMapStatus.getInt("bottom");
            mapStatus.geoRound.left = GetMapStatus.getLong("gleft");
            mapStatus.geoRound.right = GetMapStatus.getLong("gright");
            mapStatus.geoRound.top = GetMapStatus.getLong("gtop");
            mapStatus.geoRound.bottom = GetMapStatus.getLong("gbottom");
            mapStatus.xOffset = GetMapStatus.getFloat("xoffset");
            mapStatus.yOffset = GetMapStatus.getFloat("yoffset");
            boolean z5 = false;
            if (GetMapStatus.getInt("bfpp") == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            mapStatus.bfpp = z3;
            mapStatus.panoId = GetMapStatus.getString("panoid");
            mapStatus.streetIndicateAngle = GetMapStatus.getFloat("siangle");
            if (GetMapStatus.getInt("isbirdeye") == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            mapStatus.isBirdEye = z4;
            mapStatus.streetExt = GetMapStatus.getInt("ssext");
            mapStatus.roadOffsetX = GetMapStatus.getFloat("roadOffsetX");
            mapStatus.roadOffsetY = GetMapStatus.getFloat("roadOffsetY");
            if (GetMapStatus.getInt("boverlookback") == 1) {
                z5 = true;
            }
            mapStatus.bOverlookSpringback = z5;
            mapStatus.minOverlooking = (int) GetMapStatus.getFloat("minoverlook");
            mapStatus.xScreenOffset = GetMapStatus.getFloat("xScreenOffset");
            mapStatus.yScreenOffset = GetMapStatus.getFloat("yScreenOffset");
            MapStatus.GeoBound geoBound = mapStatus.geoRound;
            if (geoBound.left <= -20037508) {
                geoBound.left = -20037508L;
            }
            MapStatus.GeoBound geoBound2 = mapStatus.geoRound;
            if (geoBound2.right >= 20037508) {
                geoBound2.right = 20037508L;
            }
            MapStatus.GeoBound geoBound3 = mapStatus.geoRound;
            if (geoBound3.top >= 20037508) {
                geoBound3.top = 20037508L;
            }
            MapStatus.GeoBound geoBound4 = mapStatus.geoRound;
            if (geoBound4.bottom <= -20037508) {
                geoBound4.bottom = -20037508L;
            }
            return mapStatus;
        }
        return (MapStatus) invokeZ.objValue;
    }

    public void handleDoubleTouch(MotionEvent motionEvent) {
        SoftReference<MapViewInterface> softReference;
        GeoPoint fromPixels;
        float f;
        NaviMapViewListener naviMapViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, motionEvent) != null) || System.currentTimeMillis() - this.O > 150) {
            return;
        }
        if (isNaviMode() && (naviMapViewListener = this.j) != null) {
            naviMapViewListener.onAction(513, motionEvent);
        } else if (this.H && (softReference = this.i) != null && softReference.get() != null && this.i.get().getProjection() != null) {
            MapStatus mapStatus = getMapStatus();
            float x = motionEvent.getX() - (mapStatus.winRound.left + (getScreenWidth() / 2));
            float y2 = (motionEvent.getY() - (mapStatus.winRound.top + (getScreenHeight() / 2))) * (-1.0f);
            float f2 = 0.0f;
            if (!isCompass && !this.K) {
                fromPixels = this.i.get().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                fromPixels = this.i.get().getProjection().fromPixels(mapStatus.winRound.left + (getScreenWidth() / 2), mapStatus.winRound.top + (getScreenHeight() / 2));
                x = 0.0f;
                y2 = 0.0f;
            }
            if (fromPixels != null) {
                f2 = (float) fromPixels.getLongitudeE6();
                f = (float) fromPixels.getLatitudeE6();
            } else {
                f = 0.0f;
            }
            this.P = true;
            android.graphics.Point point = new android.graphics.Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            if (fromPixels != null && this.mListeners != null) {
                for (int i = 0; i < this.mListeners.size(); i++) {
                    al alVar = this.mListeners.get(i);
                    if (alVar != null) {
                        alVar.b(fromPixels);
                        if (alVar.a(point, getMapStatusInner())) {
                            return;
                        }
                    }
                }
            }
            getGestureMonitor().b(this.i.get().getZoomLevel() + 1.0f);
            mapStatusChangeStart();
            MapMsgProc(8195, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16), (this.w / 2) | ((this.x / 2) << 16), 0, 0, f2, f, x, y2);
            R = System.currentTimeMillis();
            procGestureForLog(false, null);
        }
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, motionEvent)) == null) {
            if (!y || System.currentTimeMillis() - R < 300) {
                return true;
            }
            if (this.mHasMapObjDraging) {
                if (getMapView() != null && getMapView().getProjection() != null) {
                    GeoPoint fromPixels = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.mListeners != null) {
                        for (int i = 0; i < this.mListeners.size(); i++) {
                            al alVar = this.mListeners.get(i);
                            if (alVar != null && fromPixels != null) {
                                alVar.d(fromPixels);
                            }
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - z);
            float abs2 = Math.abs(motionEvent.getY() - A);
            double density = SysOSUtil.getInstance().getDensity();
            if (density > 1.5d) {
                density *= 1.5d;
            }
            float f = (float) density;
            if (B && abs / f <= 3.0f && abs2 / f <= 3.0f) {
                return true;
            }
            B = false;
            if (isCompass) {
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
            }
            procGestureForLog(true, new Point(abs, abs2));
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            float x2 = z - motionEvent.getX();
            float y3 = A - motionEvent.getY();
            android.graphics.Point point = new android.graphics.Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            android.graphics.Point point2 = new android.graphics.Point((int) (motionEvent.getRawX() + x2), (int) (motionEvent.getRawY() + y3));
            if (x < 0) {
                x = 0;
            }
            if (y2 < 0) {
                y2 = 0;
            }
            if (this.mListeners != null) {
                com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = getMapStatusInner();
                for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                    al alVar2 = this.mListeners.get(i2);
                    if (alVar2 != null && alVar2.b(point2, point, mapStatusInner)) {
                        this.D = false;
                        this.s = true;
                        this.Y = true;
                        return false;
                    }
                }
            }
            if (this.m) {
                getGestureMonitor().b();
                this.m = false;
            }
            mapStatusChangeStart();
            MapMsgProc(3, 0, x | (y2 << 16));
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.b(false, true));
            this.D = false;
            this.s = true;
            this.Y = true;
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mIsMoving = false;
            if (!this.mIsAnimating) {
                if (this.mListeners == null) {
                    return;
                }
                com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = getMapStatusInner();
                for (int i = 0; i < this.mListeners.size(); i++) {
                    al alVar = this.mListeners.get(i);
                    if (alVar != null) {
                        alVar.c(mapStatusInner);
                    }
                }
            }
            this.isSetMapStatusByUsr = false;
        }
    }

    public double getZoomUnitsInMeter() {
        InterceptResult invokeV;
        Bundle GetMapStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            AppBaseMap baseMap = getBaseMap();
            if (baseMap != null && (GetMapStatus = baseMap.GetMapStatus()) != null) {
                double d = GetMapStatus.getFloat("adapterZoomUnits");
                if (d > 1.0E-4d) {
                    return d;
                }
            }
            return Math.pow(2.0d, 18.0f - getZoomLevel());
        }
        return invokeV.doubleValue;
    }

    public void mapStatusChangeStart() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048675, this) != null) || this.mIsMoving) {
            return;
        }
        this.mIsMoving = true;
        this.mIsAnimating = false;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = getMapStatusInner();
            for (int i = 0; i < this.mListeners.size(); i++) {
                al alVar = this.mListeners.get(i);
                if (alVar != null) {
                    alVar.a(mapStatusInner);
                }
            }
        }
    }

    public void unInit() {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            e();
            Handler handler = this.v;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.v = null;
            }
            List<AppBaseMap> list = W;
            if (list != null) {
                list.remove(this.t);
            }
            List<al> list2 = this.mListeners;
            if (list2 != null) {
                list2.clear();
            }
            if (this.E && (appBaseMap = this.t) != null) {
                appBaseMap.Release();
                this.t = null;
                this.E = false;
            }
            if (this.f != null) {
                this.f = null;
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, motionEvent) == null) {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            z = x;
            A = y2;
            MapMsgProc(4, 0, x | (y2 << 16));
            B = true;
            this.X = motionEvent.getDownTime();
        }
    }

    public void SetStyleMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            setMapScene(i);
        }
    }

    public void addOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.t.addOneOverlayItem(bundle);
        }
    }

    public boolean cleanCache(MapLayerType mapLayerType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapLayerType)) == null) {
            AppBaseMap appBaseMap = this.t;
            if (appBaseMap != null && appBaseMap.CleanCache(mapLayerType.a)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void enablePOIAnimation(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) && b()) {
            this.t.enablePOIAnimation(z2);
        }
    }

    public void forceSetMapScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.o = i;
            if (b()) {
                this.t.setMapScene(this.o);
            }
        }
    }

    public int getCacheSize(MapLayerType mapLayerType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, mapLayerType)) == null) {
            AppBaseMap appBaseMap = this.t;
            if (appBaseMap == null) {
                return 0;
            }
            return appBaseMap.GetCacheSize(mapLayerType.a);
        }
        return invokeL.intValue;
    }

    public String getCityInfoByID(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            AppBaseMap appBaseMap = this.t;
            if (appBaseMap != null) {
                return appBaseMap.GetCityInfoByID(i);
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public String getProjectionPt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            if (!b()) {
                return null;
            }
            return this.t.getProjectionPt(str);
        }
        return (String) invokeL.objValue;
    }

    public float getZoomToBoundF(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, bundle)) == null) {
            if (!b()) {
                return 0.0f;
            }
            return this.t.GetZoomToBoundF(bundle);
        }
        return invokeL.floatValue;
    }

    public void handleClick(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, motionEvent) == null) {
            MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
        }
    }

    public void handleDoubleDownClick(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, motionEvent) == null) {
            this.I = true;
            this.L = motionEvent.getX();
            this.M = motionEvent.getY();
            this.O = System.currentTimeMillis();
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        }
    }

    public void handleLongClick(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, motionEvent) == null) {
            MapMsgProc(20737, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
        }
    }

    public boolean handleZoomTo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i)) == null) {
            if (i != 0) {
                if (i == 1) {
                    MapMsgProc(4096, -1, 0);
                }
            } else {
                MapMsgProc(4097, -1, 0);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean importMapTheme(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.importMapTheme(i);
        }
        return invokeI.booleanValue;
    }

    public boolean isInFocusIndoorBuilding(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, geoPoint)) == null) {
            if (!b() || geoPoint == null || !this.t.IsPointInFocusIDRBorder(geoPoint.getLongitude(), geoPoint.getLatitude())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void recycleMemory(RecycleMemoryLevel recycleMemoryLevel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048679, this, recycleMemoryLevel) == null) && b()) {
            this.t.recycleMemory(recycleMemoryLevel.getLevel());
        }
    }

    public void registMapViewListener(al alVar) {
        List<al> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048680, this, alVar) == null) && alVar != null && (list = this.mListeners) != null) {
            list.add(alVar);
        }
    }

    public void removeOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, bundle) == null) {
            this.t.removeOneOverlayItem(bundle);
        }
    }

    public void removeStreetCustomMarker(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048683, this, str) != null) || !b()) {
            return;
        }
        this.t.RemoveStreetCustomMaker(str);
    }

    public void saveScreenToLocal(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            saveScreenToLocal(str, 0, 0, 0, 0);
        }
    }

    public void set3DGestureEnable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.S = z2;
        }
    }

    public void setActingTwoClickZoom(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z2) == null) {
            this.Q = z2;
        }
    }

    public void setAllStreetCustomMarkerVisibility(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048689, this, z2) != null) || !b()) {
            return;
        }
        this.t.SetAllStreetCustomMarkerVisibility(z2);
    }

    public void setCanTouchMove(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z2) == null) {
            this.V = z2;
        }
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, captureMapListener) == null) {
            this.c = captureMapListener;
        }
    }

    public void setDoubleClickZoom(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) {
            this.H = z2;
        }
    }

    public void setEnableIndoor3D(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048693, this, z2) == null) && b()) {
            this.t.setEnableIndoor3D(z2);
        }
    }

    public void setEnableZoom(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            this.U = z2;
        }
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, engineMsgListener) == null) {
            this.g = engineMsgListener;
        }
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z2) == null) {
            this.K = z2;
        }
    }

    public void setFlingEnable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.n = z2;
        }
    }

    public void setHideIndoorPopupListener(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, kVar) == null) {
            this.d = kVar;
        }
    }

    public void setInertialAnimation(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.mIsInertialAnimation = z2;
            this.P = z2;
            this.Q = z2;
        }
    }

    public void setMapClickEnable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.C = z2;
        }
    }

    public int setMapControlMode(MapControlMode mapControlMode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, mapControlMode)) == null) {
            if (!b()) {
                return -1;
            }
            this.ac = mapControlMode;
            return this.t.SetMapControlMode(mapControlMode.a);
        }
        return invokeL.intValue;
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback mapFirstFrameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, mapFirstFrameCallback) == null) {
            this.r = mapFirstFrameCallback;
        }
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, mapRenderModeChangeListener) == null) {
            this.f = mapRenderModeChangeListener;
        }
    }

    public void setMapScene(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048705, this, i) != null) || i == getMapScene()) {
            return;
        }
        this.o = i;
        if (b()) {
            this.t.setMapScene(this.o);
        }
    }

    public void setMapStatus(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048706, this, bundle) != null) || !b()) {
            return;
        }
        this.t.SetMapStatus(bundle);
    }

    public void setMapViewInterface(MapViewInterface mapViewInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, mapViewInterface) == null) {
            this.i = new SoftReference<>(mapViewInterface);
        }
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, mapViewListener) == null) {
            this.b = mapViewListener;
        }
    }

    public void setMapViewSurfaceListener(MapViewSurfaceListener mapViewSurfaceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, mapViewSurfaceListener) == null) {
            this.h = mapViewSurfaceListener;
        }
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, naviMapViewListener) == null) {
            this.j = naviMapViewListener;
        }
    }

    public void setNetStatus(int i) {
        EngineMsgListener engineMsgListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048719, this, i) != null) || (engineMsgListener = this.g) == null) {
            return;
        }
        if (i == 1) {
            engineMsgListener.onLongLinkConnect();
        } else if (i == 2 && this.a != i) {
            engineMsgListener.onLongLinkDisConnect();
        }
        this.a = i;
    }

    public void setOverlayMapCallBack(af afVar) {
        AppBaseMap appBaseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048720, this, afVar) == null) && afVar != null && (appBaseMap = this.t) != null) {
            appBaseMap.SetCallback(afVar);
        }
    }

    public void setOverlookGestureEnable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            this.T = z2;
        }
    }

    public void setRecommendPOIScene(RecommendPoiScene recommendPoiScene) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048722, this, recommendPoiScene) == null) && b()) {
            this.t.setRecommendPOIScene(recommendPoiScene.value);
        }
    }

    public void setStreetArrowClickListener(an anVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, anVar) == null) {
            this.e = anVar;
        }
    }

    public void setStreetArrowShow(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) && b()) {
            this.t.SetStreetArrowShow(z2);
        }
    }

    public void setStreetRoadClickable(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048727, this, z2) == null) && b()) {
            this.t.SetStreetRoadClickable(z2);
        }
    }

    public void setStyleMode(MapStyleMode mapStyleMode) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048728, this, mapStyleMode) != null) || !b()) {
            return;
        }
        this.t.SetStyleMode(mapStyleMode.getMode());
    }

    public void setTravelMode(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) {
            this.q = z2;
        }
    }

    public void setTwoTouchClickZoomEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) {
            this.J = z2;
        }
    }

    public void setUniversalFilter(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, str) == null) && b()) {
            this.t.setUniversalFilter(str);
        }
    }

    public void showBaseIndoorMap(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048733, this, z2) != null) || !b()) {
            return;
        }
        this.t.ShowBaseIndoorMap(z2);
    }

    public void showStreetPOIMarker(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048734, this, z2) != null) || !b()) {
            return;
        }
        this.t.ShowStreetPOIMarker(z2);
    }

    public void showUniversalLayer(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048735, this, bundle) == null) && b()) {
            this.t.showUniversalLayer(bundle);
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, bundle) == null) {
            this.t.updateOneOverlayItem(bundle);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        r7 = (org.json.JSONObject) new org.json.JSONObject(r8).getJSONArray("dataset").get(0);
        r8 = r7.getInt("itemindex");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        r2 = r7.optInt("clickindex", -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
        r4 = r8;
        r7 = r3;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
        r13 = r3;
        r10 = r8;
        r11 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        long j;
        int i4;
        int i5;
        long j2;
        int i6;
        boolean z2;
        int i7;
        String GetNearlyObjID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65545, this, i, i2, i3)) == null) {
            boolean z3 = false;
            if (!b()) {
                return false;
            }
            SoftReference<MapViewInterface> softReference = this.i;
            if (softReference != null && softReference.get() != null) {
                MapViewInterface mapViewInterface = this.i.get();
                long j3 = 0;
                try {
                    int size = mapViewInterface.getOverlays().size() - 1;
                    while (true) {
                        if (size >= 0) {
                            Overlay overlay = mapViewInterface.getOverlays().get(size);
                            if (overlay.mType == 27) {
                                j3 = overlay.mLayerID;
                                int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
                                if (this.t != null && (GetNearlyObjID = this.t.GetNearlyObjID(j3, i2, i3, zoomUnitsInMeter)) != null && !GetNearlyObjID.equals("")) {
                                    break;
                                }
                            }
                            size--;
                        } else {
                            j2 = j3;
                            i6 = -1;
                            z2 = false;
                            i7 = -1;
                            break;
                        }
                    }
                    i5 = i6;
                    z3 = z2;
                    i4 = i7;
                    j = j2;
                } catch (JSONException unused) {
                    int i8 = -1;
                }
                if (i == 1 && getMapViewListener() != null && getMapView() != null && getMapView().getProjection() != null) {
                    GeoPoint fromPixels = mapViewInterface.getProjection().fromPixels(i2, i3);
                    if (i5 == -1) {
                        getMapViewListener().onClickedItem(i4, i5, fromPixels, j);
                    } else {
                        getMapViewListener().onClickedItem(i4, fromPixels, j);
                    }
                }
            }
            return z3;
        }
        return invokeIII.booleanValue;
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048710, this, mapStatus, i, i2) == null) && b() && this.t != null && mapStatus != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("animationType", i);
            bundle.putInt("animatime", i2);
            bundle.putInt("left", mapStatus.winRound.left);
            bundle.putInt("right", mapStatus.winRound.right);
            bundle.putInt("top", mapStatus.winRound.top);
            bundle.putInt("bottom", mapStatus.winRound.bottom);
            if (i != 4) {
                bundle.putDouble("level", mapStatus.level);
                bundle.putDouble("rotation", mapStatus.rotation);
                bundle.putDouble("overlooking", mapStatus.overlooking);
                bundle.putDouble("centerptx", mapStatus.centerPtX);
                bundle.putDouble("centerpty", mapStatus.centerPtY);
                bundle.putDouble("centerptz", mapStatus.centerPtZ);
                bundle.putLong("gleft", mapStatus.geoRound.left);
                bundle.putLong("gright", mapStatus.geoRound.right);
                bundle.putLong("gbottom", mapStatus.geoRound.bottom);
                bundle.putLong("gtop", mapStatus.geoRound.top);
                bundle.putFloat("xoffset", mapStatus.xOffset);
                bundle.putFloat("yoffset", mapStatus.yOffset);
                bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
                bundle.putString("panoid", mapStatus.panoId);
                bundle.putInt("autolink", 0);
                bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
                bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
                bundle.putInt("ssext", mapStatus.streetExt);
                bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
                bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            }
            this.t.SetNewMapStatus(bundle);
        }
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, bundle2)) == null) {
            if (!b()) {
                return 0.0f;
            }
            return this.t.GetFZoomToBoundF(bundle, bundle2);
        }
        return invokeLL.floatValue;
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, bundle, bitmap) != null) || !b()) {
            return;
        }
        this.t.AddStreetCustomMarker(bundle, bitmap);
    }

    public void animateTo(GeoPoint geoPoint, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, geoPoint, i) != null) || !b()) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        mapStatus.centerPtX = geoPoint.getLongitude();
        mapStatus.centerPtY = geoPoint.getLatitude();
        setMapStatusWithAnimation(mapStatus, i);
    }

    public int getScaleLevel(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048618, this, i, i2)) == null) {
            if (!b()) {
                return 0;
            }
            return this.t.getScaleLevel(i, i2);
        }
        return invokeII.intValue;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048637, this, i, keyEvent)) == null) {
            int GetAdaptKeyCode = GetAdaptKeyCode(i);
            if (GetAdaptKeyCode == 0) {
                return false;
            }
            MapMsgProc(1, GetAdaptKeyCode, 0);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void scrollBy(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048686, this, i, i2) == null) {
            if (i == 0 && i2 == 0) {
                return;
            }
            MapStatus.WinRound winRound = getMapStatus().winRound;
            a(winRound.left + (this.w / 2) + i, winRound.top + (this.x / 2) + i2);
        }
    }

    public boolean setLayerSceneMode(long j, MapSceneMode mapSceneMode) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048700, this, j, mapSceneMode)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.SetLayerSceneMode(j, mapSceneMode.getMode());
        }
        return invokeJL.booleanValue;
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048712, this, i, bundle)) == null) {
            if (!b()) {
                return false;
            }
            if (this.t.getMapTheme() == i) {
                return true;
            }
            this.p = i;
            return this.t.setMapTheme(i, bundle);
        }
        return invokeIL.booleanValue;
    }

    public void setMaxAndMinZoomLevel(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mMaxZoomLevel = f;
            this.mMinZoomLevel = f2;
        }
    }

    public void setScreenSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048723, this, i, i2) == null) {
            this.w = i;
            this.x = i2;
        }
    }

    public void setStreetMarkerClickable(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048726, this, str, z2) != null) || !b()) {
            return;
        }
        this.t.SetStreetMarkerClickable(str, z2);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048729, this, z2, str) != null) || !b()) {
            return;
        }
        this.t.SetTargetStreetCustomMarkerVisibility(z2, str);
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048737, this, str, str2)) == null) {
            if (!b()) {
                return false;
            }
            return this.t.SwitchBaseIndoorMapFloor(str, str2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x019a A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0286 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0297 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a8 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b9 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ca A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02db A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ec A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02ff A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0310 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0322 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0331 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0340 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0351 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0362 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0380 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x039e A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b0 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c2 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03d3 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03e4 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03f0 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03fb A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0404 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x040f A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0418 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0424 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x042e A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0439 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0443 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x044d A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0456 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0461 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x046a A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0475 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0485 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x048e A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0499 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04a3 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04ae A[Catch: JSONException -> 0x078f, TRY_LEAVE, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04c3 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04cd A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04d8 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04e1 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04eb A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04f4 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04ff A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x050c A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0762 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0776 A[Catch: JSONException -> 0x078f, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0785 A[Catch: JSONException -> 0x078f, TRY_LEAVE, TryCatch #0 {JSONException -> 0x078f, blocks: (B:31:0x006c, B:34:0x007e, B:36:0x0084, B:38:0x0098, B:39:0x00a0, B:41:0x00a9, B:42:0x00b2, B:44:0x00b8, B:45:0x00be, B:47:0x00c7, B:49:0x00cf, B:51:0x00f4, B:100:0x0194, B:102:0x019a, B:370:0x0682, B:105:0x01bd, B:107:0x01ca, B:109:0x01d7, B:112:0x01df, B:114:0x01e8, B:116:0x01f7, B:121:0x0212, B:123:0x021a, B:130:0x024a, B:137:0x027e, B:139:0x0286, B:140:0x028f, B:142:0x0297, B:143:0x029f, B:145:0x02a8, B:146:0x02b1, B:148:0x02b9, B:149:0x02c1, B:151:0x02ca, B:152:0x02d3, B:154:0x02db, B:155:0x02e3, B:157:0x02ec, B:158:0x02f5, B:160:0x02ff, B:161:0x0307, B:163:0x0310, B:164:0x0319, B:166:0x0322, B:167:0x032b, B:169:0x0331, B:170:0x0337, B:172:0x0340, B:173:0x0349, B:175:0x0351, B:176:0x0359, B:178:0x0362, B:179:0x0377, B:181:0x0380, B:182:0x0395, B:184:0x039e, B:185:0x03a7, B:187:0x03b0, B:188:0x03b9, B:190:0x03c2, B:191:0x03cb, B:193:0x03d3, B:194:0x03db, B:196:0x03e4, B:198:0x03f3, B:200:0x03fb, B:202:0x0407, B:204:0x040f, B:206:0x041b, B:208:0x0424, B:210:0x0430, B:212:0x0439, B:214:0x0445, B:216:0x044d, B:218:0x0459, B:220:0x0461, B:222:0x046d, B:224:0x0475, B:225:0x047d, B:227:0x0485, B:229:0x0490, B:231:0x0499, B:233:0x04a5, B:235:0x04ae, B:239:0x04bb, B:241:0x04c3, B:243:0x04d0, B:245:0x04d8, B:247:0x04e3, B:249:0x04eb, B:251:0x04f6, B:253:0x04ff, B:256:0x050c, B:258:0x052d, B:369:0x067f, B:300:0x058d, B:306:0x059f, B:319:0x05bf, B:321:0x05c5, B:408:0x06ee, B:410:0x06f4, B:412:0x06fa, B:413:0x0702, B:415:0x0708, B:416:0x0710, B:418:0x0716, B:419:0x071e, B:421:0x0724, B:422:0x072c, B:424:0x0732, B:425:0x073a, B:427:0x0740, B:428:0x0748, B:432:0x0752, B:433:0x075a, B:434:0x0762, B:436:0x0768, B:437:0x0770, B:439:0x0776, B:440:0x077f, B:442:0x0785, B:326:0x05d6, B:328:0x05dc, B:333:0x05ec, B:334:0x05ef, B:336:0x05f5, B:339:0x0603, B:341:0x0609, B:346:0x061a, B:349:0x0624, B:351:0x062a, B:357:0x0643, B:358:0x0647, B:360:0x064d, B:361:0x0655, B:365:0x066d, B:250:0x04f4, B:246:0x04e1, B:242:0x04cd, B:232:0x04a3, B:228:0x048e, B:221:0x046a, B:217:0x0456, B:213:0x0443, B:209:0x042e, B:205:0x0418, B:201:0x0404, B:197:0x03f0, B:129:0x0243, B:126:0x0231, B:131:0x024e, B:133:0x025b, B:135:0x0264, B:117:0x01fe, B:119:0x0206, B:120:0x020f, B:113:0x01e6, B:108:0x01d4, B:85:0x013a, B:88:0x014b, B:91:0x015e, B:94:0x0168, B:96:0x017b, B:98:0x0187), top: B:452:0x006c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i, int i2) {
        InterceptResult invokeII;
        Point point;
        int i3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int i4;
        String str;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        JSONArray jSONArray;
        String str2;
        ArrayList arrayList12;
        ArrayList arrayList13;
        ArrayList arrayList14;
        double intX;
        double intY;
        JSONObject jSONObject;
        NaviMapViewListener naviMapViewListener;
        NaviMapViewListener naviMapViewListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65549, this, i, i2)) == null) {
            if (!b()) {
                return false;
            }
            if (getMapViewListener() == null && this.j == null) {
                return false;
            }
            int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
            int i5 = i;
            Point point2 = new Point(i5, i2);
            if (isNaviMode() && (naviMapViewListener2 = this.j) != null) {
                point = naviMapViewListener2.onTapInterception(point2);
            } else {
                point = null;
            }
            if (point != null) {
                i5 = point.getIntX();
                i3 = point.getIntY();
            } else {
                i3 = i2;
            }
            String GetNearlyObjID = this.t.GetNearlyObjID(-1L, i5, i3, zoomUnitsInMeter);
            if (GetNearlyObjID == null) {
                return false;
            }
            if (isNaviMode() && (naviMapViewListener = this.j) != null && naviMapViewListener.onItemClick(GetNearlyObjID, i5, i3)) {
                return true;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(GetNearlyObjID);
                ArrayList arrayList15 = new ArrayList();
                String str3 = "in";
                if (jSONObject2.has(MapBundleKey.MapObjKey.OBJ_MCAR) && (jSONObject = jSONObject2.getJSONObject(MapBundleKey.MapObjKey.OBJ_MCAR)) != null) {
                    ArrayList arrayList16 = new ArrayList();
                    MapObj mapObj = new MapObj();
                    mapObj.routeType = MapBundleKey.MapObjKey.OBJ_MCAR;
                    if (jSONObject.has("id")) {
                        mapObj.routeId = jSONObject.getInt("id");
                    }
                    if (jSONObject.has("status")) {
                        mapObj.status = jSONObject.getInt("status");
                    }
                    if (jSONObject.has("in")) {
                        mapObj.index = jSONObject.getInt("in");
                    }
                    arrayList16.add(mapObj);
                    if (getMapViewListener() != null) {
                        getMapViewListener().onClickedRouteObj(arrayList16);
                    }
                    return true;
                }
                JSONArray jSONArray2 = jSONObject2.getJSONArray("dataset");
                int i6 = ((JSONObject) jSONArray2.get(0)).getInt("ty");
                if (i6 == 22) {
                    arrayList2 = new ArrayList();
                } else {
                    if (i6 != 3 && i6 != 13 && i6 != 14 && i6 != 16 && i6 != 15 && i6 != 4 && i6 != 103 && i6 != 25 && i6 != 31 && i6 != 104 && i6 != 5000 && i6 != 6018 && i6 != 6019) {
                        if (i6 != 8 && i6 != 1 && i6 != 2) {
                            if (i6 == 6) {
                                arrayList6 = new ArrayList();
                                arrayList2 = null;
                                arrayList = null;
                                arrayList4 = null;
                                arrayList7 = null;
                                arrayList5 = null;
                                i4 = 0;
                                int i7 = -1;
                                while (i4 < jSONArray2.length()) {
                                    JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i4);
                                    int i8 = jSONObject3.getInt("ty");
                                    if (i8 == 26) {
                                        jSONArray = jSONArray2;
                                        str = GetNearlyObjID;
                                        str2 = str3;
                                        arrayList14 = arrayList;
                                        arrayList9 = arrayList4;
                                        arrayList10 = arrayList6;
                                        arrayList12 = arrayList7;
                                        arrayList13 = arrayList5;
                                    } else {
                                        MapObj mapObj2 = new MapObj();
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_LAYER_ID)) {
                                            mapObj2.layer_id = (int) jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_LAYER_ID);
                                        } else {
                                            mapObj2.layer_id = 0;
                                        }
                                        if (jSONObject3.has("ud")) {
                                            mapObj2.strUid = jSONObject3.getString("ud");
                                        } else {
                                            mapObj2.strUid = "";
                                        }
                                        mapObj2.strText = jSONObject3.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                                        if (jSONObject3.has(str3)) {
                                            mapObj2.nIndex = jSONObject3.getInt(str3);
                                        } else if (jSONObject3.has("index")) {
                                            mapObj2.nIndex = jSONObject3.getInt("index");
                                        } else {
                                            mapObj2.nIndex = 0;
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO)) {
                                            Point complexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_GEO));
                                            Point point3 = mapObj2.geoPt;
                                            if (complexPtToPoint == null) {
                                                jSONArray = jSONArray2;
                                                intX = 0.0d;
                                            } else {
                                                jSONArray = jSONArray2;
                                                intX = complexPtToPoint.getIntX();
                                            }
                                            if (complexPtToPoint == null) {
                                                str2 = str3;
                                                intY = 0.0d;
                                            } else {
                                                str2 = str3;
                                                intY = complexPtToPoint.getIntY();
                                            }
                                            point3.setTo(intX, intY);
                                        } else {
                                            jSONArray = jSONArray2;
                                            str2 = str3;
                                            if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                                                str = GetNearlyObjID;
                                                mapObj2.geoPt.setTo((int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO_Z)) {
                                                    mapObj2.geoZ = (float) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_GEO_Z);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI)) {
                                                    mapObj2.indoorpoi = jSONObject3.getBoolean(MapBundleKey.MapObjKey.OBJ_INDOOR_POI);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE)) {
                                                    mapObj2.poiOnlineType = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_BID)) {
                                                    mapObj2.bid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_BID);
                                                }
                                                if (jSONObject3.has("ts")) {
                                                    mapObj2.sltime = jSONObject3.getInt("ts");
                                                }
                                                if (jSONObject3.has("obj")) {
                                                    mapObj2.slobj = jSONObject3.getInt("obj");
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                                    mapObj2.slvisi = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                                                }
                                                mapObj2.nType = i8;
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                                    mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                                                    mapObj2.ssName = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_POINAME);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                                                    mapObj2.ssIndoorId = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID);
                                                }
                                                if (jSONObject3.has("ud")) {
                                                    mapObj2.ssPoiUid = jSONObject3.getString("ud");
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.STREET_TYPE)) {
                                                    mapObj2.ssType = jSONObject3.getString(MapBundleKey.MapObjKey.STREET_TYPE);
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                                                    mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DIS);
                                                }
                                                if (jSONObject3.has("x")) {
                                                    mapObj2.geoPt.setIntX(jSONObject3.getInt("x"));
                                                    mapObj2.streetArrowCenterX = jSONObject3.getDouble("x");
                                                }
                                                if (jSONObject3.has("y")) {
                                                    mapObj2.geoPt.setIntY(jSONObject3.getInt("y"));
                                                    mapObj2.streetArrowCenterY = jSONObject3.getDouble("y");
                                                }
                                                if (jSONObject3.has("z")) {
                                                    mapObj2.ssZ = jSONObject3.getInt("z");
                                                }
                                                if (jSONObject3.has("rotation")) {
                                                    mapObj2.ssRotation = jSONObject3.getDouble("rotation");
                                                }
                                                if (jSONObject3.has("pid")) {
                                                    mapObj2.ssPanoId = jSONObject3.getString("pid");
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                                    mapObj2.ssData = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                                                }
                                                if (!jSONObject3.has("src")) {
                                                    int i9 = jSONObject3.getInt("src");
                                                    mapObj2.dynamicSrc = i9;
                                                    i7 = i9;
                                                } else {
                                                    mapObj2.dynamicSrc = -1;
                                                }
                                                if (!jSONObject3.has("ad")) {
                                                    mapObj2.ad = jSONObject3.getInt("ad");
                                                } else {
                                                    mapObj2.ad = -1;
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                                    mapObj2.adstyle = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                                                } else {
                                                    mapObj2.adstyle = -1;
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                                    mapObj2.qid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_QID);
                                                } else {
                                                    mapObj2.qid = "";
                                                }
                                                if (!jSONObject3.has("puid")) {
                                                    mapObj2.puid = jSONObject3.getString("puid");
                                                } else {
                                                    mapObj2.puid = "";
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_SRC)) {
                                                    mapObj2.dysrc = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_SRC);
                                                } else {
                                                    mapObj2.dysrc = -1;
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_STGE)) {
                                                    mapObj2.dystge = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_STGE);
                                                } else {
                                                    mapObj2.dystge = -1;
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_ISAGG)) {
                                                    mapObj2.isAgg = jSONObject3.getBoolean(MapBundleKey.MapObjKey.OBJ_DY_ISAGG);
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                                    mapObj2.adLog = jSONObject3.getString(MapBundleKey.MapObjKey.AD_LOG);
                                                } else {
                                                    mapObj2.adLog = "";
                                                }
                                                if (!jSONObject3.has("url")) {
                                                    mapObj2.url = jSONObject3.getString("url");
                                                } else {
                                                    mapObj2.url = "";
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STYLE_ID)) {
                                                    mapObj2.style_id = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_STYLE_ID);
                                                } else {
                                                    try {
                                                        mapObj2.style_id = 0;
                                                    } catch (JSONException unused) {
                                                        return false;
                                                    }
                                                }
                                                if (!jSONObject3.has("level")) {
                                                    mapObj2.level = jSONObject3.getInt("level");
                                                } else {
                                                    mapObj2.level = -1;
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.CLICK_ACTION)) {
                                                    mapObj2.clickAction = jSONObject3.getString(MapBundleKey.MapObjKey.CLICK_ACTION);
                                                } else {
                                                    mapObj2.clickAction = "";
                                                }
                                                if (!jSONObject3.has(MapBundleKey.MapObjKey.EX_JSON)) {
                                                    mapObj2.exJson = jSONObject3.getString(MapBundleKey.MapObjKey.EX_JSON);
                                                } else {
                                                    mapObj2.exJson = "";
                                                }
                                                if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE)) {
                                                    mapObj2.statisticValue = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);
                                                }
                                                if (i6 != 22) {
                                                    ItsMapObj itsMapObj = new ItsMapObj();
                                                    itsMapObj.baseMapObj = mapObj2;
                                                    itsMapObj.tTrafficStart = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_START);
                                                    itsMapObj.tTrafficEnd = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_END);
                                                    itsMapObj.strTrafficDetail = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_DETAIL);
                                                    if (arrayList2 != null) {
                                                        arrayList2.add(itsMapObj);
                                                    }
                                                    arrayList14 = arrayList;
                                                    arrayList9 = arrayList4;
                                                    arrayList10 = arrayList6;
                                                } else {
                                                    if (i6 != 3 && i6 != 13 && i6 != 14 && i6 != 16 && i6 != 15 && i6 != 4 && i6 != 103 && i6 != 25 && i6 != 31 && i6 != 104 && i6 != 5000 && i6 != 6018) {
                                                        if (i6 == 6019) {
                                                            arrayList14 = arrayList;
                                                            arrayList9 = arrayList4;
                                                            arrayList10 = arrayList6;
                                                            arrayList12 = arrayList7;
                                                            arrayList13 = arrayList5;
                                                        } else {
                                                            if (i6 != 8 && i6 != 1 && i6 != 2) {
                                                                if (i6 == 6) {
                                                                    arrayList10 = arrayList6;
                                                                    if (arrayList10 != null) {
                                                                        arrayList10.add(mapObj2);
                                                                    }
                                                                    arrayList14 = arrayList;
                                                                    arrayList9 = arrayList4;
                                                                } else {
                                                                    arrayList10 = arrayList6;
                                                                    if (i6 == 24) {
                                                                        arrayList12 = arrayList7;
                                                                        if (arrayList12 != null) {
                                                                            arrayList12.add(mapObj2);
                                                                        }
                                                                        arrayList14 = arrayList;
                                                                        arrayList9 = arrayList4;
                                                                        arrayList13 = arrayList5;
                                                                    } else {
                                                                        arrayList12 = arrayList7;
                                                                        if (i6 != 1234 && i6 != 1236 && i6 != 2000 && i6 != 2001) {
                                                                            if (i6 == 1235) {
                                                                                if (getMapViewListener() != null) {
                                                                                    getMapViewListener().onClickStreetArrow(mapObj2);
                                                                                }
                                                                            } else if (i6 == 2002) {
                                                                                if (getMapViewListener() != null) {
                                                                                    getMapViewListener().onClickStreetSurface(mapObj2);
                                                                                }
                                                                            } else {
                                                                                if (i6 == 1239) {
                                                                                    arrayList9 = arrayList4;
                                                                                    if (arrayList9 != null) {
                                                                                        arrayList9.add(mapObj2);
                                                                                    }
                                                                                    if (getMapViewListener() != null) {
                                                                                        getMapViewListener().onClickedRouteLabelObj(arrayList9);
                                                                                    }
                                                                                } else {
                                                                                    arrayList9 = arrayList4;
                                                                                    if (i6 == 6000) {
                                                                                        if (getMapViewListener() != null) {
                                                                                            getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, true);
                                                                                        }
                                                                                    } else {
                                                                                        if (i6 == 7000) {
                                                                                            arrayList13 = arrayList5;
                                                                                            if (arrayList13 != null) {
                                                                                                arrayList13.add(mapObj2);
                                                                                            }
                                                                                        } else {
                                                                                            arrayList13 = arrayList5;
                                                                                            if (i6 == 6002) {
                                                                                                if (getMapViewListener() != null) {
                                                                                                    getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, jSONObject3.optBoolean("bchecked"));
                                                                                                }
                                                                                            } else {
                                                                                                if (i6 != 90909 && i6 != 90910) {
                                                                                                    arrayList15.add(mapObj2);
                                                                                                }
                                                                                                if (getMapViewListener() != null) {
                                                                                                    getMapViewListener().onClickSdkMapObj(i6, jSONObject3);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        arrayList14 = arrayList;
                                                                                    }
                                                                                }
                                                                                arrayList11 = arrayList5;
                                                                                arrayList8 = arrayList;
                                                                                break;
                                                                            }
                                                                            arrayList9 = arrayList4;
                                                                            arrayList11 = arrayList5;
                                                                            arrayList8 = arrayList;
                                                                            break;
                                                                        }
                                                                        arrayList9 = arrayList4;
                                                                        arrayList11 = arrayList5;
                                                                        getMapViewListener().onClickedStreetIndoorPoi(mapObj2);
                                                                        arrayList8 = arrayList;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            arrayList9 = arrayList4;
                                                            arrayList10 = arrayList6;
                                                            arrayList12 = arrayList7;
                                                            arrayList13 = arrayList5;
                                                            if (arrayList9 != null) {
                                                                arrayList9.add(mapObj2);
                                                            }
                                                            arrayList14 = arrayList;
                                                        }
                                                    } else {
                                                        arrayList9 = arrayList4;
                                                        arrayList10 = arrayList6;
                                                        arrayList12 = arrayList7;
                                                        arrayList13 = arrayList5;
                                                        arrayList14 = arrayList;
                                                    }
                                                    if (arrayList14 != null) {
                                                        arrayList14.add(mapObj2);
                                                    }
                                                }
                                                arrayList12 = arrayList7;
                                                arrayList13 = arrayList5;
                                            }
                                        }
                                        str = GetNearlyObjID;
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO_Z)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_BID)) {
                                        }
                                        if (jSONObject3.has("ts")) {
                                        }
                                        if (jSONObject3.has("obj")) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                        }
                                        mapObj2.nType = i8;
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                                        }
                                        if (jSONObject3.has("ud")) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.STREET_TYPE)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                                        }
                                        if (jSONObject3.has("x")) {
                                        }
                                        if (jSONObject3.has("y")) {
                                        }
                                        if (jSONObject3.has("z")) {
                                        }
                                        if (jSONObject3.has("rotation")) {
                                        }
                                        if (jSONObject3.has("pid")) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                        }
                                        if (!jSONObject3.has("src")) {
                                        }
                                        if (!jSONObject3.has("ad")) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                        }
                                        if (!jSONObject3.has("puid")) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_SRC)) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_STGE)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_ISAGG)) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                        }
                                        if (!jSONObject3.has("url")) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STYLE_ID)) {
                                        }
                                        if (!jSONObject3.has("level")) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.CLICK_ACTION)) {
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.EX_JSON)) {
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE)) {
                                        }
                                        if (i6 != 22) {
                                        }
                                        arrayList12 = arrayList7;
                                        arrayList13 = arrayList5;
                                    }
                                    i4++;
                                    arrayList6 = arrayList10;
                                    arrayList7 = arrayList12;
                                    arrayList4 = arrayList9;
                                    arrayList5 = arrayList13;
                                    arrayList = arrayList14;
                                    GetNearlyObjID = str;
                                    jSONArray2 = jSONArray;
                                    str3 = str2;
                                }
                                str = GetNearlyObjID;
                                arrayList8 = arrayList;
                                arrayList9 = arrayList4;
                                arrayList10 = arrayList6;
                                arrayList11 = arrayList5;
                                int i10 = i7;
                                if (i6 != 1 && i6 != 2) {
                                    if (i6 != 3 && i6 != 4) {
                                        if (i6 == 6) {
                                            if (i6 != 8) {
                                                if (i6 != 25 && i6 != 31) {
                                                    if (i6 != 5000) {
                                                        if (i6 != 7000) {
                                                            if (i6 != 22) {
                                                                if (i6 != 23) {
                                                                    if (i6 != 103 && i6 != 104) {
                                                                        if (i6 != 6018 && i6 != 6019) {
                                                                            if (i6 != 6060 && i6 != 6061) {
                                                                                switch (i6) {
                                                                                    case 20:
                                                                                        if (getMapViewListener() != null) {
                                                                                            getMapViewListener().onClickedStreetPopup(str);
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                            }
                                                                            if (getMapViewListener() != null) {
                                                                                getMapViewListener().onClickedMapObj(arrayList15);
                                                                            }
                                                                        } else if (getMapViewListener() != null) {
                                                                            getMapViewListener().onClickedUniversalLayerPoiEventMapObj(arrayList8);
                                                                        }
                                                                    }
                                                                } else if (getMapViewListener() != null) {
                                                                    getMapViewListener().onClickedMapObj(arrayList15);
                                                                }
                                                            } else if (getMapViewListener() != null) {
                                                                getMapViewListener().onClickedItsMapObj(arrayList2);
                                                            }
                                                        } else if (getMapViewListener() != null) {
                                                            getMapViewListener().onClickedParticleEventMapObj(arrayList11);
                                                        }
                                                    } else if (getMapViewListener() != null) {
                                                        if (i10 == 27) {
                                                            getMapViewListener().onClickPolymericMapObj(arrayList8);
                                                        } else {
                                                            getMapViewListener().onClickedPoiObj(arrayList8);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (getMapViewListener() != null) {
                                            getMapViewListener().onClickedMapObj(arrayList10);
                                        }
                                        return true;
                                    }
                                    if (getMapViewListener() != null) {
                                        getMapViewListener().onClickedPoiObj(arrayList8);
                                    }
                                    return true;
                                }
                                if (getMapViewListener() != null) {
                                    getMapViewListener().onClickedRouteObj(arrayList9);
                                }
                                return true;
                            } else if (i6 == 24) {
                                arrayList7 = new ArrayList();
                                arrayList2 = null;
                                arrayList = null;
                                arrayList4 = null;
                                arrayList6 = null;
                                arrayList5 = null;
                                i4 = 0;
                                int i72 = -1;
                                while (i4 < jSONArray2.length()) {
                                }
                                str = GetNearlyObjID;
                                arrayList8 = arrayList;
                                arrayList9 = arrayList4;
                                arrayList10 = arrayList6;
                                arrayList11 = arrayList5;
                                int i102 = i72;
                                if (i6 != 1) {
                                    if (i6 != 3) {
                                        if (i6 == 6) {
                                        }
                                        return true;
                                    }
                                    if (getMapViewListener() != null) {
                                    }
                                    return true;
                                }
                                if (getMapViewListener() != null) {
                                }
                                return true;
                            } else if (i6 == 1239) {
                                arrayList3 = new ArrayList();
                                arrayList4 = arrayList3;
                                arrayList2 = null;
                                arrayList = null;
                                arrayList6 = null;
                                arrayList7 = null;
                                arrayList5 = null;
                                i4 = 0;
                                int i722 = -1;
                                while (i4 < jSONArray2.length()) {
                                }
                                str = GetNearlyObjID;
                                arrayList8 = arrayList;
                                arrayList9 = arrayList4;
                                arrayList10 = arrayList6;
                                arrayList11 = arrayList5;
                                int i1022 = i722;
                                if (i6 != 1) {
                                }
                                if (getMapViewListener() != null) {
                                }
                                return true;
                            } else if (i6 == 7000) {
                                arrayList5 = new ArrayList();
                                arrayList2 = null;
                                arrayList = null;
                                arrayList4 = null;
                                arrayList6 = null;
                                arrayList7 = null;
                                i4 = 0;
                                int i7222 = -1;
                                while (i4 < jSONArray2.length()) {
                                }
                                str = GetNearlyObjID;
                                arrayList8 = arrayList;
                                arrayList9 = arrayList4;
                                arrayList10 = arrayList6;
                                arrayList11 = arrayList5;
                                int i10222 = i7222;
                                if (i6 != 1) {
                                }
                                if (getMapViewListener() != null) {
                                }
                                return true;
                            } else {
                                arrayList2 = null;
                            }
                        }
                        arrayList3 = new ArrayList();
                        arrayList4 = arrayList3;
                        arrayList2 = null;
                        arrayList = null;
                        arrayList6 = null;
                        arrayList7 = null;
                        arrayList5 = null;
                        i4 = 0;
                        int i72222 = -1;
                        while (i4 < jSONArray2.length()) {
                        }
                        str = GetNearlyObjID;
                        arrayList8 = arrayList;
                        arrayList9 = arrayList4;
                        arrayList10 = arrayList6;
                        arrayList11 = arrayList5;
                        int i102222 = i72222;
                        if (i6 != 1) {
                        }
                        if (getMapViewListener() != null) {
                        }
                        return true;
                    }
                    arrayList = new ArrayList();
                    arrayList2 = null;
                    arrayList4 = null;
                    arrayList6 = null;
                    arrayList7 = null;
                    arrayList5 = null;
                    i4 = 0;
                    int i722222 = -1;
                    while (i4 < jSONArray2.length()) {
                    }
                    str = GetNearlyObjID;
                    arrayList8 = arrayList;
                    arrayList9 = arrayList4;
                    arrayList10 = arrayList6;
                    arrayList11 = arrayList5;
                    int i1022222 = i722222;
                    if (i6 != 1) {
                    }
                    if (getMapViewListener() != null) {
                    }
                    return true;
                }
                arrayList = null;
                arrayList4 = null;
                arrayList6 = null;
                arrayList7 = null;
                arrayList5 = null;
                i4 = 0;
                int i7222222 = -1;
                while (i4 < jSONArray2.length()) {
                }
                str = GetNearlyObjID;
                arrayList8 = arrayList;
                arrayList9 = arrayList4;
                arrayList10 = arrayList6;
                arrayList11 = arrayList5;
                int i10222222 = i7222222;
                if (i6 != 1) {
                }
                if (getMapViewListener() != null) {
                }
                return true;
            } catch (JSONException unused2) {
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    private boolean c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65552, this, i, i2)) == null) {
            SoftReference<MapViewInterface> softReference = this.i;
            if (softReference != null && softReference.get() != null) {
                int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
                MapViewInterface mapViewInterface = this.i.get();
                for (int size = mapViewInterface.getBmlayers().size() - 1; size >= 0; size--) {
                    if (mapViewInterface.getBmlayers().get(size).a(i, i2, zoomUnitsInMeter)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void procGestureForLog(boolean z2, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048678, this, z2, point) == null) {
            if (!this.G.a) {
                MapStatus mapStatus = getMapStatus();
                a aVar = this.G;
                aVar.a = true;
                aVar.b = mapStatus.level;
                aVar.c = new GeoPoint(mapStatus.centerPtX, mapStatus.centerPtY);
                this.G.d = new Point(0, 0);
            }
            if (z2) {
                int abs = Math.abs(point.getIntX());
                int abs2 = Math.abs(point.getIntY());
                Point point2 = this.G.d;
                point2.setIntX(point2.getIntX() + abs);
                Point point3 = this.G.d;
                point3.setIntY(point3.getIntY() + abs2);
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            MessageProxy.registerMessageHandler(4000, this.v);
            MessageProxy.registerMessageHandler(519, this.v);
            MessageProxy.registerMessageHandler(39, this.v);
            MessageProxy.registerMessageHandler(512, this.v);
            MessageProxy.registerMessageHandler(65297, this.v);
            MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.v);
            MessageProxy.registerMessageHandler(50, this.v);
            MessageProxy.registerMessageHandler(51, this.v);
            MessageProxy.registerMessageHandler(65301, this.v);
            MessageProxy.registerMessageHandler(41, this.v);
            MessageProxy.registerMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.v);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            MessageProxy.unRegisterMessageHandler(4000, this.v);
            MessageProxy.unRegisterMessageHandler(519, this.v);
            MessageProxy.unRegisterMessageHandler(39, this.v);
            MessageProxy.unRegisterMessageHandler(512, this.v);
            MessageProxy.unRegisterMessageHandler(65297, this.v);
            MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.v);
            MessageProxy.unRegisterMessageHandler(50, this.v);
            MessageProxy.unRegisterMessageHandler(51, this.v);
            MessageProxy.unRegisterMessageHandler(65301, this.v);
            MessageProxy.unRegisterMessageHandler(41, this.v);
            MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.v);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041 A[LOOP:0: B:20:0x0041->B:26:0x005c, LOOP_START, PHI: r1 
      PHI: (r1v4 int) = (r1v1 int), (r1v5 int) binds: [B:19:0x003f, B:26:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(int i, int i2) {
        InterceptResult invokeII;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65556, this, i, i2)) == null) {
            int i3 = 0;
            if (!b()) {
                return false;
            }
            String GetNearlyObjID = this.t.GetNearlyObjID(-1L, i, i2, this.nearlyRadius);
            JSONObject jSONObject2 = null;
            if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                try {
                    jSONObject = new JSONObject(GetNearlyObjID);
                    try {
                        jSONObject.put("px", i);
                        jSONObject.put(Config.PY, i2);
                    } catch (JSONException e) {
                        e = e;
                        jSONObject2 = jSONObject;
                        e.printStackTrace();
                        jSONObject = jSONObject2;
                        if (this.mListeners == null) {
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                }
                if (this.mListeners == null) {
                    while (i3 < this.mListeners.size()) {
                        al alVar = this.mListeners.get(i3);
                        if (jSONObject != null && alVar != null) {
                            alVar.a(jSONObject.toString());
                        }
                        i3++;
                    }
                    return true;
                }
                return true;
            } else if (this.mListeners != null) {
                if (getMapView() == null || getMapView().getProjection() == null) {
                    return false;
                }
                GeoPoint fromPixels = getMapView().getProjection().fromPixels(i, i2);
                while (i3 < this.mListeners.size()) {
                    al alVar2 = this.mListeners.get(i3);
                    if (alVar2 != null) {
                        alVar2.a(fromPixels);
                    }
                    i3++;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0260 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0272 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x027c A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0286 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028f A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0299 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a2 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ad A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b9 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c6 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02d0 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02da A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e3 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ee A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f8 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0302 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x030b A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0199 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a5 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b3 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01db A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e9 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f7 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020e A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0225 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0234 A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024f A[Catch: JSONException -> 0x0337, TryCatch #0 {JSONException -> 0x0337, blocks: (B:15:0x006f, B:17:0x0089, B:18:0x008f, B:136:0x0312, B:28:0x00c0, B:31:0x00dd, B:35:0x00ee, B:37:0x00f9, B:39:0x0108, B:44:0x011f, B:46:0x0125, B:53:0x0159, B:60:0x0187, B:62:0x018d, B:63:0x0193, B:65:0x0199, B:66:0x019f, B:68:0x01a5, B:69:0x01ab, B:71:0x01b3, B:72:0x01b9, B:74:0x01bf, B:75:0x01c5, B:77:0x01cd, B:78:0x01d3, B:80:0x01db, B:81:0x01e1, B:83:0x01e9, B:84:0x01ef, B:86:0x01f7, B:87:0x0206, B:89:0x020e, B:90:0x021d, B:92:0x0225, B:93:0x022b, B:95:0x0234, B:97:0x0246, B:99:0x024f, B:100:0x0258, B:102:0x0260, B:103:0x0268, B:105:0x0272, B:107:0x027e, B:109:0x0286, B:111:0x0291, B:113:0x0299, B:115:0x02a4, B:117:0x02ad, B:119:0x02bd, B:121:0x02c6, B:123:0x02d2, B:125:0x02da, B:127:0x02e5, B:129:0x02ee, B:131:0x02fa, B:133:0x0302, B:135:0x030d, B:134:0x030b, B:130:0x02f8, B:126:0x02e3, B:122:0x02d0, B:118:0x02b9, B:114:0x02a2, B:110:0x028f, B:106:0x027c, B:52:0x0150, B:49:0x013c, B:54:0x015d, B:56:0x016d, B:58:0x0173, B:40:0x010f, B:42:0x0115, B:43:0x011c, B:36:0x00f5, B:24:0x009f, B:137:0x032d, B:21:0x0097), top: B:147:0x006f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(int i, int i2) {
        InterceptResult invokeII;
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str;
        int i3;
        ArrayList arrayList;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        ArrayList arrayList2;
        double intX;
        double intY;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65560, this, i, i2)) == null) {
            String str16 = MapBundleKey.MapObjKey.OBJ_SS_POINAME;
            String str17 = MapBundleKey.MapObjKey.OBJ_GEO;
            String str18 = "index";
            String str19 = "in";
            String str20 = "ty";
            String str21 = "z";
            String str22 = "y";
            String str23 = "x";
            String str24 = "ud";
            boolean b2 = b();
            String str25 = MapBundleKey.MapObjKey.OBJ_DIS;
            if (!b2 || getMapViewListener() == null) {
                return false;
            }
            int i4 = this.nearlyRadius;
            String str26 = MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID;
            String GetNearlyObjID = this.t.GetNearlyObjID(-1L, i, i2, (int) (i4 * getZoomUnitsInMeter()));
            if (GetNearlyObjID == null) {
                return false;
            }
            new ArrayList();
            try {
                JSONArray jSONArray2 = new JSONObject(GetNearlyObjID).getJSONArray("dataset");
                if (((JSONObject) jSONArray2.get(0)).getInt("ty") == 7000) {
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (i5 < jSONArray2.length()) {
                        try {
                            jSONObject = (JSONObject) jSONArray2.get(i5);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            i3 = i5;
                            jSONArray = jSONArray2;
                            arrayList2 = arrayList3;
                            str4 = str17;
                            str5 = str18;
                            str6 = str19;
                            str = str20;
                            str13 = str21;
                            str12 = str22;
                            str10 = str25;
                            str9 = str24;
                        } else {
                            jSONArray = jSONArray2;
                            int i6 = jSONObject.getInt(str20);
                            str = str20;
                            if (i6 == 26) {
                                i3 = i5;
                                str9 = str24;
                                arrayList2 = arrayList3;
                                str4 = str17;
                                str5 = str18;
                                str6 = str19;
                                str13 = str21;
                                str12 = str22;
                                str10 = str25;
                            } else {
                                MapObj mapObj = new MapObj();
                                i3 = i5;
                                if (jSONObject.has(str24)) {
                                    arrayList = arrayList3;
                                    mapObj.strUid = jSONObject.getString(str24);
                                } else {
                                    arrayList = arrayList3;
                                    mapObj.strUid = "";
                                }
                                mapObj.strText = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                                if (jSONObject.has(str19)) {
                                    mapObj.nIndex = jSONObject.getInt(str19);
                                } else if (jSONObject.has(str18)) {
                                    mapObj.nIndex = jSONObject.getInt(str18);
                                } else {
                                    mapObj.nIndex = 0;
                                }
                                if (!jSONObject.has(str17)) {
                                    str2 = "";
                                    str3 = str24;
                                    str4 = str17;
                                    str5 = str18;
                                    str6 = str19;
                                    if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                                        str7 = str16;
                                        mapObj.geoPt.setTo((int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                                        if (jSONObject.has("ts")) {
                                            mapObj.sltime = jSONObject.getInt("ts");
                                        }
                                        if (jSONObject.has("obj")) {
                                            mapObj.slobj = jSONObject.getInt("obj");
                                        }
                                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                            mapObj.slvisi = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                                        }
                                        mapObj.nType = i6;
                                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                            mapObj.offset = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                                        }
                                        if (jSONObject.has(str7)) {
                                            mapObj.ssName = jSONObject.getString(str7);
                                        }
                                        str8 = str26;
                                        if (jSONObject.has(str8)) {
                                            mapObj.ssIndoorId = jSONObject.getString(str8);
                                        }
                                        str9 = str3;
                                        if (jSONObject.has(str9)) {
                                            mapObj.ssPoiUid = jSONObject.getString(str9);
                                        }
                                        str10 = str25;
                                        if (jSONObject.has(str10)) {
                                            mapObj.offset = jSONObject.getInt(str10);
                                        }
                                        str11 = str23;
                                        if (jSONObject.has(str11)) {
                                            mapObj.geoPt.setIntX(jSONObject.getInt(str11));
                                            mapObj.streetArrowCenterX = jSONObject.getDouble(str11);
                                        }
                                        str12 = str22;
                                        if (jSONObject.has(str12)) {
                                            mapObj.geoPt.setIntY(jSONObject.getInt(str12));
                                            mapObj.streetArrowCenterY = jSONObject.getDouble(str12);
                                        }
                                        str13 = str21;
                                        if (jSONObject.has(str13)) {
                                            mapObj.ssZ = jSONObject.getInt(str13);
                                        }
                                        if (!jSONObject.has("rotation")) {
                                            str26 = str8;
                                            str14 = str7;
                                            mapObj.ssRotation = jSONObject.getDouble("rotation");
                                        } else {
                                            str26 = str8;
                                            str14 = str7;
                                        }
                                        if (jSONObject.has("pid")) {
                                            mapObj.ssPanoId = jSONObject.getString("pid");
                                        }
                                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                            mapObj.ssData = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                                        }
                                        if (!jSONObject.has("src")) {
                                            mapObj.dynamicSrc = jSONObject.getInt("src");
                                        } else {
                                            mapObj.dynamicSrc = -1;
                                        }
                                        if (!jSONObject.has("ad")) {
                                            mapObj.ad = jSONObject.getInt("ad");
                                        } else {
                                            mapObj.ad = -1;
                                        }
                                        if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                            mapObj.adstyle = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                                        } else {
                                            mapObj.adstyle = -1;
                                        }
                                        if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                            mapObj.qid = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_QID);
                                            str15 = str2;
                                        } else {
                                            str15 = str2;
                                            mapObj.qid = str15;
                                        }
                                        if (!jSONObject.has("puid")) {
                                            mapObj.puid = jSONObject.getString("puid");
                                        } else {
                                            mapObj.puid = str15;
                                        }
                                        if (!jSONObject.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                            mapObj.adLog = jSONObject.getString(MapBundleKey.MapObjKey.AD_LOG);
                                        } else {
                                            mapObj.adLog = str15;
                                        }
                                        if (!jSONObject.has("url")) {
                                            mapObj.url = jSONObject.getString("url");
                                        } else {
                                            mapObj.url = str15;
                                        }
                                        if (!jSONObject.has("level")) {
                                            mapObj.level = jSONObject.getInt("level");
                                        } else {
                                            mapObj.level = -1;
                                        }
                                        arrayList2 = arrayList;
                                        arrayList2.add(mapObj);
                                        str24 = str9;
                                        str25 = str10;
                                        str23 = str11;
                                        str22 = str12;
                                        str16 = str14;
                                        str20 = str;
                                        str17 = str4;
                                        str19 = str6;
                                        jSONArray2 = jSONArray;
                                        arrayList3 = arrayList2;
                                        str21 = str13;
                                        str18 = str5;
                                        i5 = i3 + 1;
                                    }
                                } else {
                                    Point complexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject.getString(str17));
                                    str4 = str17;
                                    Point point = mapObj.geoPt;
                                    if (complexPtToPoint == null) {
                                        str5 = str18;
                                        str6 = str19;
                                        intX = 0.0d;
                                    } else {
                                        str5 = str18;
                                        str6 = str19;
                                        intX = complexPtToPoint.getIntX();
                                    }
                                    if (complexPtToPoint == null) {
                                        str2 = "";
                                        str3 = str24;
                                        intY = 0.0d;
                                    } else {
                                        str2 = "";
                                        str3 = str24;
                                        intY = complexPtToPoint.getIntY();
                                    }
                                    point.setTo(intX, intY);
                                }
                                str7 = str16;
                                if (jSONObject.has("ts")) {
                                }
                                if (jSONObject.has("obj")) {
                                }
                                if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                }
                                mapObj.nType = i6;
                                if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                }
                                if (jSONObject.has(str7)) {
                                }
                                str8 = str26;
                                if (jSONObject.has(str8)) {
                                }
                                str9 = str3;
                                if (jSONObject.has(str9)) {
                                }
                                str10 = str25;
                                if (jSONObject.has(str10)) {
                                }
                                str11 = str23;
                                if (jSONObject.has(str11)) {
                                }
                                str12 = str22;
                                if (jSONObject.has(str12)) {
                                }
                                str13 = str21;
                                if (jSONObject.has(str13)) {
                                }
                                if (!jSONObject.has("rotation")) {
                                }
                                if (jSONObject.has("pid")) {
                                }
                                if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                }
                                if (!jSONObject.has("src")) {
                                }
                                if (!jSONObject.has("ad")) {
                                }
                                if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                }
                                if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                }
                                if (!jSONObject.has("puid")) {
                                }
                                if (!jSONObject.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                }
                                if (!jSONObject.has("url")) {
                                }
                                if (!jSONObject.has("level")) {
                                }
                                arrayList2 = arrayList;
                                arrayList2.add(mapObj);
                                str24 = str9;
                                str25 = str10;
                                str23 = str11;
                                str22 = str12;
                                str16 = str14;
                                str20 = str;
                                str17 = str4;
                                str19 = str6;
                                jSONArray2 = jSONArray;
                                arrayList3 = arrayList2;
                                str21 = str13;
                                str18 = str5;
                                i5 = i3 + 1;
                            }
                        }
                        str14 = str16;
                        str11 = str23;
                        str24 = str9;
                        str25 = str10;
                        str23 = str11;
                        str22 = str12;
                        str16 = str14;
                        str20 = str;
                        str17 = str4;
                        str19 = str6;
                        jSONArray2 = jSONArray;
                        arrayList3 = arrayList2;
                        str21 = str13;
                        str18 = str5;
                        i5 = i3 + 1;
                    }
                    getMapViewListener().onClickedParticleEventMapObj(arrayList3);
                    return true;
                }
                return false;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    public int MapMsgProc(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3)) == null) {
            return MapMsgProc(i, i2, i3, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
        }
        return invokeIII.intValue;
    }

    public boolean forceSetMapThemeScene(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i, i2, bundle)) == null) {
            this.p = i;
            this.o = i2;
            if (!b()) {
                return false;
            }
            return this.t.setMapThemeScene(i, i2, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048629, this, bundle, i, i2)) == null) {
            if (!b()) {
                return 0.0f;
            }
            return this.t.GetZoomToBound(bundle, i, i2);
        }
        return invokeLII.floatValue;
    }

    public int MapMsgProc(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) {
            if (!b()) {
                return -1;
            }
            return MapProc(this.u, i, i2, i3, i4, i5, d, d2, d3, d4);
        }
        return invokeCommon.intValue;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048580, this, i, i2) != null) || !b()) {
            return;
        }
        this.t.MoveToScrPoint(i, i2);
    }

    public boolean createByDuplicateAppBaseMap(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            AppBaseMap appBaseMap = new AppBaseMap();
            this.t = appBaseMap;
            if (appBaseMap.CreateByDuplicate(j)) {
                this.aa = true;
                this.u = this.t.GetId();
                List<AppBaseMap> list = W;
                if (list != null) {
                    list.add(this.t);
                }
                return true;
            }
            this.t = null;
            this.u = 0L;
            return false;
        }
        return invokeJ.booleanValue;
    }

    public Bundle getGestureOptInfoForLog() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Bundle bundle = null;
            if (!this.G.a) {
                return null;
            }
            MapStatus mapStatus = getMapStatus();
            int intX = this.G.d.getIntX();
            int intY = this.G.d.getIntY();
            boolean z3 = true;
            if (Math.sqrt((intX * intX) + (intY * intY)) > 100.0d) {
                z2 = true;
            } else {
                z2 = false;
            }
            float f = this.G.b;
            z3 = (f <= 0.0f || ((double) Math.abs(mapStatus.level - f)) < 0.5d) ? false : false;
            if (z2 || z3) {
                bundle = new Bundle();
                bundle.putDouble("pre_x", this.G.c.getLongitude());
                bundle.putDouble("pre_y", this.G.c.getLatitude());
                bundle.putFloat("pre_level", this.G.b);
            }
            this.G.a();
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public boolean getMapBarData() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!b()) {
                return false;
            }
            Bundle bundle = new Bundle();
            this.t.getMapBarData(bundle);
            byte[] bArr = new byte[0];
            String str3 = null;
            if (bundle.containsKey("uid")) {
                str = bundle.getString("uid");
            } else {
                str = null;
            }
            if (bundle.containsKey("searchbound")) {
                str2 = bundle.getString("searchbound");
            } else {
                str2 = null;
            }
            if (bundle.containsKey("curfloor")) {
                str3 = bundle.getString("curfloor");
            }
            if (bundle.containsKey("barinfo")) {
                bArr = bundle.getByteArray("barinfo");
            }
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b(str, str2, str3, bArr));
            return true;
        }
        return invokeV.booleanValue;
    }

    public void handleDoubleClickZoom(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, motionEvent) != null) || System.currentTimeMillis() - this.O < 100) {
            return;
        }
        mapStatusChangeStart();
        this.mIsAnimating = true;
        float y2 = motionEvent.getY();
        float f = this.M - y2;
        MapMsgProc(8193, 3, (int) ((f / (getScreenHeight() / 9.0f)) * 10000.0f));
        this.N = f;
        this.M = y2;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        if (isNaviMode() && getNaviMapViewListener() != null) {
            getNaviMapViewListener().onAction(521, null);
        }
    }

    public void handleStreetscapeDoubleTouch(MotionEvent motionEvent) {
        SoftReference<MapViewInterface> softReference;
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, motionEvent) == null) && (softReference = this.i) != null && softReference.get() != null && this.i.get().getProjection() != null) {
            MapStatus mapStatus = getMapStatus();
            Projection projection = this.i.get().getProjection();
            MapStatus.WinRound winRound = mapStatus.winRound;
            GeoPoint fromPixels = projection.fromPixels(winRound.left + (this.w / 2), winRound.top + (this.x / 2));
            float f2 = 0.0f;
            if (fromPixels != null) {
                f2 = (float) fromPixels.getLongitudeE6();
                f = (float) fromPixels.getLatitudeE6();
            } else {
                f = 0.0f;
            }
            MapMsgProc(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.x / 2) << 16) | (this.w / 2), 0, 0, f2, f, 0.0d, 0.0d);
        }
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, motionEvent)) == null) {
            if (!b()) {
                return false;
            }
            if (!this.D) {
                this.ab.a(motionEvent);
            }
            if (motionEvent.getPointerCount() == 2) {
                this.m = true;
                y = false;
                c();
                procGestureForLog(false, null);
            }
            if (motionEvent.getAction() != 2 && this.I) {
                this.m = true;
                c();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return false;
                    }
                    if (this.I) {
                        handleDoubleClickZoom(motionEvent);
                    } else if (this.V) {
                        handleTouchMove(motionEvent);
                    }
                } else {
                    y = true;
                    this.m = true;
                    handleTouchUp(motionEvent);
                }
            } else {
                this.m = true;
                a(motionEvent);
            }
            if (this.mListeners != null) {
                for (int i = 0; i < this.mListeners.size(); i++) {
                    al alVar = this.mListeners.get(i);
                    if (alVar != null) {
                        alVar.a(motionEvent);
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean handleTouchSingleClick(MotionEvent motionEvent) {
        InterceptResult invokeL;
        NaviMapViewListener naviMapViewListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            d(x, y2);
            if (e(x, y2) || handlePopupClick(x, y2) || c(x, y2) || a(1, x, y2)) {
                return true;
            }
            if (this.C && b(x, y2)) {
                return true;
            }
            if (isNaviMode() && (naviMapViewListener = this.j) != null) {
                naviMapViewListener.onAction(514, motionEvent);
            }
            if (getMapViewListener() != null) {
                getMapViewListener().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (!y || !this.V || !this.n) {
                return false;
            }
            float sqrt = (float) ((((float) Math.sqrt((f * f) + (f2 * f2))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f)) * 1.3d);
            if (getMapControlMode() != MapControlMode.STREET && sqrt < 300.0f) {
                this.D = false;
                return false;
            }
            this.D = true;
            if (this.mListeners != null) {
                com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = getMapStatusInner();
                for (int i = 0; i < this.mListeners.size(); i++) {
                    al alVar = this.mListeners.get(i);
                    if (alVar != null && alVar.a(motionEvent2, f, f2, mapStatusInner)) {
                        this.Y = false;
                        return false;
                    }
                }
            }
            getGestureMonitor().a();
            mapStatusChangeStart();
            MapMsgProc(34, (int) sqrt, (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
            if (getMapViewListener() != null) {
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.c());
            }
            this.Y = false;
            if (this.mListeners != null) {
                for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                    al alVar2 = this.mListeners.get(i2);
                    if (alVar2 != null) {
                        alVar2.a(motionEvent2);
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean handleTouchUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (x < 0) {
                x = 0;
            }
            if (y2 < 0) {
                y2 = 0;
            }
            if (this.mHasMapObjDraging) {
                if (this.mListeners != null && getMapView() != null && getMapView().getProjection() != null) {
                    GeoPoint fromPixels = getMapView().getProjection().fromPixels(x, y2);
                    for (int i = 0; i < this.mListeners.size(); i++) {
                        al alVar = this.mListeners.get(i);
                        if (alVar != null && fromPixels != null) {
                            alVar.e(fromPixels);
                        }
                    }
                }
                this.mHasMapObjDraging = false;
                return true;
            }
            if (y) {
                MapMsgProc(5, 0, x | (y2 << 16));
            }
            if (!this.D && getMapViewListener() != null) {
                getMapViewListener().onMapAnimationFinish();
            }
            if (!this.D && isNaviMode() && getNaviMapViewListener() != null) {
                getNaviMapViewListener().onMapAnimationFinish();
            }
            if (motionEvent.getEventTime() - this.X < 300 && Math.abs(motionEvent.getX() - z) < 10.0f && Math.abs(motionEvent.getY() - A) < 10.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!this.D && ((!z2 || this.Y) && !this.P && !this.Q && !this.mIsAnimating && this.mListeners != null)) {
                com.baidu.mapsdkplatform.comapi.map.x mapStatusInner = getMapStatusInner();
                for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                    al alVar2 = this.mListeners.get(i2);
                    if (alVar2 != null) {
                        alVar2.c(mapStatusInner);
                    }
                }
                this.mIsMoving = false;
            }
            this.Y = false;
            this.D = false;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.b(true, false));
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setMapStatus(MapStatus mapStatus) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048707, this, mapStatus) == null) && b() && mapStatus != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putInt("left", mapStatus.winRound.left);
            bundle.putInt("right", mapStatus.winRound.right);
            bundle.putInt("top", mapStatus.winRound.top);
            bundle.putInt("bottom", mapStatus.winRound.bottom);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putInt("animatime", mapStatus.animationTime);
            bundle.putInt("animation", mapStatus.hasAnimation);
            bundle.putInt("animationType", mapStatus.animationType);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            mapStatusChangeStart();
            this.t.SetMapStatus(bundle);
        }
    }

    public boolean handleTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, motionEvent)) == null) {
            if (!b()) {
                return false;
            }
            if (motionEvent.getAction() == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (rawX > 0.0f) {
                    i = 18;
                } else if (rawX < 0.0f) {
                    i = 16;
                } else {
                    i = 0;
                }
                if (rawY > 0.0f) {
                    i = 19;
                } else if (rawY < 0.0f) {
                    i = 17;
                }
                if (i == 0) {
                    return false;
                }
                MapMsgProc(1, i, 0);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void initMapResources(Bundle bundle) {
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048652, this, bundle) == null) && !this.E && bundle != null && this.t != null) {
            if (SysOSUtil.getInstance().getDensityDPI() >= 180) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
            String string = bundle.getString("modulePath");
            String string2 = bundle.getString("appSdcardPath");
            String string3 = bundle.getString("appCachePath");
            String string4 = bundle.getString("appSecondCachePath");
            String string5 = bundle.getString("engineErrorPath");
            int i = bundle.getInt("mapTmpMax");
            int i2 = bundle.getInt("domTmpMax");
            int i3 = bundle.getInt("itsTmpMax");
            int i4 = bundle.getInt("ssgTmpMax");
            if (z2) {
                str = "/h/";
            } else {
                str = "/l/";
            }
            String str2 = string + "/cfg";
            String str3 = string2 + "/vmp";
            String str4 = str2 + "/a/";
            String str5 = str3 + str;
            String str6 = str3 + str;
            String str7 = string3 + "/tmp/";
            String str8 = string4 + "/tmp/";
            Bundle bundle2 = new Bundle();
            bundle2.putString("cfgdataroot", str4);
            bundle2.putString("vmpdataroot", str5);
            bundle2.putString("tmpdataroot", str7);
            bundle2.putString("tmpdatapast", str8);
            bundle2.putString("importroot", str6);
            bundle2.putString("stylerespath", str2 + "/a/");
            if (string5 != null && string5.length() > 0) {
                bundle2.putString("engineerrorpath", string5);
            }
            bundle2.putInt("cx", this.w);
            bundle2.putInt("cy", this.x);
            bundle2.putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
            bundle2.putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
            bundle2.putInt("maptmpmax", i);
            bundle2.putInt("domtmpmax", i2);
            bundle2.putInt("itstmpmax", i3);
            bundle2.putInt("ssgtmpmax", i4);
            bundle2.putInt("pathchange", 0);
            if (bundle.containsKey("maptheme")) {
                bundle2.putInt("maptheme", bundle.getInt("maptheme"));
            }
            if (bundle.containsKey("mapscene")) {
                bundle2.putInt("mapscene", bundle.getInt("mapscene"));
            }
            if (bundle.containsKey("fontsizelevel")) {
                bundle2.putInt("fontsizelevel", bundle.getInt("fontsizelevel"));
            }
            if (!com.baidu.platform.comapi.b.f()) {
                com.baidu.platform.comapi.b.e();
            }
            if (!this.t.initWithOptions(bundle2, false)) {
                Log.e(k, "MapControl init fail!");
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("MapControl init fail");
                    return;
                }
                return;
            }
            this.t.SetMapStatus(bundle);
            this.E = true;
        }
    }

    public boolean isInFocusBarBorder(GeoPoint geoPoint, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048663, this, new Object[]{geoPoint, Double.valueOf(d)})) == null) {
            if (!b() || geoPoint == null || !this.t.IsPointInFocusBarBorder(geoPoint.getLongitude(), geoPoint.getLatitude(), d)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void saveScreenToLocal(String str, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && b() && !TextUtils.isEmpty(str)) {
            String str2 = null;
            if (i3 != 0 && i4 != 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("x", i);
                    jSONObject.put("y", i2);
                    jSONObject.put("width", i3);
                    jSONObject.put("height", i4);
                    str2 = jSONObject.toString();
                } catch (Exception unused) {
                }
            }
            this.t.SaveScreenToLocal(str, str2);
        }
    }

    public void setMapStatus(MapStatus mapStatus, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048708, this, mapStatus, z2) == null) && b() && mapStatus != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putInt("left", mapStatus.winRound.left);
            bundle.putInt("right", mapStatus.winRound.right);
            bundle.putInt("top", mapStatus.winRound.top);
            bundle.putInt("bottom", mapStatus.winRound.bottom);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putInt("animation", 0);
            bundle.putInt("animatime", 0);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", z2 ? 1 : 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            this.t.SetMapStatus(bundle);
        }
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048709, this, mapStatus, i) == null) && b() && this.t != null && mapStatus != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putInt("left", mapStatus.winRound.left);
            bundle.putInt("right", mapStatus.winRound.right);
            bundle.putInt("top", mapStatus.winRound.top);
            bundle.putInt("bottom", mapStatus.winRound.bottom);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putInt("animation", 1);
            bundle.putInt("animatime", i);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            mapStatusChangeStart();
            this.mIsAnimating = true;
            this.t.SetMapStatus(bundle);
        }
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048711, this, new Object[]{mapStatus, Integer.valueOf(i), Boolean.valueOf(z2)}) == null) && b() && this.t != null && mapStatus != null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble("rotation", mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putInt("left", mapStatus.winRound.left);
            bundle.putInt("right", mapStatus.winRound.right);
            bundle.putInt("top", mapStatus.winRound.top);
            bundle.putInt("bottom", mapStatus.winRound.bottom);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putInt("animation", 1);
            bundle.putInt("animatime", i);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", z2 ? 1 : 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            this.t.SetMapStatus(bundle);
        }
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048713, this, i, i2, bundle)) == null) {
            if (!b()) {
                return false;
            }
            if (this.t.getMapTheme() == i && this.t.getMapScene() == i2) {
                return true;
            }
            this.p = i;
            this.o = i2;
            return this.t.setMapThemeScene(i, i2, bundle);
        }
        return invokeIIL.booleanValue;
    }
}
