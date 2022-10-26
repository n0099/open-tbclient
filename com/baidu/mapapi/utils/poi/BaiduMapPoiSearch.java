package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.route.BaiduMapRoutePlan;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class BaiduMapPoiSearch {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(97521808, "Lcom/baidu/mapapi/utils/poi/BaiduMapPoiSearch;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(97521808, "Lcom/baidu/mapapi/utils/poi/BaiduMapPoiSearch;");
        }
    }

    public BaiduMapPoiSearch() {
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

    public static void a(PoiParaOption poiParaOption, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, poiParaOption, context) == null) {
            Uri parse = Uri.parse("http://api.map.baidu.com/place/detail?uid=" + poiParaOption.a + "&output=html&src=" + context.getPackageName());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setData(parse);
            context.startActivity(intent);
        }
    }

    public static void b(PoiParaOption poiParaOption, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, poiParaOption, context) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://api.map.baidu.com/place/search?");
            sb.append("query=");
            sb.append(poiParaOption.b);
            sb.append("&location=");
            LatLng latLng = poiParaOption.c;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            sb.append(latLng.latitude);
            sb.append(",");
            sb.append(latLng.longitude);
            sb.append("&radius=");
            sb.append(poiParaOption.d);
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

    public static void b(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, context) == null) {
            if (str == null || str.length() == 0) {
                throw new RuntimeException("BDMapSDKException: pano id can not be null.");
            }
            if (context == null) {
                throw new RuntimeException("BDMapSDKException: context cannot be null.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("baidumap://map/streetscape?");
            sb.append("panoid=");
            sb.append(str);
            sb.append("&pid=");
            sb.append(str);
            sb.append("&panotype=");
            sb.append("street");
            sb.append("&src=");
            sb.append("sdk_[" + context.getPackageName() + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                throw new RuntimeException("BDMapSDKException: BaiduMap app is not installed.");
            }
            context.startActivity(intent);
        }
    }

    public static boolean dispatchPoiToBaiduMap(List list, Context context) throws Exception {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, context)) == null) {
            if (list.isEmpty() || list.size() <= 0) {
                throw new NullPointerException("BDMapSDKException: dispatch poidata is null");
            }
            int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
            if (baiduMapVersion == 0) {
                str = "BaiduMap app is not installed.";
            } else if (baiduMapVersion >= 840) {
                return com.baidu.mapapi.utils.b.a(list, context, 6);
            } else {
                str = "Baidumap app version is too lowl.Version is greater than 8.4";
            }
            Log.e("baidumapsdk", str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void finish(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || context == null) {
            return;
        }
        com.baidu.mapapi.utils.b.a(context);
    }

    public static void openBaiduMapPanoShow(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, context) == null) {
            new com.baidu.platform.comapi.pano.a().a(str, new a(context));
        }
    }

    public static boolean openBaiduMapPoiDetialsPage(PoiParaOption poiParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, poiParaOption, context)) == null) {
            if (poiParaOption == null || context == null) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
            }
            String str = poiParaOption.a;
            if (str != null) {
                if (str.equals("")) {
                    Log.e(BaiduMapRoutePlan.class.getName(), "poi uid can not be empty string");
                    return false;
                }
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion == 0) {
                    Log.e("baidumapsdk", "BaiduMap app is not installed.");
                    if (a) {
                        a(poiParaOption, context);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
                } else if (baiduMapVersion >= 810) {
                    return com.baidu.mapapi.utils.b.a(poiParaOption, context, 3);
                } else {
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                    if (a) {
                        a(poiParaOption, context);
                        return true;
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static boolean openBaiduMapPoiNearbySearch(PoiParaOption poiParaOption, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, poiParaOption, context)) == null) {
            if (poiParaOption == null || context == null) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
            }
            String str = poiParaOption.b;
            if (str != null) {
                LatLng latLng = poiParaOption.c;
                if (latLng != null) {
                    if (latLng.longitude == 0.0d || latLng.latitude == 0.0d) {
                        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center longitude or latitude can not be 0.");
                    }
                    if (poiParaOption.d != 0) {
                        if (str.equals("")) {
                            Log.e(BaiduMapRoutePlan.class.getName(), "poi key can not be empty string");
                            return false;
                        }
                        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                        if (baiduMapVersion == 0) {
                            Log.e("baidumapsdk", "BaiduMap app is not installed.");
                            if (a) {
                                b(poiParaOption, context);
                                return true;
                            }
                            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
                        } else if (baiduMapVersion >= 810) {
                            return com.baidu.mapapi.utils.b.a(poiParaOption, context, 4);
                        } else {
                            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                            if (a) {
                                b(poiParaOption, context);
                                return true;
                            }
                            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                        }
                    }
                    throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search radius larger than 0.");
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center can not be null.");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search key can not be null.");
        }
        return invokeLL.booleanValue;
    }

    public static void setSupportWebPoi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            a = z;
        }
    }
}
