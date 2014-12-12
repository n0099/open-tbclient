package com.baidu.adp.lib.a.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final Object j(Class<?> cls) {
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

    public static final boolean a(Class<?> cls, Class<?> cls2) {
        if (cls == null || cls2 == null) {
            return false;
        }
        if (cls == cls2) {
            return true;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static final List<Field> k(Class<?> cls) {
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

    public static final Object b(Object obj, String str) {
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

    public static final boolean a(Object obj, String str, Object obj2) {
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
