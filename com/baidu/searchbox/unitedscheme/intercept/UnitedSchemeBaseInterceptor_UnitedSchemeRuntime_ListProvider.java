package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.pm2;
import com.baidu.tieba.u64;
import com.baidu.tieba.xc3;
import com.baidu.tieba.yc3;
import com.baidu.tieba.yj1;
import com.baidu.tieba.zc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements yj1 {
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

    @Override // com.baidu.tieba.yj1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new pm2());
            arrayList.add(new xc3());
            arrayList.add(new yc3());
            arrayList.add(new zc3());
            arrayList.add(new u64());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
