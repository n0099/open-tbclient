package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import com.baidu.mobads.g.g;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {
    private static volatile Map<String, c> c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f2430a;
    private Method[] b;

    public static c a(Context context, String str) {
        if (!c.containsKey(str) || c.get(str).f2430a == null) {
            synchronized (c.class) {
                if (!c.containsKey(str) || c.get(str).f2430a == null) {
                    c.put(str, new c(context, str));
                }
            }
        }
        return c.get(str);
    }

    private c(Context context, String str) {
        this.b = null;
        try {
            DexClassLoader d = com.baidu.mobads.g.b.d();
            if (d == null) {
                this.f2430a = b(context, str);
            } else {
                this.f2430a = Class.forName(str, true, d);
            }
            this.b = this.f2430a.getMethods();
        } catch (Throwable th) {
            q.a().d(th);
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f2430a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                q.a().d(th);
                return null;
            }
        }
        constructor = this.f2430a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    public Class<?> b(Context context, String str) {
        Class<?> cls = null;
        q a2 = q.a();
        try {
            cls = Class.forName(str, true, new DexClassLoader(g.a(context), context.getFilesDir().getAbsolutePath(), null, c.class.getClass().getClassLoader()));
        } catch (Throwable th) {
            a2.d(th);
        }
        a2.d("jar.path=, clz=" + cls);
        return cls;
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr == null || objArr.length == 0) {
                    a2.invoke(obj, new Object[0]);
                } else {
                    a2.invoke(obj, objArr);
                }
            }
        } catch (Throwable th) {
            q.a().d(th);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0020 -> B:8:0x0012). Please submit an issue!!! */
    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr == null || objArr.length == 0) {
                    return a2.invoke(obj, new Object[0]);
                }
                return a2.invoke(obj, objArr);
            }
        } catch (Throwable th) {
            q.a().d(th);
        }
        return null;
    }

    public String c(Object obj, String str, Object... objArr) {
        Object invoke;
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr == null || objArr.length == 0) {
                    invoke = a2.invoke(obj, new Object[0]);
                } else {
                    invoke = a2.invoke(obj, objArr);
                }
                if (invoke instanceof String) {
                    return (String) invoke;
                }
            }
        } catch (Throwable th) {
            q.a().d(th);
        }
        return null;
    }

    private Method a(String str) {
        Method[] methodArr;
        if (this.b == null) {
            return null;
        }
        for (Method method : this.b) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
