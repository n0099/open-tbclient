package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f42019a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f42020b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f42021c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f42022d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f42023e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f42024f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f42025g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f42026h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f42027i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f42028j;
    public static final /* synthetic */ h[] k;
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
        f42019a = new h("logo", 0);
        f42020b = new h("popup", 1);
        f42021c = new h("marker", 2);
        f42022d = new h("ground", 3);
        f42023e = new h("text", 4);
        f42024f = new h("arc", 5);
        f42025g = new h("dot", 6);
        f42026h = new h("circle", 7);
        f42027i = new h("polyline", 8);
        h hVar = new h("polygon", 9);
        f42028j = hVar;
        k = new h[]{f42019a, f42020b, f42021c, f42022d, f42023e, f42024f, f42025g, f42026h, f42027i, hVar};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) k.clone() : (h[]) invokeV.objValue;
    }
}
