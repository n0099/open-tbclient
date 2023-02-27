package com.baidu.android.pushservice.v;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.ach.d.e;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements com.baidu.android.pushservice.v.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.android.pushservice.v.b a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1588647595, "Lcom/baidu/android/pushservice/v/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1588647595, "Lcom/baidu/android/pushservice/v/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public c() {
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
        this.a = null;
        this.a = new com.baidu.android.pushservice.ach.b();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            com.baidu.android.pushservice.v.b bVar = this.a;
            if (bVar == null) {
                return 2;
            }
            try {
                return bVar.a(context);
            } catch (Throwable unused) {
                h(context);
                return 2;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar) {
        com.baidu.android.pushservice.v.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar}) == null) || (bVar2 = this.a) == null) {
            return;
        }
        try {
            bVar2.a(context, i, eVar, j, bVar);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, PushScreenReceiver.a aVar) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(context, aVar);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, context, str, i) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.a == null && i == 1) {
            return;
        }
        Utility.b(context, str, i);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, JSONObject jSONObject) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, jSONObject) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(context, jSONObject);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i)) == null) {
            com.baidu.android.pushservice.v.b bVar = this.a;
            if (bVar == null) {
                return false;
            }
            try {
                return bVar.a(context, i);
            } catch (Throwable unused) {
                h(context);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            com.baidu.android.pushservice.v.b bVar = this.a;
            if (bVar == null) {
                return 2;
            }
            try {
                return bVar.b(context);
            } catch (Throwable unused) {
                h(context);
                return 2;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i)) == null) {
            com.baidu.android.pushservice.v.b bVar = this.a;
            if (bVar == null) {
                return false;
            }
            try {
                return bVar.b(context, i);
            } catch (Throwable unused) {
                h(context);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.android.pushservice.v.b
    public void c(Context context) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.c(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void c(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, context, i) == null) {
            if (this.a == null && i == 1) {
                return;
            }
            Utility.a(context, "com.baidu.android.pushservice.ach.PushAchProvider", i);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void d(Context context) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, context) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.d(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void d(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, context, i) == null) {
            if (this.a == null && i == 1) {
                return;
            }
            Utility.b(context, "com.baidu.android.pushservice.ach.PushAchService", i);
            Utility.b(context, "com.baidu.android.pushservice.ach.power.PushAchHpkitService", i);
            Utility.a(context, "com.baidu.android.pushservice.ach.PushAchProvider", i);
            for (String str : com.baidu.android.pushservice.ach.a.a) {
                Utility.b(context, str, i);
            }
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void e(Context context) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, context) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.e(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void f(Context context) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, context) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.f(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void g(Context context) {
        com.baidu.android.pushservice.v.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, context) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.g(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.a = null;
            d(context, 2);
        }
    }
}
