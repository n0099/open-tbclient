package com.baidu.fsg.base.utils;

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
/* loaded from: classes6.dex */
public final class ReflectUtils {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2040a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2041b = true;

    private ReflectUtils(Class<?> cls) {
        this.f2040a = cls;
    }

    private ReflectUtils(Object obj) {
        this.f2040a = obj;
    }

    public static ReflectUtils on(String str) throws RuntimeException {
        return on(c(str));
    }

    public static ReflectUtils on(String str, ClassLoader classLoader) throws RuntimeException {
        return on(a(str, classLoader));
    }

    public static ReflectUtils on(Class<?> cls) {
        return new ReflectUtils(cls);
    }

    public static ReflectUtils on(Object obj) {
        return new ReflectUtils(obj);
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
            return t;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private static ReflectUtils a(Constructor<?> constructor, Object... objArr) throws RuntimeException {
        try {
            return on(((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ReflectUtils a(Method method, Object obj, Object... objArr) throws RuntimeException {
        try {
            accessible(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return on(obj);
            }
            return on(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof ReflectUtils) {
            return ((ReflectUtils) obj).get();
        }
        return obj;
    }

    private static Class<?>[] a(Object... objArr) {
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

    private static Class<?> c(String str) throws RuntimeException {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> a(String str, ClassLoader classLoader) throws RuntimeException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            if (Void.TYPE == cls) {
                return Void.class;
            }
            return cls;
        }
        return cls;
    }

    public <T> T get() {
        return (T) this.f2040a;
    }

    public ReflectUtils set(String str, Object obj) throws RuntimeException {
        try {
            Field d = d(str);
            d.setAccessible(true);
            d.set(this.f2040a, a(obj));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T get(String str) throws RuntimeException {
        return (T) field(str).get();
    }

    public ReflectUtils field(String str) throws RuntimeException {
        try {
            return on(d(str).get(this.f2040a));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Field d(String str) throws RuntimeException {
        Class<?> cls;
        Class<?> type = type();
        try {
            return type.getField(str);
        } catch (NoSuchFieldException e) {
            while (true) {
                try {
                    cls = type;
                    return (Field) accessible(cls.getDeclaredField(str));
                } catch (NoSuchFieldException e2) {
                    type = cls.getSuperclass();
                    if (type == null) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public Map<String, ReflectUtils> fields() {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.f2041b) ^ Modifier.isStatic(field.getModifiers())) {
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

    public ReflectUtils call(String str) throws RuntimeException {
        return call(str, new Object[0]);
    }

    public ReflectUtils call(String str, Object... objArr) throws RuntimeException {
        Class<?>[] a2 = a(objArr);
        try {
            return a(a(str, a2), this.f2040a, objArr);
        } catch (NoSuchMethodException e) {
            try {
                return a(b(str, a2), this.f2040a, objArr);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> type = type();
        try {
            return type.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return type.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException e2) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException();
        }
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

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public ReflectUtils create() throws RuntimeException {
        return create(new Object[0]);
    }

    public ReflectUtils create(Object... objArr) throws RuntimeException {
        Constructor<?>[] declaredConstructors;
        Class<?>[] a2 = a(objArr);
        try {
            return a(type().getDeclaredConstructor(a2), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), a2)) {
                    return a(constructor, objArr);
                }
            }
            throw new RuntimeException(e);
        }
    }

    public <P> P as(Class<P> cls) {
        final boolean z = this.f2040a instanceof Map;
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.baidu.fsg.base.utils.ReflectUtils.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                try {
                    return ReflectUtils.on(ReflectUtils.this.f2040a).call(name, objArr).get();
                } catch (RuntimeException e) {
                    if (z) {
                        Map map = (Map) ReflectUtils.this.f2040a;
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
                    throw e;
                }
            }
        });
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

    public int hashCode() {
        return this.f2040a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ReflectUtils) {
            return this.f2040a.equals(((ReflectUtils) obj).get());
        }
        return false;
    }

    public String toString() {
        return this.f2040a.toString();
    }

    public Class<?> type() {
        return this.f2041b ? (Class) this.f2040a : this.f2040a.getClass();
    }

    /* loaded from: classes6.dex */
    public class NULL {
        public NULL() {
        }
    }
}
