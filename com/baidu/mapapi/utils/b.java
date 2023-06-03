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
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.navi.TruckNaviOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static double A = 0.0d;
    public static double B = 0.0d;
    public static double C = 0.0d;
    public static double D = 0.0d;
    public static int E = 0;
    public static boolean F = false;
    public static String G = null;
    public static int H = 0;
    public static int I = 0;
    public static int J = 0;
    public static int K = 0;
    public static int L = 0;
    public static int a = -1;
    public static final String c = "com.baidu.mapapi.utils.b";
    public static com.baidu.mapframework.open.aidl.a d;
    public static IComOpenClient e;
    public static int f;
    public static String g;
    public static String h;
    public static String i;
    public static String p;
    public static RouteParaOption.EBusStrategyType q;
    public static Thread x;
    public static int y;
    public static double z;
    public static List<DispathcPoiData> j = new ArrayList();
    public static LatLng k = null;
    public static LatLng l = null;
    public static String m = null;
    public static String n = null;
    public static String o = null;
    public static String r = null;
    public static String s = null;
    public static LatLng t = null;
    public static int u = 0;
    public static boolean v = false;
    public static boolean w = false;
    public static ServiceConnection b = new d();

    public static String a() {
        return AppTools.getBaiduMapToken();
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

    public static void a(int i2, Context context) {
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 != 7) {
                            if (i2 != 8) {
                                if (i2 != 9) {
                                    switch (i2) {
                                        case 101:
                                        case 102:
                                            break;
                                        case 103:
                                            f(context);
                                            return;
                                        case 104:
                                            g(context);
                                            return;
                                        default:
                                            return;
                                    }
                                } else {
                                    j(context);
                                    return;
                                }
                            } else {
                                i(context);
                                return;
                            }
                        } else {
                            h(context);
                            return;
                        }
                    } else {
                        e(context);
                        return;
                    }
                } else {
                    d(context);
                    return;
                }
            } else {
                c(context);
                return;
            }
        }
        c(context, i2);
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
            w = context.bindService(intent, b, 1);
        }
        if (w) {
            Thread thread = new Thread(new f(context, i2));
            x = thread;
            thread.setDaemon(true);
            x.start();
            return;
        }
        Log.e("baidumapsdk", "bind service failed，call openapi");
        a(i2, context);
    }

    public static void a(Context context) {
        if (w) {
            context.unbindService(b);
            w = false;
        }
    }

    public static void a(TruckNaviOption truckNaviOption) {
        y = 0;
        z = 0.0d;
        A = 0.0d;
        B = 0.0d;
        C = 0.0d;
        D = 0.0d;
        E = 0;
        F = false;
        G = null;
        H = 0;
        I = 0;
        J = 0;
        K = 0;
        L = 0;
        if (truckNaviOption.getNaviRoutePolicy() != null) {
            p = truckNaviOption.getNaviRoutePolicy();
        }
        JSONArray wayPoint = truckNaviOption.getWayPoint();
        if (wayPoint != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viaPoints", wayPoint);
                try {
                    o = URLEncoder.encode(jSONObject.toString(), "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        y = truckNaviOption.getTruckType();
        z = truckNaviOption.getHeight();
        A = truckNaviOption.getWidth();
        B = truckNaviOption.getWeight();
        C = truckNaviOption.getLength();
        D = truckNaviOption.getAxleWeight();
        E = truckNaviOption.getAxleCount();
        F = truckNaviOption.getIsTrailer();
        G = truckNaviOption.getPlateNumber();
        H = truckNaviOption.getPlateColor();
        I = truckNaviOption.getDisplacement();
        J = truckNaviOption.getPowerType();
        K = truckNaviOption.getEmissionLimit();
        L = truckNaviOption.getLoadWeight();
    }

    public static void e(Context context) {
        Thread thread = x;
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
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        if (!TextUtils.isEmpty(o)) {
            sb.append("&viaPoints=");
            sb.append(o);
        }
        sb.append("&type=");
        sb.append(p);
        sb.append("&mode=");
        sb.append("driving");
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public static void f(Context context) {
        Thread thread = x;
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
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        if (!TextUtils.isEmpty(o)) {
            sb.append("&viaPoints=");
            sb.append(o);
        }
        sb.append("&type=");
        sb.append(p);
        sb.append("&mode=");
        sb.append("neweng");
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public static void h(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        if (k != null && l != null) {
            sb.append("origin=");
            sb.append(k.latitude);
            sb.append(",");
            sb.append(k.longitude);
            sb.append("&destination=");
            sb.append(l.latitude);
            sb.append(",");
            sb.append(l.longitude);
            sb.append("&src=");
            sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public static void i(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        if (k != null && l != null) {
            sb.append("origin=");
            sb.append(k.latitude);
            sb.append(",");
            sb.append(k.longitude);
            sb.append("&destination=");
            sb.append(l.latitude);
            sb.append(",");
            sb.append(l.longitude);
            sb.append("&src=");
            sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public static void j(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
            l = CoordTrans.gcjToBaidu(l);
        }
        if (k != null && l != null) {
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
            sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            Log.e(DebugActiveUploadResult.SOURCE, sb.toString());
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public static void a(List<DispathcPoiData> list, Context context) {
        g = context.getPackageName();
        h = b(context);
        i = "";
        List<DispathcPoiData> list2 = j;
        if (list2 != null) {
            list2.clear();
        }
        for (DispathcPoiData dispathcPoiData : list) {
            j.add(dispathcPoiData);
        }
    }

    public static boolean a(int i2) {
        if (i2 != 101 && i2 != 102) {
            switch (i2) {
                case 0:
                case 1:
                case 2:
                    break;
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
        return g();
    }

    public static boolean a(Context context, int i2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!com.baidu.platform.comapi.d.a.a(context)) {
            Log.d(c, "package sign verify failed");
            return false;
        }
        v = false;
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
            default:
                switch (i2) {
                    case 101:
                        a = 101;
                        break;
                    case 102:
                        a = 102;
                        break;
                    case 103:
                        a = 103;
                        break;
                    case 104:
                        a = 104;
                        break;
                }
        }
        if (i2 == 9) {
            w = false;
        }
        if (d != null && w) {
            if (e != null) {
                v = true;
                return a(i2);
            }
            d.a(new c(i2));
        } else {
            b(context, i2);
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

    public static void b(NaviParaOption naviParaOption, Context context, int i2) {
        g = context.getPackageName();
        m = null;
        k = null;
        n = null;
        l = null;
        o = null;
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
        if (naviParaOption.getNaviRoutePolicy() != null) {
            p = naviParaOption.getNaviRoutePolicy();
        }
        JSONArray wayPoint = naviParaOption.getWayPoint();
        if (wayPoint != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viaPoints", wayPoint);
                try {
                    o = URLEncoder.encode(jSONObject.toString(), "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (naviParaOption instanceof TruckNaviOption) {
            a((TruckNaviOption) naviParaOption);
        }
    }

    public static void b(PoiParaOption poiParaOption, Context context, int i2) {
        r = null;
        s = null;
        t = null;
        u = 0;
        g = context.getPackageName();
        if (poiParaOption.getUid() != null) {
            r = poiParaOption.getUid();
        }
        if (poiParaOption.getKey() != null) {
            s = poiParaOption.getKey();
        }
        if (poiParaOption.getCenter() != null) {
            t = poiParaOption.getCenter();
        }
        if (poiParaOption.getRadius() != 0) {
            u = poiParaOption.getRadius();
        }
    }

    public static void b(RouteParaOption routeParaOption, Context context, int i2) {
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
            q = routeParaOption.getBusStrategyType();
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 101) {
                        if (i2 == 102) {
                            f = 102;
                            return;
                        }
                        return;
                    }
                    f = 101;
                    return;
                }
                f = 2;
                return;
            }
            f = 1;
            return;
        }
        f = 0;
    }

    public static void c(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/place/detail?");
        sb.append("uid=");
        sb.append(r);
        sb.append("&show_type=");
        sb.append("detail_page");
        sb.append("&src=");
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public static void c(Context context, int i2) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        if (i2 == 101) {
            i2 = 3;
        }
        if (i2 == 102) {
            i2 = 4;
        }
        String[] strArr = {"driving", "transit", "walking", "neweng", "truck"};
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/direction?");
        sb.append("origin=");
        if (k != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        if (!TextUtils.isEmpty(m) && k != null) {
            sb.append("name:");
            sb.append(m);
            sb.append("|latlng:");
            sb.append(k.latitude);
            sb.append(",");
            sb.append(k.longitude);
        } else if (!TextUtils.isEmpty(m)) {
            sb.append(m);
        } else {
            LatLng latLng = k;
            if (latLng != null) {
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(k.longitude);
            }
        }
        sb.append("&destination=");
        if (l != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        if (!TextUtils.isEmpty(n) && l != null) {
            sb.append("name:");
            sb.append(n);
            sb.append("|latlng:");
            sb.append(l.latitude);
            sb.append(",");
            sb.append(l.longitude);
        } else if (!TextUtils.isEmpty(n)) {
            sb.append(n);
        } else {
            LatLng latLng2 = l;
            if (latLng2 != null) {
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(l.longitude);
            }
        }
        sb.append("&mode=");
        sb.append(strArr[i2]);
        sb.append("&target=");
        sb.append("1");
        sb.append("&src=");
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public static void d(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            t = CoordTrans.gcjToBaidu(t);
        }
        sb.append("center=");
        sb.append(t.latitude);
        sb.append(",");
        sb.append(t.longitude);
        sb.append("&query=");
        sb.append(s);
        sb.append("&radius=");
        sb.append(u);
        sb.append("&src=");
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        context.startActivity(intent);
    }

    public static void g(Context context) {
        Thread thread = x;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/truck/navigation?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            l = CoordTrans.gcjToBaidu(l);
        }
        sb.append("location=");
        sb.append(l.latitude);
        sb.append(",");
        sb.append(l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
        if (!TextUtils.isEmpty(o)) {
            sb.append("&viaPoints=");
            sb.append(o);
        }
        sb.append("&type=");
        sb.append(p);
        int i2 = y;
        if (i2 > 0 && i2 <= 4) {
            sb.append("&truck_type=");
            sb.append(y);
            double d2 = z;
            if (d2 > 0.0d && d2 <= 10.0d) {
                sb.append("&height=");
                sb.append(z);
                double d3 = A;
                if (d3 > 0.0d && d3 <= 5.0d) {
                    sb.append("&width=");
                    sb.append(A);
                    double d4 = B;
                    if (d4 > 0.0d && d4 <= 100.0d) {
                        sb.append("&weight=");
                        sb.append(B);
                        double d5 = C;
                        if (d5 > 0.0d && d5 <= 25.0d) {
                            sb.append("&length=");
                            sb.append(C);
                            double d6 = D;
                            if (d6 >= 0.0d && d6 <= 100.0d) {
                                sb.append("&axle_weight=");
                                sb.append(D);
                            }
                            int i3 = E;
                            if (i3 > 1 && i3 <= 8) {
                                sb.append("&axle_count=");
                                sb.append(E);
                                if (F) {
                                    sb.append("&is_trailer=");
                                    sb.append(1);
                                } else {
                                    sb.append("&is_trailer=");
                                    sb.append(0);
                                }
                                if (!TextUtils.isEmpty(G)) {
                                    if (G.length() != 7 && G.length() != 8) {
                                        throw new IllegalArgumentException("BDMapSDKException: plateNumber error Please fill in the correct license plate");
                                    }
                                    sb.append("&plate_number=");
                                    sb.append(G);
                                    int i4 = H;
                                    if (i4 >= 0 && i4 <= 4) {
                                        sb.append("&plate_color=");
                                        sb.append(H);
                                    }
                                    if (I > 0) {
                                        sb.append("&displacement=");
                                        sb.append(I);
                                    }
                                    int i5 = J;
                                    if (i5 > 0 && i5 <= 4) {
                                        sb.append("&power_type=");
                                        sb.append(J);
                                        int i6 = K;
                                        if (i6 >= 0 && i6 <= 6) {
                                            sb.append("&emission_limit=");
                                            sb.append(K);
                                            int i7 = L;
                                            if (i7 > 0 && i7 <= 100) {
                                                sb.append("&load_weight=");
                                                sb.append(L);
                                                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(sb.toString()));
                                                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                                                context.startActivity(intent);
                                                return;
                                            }
                                            throw new IllegalArgumentException("BDMapSDKException: loadWeight Must be between 1 and 100");
                                        }
                                        throw new IllegalArgumentException("BDMapSDKException: emissionLimit Must be between 0 and 6");
                                    }
                                    throw new IllegalArgumentException("BDMapSDKException: powerType Must be between 1 and 4");
                                }
                                throw new IllegalArgumentException("BDMapSDKException: plateNumber Can not be null");
                            }
                            throw new IllegalArgumentException("BDMapSDKException: axleCount Must be between 2 and 8");
                        }
                        throw new IllegalArgumentException("BDMapSDKException: length Must be between 1 and 25");
                    }
                    throw new IllegalArgumentException("BDMapSDKException: weight Must be between 1 and 100");
                }
                throw new IllegalArgumentException("BDMapSDKException: width Must be between 1 and 5");
            }
            throw new IllegalArgumentException("BDMapSDKException: height Must be between 1 and 10");
        }
        throw new IllegalArgumentException("BDMapSDKException: truckType Must be between 1 and 4");
    }

    public static boolean g() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutRoute");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("target", "route_search_page");
            Bundle bundle2 = new Bundle();
            if (f == 102) {
                f = 7;
            }
            bundle2.putInt("route_type", f);
            bundle2.putInt("bus_strategy", q.ordinal());
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
            bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        }
        Log.d(c, "callDispatchTakeOut com not found");
        return false;
    }

    public static boolean k() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (Exception e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("target", "walknavi_page");
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
            bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        }
        Log.d(c, "callDispatchTakeOut com not found");
        return false;
    }

    public static boolean l() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutRouteRidingNavi");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("target", "bikenavi_page");
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
            bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        }
        Log.d(c, "callDispatchTakeOut com not found");
        return false;
    }

    public static boolean h() {
        try {
            Log.d(c, "callDispatchTakeOutPoiDetials");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("target", "request_poi_detail_page");
                Bundle bundle2 = new Bundle();
                if (r != null) {
                    bundle2.putString("uid", r);
                } else {
                    bundle2.putString("uid", "");
                }
                bundle.putBundle("base_params", bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
                bundle.putBundle("ext_params", bundle3);
                return e.a("map.android.baidu.mainmap", a2, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    public static boolean i() {
        List<DispathcPoiData> list = j;
        if (list != null && list.size() > 0) {
            try {
                Log.d(c, "callDispatchPoiToBaiduMap");
                String a2 = e.a("map.android.baidu.mainmap");
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
                                jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, ll2mc.getLongitudeE6());
                                jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, ll2mc.getLatitudeE6());
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
                    bundle2.putString("from", h);
                    bundle2.putString("pkg", g);
                    bundle2.putString("cls", i);
                    bundle2.putInt("count", i2);
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return e.a("map.android.baidu.mainmap", a2, bundle);
                }
                Log.d(c, "callDispatchPoiToBaiduMap com not found");
            } catch (RemoteException e3) {
                Log.d(c, "callDispatchPoiToBaiduMap exception", e3);
            }
        }
        return false;
    }

    public static boolean j() {
        String a2;
        try {
            Log.d(c, "callDispatchTakeOutRouteNavi");
            a2 = e.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
        }
        if (a2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("target", "navigation_page");
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
            if (!TextUtils.isEmpty(o)) {
                bundle2.putString("viaPoints", o);
            }
            if (!TextUtils.isEmpty(p)) {
                bundle2.putString("type", p);
            }
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
            bundle.putBundle("ext_params", bundle3);
            return e.a("map.android.baidu.mainmap", a2, bundle);
        }
        Log.d(c, "callDispatchTakeOut com not found");
        return false;
    }

    public static boolean m() {
        try {
            Log.d(c, "callDispatchTakeOutPoiNearbySearch");
            String a2 = e.a("map.android.baidu.mainmap");
            if (a2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("target", "poi_search_page");
                Bundle bundle2 = new Bundle();
                if (s != null) {
                    bundle2.putString("search_key", s);
                } else {
                    bundle2.putString("search_key", "");
                }
                if (t != null) {
                    bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(t).getLongitudeE6());
                    bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(t).getLatitudeE6());
                } else {
                    bundle2.putString("search_key", "");
                }
                if (u != 0) {
                    bundle2.putInt("search_radius", u);
                } else {
                    bundle2.putInt("search_radius", 1000);
                }
                bundle2.putBoolean("is_direct_search", true);
                bundle2.putBoolean("is_direct_area_search", true);
                bundle.putBundle("base_params", bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString("launch_from", "sdk_[" + g + PreferencesUtil.RIGHT_MOUNT);
                bundle.putBundle("ext_params", bundle3);
                return e.a("map.android.baidu.mainmap", a2, bundle);
            }
            Log.d(c, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e2) {
            Log.d(c, "callDispatchTakeOut exception", e2);
            return false;
        }
    }
}
