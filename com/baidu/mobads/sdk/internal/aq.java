package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Map<String, aq> c;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<?> a;
    public Method[] b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833692959, "Lcom/baidu/mobads/sdk/internal/aq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833692959, "Lcom/baidu/mobads/sdk/internal/aq;");
                return;
            }
        }
        c = new HashMap();
    }

    public aq(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        try {
            Class<?> cls = Class.forName(str, true, bq.a(context));
            this.a = cls;
            this.b = cls.getMethods();
        } catch (Throwable th) {
            br.a().a(th);
        }
    }

    public static aq a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (!c.containsKey(str) || c.get(str).a == null) {
                synchronized (aq.class) {
                    if (!c.containsKey(str) || c.get(str).a == null) {
                        c.put(str, new aq(context, str));
                    }
                }
            }
            return c.get(str);
        }
        return (aq) invokeLL.objValue;
    }

    private Method a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Method[] methodArr = this.b;
            if (methodArr == null) {
                return null;
            }
            for (Method method : methodArr) {
                if (method.getName().equals(str)) {
                    method.setAccessible(true);
                    return method;
                }
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLL;
        Constructor<?> constructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, clsArr, objArr)) == null) {
            if (objArr != null) {
                try {
                    if (objArr.length != 0) {
                        constructor = this.a.getConstructor(clsArr);
                        return constructor.newInstance(objArr);
                    }
                } catch (Throwable th) {
                    br.a().a(th);
                    return null;
                }
            }
            constructor = this.a.getConstructor(new Class[0]);
            return constructor.newInstance(objArr);
        }
        return invokeLL.objValue;
    }

    public void a(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str, objArr) == null) {
            try {
                Method a = a(str);
                if (a != null) {
                    if (objArr != null && objArr.length != 0) {
                        a.invoke(obj, objArr);
                        return;
                    }
                    a.invoke(obj, new Object[0]);
                }
            } catch (Throwable th) {
                br.a().a(th);
            }
        }
    }

    public Object b(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, str, objArr)) == null) {
            try {
                Method a = a(str);
                if (a != null) {
                    if (objArr != null && objArr.length != 0) {
                        return a.invoke(obj, objArr);
                    }
                    return a.invoke(obj, new Object[0]);
                }
                return null;
            } catch (Throwable th) {
                br.a().a(th);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:4:0x0004, B:7:0x000c, B:10:0x0010, B:12:0x001c, B:14:0x0020, B:11:0x0015), top: B:24:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(Object obj, String str, Object... objArr) {
        Object invoke;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, obj, str, objArr)) == null) {
            try {
                Method a = a(str);
                if (a != null) {
                    if (objArr != null && objArr.length != 0) {
                        invoke = a.invoke(obj, objArr);
                        if (!(invoke instanceof String)) {
                            return (String) invoke;
                        }
                        return null;
                    }
                    invoke = a.invoke(obj, new Object[0]);
                    if (!(invoke instanceof String)) {
                    }
                } else {
                    return null;
                }
            } catch (Throwable th) {
                br.a().a(th);
                return null;
            }
        } else {
            return (String) invokeLLL.objValue;
        }
    }
}
