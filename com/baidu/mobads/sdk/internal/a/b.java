package com.baidu.mobads.sdk.internal.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public int a(Object[] objArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, objArr, i, i2)) == null) {
            if (objArr != null && objArr.length > i && (objArr[i] instanceof Integer)) {
                return ((Integer) objArr[i]).intValue();
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public Object a(Object[] objArr, int i, Object obj) {
        InterceptResult invokeLIL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr, i, obj)) == null) {
            if (objArr != null && objArr.length > i && (obj2 = objArr[i]) != null) {
                return obj2;
            }
            return obj;
        }
        return invokeLIL.objValue;
    }
}
