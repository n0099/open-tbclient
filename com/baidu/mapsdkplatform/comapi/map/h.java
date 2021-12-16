package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static final h a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f36935b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f36936c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f36937d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f36938e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f36939f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f36940g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f36941h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f36942i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f36943j;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ h[] f36944k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782220, "Lcom/baidu/mapsdkplatform/comapi/map/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782220, "Lcom/baidu/mapsdkplatform/comapi/map/h;");
                return;
            }
        }
        a = new h("logo", 0);
        f36935b = new h("popup", 1);
        f36936c = new h("marker", 2);
        f36937d = new h("ground", 3);
        f36938e = new h("text", 4);
        f36939f = new h("arc", 5);
        f36940g = new h("dot", 6);
        f36941h = new h("circle", 7);
        f36942i = new h("polyline", 8);
        h hVar = new h("polygon", 9);
        f36943j = hVar;
        f36944k = new h[]{a, f36935b, f36936c, f36937d, f36938e, f36939f, f36940g, f36941h, f36942i, hVar};
    }

    public h(String str, int i2) {
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

    public static h valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (h) Enum.valueOf(h.class, str) : (h) invokeL.objValue;
    }

    public static h[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f36944k.clone() : (h[]) invokeV.objValue;
    }
}
