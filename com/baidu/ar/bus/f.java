package com.baidu.ar.bus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f {
    public static final Map<Class<?>, List<e>> kM = new ConcurrentHashMap();
    public static final a[] kN = new a[4];

    /* loaded from: classes.dex */
    public static class a {
        public final List<e> kO = new ArrayList();
        public final Map<Class, Object> kP = new HashMap();
        public final Map<String, Class> kQ = new HashMap();
        public final StringBuilder kR = new StringBuilder(128);
        public Class<?> kS;
        public Class<?> kT;
        public boolean kU;

        private boolean b(Method method, Class<?> cls) {
            this.kR.setLength(0);
            this.kR.append(method.getName());
            StringBuilder sb = this.kR;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.kR.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.kQ.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.kQ.put(sb2, put);
            return false;
        }

        public boolean a(Method method, Class<?> cls) {
            Object put = this.kP.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.kP.put(cls, this);
            }
            return b(method, cls);
        }

        public void c(Class<?> cls) {
            this.kT = cls;
            this.kS = cls;
            this.kU = false;
        }

        public void cK() {
            if (!this.kU) {
                Class<? super Object> superclass = this.kT.getSuperclass();
                this.kT = superclass;
                String name = superclass.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                    return;
                }
            }
            this.kT = null;
        }

        public void recycle() {
            this.kO.clear();
            this.kP.clear();
            this.kQ.clear();
            this.kR.setLength(0);
            this.kS = null;
            this.kT = null;
            this.kU = false;
        }
    }

    private List<e> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.kO);
        aVar.recycle();
        synchronized (kN) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (kN[i] == null) {
                    kN[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private List<e> b(Class<?> cls) {
        a cJ = cJ();
        cJ.c(cls);
        while (cJ.kT != null) {
            b(cJ);
            cJ.cK();
        }
        return a(cJ);
    }

    private void b(a aVar) {
        Method[] methods;
        CallBack callBack;
        try {
            try {
                methods = aVar.kT.getDeclaredMethods();
            } catch (LinkageError unused) {
                com.baidu.ar.h.b.aS(("Could not inspect methods of " + aVar.kT.getName()) + ". Please make this class visible to EventBus annotation processor to avoid reflection.");
                return;
            }
        } catch (Throwable unused2) {
            methods = aVar.kT.getMethods();
            aVar.kU = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && (callBack = (CallBack) method.getAnnotation(CallBack.class)) != null) {
                    Class<?> cls = parameterTypes[0];
                    if (aVar.a(method, cls)) {
                        aVar.kO.add(new e(method, cls, callBack.threadMode()));
                    }
                }
            }
        }
    }

    private a cJ() {
        synchronized (kN) {
            for (int i = 0; i < 4; i++) {
                a aVar = kN[i];
                if (aVar != null) {
                    kN[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    public List<e> a(Class<?> cls) {
        List<e> list = kM.get(cls);
        if (list != null) {
            return list;
        }
        List<e> b = b(cls);
        if (!b.isEmpty()) {
            kM.put(cls, b);
            return b;
        }
        com.baidu.ar.h.b.aS("Subscriber " + cls + " and its super classes have no public methods with the @CallBack annotation");
        return null;
    }
}
