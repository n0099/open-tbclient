package com.baidu.searchbox.unitedscheme.intercept;

import c.a.j0.a.a;
import c.a.q0.a.f2.g.b;
import c.a.q0.a.f2.g.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider() {
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

    @Override // c.a.j0.a.a
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.q0.a.x0.a.e.a());
            arrayList.add(new c.a.q0.a.f2.g.a());
            arrayList.add(new b());
            arrayList.add(new c());
            arrayList.add(new c.a.q0.j.w.a());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
