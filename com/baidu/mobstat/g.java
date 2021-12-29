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
    public static final g f38132b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f38133c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f38134d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f38135e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f38136f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f38137g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f38138h;

    /* renamed from: i  reason: collision with root package name */
    public static final g f38139i;

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ g[] f38140k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public long f38141j;

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
        f38132b = new g("APP_USER_LIST", 1);
        f38133c = new g("APP_SYS_LIST", 2);
        f38134d = new g("APP_TRACE_CURRENT", 3);
        f38135e = new g("APP_TRACE_HIS", 4);
        f38136f = new g("APP_CHANGE", 5);
        f38137g = new g("APP_APK", 6);
        f38138h = new g("LAST_SEND", 7);
        g gVar = new g("LAST_UPDATE", 8);
        f38139i = gVar;
        f38140k = new g[]{a, f38132b, f38133c, f38134d, f38135e, f38136f, f38137g, f38138h, gVar};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) f38140k.clone() : (g[]) invokeV.objValue;
    }
}
