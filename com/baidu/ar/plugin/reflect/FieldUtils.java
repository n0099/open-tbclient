package com.baidu.ar.plugin.reflect;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FieldUtils {
    public static Map<String, Field> sFieldCache = new HashMap();

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        boolean z2;
        if (cls != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The class must not be null", new Object[0]);
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

    public static Object readField(Object obj, String str, boolean z) {
        boolean z2;
        boolean z3;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        if (field != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Validate.isTrue(z3, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, z);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) {
        boolean z;
        boolean z2;
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        Validate.isTrue(z, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, true);
        if (declaredField != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    public static void writeField(Object obj, String str, Object obj2) {
        writeField(obj, str, obj2, true);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) {
        boolean z;
        Field field = getField(cls, str, true);
        if (field != null) {
            z = true;
        } else {
            z = false;
        }
        Validate.isTrue(z, "Cannot locate field %s on %s", str, cls);
        writeStaticField(field, obj, true);
    }

    public static Field getField(Class<?> cls, String str) {
        return getField(cls, str, true);
    }

    public static String getKey(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
    }

    public static Object readField(Object obj, String str) {
        boolean z;
        boolean z2;
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        Validate.isTrue(z, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, true);
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, false);
    }

    public static Object readStaticField(Class<?> cls, String str) {
        boolean z;
        Field field = getField(cls, str, true);
        if (field != null) {
            z = true;
        } else {
            z = false;
        }
        Validate.isTrue(z, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(field, true);
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        boolean z2;
        Field field;
        boolean z3;
        Field declaredField;
        if (cls != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The class must not be null", new Object[0]);
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
                if (field2 == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Validate.isTrue(z3, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field2 = field3;
            } catch (NoSuchFieldException unused2) {
            }
        }
        synchronized (sFieldCache) {
            sFieldCache.put(key, field2);
        }
        return field2;
    }

    public static Object readField(Field field, Object obj) {
        return readField(field, obj, true);
    }

    public static Object readStaticField(Field field, boolean z) {
        boolean z2;
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The field must not be null", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    public static Object readField(Field field, Object obj, boolean z) {
        boolean z2;
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        return field.get(obj);
    }

    public static void writeField(Field field, Object obj, Object obj2) {
        writeField(field, obj, obj2, true);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) {
        boolean z2;
        boolean z3;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, true);
        if (field != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Validate.isTrue(z3, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(field, obj, obj2, z);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) {
        boolean z2;
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) {
        boolean z2;
        if (field != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Validate.isTrue(z2, "The field must not be null", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }
}
