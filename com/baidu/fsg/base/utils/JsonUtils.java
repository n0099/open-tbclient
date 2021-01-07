package com.baidu.fsg.base.utils;

import com.baidu.fsg.base.ApollonConstants;
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
/* loaded from: classes6.dex */
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2031a = ApollonConstants.DEBUG & false;

    private JsonUtils() {
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return Encoder.serialize(new JSONStringer(), obj).toString();
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JSONException {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        if (DataType.isArray(cls) || DataType.isCollection(cls)) {
            return (T) Decoder.deserialize(new JSONArray(str), cls);
        }
        return (T) Decoder.deserialize(new JSONObject(str), cls);
    }

    /* loaded from: classes6.dex */
    private static class Encoder {
        private Encoder() {
        }

        public static JSONStringer serialize(JSONStringer jSONStringer, Object obj) {
            if (DataType.isNull(obj)) {
                a(jSONStringer);
            } else {
                Class<?> cls = obj.getClass();
                if (DataType.isRaw(cls)) {
                    a(jSONStringer, obj);
                } else if (DataType.isArray(cls)) {
                    b(jSONStringer, obj);
                } else if (DataType.isCollection(cls)) {
                    a(jSONStringer, (Collection<?>) obj);
                } else if (DataType.isMap(cls)) {
                    a(jSONStringer, (Map<?, ?>) obj);
                } else {
                    c(jSONStringer, obj);
                }
            }
            return jSONStringer;
        }

        private static void a(JSONStringer jSONStringer) {
            try {
                jSONStringer.value((Object) null);
            } catch (JSONException e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
        }

        private static void a(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.value(obj);
            } catch (JSONException e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
        }

        private static JSONStringer b(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.array();
                for (int i = 0; i < Array.getLength(obj); i++) {
                    serialize(jSONStringer, Array.get(obj, i));
                }
                jSONStringer.endArray();
            } catch (Exception e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
            return jSONStringer;
        }

        private static void a(JSONStringer jSONStringer, Collection<?> collection) {
            try {
                jSONStringer.array();
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    serialize(jSONStringer, it.next());
                }
                jSONStringer.endArray();
            } catch (Exception e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
        }

        private static void a(JSONStringer jSONStringer, Map<?, ?> map) {
            try {
                jSONStringer.object();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    jSONStringer.key((String) entry.getKey());
                    serialize(jSONStringer, entry.getValue());
                }
                jSONStringer.endObject();
            } catch (Exception e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
        }

        private static void c(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.object();
                a(jSONStringer, obj.getClass(), obj);
                jSONStringer.endObject();
            } catch (Exception e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
            }
        }

        private static void a(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls != null) {
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
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class Decoder {
        private Decoder() {
        }

        public static <T> T deserialize(JSONArray jSONArray, Class<T> cls) throws JSONException {
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

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
            if (cls == null || DataType.isNull(jSONObject)) {
                return null;
            }
            T t = (T) a(cls);
            if (t != null) {
                if (DataType.isMap(cls)) {
                    a((Map) t, jSONObject);
                    return t;
                }
                a(jSONObject, (Class<?>) cls, (Object) t);
                return t;
            }
            return t;
        }

        private static void a(JSONObject jSONObject, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls != null) {
                a(jSONObject, cls.getSuperclass(), obj);
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                        a(jSONObject, obj, field);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static void a(JSONObject jSONObject, Object obj, Field field) {
            Object deserialize;
            Class<?> type = field.getType();
            String name = field.getName();
            try {
            } catch (Exception e) {
                if (!JsonUtils.f2031a) {
                }
            }
            if (DataType.isRaw(type)) {
                if (Integer.TYPE.isAssignableFrom(type)) {
                    try {
                        deserialize = Integer.valueOf(jSONObject.getInt(name));
                    } catch (JSONException e2) {
                        if (JsonUtils.f2031a) {
                            e2.printStackTrace();
                        }
                        deserialize = null;
                    }
                } else if (Long.TYPE.isAssignableFrom(type)) {
                    try {
                        deserialize = Long.valueOf(jSONObject.getLong(name));
                    } catch (JSONException e3) {
                        if (JsonUtils.f2031a) {
                            e3.printStackTrace();
                        }
                        deserialize = null;
                    }
                } else if (Float.TYPE.isAssignableFrom(type) || Double.TYPE.isAssignableFrom(type)) {
                    try {
                        deserialize = Double.valueOf(jSONObject.getDouble(name));
                    } catch (JSONException e4) {
                        if (JsonUtils.f2031a) {
                            e4.printStackTrace();
                        }
                        deserialize = null;
                    }
                } else if (DataType.isBoolean(type)) {
                    try {
                        deserialize = Boolean.valueOf(jSONObject.getBoolean(name));
                    } catch (JSONException e5) {
                        if (JsonUtils.f2031a) {
                            e5.printStackTrace();
                        }
                        deserialize = null;
                    }
                } else {
                    deserialize = jSONObject.opt(name);
                }
                if (!JsonUtils.f2031a) {
                    e.printStackTrace();
                    return;
                }
                return;
            } else if (DataType.isArray(type) || DataType.isCollection(type)) {
                deserialize = deserialize(jSONObject.optJSONArray(name), type);
            } else if (DataType.isJSONObject(type)) {
                deserialize = jSONObject.opt(name);
            } else if (DataType.isObject(type)) {
                deserialize = deserialize(jSONObject.optJSONObject(name), type);
            } else if (DataType.isMap(type)) {
                deserialize = a(new HashMap(), jSONObject.optJSONObject(name));
            } else {
                throw new Exception("unknow type!");
            }
            a(obj, field, deserialize);
        }

        private static void a(Object obj, Field field, Object obj2) {
            if (obj != null && field != null && obj2 != null && !"".equals(obj2)) {
                try {
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    if (Date.class.isAssignableFrom(type)) {
                        field.set(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString()));
                    } else {
                        field.set(obj, obj2);
                    }
                } catch (Exception e) {
                    if (JsonUtils.f2031a) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static Map<String, Object> a(Map<String, Object> map, JSONObject jSONObject) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    map.put(next, jSONObject.get(next));
                }
                if (LogUtil.DEBUG) {
                    LogUtil.logd("map=" + map.toString());
                    return map;
                }
                return map;
            } catch (JSONException e) {
                if (JsonUtils.f2031a) {
                    e.printStackTrace();
                }
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        private static <T> T[] a(JSONArray jSONArray, Class<T> cls) {
            if (DataType.isNull(jSONArray) || cls == null) {
                return null;
            }
            int length = jSONArray.length();
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
            boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
            for (int i = 0; i < length; i++) {
                try {
                    tArr[i] = a(jSONArray, i, cls, z);
                } catch (JSONException e) {
                    if (JsonUtils.f2031a) {
                        e.printStackTrace();
                        return tArr;
                    }
                    return tArr;
                }
            }
            return tArr;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
        private static <T> T b(JSONArray jSONArray, Class<T> cls) throws JSONException {
            Type[] actualTypeArguments;
            if (DataType.isNull(jSONArray) || !DataType.isCollection(cls)) {
                return null;
            }
            Type genericSuperclass = cls.getGenericSuperclass();
            Class cls2 = (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) ? null : (Class) actualTypeArguments[0];
            if (cls2 == null) {
                return null;
            }
            ?? r0 = (T) ((Collection) a(cls));
            boolean z = DataType.isArray(cls2) || DataType.isCollection(cls2);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    r0.add(a(jSONArray, i, cls2, z));
                } catch (JSONException e) {
                    if (JsonUtils.f2031a) {
                        e.printStackTrace();
                        return r0;
                    }
                    return r0;
                }
            }
            return r0;
        }

        private static <T> T a(JSONArray jSONArray, int i, Class<T> cls, boolean z) throws JSONException {
            if (z) {
                return (T) deserialize(jSONArray.getJSONArray(i), cls);
            }
            if (jSONArray.get(i) instanceof JSONObject) {
                return (T) deserialize(jSONArray.getJSONObject(i), cls);
            }
            return (T) jSONArray.get(i);
        }

        private static <T> T a(Class<T> cls) throws JSONException {
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
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class DataType {
        public static boolean isNull(Object obj) {
            if (obj instanceof JSONObject) {
                return JSONObject.NULL.equals(obj);
            }
            return obj == null;
        }

        public static boolean isBoolean(Class<?> cls) {
            return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
        }

        public static boolean isNumber(Class<?> cls) {
            return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
        }

        public static boolean isString(Class<?> cls) {
            return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
        }

        public static boolean isRaw(Class<?> cls) {
            return isBoolean(cls) || isNumber(cls) || isString(cls);
        }

        public static boolean isObject(Class<?> cls) {
            return (cls == null || isRaw(cls) || isArray(cls) || isCollection(cls) || isMap(cls) || isJSONObject(cls)) ? false : true;
        }

        public static boolean isArray(Class<?> cls) {
            return cls != null && cls.isArray();
        }

        public static boolean isCollection(Class<?> cls) {
            return cls != null && Collection.class.isAssignableFrom(cls);
        }

        public static boolean isMap(Class<?> cls) {
            return cls != null && Map.class.isAssignableFrom(cls);
        }

        public static boolean isJSONObject(Class<?> cls) {
            return cls != null && JSONObject.class.isAssignableFrom(cls);
        }
    }
}
