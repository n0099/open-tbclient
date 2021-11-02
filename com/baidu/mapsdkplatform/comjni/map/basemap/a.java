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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f40428a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static Set<Integer> f40429d;

    /* renamed from: e  reason: collision with root package name */
    public static List<JNIBaseMap> f40430e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f40431b;

    /* renamed from: c  reason: collision with root package name */
    public JNIBaseMap f40432c;

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
        f40429d = new HashSet();
        f40430e = new ArrayList();
    }

    public a() {
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
        this.f40431b = 0L;
        this.f40432c = null;
        this.f40432c = new JNIBaseMap();
    }

    public static int a(long j, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? JNIBaseMap.MapProc(j, i2, i3, i4) : invokeCommon.intValue;
    }

    public static List<JNIBaseMap> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f40430e : (List) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40431b : invokeV.longValue;
    }

    public long a(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str)) == null) ? this.f40432c.AddLayer(this.f40431b, i2, i3, str) : invokeIIL.longValue;
    }

    public String a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? this.f40432c.ScrPtToGeoPoint(this.f40431b, i2, i3) : (String) invokeII.objValue;
    }

    public String a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i2, i3, i4, i5)) == null) ? this.f40432c.GetNearlyObjID(this.f40431b, i2, i3, i4, i5) : (String) invokeIIII.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f40432c.OnSchcityGet(this.f40431b, str) : (String) invokeL.objValue;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)}) == null) {
            this.f40432c.setCustomTrafficColor(this.f40431b, j, j2, j3, j4, z);
        }
    }

    public void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f40432c.ShowLayers(this.f40431b, j, z);
        }
    }

    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.f40432c.SetMapStatus(this.f40431b, bundle);
        }
    }

    public void a(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
            this.f40432c.SaveScreenToLocal(this.f40431b, str, bundle);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f40432c.ShowSatelliteMap(this.f40431b, z);
        }
    }

    public void a(Bundle[] bundleArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundleArr) == null) {
            this.f40432c.addOverlayItems(this.f40431b, bundleArr, bundleArr.length);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            this.f40431b = f40430e.size() == 0 ? this.f40432c.Create() : this.f40432c.CreateDuplicate(f40430e.get(0).f40427a);
            JNIBaseMap jNIBaseMap = this.f40432c;
            jNIBaseMap.f40427a = this.f40431b;
            f40430e.add(jNIBaseMap);
            f40429d.add(Integer.valueOf(i2));
            this.f40432c.SetCallback(this.f40431b, null);
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.f40432c.OnRecordReload(this.f40431b, i2, z) : invokeCommon.booleanValue;
    }

    public boolean a(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) ? this.f40432c.OnRecordStart(this.f40431b, i2, z, i3) : invokeCommon.booleanValue;
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) ? this.f40432c.LayersIsShow(this.f40431b, j) : invokeJ.booleanValue;
    }

    public boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? this.f40432c.SwitchLayer(this.f40431b, j, j2) : invokeCommon.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? this.f40432c.SwitchBaseIndoorMapFloor(this.f40431b, str, str2) : invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i2), str8, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)})) == null) ? this.f40432c.Init(this.f40431b, str, str2, str3, str4, str5, str6, str7, i2, str8, i3, i4, i5, i6, i7, i8, i9) : invokeCommon.booleanValue;
    }

    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f40432c.OnRecordImport(this.f40431b, z, z2) : invokeCommon.booleanValue;
    }

    public int[] a(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, iArr, i2, i3)) == null) ? this.f40432c.GetScreenBuf(this.f40431b, iArr, i2, i3) : (int[]) invokeLII.objValue;
    }

    public String b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? this.f40432c.GeoPtToScrPoint(this.f40431b, i2, i3) : (String) invokeII.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.f40432c.UpdateLayers(this.f40431b, j);
        }
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            this.f40432c.setMapStatusLimits(this.f40431b, bundle);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f40432c.ShowHotMap(this.f40431b, z);
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.f40432c.Release(this.f40431b);
            f40430e.remove(this.f40432c);
            f40429d.remove(Integer.valueOf(i2));
            this.f40431b = 0L;
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean b(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.f40432c.OnRecordRemove(this.f40431b, i2, z) : invokeCommon.booleanValue;
    }

    public boolean b(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) ? this.f40432c.OnRecordSuspend(this.f40431b, i2, z, i3) : invokeCommon.booleanValue;
    }

    public float c(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bundle)) == null) ? this.f40432c.GetZoomToBound(this.f40431b, bundle) : invokeL.floatValue;
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.f40432c.SetMapControlMode(this.f40431b, i2) : invokeI.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f40432c.OnPause(this.f40431b);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f40432c.ShowTrafficMap(this.f40431b, z);
        }
    }

    public boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048607, this, j)) == null) ? this.f40432c.cleanSDKTileDataCache(this.f40431b, j) : invokeJ.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f40432c.OnResume(this.f40431b);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.f40432c.ClearLayer(this.f40431b, j);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f40432c.enableDrawHouseHeight(this.f40431b, z);
        }
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? this.f40432c.OnRecordAdd(this.f40431b, i2) : invokeI.booleanValue;
    }

    public boolean d(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) ? this.f40432c.updateSDKTile(this.f40431b, bundle) : invokeL.booleanValue;
    }

    public String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? this.f40432c.OnRecordGetAt(this.f40431b, i2) : (String) invokeI.objValue;
    }

    public String e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048614, this, j)) == null) ? this.f40432c.getCompassPosition(this.f40431b, j) : (String) invokeJ.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f40432c.OnBackground(this.f40431b);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f40432c.ShowBaseIndoorMap(this.f40431b, z);
        }
    }

    public boolean e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bundle)) == null) ? this.f40432c.addtileOverlay(this.f40431b, bundle) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f40432c.OnForeground(this.f40431b);
        }
    }

    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            this.f40432c.addOneOverlayItem(this.f40431b, bundle);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f40432c.ResetImageRes(this.f40431b);
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            this.f40432c.updateOneOverlayItem(this.f40431b, bundle);
        }
    }

    public Bundle h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f40432c.GetMapStatus(this.f40431b) : (Bundle) invokeV.objValue;
    }

    public void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            this.f40432c.removeOneOverlayItem(this.f40431b, bundle);
        }
    }

    public Bundle i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f40432c.getMapStatusLimits(this.f40431b) : (Bundle) invokeV.objValue;
    }

    public Bundle j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f40432c.getDrawingMapStatus(this.f40431b) : (Bundle) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f40432c.GetBaiduHotMapCityInfo(this.f40431b) : invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f40432c.OnRecordGetAll(this.f40431b) : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f40432c.OnHotcityGet(this.f40431b) : (String) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.f40432c.PostStatInfo(this.f40431b);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f40432c.isDrawHouseHeightEnable(this.f40431b) : invokeV.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.f40432c.clearHeatMapLayerCache(this.f40431b);
        }
    }

    public MapBaseIndoorMapInfo q() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            String str = this.f40432c.getfocusedBaseIndoorMapInfo(this.f40431b);
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
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(optJSONArray.get(i2).toString());
            }
            return new MapBaseIndoorMapInfo(str2, str3, arrayList);
        }
        return (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f40432c.IsBaseIndoorMapMode(this.f40431b) : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f40432c.setBackgroundTransparent(this.f40431b);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.f40432c.resetBackgroundTransparent(this.f40431b);
        }
    }

    public float[] u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            JNIBaseMap jNIBaseMap = this.f40432c;
            if (jNIBaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            jNIBaseMap.getProjectionMatrix(this.f40431b, fArr, 16);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public float[] v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            JNIBaseMap jNIBaseMap = this.f40432c;
            if (jNIBaseMap == null) {
                return null;
            }
            float[] fArr = new float[16];
            jNIBaseMap.getViewMatrix(this.f40431b, fArr, 16);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }
}
