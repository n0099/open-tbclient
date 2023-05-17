package com.baidu.platform.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class SearchType {
    public static /* synthetic */ Interceptable $ic;
    public static final SearchType a;
    public static final SearchType b;
    public static final SearchType c;
    public static final SearchType d;
    public static final SearchType e;
    public static final SearchType f;
    public static final SearchType g;
    public static final SearchType h;
    public static final SearchType i;
    public static final SearchType j;
    public static final SearchType k;
    public static final SearchType l;
    public static final SearchType m;
    public static final SearchType n;
    public static final SearchType o;
    public static final SearchType p;
    public static final SearchType q;
    public static final SearchType r;
    public static final SearchType s;
    public static final SearchType t;
    public static final SearchType u;
    public static final SearchType v;
    public static final /* synthetic */ SearchType[] w;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1827963927, "Lcom/baidu/platform/base/SearchType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1827963927, "Lcom/baidu/platform/base/SearchType;");
                return;
            }
        }
        a = new SearchType("POI_NEAR_BY_SEARCH", 0);
        b = new SearchType("POI_IN_CITY_SEARCH", 1);
        c = new SearchType("POI_IN_BOUND_SEARCH", 2);
        d = new SearchType("POI_DETAIL_SEARCH", 3);
        e = new SearchType("INDOOR_POI_SEARCH", 4);
        f = new SearchType("SUGGESTION_SEARCH_TYPE", 5);
        g = new SearchType("GEO_CODER", 6);
        h = new SearchType("REVERSE_GEO_CODER", 7);
        i = new SearchType("MASS_TRANSIT_ROUTE", 8);
        j = new SearchType("TRANSIT_ROUTE", 9);
        k = new SearchType("DRIVE_ROUTE", 10);
        l = new SearchType("BIKE_ROUTE", 11);
        m = new SearchType("WALK_ROUTE", 12);
        n = new SearchType("INDOOR_ROUTE", 13);
        o = new SearchType("BUS_LINE_DETAIL", 14);
        p = new SearchType("DISTRICT_SEARCH", 15);
        q = new SearchType("POI_DETAIL_SHARE", 16);
        r = new SearchType("LOCATION_SEARCH_SHARE", 17);
        s = new SearchType("ROUTE_PLAN_SHARE", 18);
        t = new SearchType("WEATHER_SEARCH", 19);
        u = new SearchType("RECOMMEND_STOP", 20);
        SearchType searchType = new SearchType("BUILDING_SEARCH", 21);
        v = searchType;
        w = new SearchType[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, searchType};
    }

    public SearchType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static SearchType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (SearchType) Enum.valueOf(SearchType.class, str);
        }
        return (SearchType) invokeL.objValue;
    }

    public static SearchType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (SearchType[]) w.clone();
        }
        return (SearchType[]) invokeV.objValue;
    }
}
