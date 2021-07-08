package com.baidu.mobads.cid.cesium.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f8191a = 5;

    /* renamed from: b  reason: collision with root package name */
    public static int f8192b = 40;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public b f8193c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-480698560, "Lcom/baidu/mobads/cid/cesium/a/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-480698560, "Lcom/baidu/mobads/cid/cesium/a/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b bVar = new b(f8192b);
        this.f8193c = bVar;
        bVar.a(0, f8192b, true);
    }

    public void a(b bVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, bVar, i2, i3, i4) == null) {
            b c2 = this.f8193c.c(i2, i2 + i3);
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        c2.d(bVar);
                    } else if (i4 == 3) {
                        c2.b(bVar);
                    }
                }
                c2.c(bVar);
            } else {
                c2.a(bVar);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                this.f8193c.a(i2 + i5, c2.c(i5));
            }
        }
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8193c.a() : (byte[]) invokeV.objValue;
    }
}
