package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaiduMapNavigation {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7246a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-392838784, "Lcom/baidu/mapapi/navi/BaiduMapNavigation;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-392838784, "Lcom/baidu/mapapi/navi/BaiduMapNavigation;");
        }
    }

    public BaiduMapNavigation() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                packageManager = context.getApplicationContext().getPackageManager();
                try {
                    applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                packageManager = null;
            }
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return (String) invokeL.objValue;
    }

    public static void a(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, naviParaOption, context) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            LatLng latLng = naviParaOption.f7247a;
            if (latLng == null || naviParaOption.f7249c == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point.");
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(naviParaOption.f7249c);
            StringBuilder sb = new StringBuilder();
            sb.append("http://app.navi.baidu.com/mobile/#navi/naving/");
            sb.append("&sy=0");
            sb.append("&endp=");
            sb.append("&start=");
            sb.append("&startwd=");
            sb.append("&endwd=");
            sb.append("&fromprod=map_sdk");
            sb.append("&app_version=");
            sb.append(VersionInfo.VERSION_INFO);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("type", "1");
                if (naviParaOption.f7248b == null || naviParaOption.f7248b.equals("")) {
                    jSONObject.put("keyword", "");
                } else {
                    jSONObject.put("keyword", naviParaOption.f7248b);
                }
                jSONObject.put("xy", String.valueOf(ll2mc.getLongitudeE6()) + "," + String.valueOf(ll2mc.getLatitudeE6()));
                jSONArray.put(jSONObject);
                jSONObject2.put("type", "1");
                if (naviParaOption.f7250d == null || naviParaOption.f7250d.equals("")) {
                    jSONObject.put("keyword", "");
                } else {
                    jSONObject.put("keyword", naviParaOption.f7250d);
                }
                jSONObject2.put("xy", String.valueOf(ll2mc2.getLongitudeE6()) + "," + String.valueOf(ll2mc2.getLatitudeE6()));
                jSONArray.put(jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() > 0) {
                sb.append("&positions=");
                sb.append(jSONArray.toString());
            }
            sb.append("&ctrl_type=");
            sb.append("&mrsl=");
            sb.append("/vt=map&state=entry");
            Uri parse = Uri.parse(sb.toString());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    public static void finish(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || context == null) {
            return;
        }
        b.a(context);
    }

    public static boolean openBaiduMapBikeNavi(NaviParaOption naviParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, naviParaOption, context)) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (naviParaOption.f7249c == null || naviParaOption.f7247a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 8);
            } else {
                str = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e("baidumapsdk", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapNavi(NaviParaOption naviParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, naviParaOption, context)) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (naviParaOption.f7249c == null || naviParaOption.f7247a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (f7246a) {
                    a(naviParaOption, context);
                    return true;
                }
                throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: BaiduMap app is not installed.");
            } else if (baiduMapVersion >= 830) {
                return b.a(naviParaOption, context, 5);
            } else {
                Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.2");
                if (f7246a) {
                    a(naviParaOption, context);
                    return true;
                }
                throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.2");
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapWalkNavi(NaviParaOption naviParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, naviParaOption, context)) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (naviParaOption.f7249c == null || naviParaOption.f7247a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 7);
            } else {
                str = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e("baidumapsdk", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapWalkNaviAR(NaviParaOption naviParaOption, Context context) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, naviParaOption, context)) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            if (naviParaOption.f7249c == null || naviParaOption.f7247a == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 869) {
                return b.a(naviParaOption, context, 9);
            } else {
                str = "Baidumap app version is too lowl.Version is greater than 8.6.6";
            }
            Log.e("baidumapsdk", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static void openWebBaiduMapNavi(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        String str;
        Uri parse;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, naviParaOption, context) == null) {
            if (naviParaOption == null || context == null) {
                throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
            }
            LatLng latLng = naviParaOption.f7247a;
            if (latLng == null || naviParaOption.f7249c == null) {
                String str2 = naviParaOption.f7248b;
                if (str2 == null || str2.equals("") || (str = naviParaOption.f7250d) == null || str.equals("")) {
                    throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point or set the start and end name.");
                }
                parse = Uri.parse("http://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$" + naviParaOption.f7248b + "$$$$$$&en=2$$$$$$" + naviParaOption.f7250d + "$$$$$$&fromprod=" + a(context));
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
            } else {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(naviParaOption.f7249c);
                parse = Uri.parse("http://daohang.map.baidu.com/mobile/#navi/naving/start=" + ll2mc.getLongitudeE6() + "," + ll2mc.getLatitudeE6() + "&endp=" + ll2mc2.getLongitudeE6() + "," + ll2mc2.getLatitudeE6() + "&fromprod=" + a(context) + "/vt=map&state=entry");
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    public static void setSupportWebNavi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            f7246a = z;
        }
    }
}
