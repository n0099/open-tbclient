package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.d24;
import com.baidu.tieba.g83;
import com.baidu.tieba.h83;
import com.baidu.tieba.i83;
import com.baidu.tieba.jf1;
import com.baidu.tieba.yh2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements jf1 {
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

    @Override // com.baidu.tieba.jf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new yh2());
            arrayList.add(new g83());
            arrayList.add(new h83());
            arrayList.add(new i83());
            arrayList.add(new d24());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
