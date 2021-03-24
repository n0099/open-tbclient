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
/* loaded from: classes2.dex */
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5370a = ApollonConstants.DEBUG & false;

    /* loaded from: classes2.dex */
    public static class DataType {
        public static boolean isArray(Class<?> cls) {
            return cls != null && cls.isArray();
        }

        public static boolean isBoolean(Class<?> cls) {
            return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
        }

        public static boolean isCollection(Class<?> cls) {
            return cls != null && Collection.class.isAssignableFrom(cls);
        }

        public static boolean isJSONObject(Class<?> cls) {
            return cls != null && JSONObject.class.isAssignableFrom(cls);
        }

        public static boolean isMap(Class<?> cls) {
            return cls != null && Map.class.isAssignableFrom(cls);
        }

        public static boolean isNull(Object obj) {
            if (obj instanceof JSONObject) {
                return JSONObject.NULL.equals(obj);
            }
            return obj == null;
        }

        public static boolean isNumber(Class<?> cls) {
            return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
        }

        public static boolean isObject(Class<?> cls) {
            return (cls == null || isRaw(cls) || isArray(cls) || isCollection(cls) || isMap(cls) || isJSONObject(cls)) ? false : true;
        }

        public static boolean isRaw(Class<?> cls) {
            return isBoolean(cls) || isNumber(cls) || isString(cls);
        }

        public static boolean isString(Class<?> cls) {
            return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
        }
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JSONException {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        if (!DataType.isArray(cls) && !DataType.isCollection(cls)) {
            return (T) Decoder.deserialize(new JSONObject(str), cls);
        }
        return (T) Decoder.deserialize(new JSONArray(str), cls);
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return Encoder.serialize(new JSONStringer(), obj).toString();
    }

    /* loaded from: classes2.dex */
    public static class Encoder {
        public static void a(JSONStringer jSONStringer) {
            try {
                jSONStringer.value((Object) null);
            } catch (JSONException e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
        }

        public static JSONStringer b(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.array();
                for (int i = 0; i < Array.getLength(obj); i++) {
                    serialize(jSONStringer, Array.get(obj, i));
                }
                jSONStringer.endArray();
            } catch (Exception e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
            return jSONStringer;
        }

        public static void c(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.object();
                a(jSONStringer, obj.getClass(), obj);
                jSONStringer.endObject();
            } catch (Exception e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
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

        public static void a(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.value(obj);
            } catch (JSONException e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Collection<?> collection) {
            try {
                jSONStringer.array();
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    serialize(jSONStringer, it.next());
                }
                jSONStringer.endArray();
            } catch (Exception e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Map<?, ?> map) {
            try {
                jSONStringer.object();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    jSONStringer.key((String) entry.getKey());
                    serialize(jSONStringer, entry.getValue());
                }
                jSONStringer.endObject();
            } catch (Exception e2) {
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void a(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls == null) {
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
    }

    /* loaded from: classes2.dex */
    public static class Decoder {
        public static void a(JSONObject jSONObject, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls == null) {
                return;
            }
            a(jSONObject, cls.getSuperclass(), obj);
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers()) && !field.isSynthetic()) {
                    a(jSONObject, obj, field);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Collection] */
        public static <T> T b(JSONArray jSONArray, Class<T> cls) throws JSONException {
            Type[] actualTypeArguments;
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
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    r5.add(a(jSONArray, i, cls2, z));
                } catch (JSONException e2) {
                    if (JsonUtils.f5370a) {
                        e2.printStackTrace();
                    }
                }
            }
            return r5;
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

        /* JADX WARN: Removed duplicated region for block: B:64:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void a(JSONObject jSONObject, Object obj, Field field) {
            Class<?> type = field.getType();
            String name = field.getName();
            Object obj2 = null;
            try {
            } catch (Exception e2) {
                if (JsonUtils.f5370a) {
                }
            }
            if (DataType.isRaw(type)) {
                if (Integer.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Integer.valueOf(jSONObject.getInt(name));
                    } catch (JSONException e3) {
                        if (JsonUtils.f5370a) {
                            e3.printStackTrace();
                        }
                    }
                } else if (Long.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Long.valueOf(jSONObject.getLong(name));
                    } catch (JSONException e4) {
                        if (JsonUtils.f5370a) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    if (!Float.TYPE.isAssignableFrom(type) && !Double.TYPE.isAssignableFrom(type)) {
                        if (DataType.isBoolean(type)) {
                            try {
                                obj2 = Boolean.valueOf(jSONObject.getBoolean(name));
                            } catch (JSONException e5) {
                                if (JsonUtils.f5370a) {
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
                        if (JsonUtils.f5370a) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (JsonUtils.f5370a) {
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
                    obj2 = a(new HashMap(), jSONObject.optJSONObject(name));
                } else {
                    throw new Exception("unknow type!");
                }
            }
            obj2 = deserialize(jSONObject.optJSONArray(name), type);
            a(obj, field, obj2);
        }

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
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

        public static void a(Object obj, Field field, Object obj2) {
            if (obj == null || field == null || obj2 == null || "".equals(obj2)) {
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
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                }
            }
        }

        public static Map<String, Object> a(Map<String, Object> map, JSONObject jSONObject) {
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
                if (JsonUtils.f5370a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T[] a(JSONArray jSONArray, Class<T> cls) {
            if (DataType.isNull(jSONArray) || cls == null) {
                return null;
            }
            int length = jSONArray.length();
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
            boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
            for (int i = 0; i < length; i++) {
                try {
                    tArr[i] = a(jSONArray, i, cls, z);
                } catch (JSONException e2) {
                    if (JsonUtils.f5370a) {
                        e2.printStackTrace();
                    }
                }
            }
            return tArr;
        }

        public static <T> T a(JSONArray jSONArray, int i, Class<T> cls, boolean z) throws JSONException {
            if (z) {
                return (T) deserialize(jSONArray.getJSONArray(i), cls);
            }
            if (jSONArray.get(i) instanceof JSONObject) {
                return (T) deserialize(jSONArray.getJSONObject(i), cls);
            }
            return (T) jSONArray.get(i);
        }

        public static <T> T a(Class<T> cls) throws JSONException {
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
    }
}
