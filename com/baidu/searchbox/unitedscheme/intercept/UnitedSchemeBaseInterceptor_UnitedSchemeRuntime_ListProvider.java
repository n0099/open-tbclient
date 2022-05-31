package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad2;
import com.repackage.ex3;
import com.repackage.i33;
import com.repackage.j33;
import com.repackage.k33;
import com.repackage.na1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements na1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.na1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ad2());
            arrayList.add(new i33());
            arrayList.add(new j33());
            arrayList.add(new k33());
            arrayList.add(new ex3());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
