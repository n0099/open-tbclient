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
    public static boolean f7531a = true;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(RouteParaOption routeParaOption, Context context, int i2) {
        LatLng latLng;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("http://api.map.baidu.com/direction?");
        sb.append("origin=");
        LatLng latLng2 = routeParaOption.f7532a;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng2 != null) {
            latLng2 = CoordTrans.gcjToBaidu(latLng2);
        }
        if (routeParaOption.f7532a != null && (str2 = routeParaOption.f7534c) != null && !str2.equals("") && latLng2 != null) {
            sb.append("latlng:");
            sb.append(latLng2.latitude);
            sb.append(",");
            sb.append(latLng2.longitude);
            sb.append(FieldBuilder.SE);
            sb.append("name:");
        } else if (routeParaOption.f7532a != null && latLng2 != null) {
            sb.append(latLng2.latitude);
            sb.append(",");
            sb.append(latLng2.longitude);
            latLng = routeParaOption.f7533b;
            if (SDKInitializer.getCoordType() == CoordType.GCJ02 && latLng != null) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            sb.append("&destination=");
            if (routeParaOption.f7533b == null && (str = routeParaOption.f7535d) != null && !str.equals("") && latLng != null) {
                sb.append("latlng:");
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(latLng.longitude);
                sb.append(FieldBuilder.SE);
                sb.append("name:");
            } else if (routeParaOption.f7533b != null && latLng != null) {
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
            sb.append(routeParaOption.f7535d);
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
        sb.append(routeParaOption.f7534c);
        latLng = routeParaOption.f7533b;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            latLng = CoordTrans.gcjToBaidu(latLng);
        }
        sb.append("&destination=");
        if (routeParaOption.f7533b == null) {
        }
        if (routeParaOption.f7533b != null) {
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
        sb.append(routeParaOption.f7535d);
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

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.f7533b == null && routeParaOption.f7532a == null && routeParaOption.f7535d == null && routeParaOption.f7534c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7534c == null && routeParaOption.f7532a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.f7535d == null && routeParaOption.f7533b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7534c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7532a == null) || (((str = routeParaOption.f7535d) == null || str.equals("")) && routeParaOption.f7533b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7537f == null) {
            routeParaOption.f7537f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7531a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 0);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7531a) {
                a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.f7533b == null && routeParaOption.f7532a == null && routeParaOption.f7535d == null && routeParaOption.f7534c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7534c == null && routeParaOption.f7532a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.f7535d == null && routeParaOption.f7533b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7534c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7532a == null) || (((str = routeParaOption.f7535d) == null || str.equals("")) && routeParaOption.f7533b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7537f == null) {
            routeParaOption.f7537f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7531a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 1);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7531a) {
                a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        String str;
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (routeParaOption.f7533b == null && routeParaOption.f7532a == null && routeParaOption.f7535d == null && routeParaOption.f7534c == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f7534c == null && routeParaOption.f7532a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.f7535d == null && routeParaOption.f7533b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        String str2 = routeParaOption.f7534c;
        if (((str2 == null || str2.equals("")) && routeParaOption.f7532a == null) || (((str = routeParaOption.f7535d) == null || str.equals("")) && routeParaOption.f7533b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f7537f == null) {
            routeParaOption.f7537f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f7531a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return b.a(routeParaOption, context, 2);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f7531a) {
                a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static void setSupportWebRoute(boolean z) {
        f7531a = z;
    }
}
