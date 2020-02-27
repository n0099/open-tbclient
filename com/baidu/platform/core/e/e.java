package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class e extends com.baidu.platform.base.e {
    public e(RouteShareURLOption routeShareURLOption) {
        a(routeShareURLOption);
    }

    private int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void a(RouteShareURLOption routeShareURLOption) {
        com.baidu.platform.util.a aVar = new com.baidu.platform.util.a();
        Point ll2point = CoordUtil.ll2point(routeShareURLOption.mFrom.getLocation());
        Point ll2point2 = CoordUtil.ll2point(routeShareURLOption.mTo.getLocation());
        String str = ll2point != null ? "1$$$$" + ll2point.x + Constants.ACCEPT_TIME_SEPARATOR_SP + ll2point.y + "$$" : "2$$$$$$";
        String name = routeShareURLOption.mFrom.getName();
        String str2 = str + ((name == null || name.equals("")) ? "起点" : "起点") + "$$0$$$$";
        String str3 = ll2point2 != null ? "1$$$$" + ll2point2.x + Constants.ACCEPT_TIME_SEPARATOR_SP + ll2point2.y + "$$" : "2$$$$$$";
        String name2 = routeShareURLOption.mTo.getName();
        String str4 = str3 + ((name2 == null || name2.equals("")) ? "终点" : "终点") + "$$0$$$$";
        String str5 = "";
        String str6 = "";
        switch (routeShareURLOption.mMode.ordinal()) {
            case 0:
                str6 = "&sharecallbackflag=carRoute";
                str5 = "nav";
                aVar.a(Config.STAT_SDK_CHANNEL, a(routeShareURLOption.mFrom.getCity()) + "");
                aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                break;
            case 1:
                str6 = "&sharecallbackflag=footRoute";
                str5 = "walk";
                aVar.a(Config.STAT_SDK_CHANNEL, a(routeShareURLOption.mFrom.getCity()) + "");
                aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                break;
            case 2:
                str6 = "&sharecallbackflag=cycleRoute";
                str5 = "cycle";
                aVar.a(Config.STAT_SDK_CHANNEL, a(routeShareURLOption.mFrom.getCity()) + "");
                aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                break;
            case 3:
                str6 = "&i=" + routeShareURLOption.mPn + ",1,1&sharecallbackflag=busRoute";
                aVar.a("c", routeShareURLOption.mCityCode + "");
                str5 = "bt";
                break;
        }
        aVar.a(IXAdRequestInfo.SN, str2);
        aVar.a(com.baidu.fsg.base.statistics.h.a, str4);
        this.a.a("url", "http://map.baidu.com/?newmap=1&s=" + str5 + (AppMD5.encodeUrlParamsValue(ETAG.ITEM_SEPARATOR + aVar.a() + ("&start=" + name + "&end=" + name2)) + str6));
        this.a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.r();
    }
}
