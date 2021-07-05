package com.baidu.ar.h;

import com.baidu.android.common.others.java.ReflectionUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(Object obj, String str, String str2, Object obj2, Class<?> cls) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, obj, str, str2, obj2, cls)) == null) {
            try {
                return Class.forName(str).getDeclaredMethod(str2, cls).invoke(obj, obj2);
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "invokeMethod() className = " + str + " && methodName = " + str2 + " error!!!");
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, clsArr, objArr)) == null) {
            try {
                return a(a(str, clsArr), objArr);
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "getNewInstance(params) className = " + str + " error!!!");
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object a(Constructor<?> constructor, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, constructor, objArr)) == null) {
            try {
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "getNewInstance() error!!!");
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Constructor<?> a(String str, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, clsArr)) == null) {
            try {
                return Class.forName(str).getDeclaredConstructor(clsArr);
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "getSingleInstance() className = " + str + " error!!!");
                return null;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static boolean a(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, classLoader)) == null) {
            try {
                return Class.forName(str, false, classLoader) != null;
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "isClassExist() class " + str + " is not exist!!!");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object aV(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return Class.forName(str).newInstance();
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "getNewInstance() className = " + str + " error!!!");
                return null;
            }
        }
        return invokeL.objValue;
    }

    public static Object m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            try {
                return Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                b.k(ReflectionUtils.TAG, "getSingleInstance() className = " + str + " error!!!");
                return null;
            }
        }
        return invokeLL.objValue;
    }
}
