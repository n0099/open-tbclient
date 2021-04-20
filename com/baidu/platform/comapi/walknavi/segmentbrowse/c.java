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
    public static int f9725a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f9726b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f9727c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f9728d = 99999;

    /* renamed from: f  reason: collision with root package name */
    public static a f9730f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f9731g = -1;

    /* renamed from: e  reason: collision with root package name */
    public static b f9729e = b.FIRST_GUIDANCE;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, a> f9732h = new HashMap<>();

    public static void a(a aVar) {
        f9730f = aVar;
        HashMap<Integer, a> hashMap = f9732h;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(a()), aVar);
        }
        f();
        e();
    }

    public static int b() {
        return f9731g + 1;
    }

    public static int c() {
        return f9731g - 1;
    }

    public static a d() {
        return f9732h.get(Integer.valueOf(f9731g));
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
        return a(f9731g, -1);
    }

    public static a f() {
        return a(f9731g, 1);
    }

    public static int g() {
        return f9727c;
    }

    public static int h() {
        return f9728d;
    }

    public static double i() {
        a a2 = a(f9731g, -2);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double j() {
        a a2 = a(f9731g, -1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double k() {
        if (f9732h.get(Integer.valueOf(f9731g)) == null || f9732h.get(Integer.valueOf(f9731g)).d() < 0) {
            return -1.0d;
        }
        return e(f9732h.get(Integer.valueOf(f9731g)).d());
    }

    public static double l() {
        a a2 = a(f9731g, 1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static int m() {
        if (i() == -1.0d) {
            return -1;
        }
        return (int) (i() * f9725a);
    }

    public static int n() {
        if (j() == -1.0d) {
            return -1;
        }
        return (int) (j() * f9725a);
    }

    public static int o() {
        if (k() == -1.0d) {
            return -1;
        }
        return (int) (k() * f9725a);
    }

    public static int p() {
        if (l() == -1.0d) {
            return -1;
        }
        return (int) (l() * f9725a);
    }

    public static double q() {
        return 0.7d;
    }

    public static void r() {
        f9731g = -1;
        f9727c = -1;
        f9728d = 99999;
        f9729e = b.FIRST_GUIDANCE;
        f9726b = -1;
        HashMap<Integer, a> hashMap = f9732h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static b s() {
        return f9729e;
    }

    public static void b(int i) {
        if (f9727c != -1 || i == -1) {
            return;
        }
        f9727c = i;
    }

    public static void c(int i) {
        if (f9728d != 99999 || i == -1) {
            return;
        }
        f9728d = i;
    }

    public static a d(int i) {
        HashMap<Integer, a> hashMap = f9732h;
        if (hashMap == null || hashMap.size() < 1 || !f9732h.containsKey(Integer.valueOf(i))) {
            return null;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("route hashmap", f9732h.toString());
        return f9732h.get(Integer.valueOf(i));
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
        return f9731g;
    }

    public static void a(int i) {
        f9731g = i;
        b(i);
        f();
        e();
    }

    public static int a(Context context) {
        Paint paint = new Paint();
        paint.setTextSize(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(context, 17.0f));
        int measureText = (int) paint.measureText("任");
        double d2 = (f9725a * 0.7d) / measureText;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "singleCharwidth:" + measureText);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "num:" + d2);
        return (int) d2;
    }

    public static a a(int i, int i2) {
        HashMap<Integer, a> hashMap = f9732h;
        if (hashMap != null) {
            int i3 = i + i2;
            if (hashMap.containsKey(Integer.valueOf(i3))) {
                return f9732h.get(Integer.valueOf(i3));
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
            f9732h.put(Integer.valueOf(i + i2), aVar);
            return aVar;
        }
        return null;
    }

    public static void a(b bVar) {
        f9729e = bVar;
    }
}
