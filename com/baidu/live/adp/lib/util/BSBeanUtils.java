package com.baidu.live.adp.lib.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BSBeanUtils {
    private BSBeanUtils() {
    }

    public static Field getDeclaredField(Object obj, String str) throws NoSuchFieldException {
        if (obj == null || StringUtils.isNull(str)) {
            return null;
        }
        return getDeclaredField(obj.getClass(), str);
    }

    public static Field getDeclaredField(Class<?> cls, String str) throws NoSuchFieldException {
        if (cls == null || StringUtils.isNull(str)) {
            return null;
        }
        for (Class<?> cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                return cls2.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("No such field: " + cls.getName() + '.' + str);
    }

    public static Object forceGetProperty(Object obj, String str) throws NoSuchFieldException {
        Object obj2 = null;
        if (obj != null && !StringUtils.isNull(str)) {
            Field declaredField = getDeclaredField(obj, str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            try {
                obj2 = declaredField.get(obj);
            } catch (IllegalAccessException e) {
            }
            declaredField.setAccessible(isAccessible);
        }
        return obj2;
    }

    public static Object forceGetProperty(Object obj, Field field) {
        Object obj2 = null;
        if (obj == null || field == null) {
            return null;
        }
        boolean isAccessible = field.isAccessible();
        try {
            field.setAccessible(true);
            obj2 = field.get(obj);
            field.setAccessible(isAccessible);
            return obj2;
        } catch (Throwable th) {
            return obj2;
        }
    }

    public static void forceSetProperty(Object obj, String str, Object obj2) throws NoSuchFieldException {
        if (obj != null && !StringUtils.isNull(str)) {
            Field declaredField = getDeclaredField(obj, str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            try {
                declaredField.set(obj, obj2);
            } catch (IllegalAccessException e) {
            }
            declaredField.setAccessible(isAccessible);
        }
    }

    public static Object invokePrivateMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException {
        Class<?> cls;
        Method method;
        Object obj2;
        if (obj == null || StringUtils.isNull(str)) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        Class<?> cls2 = obj.getClass();
        while (true) {
            if (cls2 == Object.class) {
                method = null;
                break;
            }
            try {
                method = cls2.getDeclaredMethod(str, clsArr);
                break;
            } catch (NoSuchMethodException e) {
                cls2 = cls2.getSuperclass();
            }
        }
        if (method == null) {
            throw new NoSuchMethodException("No Such Method:" + cls.getSimpleName() + str);
        }
        boolean isAccessible = method.isAccessible();
        method.setAccessible(true);
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (Exception e2) {
            obj2 = null;
        }
        method.setAccessible(isAccessible);
        return obj2;
    }

    public static List<Field> getFieldsByType(Object obj, Class<?> cls) {
        Field[] declaredFields;
        ArrayList arrayList = new ArrayList();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.getType().isAssignableFrom(cls)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static Field getDeclaredField(Class<?> cls, Class<?> cls2) {
        Field[] declaredFields;
        if (cls == null) {
            return null;
        }
        while (cls != Object.class) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (cls2.isAssignableFrom(field.getType())) {
                        return field;
                    }
                }
                continue;
            } catch (Throwable th) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Class<?> getPropertyType(Class<?> cls, String str) throws NoSuchFieldException {
        return getDeclaredField(cls, str).getType();
    }

    public static String getGetterName(Class<?> cls, String str) {
        if (cls == null || StringUtils.isNull(str)) {
            return null;
        }
        if (cls.getName().equals("boolean")) {
            return "is" + getIsName(str);
        }
        return "get" + getSetterName(str);
    }

    private static String getIsName(String str) {
        return "is" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String getSetterName(String str) {
        return "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Method getGetterMethod(Class<?> cls, String str) {
        try {
            return cls.getMethod(getGetterName(cls, str), new Class[0]);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
