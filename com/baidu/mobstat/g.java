package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f43637a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f43638b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f43639c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f43640d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f43641e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f43642f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f43643g;

    /* renamed from: h  reason: collision with root package name */
    public static final g f43644h;

    /* renamed from: i  reason: collision with root package name */
    public static final g f43645i;
    public static final /* synthetic */ g[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public long f43646j;

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
        f43637a = new g("AP_LIST", 0);
        f43638b = new g("APP_USER_LIST", 1);
        f43639c = new g("APP_SYS_LIST", 2);
        f43640d = new g("APP_TRACE_CURRENT", 3);
        f43641e = new g("APP_TRACE_HIS", 4);
        f43642f = new g("APP_CHANGE", 5);
        f43643g = new g("APP_APK", 6);
        f43644h = new g("LAST_SEND", 7);
        g gVar = new g("LAST_UPDATE", 8);
        f43645i = gVar;
        k = new g[]{f43637a, f43638b, f43639c, f43640d, f43641e, f43642f, f43643g, f43644h, gVar};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) k.clone() : (g[]) invokeV.objValue;
    }
}
