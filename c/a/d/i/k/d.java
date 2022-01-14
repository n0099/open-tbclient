package c.a.d.i.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Class<?>, Class<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<? extends T> a;

        /* renamed from: b  reason: collision with root package name */
        public final T f3202b;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416750638, "Lc/a/d/i/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-416750638, "Lc/a/d/i/k/d;");
                return;
            }
        }
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        a.put(Byte.class, Byte.TYPE);
        a.put(Character.class, Character.TYPE);
        a.put(Short.class, Short.TYPE);
        a.put(Integer.class, Integer.TYPE);
        a.put(Float.class, Float.TYPE);
        a.put(Long.class, Long.TYPE);
        a.put(Double.class, Double.TYPE);
        HashMap<Class<?>, Class<?>> hashMap2 = a;
        Class<?> cls = Boolean.TYPE;
        hashMap2.put(cls, cls);
        HashMap<Class<?>, Class<?>> hashMap3 = a;
        Class<?> cls2 = Byte.TYPE;
        hashMap3.put(cls2, cls2);
        HashMap<Class<?>, Class<?>> hashMap4 = a;
        Class<?> cls3 = Character.TYPE;
        hashMap4.put(cls3, cls3);
        HashMap<Class<?>, Class<?>> hashMap5 = a;
        Class<?> cls4 = Short.TYPE;
        hashMap5.put(cls4, cls4);
        HashMap<Class<?>, Class<?>> hashMap6 = a;
        Class<?> cls5 = Integer.TYPE;
        hashMap6.put(cls5, cls5);
        HashMap<Class<?>, Class<?>> hashMap7 = a;
        Class<?> cls6 = Float.TYPE;
        hashMap7.put(cls6, cls6);
        HashMap<Class<?>, Class<?>> hashMap8 = a;
        Class<?> cls7 = Long.TYPE;
        hashMap8.put(cls7, cls7);
        HashMap<Class<?>, Class<?>> hashMap9 = a;
        Class<?> cls8 = Double.TYPE;
        hashMap9.put(cls8, cls8);
    }

    public static <T> T a(Object obj, String str, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, obj, str, objArr)) == null) ? (T) b(obj, str, objArr) : (T) invokeLLL.objValue;
    }

    public static <T> T b(Object obj, String str, Object[] objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, str, objArr)) == null) ? (T) f(obj.getClass(), str, i(objArr)).invoke(obj, j(objArr)) : (T) invokeLLL.objValue;
    }

    public static Object c(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, obj2)) == null) {
            if (obj == null) {
                return obj2;
            }
            if (obj2 == null) {
                return obj;
            }
            if (obj.getClass().isArray() && obj2.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                int length = Array.getLength(obj);
                int length2 = Array.getLength(obj2) + length;
                Object newInstance = Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    if (i2 < length) {
                        Array.set(newInstance, i2, Array.get(obj, i2));
                    } else {
                        Array.set(newInstance, i2, Array.get(obj2, i2 - length));
                    }
                }
                return newInstance;
            } else if ((obj instanceof List) && (obj2 instanceof List)) {
                List list = (List) obj;
                List list2 = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size() + list2.size());
                arrayList.addAll(list);
                arrayList.addAll(list2);
                return arrayList;
            } else {
                return obj;
            }
        }
        return invokeLL.objValue;
    }

    public static boolean d(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, clsArr, clsArr2)) == null) {
            if (clsArr == null) {
                return clsArr2 == null || clsArr2.length == 0;
            }
            int length = clsArr.length;
            if (clsArr2 == null) {
                return length == 0;
            } else if (length != clsArr2.length) {
                return false;
            } else {
                for (int i2 = length - 1; i2 >= 0; i2--) {
                    if (clsArr[i2].isAssignableFrom(clsArr2[i2]) || (a.containsKey(clsArr[i2]) && a.get(clsArr[i2]).equals(a.get(clsArr2[i2])))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Method e(Method[] methodArr, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, methodArr, str, clsArr)) == null) {
            if (str != null) {
                for (Method method : methodArr) {
                    if (method.getName().equals(str) && d(method.getParameterTypes(), clsArr)) {
                        return method;
                    }
                }
                throw new NoSuchMethodException(str);
            }
            throw new NullPointerException("Method name must not be null.");
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method f(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException, SecurityException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            Method e2 = e(cls.getDeclaredMethods(), str, clsArr);
            if (e2 != null) {
                e2.setAccessible(true);
            }
            return e2;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method g(Object obj, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, str, clsArr)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object h(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, cls, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLLL.objValue;
    }

    public static Class<?>[] i(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, objArr)) == null) {
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj != null && (obj instanceof a)) {
                    clsArr[i2] = ((a) obj).a;
                } else {
                    clsArr[i2] = obj == null ? null : obj.getClass();
                }
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static Object[] j(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, objArr)) == null) {
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            Object[] objArr2 = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (obj != null && (obj instanceof a)) {
                    objArr2[i2] = ((a) obj).f3202b;
                } else {
                    objArr2[i2] = obj;
                }
            }
            return objArr2;
        }
        return (Object[]) invokeL.objValue;
    }

    public static Object k(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, obj, str, clsArr, objArr)) == null) {
            Method g2 = g(obj, str, clsArr);
            if (g2 != null) {
                try {
                    g2.setAccessible(true);
                    return g2.invoke(obj, objArr);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return invokeLLLL.objValue;
    }

    public static void l(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, obj, cls, str, obj2) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        }
    }
}
