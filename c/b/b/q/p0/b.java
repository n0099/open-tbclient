package c.b.b.q.p0;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class a(String str) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e2) {
                throw new ReflectionException("Class not found: " + str, e2);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static c b(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            try {
                return new c(cls.getConstructor(clsArr));
            } catch (NoSuchMethodException e2) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e2);
            } catch (SecurityException e3) {
                throw new ReflectionException("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e3);
            }
        }
        return (c) invokeLL.objValue;
    }

    public static c c(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, clsArr)) == null) {
            try {
                return new c(cls.getDeclaredConstructor(clsArr));
            } catch (NoSuchMethodException e2) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e2);
            } catch (SecurityException e3) {
                throw new ReflectionException("Security violation while getting constructor for class: " + cls.getName(), e3);
            }
        }
        return (c) invokeLL.objValue;
    }

    public static d[] d(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            Field[] declaredFields = cls.getDeclaredFields();
            d[] dVarArr = new d[declaredFields.length];
            int length = declaredFields.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2] = new d(declaredFields[i2]);
            }
            return dVarArr;
        }
        return (d[]) invokeL.objValue;
    }

    public static String e(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) ? cls.getSimpleName() : (String) invokeL.objValue;
    }

    public static boolean f(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, cls2)) == null) ? cls.isAssignableFrom(cls2) : invokeLL.booleanValue;
    }

    public static boolean g(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) ? cls.isMemberClass() : invokeL.booleanValue;
    }

    public static boolean h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? Modifier.isStatic(cls.getModifiers()) : invokeL.booleanValue;
    }

    public static <T> T i(Class<T> cls) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e2);
            } catch (InstantiationException e3) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e3);
            }
        }
        return (T) invokeL.objValue;
    }
}
