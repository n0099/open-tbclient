package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
class b {
    static b yk = new b();
    private final Map<Class, a> yl = new HashMap();
    private final Map<Class, Boolean> ym = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Class cls) {
        if (this.ym.containsKey(cls)) {
            return this.ym.get(cls).booleanValue();
        }
        Method[] f = f(cls);
        for (Method method : f) {
            if (((r) method.getAnnotation(r.class)) != null) {
                a(cls, f);
                return true;
            }
        }
        this.ym.put(cls, false);
        return false;
    }

    private Method[] f(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a g(Class cls) {
        a aVar = this.yl.get(cls);
        if (aVar == null) {
            return a(cls, null);
        }
        return aVar;
    }

    private void a(Map<C0001b, Lifecycle.Event> map, C0001b c0001b, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(c0001b);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + c0001b.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(c0001b, event);
        }
    }

    private a a(Class cls, @Nullable Method[] methodArr) {
        int i;
        boolean z;
        a g;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (g = g(superclass)) != null) {
            hashMap.putAll(g.yo);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0001b, Lifecycle.Event> entry : g(cls2).yo.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = f(cls);
        }
        int length = methodArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            Method method = methodArr[i2];
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar == null) {
                z = z2;
            } else {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(j.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                Lifecycle.Event gn = rVar.gn();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (gn != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new C0001b(i, method), gn, cls);
                z = true;
            }
            i2++;
            z2 = z;
        }
        a aVar = new a(hashMap);
        this.yl.put(cls, aVar);
        this.ym.put(cls, Boolean.valueOf(z2));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        final Map<Lifecycle.Event, List<C0001b>> yn = new HashMap();
        final Map<C0001b, Lifecycle.Event> yo;

        a(Map<C0001b, Lifecycle.Event> map) {
            this.yo = map;
            for (Map.Entry<C0001b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<C0001b> list = this.yn.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.yn.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(j jVar, Lifecycle.Event event, Object obj) {
            a(this.yn.get(event), jVar, event, obj);
            a(this.yn.get(Lifecycle.Event.ON_ANY), jVar, event, obj);
        }

        private static void a(List<C0001b> list, j jVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).b(jVar, event, obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.arch.lifecycle.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0001b {
        final Method mMethod;
        final int yp;

        C0001b(int i, Method method) {
            this.yp = i;
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        void b(j jVar, Lifecycle.Event event, Object obj) {
            try {
                switch (this.yp) {
                    case 0:
                        this.mMethod.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.mMethod.invoke(obj, jVar);
                        return;
                    case 2:
                        this.mMethod.invoke(obj, jVar, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0001b c0001b = (C0001b) obj;
            return this.yp == c0001b.yp && this.mMethod.getName().equals(c0001b.mMethod.getName());
        }

        public int hashCode() {
            return (this.yp * 31) + this.mMethod.getName().hashCode();
        }
    }
}
