package com.baidu.platform.comapi.walknavi.segmentbrowse;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f10167a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f10168b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f10169c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f10170d = 99999;

    /* renamed from: f  reason: collision with root package name */
    public static a f10172f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f10173g = -1;

    /* renamed from: e  reason: collision with root package name */
    public static b f10171e = b.FIRST_GUIDANCE;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, a> f10174h = new HashMap<>();

    public static void a(a aVar) {
        f10172f = aVar;
        HashMap<Integer, a> hashMap = f10174h;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(a()), aVar);
        }
        f();
        e();
    }

    public static int b() {
        return f10173g + 1;
    }

    public static int c() {
        return f10173g - 1;
    }

    public static a d() {
        return f10174h.get(Integer.valueOf(f10173g));
    }

    public static double e(int i) {
        if (i > 30 || i <= 0) {
            if (i > 150 || i <= 30) {
                return i > 150 ? 2.0d : -1.0d;
            }
            return 1.5d;
        }
        return 1.0d;
    }

    public static a e() {
        return a(f10173g, -1);
    }

    public static a f() {
        return a(f10173g, 1);
    }

    public static int g() {
        return f10169c;
    }

    public static int h() {
        return f10170d;
    }

    public static double i() {
        a a2 = a(f10173g, -2);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double j() {
        a a2 = a(f10173g, -1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double k() {
        if (f10174h.get(Integer.valueOf(f10173g)) == null || f10174h.get(Integer.valueOf(f10173g)).d() < 0) {
            return -1.0d;
        }
        return e(f10174h.get(Integer.valueOf(f10173g)).d());
    }

    public static double l() {
        a a2 = a(f10173g, 1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static int m() {
        if (i() == -1.0d) {
            return -1;
        }
        return (int) (i() * f10167a);
    }

    public static int n() {
        if (j() == -1.0d) {
            return -1;
        }
        return (int) (j() * f10167a);
    }

    public static int o() {
        if (k() == -1.0d) {
            return -1;
        }
        return (int) (k() * f10167a);
    }

    public static int p() {
        if (l() == -1.0d) {
            return -1;
        }
        return (int) (l() * f10167a);
    }

    public static double q() {
        return 0.7d;
    }

    public static void r() {
        f10173g = -1;
        f10169c = -1;
        f10170d = 99999;
        f10171e = b.FIRST_GUIDANCE;
        f10168b = -1;
        HashMap<Integer, a> hashMap = f10174h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static b s() {
        return f10171e;
    }

    public static void b(int i) {
        if (f10169c != -1 || i == -1) {
            return;
        }
        f10169c = i;
    }

    public static void c(int i) {
        if (f10170d != 99999 || i == -1) {
            return;
        }
        f10170d = i;
    }

    public static a d(int i) {
        HashMap<Integer, a> hashMap = f10174h;
        if (hashMap == null || hashMap.size() < 1 || !f10174h.containsKey(Integer.valueOf(i))) {
            return null;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("route hashmap", f10174h.toString());
        return f10174h.get(Integer.valueOf(i));
    }

    public static void f(int i) {
        int b2 = com.baidu.platform.comapi.wnplatform.o.b.b.a().b();
        int c2 = com.baidu.platform.comapi.wnplatform.o.b.b.a().c();
        int n = com.baidu.platform.comapi.walknavi.b.a().Q().n();
        MapBound f2 = com.baidu.platform.comapi.walknavi.b.a().f(i);
        MapStatus i2 = com.baidu.platform.comapi.walknavi.b.a().G().i();
        if (i2 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i2);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            if (f2 != null) {
                float a2 = com.baidu.platform.comapi.walknavi.b.a().G().a(f2, b2, c2 - (n * 2));
                builder.target(CoordUtil.mc2ll(new GeoPoint((f2.getPtLB().getmPtx() + f2.getPtRT().getmPtx()) / 2, (f2.getPtLB().getmPty() + f2.getPtRT().getmPty()) / 2)));
                builder.zoom(a2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: height:" + c2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: topUIHeight:" + n);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: width:" + b2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: level:" + a2);
            }
            com.baidu.platform.comapi.walknavi.b.a().G().a(builder.build(), 500);
        }
        com.baidu.platform.comapi.walknavi.b.a().D().e(i);
    }

    public static int a() {
        return f10173g;
    }

    public static void a(int i) {
        f10173g = i;
        b(i);
        f();
        e();
    }

    public static int a(Context context) {
        Paint paint = new Paint();
        paint.setTextSize(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(context, 17.0f));
        int measureText = (int) paint.measureText("任");
        double d2 = (f10167a * 0.7d) / measureText;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "singleCharwidth:" + measureText);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "num:" + d2);
        return (int) d2;
    }

    public static a a(int i, int i2) {
        HashMap<Integer, a> hashMap = f10174h;
        if (hashMap != null) {
            int i3 = i + i2;
            if (hashMap.containsKey(Integer.valueOf(i3))) {
                return f10174h.get(Integer.valueOf(i3));
            }
        }
        a aVar = new a();
        Bundle bundle = new Bundle();
        com.baidu.platform.comapi.wnplatform.d.a.a("uid******offset", "uid**" + i + "offset" + i2);
        com.baidu.platform.comapi.walknavi.b.a().D().a(i, i2, bundle);
        if (bundle.containsKey("uid")) {
            aVar.b(bundle.getInt("uid"));
            aVar.b(bundle.getString("usGuideText"));
            aVar.a(e.a(bundle, false));
            aVar.b(e.a(bundle));
            int i4 = bundle.getInt("nParagraphLength");
            if (bundle.containsKey("enGuideType")) {
                String a2 = com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[bundle.getInt("enGuideType")]);
                if (i4 == 0 && a2.equals("wn_dest.png")) {
                    aVar.a(20);
                    c(bundle.getInt("uid"));
                } else {
                    aVar.a(i4);
                }
                aVar.a(a2);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("getRouteMessageModelByUid", "wroutemessagemodel" + aVar.toString());
            f10174h.put(Integer.valueOf(i + i2), aVar);
            return aVar;
        }
        return null;
    }

    public static void a(b bVar) {
        f10171e = bVar;
    }
}
