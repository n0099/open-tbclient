package com.baidu.smartcolor;

import c.a.l0.a;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SmartColorSDK {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SmartColorSDK f45226a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-813018686, "Lcom/baidu/smartcolor/SmartColorSDK;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-813018686, "Lcom/baidu/smartcolor/SmartColorSDK;");
                return;
            }
        }
        System.loadLibrary("native-bridge");
        f45226a = null;
    }

    public SmartColorSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(Tri tri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tri)) == null) {
            if (tri == Tri.TRUE) {
                return 1;
            }
            return tri == Tri.FALSE ? 0 : 2;
        }
        return invokeL.intValue;
    }

    public static SmartColorSDK b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f45226a == null) {
                synchronized (SmartColorSDK.class) {
                    if (f45226a == null) {
                        f45226a = new SmartColorSDK();
                    }
                }
            }
            return f45226a;
        }
        return (SmartColorSDK) invokeV.objValue;
    }

    private native String getNativeSmartColor(byte[] bArr, int i2, int i3, int i4, int i5, String str, String str2, int i6, int i7, int i8, int i9, long j2, long j3, long j4, long j5);

    public String c(a aVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, aVar, bArr, i2)) == null) ? getNativeSmartColor(bArr, i2, aVar.i(), aVar.j(), aVar.n(), aVar.s(), aVar.k(), a(aVar.l()), a(aVar.m()), a(aVar.h()), a(aVar.g()), aVar.q(), aVar.o(), aVar.r(), aVar.p()) : (String) invokeLLI.objValue;
    }
}
