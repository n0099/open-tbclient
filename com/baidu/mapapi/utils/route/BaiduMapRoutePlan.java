package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BaiduMapRoutePlan {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1392569713, "Lcom/baidu/mapapi/utils/route/BaiduMapRoutePlan;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1392569713, "Lcom/baidu/mapapi/utils/route/BaiduMapRoutePlan;");
        }
    }

    public BaiduMapRoutePlan() {
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

    public static void a(RouteParaOption routeParaOption, Context context, int i) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, routeParaOption, context, i) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://api.map.baidu.com/direction?");
            sb.append("origin=");
            LatLng latLng = routeParaOption.a;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng != null) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            if (routeParaOption.a != null && (str3 = routeParaOption.c) != null && !str3.equals("") && latLng != null) {
                sb.append("latlng:");
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
                sb.append("|");
                sb.append("name:");
                sb.append(routeParaOption.c);
            } else if (routeParaOption.a != null && latLng != null) {
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
            } else {
                sb.append(routeParaOption.c);
            }
            LatLng latLng2 = routeParaOption.b;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng2 != null) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            sb.append("&destination=");
            if (routeParaOption.b != null && (str2 = routeParaOption.d) != null && !str2.equals("") && latLng2 != null) {
                sb.append("latlng:");
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(latLng2.longitude);
                sb.append("|");
                sb.append("name:");
                sb.append(routeParaOption.d);
            } else if (routeParaOption.b != null && latLng2 != null) {
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(latLng2.longitude);
            } else {
                sb.append(routeParaOption.d);
            }
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        str = "";
                    } else {
                        str = "walking";
                    }
                } else {
                    str = "transit";
                }
            } else {
                str = "driving";
            }
            sb.append("&mode=");
            sb.append(str);
            sb.append("&region=");
            if (routeParaOption.getCityName() != null && !routeParaOption.getCityName().equals("")) {
                sb.append(routeParaOption.getCityName());
            } else {
                sb.append("全国");
            }
            sb.append("&output=html");
            sb.append("&src=");
            sb.append(context.getPackageName());
            Uri parse = Uri.parse(sb.toString());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    public static void finish(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && context != null) {
            b.a(context);
        }
    }

    public static void setSupportWebRoute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            a = z;
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, routeParaOption, context)) == null) {
            if (routeParaOption != null && context != null) {
                if (routeParaOption.c == null && routeParaOption.a == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
                }
                if (routeParaOption.d == null && routeParaOption.b == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
                }
                if ((TextUtils.isEmpty(routeParaOption.c) && routeParaOption.a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                    return false;
                }
                if (routeParaOption.f == null) {
                    routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 810) {
                        return b.a(routeParaOption, context, 0);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(routeParaOption, context, 0);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 0);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapNewEnergyRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, routeParaOption, context)) == null) {
            if (routeParaOption != null && context != null) {
                if (routeParaOption.c == null && routeParaOption.a == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
                }
                if (routeParaOption.d == null && routeParaOption.b == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
                }
                if ((TextUtils.isEmpty(routeParaOption.c) && routeParaOption.a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                    return false;
                }
                if (routeParaOption.f == null) {
                    routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 810) {
                        return b.a(routeParaOption, context, 101);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(routeParaOption, context, 101);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 101);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, routeParaOption, context)) == null) {
            if (routeParaOption != null && context != null) {
                if (routeParaOption.c == null && routeParaOption.a == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
                }
                if (routeParaOption.d == null && routeParaOption.b == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
                }
                if ((TextUtils.isEmpty(routeParaOption.c) && routeParaOption.a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                    return false;
                }
                if (routeParaOption.f == null) {
                    routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 810) {
                        return b.a(routeParaOption, context, 1);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(routeParaOption, context, 1);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 1);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapTruckRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, routeParaOption, context)) == null) {
            if (routeParaOption != null && context != null) {
                if (routeParaOption.c == null && routeParaOption.a == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
                }
                if (routeParaOption.d == null && routeParaOption.b == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
                }
                if ((TextUtils.isEmpty(routeParaOption.c) && routeParaOption.a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                    return false;
                }
                if (routeParaOption.f == null) {
                    routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 810) {
                        return b.a(routeParaOption, context, 102);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(routeParaOption, context, 7);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 7);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, routeParaOption, context)) == null) {
            if (routeParaOption != null && context != null) {
                if (routeParaOption.c == null && routeParaOption.a == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
                }
                if (routeParaOption.d == null && routeParaOption.b == null) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
                }
                if ((TextUtils.isEmpty(routeParaOption.c) && routeParaOption.a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                    return false;
                }
                if (routeParaOption.f == null) {
                    routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 810) {
                        return b.a(routeParaOption, context, 2);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(routeParaOption, context, 2);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(routeParaOption, context, 2);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        return invokeLL.booleanValue;
    }
}
