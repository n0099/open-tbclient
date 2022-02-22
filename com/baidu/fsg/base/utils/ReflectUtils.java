package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class ReflectUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f34097b;

    /* loaded from: classes10.dex */
    public class NULL {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReflectUtils a;

        public NULL(ReflectUtils reflectUtils) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reflectUtils};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = reflectUtils;
        }
    }

    public ReflectUtils(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cls;
        this.f34097b = true;
    }

    public ReflectUtils(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = obj;
        this.f34097b = false;
    }

    public static ReflectUtils a(Constructor<?> constructor, Object... objArr) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, constructor, objArr)) == null) {
            try {
                return on(((Constructor) accessible(constructor)).newInstance(objArr));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public static ReflectUtils a(Method method, Object obj, Object... objArr) throws RuntimeException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, method, obj, objArr)) == null) {
            try {
                accessible(method);
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return on(obj);
                }
                return on(method.invoke(obj, objArr));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLLL.objValue;
    }

    public static Class<?> a(String str, ClassLoader classLoader) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, classLoader)) == null) {
            try {
                return Class.forName(str, true, classLoader);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj : invokeL.objValue;
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, clsArr)) == null) {
            Class<?> type = type();
            try {
                return type.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                do {
                    try {
                        return type.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused2) {
                        type = type.getSuperclass();
                        if (type == null) {
                            throw new NoSuchMethodException();
                        }
                    }
                } while (type == null);
                throw new NoSuchMethodException();
            }
        }
        return (Method) invokeLL.objValue;
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, method, str, clsArr)) == null) ? method.getName().equals(str) && a(method.getParameterTypes(), clsArr) : invokeLLL.booleanValue;
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, clsArr, clsArr2)) == null) {
            if (clsArr.length == clsArr2.length) {
                for (int i2 = 0; i2 < clsArr2.length; i2++) {
                    if (clsArr2[i2] != NULL.class && !wrapper(clsArr[i2]).isAssignableFrom(wrapper(clsArr2[i2]))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Class<?>[] a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, objArr)) == null) {
            if (objArr == null) {
                return new Class[0];
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                clsArr[i2] = obj == null ? NULL.class : obj.getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, t)) == null) {
            if (t == null) {
                return null;
            }
            if (t instanceof Member) {
                Member member = (Member) t;
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return t;
                }
            }
            if (!t.isAccessible()) {
                t.setAccessible(true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    private Field b(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            Class<?> type = type();
            try {
                return type.getField(str);
            } catch (NoSuchFieldException e2) {
                do {
                    try {
                        return (Field) accessible(type.getDeclaredField(str));
                    } catch (NoSuchFieldException unused) {
                        type = type.getSuperclass();
                        if (type != null) {
                            throw new RuntimeException(e2);
                        }
                    }
                } while (type != null);
                throw new RuntimeException(e2);
            }
        }
        return (Field) invokeL.objValue;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Method[] methods;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, clsArr)) == null) {
            Class<?> type = type();
            for (Method method : type.getMethods()) {
                if (a(method, str, clsArr)) {
                    return method;
                }
            }
            do {
                for (Method method2 : type.getDeclaredMethods()) {
                    if (a(method2, str, clsArr)) {
                        return method2;
                    }
                }
                type = type.getSuperclass();
            } while (type != null);
            throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
        }
        return (Method) invokeLL.objValue;
    }

    public static Class<?> c(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Class) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            int length = str.length();
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                return str.toLowerCase();
            }
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
        return (String) invokeL.objValue;
    }

    public static ReflectUtils on(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, cls)) == null) ? new ReflectUtils(cls) : (ReflectUtils) invokeL.objValue;
    }

    public static ReflectUtils on(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, obj)) == null) ? new ReflectUtils(obj) : (ReflectUtils) invokeL.objValue;
    }

    public static ReflectUtils on(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? on(c(str)) : (ReflectUtils) invokeL.objValue;
    }

    public static ReflectUtils on(String str, ClassLoader classLoader) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, classLoader)) == null) ? on(a(str, classLoader)) : (ReflectUtils) invokeLL.objValue;
    }

    public static Class<?> wrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
        }
        return (Class) invokeL.objValue;
    }

    public <P> P as(Class<P> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler(this, this.a instanceof Map) { // from class: com.baidu.fsg.base.utils.ReflectUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ReflectUtils f34098b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34098b = this;
                this.a = r7;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                    String name = method.getName();
                    try {
                        return ReflectUtils.on(this.f34098b.a).call(name, objArr).get();
                    } catch (RuntimeException e2) {
                        if (this.a) {
                            Map map = (Map) this.f34098b.a;
                            int length = objArr == null ? 0 : objArr.length;
                            if (length == 0 && name.startsWith("get")) {
                                return map.get(ReflectUtils.d(name.substring(3)));
                            }
                            if (length == 0 && name.startsWith("is")) {
                                return map.get(ReflectUtils.d(name.substring(2)));
                            }
                            if (length == 1 && name.startsWith("set")) {
                                map.put(ReflectUtils.d(name.substring(3)), objArr[0]);
                                return null;
                            }
                        }
                        throw e2;
                    }
                }
                return invokeLLL.objValue;
            }
        }) : (P) invokeL.objValue;
    }

    public ReflectUtils call(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? call(str, new Object[0]) : (ReflectUtils) invokeL.objValue;
    }

    public ReflectUtils call(String str, Object... objArr) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) {
            Class<?>[] a = a(objArr);
            try {
                try {
                    return a(a(str, a), this.a, objArr);
                } catch (NoSuchMethodException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (NoSuchMethodException unused) {
                return a(b(str, a), this.a, objArr);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public ReflectUtils create() throws RuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? create(new Object[0]) : (ReflectUtils) invokeV.objValue;
    }

    public ReflectUtils create(Object... objArr) throws RuntimeException {
        InterceptResult invokeL;
        Constructor<?>[] declaredConstructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            Class<?>[] a = a(objArr);
            try {
                return a(type().getDeclaredConstructor(a), objArr);
            } catch (NoSuchMethodException e2) {
                for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                    if (a(constructor.getParameterTypes(), a)) {
                        return a(constructor, objArr);
                    }
                }
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof ReflectUtils) {
                return this.a.equals(((ReflectUtils) obj).get());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ReflectUtils field(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return on(b(str).get(this.a));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeL.objValue;
    }

    public Map<String, ReflectUtils> fields() {
        InterceptResult invokeV;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Class<?> type = type();
            do {
                for (Field field : type.getDeclaredFields()) {
                    if ((!this.f34097b) ^ Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!linkedHashMap.containsKey(name)) {
                            linkedHashMap.put(name, field(name));
                        }
                    }
                }
                type = type.getSuperclass();
            } while (type != null);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public <T> T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (T) this.a : (T) invokeV.objValue;
    }

    public <T> T get(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? (T) field(str).get() : (T) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.hashCode() : invokeV.intValue;
    }

    public ReflectUtils set(String str, Object obj) throws RuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, obj)) == null) {
            try {
                Field b2 = b(str);
                b2.setAccessible(true);
                b2.set(this.a, a(obj));
                return this;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ReflectUtils) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
    }

    public Class<?> type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34097b ? (Class) this.a : this.a.getClass() : (Class) invokeV.objValue;
    }
}
