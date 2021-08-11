package com.baidu.apollon.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.ApollonConstants;
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
    public static final boolean f38025a;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) {
                if (obj instanceof JSONObject) {
                    return JSONObject.NULL.equals(obj);
                }
                return obj == null;
            }
            return invokeL.booleanValue;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-209311602, "Lcom/baidu/apollon/utils/JsonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-209311602, "Lcom/baidu/apollon/utils/JsonUtils;");
                return;
            }
        }
        f38025a = ApollonConstants.DEBUG & false;
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
            if (!DataType.isArray(cls) && !DataType.isCollection(cls)) {
                return (T) Decoder.deserialize(new JSONObject(str), cls);
            }
            return (T) Decoder.deserialize(new JSONArray(str), cls);
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

        public static JSONStringer serialize(JSONStringer jSONStringer, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONStringer, obj)) == null) {
                if (DataType.isNull(obj)) {
                    serializeNull(jSONStringer);
                } else {
                    Class<?> cls = obj.getClass();
                    if (DataType.isRaw(cls)) {
                        serializeRaw(jSONStringer, obj);
                    } else if (DataType.isArray(cls)) {
                        serializeArray(jSONStringer, obj);
                    } else if (DataType.isCollection(cls)) {
                        serializeCollection(jSONStringer, (Collection) obj);
                    } else if (DataType.isMap(cls)) {
                        serializeMap(jSONStringer, (Map) obj);
                    } else {
                        serializeObject(jSONStringer, obj);
                    }
                }
                return jSONStringer;
            }
            return (JSONStringer) invokeLL.objValue;
        }

        public static JSONStringer serializeArray(JSONStringer jSONStringer, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONStringer, obj)) == null) {
                try {
                    jSONStringer.array();
                    for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
                        serialize(jSONStringer, Array.get(obj, i2));
                    }
                    jSONStringer.endArray();
                } catch (Exception e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
                return jSONStringer;
            }
            return (JSONStringer) invokeLL.objValue;
        }

        public static void serializeCollection(JSONStringer jSONStringer, Collection<?> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, jSONStringer, collection) == null) {
                try {
                    jSONStringer.array();
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        serialize(jSONStringer, it.next());
                    }
                    jSONStringer.endArray();
                } catch (Exception e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void serializeMap(JSONStringer jSONStringer, Map<?, ?> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONStringer, map) == null) {
                try {
                    jSONStringer.object();
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        jSONStringer.key((String) entry.getKey());
                        serialize(jSONStringer, entry.getValue());
                    }
                    jSONStringer.endObject();
                } catch (Exception e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void serializeNull(JSONStringer jSONStringer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONStringer) == null) {
                try {
                    jSONStringer.value((Object) null);
                } catch (JSONException e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, jSONStringer, obj) == null) {
                try {
                    jSONStringer.object();
                    serializeObject(jSONStringer, obj.getClass(), obj);
                    jSONStringer.endObject();
                } catch (Exception e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void serializeRaw(JSONStringer jSONStringer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65544, null, jSONStringer, obj) == null) {
                try {
                    jSONStringer.value(obj);
                } catch (JSONException e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            Field[] declaredFields;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONStringer, cls, obj) == null) || cls == null) {
                return;
            }
            serializeObject(jSONStringer, cls.getSuperclass(), obj);
            for (Field field : cls.getDeclaredFields()) {
                if (!ClassLoader.class.isAssignableFrom(field.getType()) && !PathClassLoader.class.isAssignableFrom(field.getType()) && !Class.class.isAssignableFrom(field.getType()) && !Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
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

        public static <T> T deserialize(JSONArray jSONArray, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONArray, cls)) == null) {
                if (cls == null || DataType.isNull(jSONArray)) {
                    return null;
                }
                if (DataType.isArray(cls)) {
                    return (T) deserializeArray(jSONArray, cls.getComponentType());
                }
                if (DataType.isCollection(cls)) {
                    return (T) deserializeCollection(jSONArray, cls);
                }
                return null;
            }
            return (T) invokeLL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T[] deserializeArray(JSONArray jSONArray, Class<T> cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONArray, cls)) == null) {
                if (DataType.isNull(jSONArray) || cls == null) {
                    return null;
                }
                int length = jSONArray.length();
                T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
                boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        tArr[i2] = deserializeJSONArray(jSONArray, i2, cls, z);
                    } catch (JSONException e2) {
                        if (JsonUtils.f38025a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeLL.objValue);
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Collection] */
        public static <T> T deserializeCollection(JSONArray jSONArray, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Type[] actualTypeArguments;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, cls)) == null) {
                if (DataType.isNull(jSONArray) || !DataType.isCollection(cls)) {
                    return null;
                }
                Type genericSuperclass = cls.getGenericSuperclass();
                Class cls2 = (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) ? null : (Class) actualTypeArguments[0];
                if (cls2 == null) {
                    return null;
                }
                ?? r5 = (T) ((Collection) newInstance(cls));
                boolean z = DataType.isArray(cls2) || DataType.isCollection(cls2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        r5.add(deserializeJSONArray(jSONArray, i2, cls2, z));
                    } catch (JSONException e2) {
                        if (JsonUtils.f38025a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return r5;
            }
            return (T) invokeLL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void deserializeField(JSONObject jSONObject, Object obj, Field field) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, obj, field) == null) {
                Class<?> type = field.getType();
                String name = field.getName();
                Object obj2 = null;
                try {
                } catch (Exception e2) {
                    if (JsonUtils.f38025a) {
                    }
                }
                if (DataType.isRaw(type)) {
                    if (Integer.TYPE.isAssignableFrom(type)) {
                        try {
                            obj2 = Integer.valueOf(jSONObject.getInt(name));
                        } catch (JSONException e3) {
                            if (JsonUtils.f38025a) {
                                e3.printStackTrace();
                            }
                        }
                    } else if (Long.TYPE.isAssignableFrom(type)) {
                        try {
                            obj2 = Long.valueOf(jSONObject.getLong(name));
                        } catch (JSONException e4) {
                            if (JsonUtils.f38025a) {
                                e4.printStackTrace();
                            }
                        }
                    } else {
                        if (!Float.TYPE.isAssignableFrom(type) && !Double.TYPE.isAssignableFrom(type)) {
                            if (DataType.isBoolean(type)) {
                                try {
                                    obj2 = Boolean.valueOf(jSONObject.getBoolean(name));
                                } catch (JSONException e5) {
                                    if (JsonUtils.f38025a) {
                                        e5.printStackTrace();
                                    }
                                }
                            } else {
                                obj2 = jSONObject.opt(name);
                            }
                        }
                        try {
                            obj2 = Double.valueOf(jSONObject.getDouble(name));
                        } catch (JSONException e6) {
                            if (JsonUtils.f38025a) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    if (JsonUtils.f38025a) {
                        return;
                    }
                    e2.printStackTrace();
                    return;
                }
                if (!DataType.isArray(type) && !DataType.isCollection(type)) {
                    if (DataType.isJSONObject(type)) {
                        obj2 = jSONObject.opt(name);
                    } else if (DataType.isObject(type)) {
                        obj2 = deserialize(jSONObject.optJSONObject(name), type);
                    } else if (DataType.isMap(type)) {
                        obj2 = deserializeMap(new HashMap(), jSONObject.optJSONObject(name));
                    } else {
                        throw new Exception("unknow type!");
                    }
                }
                obj2 = deserialize(jSONObject.optJSONArray(name), type);
                setFiedlValue(obj, field, obj2);
            }
        }

        public static <T> T deserializeJSONArray(JSONArray jSONArray, int i2, Class<T> cls, boolean z) throws JSONException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{jSONArray, Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) {
                if (z) {
                    return (T) deserialize(jSONArray.getJSONArray(i2), cls);
                }
                if (jSONArray.get(i2) instanceof JSONObject) {
                    return (T) deserialize(jSONArray.getJSONObject(i2), cls);
                }
                return (T) jSONArray.get(i2);
            }
            return (T) invokeCommon.objValue;
        }

        public static Map<String, Object> deserializeMap(Map<String, Object> map, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, map, jSONObject)) == null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        map.put(next, jSONObject.get(next));
                    }
                    if (LogUtil.DEBUG) {
                        LogUtil.logd("map=" + map.toString());
                    }
                    return map;
                } catch (JSONException e2) {
                    if (JsonUtils.f38025a) {
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return (Map) invokeLL.objValue;
        }

        public static void deserializeObject(JSONObject jSONObject, Class<?> cls, Object obj) {
            Field[] declaredFields;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65544, null, jSONObject, cls, obj) == null) || cls == null) {
                return;
            }
            deserializeObject(jSONObject, cls.getSuperclass(), obj);
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                    deserializeField(jSONObject, obj, field);
                }
            }
        }

        public static <T> T newInstance(Class<T> cls) throws JSONException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
                if (cls == null) {
                    return null;
                }
                if (cls.isInterface()) {
                    if (cls.equals(Map.class)) {
                        return (T) new HashMap();
                    }
                    if (cls.equals(List.class)) {
                        return (T) new ArrayList();
                    }
                    if (cls.equals(Set.class)) {
                        return (T) new HashSet();
                    }
                    throw new JSONException("unknown interface: " + cls);
                }
                try {
                    return cls.newInstance();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }

        public static void setFiedlValue(Object obj, Field field, Object obj2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65546, null, obj, field, obj2) == null) || obj == null || field == null || obj2 == null || "".equals(obj2)) {
                return;
            }
            try {
                Class<?> type = field.getType();
                field.setAccessible(true);
                if (Date.class.isAssignableFrom(type)) {
                    field.set(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString()));
                } else {
                    field.set(obj, obj2);
                }
            } catch (Exception e2) {
                if (JsonUtils.f38025a) {
                    e2.printStackTrace();
                }
            }
        }

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, cls)) == null) {
                if (cls == null || DataType.isNull(jSONObject)) {
                    return null;
                }
                T t = (T) newInstance(cls);
                if (t != null) {
                    if (DataType.isMap(cls)) {
                        deserializeMap((Map) t, jSONObject);
                    } else {
                        deserializeObject(jSONObject, cls, t);
                    }
                }
                return t;
            }
            return (T) invokeLL.objValue;
        }
    }
}
