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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static ServiceConnection f35703b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f35704c = "com.baidu.mapapi.utils.b";

    /* renamed from: d  reason: collision with root package name */
    public static com.baidu.mapframework.open.aidl.a f35705d;

    /* renamed from: e  reason: collision with root package name */
    public static IComOpenClient f35706e;

    /* renamed from: f  reason: collision with root package name */
    public static int f35707f;

    /* renamed from: g  reason: collision with root package name */
    public static String f35708g;

    /* renamed from: h  reason: collision with root package name */
    public static String f35709h;

    /* renamed from: i  reason: collision with root package name */
    public static String f35710i;

    /* renamed from: j  reason: collision with root package name */
    public static List<DispathcPoiData> f35711j;
    public static LatLng k;
    public static LatLng l;
    public static String m;
    public static String n;
    public static RouteParaOption.EBusStrategyType o;
    public static String p;
    public static String q;
    public static LatLng r;
    public static int s;
    public static boolean t;
    public static boolean u;
    public static Thread v;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(286916890, "Lcom/baidu/mapapi/utils/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(286916890, "Lcom/baidu/mapapi/utils/b;");
                return;
            }
        }
        f35711j = new ArrayList();
        k = null;
        l = null;
        m = null;
        n = null;
        p = null;
        q = null;
        r = null;
        s = 0;
        t = false;
        u = false;
        f35703b = new d();
    }

    public b() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? AppTools.getBaiduMapToken() : (String) invokeV.objValue;
    }

    public static void a(int i2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i2, context) == null) {
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
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, context) == null) && u) {
            context.unbindService(f35703b);
            u = false;
        }
    }

    public static void a(List<DispathcPoiData> list, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, list, context) == null) {
            f35708g = context.getPackageName();
            f35709h = b(context);
            f35710i = "";
            List<DispathcPoiData> list2 = f35711j;
            if (list2 != null) {
                list2.clear();
            }
            for (DispathcPoiData dispathcPoiData : list) {
                f35711j.add(dispathcPoiData);
            }
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
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
        return invokeI.booleanValue;
    }

    public static boolean a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (com.baidu.platform.comapi.a.a.a(context)) {
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
                if (f35705d == null || !u) {
                    b(context, i2);
                } else if (f35706e != null) {
                    t = true;
                    return a(i2);
                } else {
                    f35705d.a(new c(i2));
                }
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean a(NaviParaOption naviParaOption, Context context, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, naviParaOption, context, i2)) == null) {
            b(naviParaOption, context, i2);
            return a(context, i2);
        }
        return invokeLLI.booleanValue;
    }

    public static boolean a(PoiParaOption poiParaOption, Context context, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, poiParaOption, context, i2)) == null) {
            b(poiParaOption, context, i2);
            return a(context, i2);
        }
        return invokeLLI.booleanValue;
    }

    public static boolean a(RouteParaOption routeParaOption, Context context, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65548, null, routeParaOption, context, i2)) == null) {
            b(routeParaOption, context, i2);
            return a(context, i2);
        }
        return invokeLLI.booleanValue;
    }

    public static boolean a(List<DispathcPoiData> list, Context context, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, null, list, context, i2)) == null) {
            a(list, context);
            return a(context, i2);
        }
        return invokeLLI.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, context, i2) == null) {
            Intent intent = new Intent();
            String a2 = a();
            if (a2 == null) {
                return;
            }
            intent.putExtra("api_token", a2);
            intent.setAction("com.baidu.map.action.OPEN_SERVICE");
            intent.setPackage("com.baidu.BaiduMap");
            if (i2 != 9) {
                u = context.bindService(intent, f35703b, 1);
            }
            if (!u) {
                a(i2, context);
                return;
            }
            Thread thread = new Thread(new f(context, i2));
            v = thread;
            thread.setDaemon(true);
            v.start();
        }
    }

    public static void b(NaviParaOption naviParaOption, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, null, naviParaOption, context, i2) == null) {
            f35708g = context.getPackageName();
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
    }

    public static void b(PoiParaOption poiParaOption, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, poiParaOption, context, i2) == null) {
            p = null;
            q = null;
            r = null;
            s = 0;
            f35708g = context.getPackageName();
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
    }

    public static void b(RouteParaOption routeParaOption, Context context, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65556, null, routeParaOption, context, i2) == null) {
            m = null;
            k = null;
            n = null;
            l = null;
            f35708g = context.getPackageName();
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
            f35707f = i3;
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r2 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ce, code lost:
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, int i2) {
        LatLng latLng;
        LatLng latLng2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65560, null, context, i2) == null) {
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
                    sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                    intent.setFlags(268435456);
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
                sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                intent2.setFlags(268435456);
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent22 = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent22.setFlags(268435456);
            context.startActivity(intent22);
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
                if (a2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("target", "route_search_page");
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("route_type", f35707f);
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
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
            } catch (RemoteException unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, context) == null) {
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
            sb.append("sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
            sb.toString();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
                if (a2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("target", "request_poi_detail_page");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("uid", p != null ? p : "");
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
                return false;
            } catch (RemoteException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            List<DispathcPoiData> list = f35711j;
            if (list != null && list.size() > 0) {
                try {
                    String a2 = f35706e.a("map.android.baidu.mainmap");
                    if (a2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("target", "favorite_page");
                        Bundle bundle2 = new Bundle();
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        for (int i3 = 0; i3 < f35711j.size(); i3++) {
                            if (f35711j.get(i3).name != null && !f35711j.get(i3).name.equals("") && f35711j.get(i3).pt != null) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("name", f35711j.get(i3).name);
                                    GeoPoint ll2mc = CoordUtil.ll2mc(f35711j.get(i3).pt);
                                    jSONObject.put("ptx", ll2mc.getLongitudeE6());
                                    jSONObject.put("pty", ll2mc.getLatitudeE6());
                                    jSONObject.put(DuPaBInfoMsg.B_ADDR, f35711j.get(i3).addr);
                                    jSONObject.put("uid", f35711j.get(i3).uid);
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
                        bundle2.putString("from", f35709h);
                        bundle2.putString("pkg", f35708g);
                        bundle2.putString("cls", f35710i);
                        bundle2.putInt("count", i2);
                        bundle.putBundle("base_params", bundle2);
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                        bundle.putBundle("ext_params", bundle3);
                        return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                    }
                } catch (RemoteException unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
                if (a2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("target", "navigation_page");
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
                    bundle2.putString(FilterValue.DEFAULT_FILTER_VALUE, stringBuffer.toString());
                    bundle2.putString("destination", stringBuffer2.toString());
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
            } catch (RemoteException unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
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
                    bundle2.putString(FilterValue.DEFAULT_FILTER_VALUE, stringBuffer.toString());
                    bundle2.putString("destination", stringBuffer2.toString());
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
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
                    bundle2.putString(FilterValue.DEFAULT_FILTER_VALUE, stringBuffer.toString());
                    bundle2.putString("destination", stringBuffer2.toString());
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
            } catch (RemoteException unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                String a2 = f35706e.a("map.android.baidu.mainmap");
                if (a2 != null) {
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
                    bundle3.putString("launch_from", "sdk_[" + f35708g + PreferencesUtil.RIGHT_MOUNT);
                    bundle.putBundle("ext_params", bundle3);
                    return f35706e.a("map.android.baidu.mainmap", a2, bundle);
                }
                return false;
            } catch (RemoteException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
