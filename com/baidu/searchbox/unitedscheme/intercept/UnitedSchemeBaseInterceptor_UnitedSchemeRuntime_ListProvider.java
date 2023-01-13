package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ci2;
import com.baidu.tieba.h24;
import com.baidu.tieba.k83;
import com.baidu.tieba.l83;
import com.baidu.tieba.m83;
import com.baidu.tieba.nf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements nf1 {
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

    @Override // com.baidu.tieba.nf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ci2());
            arrayList.add(new k83());
            arrayList.add(new l83());
            arrayList.add(new m83());
            arrayList.add(new h24());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
