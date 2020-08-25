package com.baidu.live.adp.lib.ormobject.reflect;

import android.util.Log;
import com.baidu.live.adp.lib.util.BdLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class ClassHelper {
    public static final <T> T newEmptyInstance(Class<T> cls) {
        try {
            Constructor<T> constructor = cls.getConstructor(new Class[0]);
            if (constructor.getParameterTypes().length != 0) {
                return null;
            }
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            BdLog.detailException(e5);
            return null;
        }
    }

    public static final Object newEmptyParamsInstance(Class<?> cls) {
        Object obj = null;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            if (declaredConstructors.length != 1) {
                for (Constructor<?> constructor : declaredConstructors) {
                    constructor.setAccessible(true);
                    if (constructor.getParameterTypes().length == 0) {
                        constructor.setAccessible(true);
                        obj = constructor.newInstance(new Object[0]);
                        break;
                    }
                }
            } else {
                Constructor<?> constructor2 = declaredConstructors[0];
                if (constructor2.getParameterTypes().length == 0) {
                    constructor2.setAccessible(true);
                    obj = constructor2.newInstance(new Object[0]);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return obj;
    }

    public static final Object newOneIntParamsInstance(Class<?> cls, int i) {
        Object obj = null;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            if (declaredConstructors.length != 1) {
                for (Constructor<?> constructor : declaredConstructors) {
                    constructor.setAccessible(true);
                    if (constructor.getParameterTypes().length == 1) {
                        constructor.setAccessible(true);
                        obj = constructor.newInstance(Integer.valueOf(i));
                        break;
                    }
                }
            } else {
                Constructor<?> constructor2 = declaredConstructors[0];
                if (constructor2.getParameterTypes().length == 1) {
                    constructor2.setAccessible(true);
                    obj = constructor2.newInstance(Integer.valueOf(i));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return obj;
    }

    public static final boolean isClassIsSubClassForClazz(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return false;
        }
        if (cls == cls2) {
            return true;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static final Type[] getTypes(Type type) {
        if (type == null || !(type instanceof ParameterizedType)) {
            return null;
        }
        return ((ParameterizedType) type).getActualTypeArguments();
    }

    public static final Type[] getTypes(Class<?> cls, String str) {
        Field findField = findField(cls, str);
        if (findField != null) {
            return getTypes(findField.getGenericType());
        }
        return null;
    }

    public static final Object invokeMethodParam(String str, Object obj, Class<?> cls, Object... objArr) {
        Method findMethod = findMethod(cls, str, objArr);
        if (findMethod == null) {
            return null;
        }
        try {
            findMethod.setAccessible(true);
            return findMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Object invokeMethodParam(Method method, Object obj, Class<?> cls, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Object invokeMethodNoParam(String str, Object obj, Class<?> cls) {
        Method findMethod = findMethod(cls, str, new Object[0]);
        if (findMethod == null) {
            return null;
        }
        try {
            findMethod.setAccessible(true);
            return findMethod.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Object invokeMethodNoParam(Method method, Object obj, Class<?> cls) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final List<Method> findMethods(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        while (cls != Object.class) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods != null) {
                for (Method method : declaredMethods) {
                    if (method != null) {
                        linkedList.add(method);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return linkedList;
    }

    public static final Method findMethod(Class<?> cls, String str, Object... objArr) {
        Method method;
        Method method2 = null;
        while (cls != Object.class && method2 == null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = method2;
                    break;
                }
                method = declaredMethods[i];
                if (method != null && method.getName().equals(str)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes != null || objArr != null) {
                        if (parameterTypes != null && objArr != null && parameterTypes.length == objArr.length) {
                            boolean z = true;
                            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                                if (parameterTypes[i2].isPrimitive()) {
                                    if (parameterTypes[i2] == Integer.TYPE && objArr[i2].getClass() == Integer.class) {
                                        Log.d("ClassHelper", "findMethod int");
                                    } else if (parameterTypes[i2] == Short.TYPE && objArr[i2].getClass() == Short.class) {
                                        Log.d("ClassHelper", "findMethod short");
                                    } else if (parameterTypes[i2] == Long.TYPE && objArr[i2].getClass() == Long.class) {
                                        Log.d("ClassHelper", "findMethod long");
                                    } else if (parameterTypes[i2] == Float.TYPE && objArr[i2].getClass() == Float.class) {
                                        Log.d("ClassHelper", "findMethod float");
                                    } else if (parameterTypes[i2] == Double.TYPE && objArr[i2].getClass() == Double.class) {
                                        Log.d("ClassHelper", "findMethod double");
                                    } else if (parameterTypes[i2] == Boolean.TYPE && objArr[i2].getClass() == Boolean.class) {
                                        Log.d("ClassHelper", "findMethod boolean");
                                    } else if (parameterTypes[i2] == Byte.TYPE && objArr[i2].getClass() == Byte.class) {
                                        Log.d("ClassHelper", "findMethod byte");
                                    } else if (parameterTypes[i2] == Character.TYPE && objArr[i2].getClass() == Character.class) {
                                        Log.d("ClassHelper", "findMethod char");
                                    } else {
                                        Log.d("ClassHelper", "findMethod no match");
                                        z = false;
                                    }
                                } else if (objArr[i2].getClass() != parameterTypes[i2]) {
                                    z = false;
                                }
                            }
                            if (!z) {
                            }
                        }
                    }
                }
                i++;
            }
            cls = cls.getSuperclass();
            method2 = method;
        }
        return method2;
    }

    public static final List<Field> findFields(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        while (cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    if (field != null && !Modifier.isTransient(field.getModifiers())) {
                        linkedList.add(field);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return linkedList;
    }

    public static final Field findField(Class<?> cls, String str) {
        Field field = null;
        while (cls != Object.class && field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
            }
            cls = cls.getSuperclass();
        }
        return field;
    }

    public static final Object getValueForField(Object obj, String str) {
        Field findField = findField(obj.getClass(), str);
        if (findField != null) {
            try {
                findField.setAccessible(true);
                return findField.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static final boolean setValueForField(Object obj, String str, Object obj2) {
        Field findField = findField(obj.getClass(), str);
        if (findField != null) {
            try {
                findField.setAccessible(true);
                findField.set(obj, obj2);
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static final Class<?> getFieldType(Object obj, String str) {
        Field findField = findField(obj.getClass(), str);
        if (findField != null) {
            return findField.getType();
        }
        return null;
    }
}
