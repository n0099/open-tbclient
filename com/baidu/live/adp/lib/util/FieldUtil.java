package com.baidu.live.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class FieldUtil {
    public static final String TYPE_BOOLEAN = "java.lang.Boolean";
    public static final String TYPE_BYTE = "java.lang.Byte";
    public static final String TYPE_CHARACTER = "java.lang.Character";
    public static final String TYPE_DATE = "java.util.Date";
    public static final String TYPE_DOUBLE = "java.lang.Double";
    public static final String TYPE_FLOAT = "java.lang.Float";
    public static final String TYPE_INTEGER = "java.lang.Integer";
    public static final String TYPE_LONG = "java.lang.Long";
    public static final String TYPE_SHORT = "java.lang.Short";
    public static final String TYPE_STRING = "java.lang.String";
    public static String dateFormat = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> PrimitiveTypes = new HashMap<>();

    static {
        PrimitiveTypes.put(TYPE_STRING, TYPE_STRING);
        PrimitiveTypes.put(TYPE_INTEGER, TYPE_INTEGER);
        PrimitiveTypes.put(TYPE_DOUBLE, TYPE_DOUBLE);
        PrimitiveTypes.put(TYPE_FLOAT, TYPE_FLOAT);
        PrimitiveTypes.put(TYPE_BOOLEAN, TYPE_BOOLEAN);
        PrimitiveTypes.put(TYPE_CHARACTER, TYPE_CHARACTER);
        PrimitiveTypes.put(TYPE_SHORT, TYPE_SHORT);
        PrimitiveTypes.put(TYPE_LONG, TYPE_LONG);
        PrimitiveTypes.put(TYPE_BYTE, TYPE_BYTE);
        PrimitiveTypes.put(TYPE_DATE, TYPE_DATE);
        PrimitiveTypes.put(TYPE_INTEGER, TYPE_INTEGER);
        PrimitiveTypes.put(TYPE_INTEGER, TYPE_INTEGER);
    }

    public static boolean isPrimitiveType(String str) {
        return PrimitiveTypes.get(str) != null;
    }

    public static boolean isPrimitiveType(Field field) {
        Class<?> type = field.getType();
        return type.equals(Integer.TYPE) || type.equals(Long.TYPE) || type.equals(Byte.TYPE) || type.equals(Boolean.TYPE) || type.equals(Character.TYPE) || type.equals(Double.TYPE) || type.equals(Float.TYPE) || type.equals(Short.TYPE) || PrimitiveTypes.get(type.getName()) != null;
    }

    private static Object setFieldType(Class<?> cls, Object obj) {
        if (obj != null) {
            String name = cls.getName();
            if (name.equals(TYPE_INTEGER) || cls.equals(Integer.TYPE)) {
                return Integer.valueOf(Integer.parseInt(obj.toString()));
            }
            if (name.equals(TYPE_STRING)) {
                return obj.toString();
            }
            if (name.equals(TYPE_LONG) || cls.equals(Long.TYPE)) {
                return Long.valueOf(Long.parseLong(obj.toString()));
            }
            if (name.equals(TYPE_BOOLEAN) || cls.equals(Boolean.TYPE)) {
                return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
            }
            if (name.equals(TYPE_BYTE) || cls.equals(Byte.TYPE)) {
                return Byte.valueOf(Byte.parseByte(obj.toString()));
            }
            if (name.equals(TYPE_CHARACTER) || cls.equals(Character.TYPE)) {
                return Character.valueOf(obj.toString().charAt(0));
            }
            if (name.equals(TYPE_DOUBLE) || cls.equals(Double.TYPE)) {
                return Double.valueOf(Double.parseDouble(obj.toString()));
            }
            if (name.equals(TYPE_FLOAT) || cls.equals(Float.TYPE)) {
                return Float.valueOf(Float.parseFloat(obj.toString()));
            }
            if (name.equals(TYPE_SHORT) || cls.equals(Short.TYPE)) {
                return Short.valueOf(Short.parseShort(obj.toString()));
            }
            if (name.equals(TYPE_DATE)) {
                return StringUtils.handleDate(obj.toString(), dateFormat);
            }
            return (cls.isArray() && (obj instanceof String)) ? new String[]{obj.toString()} : obj;
        }
        return obj;
    }

    public static void forceSetProperty(Object obj, String str, Object obj2) throws NoSuchFieldException {
        if (obj != null && !StringUtils.isNull(str)) {
            Field declaredField = BSBeanUtils.getDeclaredField(obj, str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            try {
                declaredField.set(obj, setFieldType(declaredField.getType(), obj2));
            } catch (IllegalAccessException e) {
            }
            declaredField.setAccessible(isAccessible);
        }
    }

    public static void forceSetProperty(Class<?> cls, String str, Object obj) throws NoSuchFieldException {
        if (cls != null && !StringUtils.isNull(str)) {
            Field declaredField = BSBeanUtils.getDeclaredField(cls, str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            try {
                declaredField.set(cls, setFieldType(declaredField.getType(), obj));
            } catch (IllegalAccessException e) {
            }
            declaredField.setAccessible(isAccessible);
        }
    }

    public static Object forceGetProperty(Object obj, Field field) {
        Object obj2 = null;
        if (obj != null && field != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                obj2 = field.get(obj);
            } catch (Throwable th) {
            }
            field.setAccessible(isAccessible);
        }
        return obj2;
    }
}
