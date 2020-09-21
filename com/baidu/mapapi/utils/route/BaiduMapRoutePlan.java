package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class BaiduMapRoutePlan {
    private static boolean a = true;

    private static void a(RouteParaOption routeParaOption, Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://api.map.baidu.com/direction?");
        sb.append("origin=");
        LatLng latLng = routeParaOption.a;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng != null) {
            latLng = CoordTrans.gcjToBaidu(latLng);
        }
        if (routeParaOption.a != null && routeParaOption.c != null && !routeParaOption.c.equals("") && latLng != null) {
            sb.append("latlng:");
            sb.append(latLng.latitude);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(latLng.longitude);
            sb.append("|");
            sb.append("name:");
            sb.append(routeParaOption.c);
        } else if (routeParaOption.a == null || latLng == null) {
            sb.append(routeParaOption.c);
        } else {
            sb.append(latLng.latitude);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(latLng.longitude);
        }
        LatLng latLng2 = routeParaOption.b;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng2 != null) {
            latLng2 = CoordTrans.gcjToBaidu(latLng2);
        }
        sb.append("&destination=");
        if (routeParaOption.b != null && routeParaOption.d != null && !routeParaOption.d.equals("") && latLng2 != null) {
            sb.append("latlng:");
            sb.append(latLng2.latitude);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(latLng2.longitude);
            sb.append("|");
            sb.append("name:");
            sb.append(routeParaOption.d);
        } else if (routeParaOption.b == null || latLng2 == null) {
            sb.append(routeParaOption.d);
        } else {
            sb.append(latLng2.latitude);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(latLng2.longitude);
        }
        String str = "";
        switch (i) {
            case 0:
                str = "driving";
                break;
            case 1:
                str = "transit";
                break;
            case 2:
                str = "walking";
                break;
        }
        sb.append("&mode=");
        sb.append(str);
        sb.append("&region=");
        if (routeParaOption.getCityName() == null || routeParaOption.getCityName().equals("")) {
            sb.append("全国");
        } else {
            sb.append(routeParaOption.getCityName());
        }
        sb.append("&output=html");
        sb.append("&src=");
        sb.append(context.getPackageName());
        Uri parse = Uri.parse(sb.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(parse);
        context.startActivity(intent);
    }

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f == null) {
            routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 0);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f == null) {
            routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 1);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.b == null && routeParaOption.a == null && routeParaOption.d == null && routeParaOption.c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.c == null && routeParaOption.a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if (((routeParaOption.c == null || routeParaOption.c.equals("")) && routeParaOption.a == null) || ((routeParaOption.d == null || routeParaOption.d.equals("")) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f == null) {
            routeParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 2);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static void setSupportWebRoute(boolean z) {
        a = z;
    }
}
