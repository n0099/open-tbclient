package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaiduMapNavigation {
    public static boolean a = true;

    public static String a(Context context) {
        PackageManager packageManager;
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

    public static void finish(Context context) {
        if (context != null) {
            b.a(context);
        }
    }

    public static void setSupportWebNavi(boolean z) {
        a = z;
    }

    public static void a(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        if (naviParaOption != null && context != null) {
            LatLng latLng = naviParaOption.a;
            if (latLng != null && naviParaOption.c != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(naviParaOption.c);
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
                    if (naviParaOption.b != null && !naviParaOption.b.equals("")) {
                        jSONObject.put("keyword", naviParaOption.b);
                    } else {
                        jSONObject.put("keyword", "");
                    }
                    jSONObject.put("xy", String.valueOf(ll2mc.getLongitudeE6()) + "," + String.valueOf(ll2mc.getLatitudeE6()));
                    jSONArray.put(jSONObject);
                    jSONObject2.put("type", "1");
                    if (naviParaOption.d != null && !naviParaOption.d.equals("")) {
                        jSONObject.put("keyword", naviParaOption.d);
                    } else {
                        jSONObject.put("keyword", "");
                    }
                    jSONObject2.put("xy", String.valueOf(ll2mc2.getLongitudeE6()) + "," + String.valueOf(ll2mc2.getLatitudeE6()));
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
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
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setData(parse);
                context.startActivity(intent);
                return;
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapBikeNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption != null && context != null) {
            if (naviParaOption.c != null && naviParaOption.a != null) {
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 869) {
                        return b.a(naviParaOption, context, 8);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
                    return false;
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                return false;
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapWalkNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption != null && context != null) {
            if (naviParaOption.c != null && naviParaOption.a != null) {
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 869) {
                        return b.a(naviParaOption, context, 7);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
                    return false;
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                return false;
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapWalkNaviAR(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption != null && context != null) {
            if (naviParaOption.c != null && naviParaOption.a != null) {
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 869) {
                        return b.a(naviParaOption, context, 9);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
                    return false;
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                return false;
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    public static boolean openBaiduMapNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption != null && context != null) {
            if (naviParaOption.c != null && naviParaOption.a != null) {
                int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
                if (baiduMapVersion != 0) {
                    if (baiduMapVersion >= 830) {
                        return b.a(naviParaOption, context, 5);
                    }
                    Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.2");
                    if (a) {
                        a(naviParaOption, context);
                        return true;
                    }
                    throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.2");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a) {
                    a(naviParaOption, context);
                    return true;
                }
                throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: BaiduMap app is not installed.");
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }

    @Deprecated
    public static void openWebBaiduMapNavi(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        String str;
        if (naviParaOption != null && context != null) {
            LatLng latLng = naviParaOption.a;
            if (latLng != null && naviParaOption.c != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(naviParaOption.c);
                Uri parse = Uri.parse("http://daohang.map.baidu.com/mobile/#navi/naving/start=" + ll2mc.getLongitudeE6() + "," + ll2mc.getLatitudeE6() + "&endp=" + ll2mc2.getLongitudeE6() + "," + ll2mc2.getLatitudeE6() + "&fromprod=" + a(context) + "/vt=map&state=entry");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setData(parse);
                context.startActivity(intent);
                return;
            }
            String str2 = naviParaOption.b;
            if (str2 != null && !str2.equals("") && (str = naviParaOption.d) != null && !str.equals("")) {
                Uri parse2 = Uri.parse("http://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$" + naviParaOption.b + "$$$$$$&en=2$$$$$$" + naviParaOption.d + "$$$$$$&fromprod=" + a(context));
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.setData(parse2);
                context.startActivity(intent2);
                return;
            }
            throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point or set the start and end name.");
        }
        throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
    }
}
