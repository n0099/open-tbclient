package com.baidu.android.pushservice.ach.e;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c {
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

    @Override // com.baidu.android.pushservice.ach.e.c
    public void a(Service service, Intent intent, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{service, intent, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15987, this, service, intent, Integer.valueOf(i), Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.android.pushservice.ach.e.c
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15950, this, context);
        }
    }

    @Override // com.baidu.android.pushservice.ach.e.c
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15949, this, context) : invokeL.booleanValue;
    }
}
