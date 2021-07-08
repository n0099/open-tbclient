package com.baidu.apollon.restnet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC0064a f3852a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.apollon.restnet.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0064a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public a() {
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

    public static InterfaceC0064a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f3852a : (InterfaceC0064a) invokeV.objValue;
    }

    public static void a(InterfaceC0064a interfaceC0064a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, interfaceC0064a) == null) {
            f3852a = interfaceC0064a;
        }
    }
}
