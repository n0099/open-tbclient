package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
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
/* loaded from: classes8.dex */
public class r {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "r";

    /* renamed from: c  reason: collision with root package name */
    public static r f36484c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f36485b;

    /* renamed from: d  reason: collision with root package name */
    public w f36486d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f36487e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(724782530, "Lcom/baidu/mapsdkplatform/comapi/map/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(724782530, "Lcom/baidu/mapsdkplatform/comapi/map/r;");
        }
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f36484c == null) {
                r rVar = new r();
                f36484c = rVar;
                rVar.g();
            }
            return f36484c;
        }
        return (r) invokeV.objValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            h();
            this.f36486d = new w();
            s sVar = new s(this);
            this.f36487e = sVar;
            MessageCenter.registMessage(65289, sVar);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Context context = BMapManager.getContext();
            EnvironmentUtilities.initAppDirectory(context);
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
            this.f36485b = aVar;
            aVar.a(context.hashCode());
            String moduleFileName = SysOSUtil.getModuleFileName();
            String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
            String appCachePath = EnvironmentUtilities.getAppCachePath();
            String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
            int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
            int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
            int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
            String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
            String str2 = moduleFileName + "/cfg";
            String str3 = appSDCardPath + "/vmp";
            String str4 = str3 + str;
            String str5 = str3 + str;
            String str6 = appCachePath + "/tmp/";
            this.f36485b.a(str2 + "/a/", str4, str6, appSecondCachePath + "/tmp/", str5, str2 + "/a/", null, 0, str2 + "/idrres/", SysOSUtil.getScreenSizeX(), SysOSUtil.getScreenSizeY(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
            this.f36485b.d();
        }
    }

    public ArrayList<q> a(String str) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!str.equals("") && (aVar = this.f36485b) != null) {
                String a2 = aVar.a(str);
                if (a2 == null || a2.equals("")) {
                    return null;
                }
                ArrayList<q> arrayList = new ArrayList<>();
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET)) == null) {
                        return null;
                    }
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        q qVar = new q();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        int optInt = jSONObject2.optInt("id");
                        if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                            qVar.a = optInt;
                            qVar.f36480b = jSONObject2.optString("name");
                            qVar.f36481c = jSONObject2.optInt("mapsize");
                            qVar.f36482d = jSONObject2.optInt("cty");
                            if (jSONObject2.has("child")) {
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("child");
                                ArrayList<q> arrayList2 = new ArrayList<>();
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    q qVar2 = new q();
                                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                                    qVar2.a = optJSONObject.optInt("id");
                                    qVar2.f36480b = optJSONObject.optString("name");
                                    qVar2.f36481c = optJSONObject.optInt("mapsize");
                                    qVar2.f36482d = optJSONObject.optInt("cty");
                                    arrayList2.add(qVar2);
                                }
                                qVar.a(arrayList2);
                            }
                            arrayList.add(qVar);
                        }
                    }
                    return arrayList;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void a(v vVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar) == null) || (wVar = this.f36486d) == null) {
            return;
        }
        wVar.a(vVar);
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f36485b == null || i2 < 0) {
                return false;
            }
            if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
                return this.f36485b.d(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar == null) {
                return false;
            }
            return aVar.a(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageCenter.unregistMessage(65289, this.f36487e);
            this.f36485b.b(BMapManager.getContext().hashCode());
            f36484c = null;
        }
    }

    public void b(v vVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vVar) == null) || (wVar = this.f36486d) == null) {
            return;
        }
        wVar.b(vVar);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f36485b == null || i2 < 0) {
                return false;
            }
            if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
                return this.f36485b.a(i2, false, 0);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public ArrayList<q> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar == null) {
                return null;
            }
            String m = aVar.m();
            ArrayList<q> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(m).optJSONArray(ActionJsonData.TAG_DATASET);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    q qVar = new q();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    qVar.a = optJSONObject.optInt("id");
                    qVar.f36480b = optJSONObject.optString("name");
                    qVar.f36481c = optJSONObject.optInt("mapsize");
                    qVar.f36482d = optJSONObject.optInt("cty");
                    if (optJSONObject.has("child")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                        ArrayList<q> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            q qVar2 = new q();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                            qVar2.a = optJSONObject2.optInt("id");
                            qVar2.f36480b = optJSONObject2.optString("name");
                            qVar2.f36481c = optJSONObject2.optInt("mapsize");
                            qVar2.f36482d = optJSONObject2.optInt("cty");
                            arrayList2.add(qVar2);
                        }
                        qVar.a(arrayList2);
                    }
                    arrayList.add(qVar);
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar == null || i2 < 0) {
                return false;
            }
            return aVar.b(i2, false, 0);
        }
        return invokeI.booleanValue;
    }

    public ArrayList<q> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            ArrayList<q> arrayList = null;
            if (aVar == null) {
                return null;
            }
            String a2 = aVar.a("");
            ArrayList<q> arrayList2 = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(a2).optJSONArray(ActionJsonData.TAG_DATASET);
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    q qVar = new q();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    int optInt = optJSONObject.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        qVar.a = optInt;
                        qVar.f36480b = optJSONObject.optString("name");
                        qVar.f36481c = optJSONObject.optInt("mapsize");
                        qVar.f36482d = optJSONObject.optInt("cty");
                        if (optJSONObject.has("child")) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                            ArrayList<q> arrayList3 = new ArrayList<>();
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                q qVar2 = new q();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                                try {
                                    qVar2.a = optJSONObject2.optInt("id");
                                    qVar2.f36480b = optJSONObject2.optString("name");
                                    qVar2.f36481c = optJSONObject2.optInt("mapsize");
                                    qVar2.f36482d = optJSONObject2.optInt("cty");
                                    arrayList3.add(qVar2);
                                } catch (JSONException unused) {
                                    return null;
                                } catch (Exception unused2) {
                                    return null;
                                }
                            }
                            qVar.a(arrayList3);
                        }
                        arrayList2.add(qVar);
                    }
                    i2++;
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

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar == null) {
                return false;
            }
            return aVar.b(0, true, i2);
        }
        return invokeI.booleanValue;
    }

    public ArrayList<u> e() {
        InterceptResult invokeV;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar != null && (l = aVar.l()) != null && !l.equals("")) {
                ArrayList<u> arrayList = new ArrayList<>();
                try {
                    JSONObject jSONObject = new JSONObject(l);
                    if (jSONObject.length() == 0) {
                        return null;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        u uVar = new u();
                        t tVar = new t();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        tVar.a = optJSONObject.optInt("id");
                        tVar.f36488b = optJSONObject.optString("name");
                        tVar.f36489c = optJSONObject.optString("pinyin");
                        tVar.f36494h = optJSONObject.optInt("mapoldsize");
                        tVar.f36495i = optJSONObject.optInt("ratio");
                        tVar.l = optJSONObject.optInt("status");
                        tVar.f36493g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt("x"));
                        boolean z = true;
                        if (optJSONObject.optInt("up") != 1) {
                            z = false;
                        }
                        tVar.f36496j = z;
                        tVar.f36491e = optJSONObject.optInt("lev");
                        if (tVar.f36496j) {
                            tVar.f36497k = optJSONObject.optInt("mapsize");
                        } else {
                            tVar.f36497k = 0;
                        }
                        uVar.a(tVar);
                        arrayList.add(uVar);
                    }
                    return arrayList;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar == null || i2 < 0) {
                return false;
            }
            return aVar.b(i2, false);
        }
        return invokeI.booleanValue;
    }

    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.f36485b == null || i2 < 0) {
                return false;
            }
            if (i2 <= 2000 || i2 == 2912 || i2 == 2911 || i2 == 9000) {
                return this.f36485b.a(i2, false);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public u g(int i2) {
        InterceptResult invokeI;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f36485b;
            if (aVar != null && i2 >= 0 && (e2 = aVar.e(i2)) != null && !e2.equals("")) {
                u uVar = new u();
                t tVar = new t();
                try {
                    JSONObject jSONObject = new JSONObject(e2);
                    if (jSONObject.length() == 0) {
                        return null;
                    }
                    int optInt = jSONObject.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        tVar.a = optInt;
                        tVar.f36488b = jSONObject.optString("name");
                        tVar.f36489c = jSONObject.optString("pinyin");
                        tVar.f36490d = jSONObject.optString("headchar");
                        tVar.f36494h = jSONObject.optInt("mapoldsize");
                        tVar.f36495i = jSONObject.optInt("ratio");
                        tVar.l = jSONObject.optInt("status");
                        tVar.f36493g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt("x"));
                        boolean z = true;
                        if (jSONObject.optInt("up") != 1) {
                            z = false;
                        }
                        tVar.f36496j = z;
                        tVar.f36491e = jSONObject.optInt("lev");
                        if (tVar.f36496j) {
                            tVar.f36497k = jSONObject.optInt("mapsize");
                        } else {
                            tVar.f36497k = 0;
                        }
                        tVar.f36492f = jSONObject.optInt("ver");
                        uVar.a(tVar);
                        return uVar;
                    }
                    return null;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        }
        return (u) invokeI.objValue;
    }
}
