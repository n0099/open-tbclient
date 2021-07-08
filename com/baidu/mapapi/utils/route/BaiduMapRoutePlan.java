package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7521a = true;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(RouteParaOption routeParaOption, Context context, int i2) {
        LatLng latLng;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, routeParaOption, context, i2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://api.map.baidu.com/direction?");
            sb.append("origin=");
            LatLng latLng2 = routeParaOption.f7522a;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng2 != null) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (routeParaOption.f7522a != null && (str2 = routeParaOption.f7524c) != null && !str2.equals("") && latLng2 != null) {
                sb.append("latlng:");
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(latLng2.longitude);
                sb.append("|");
                sb.append("name:");
            } else if (routeParaOption.f7522a != null && latLng2 != null) {
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(latLng2.longitude);
                latLng = routeParaOption.f7523b;
                if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng != null) {
                    latLng = CoordTrans.gcjToBaidu(latLng);
                }
                sb.append("&destination=");
                if (routeParaOption.f7523b == null && (str = routeParaOption.f7525d) != null && !str.equals("") && latLng != null) {
                    sb.append("latlng:");
                    sb.append(latLng.latitude);
                    sb.append(",");
                    sb.append(latLng.longitude);
                    sb.append("|");
                    sb.append("name:");
                } else if (routeParaOption.f7523b != null && latLng != null) {
                    sb.append(latLng.latitude);
                    sb.append(",");
                    sb.append(latLng.longitude);
                    String str3 = i2 == 0 ? i2 != 1 ? i2 != 2 ? "" : "walking" : "transit" : "driving";
                    sb.append("&mode=");
                    sb.append(str3);
                    sb.append("&region=");
                    sb.append((routeParaOption.getCityName() != null || routeParaOption.getCityName().equals("")) ? "全国" : routeParaOption.getCityName());
                    sb.append("&output=html");
                    sb.append("&src=");
                    sb.append(context.getPackageName());
                    Uri parse = Uri.parse(sb.toString());
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent.setData(parse);
                    context.startActivity(intent);
                }
                sb.append(routeParaOption.f7525d);
                if (i2 == 0) {
                }
                sb.append("&mode=");
                sb.append(str3);
                sb.append("&region=");
                sb.append((routeParaOption.getCityName() != null || routeParaOption.getCityName().equals("")) ? "全国" : routeParaOption.getCityName());
                sb.append("&output=html");
                sb.append("&src=");
                sb.append(context.getPackageName());
                Uri parse2 = Uri.parse(sb.toString());
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent2.setData(parse2);
                context.startActivity(intent2);
            }
            sb.append(routeParaOption.f7524c);
            latLng = routeParaOption.f7523b;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            sb.append("&destination=");
            if (routeParaOption.f7523b == null) {
            }
            if (routeParaOption.f7523b != null) {
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
                if (i2 == 0) {
                }
                sb.append("&mode=");
                sb.append(str3);
                sb.append("&region=");
                sb.append((routeParaOption.getCityName() != null || routeParaOption.getCityName().equals("")) ? "全国" : routeParaOption.getCityName());
                sb.append("&output=html");
                sb.append("&src=");
                sb.append(context.getPackageName());
                Uri parse22 = Uri.parse(sb.toString());
                Intent intent22 = new Intent();
                intent22.setAction("android.intent.action.VIEW");
                intent22.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent22.setData(parse22);
                context.startActivity(intent22);
            }
            sb.append(routeParaOption.f7525d);
            if (i2 == 0) {
            }
            sb.append("&mode=");
            sb.append(str3);
            sb.append("&region=");
            sb.append((routeParaOption.getCityName() != null || routeParaOption.getCityName().equals("")) ? "全国" : routeParaOption.getCityName());
            sb.append("&output=html");
            sb.append("&src=");
            sb.append(context.getPackageName());
            Uri parse222 = Uri.parse(sb.toString());
            Intent intent222 = new Intent();
            intent222.setAction("android.intent.action.VIEW");
            intent222.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent222.setData(parse222);
            context.startActivity(intent222);
        }
    }

    public static void finish(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || context == null) {
            return;
        }
        b.a(context);
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, routeParaOption, context)) == null) {
            if (routeParaOption == null || context == null) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (routeParaOption.f7523b == null && routeParaOption.f7522a == null && routeParaOption.f7525d == null && routeParaOption.f7524c == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
            }
            if (routeParaOption.f7524c == null && routeParaOption.f7522a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
            }
            if (routeParaOption.f7525d == null && routeParaOption.f7523b == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
            }
            String str2 = routeParaOption.f7524c;
            if (((str2 == null || str2.equals("")) && routeParaOption.f7522a == null) || (((str = routeParaOption.f7525d) == null || str.equals("")) && routeParaOption.f7523b == null)) {
                Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                return false;
            }
            if (routeParaOption.f7527f == null) {
                routeParaOption.f7527f = RouteParaOption.EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (f7521a) {
                    a(routeParaOption, context, 0);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 0);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (f7521a) {
                    a(routeParaOption, context, 0);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, routeParaOption, context)) == null) {
            if (routeParaOption == null || context == null) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (routeParaOption.f7523b == null && routeParaOption.f7522a == null && routeParaOption.f7525d == null && routeParaOption.f7524c == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
            }
            if (routeParaOption.f7524c == null && routeParaOption.f7522a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
            }
            if (routeParaOption.f7525d == null && routeParaOption.f7523b == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
            }
            String str2 = routeParaOption.f7524c;
            if (((str2 == null || str2.equals("")) && routeParaOption.f7522a == null) || (((str = routeParaOption.f7525d) == null || str.equals("")) && routeParaOption.f7523b == null)) {
                Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                return false;
            }
            if (routeParaOption.f7527f == null) {
                routeParaOption.f7527f = RouteParaOption.EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (f7521a) {
                    a(routeParaOption, context, 1);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 1);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (f7521a) {
                    a(routeParaOption, context, 1);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, routeParaOption, context)) == null) {
            if (routeParaOption == null || context == null) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (routeParaOption.f7523b == null && routeParaOption.f7522a == null && routeParaOption.f7525d == null && routeParaOption.f7524c == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
            }
            if (routeParaOption.f7524c == null && routeParaOption.f7522a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
            }
            if (routeParaOption.f7525d == null && routeParaOption.f7523b == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
            }
            String str2 = routeParaOption.f7524c;
            if (((str2 == null || str2.equals("")) && routeParaOption.f7522a == null) || (((str = routeParaOption.f7525d) == null || str.equals("")) && routeParaOption.f7523b == null)) {
                Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
                return false;
            }
            if (routeParaOption.f7527f == null) {
                routeParaOption.f7527f = RouteParaOption.EBusStrategyType.bus_recommend_way;
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (f7521a) {
                    a(routeParaOption, context, 2);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 810) {
                return b.a(routeParaOption, context, 2);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                if (f7521a) {
                    a(routeParaOption, context, 2);
                    return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
            }
        }
        return invokeLL.booleanValue;
    }

    public static void setSupportWebRoute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f7521a = z;
        }
    }
}
