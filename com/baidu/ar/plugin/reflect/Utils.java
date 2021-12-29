package com.baidu.ar.plugin.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1914741096, "Lcom/baidu/ar/plugin/reflect/Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1914741096, "Lcom/baidu/ar/plugin/reflect/Utils;");
                return;
            }
        }
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public Utils() {
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

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            getAllInterfaces(cls, linkedHashSet);
            return new ArrayList(linkedHashSet);
        }
        return (List) invokeL.objValue;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr, objArr2)) == null) {
            if (objArr != null || objArr2 == null || objArr2.length <= 0) {
                if (objArr2 != null || objArr == null || objArr.length <= 0) {
                    return objArr == null || objArr2 == null || objArr.length == objArr2.length;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, clsArr)) == null) ? (clsArr == null || clsArr.length == 0) ? EMPTY_CLASS_ARRAY : clsArr : (Class[]) invokeL.objValue;
    }

    public static Class<?>[] toClass(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            if (objArr.length == 0) {
                return EMPTY_CLASS_ARRAY;
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, objArr)) == null) ? (objArr == null || objArr.length == 0) ? EMPTY_OBJECT_ARRAY : objArr : (Object[]) invokeL.objValue;
    }

    public static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cls, hashSet) == null) {
            while (cls != null) {
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (hashSet.add(cls2)) {
                        getAllInterfaces(cls2, hashSet);
                    }
                }
                cls = cls.getSuperclass();
            }
        }
    }
}
