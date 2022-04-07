package com.baidu.sofire;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
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

    public static boolean copyAllActivityFields(Activity activity, Activity activity2) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, activity2)) == null) {
            if (activity == null || activity2 == null) {
                return false;
            }
            for (Class<Activity> cls = Activity.class; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        if (field.getName().equals("mWindow")) {
                            field.set(activity2, activity.getWindow());
                        } else {
                            field.set(activity2, field.get(activity));
                        }
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean copyAllFields(Class<?> cls, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return false;
            }
            while (cls != null && cls != Object.class) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        field.set(obj2, field.get(obj));
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                }
                cls = cls.getSuperclass();
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) {
            try {
                Field field = cls.getField(str);
                if (field != null) {
                    return field;
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException e) {
                    CommonMethods.handleNuLException(e);
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchFieldException();
        }
        return (Field) invokeLL.objValue;
    }

    public static Field findFieldNoThrow(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str)) == null) {
            try {
                return findField(cls, str);
            } catch (NoSuchFieldException e) {
                CommonMethods.handleNuLException(e);
                return null;
            }
        }
        return (Field) invokeLL.objValue;
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                if (method != null) {
                    return method;
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException e) {
                    CommonMethods.handleNuLException(e);
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchMethodException();
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method findMethodNoThrow(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            try {
                method = findMethod(cls, str, clsArr);
                try {
                    method.setAccessible(true);
                } catch (Throwable th) {
                    th = th;
                    CommonMethods.handleNuLException(th);
                    return method;
                }
            } catch (Throwable th2) {
                th = th2;
                method = null;
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Class<?> loadClassNoThrow(ClassLoader classLoader, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, classLoader, str)) == null) {
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException e) {
                CommonMethods.handleNuLException(e);
                return null;
            }
        }
        return (Class) invokeLL.objValue;
    }
}
