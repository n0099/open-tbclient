package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3721a = 1032;

    /* renamed from: b  reason: collision with root package name */
    public static Map<Class<?>, Method> f3722b = new HashMap();

    public static void a() {
        synchronized (f3722b) {
            f3722b.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        r1 = com.baidu.apollon.eventbus.f.f3722b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
        com.baidu.apollon.eventbus.f.f3722b.put(r12, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Method a(Class<?> cls) {
        Method method;
        synchronized (f3722b) {
            method = f3722b.get(cls);
        }
        if (method != null) {
            return method;
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            Method[] methods = cls2.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    Method method2 = methods[i2];
                    if (method2.getName().equals(EventBus.DEFAULT_METHOD_NAME)) {
                        int modifiers = method2.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & f3721a) == 0) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (parameterTypes.length == 1 && parameterTypes[0] == EventBus.Event.class) {
                                method = method2;
                                break;
                            }
                        }
                    }
                    i2++;
                }
            }
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called " + EventBus.DEFAULT_METHOD_NAME);
    }
}
