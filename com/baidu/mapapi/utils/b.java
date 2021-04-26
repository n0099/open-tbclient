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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
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
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f7693a = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final String f7695c = "com.baidu.mapapi.utils.b";

    /* renamed from: d  reason: collision with root package name */
    public static com.baidu.mapframework.open.aidl.a f7696d;

    /* renamed from: e  reason: collision with root package name */
    public static IComOpenClient f7697e;

    /* renamed from: f  reason: collision with root package name */
    public static int f7698f;

    /* renamed from: g  reason: collision with root package name */
    public static String f7699g;

    /* renamed from: h  reason: collision with root package name */
    public static String f7700h;

    /* renamed from: i  reason: collision with root package name */
    public static String f7701i;
    public static RouteParaOption.EBusStrategyType o;
    public static Thread v;
    public static List<DispathcPoiData> j = new ArrayList();
    public static LatLng k = null;
    public static LatLng l = null;
    public static String m = null;
    public static String n = null;
    public static String p = null;
    public static String q = null;
    public static LatLng r = null;
    public static int s = 0;
    public static boolean t = false;
    public static boolean u = false;

    /* renamed from: b  reason: collision with root package name */
    public static ServiceConnection f7694b = new d();

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
            context.unbindService(f7694b);
            u = false;
        }
    }

    public static void a(List<DispathcPoiData> list, Context context) {
        f7699g = context.getPackageName();
        f7700h = b(context);
        f7701i = "";
        List<DispathcPoiData> list2 = j;
        if (list2 != null) {
            list2.clear();
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
            Log.d(f7695c, "package sign verify failed");
            return false;
        }
        t = false;
        switch (i2) {
            case 0:
                f7693a = 0;
                break;
            case 1:
                f7693a = 1;
                break;
            case 2:
                f7693a = 2;
                break;
            case 3:
                f7693a = 3;
                break;
            case 4:
                f7693a = 4;
                break;
            case 5:
                f7693a = 5;
                break;
            case 6:
                f7693a = 6;
                break;
            case 7:
                f7693a = 7;
                break;
            case 8:
                f7693a = 8;
                break;
            case 9:
                f7693a = 9;
                break;
        }
        if (i2 == 9) {
            u = false;
        }
        if (f7696d == null || !u) {
            b(context, i2);
        } else if (f7697e != null) {
            t = true;
            return a(i2);
        } else {
            f7696d.a(new c(i2));
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
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static void b(Context context, int i2) {
        Intent intent = new Intent();
        String a2 = a();
        if (a2 == null) {
            return;
        }
        intent.putExtra("api_token", a2);
        intent.setAction("com.baidu.map.action.OPEN_SERVICE");
        intent.setPackage("com.baidu.BaiduMap");
        if (i2 != 9) {
            u = context.bindService(intent, f7694b, 1);
        }
        if (!u) {
            Log.e("baidumapsdk", "bind service failed，call openapi");
            a(i2, context);
            return;
        }
        Thread thread = new Thread(new f(context, i2));
        v = thread;
        thread.setDaemon(true);
        v.start();
    }

    public static void b(NaviParaOption naviParaOption, Context context, int i2) {
        f7699g = context.getPackageName();
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

    public static void b(PoiParaOption poiParaOption, Context context, int i2) {
        p = null;
        q = null;
        r = null;
        s = 0;
        f7699g = context.getPackageName();
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

    public static void b(RouteParaOption routeParaOption, Context context, int i2) {
        int i3;
        m = null;
        k = null;
        n = null;
        l = null;
        f7699g = context.getPackageName();
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
        if (i2 != 0) {
            i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    return;
                }
            }
        } else {
            i3 = 0;
        }
        f7698f = i3;
    }

    public static void c(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/place/detail?");
        sb.append("uid=");
        sb.append(p);
        sb.append("&show_type=");
        sb.append("detail_page");
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, int i2) {
        LatLng latLng;
        LatLng latLng2;
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        String[] strArr = {"driving", "transit", "walking"};
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/direction?");
        sb.append("origin=");
        if (k != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        if (TextUtils.isEmpty(m) || k == null) {
            if (TextUtils.isEmpty(m)) {
                latLng = k;
            } else {
                sb.append(m);
            }
            sb.append("&destination=");
            if (l != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
                l = CoordTrans.gcjToBaidu(l);
            }
            if (!TextUtils.isEmpty(n) || l == null) {
                if (TextUtils.isEmpty(n)) {
                    sb.append(n);
                } else {
                    latLng2 = l;
                }
                sb.append("&mode=");
                sb.append(strArr[i2]);
                sb.append("&target=");
                sb.append("1");
                sb.append("&src=");
                sb.append("sdk_[" + f7699g + "]");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                context.startActivity(intent);
            }
            sb.append("name:");
            sb.append(n);
            sb.append("|latlng:");
            latLng2 = l;
            sb.append(latLng2.latitude);
            sb.append(",");
            sb.append(l.longitude);
            sb.append("&mode=");
            sb.append(strArr[i2]);
            sb.append("&target=");
            sb.append("1");
            sb.append("&src=");
            sb.append("sdk_[" + f7699g + "]");
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent2);
        }
        sb.append("name:");
        sb.append(m);
        sb.append("|latlng:");
        latLng = k;
        sb.append(latLng.latitude);
        sb.append(",");
        sb.append(k.longitude);
        sb.append("&destination=");
        if (l != null) {
            l = CoordTrans.gcjToBaidu(l);
        }
        if (TextUtils.isEmpty(n)) {
        }
        if (TextUtils.isEmpty(n)) {
        }
        sb.append("&mode=");
        sb.append(strArr[i2]);
        sb.append("&target=");
        sb.append("1");
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent22 = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent22.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent22);
    }

    public static void d(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            r = CoordTrans.gcjToBaidu(r);
        }
        sb.append("center=");
        sb.append(r.latitude);
        sb.append(",");
        sb.append(r.longitude);
        sb.append("&query=");
        sb.append(q);
        sb.append("&radius=");
        sb.append(s);
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static void e(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        sb.append("&location=");
        sb.append(l.latitude);
        sb.append(",");
        sb.append(l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static void f(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        sb.append("&destination=");
        sb.append(l.latitude);
        sb.append(",");
        sb.append(l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static void g(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        sb.append("&destination=");
        sb.append(l.latitude);
        sb.append(",");
        sb.append(l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static boolean g() {
        String a2;
        try {
            Log.d(f7695c, "callDispatchTakeOutRoute");
            a2 = f7697e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(f7695c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "route_search_page");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("route_type", f7698f);
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
        bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f7697e.a("map.android.baidu.mainmap", a2, bundle);
    }

    public static void h(Context context) {
        Thread thread = v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("origin=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        sb.append("&destination=");
        sb.append(l.latitude);
        sb.append(",");
        sb.append(l.longitude);
        sb.append("&mode=");
        sb.append("walking_ar");
        sb.append("&src=");
        sb.append("sdk_[" + f7699g + "]");
        Log.e("test", sb.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public static boolean h() {
        try {
            Log.d(f7695c, "callDispatchTakeOutPoiDetials");
            String a2 = f7697e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(f7695c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("target", "request_poi_detail_page");
            Bundle bundle2 = new Bundle();
            bundle2.putString("uid", p != null ? p : "");
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
            bundle.putBundle("ext_params", bundle3);
            return f7697e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (RemoteException e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    public static boolean i() {
        List<DispathcPoiData> list = j;
        if (list != null && list.size() > 0) {
            try {
                Log.d(f7695c, "callDispatchPoiToBaiduMap");
                String a2 = f7697e.a("map.android.baidu.mainmap");
                if (a2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("target", "favorite_page");
                    Bundle bundle2 = new Bundle();
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 0;
                    for (int i3 = 0; i3 < j.size(); i3++) {
                        if (j.get(i3).name != null && !j.get(i3).name.equals("") && j.get(i3).pt != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("name", j.get(i3).name);
                                GeoPoint ll2mc = CoordUtil.ll2mc(j.get(i3).pt);
                                jSONObject.put("ptx", ll2mc.getLongitudeE6());
                                jSONObject.put("pty", ll2mc.getLatitudeE6());
                                jSONObject.put(DuPaBInfoMsg.B_ADDR, j.get(i3).addr);
                                jSONObject.put("uid", j.get(i3).uid);
                                i2++;
                                jSONArray.put(jSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (i2 == 0) {
                        return false;
                    }
                    bundle2.putString("data", jSONArray.toString());
                    bundle2.putString("from", f7700h);
                    bundle2.putString("pkg", f7699g);
                    bundle2.putString("cls", f7701i);
                    bundle2.putInt("count", i2);
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
                    bundle.putBundle("ext_params", bundle3);
                    return f7697e.a("map.android.baidu.mainmap", a2, bundle);
                }
                Log.d(f7695c, "callDispatchPoiToBaiduMap com not found");
            } catch (RemoteException e3) {
                Log.d(f7695c, "callDispatchPoiToBaiduMap exception", e3);
            }
        }
        return false;
    }

    public static boolean j() {
        String a2;
        try {
            Log.d(f7695c, "callDispatchTakeOutRouteNavi");
            a2 = f7697e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(f7695c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "navigation_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        bundle2.putString("type", "DIS");
        StringBuffer stringBuffer = new StringBuffer();
        if (m != null) {
            stringBuffer.append("name:" + m + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (n != null) {
            stringBuffer2.append("name:" + n + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString("destination", stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f7697e.a("map.android.baidu.mainmap", a2, bundle);
    }

    public static boolean k() {
        String a2;
        try {
            Log.d(f7695c, "callDispatchTakeOutRouteNavi");
            a2 = f7697e.a("map.android.baidu.mainmap");
        } catch (Exception e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(f7695c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "walknavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (m != null) {
            stringBuffer.append("name:" + m + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (n != null) {
            stringBuffer2.append("name:" + n + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString("destination", stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f7697e.a("map.android.baidu.mainmap", a2, bundle);
    }

    public static boolean l() {
        String a2;
        try {
            Log.d(f7695c, "callDispatchTakeOutRouteRidingNavi");
            a2 = f7697e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
        }
        if (a2 == null) {
            Log.d(f7695c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "bikenavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (m != null) {
            stringBuffer.append("name:" + m + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (n != null) {
            stringBuffer2.append("name:" + n + FieldBuilder.SE);
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(l.latitude), Double.valueOf(l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString("destination", stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f7697e.a("map.android.baidu.mainmap", a2, bundle);
    }

    public static boolean m() {
        try {
            Log.d(f7695c, "callDispatchTakeOutPoiNearbySearch");
            String a2 = f7697e.a("map.android.baidu.mainmap");
            if (a2 == null) {
                Log.d(f7695c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("target", "poi_search_page");
            Bundle bundle2 = new Bundle();
            if (q != null) {
                bundle2.putString(SearchFriendActivity.HTTP_PARAMS_SEARCH_KEY, q);
            } else {
                bundle2.putString(SearchFriendActivity.HTTP_PARAMS_SEARCH_KEY, "");
            }
            if (r != null) {
                bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(r).getLongitudeE6());
                bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(r).getLatitudeE6());
            } else {
                bundle2.putString(SearchFriendActivity.HTTP_PARAMS_SEARCH_KEY, "");
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
            bundle3.putString("launch_from", "sdk_[" + f7699g + "]");
            bundle.putBundle("ext_params", bundle3);
            return f7697e.a("map.android.baidu.mainmap", a2, bundle);
        } catch (RemoteException e2) {
            Log.d(f7695c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }
}
