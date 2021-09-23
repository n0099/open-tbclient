package com.baidu.fsg.base.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes5.dex */
public final class JsonUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39633a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class DataType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DataType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static boolean isArray(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? cls != null && cls.isArray() : invokeL.booleanValue;
        }

        public static boolean isBoolean(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) ? cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) : invokeL.booleanValue;
        }

        public static boolean isCollection(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? cls != null && Collection.class.isAssignableFrom(cls) : invokeL.booleanValue;
        }

        public static boolean isJSONObject(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) ? cls != null && JSONObject.class.isAssignableFrom(cls) : invokeL.booleanValue;
        }

        public static boolean isMap(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cls)) == null) ? cls != null && Map.class.isAssignableFrom(cls) : invokeL.booleanValue;
        }

        public static boolean isNull(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) ? obj instanceof JSONObject ? JSONObject.NULL.equals(obj) : obj == null : invokeL.booleanValue;
        }

        public static boolean isNumber(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls)) : invokeL.booleanValue;
        }

        public static boolean isObject(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) ? (cls == null || isRaw(cls) || isArray(cls) || isCollection(cls) || isMap(cls) || isJSONObject(cls)) ? false : true : invokeL.booleanValue;
        }

        public static boolean isRaw(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? isBoolean(cls) || isNumber(cls) || isString(cls) : invokeL.booleanValue;
        }

        public static boolean isString(Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cls)) == null) ? cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class Decoder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Decoder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static <T> T a(Class<T> cls) throws JSONException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
                if (cls == null) {
                    return null;
                }
                if (!cls.isInterface()) {
                    try {
                        return cls.newInstance();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } else if (cls.equals(Map.class)) {
                    return (T) new HashMap();
                } else {
                    if (cls.equals(List.class)) {
                        return (T) new ArrayList();
                    }
                    if (cls.equals(Set.class)) {
                        return (T) new HashSet();
                    }
                    throw new JSONException("unknown interface: " + cls);
                }
            }
            return (T) invokeL.objValue;
        }

        public static <T> T a(JSONArray jSONArray, int i2, Class<T> cls, boolean z) throws JSONException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jSONArray, Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) ? z ? (T) deserialize(jSONArray.getJSONArray(i2), cls) : jSONArray.get(i2) instanceof JSONObject ? (T) deserialize(jSONArray.getJSONObject(i2), cls) : (T) jSONArray.get(i2) : (T) invokeCommon.objValue;
        }

        public static Map<String, Object> a(Map<String, Object> map, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, jSONObject)) == null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        map.put(next, jSONObject.get(next));
                    }
                    if (LogUtil.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("map=");
                        sb.append(map.toString());
                        LogUtil.logd(sb.toString());
                    }
                    return map;
                } catch (JSONException e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return (Map) invokeLL.objValue;
        }

        public static void a(Object obj, Field field, Object obj2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, field, obj2) == null) || obj == null || field == null || obj2 == null || "".equals(obj2)) {
                return;
            }
            try {
                Class<?> type = field.getType();
                field.setAccessible(true);
                if (Date.class.isAssignableFrom(type)) {
                    obj2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString());
                }
                field.set(obj, obj2);
            } catch (Exception e2) {
                if (JsonUtils.f39633a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void a(JSONObject jSONObject, Class<?> cls, Object obj) {
            Field[] declaredFields;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, cls, obj) == null) || cls == null) {
                return;
            }
            a(jSONObject, cls.getSuperclass(), obj);
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                    a(jSONObject, obj, field);
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:11|(5:16|(4:22|23|19|20)|18|19|20)|30|31|19|20) */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
            if (com.baidu.fsg.base.utils.JsonUtils.f39633a == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
            r4 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
            if (com.baidu.fsg.base.utils.JsonUtils.f39633a == false) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void a(JSONObject jSONObject, Object obj, Field field) {
            Object deserialize;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, obj, field) == null) {
                Class<?> type = field.getType();
                String name = field.getName();
                try {
                    if (!DataType.isRaw(type)) {
                        if (!DataType.isArray(type) && !DataType.isCollection(type)) {
                            if (!DataType.isJSONObject(type)) {
                                if (DataType.isObject(type)) {
                                    deserialize = deserialize(jSONObject.optJSONObject(name), type);
                                } else if (!DataType.isMap(type)) {
                                    throw new Exception("unknow type!");
                                } else {
                                    deserialize = a(new HashMap(), jSONObject.optJSONObject(name));
                                }
                                a(obj, field, deserialize);
                            }
                            deserialize = jSONObject.opt(name);
                            a(obj, field, deserialize);
                        }
                        deserialize = deserialize(jSONObject.optJSONArray(name), type);
                        a(obj, field, deserialize);
                    } else if (Integer.TYPE.isAssignableFrom(type)) {
                        try {
                            deserialize = Integer.valueOf(jSONObject.getInt(name));
                        } catch (JSONException e2) {
                            e = e2;
                            if (JsonUtils.f39633a) {
                                e.printStackTrace();
                            }
                            deserialize = null;
                            a(obj, field, deserialize);
                        }
                        a(obj, field, deserialize);
                    } else if (Long.TYPE.isAssignableFrom(type)) {
                        try {
                            deserialize = Long.valueOf(jSONObject.getLong(name));
                        } catch (JSONException e3) {
                            e = e3;
                            if (JsonUtils.f39633a) {
                                e.printStackTrace();
                            }
                            deserialize = null;
                            a(obj, field, deserialize);
                        }
                        a(obj, field, deserialize);
                    } else {
                        if (!Float.TYPE.isAssignableFrom(type) && !Double.TYPE.isAssignableFrom(type)) {
                            if (DataType.isBoolean(type)) {
                                try {
                                    deserialize = Boolean.valueOf(jSONObject.getBoolean(name));
                                } catch (JSONException e4) {
                                    e = e4;
                                }
                                a(obj, field, deserialize);
                            }
                            deserialize = jSONObject.opt(name);
                            a(obj, field, deserialize);
                        }
                        deserialize = Double.valueOf(jSONObject.getDouble(name));
                        a(obj, field, deserialize);
                    }
                } catch (Exception e5) {
                    if (JsonUtils.f39633a) {
                        e5.printStackTrace();
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T[] a(JSONArray jSONArray, Class<T> cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONArray, cls)) == null) {
                if (DataType.isNull(jSONArray) || cls == null) {
                    return null;
                }
                int length = jSONArray.length();
                T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
                boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        tArr[i2] = a(jSONArray, i2, cls, z);
                    } catch (JSONException e2) {
                        if (JsonUtils.f39633a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeLL.objValue);
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Collection] */
        public static <T> T b(JSONArray jSONArray, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Type[] actualTypeArguments;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONArray, cls)) == null) {
                if (DataType.isNull(jSONArray) || !DataType.isCollection(cls)) {
                    return null;
                }
                Type genericSuperclass = cls.getGenericSuperclass();
                Class cls2 = (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) ? null : (Class) actualTypeArguments[0];
                if (cls2 == null) {
                    return null;
                }
                ?? r5 = (T) ((Collection) a(cls));
                boolean z = DataType.isArray(cls2) || DataType.isCollection(cls2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        r5.add(a(jSONArray, i2, cls2, z));
                    } catch (JSONException e2) {
                        if (JsonUtils.f39633a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return r5;
            }
            return (T) invokeLL.objValue;
        }

        public static <T> T deserialize(JSONArray jSONArray, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONArray, cls)) == null) {
                if (cls == null || DataType.isNull(jSONArray)) {
                    return null;
                }
                if (DataType.isArray(cls)) {
                    return (T) a(jSONArray, cls.getComponentType());
                }
                if (DataType.isCollection(cls)) {
                    return (T) b(jSONArray, cls);
                }
                return null;
            }
            return (T) invokeLL.objValue;
        }

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, cls)) == null) {
                if (cls == null || DataType.isNull(jSONObject)) {
                    return null;
                }
                T t = (T) a(cls);
                if (t != null) {
                    if (DataType.isMap(cls)) {
                        a((Map) t, jSONObject);
                    } else {
                        a(jSONObject, (Class<?>) cls, (Object) t);
                    }
                }
                return t;
            }
            return (T) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class Encoder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Encoder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static JSONStringer a(JSONStringer jSONStringer, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONStringer, obj)) == null) {
                try {
                    jSONStringer.array();
                    for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
                        serialize(jSONStringer, Array.get(obj, i2));
                    }
                    jSONStringer.endArray();
                } catch (Exception e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
                return jSONStringer;
            }
            return (JSONStringer) invokeLL.objValue;
        }

        public static void a(JSONStringer jSONStringer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, jSONStringer) == null) {
                try {
                    jSONStringer.value((Object) null);
                } catch (JSONException e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            Field[] declaredFields;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65539, null, jSONStringer, cls, obj) == null) || cls == null) {
                return;
            }
            a(jSONStringer, cls.getSuperclass(), obj);
            for (Field field : cls.getDeclaredFields()) {
                if (!ClassLoader.class.isAssignableFrom(field.getType()) && !PathClassLoader.class.isAssignableFrom(field.getType()) && !Class.class.isAssignableFrom(field.getType()) && !field.isSynthetic() && !Modifier.isTransient(field.getModifiers())) {
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (Date.class.isAssignableFrom(field.getType())) {
                            obj2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) obj2);
                        }
                        jSONStringer.key(field.getName());
                        serialize(jSONStringer, obj2);
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Collection<?> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONStringer, collection) == null) {
                try {
                    jSONStringer.array();
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        serialize(jSONStringer, it.next());
                    }
                    jSONStringer.endArray();
                } catch (Exception e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Map<?, ?> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONStringer, map) == null) {
                try {
                    jSONStringer.object();
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        jSONStringer.key((String) entry.getKey());
                        serialize(jSONStringer, entry.getValue());
                    }
                    jSONStringer.endObject();
                } catch (Exception e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONStringer jSONStringer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONStringer, obj) == null) {
                try {
                    jSONStringer.object();
                    a(jSONStringer, obj.getClass(), obj);
                    jSONStringer.endObject();
                } catch (Exception e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void c(JSONStringer jSONStringer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, jSONStringer, obj) == null) {
                try {
                    jSONStringer.value(obj);
                } catch (JSONException e2) {
                    if (JsonUtils.f39633a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static JSONStringer serialize(JSONStringer jSONStringer, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONStringer, obj)) == null) {
                if (DataType.isNull(obj)) {
                    a(jSONStringer);
                } else {
                    Class<?> cls = obj.getClass();
                    if (DataType.isRaw(cls)) {
                        c(jSONStringer, obj);
                    } else if (DataType.isArray(cls)) {
                        a(jSONStringer, obj);
                    } else if (DataType.isCollection(cls)) {
                        a(jSONStringer, (Collection<?>) obj);
                    } else if (DataType.isMap(cls)) {
                        a(jSONStringer, (Map<?, ?>) obj);
                    } else {
                        b(jSONStringer, obj);
                    }
                }
                return jSONStringer;
            }
            return (JSONStringer) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1675578891, "Lcom/baidu/fsg/base/utils/JsonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1675578891, "Lcom/baidu/fsg/base/utils/JsonUtils;");
                return;
            }
        }
        f39633a = ApollonConstants.DEBUG & false;
    }

    public JsonUtils() {
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

    public static <T> T fromJson(String str, Class<T> cls) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, cls)) == null) {
            if (cls == null || str == null || str.length() == 0) {
                return null;
            }
            return (DataType.isArray(cls) || DataType.isCollection(cls)) ? (T) Decoder.deserialize(new JSONArray(str), cls) : (T) Decoder.deserialize(new JSONObject(str), cls);
        }
        return (T) invokeLL.objValue;
    }

    public static String toJson(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return Encoder.serialize(new JSONStringer(), obj).toString();
        }
        return (String) invokeL.objValue;
    }
}
