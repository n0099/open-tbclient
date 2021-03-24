package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class ReflectUtils {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3978a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3979b = true;

    /* loaded from: classes2.dex */
    public class NULL {
        public NULL() {
        }
    }

    public ReflectUtils(Class<?> cls) {
        this.f3978a = cls;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static Class<?> c(String str) throws RuntimeException {
        try {
            return Class.forName(str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Field d(String str) throws RuntimeException {
        Class<?> type = type();
        try {
            return type.getField(str);
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new RuntimeException(e2);
                    }
                }
            } while (type == null);
            throw new RuntimeException(e2);
        }
    }

    public static ReflectUtils on(String str) throws RuntimeException {
        return on(c(str));
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            return Void.TYPE == cls ? Void.class : cls;
        }
        return cls;
    }

    public <P> P as(Class<P> cls) {
        final boolean z = this.f3978a instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.baidu.apollon.utils.ReflectUtils.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                try {
                    return ReflectUtils.on(ReflectUtils.this.f3978a).call(name, objArr).get();
                } catch (RuntimeException e2) {
                    if (z) {
                        Map map = (Map) ReflectUtils.this.f3978a;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.b(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.b(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.b(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e2;
                }
            }
        });
    }

    public ReflectUtils call(String str) throws RuntimeException {
        return call(str, new Object[0]);
    }

    public ReflectUtils create() throws RuntimeException {
        return create(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ReflectUtils) {
            return this.f3978a.equals(((ReflectUtils) obj).get());
        }
        return false;
    }

    public ReflectUtils field(String str) throws RuntimeException {
        try {
            return on(d(str).get(this.f3978a));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public Map<String, ReflectUtils> fields() {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.f3979b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return linkedHashMap;
    }

    public <T> T get() {
        return (T) this.f3978a;
    }

    public int hashCode() {
        return this.f3978a.hashCode();
    }

    public ReflectUtils set(String str, Object obj) throws RuntimeException {
        try {
            Field d2 = d(str);
            d2.setAccessible(true);
            d2.set(this.f3978a, a(obj));
            return this;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return this.f3978a.toString();
    }

    public Class<?> type() {
        if (this.f3979b) {
            return (Class) this.f3978a;
        }
        return this.f3978a.getClass();
    }

    public static ReflectUtils on(String str, ClassLoader classLoader) throws RuntimeException {
        return on(a(str, classLoader));
    }

    public ReflectUtils call(String str, Object... objArr) throws RuntimeException {
        Class<?>[] a2 = a(objArr);
        try {
            try {
                return a(a(str, a2), this.f3978a, objArr);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, a2), this.f3978a, objArr);
        }
    }

    public ReflectUtils create(Object... objArr) throws RuntimeException {
        Constructor<?>[] declaredConstructors;
        Class<?>[] a2 = a(objArr);
        try {
            return a(type().getDeclaredConstructor(a2), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), a2)) {
                    return a(constructor, objArr);
                }
            }
            throw new RuntimeException(e2);
        }
    }

    public <T> T get(String str) throws RuntimeException {
        return (T) field(str).get();
    }

    public static ReflectUtils a(Constructor<?> constructor, Object... objArr) throws RuntimeException {
        try {
            return on(((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static ReflectUtils on(Class<?> cls) {
        return new ReflectUtils(cls);
    }

    public ReflectUtils(Object obj) {
        this.f3978a = obj;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Method[] methods;
        Method[] declaredMethods;
        Class<?> type = type();
        for (Method method : type.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : type.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    public static ReflectUtils on(Object obj) {
        return new ReflectUtils(obj);
    }

    public static ReflectUtils a(Method method, Object obj, Object... objArr) throws RuntimeException {
        try {
            accessible(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return on(obj);
            }
            return on(method.invoke(obj, objArr));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Object a(Object obj) {
        return obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj;
    }

    public static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    public static Class<?> a(String str, ClassLoader classLoader) throws RuntimeException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        try {
            return type.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return type.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
