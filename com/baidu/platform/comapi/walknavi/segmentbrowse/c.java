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
    public static int f10085a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f10086b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f10087c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f10088d = 99999;

    /* renamed from: f  reason: collision with root package name */
    public static a f10090f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f10091g = -1;

    /* renamed from: e  reason: collision with root package name */
    public static b f10089e = b.FIRST_GUIDANCE;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<Integer, a> f10092h = new HashMap<>();

    public static void a(a aVar) {
        f10090f = aVar;
        HashMap<Integer, a> hashMap = f10092h;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(a()), aVar);
        }
        f();
        e();
    }

    public static int b() {
        return f10091g + 1;
    }

    public static int c() {
        return f10091g - 1;
    }

    public static a d() {
        return f10092h.get(Integer.valueOf(f10091g));
    }

    public static double e(int i2) {
        if (i2 > 30 || i2 <= 0) {
            if (i2 > 150 || i2 <= 30) {
                return i2 > 150 ? 2.0d : -1.0d;
            }
            return 1.5d;
        }
        return 1.0d;
    }

    public static a e() {
        return a(f10091g, -1);
    }

    public static a f() {
        return a(f10091g, 1);
    }

    public static int g() {
        return f10087c;
    }

    public static int h() {
        return f10088d;
    }

    public static double i() {
        a a2 = a(f10091g, -2);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double j() {
        a a2 = a(f10091g, -1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double k() {
        if (f10092h.get(Integer.valueOf(f10091g)) == null || f10092h.get(Integer.valueOf(f10091g)).d() < 0) {
            return -1.0d;
        }
        return e(f10092h.get(Integer.valueOf(f10091g)).d());
    }

    public static double l() {
        a a2 = a(f10091g, 1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static int m() {
        if (i() == -1.0d) {
            return -1;
        }
        return (int) (i() * f10085a);
    }

    public static int n() {
        if (j() == -1.0d) {
            return -1;
        }
        return (int) (j() * f10085a);
    }

    public static int o() {
        if (k() == -1.0d) {
            return -1;
        }
        return (int) (k() * f10085a);
    }

    public static int p() {
        if (l() == -1.0d) {
            return -1;
        }
        return (int) (l() * f10085a);
    }

    public static double q() {
        return 0.7d;
    }

    public static void r() {
        f10091g = -1;
        f10087c = -1;
        f10088d = 99999;
        f10089e = b.FIRST_GUIDANCE;
        f10086b = -1;
        HashMap<Integer, a> hashMap = f10092h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static b s() {
        return f10089e;
    }

    public static void b(int i2) {
        if (f10087c != -1 || i2 == -1) {
            return;
        }
        f10087c = i2;
    }

    public static void c(int i2) {
        if (f10088d != 99999 || i2 == -1) {
            return;
        }
        f10088d = i2;
    }

    public static a d(int i2) {
        HashMap<Integer, a> hashMap = f10092h;
        if (hashMap == null || hashMap.size() < 1 || !f10092h.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("route hashmap", f10092h.toString());
        return f10092h.get(Integer.valueOf(i2));
    }

    public static void f(int i2) {
        int b2 = com.baidu.platform.comapi.wnplatform.o.b.b.a().b();
        int c2 = com.baidu.platform.comapi.wnplatform.o.b.b.a().c();
        int n = com.baidu.platform.comapi.walknavi.b.a().Q().n();
        MapBound f2 = com.baidu.platform.comapi.walknavi.b.a().f(i2);
        MapStatus i3 = com.baidu.platform.comapi.walknavi.b.a().G().i();
        if (i3 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i3);
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
        com.baidu.platform.comapi.walknavi.b.a().D().e(i2);
    }

    public static int a() {
        return f10091g;
    }

    public static void a(int i2) {
        f10091g = i2;
        b(i2);
        f();
        e();
    }

    public static int a(Context context) {
        Paint paint = new Paint();
        paint.setTextSize(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(context, 17.0f));
        int measureText = (int) paint.measureText("任");
        double d2 = (f10085a * 0.7d) / measureText;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "singleCharwidth:" + measureText);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "num:" + d2);
        return (int) d2;
    }

    public static a a(int i2, int i3) {
        HashMap<Integer, a> hashMap = f10092h;
        if (hashMap != null) {
            int i4 = i2 + i3;
            if (hashMap.containsKey(Integer.valueOf(i4))) {
                return f10092h.get(Integer.valueOf(i4));
            }
        }
        a aVar = new a();
        Bundle bundle = new Bundle();
        com.baidu.platform.comapi.wnplatform.d.a.a("uid******offset", "uid**" + i2 + "offset" + i3);
        com.baidu.platform.comapi.walknavi.b.a().D().a(i2, i3, bundle);
        if (bundle.containsKey("uid")) {
            aVar.b(bundle.getInt("uid"));
            aVar.b(bundle.getString("usGuideText"));
            aVar.a(e.a(bundle, false));
            aVar.b(e.a(bundle));
            int i5 = bundle.getInt("nParagraphLength");
            if (bundle.containsKey("enGuideType")) {
                String a2 = com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[bundle.getInt("enGuideType")]);
                if (i5 == 0 && a2.equals("wn_dest.png")) {
                    aVar.a(20);
                    c(bundle.getInt("uid"));
                } else {
                    aVar.a(i5);
                }
                aVar.a(a2);
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("getRouteMessageModelByUid", "wroutemessagemodel" + aVar.toString());
            f10092h.put(Integer.valueOf(i2 + i3), aVar);
            return aVar;
        }
        return null;
    }

    public static void a(b bVar) {
        f10089e = bVar;
    }
}
