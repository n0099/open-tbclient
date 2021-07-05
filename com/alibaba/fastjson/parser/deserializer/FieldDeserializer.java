package com.alibaba.fastjson.parser.deserializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public abstract class FieldDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BeanContext beanContext;
    public final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, fieldInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    public static void degradeValueAssignment(Field field, Method method, Object obj, Object obj2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, field, method, obj, obj2) == null) || setFieldValue(field, obj, obj2)) {
            return;
        }
        Class<?> cls = obj.getClass();
        cls.getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
    }

    public static boolean setFieldValue(Field field, Object obj, Object obj2) throws IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, field, obj, obj2)) == null) {
            if (field == null || Modifier.isFinal(field.getModifiers())) {
                return false;
            }
            field.set(obj, obj2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public Class<?> getOwnerClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.clazz : (Class) invokeV.objValue;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, obj, z) == null) {
            setValue(obj, Boolean.valueOf(z));
        }
    }

    public void setWrappedValue(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj) == null) {
            throw new JSONException("TODO");
        }
    }

    public void setValue(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, obj, i2) == null) {
            setValue(obj, Integer.valueOf(i2));
        }
    }

    public void setValue(Object obj, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, obj, j) == null) {
            setValue(obj, Long.valueOf(j));
        }
    }

    public void setValue(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, obj, str) == null) {
            setValue(obj, (Object) str);
        }
    }

    public void setValue(Object obj, Object obj2) {
        Method method;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, obj, obj2) == null) {
            if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
                return;
            }
            FieldInfo fieldInfo = this.fieldInfo;
            if (fieldInfo.fieldClass == String.class && (str = fieldInfo.format) != null && str.equals("trim")) {
                obj2 = ((String) obj2).trim();
            }
            try {
                method = this.fieldInfo.method;
            } catch (Exception e2) {
                throw new JSONException("set property error, " + this.clazz.getName() + "#" + this.fieldInfo.name, e2);
            }
            if (method != null) {
                if (this.fieldInfo.getOnly) {
                    if (this.fieldInfo.fieldClass == AtomicInteger.class) {
                        AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                        if (atomicInteger != null) {
                            atomicInteger.set(((AtomicInteger) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
                        AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                        if (atomicLong != null) {
                            atomicLong.set(((AtomicLong) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
                        AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                        if (atomicBoolean != null) {
                            atomicBoolean.set(((AtomicBoolean) obj2).get());
                            return;
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    } else {
                        if (Map.class.isAssignableFrom(method.getReturnType())) {
                            try {
                                Map map = (Map) method.invoke(obj, new Object[0]);
                                if (map == null) {
                                    if (obj2 != null) {
                                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                        return;
                                    }
                                    return;
                                } else if (map == Collections.emptyMap()) {
                                    return;
                                } else {
                                    if (map.isEmpty() && ((Map) obj2).isEmpty()) {
                                        return;
                                    }
                                    String name = map.getClass().getName();
                                    if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                                        if (map.getClass().getName().equals("kotlin.collections.EmptyMap")) {
                                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                            return;
                                        } else {
                                            map.putAll((Map) obj2);
                                            return;
                                        }
                                    }
                                    return;
                                }
                            } catch (InvocationTargetException unused) {
                                degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                return;
                            }
                        }
                        try {
                            Collection collection = (Collection) method.invoke(obj, new Object[0]);
                            if (collection == null || obj2 == null) {
                                if (collection != null || obj2 == null) {
                                    return;
                                }
                                degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                return;
                            }
                            String name2 = collection.getClass().getName();
                            if (collection != Collections.emptySet() && collection != Collections.emptyList() && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                                if (!collection.isEmpty()) {
                                    collection.clear();
                                } else if (((Collection) obj2).isEmpty()) {
                                    return;
                                }
                                if (!name2.equals("kotlin.collections.EmptyList") && !name2.equals("kotlin.collections.EmptySet")) {
                                    collection.addAll((Collection) obj2);
                                    return;
                                }
                                degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                return;
                            }
                            return;
                        } catch (InvocationTargetException unused2) {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                        throw new JSONException("set property error, " + this.clazz.getName() + "#" + this.fieldInfo.name, e2);
                    }
                }
                method.invoke(obj, obj2);
                return;
            }
            Field field = this.fieldInfo.field;
            if (!this.fieldInfo.getOnly) {
                if (field != null) {
                    field.set(obj, obj2);
                }
            } else if (this.fieldInfo.fieldClass == AtomicInteger.class) {
                AtomicInteger atomicInteger2 = (AtomicInteger) field.get(obj);
                if (atomicInteger2 != null) {
                    atomicInteger2.set(((AtomicInteger) obj2).get());
                }
            } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
                AtomicLong atomicLong2 = (AtomicLong) field.get(obj);
                if (atomicLong2 != null) {
                    atomicLong2.set(((AtomicLong) obj2).get());
                }
            } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) field.get(obj);
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(((AtomicBoolean) obj2).get());
                }
            } else if (Map.class.isAssignableFrom(this.fieldInfo.fieldClass)) {
                Map map2 = (Map) field.get(obj);
                if (map2 != null && map2 != Collections.emptyMap() && !map2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map2.putAll((Map) obj2);
                }
            } else {
                Collection collection2 = (Collection) field.get(obj);
                if (collection2 != null && obj2 != null && collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && !collection2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    collection2.clear();
                    collection2.addAll((Collection) obj2);
                }
            }
        }
    }
}
