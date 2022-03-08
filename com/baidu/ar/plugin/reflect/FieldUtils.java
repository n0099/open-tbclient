package com.baidu.ar.plugin.reflect;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FieldUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Field> sFieldCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-546801082, "Lcom/baidu/ar/plugin/reflect/FieldUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-546801082, "Lcom/baidu/ar/plugin/reflect/FieldUtils;");
                return;
            }
        }
        sFieldCache = new HashMap();
    }

    public FieldUtils() {
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

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, cls, str, z)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            Validate.isTrue(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!MemberUtils.isAccessible(declaredField)) {
                    if (!z) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
        return (Field) invokeLLZ.objValue;
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Field field;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, z)) == null) {
            Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
            Validate.isTrue(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
            String key = getKey(cls, str);
            synchronized (sFieldCache) {
                field = sFieldCache.get(key);
            }
            if (field != null) {
                if (z && !field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            }
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    declaredField = cls2.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z) {
                        declaredField.setAccessible(true);
                    } else {
                        continue;
                    }
                }
                synchronized (sFieldCache) {
                    sFieldCache.put(key, declaredField);
                }
                return declaredField;
            }
            Field field2 = null;
            for (Class<?> cls3 : Utils.getAllInterfaces(cls)) {
                try {
                    Field field3 = cls3.getField(str);
                    Validate.isTrue(field2 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    field2 = field3;
                } catch (NoSuchFieldException unused2) {
                }
            }
            synchronized (sFieldCache) {
                sFieldCache.put(key, field2);
            }
            return field2;
        }
        return (Field) invokeLLZ.objValue;
    }

    public static String getKey(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, str)) == null) {
            return cls.toString() + "#" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, field, obj, z)) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            return field.get(obj);
        }
        return invokeLLZ.objValue;
    }

    public static Object readStaticField(Field field, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, field, z)) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
            return readField(field, (Object) null, z);
        }
        return invokeLZ.objValue;
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, obj, str, obj2) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, true);
            Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(declaredField, obj, obj2, false);
        }
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{field, obj, obj2, Boolean.valueOf(z)}) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            } else {
                MemberUtils.setAccessibleWorkaround(field);
            }
            field.set(obj, obj2);
        }
    }

    public static void writeStaticField(Field field, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65554, null, field, obj, z) == null) {
            Validate.isTrue(field != null, "The field must not be null", new Object[0]);
            Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
            writeField(field, (Object) null, obj, z);
        }
    }

    public static Object readStaticField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, str)) == null) {
            Field field = getField(cls, str, true);
            Validate.isTrue(field != null, "Cannot locate field '%s' on %s", str, cls);
            return readStaticField(field, true);
        }
        return invokeLL.objValue;
    }

    public static Object readField(Field field, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, field, obj)) == null) ? readField(field, obj, true) : invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, obj, str, obj2) == null) {
            writeField(obj, str, obj2, true);
        }
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, cls, str, obj) == null) {
            Field field = getField(cls, str, true);
            Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
            writeStaticField(field, obj, true);
        }
    }

    public static Object readField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, str)) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, true);
            Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
            return readField(field, obj, false);
        }
        return invokeLL.objValue;
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{obj, str, obj2, Boolean.valueOf(z)}) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, true);
            Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
            writeField(field, obj, obj2, z);
        }
    }

    public static Object readField(Object obj, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, obj, str, z)) == null) {
            Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z);
            Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
            return readField(field, obj, z);
        }
        return invokeLLZ.objValue;
    }

    public static void writeField(Field field, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, field, obj, obj2) == null) {
            writeField(field, obj, obj2, true);
        }
    }

    public static Field getField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) ? getField(cls, str, true) : (Field) invokeLL.objValue;
    }
}
