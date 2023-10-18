package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class an {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "PluginLoader";
    public static ClassLoader b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833692866, "Lcom/baidu/mobads/sdk/internal/an;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833692866, "Lcom/baidu/mobads/sdk/internal/an;");
        }
    }

    public an() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return ck.d.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.b();
        }
    }

    public static Activity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            s sVar = (s) c.a().a(c.a.b).a();
            if (sVar != null) {
                return sVar.c();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            s sVar = (s) c.a().a(c.a.b).a();
            if (sVar != null) {
                return sVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            s sVar = (s) c.a().a(c.a.b).a();
            if (sVar != null) {
                return sVar.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void g() {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, null) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.g();
        }
    }

    public static void h() {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, null) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a();
        }
    }

    public static View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            s sVar = (s) c.a().a(c.a.b).a();
            if (sVar != null) {
                return sVar.a(context);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static void b(int i) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65551, null, i) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.b(i);
        }
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        InterceptResult invokeLLLL;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, classLoader)) == null) {
            if (!a()) {
                return classLoader;
            }
            if (b == null && (rVar = (r) c.a().a(c.a.a).a()) != null) {
                b = rVar.getClassLoaderFromJar(str, str2, str3, classLoader);
            }
            return b;
        }
        return (ClassLoader) invokeLLLL.objValue;
    }

    public static void a(double d, am.b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d), bVar, aVar}) == null) {
            r rVar = (r) c.a().a(c.a.a).a();
            if (rVar != null) {
                rVar.startLoadRemotePhp(d, bVar);
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static void a(int i) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65541, null, i) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(i);
        }
    }

    public static void a(int i, int i2) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65542, null, i, i2) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.b(i, i2);
        }
    }

    public static void b(int i, int i2) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65552, null, i, i2) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(i, i2);
        }
    }

    public static void a(int i, boolean z) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(i, z);
        }
    }

    public static void a(Context context, String str) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(context, str);
        }
    }

    public static void a(Context context, String str, String str2) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, null, context, str, str2) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(context, str, str2);
        }
    }

    public static void a(t tVar) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, tVar) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(tVar);
        }
    }

    public static void a(boolean z) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65547, null, z) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(z);
        }
    }

    public static void a(boolean z, int i, int i2, int i3) {
        s sVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && (sVar = (s) c.a().a(c.a.b).a()) != null) {
            sVar.a(z, i, i2, i3);
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            s sVar = (s) c.a().a(c.a.b).a();
            if (sVar != null) {
                return sVar.f();
            }
            av.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
            return false;
        }
        return invokeV.booleanValue;
    }
}
