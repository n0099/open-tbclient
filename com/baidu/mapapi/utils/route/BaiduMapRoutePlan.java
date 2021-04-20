package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes2.dex */
public class BaiduMapRoutePlan {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7447a = true;

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(RouteParaOption routeParaOption, Context context, int i) {
        LatLng latLng;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("http://api.map.baidu.com/direction?");
        sb.append("origin=");
        LatLng latLng2 = routeParaOption.f7448a;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng2 != null) {
            latLng2 = CoordTrans.gcjToBaidu(latLng2);
        }
        if (routeParaOption.f7448a != null && (str2 = routeParaOption.f7450c) != null && !str2.equals("")) {
            sb.append("latlng:");
            sb.append(latLng2.latitude);
            sb.append(",");
            sb.append(latLng2.longitude);
            sb.append(FieldBuilder.SE);
            sb.append("name:");
        } else if (routeParaOption.f7448a != null) {
            sb.append(latLng2.latitude);
            sb.append(",");
            sb.append(latLng2.longitude);
            latLng = routeParaOption.f7449b;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng != null) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            sb.append("&destination=");
            if (routeParaOption.f7449b == null && (str = routeParaOption.f7451d) != null && !str.equals("")) {
                sb.append("latlng:");
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
                sb.append(FieldBuilder.SE);
                sb.append("name:");
            } else if (routeParaOption.f7449b != null) {
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
                String str3 = i != 0 ? i != 1 ? i != 2 ? "" : "walking" : "transit" : "driving";
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
            sb.append(routeParaOption.f7451d);
            if (i != 0) {
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
        sb.append(routeParaOption.f7450c);
        latLng = routeParaOption.f7449b;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            latLng = CoordTrans.gcjToBaidu(latLng);
        }
        sb.append("&destination=");
        if (routeParaOption.f7449b == null) {
        }
        if (routeParaOption.f7449b != null) {
        }
        sb.append(routeParaOption.f7451d);
        if (i != 0) {
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

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f7449b == null && routeParaOption.f7448a == null && routeParaOption.f7451d == null && routeParaOption.f7450c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7450c == null && routeParaOption.f7448a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f7451d == null && routeParaOption.f7449b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7450c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7448a == null) || (((str = routeParaOption.f7451d) == null || str.equals("")) && routeParaOption.f7449b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7453f == null) {
            routeParaOption.f7453f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7447a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 0);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7447a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f7449b == null && routeParaOption.f7448a == null && routeParaOption.f7451d == null && routeParaOption.f7450c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7450c == null && routeParaOption.f7448a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f7451d == null && routeParaOption.f7449b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7450c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7448a == null) || (((str = routeParaOption.f7451d) == null || str.equals("")) && routeParaOption.f7449b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7453f == null) {
            routeParaOption.f7453f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7447a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 1);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7447a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f7449b == null && routeParaOption.f7448a == null && routeParaOption.f7451d == null && routeParaOption.f7450c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7450c == null && routeParaOption.f7448a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f7451d == null && routeParaOption.f7449b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7450c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7448a == null) || (((str = routeParaOption.f7451d) == null || str.equals("")) && routeParaOption.f7449b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7453f == null) {
            routeParaOption.f7453f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7447a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 2);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7447a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static void setSupportWebRoute(boolean z) {
        f7447a = z;
    }
}
