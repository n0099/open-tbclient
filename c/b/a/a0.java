package c.b.a;

import android.content.Context;
import c.b.a.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class a0 implements v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f31205a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f31206b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f31207c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074088679, "Lc/b/a/a0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074088679, "Lc/b/a/a0;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f31206b = cls;
            f31205a = cls.newInstance();
            f31207c = f31206b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            String str = u0.f31318j;
            o0.g(str, "Api#static reflect exception! " + e2.getMessage());
        }
    }

    public a0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f31206b == null || f31205a == null || f31207c == null) ? false : true : invokeV.booleanValue;
    }

    @Override // c.b.a.v0
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? b() : invokeL.booleanValue;
    }

    public static String a(Context context, Method method) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, method)) == null) {
            Object obj = f31205a;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.b.a.v0
    public v0.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                v0.a aVar = new v0.a();
                aVar.f31329a = a(context, f31207c);
                return aVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (v0.a) invokeL.objValue;
    }
}
