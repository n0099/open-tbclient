package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final g a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f37976b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f37977c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f37978d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f37979e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f37980f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f37981g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f37982h;

    /* renamed from: i  reason: collision with root package name */
    public static final g f37983i;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ g[] f37984k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public long f37985j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366710051, "Lcom/baidu/mobstat/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366710051, "Lcom/baidu/mobstat/g;");
                return;
            }
        }
        a = new g("AP_LIST", 0);
        f37976b = new g("APP_USER_LIST", 1);
        f37977c = new g("APP_SYS_LIST", 2);
        f37978d = new g("APP_TRACE_CURRENT", 3);
        f37979e = new g("APP_TRACE_HIS", 4);
        f37980f = new g("APP_CHANGE", 5);
        f37981g = new g("APP_APK", 6);
        f37982h = new g("LAST_SEND", 7);
        g gVar = new g("LAST_UPDATE", 8);
        f37983i = gVar;
        f37984k = new g[]{a, f37976b, f37977c, f37978d, f37979e, f37980f, f37981g, f37982h, gVar};
    }

    public g(String str, int i2) {
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

    public static g valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (g) Enum.valueOf(g.class, str) : (g) invokeL.objValue;
    }

    public static g[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) f37984k.clone() : (g[]) invokeV.objValue;
    }
}
