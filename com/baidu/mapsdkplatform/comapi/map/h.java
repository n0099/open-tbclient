package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static final h a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f36446b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f36447c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f36448d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f36449e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f36450f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f36451g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f36452h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f36453i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f36454j;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ h[] f36455k;
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
        f36446b = new h("popup", 1);
        f36447c = new h("marker", 2);
        f36448d = new h("ground", 3);
        f36449e = new h("text", 4);
        f36450f = new h("arc", 5);
        f36451g = new h("dot", 6);
        f36452h = new h("circle", 7);
        f36453i = new h("polyline", 8);
        h hVar = new h("polygon", 9);
        f36454j = hVar;
        f36455k = new h[]{a, f36446b, f36447c, f36448d, f36449e, f36450f, f36451g, f36452h, f36453i, hVar};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f36455k.clone() : (h[]) invokeV.objValue;
    }
}
