package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f26923d;

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f26924e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f26925b;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f26926c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2024252052, "Lcom/baidu/mapsdkplatform/comjni/map/basemap/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2024252052, "Lcom/baidu/mapsdkplatform/comjni/map/basemap/a;");
                return;
            }
        }
        f26923d = new HashSet();
        f26924e = new ArrayList();
    }

    public a() {
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
        this.f26925b = 0L;
        this.f26926c = null;
        this.f26926c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? JNIBaseMap.MapProc(j, i, i2, i3) : invokeCommon.intValue;
    }

    public static List<JNIBaseMap> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f26924e : (List) invokeV.objValue;
    }

    public static void b(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            JNIBaseMap.SetMapCustomEnable(j, z);
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26925b : invokeV.longValue;
    }

    public long a(int i, int i2, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str)) == null) ? this.f26926c.AddLayer(this.f26925b, i, i2, str) : invokeIIL.longValue;
    }

    public String a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? this.f26926c.ScrPtToGeoPoint(this.f26925b, i, i2) : (String) invokeII.objValue;
    }

    public String a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) ? this.f26926c.GetNearlyObjID(this.f26925b, i, i2, i3, i4) : (String) invokeIIII.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f26926c.OnSchcityGet(this.f26925b, str) : (String) invokeL.objValue;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)}) == null) {
            this.f26926c.setCustomTrafficColor(this.f26925b, j, j2, j3, j4, z);
        }
    }

    public void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f26926c.ShowLayers(this.f26925b, j, z);
        }
    }

    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.f26926c.SetMapStatus(this.f26925b, bundle);
        }
    }

    public void a(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
            this.f26926c.SaveScreenToLocal(this.f26925b, str, bundle);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f26926c.ShowSatelliteMap(this.f26925b, z);
        }
    }

    public void a(Bundle[] bundleArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundleArr) == null) {
            this.f26926c.addOverlayItems(this.f26925b, bundleArr, bundleArr.length);
        }
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.f26925b = f26924e.size() == 0 ? this.f26926c.Create() : this.f26926c.CreateDuplicate(f26924e.get(0).a);
            JNIBaseMap jNIBaseMap = this.f26926c;
            jNIBaseMap.a = this.f26925b;
            f26924e.add(jNIBaseMap);
            f26923d.add(Integer.valueOf(i));
            this.f26926c.SetCallback(this.f26925b, null);
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? this.f26926c.OnRecordReload(this.f26925b, i, z) : invokeCommon.booleanValue;
    }

    public boolean a(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? this.f26926c.OnRecordStart(this.f26925b, i, z, i2) : invokeCommon.booleanValue;
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) ? this.f26926c.LayersIsShow(this.f26925b, j) : invokeJ.booleanValue;
    }

    public boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? this.f26926c.SwitchLayer(this.f26925b, j, j2) : invokeCommon.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? this.f26926c.SwitchBaseIndoorMapFloor(this.f26925b, str, str2) : invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)})) == null) ? this.f26926c.Init(this.f26925b, str, str2, str3, str4, str5, str6, str7, i, str8, i2, i3, i4, i5, i6, i7, i8) : invokeCommon.booleanValue;
    }

    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f26926c.OnRecordImport(this.f26925b, z, z2) : invokeCommon.booleanValue;
    }

    public int[] a(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, iArr, i, i2)) == null) ? this.f26926c.GetScreenBuf(this.f26925b, iArr, i, i2) : (int[]) invokeLII.objValue;
    }

    public String b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) ? this.f26926c.GeoPtToScrPoint(this.f26925b, i, i2) : (String) invokeII.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.f26926c.UpdateLayers(this.f26925b, j);
        }
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            this.f26926c.setMapStatusLimits(this.f26925b, bundle);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f26926c.ShowHotMap(this.f26925b, z);
        }
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            this.f26926c.Release(this.f26925b);
            f26924e.remove(this.f26926c);
            f26923d.remove(Integer.valueOf(i));
            this.f26925b = 0L;
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean b(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? this.f26926c.OnRecordRemove(this.f26925b, i, z) : invokeCommon.booleanValue;
    }

    public boolean b(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? this.f26926c.OnRecordSuspend(this.f26925b, i, z, i2) : invokeCommon.booleanValue;
    }

    public float c(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bundle)) == null) ? this.f26926c.GetZoomToBound(this.f26925b, bundle) : invokeL.floatValue;
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) ? this.f26926c.SetMapControlMode(this.f26925b, i) : invokeI.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f26926c.OnPause(this.f26925b);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f26926c.ShowTrafficMap(this.f26925b, z);
        }
    }

    public boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048607, this, j)) == null) ? this.f26926c.cleanSDKTileDataCache(this.f26925b, j) : invokeJ.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f26926c.OnResume(this.f26925b);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.f26926c.ClearLayer(this.f26925b, j);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f26926c.enableDrawHouseHeight(this.f26925b, z);
        }
    }

    public boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? this.f26926c.OnRecordAdd(this.f26925b, i) : invokeI.booleanValue;
    }

    public boolean d(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) ? this.f26926c.updateSDKTile(this.f26925b, bundle) : invokeL.booleanValue;
    }

    public String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) ? this.f26926c.OnRecordGetAt(this.f26925b, i) : (String) invokeI.objValue;
    }

    public String e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048614, this, j)) == null) ? this.f26926c.getCompassPosition(this.f26925b, j) : (String) invokeJ.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f26926c.OnBackground(this.f26925b);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f26926c.ShowBaseIndoorMap(this.f26925b, z);
        }
    }

    public boolean e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bundle)) == null) ? this.f26926c.addtileOverlay(this.f26925b, bundle) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f26926c.OnForeground(this.f26925b);
        }
    }

    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            this.f26926c.addOneOverlayItem(this.f26925b, bundle);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f26926c.ResetImageRes(this.f26925b);
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            this.f26926c.updateOneOverlayItem(this.f26925b, bundle);
        }
    }

    public Bundle h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f26926c.GetMapStatus(this.f26925b) : (Bundle) invokeV.objValue;
    }

    public void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            this.f26926c.removeOneOverlayItem(this.f26925b, bundle);
        }
    }

    public Bundle i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f26926c.getMapStatusLimits(this.f26925b) : (Bundle) invokeV.objValue;
    }

    public Bundle j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f26926c.getDrawingMapStatus(this.f26925b) : (Bundle) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f26926c.GetBaiduHotMapCityInfo(this.f26925b) : invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f26926c.OnRecordGetAll(this.f26925b) : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f26926c.OnHotcityGet(this.f26925b) : (String) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.f26926c.PostStatInfo(this.f26925b);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f26926c.isDrawHouseHeightEnable(this.f26925b) : invokeV.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.f26926c.clearHeatMapLayerCache(this.f26925b);
        }
    }

    public MapBaseIndoorMapInfo q() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            String str = this.f26926c.getfocusedBaseIndoorMapInfo(this.f26925b);
            if (str == null) {
                return null;
            }
            String str2 = "";
            String str3 = new String();
            ArrayList arrayList = new ArrayList(1);
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("focusindoorid");
                str3 = jSONObject.optString("curfloor");
                optJSONArray = jSONObject.optJSONArray("floorlist");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.get(i).toString());
            }
            return new MapBaseIndoorMapInfo(str2, str3, arrayList);
        }
        return (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f26926c.IsBaseIndoorMapMode(this.f26925b) : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f26926c.setBackgroundTransparent(this.f26925b);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.f26926c.resetBackgroundTransparent(this.f26925b);
        }
    }

    public float[] u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            JNIBaseMap jNIBaseMap = this.f26926c;
            if (jNIBaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            jNIBaseMap.getProjectionMatrix(this.f26925b, fArr, 16);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public float[] v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            JNIBaseMap jNIBaseMap = this.f26926c;
            if (jNIBaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            jNIBaseMap.getViewMatrix(this.f26925b, fArr, 16);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }
}
