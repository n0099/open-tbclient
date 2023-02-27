package com.baidu.android.pushservice.ach;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.ach.c.b;
import com.baidu.android.pushservice.manageach.components.BaseAchService;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PushAchService extends BaseAchService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* loaded from: classes.dex */
    public class a implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushAchService a;

        public a(PushAchService pushAchService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushAchService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushAchService;
        }

        @Override // com.baidu.android.pushservice.ach.c.b.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15908, this, Integer.valueOf(i));
            }
        }

        @Override // com.baidu.android.pushservice.ach.c.b.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15907, this, Boolean.valueOf(z), Integer.valueOf(i));
            }
        }
    }

    public PushAchService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = PushAchService.class.getName();
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public int a(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, intent, i, i2)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15934, this, intent, Integer.valueOf(i), Integer.valueOf(i2)) : invokeLII.intValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15933, this, intent) : (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15936, this, null);
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15935, this, null);
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15930, this, intent) : invokeL.booleanValue;
    }

    public final void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15929, this, intent);
        }
    }
}
