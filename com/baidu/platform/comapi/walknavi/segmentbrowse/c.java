package com.baidu.platform.comapi.walknavi.segmentbrowse;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f3087a;
    private static a f;
    private static int g = -1;
    public static int b = -1;
    public static int c = -1;
    public static int d = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
    public static b e = b.FIRST_GUIDANCE;
    private static HashMap<Integer, a> h = new HashMap<>();

    public static void a(a aVar) {
        f = aVar;
        if (h != null) {
            h.put(Integer.valueOf(a()), aVar);
        }
        d();
        c();
    }

    public static int a() {
        return g;
    }

    public static void a(int i) {
        g = i;
        b(i);
        d();
        c();
    }

    public static a b() {
        return h.get(Integer.valueOf(g));
    }

    public static a c() {
        return a(g, -1);
    }

    public static a d() {
        return a(g, 1);
    }

    public static void b(int i) {
        if (c == -1 && i != -1) {
            c = i;
        }
    }

    public static int e() {
        return c;
    }

    public static void c(int i) {
        if (d == 99999 && i != -1) {
            d = i;
        }
    }

    public static int f() {
        return d;
    }

    public static int a(Context context) {
        Paint paint = new Paint();
        paint.setTextSize(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.a.a(context, 17.0f));
        int measureText = (int) paint.measureText("任");
        double d2 = (0.7d * f3087a) / measureText;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "singleCharwidth:" + measureText);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "num:" + d2);
        return (int) d2;
    }

    public static a d(int i) {
        if (h == null || h.size() < 1 || !h.containsKey(Integer.valueOf(i))) {
            return null;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("route hashmap", h.toString());
        return h.get(Integer.valueOf(i));
    }

    public static a a(int i, int i2) {
        if (h != null && h.containsKey(Integer.valueOf(i + i2))) {
            return h.get(Integer.valueOf(i + i2));
        }
        a aVar = new a();
        Bundle bundle = new Bundle();
        com.baidu.platform.comapi.wnplatform.d.a.a("uid******offset", "uid**" + i + "offset" + i2);
        com.baidu.platform.comapi.walknavi.b.a().G().a(i, i2, bundle);
        if (!bundle.containsKey("uid")) {
            return null;
        }
        aVar.b(bundle.getInt("uid"));
        aVar.b(bundle.getString("usGuideText"));
        aVar.a(d.a(bundle, false));
        aVar.b(d.a(bundle));
        int i3 = bundle.getInt("nParagraphLength");
        if (bundle.containsKey("enGuideType")) {
            String a2 = com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[bundle.getInt("enGuideType")]);
            if (i3 == 0 && a2.equals("wn_dest.png")) {
                aVar.a(20);
                c(bundle.getInt("uid"));
            } else {
                aVar.a(i3);
            }
            aVar.a(a2);
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("getRouteMessageModelByUid", "wroutemessagemodel" + aVar.toString());
        h.put(Integer.valueOf(i + i2), aVar);
        return aVar;
    }

    public static double g() {
        a a2 = a(g, -2);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double h() {
        a a2 = a(g, -1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static double i() {
        if (h.get(Integer.valueOf(g)) == null || h.get(Integer.valueOf(g)).d() < 0) {
            return -1.0d;
        }
        return e(h.get(Integer.valueOf(g)).d());
    }

    public static double j() {
        a a2 = a(g, 1);
        if (a2 == null || a2.d() < 0) {
            return -1.0d;
        }
        return e(a2.d());
    }

    public static int k() {
        if (g() == -1.0d) {
            return -1;
        }
        return (int) (g() * f3087a);
    }

    public static int l() {
        if (h() == -1.0d) {
            return -1;
        }
        return (int) (h() * f3087a);
    }

    public static int m() {
        if (i() == -1.0d) {
            return -1;
        }
        return (int) (i() * f3087a);
    }

    public static int n() {
        if (j() == -1.0d) {
            return -1;
        }
        return (int) (j() * f3087a);
    }

    public static double e(int i) {
        if (i <= 30 && i > 0) {
            return 1.0d;
        }
        if (i <= 150 && i > 30) {
            return 1.5d;
        }
        if (i > 150) {
            return 2.0d;
        }
        return -1.0d;
    }

    public static void o() {
        g = -1;
        c = -1;
        d = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
        e = b.FIRST_GUIDANCE;
        b = -1;
        if (h != null) {
            h.clear();
        }
    }

    public static b p() {
        return e;
    }

    public static void a(b bVar) {
        e = bVar;
    }

    public static void f(int i) {
        int b2 = com.baidu.platform.comapi.wnplatform.p.b.b.a().b();
        int c2 = com.baidu.platform.comapi.wnplatform.p.b.b.a().c();
        int n = com.baidu.platform.comapi.walknavi.b.a().T().n();
        MapBound g2 = com.baidu.platform.comapi.walknavi.b.a().g(i);
        MapStatus i2 = com.baidu.platform.comapi.walknavi.b.a().J().i();
        if (i2 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(i2);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            if (g2 != null) {
                float a2 = com.baidu.platform.comapi.walknavi.b.a().J().a(g2, b2, c2 - (n * 2));
                builder.target(CoordUtil.mc2ll(new GeoPoint((g2.getPtLB().getIntX() + g2.getPtRT().getIntX()) / 2, (g2.getPtRT().getIntY() + g2.getPtLB().getIntY()) / 2)));
                builder.zoom(a2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: height:" + c2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: topUIHeight:" + n);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: width:" + b2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: level:" + a2);
            }
            com.baidu.platform.comapi.walknavi.b.a().J().a(builder.build(), 500);
        }
        com.baidu.platform.comapi.walknavi.b.a().G().f(i);
    }
}
