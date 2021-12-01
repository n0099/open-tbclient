package c.a.c0.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cls, str)) == null) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    h(declaredField, true);
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = null;
            for (Class<?> cls3 : cls.getInterfaces()) {
                try {
                    Field field2 = cls3.getField(str);
                    k.a(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    field = field2;
                } catch (NoSuchFieldException unused2) {
                }
            }
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, str, clsArr)) == null) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                    h(declaredMethod, true);
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            Method method = null;
            for (Class<?> cls3 : cls.getInterfaces()) {
                try {
                    Method method2 = cls3.getMethod(str, clsArr);
                    k.a(method == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    method = method2;
                } catch (NoSuchMethodException unused2) {
                }
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, obj, str, clsArr, objArr)) == null) {
            Method b2 = b(obj.getClass(), str, clsArr);
            b2.setAccessible(true);
            return b2.invoke(obj, objArr);
        }
        return invokeLLLL.objValue;
    }

    public static Object d(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, obj, str)) == null) ? f(a(cls, str), obj) : invokeLLL.objValue;
    }

    public static Object e(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) ? d(obj.getClass(), obj, str) : invokeLL.objValue;
    }

    public static Object f(Field field, Object obj) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, field, obj)) == null) ? field.get(obj) : invokeLL.objValue;
    }

    public static void g(Field field) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, field) == null) {
            k.a(field != null, "The field must not be null", new Object[0]);
            try {
                if (Modifier.isFinal(field.getModifiers())) {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    boolean z = !declaredField.isAccessible();
                    if (z) {
                        declaredField.setAccessible(true);
                    }
                    declaredField.setInt(field, field.getModifiers() & (-17));
                    if (z) {
                        declaredField.setAccessible(false);
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    public static void h(AccessibleObject accessibleObject, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65543, null, accessibleObject, z) == null) || accessibleObject.isAccessible() == z) {
            return;
        }
        accessibleObject.setAccessible(z);
    }

    public static void i(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, cls, obj, str, obj2) == null) {
            k(a(cls, str), obj, obj2);
        }
    }

    public static void j(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, obj, str, obj2) == null) {
            i(obj.getClass(), obj, str, obj2);
        }
    }

    public static void k(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, field, obj, obj2) == null) {
            field.set(obj, obj2);
        }
    }
}
