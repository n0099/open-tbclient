package com.baidu.apollon.utils;

import com.baidu.apollon.ApollonConstants;
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
/* loaded from: classes.dex */
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3960a = ApollonConstants.DEBUG & false;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class Encoder {
        public static JSONStringer serialize(JSONStringer jSONStringer, Object obj) {
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

        public static JSONStringer serializeArray(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.array();
                for (int i = 0; i < Array.getLength(obj); i++) {
                    serialize(jSONStringer, Array.get(obj, i));
                }
                jSONStringer.endArray();
            } catch (Exception e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
            return jSONStringer;
        }

        public static void serializeCollection(JSONStringer jSONStringer, Collection<?> collection) {
            try {
                jSONStringer.array();
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    serialize(jSONStringer, it.next());
                }
                jSONStringer.endArray();
            } catch (Exception e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void serializeMap(JSONStringer jSONStringer, Map<?, ?> map) {
            try {
                jSONStringer.object();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    jSONStringer.key((String) entry.getKey());
                    serialize(jSONStringer, entry.getValue());
                }
                jSONStringer.endObject();
            } catch (Exception e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void serializeNull(JSONStringer jSONStringer) {
            try {
                jSONStringer.value((Object) null);
            } catch (JSONException e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.object();
                serializeObject(jSONStringer, obj.getClass(), obj);
                jSONStringer.endObject();
            } catch (Exception e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void serializeRaw(JSONStringer jSONStringer, Object obj) {
            try {
                jSONStringer.value(obj);
            } catch (JSONException e2) {
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static void serializeObject(JSONStringer jSONStringer, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls == null) {
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

    /* loaded from: classes.dex */
    public static class Decoder {
        public static <T> T deserialize(JSONArray jSONArray, Class<T> cls) throws JSONException {
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

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T[] deserializeArray(JSONArray jSONArray, Class<T> cls) {
            if (DataType.isNull(jSONArray) || cls == null) {
                return null;
            }
            int length = jSONArray.length();
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
            boolean z = DataType.isArray(cls) || DataType.isCollection(cls);
            for (int i = 0; i < length; i++) {
                try {
                    tArr[i] = deserializeJSONArray(jSONArray, i, cls, z);
                } catch (JSONException e2) {
                    if (JsonUtils.f3960a) {
                        e2.printStackTrace();
                    }
                }
            }
            return tArr;
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Collection] */
        public static <T> T deserializeCollection(JSONArray jSONArray, Class<T> cls) throws JSONException {
            Type[] actualTypeArguments;
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
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    r5.add(deserializeJSONArray(jSONArray, i, cls2, z));
                } catch (JSONException e2) {
                    if (JsonUtils.f3960a) {
                        e2.printStackTrace();
                    }
                }
            }
            return r5;
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void deserializeField(JSONObject jSONObject, Object obj, Field field) {
            Class<?> type = field.getType();
            String name = field.getName();
            Object obj2 = null;
            try {
            } catch (Exception e2) {
                if (JsonUtils.f3960a) {
                }
            }
            if (DataType.isRaw(type)) {
                if (Integer.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Integer.valueOf(jSONObject.getInt(name));
                    } catch (JSONException e3) {
                        if (JsonUtils.f3960a) {
                            e3.printStackTrace();
                        }
                    }
                } else if (Long.TYPE.isAssignableFrom(type)) {
                    try {
                        obj2 = Long.valueOf(jSONObject.getLong(name));
                    } catch (JSONException e4) {
                        if (JsonUtils.f3960a) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    if (!Float.TYPE.isAssignableFrom(type) && !Double.TYPE.isAssignableFrom(type)) {
                        if (DataType.isBoolean(type)) {
                            try {
                                obj2 = Boolean.valueOf(jSONObject.getBoolean(name));
                            } catch (JSONException e5) {
                                if (JsonUtils.f3960a) {
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
                        if (JsonUtils.f3960a) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (JsonUtils.f3960a) {
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

        public static <T> T deserializeJSONArray(JSONArray jSONArray, int i, Class<T> cls, boolean z) throws JSONException {
            if (z) {
                return (T) deserialize(jSONArray.getJSONArray(i), cls);
            }
            if (jSONArray.get(i) instanceof JSONObject) {
                return (T) deserialize(jSONArray.getJSONObject(i), cls);
            }
            return (T) jSONArray.get(i);
        }

        public static Map<String, Object> deserializeMap(Map<String, Object> map, JSONObject jSONObject) {
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
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }

        public static void deserializeObject(JSONObject jSONObject, Class<?> cls, Object obj) {
            Field[] declaredFields;
            if (cls == null) {
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

        public static void setFiedlValue(Object obj, Field field, Object obj2) {
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
                if (JsonUtils.f3960a) {
                    e2.printStackTrace();
                }
            }
        }

        public static <T> T deserialize(JSONObject jSONObject, Class<T> cls) throws JSONException {
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
    }
}
