package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ac1;
import com.repackage.ne2;
import com.repackage.ry3;
import com.repackage.v43;
import com.repackage.w43;
import com.repackage.x43;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements ac1 {
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

    @Override // com.repackage.ac1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ne2());
            arrayList.add(new v43());
            arrayList.add(new w43());
            arrayList.add(new x43());
            arrayList.add(new ry3());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
