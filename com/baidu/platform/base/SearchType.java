package com.baidu.platform.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class SearchType {
    public static /* synthetic */ Interceptable $ic;
    public static final SearchType a;

    /* renamed from: b  reason: collision with root package name */
    public static final SearchType f38978b;

    /* renamed from: c  reason: collision with root package name */
    public static final SearchType f38979c;

    /* renamed from: d  reason: collision with root package name */
    public static final SearchType f38980d;

    /* renamed from: e  reason: collision with root package name */
    public static final SearchType f38981e;

    /* renamed from: f  reason: collision with root package name */
    public static final SearchType f38982f;

    /* renamed from: g  reason: collision with root package name */
    public static final SearchType f38983g;

    /* renamed from: h  reason: collision with root package name */
    public static final SearchType f38984h;

    /* renamed from: i  reason: collision with root package name */
    public static final SearchType f38985i;

    /* renamed from: j  reason: collision with root package name */
    public static final SearchType f38986j;

    /* renamed from: k  reason: collision with root package name */
    public static final SearchType f38987k;
    public static final SearchType l;
    public static final SearchType m;
    public static final SearchType n;
    public static final SearchType o;
    public static final SearchType p;
    public static final SearchType q;
    public static final SearchType r;
    public static final SearchType s;
    public static final /* synthetic */ SearchType[] t;
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
        f38978b = new SearchType("POI_IN_CITY_SEARCH", 1);
        f38979c = new SearchType("POI_IN_BOUND_SEARCH", 2);
        f38980d = new SearchType("POI_DETAIL_SEARCH", 3);
        f38981e = new SearchType("INDOOR_POI_SEARCH", 4);
        f38982f = new SearchType("SUGGESTION_SEARCH_TYPE", 5);
        f38983g = new SearchType("GEO_CODER", 6);
        f38984h = new SearchType("REVERSE_GEO_CODER", 7);
        f38985i = new SearchType("MASS_TRANSIT_ROUTE", 8);
        f38986j = new SearchType("TRANSIT_ROUTE", 9);
        f38987k = new SearchType("DRIVE_ROUTE", 10);
        l = new SearchType("BIKE_ROUTE", 11);
        m = new SearchType("WALK_ROUTE", 12);
        n = new SearchType("INDOOR_ROUTE", 13);
        o = new SearchType("BUS_LINE_DETAIL", 14);
        p = new SearchType("DISTRICT_SEARCH", 15);
        q = new SearchType("POI_DETAIL_SHARE", 16);
        r = new SearchType("LOCATION_SEARCH_SHARE", 17);
        SearchType searchType = new SearchType("ROUTE_PLAN_SHARE", 18);
        s = searchType;
        t = new SearchType[]{a, f38978b, f38979c, f38980d, f38981e, f38982f, f38983g, f38984h, f38985i, f38986j, f38987k, l, m, n, o, p, q, r, searchType};
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SearchType) Enum.valueOf(SearchType.class, str) : (SearchType) invokeL.objValue;
    }

    public static SearchType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SearchType[]) t.clone() : (SearchType[]) invokeV.objValue;
    }
}
