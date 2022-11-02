package com.baidu.mapapi.navi;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NaviParaOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LatLng a;
    public String b;
    public LatLng c;
    public String d;
    public WayPoint e;
    public NaviRoutePolicy f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class NaviRoutePolicy {
        public static /* synthetic */ Interceptable $ic;
        public static final NaviRoutePolicy BLK;
        public static final NaviRoutePolicy DEFAULT;
        public static final NaviRoutePolicy DIS;
        public static final NaviRoutePolicy FEE;
        public static final NaviRoutePolicy HIGHWAY;
        public static final NaviRoutePolicy TIME;
        public static final /* synthetic */ NaviRoutePolicy[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8012873, "Lcom/baidu/mapapi/navi/NaviParaOption$NaviRoutePolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(8012873, "Lcom/baidu/mapapi/navi/NaviParaOption$NaviRoutePolicy;");
                    return;
                }
            }
            BLK = new NaviRoutePolicy("BLK", 0);
            TIME = new NaviRoutePolicy("TIME", 1);
            DIS = new NaviRoutePolicy("DIS", 2);
            FEE = new NaviRoutePolicy("FEE", 3);
            HIGHWAY = new NaviRoutePolicy("HIGHWAY", 4);
            NaviRoutePolicy naviRoutePolicy = new NaviRoutePolicy(EngineName.DEFAULT_ENGINE, 5);
            DEFAULT = naviRoutePolicy;
            a = new NaviRoutePolicy[]{BLK, TIME, DIS, FEE, HIGHWAY, naviRoutePolicy};
        }

        public NaviRoutePolicy(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NaviRoutePolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NaviRoutePolicy) Enum.valueOf(NaviRoutePolicy.class, str);
            }
            return (NaviRoutePolicy) invokeL.objValue;
        }

        public static NaviRoutePolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NaviRoutePolicy[]) a.clone();
            }
            return (NaviRoutePolicy[]) invokeV.objValue;
        }
    }

    public NaviParaOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = NaviRoutePolicy.DEFAULT;
    }

    public String getEndName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (LatLng) invokeV.objValue;
    }

    public String getStartName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (LatLng) invokeV.objValue;
    }

    public NaviParaOption endName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
            this.c = latLng;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy naviRoutePolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, naviRoutePolicy)) == null) {
            this.f = naviRoutePolicy;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption setWayPoint(WayPoint wayPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, wayPoint)) == null) {
            if (wayPoint == null) {
                return null;
            }
            this.e = wayPoint;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption startName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, latLng)) == null) {
            this.a = latLng;
            return this;
        }
        return (NaviParaOption) invokeL.objValue;
    }

    public String getNaviRoutePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = a.a[this.f.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return EngineName.DEFAULT_ENGINE;
                            }
                            return "HIGHWAY";
                        }
                        return "FEE";
                    }
                    return "DIS";
                }
                return "TIME";
            }
            return "BLK";
        }
        return (String) invokeV.objValue;
    }

    public JSONArray getWayPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WayPoint wayPoint = this.e;
            JSONArray jSONArray = null;
            if (wayPoint == null) {
                return null;
            }
            List<WayPointInfo> viaPoints = wayPoint.getViaPoints();
            if (viaPoints != null && viaPoints.size() != 0) {
                jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < viaPoints.size(); i++) {
                    WayPointInfo wayPointInfo = viaPoints.get(i);
                    if (wayPointInfo != null) {
                        try {
                            if (!TextUtils.isEmpty(wayPointInfo.getWayPointName())) {
                                jSONObject.put("name", wayPointInfo.getWayPointName());
                            }
                            LatLng latLng = wayPointInfo.getLatLng();
                            if (latLng != null) {
                                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                    latLng = CoordTrans.gcjToBaidu(latLng);
                                }
                                jSONObject.put(SuggestAddrField.KEY_LNG, latLng.longitude);
                                jSONObject.put(SuggestAddrField.KEY_LAT, latLng.latitude);
                                jSONArray.put(jSONObject);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
