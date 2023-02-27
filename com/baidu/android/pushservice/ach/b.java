package com.baidu.android.pushservice.ach;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.ach.d.e;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.z.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.android.pushservice.v.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PushScreenReceiver a;

    /* loaded from: classes.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;

        public a(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15927, this, null);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.ach.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0019b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;

        public C0019b(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15922, this, null);
            }
        }
    }

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

    @Override // com.baidu.android.pushservice.v.b
    public int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15921, this, context) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar}) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15924, this, context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, PushScreenReceiver.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15923, this, context, aVar);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, jSONObject) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15886, this, context, jSONObject);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15885, this, context, Integer.valueOf(i)) : invokeLI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15888, this, context) : invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, context, i)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15887, this, context, Integer.valueOf(i)) : invokeLI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15882, this, context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15881, this, context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15884, this, context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15883, this, context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15878, this, context);
        }
    }
}
