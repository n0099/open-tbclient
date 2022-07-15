package com.baidu.searchbox.unitedscheme;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c13;
import com.repackage.d13;
import com.repackage.in3;
import com.repackage.nb1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements nb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider() {
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

    @Override // com.repackage.nb1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c13());
            arrayList.add(new d13());
            arrayList.add(new in3());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
