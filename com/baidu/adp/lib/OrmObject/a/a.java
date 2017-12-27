package com.baidu.adp.lib.OrmObject.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final Object d(Class<?> cls) {
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

    public static final Object a(Class<?> cls, int i) {
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

    public static final boolean d(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return false;
        }
        if (cls == cls2) {
            return true;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static final Object a(Method method, Object obj, Class<?> cls, Object... objArr) {
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

    public static final Object a(Method method, Object obj, Class<?> cls) {
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

    public static final Method b(Class<?> cls, String str, Object... objArr) {
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
                                    if ((parameterTypes[i2] != Integer.TYPE || objArr[i2].getClass() != Integer.class) && ((parameterTypes[i2] != Short.TYPE || objArr[i2].getClass() != Short.class) && ((parameterTypes[i2] != Long.TYPE || objArr[i2].getClass() != Long.class) && ((parameterTypes[i2] != Float.TYPE || objArr[i2].getClass() != Float.class) && ((parameterTypes[i2] != Double.TYPE || objArr[i2].getClass() != Double.class) && ((parameterTypes[i2] != Boolean.TYPE || objArr[i2].getClass() != Boolean.class) && ((parameterTypes[i2] != Byte.TYPE || objArr[i2].getClass() != Byte.class) && (parameterTypes[i2] != Character.TYPE || objArr[i2].getClass() != Character.class)))))))) {
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

    public static final List<Field> e(Class<?> cls) {
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

    public static final Field b(Class<?> cls, String str) {
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

    public static final Object g(Object obj, String str) {
        Field b = b(obj.getClass(), str);
        if (b != null) {
            try {
                b.setAccessible(true);
                return b.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static final boolean d(Object obj, String str, Object obj2) {
        Field b = b(obj.getClass(), str);
        if (b != null) {
            try {
                b.setAccessible(true);
                b.set(obj, obj2);
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
