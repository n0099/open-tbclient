package com.baidu.platform.core.g;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
/* loaded from: classes3.dex */
public class e extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e(RouteShareURLOption routeShareURLOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {routeShareURLOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(routeShareURLOption);
    }

    private int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    private void a(RouteShareURLOption routeShareURLOption) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, routeShareURLOption) == null) {
            com.baidu.platform.util.a aVar = new com.baidu.platform.util.a();
            Point ll2point = CoordUtil.ll2point(routeShareURLOption.mFrom.getLocation());
            Point ll2point2 = CoordUtil.ll2point(routeShareURLOption.mTo.getLocation());
            String str3 = "2$$$$$$";
            if (ll2point == null) {
                str = "2$$$$$$";
            } else {
                str = "1$$$$" + ll2point.x + "," + ll2point.y + UrlTemplate.ESCAPED_DOLLAR;
            }
            String name = routeShareURLOption.mFrom.getName();
            String str4 = "";
            name = (name == null || name.equals("")) ? "起点" : "起点";
            String str5 = str + name + "$$0$$$$";
            if (ll2point2 != null) {
                str3 = "1$$$$" + ll2point2.x + "," + ll2point2.y + UrlTemplate.ESCAPED_DOLLAR;
            }
            String name2 = routeShareURLOption.mTo.getName();
            name2 = (name2 == null || name2.equals("")) ? "终点" : "终点";
            String str6 = str3 + name2 + "$$0$$$$";
            int ordinal = routeShareURLOption.mMode.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            str2 = "";
                        } else {
                            String str7 = "&i=" + routeShareURLOption.mPn + ",1,1&sharecallbackflag=busRoute";
                            aVar.a("c", routeShareURLOption.mCityCode + "");
                            str2 = "bt";
                            str4 = str7;
                        }
                    } else {
                        aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
                        aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                        str4 = "&sharecallbackflag=cycleRoute";
                        str2 = "cycle";
                    }
                } else {
                    aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
                    aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                    str4 = "&sharecallbackflag=footRoute";
                    str2 = "walk";
                }
            } else {
                aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
                aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
                str4 = "&sharecallbackflag=carRoute";
                str2 = "nav";
            }
            aVar.a(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, str5);
            aVar.a("en", str6);
            String str8 = "&" + aVar.a() + ("&start=" + name + "&end=" + name2);
            this.a.a("url", "http://map.baidu.com/?newmap=1&s=" + str2 + (AppMD5.encodeUrlParamsValue(str8) + str4));
            this.a.a("from", "android_map_sdk");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.r();
        }
        return (String) invokeL.objValue;
    }
}
