package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "o";
    public static o c;
    public transient /* synthetic */ FieldHolder $fh;
    public AppBaseMap b;
    public t d;
    public Handler e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(724782437, "Lcom/baidu/mapsdkplatform/comapi/map/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(724782437, "Lcom/baidu/mapsdkplatform/comapi/map/o;");
        }
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                o oVar = new o();
                c = oVar;
                oVar.g();
            }
            return c;
        }
        return (o) invokeV.objValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            h();
            this.d = new t();
            p pVar = new p(this);
            this.e = pVar;
            MessageCenter.registMessage(65289, pVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageCenter.unregistMessage(65289, this.e);
            this.b.releaseFromOfflineMap();
            c = null;
        }
    }

    public void b(s sVar) {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) && (tVar = this.d) != null) {
            tVar.b(sVar);
        }
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap == null || i < 0) {
                return false;
            }
            return appBaseMap.OnRecordSuspend(i, false, 0);
        }
        return invokeI.booleanValue;
    }

    public boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.OnRecordSuspend(0, true, i);
        }
        return invokeI.booleanValue;
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap == null || i < 0) {
                return false;
            }
            return appBaseMap.OnRecordRemove(i, false);
        }
        return invokeI.booleanValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.b == null || i < 0) {
                return false;
            }
            if (i > 2000 && i != 2912 && i != 2911 && i != 9000) {
                return false;
            }
            return this.b.OnRecordReload(i, false);
        }
        return invokeI.booleanValue;
    }

    private void h() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
            AppBaseMap appBaseMap = new AppBaseMap();
            this.b = appBaseMap;
            appBaseMap.Create();
            String moduleFileName = SysOSUtil.getModuleFileName();
            String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
            String appCachePath = EnvironmentUtilities.getAppCachePath();
            String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
            int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
            int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
            int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
            int ssgTmpStgMax = EnvironmentUtilities.getSsgTmpStgMax();
            if (com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI() >= 180) {
                str = "/h/";
            } else {
                str = "/l/";
            }
            String str2 = moduleFileName + "/cfg";
            String str3 = appSDCardPath + "/vmp";
            String str4 = str2 + "/idrres/";
            String str5 = str3 + str;
            String str6 = str3 + str;
            String str7 = appCachePath + "/tmp/";
            this.b.Init(str2 + "/a/", str4, str5, str7, appSecondCachePath + "/tmp/", str6, str2 + "/a/", com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenWidth(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getScreenHeight(), com.baidu.platform.comapi.util.SysOSUtil.getInstance().getDensityDPI(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, ssgTmpStgMax, false, false);
            this.b.OnResume();
        }
    }

    public ArrayList<r> e() {
        InterceptResult invokeV;
        String OnRecordGetAll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap != null && (OnRecordGetAll = appBaseMap.OnRecordGetAll()) != null && !OnRecordGetAll.equals("")) {
                ArrayList<r> arrayList = new ArrayList<>();
                try {
                    JSONObject jSONObject = new JSONObject(OnRecordGetAll);
                    if (jSONObject.length() == 0) {
                        return null;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        r rVar = new r();
                        q qVar = new q();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        qVar.a = optJSONObject.optInt("id");
                        qVar.b = optJSONObject.optString("name");
                        qVar.c = optJSONObject.optString("pinyin");
                        qVar.h = optJSONObject.optInt("mapoldsize");
                        qVar.i = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                        qVar.l = optJSONObject.optInt("status");
                        qVar.g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                        boolean z = true;
                        if (optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE) != 1) {
                            z = false;
                        }
                        qVar.j = z;
                        qVar.e = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                        if (qVar.j) {
                            qVar.k = optJSONObject.optInt("mapsize");
                        } else {
                            qVar.k = 0;
                        }
                        rVar.a(qVar);
                        arrayList.add(rVar);
                    }
                    return arrayList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> a(String str) {
        InterceptResult invokeL;
        AppBaseMap appBaseMap;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!str.equals("") && (appBaseMap = this.b) != null) {
                String OnSchcityGet = appBaseMap.OnSchcityGet(str);
                if (OnSchcityGet == null || OnSchcityGet.equals("")) {
                    return null;
                }
                ArrayList<n> arrayList = new ArrayList<>();
                try {
                    JSONObject jSONObject = new JSONObject(OnSchcityGet);
                    if (jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray("dataset")) == null) {
                        return null;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        n nVar = new n();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        int optInt = jSONObject2.optInt("id");
                        if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                            nVar.a = optInt;
                            nVar.b = jSONObject2.optString("name");
                            nVar.c = jSONObject2.optInt("mapsize");
                            nVar.d = jSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            if (jSONObject2.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                                ArrayList<n> arrayList2 = new ArrayList<>();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    n nVar2 = new n();
                                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                                    nVar2.a = optJSONObject.optInt("id");
                                    nVar2.b = optJSONObject.optString("name");
                                    nVar2.c = optJSONObject.optInt("mapsize");
                                    nVar2.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                    arrayList2.add(nVar2);
                                }
                                nVar.a(arrayList2);
                            }
                            arrayList.add(nVar);
                        }
                    }
                    return arrayList;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public r g(int i) {
        InterceptResult invokeI;
        String OnRecordGetAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap != null && i >= 0 && (OnRecordGetAt = appBaseMap.OnRecordGetAt(i)) != null && !OnRecordGetAt.equals("")) {
                r rVar = new r();
                q qVar = new q();
                try {
                    JSONObject jSONObject = new JSONObject(OnRecordGetAt);
                    if (jSONObject.length() == 0) {
                        return null;
                    }
                    int optInt = jSONObject.optInt("id");
                    if (optInt > 2000 && optInt != 2912 && optInt != 2911 && optInt != 9000) {
                        return null;
                    }
                    qVar.a = optInt;
                    qVar.b = jSONObject.optString("name");
                    qVar.c = jSONObject.optString("pinyin");
                    qVar.d = jSONObject.optString("headchar");
                    qVar.h = jSONObject.optInt("mapoldsize");
                    qVar.i = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                    qVar.l = jSONObject.optInt("status");
                    qVar.g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                    boolean z = true;
                    if (jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE) != 1) {
                        z = false;
                    }
                    qVar.j = z;
                    qVar.e = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_LEVEL);
                    if (qVar.j) {
                        qVar.k = jSONObject.optInt("mapsize");
                    } else {
                        qVar.k = 0;
                    }
                    qVar.f = jSONObject.optInt("ver");
                    rVar.a(qVar);
                    return rVar;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (r) invokeI.objValue;
    }

    public void a(s sVar) {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) && (tVar = this.d) != null) {
            tVar.a(sVar);
        }
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.b == null || i < 0) {
                return false;
            }
            if (i > 2000 && i != 2912 && i != 2911 && i != 9000) {
                return false;
            }
            return this.b.OnRecordStart(i, false, 0);
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.b == null || i < 0) {
                return false;
            }
            if (i > 2000 && i != 2912 && i != 2911 && i != 9000) {
                return false;
            }
            return this.b.OnRecordAdd(i);
        }
        return invokeI.booleanValue;
    }

    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap == null) {
                return false;
            }
            return appBaseMap.OnRecordImport(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public ArrayList<n> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AppBaseMap appBaseMap = this.b;
            if (appBaseMap == null) {
                return null;
            }
            String OnHotcityGet = appBaseMap.OnHotcityGet();
            ArrayList<n> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(OnHotcityGet).optJSONArray("dataset");
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    n nVar = new n();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    nVar.a = optJSONObject.optInt("id");
                    nVar.b = optJSONObject.optString("name");
                    nVar.c = optJSONObject.optInt("mapsize");
                    nVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                    if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                        ArrayList<n> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            n nVar2 = new n();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            nVar2.a = optJSONObject2.optInt("id");
                            nVar2.b = optJSONObject2.optString("name");
                            nVar2.c = optJSONObject2.optInt("mapsize");
                            nVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                            arrayList2.add(nVar2);
                        }
                        nVar.a(arrayList2);
                    }
                    arrayList.add(nVar);
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AppBaseMap appBaseMap = this.b;
            ArrayList<n> arrayList = null;
            if (appBaseMap == null) {
                return null;
            }
            String OnSchcityGet = appBaseMap.OnSchcityGet("");
            ArrayList<n> arrayList2 = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(OnSchcityGet).optJSONArray("dataset");
                if (optJSONArray == null) {
                    return null;
                }
                int i = 0;
                while (i < optJSONArray.length()) {
                    n nVar = new n();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        nVar.a = optInt;
                        nVar.b = optJSONObject.optString("name");
                        nVar.c = optJSONObject.optInt("mapsize");
                        nVar.d = optJSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                        if (optJSONObject.has(MapBundleKey.OfflineMapKey.OFFLINE_CHILD)) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
                            ArrayList<n> arrayList3 = new ArrayList<>();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                n nVar2 = new n();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                try {
                                    nVar2.a = optJSONObject2.optInt("id");
                                    nVar2.b = optJSONObject2.optString("name");
                                    nVar2.c = optJSONObject2.optInt("mapsize");
                                    nVar2.d = optJSONObject2.optInt(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
                                    arrayList3.add(nVar2);
                                } catch (JSONException unused) {
                                    return null;
                                } catch (Exception unused2) {
                                    return null;
                                }
                            }
                            nVar.a(arrayList3);
                        }
                        arrayList2.add(nVar);
                    }
                    i++;
                    arrayList = null;
                }
                return arrayList2;
            } catch (JSONException unused3) {
                return arrayList;
            } catch (Exception unused4) {
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
