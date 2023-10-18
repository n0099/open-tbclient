package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public class ar {
    public static /* synthetic */ Interceptable $ic = null;
    public static br a = null;
    public static final String b = "com.baidu.mobads.sdk.internal.ar";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833692990, "Lcom/baidu/mobads/sdk/internal/ar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833692990, "Lcom/baidu/mobads/sdk/internal/ar;");
                return;
            }
        }
        a = br.a();
    }

    public ar() {
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

    public static Class<?> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, classLoader)) == null) {
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (Exception e) {
                    a.a(b, Log.getStackTraceString(e));
                }
            }
            return null;
        }
        return (Class) invokeLL.objValue;
    }

    public static Field b(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, cls, str)) == null) {
            while (cls != Object.class) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception e) {
                    a.b(b, Log.getStackTraceString(e));
                    cls = cls.getSuperclass();
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static ClassLoader a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return an.a(bx.a(context), context.getFilesDir().getAbsolutePath(), (String) null, ar.class.getClassLoader());
        }
        return (ClassLoader) invokeL.objValue;
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, cls, obj, str, clsArr, objArr)) == null) {
            try {
                if (!a(cls, str, clsArr)) {
                    return null;
                }
                return b(cls, str, clsArr).invoke(obj, objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    public static Object a(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, str)) == null) {
            Field b2 = b((Class<?>) cls, str);
            if (b2 != null) {
                b2.setAccessible(true);
                try {
                    return b2.get(cls);
                } catch (Exception e) {
                    a.b(b, Log.getStackTraceString(e));
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, classLoader, str, str2)) == null) {
            try {
                return a((Class) Class.forName(str, true, classLoader), str2);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, cls, str, clsArr)) == null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (declaredMethod == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            Field b2 = b(obj, str);
            if (b2 != null) {
                b2.setAccessible(true);
                try {
                    return b2.get(obj);
                } catch (Exception e) {
                    a.b(b, Log.getStackTraceString(e));
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, obj, str, clsArr, objArr)) == null) {
            try {
                return a(obj.getClass(), obj, str, clsArr, objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static Object a(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, str, objArr)) == null) {
            try {
                return a(obj.getClass(), obj, str, a(objArr), objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, str, classLoader, str2, clsArr, objArr)) == null) {
            try {
                Class<?> a2 = a(str, classLoader);
                if (a2 == null) {
                    return null;
                }
                Method declaredMethod = a2.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, classLoader, invocationHandler)) == null) {
            Class<?> a2 = a(str, classLoader);
            if (a2 != null) {
                return Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, invocationHandler);
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, str, classLoader, clsArr, objArr)) == null) {
            try {
                Class<?> a2 = a(str, classLoader);
                if (a2 == null) {
                    return null;
                }
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, obj, classLoader, str2, clsArr, objArr})) == null) {
            try {
                Class<?> a2 = a(str, classLoader);
                if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeCommon.objValue;
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLLL;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65551, null, str, obj, str2, clsArr, objArr)) == null) {
            try {
                Class<?> a2 = a(str);
                if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                    return null;
                }
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, invocationHandler)) == null) {
            Class<?> a2 = a(str);
            if (a2 != null) {
                return Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, invocationHandler);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, str, clsArr, objArr)) == null) {
            try {
                Class<?> a2 = a(str);
                if (a2 == null) {
                    return null;
                }
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, cls, str, clsArr)) == null) {
            try {
                if (cls.getDeclaredMethod(str, clsArr) == null) {
                    return false;
                }
                return true;
            } catch (NoSuchMethodException unused) {
                return false;
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Class<?>[] a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, objArr)) == null) {
            try {
                int length = objArr.length;
                Class<?>[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                return clsArr;
            } catch (Exception e) {
                a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return (Class[]) invokeL.objValue;
    }

    public static Field b(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception e) {
                    a.b(b, Log.getStackTraceString(e));
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }
}
