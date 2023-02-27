package com.baidu.android.pushservice.ach.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static b d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? (b) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15945, null, context) : (b) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.ach.f.b
    public int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15948, this, context) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.f.b
    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15947, this, context) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.ach.f.b
    public int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15942, this, context) : invokeL.intValue;
    }
}
