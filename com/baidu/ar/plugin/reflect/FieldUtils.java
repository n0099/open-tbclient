package com.baidu.ar.plugin.reflect;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class FieldUtils {
    private static Map<String, Field> sFieldCache = new HashMap();

    private static String getKey(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    private static Field getField(Class<?> cls, String str, boolean z) {
        Field field;
        Field field2;
        Field declaredField;
        Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
        Validate.isTrue(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
        String key = getKey(cls, str);
        synchronized (sFieldCache) {
            field = sFieldCache.get(key);
        }
        if (field != null) {
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
                return field;
            }
            return field;
        }
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                declaredField = cls2.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
            }
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                if (!z) {
                    continue;
                } else {
                    declaredField.setAccessible(true);
                }
            }
            synchronized (sFieldCache) {
                sFieldCache.put(key, declaredField);
            }
            return declaredField;
        }
        Field field3 = null;
        for (Class<?> cls3 : Utils.getAllInterfaces(cls)) {
            try {
                field2 = cls3.getField(str);
                Validate.isTrue(field3 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
            } catch (NoSuchFieldException e2) {
                field2 = field3;
            }
            field3 = field2;
        }
        synchronized (sFieldCache) {
            sFieldCache.put(key, field3);
        }
        return field3;
    }

    public static Field getField(Class<?> cls, String str) {
        return getField(cls, str, true);
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        return field.get(obj);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, true);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, true);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, false);
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, z);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        field.set(obj, obj2);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, true);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, true);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(field, obj, obj2, z);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, true);
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, "The field must not be null", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field field = getField(cls, str, true);
        Validate.isTrue(field != null, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(field, true);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, "The field must not be null", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field field = getField(cls, str, true);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        writeStaticField(field, obj, true);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Validate.isTrue(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, true);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
        Validate.isTrue(TextUtils.isEmpty(str) ? false : true, "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!MemberUtils.isAccessible(declaredField)) {
                if (z) {
                    declaredField.setAccessible(true);
                    return declaredField;
                }
                return null;
            }
            return declaredField;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
