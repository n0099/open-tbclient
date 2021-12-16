package com.baidu.fsg.face.base;

import android.content.Context;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "1.3.7";

    /* renamed from: b  reason: collision with root package name */
    public static final int f35012b = 32;

    /* renamed from: c  reason: collision with root package name */
    public static c f35013c;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f35013c == null) {
                synchronized (c.class) {
                    if (f35013c == null) {
                        f35013c = new c();
                    }
                }
            }
            return f35013c;
        }
        return (c) invokeV.objValue;
    }

    private b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new b(this) { // from class: com.baidu.fsg.face.base.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.fsg.face.base.b
            public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, eVar, aVar, sapiBiometricDto, context) == null) {
                    com.baidu.fsg.face.base.d.d.d(d.class.getSimpleName(), "ERROR with implement Biometric!");
                }
            }
        } : (b) invokeV.objValue;
    }

    @Override // com.baidu.fsg.face.base.d
    public b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            try {
                return (b) Class.forName(a.a(i2)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
                return c();
            }
        }
        return (b) invokeI.objValue;
    }
}
