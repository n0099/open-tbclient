package com.baidu.ar.bus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class f {
    private static final Map<Class<?>, List<e>> kx = new ConcurrentHashMap();
    private static final a[] ky = new a[4];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a {
        Class<?> kD;
        Class<?> kE;
        boolean kF;
        final List<e> kz = new ArrayList();
        final Map<Class, Object> kA = new HashMap();
        final Map<String, Class> kB = new HashMap();
        final StringBuilder kC = new StringBuilder(128);

        a() {
        }

        private boolean b(Method method, Class<?> cls) {
            this.kC.setLength(0);
            this.kC.append(method.getName());
            this.kC.append('>').append(cls.getName());
            String sb = this.kC.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.kB.put(sb, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.kB.put(sb, put);
            return false;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.kA.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.kA.put(cls, this);
            }
            return b(method, cls);
        }

        void c(Class<?> cls) {
            this.kE = cls;
            this.kD = cls;
            this.kF = false;
        }

        void cL() {
            if (this.kF) {
                this.kE = null;
                return;
            }
            this.kE = this.kE.getSuperclass();
            String name = this.kE.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.kE = null;
            }
        }

        void recycle() {
            this.kz.clear();
            this.kA.clear();
            this.kB.clear();
            this.kC.setLength(0);
            this.kD = null;
            this.kE = null;
            this.kF = false;
        }
    }

    private List<e> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.kz);
        aVar.recycle();
        synchronized (ky) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (ky[i] == null) {
                    ky[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private List<e> b(Class<?> cls) {
        a cK = cK();
        cK.c(cls);
        while (cK.kE != null) {
            b(cK);
            cK.cL();
        }
        return a(cK);
    }

    private void b(a aVar) {
        Method[] methodArr;
        CallBack callBack;
        try {
            methodArr = aVar.kE.getDeclaredMethods();
        } catch (Throwable th) {
            try {
                Method[] methods = aVar.kE.getMethods();
                aVar.kF = true;
                methodArr = methods;
            } catch (LinkageError e) {
                com.baidu.ar.g.b.aP(("Could not inspect methods of " + aVar.kE.getName()) + ". Please make this class visible to EventBus annotation processor to avoid reflection.");
                return;
            }
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && (callBack = (CallBack) method.getAnnotation(CallBack.class)) != null) {
                    Class<?> cls = parameterTypes[0];
                    if (aVar.a(method, cls)) {
                        aVar.kz.add(new e(method, cls, callBack.threadMode()));
                    }
                }
            }
        }
    }

    private a cK() {
        synchronized (ky) {
            for (int i = 0; i < 4; i++) {
                a aVar = ky[i];
                if (aVar != null) {
                    ky[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<e> a(Class<?> cls) {
        List<e> list = kx.get(cls);
        if (list != null) {
            return list;
        }
        List<e> b = b(cls);
        if (b.isEmpty()) {
            com.baidu.ar.g.b.aP("Subscriber " + cls + " and its super classes have no public methods with the @CallBack annotation");
            return null;
        }
        kx.put(cls, b);
        return b;
    }
}
