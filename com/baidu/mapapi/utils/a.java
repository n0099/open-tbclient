package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static com.baidu.mapframework.open.aidl.a d;
    private static IComOpenClient e;
    private static int f;
    private static RouteParaOption.EBusStrategyType o;
    private static Thread v;
    private static final String c = a.class.getName();
    public static int a = -1;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static List<DispathcPoiData> j = new ArrayList();
    private static LatLng k = null;
    private static LatLng l = null;
    private static String m = null;
    private static String n = null;
    private static String p = null;
    private static String q = null;
    private static LatLng r = null;
    private static int s = 0;
    private static boolean t = false;
    private static boolean u = false;
    static ServiceConnection b = new c();

    public static String a() {
        return AppTools.getBaiduMapToken();
    }

    public static void a(int i2, Context context) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
                c(context, i2);
                return;
            case 3:
                c(context);
                return;
            case 4:
                d(context);
                return;
            case 5:
                e(context);
                return;
            case 6:
            default:
                return;
            case 7:
                f(context);
                return;
            case 8:
                g(context);
                return;
            case 9:
                h(context);
                return;
        }
    }

    public static void a(Context context) {
        if (u) {
            context.unbindService(b);
            u = false;
        }
    }

    private static void a(List<DispathcPoiData> list, Context context) {
        g = context.getPackageName();
        h = b(context);
        i = "";
        if (j != null) {
            j.clear();
        }
        for (DispathcPoiData dispathcPoiData : list) {
            j.add(dispathcPoiData);
        }
    }

    public static boolean a(int i2) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
                return g();
            case 3:
                return h();
            case 4:
                return m();
            case 5:
                return j();
            case 6:
                return i();
            case 7:
                return k();
            case 8:
                return l();
            default:
                return false;
        }
    }

    public static boolean a(Context context, int i2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!com.baidu.platform.comapi.a.a.a(context)) {
            Log.d(c, "package sign verify failed");
            return false;
        }
        t = false;
        switch (i2) {
            case 0:
                a = 0;
                break;
            case 1:
                a = 1;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                a = 3;
                break;
            case 4:
                a = 4;
                break;
            case 5:
                a = 5;
                break;
            case 6:
                a = 6;
                break;
            case 7:
                a = 7;
                break;
            case 8:
                a = 8;
                break;
            case 9:
                a = 9;
                break;
        }
        if (i2 == 9) {
            u = false;
        }
        if (d == null || !u) {
            b(context, i2);
        } else if (e != null) {
            t = true;
            return a(i2);
        } else {
            d.a(new b(i2));
        }
        return true;
    }

    public static boolean a(NaviParaOption naviParaOption, Context context, int i2) {
        b(naviParaOption, context, i2);
        return a(context, i2);
    }

    public static boolean a(PoiParaOption poiParaOption, Context context, int i2) {
        b(poiParaOption, context, i2);
        return a(context, i2);
    }

    public static boolean a(RouteParaOption routeParaOption, Context context, int i2) {
        b(routeParaOption, context, i2);
        return a(context, i2);
    }

    public static boolean a(List<DispathcPoiData> list, Context context, int i2) {
        a(list, context);
        return a(context, i2);
    }

    public static String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
            }
        } catch (PackageManager.NameNotFoundException e3) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    private static void b(Context context, int i2) {
        Intent intent = new Intent();
        String a2 = a();
        if (a2 == null) {
            return;
        }
        intent.putExtra("api_token", a2);
        intent.setAction("com.baidu.map.action.OPEN_SERVICE");
        intent.setPackage("com.baidu.BaiduMap");
        if (i2 != 9) {
            u = context.bindService(intent, b, 1);
        }
        if (!u) {
            Log.e("baidumapsdk", "bind service failed，call openapi");
            a(i2, context);
            return;
        }
        v = new Thread(new e(context, i2));
        v.setDaemon(true);
        v.start();
    }

    private static void b(NaviParaOption naviParaOption, Context context, int i2) {
        g = context.getPackageName();
        m = null;
        k = null;
        n = null;
        l = null;
        if (naviParaOption.getStartPoint() != null) {
            k = naviParaOption.getStartPoint();
        }
        if (naviParaOption.getEndPoint() != null) {
            l = naviParaOption.getEndPoint();
        }
        if (naviParaOption.getStartName() != null) {
            m = naviParaOption.getStartName();
        }
        if (naviParaOption.getEndName() != null) {
            n = naviParaOption.getEndName();
        }
    }

    private static void b(PoiParaOption poiParaOption, Context context, int i2) {
        p = null;
        q = null;
        r = null;
        s = 0;
        g = context.getPackageName();
        if (poiParaOption.getUid() != null) {
            p = poiParaOption.getUid();
        }
        if (poiParaOption.getKey() != null) {
            q = poiParaOption.getKey();
        }
        if (poiParaOption.getCenter() != null) {
            r = poiParaOption.getCenter();
        }
        if (poiParaOption.getRadius() != 0) {
            s = poiParaOption.getRadius();
        }
    }

    private static void b(RouteParaOption routeParaOption, Context context, int i2) {
        m = null;
        k = null;
        n = null;
        l = null;
        g = context.getPackageName();
        if (routeParaOption.getStartPoint() != null) {
            k = routeParaOption.getStartPoint();
        }
        if (routeParaOption.getEndPoint() != null) {
            l = routeParaOption.getEndPoint();
        }
        if (routeParaOption.getStartName() != null) {
            m = routeParaOption.getStartName();
        }
        if (routeParaOption.getEndName() != null) {
            n = routeParaOption.getEndName();
        }
        if (routeParaOption.getBusStrategyType() != null) {
            o = routeParaOption.getBusStrategyType();
        }
        switch (i2) {
            case 0:
                f = 0;
                return;
            case 1:
                f = 1;
                return;
            case 2:
                f = 2;
                return;
            default:
                return;
        }
    }

    private static void c(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/place/detail?");
        sb.append("uid=").append(p);
        sb.append("&show_type=").append("detail_page");
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void c(Context context, int i2) {
        if (v != null) {
            v.interrupt();
        }
        String[] strArr = {"driving", "transit", "walking"};
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/direction?");
        sb.append("origin=");
        if (k != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        if (!TextUtils.isEmpty(m) && k != null) {
            sb.append("name:").append(m).append("|latlng:").append(k.latitude).append(",").append(k.longitude);
        } else if (!TextUtils.isEmpty(m)) {
            sb.append(m);
        } else if (k != null) {
            sb.append(k.latitude).append(",").append(k.longitude);
        }
        sb.append("&destination=");
        if (l != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        if (!TextUtils.isEmpty(n) && l != null) {
            sb.append("name:").append(n).append("|latlng:").append(l.latitude).append(",").append(l.longitude);
        } else if (!TextUtils.isEmpty(n)) {
            sb.append(n);
        } else if (l != null) {
            sb.append(l.latitude).append(",").append(l.longitude);
        }
        sb.append("&mode=").append(strArr[i2]);
        sb.append("&target=").append("1");
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void d(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            r = CoordTrans.gcjToBaidu(r);
        }
        sb.append("center=").append(r.latitude).append(",").append(r.longitude);
        sb.append("&query=").append(q).append("&radius=").append(s);
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=").append(k.latitude).append(",").append(k.longitude);
        sb.append("&location=").append(l.latitude).append(",").append(l.longitude);
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void f(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=").append(k.latitude).append(",").append(k.longitude);
        sb.append("&destination=").append(l.latitude).append(",").append(l.longitude);
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void g(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=").append(k.latitude).append(",").append(k.longitude);
        sb.append("&destination=").append(l.latitude).append(",").append(l.longitude);
        sb.append("&src=").append("sdk_[" + g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static boolean g() {
        try {
            Log.d(c, "callDispatchTakeOutRoute");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(BaiduRimConstants.ACTION_TARGET, "route_search_page");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("route_type", f);
            bundle2.putInt("bus_strategy", o.ordinal());
            bundle2.putInt("cross_city_bus_strategy", 5);
            if (k != null) {
                bundle2.putInt("start_type", 1);
                bundle2.putInt("start_longitude", (int) CoordUtil.ll2mc(k).getLongitudeE6());
                bundle2.putInt("start_latitude", (int) CoordUtil.ll2mc(k).getLatitudeE6());
            } else {
                bundle2.putInt("start_type", 2);
                bundle2.putInt("start_longitude", 0);
                bundle2.putInt("start_latitude", 0);
            }
            if (m != null) {
                bundle2.putString("start_keyword", m);
            } else {
                bundle2.putString("start_keyword", "地图上的点");
            }
            bundle2.putString("start_uid", "");
            if (l != null) {
                bundle2.putInt("end_type", 1);
                bundle2.putInt("end_longitude", (int) CoordUtil.ll2mc(l).getLongitudeE6());
                bundle2.putInt("end_latitude", (int) CoordUtil.ll2mc(l).getLatitudeE6());
            } else {
                bundle2.putInt("end_type", 2);
                bundle2.putInt("end_longitude", 0);
                bundle2.putInt("end_latitude", 0);
            }
            if (n != null) {
                bundle2.putString("end_keyword", n);
            } else {
                bundle2.putString("end_keyword", "地图上的点");
            }
            bundle2.putString("end_uid", "");
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + g + "]");
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    private static void h(Context context) {
        if (v != null) {
            v.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=").append(k.latitude).append(",").append(k.longitude);
        sb.append("&destination=").append(l.latitude).append(",").append(l.longitude);
        sb.append("&mode=").append("walking_ar");
        sb.append("&src=").append("sdk_[" + g + "]");
        Log.e("test", sb.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static boolean h() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutPoiDetials");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BaiduRimConstants.ACTION_TARGET, "request_poi_detail_page");
        Bundle bundle2 = new Bundle();
        if (p != null) {
            bundle2.putString("uid", p);
        } else {
            bundle2.putString("uid", "");
        }
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + g + "]");
        bundle.putBundle("ext_params", bundle3);
        return e.a("map.android.baidu.mainmap", a2, bundle);
    }

    private static boolean i() {
        String a2;
        int i2;
        JSONException e2;
        if (j == null || j.size() <= 0) {
            return false;
        }
        try {
            Log.d(c, "callDispatchPoiToBaiduMap");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e3) {
            Log.d(c, "callDispatchPoiToBaiduMap exception", e3);
        }
        if (a2 == null) {
            Log.d(c, "callDispatchPoiToBaiduMap com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BaiduRimConstants.ACTION_TARGET, "favorite_page");
        Bundle bundle2 = new Bundle();
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        int i4 = 0;
        while (i3 < j.size()) {
            if (j.get(i3).name == null || j.get(i3).name.equals("")) {
                i2 = i4;
            } else if (j.get(i3).pt == null) {
                i2 = i4;
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", j.get(i3).name);
                    GeoPoint ll2mc = CoordUtil.ll2mc(j.get(i3).pt);
                    jSONObject.put("ptx", ll2mc.getLongitudeE6());
                    jSONObject.put("pty", ll2mc.getLatitudeE6());
                    jSONObject.put("addr", j.get(i3).addr);
                    jSONObject.put("uid", j.get(i3).uid);
                    i2 = i4 + 1;
                    try {
                        jSONArray.put(jSONObject);
                    } catch (JSONException e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        i3++;
                        i4 = i2;
                    }
                } catch (JSONException e5) {
                    i2 = i4;
                    e2 = e5;
                }
            }
            i3++;
            i4 = i2;
        }
        if (i4 == 0) {
            return false;
        }
        bundle2.putString("data", jSONArray.toString());
        bundle2.putString("from", h);
        bundle2.putString("pkg", g);
        bundle2.putString("cls", i);
        bundle2.putInt(Config.TRACE_VISIT_RECENT_COUNT, i4);
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + g + "]");
        bundle.putBundle("ext_params", bundle3);
        return e.a("map.android.baidu.mainmap", a2, bundle);
    }

    private static boolean j() {
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(BaiduRimConstants.ACTION_TARGET, "navigation_page");
            Bundle bundle2 = new Bundle();
            bundle2.putString("coord_type", "bd09ll");
            bundle2.putString("type", "DIS");
            StringBuffer stringBuffer = new StringBuffer();
            if (m != null) {
                stringBuffer.append("name:" + m + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                k = CoordTrans.gcjToBaidu(k);
            }
            stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
            StringBuffer stringBuffer2 = new StringBuffer();
            if (n != null) {
                stringBuffer2.append("name:" + n + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                l = CoordTrans.gcjToBaidu(l);
            }
            stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
            bundle2.putString("origin", stringBuffer.toString());
            bundle2.putString("destination", stringBuffer2.toString());
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + g + "]");
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    private static boolean k() {
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(BaiduRimConstants.ACTION_TARGET, "walknavi_page");
            Bundle bundle2 = new Bundle();
            bundle2.putString("coord_type", "bd09ll");
            StringBuffer stringBuffer = new StringBuffer();
            if (m != null) {
                stringBuffer.append("name:" + m + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                k = CoordTrans.gcjToBaidu(k);
            }
            stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
            StringBuffer stringBuffer2 = new StringBuffer();
            if (n != null) {
                stringBuffer2.append("name:" + n + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                l = CoordTrans.gcjToBaidu(l);
            }
            stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
            bundle2.putString("origin", stringBuffer.toString());
            bundle2.putString("destination", stringBuffer2.toString());
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + g + "]");
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (Exception e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    private static boolean l() {
        try {
            Log.d(c, "callDispatchTakeOutRouteRidingNavi");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(BaiduRimConstants.ACTION_TARGET, "bikenavi_page");
            Bundle bundle2 = new Bundle();
            bundle2.putString("coord_type", "bd09ll");
            StringBuffer stringBuffer = new StringBuffer();
            if (m != null) {
                stringBuffer.append("name:" + m + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                k = CoordTrans.gcjToBaidu(k);
            }
            stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
            StringBuffer stringBuffer2 = new StringBuffer();
            if (n != null) {
                stringBuffer2.append("name:" + n + "|");
            }
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                l = CoordTrans.gcjToBaidu(l);
            }
            stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
            bundle2.putString("origin", stringBuffer.toString());
            bundle2.putString("destination", stringBuffer2.toString());
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + g + "]");
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    private static boolean m() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutPoiNearbySearch");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BaiduRimConstants.ACTION_TARGET, "poi_search_page");
        Bundle bundle2 = new Bundle();
        if (q != null) {
            bundle2.putString("search_key", q);
        } else {
            bundle2.putString("search_key", "");
        }
        if (r != null) {
            bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(r).getLongitudeE6());
            bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(r).getLatitudeE6());
        } else {
            bundle2.putString("search_key", "");
        }
        if (s != 0) {
            bundle2.putInt("search_radius", s);
        } else {
            bundle2.putInt("search_radius", 1000);
        }
        bundle2.putBoolean("is_direct_search", true);
        bundle2.putBoolean("is_direct_area_search", true);
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + g + "]");
        bundle.putBundle("ext_params", bundle3);
        return e.a("map.android.baidu.mainmap", a2, bundle);
    }
}
