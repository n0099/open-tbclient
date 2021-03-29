package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import com.baidu.mobads.g.g;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile Map<String, c> f8387c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f8388a;

    /* renamed from: b  reason: collision with root package name */
    public Method[] f8389b;

    public c(Context context, String str) {
        this.f8389b = null;
        try {
            DexClassLoader d2 = com.baidu.mobads.g.b.d();
            if (d2 == null) {
                this.f8388a = b(context, str);
            } else {
                this.f8388a = Class.forName(str, true, d2);
            }
            this.f8389b = this.f8388a.getMethods();
        } catch (Throwable th) {
            q.a().d(th);
        }
    }

    public static c a(Context context, String str) {
        if (!f8387c.containsKey(str) || f8387c.get(str).f8388a == null) {
            synchronized (c.class) {
                if (!f8387c.containsKey(str) || f8387c.get(str).f8388a == null) {
                    f8387c.put(str, new c(context, str));
                }
            }
        }
        return f8387c.get(str);
    }

    public Class<?> b(Context context, String str) {
        q a2 = q.a();
        Class<?> cls = null;
        try {
            cls = Class.forName(str, true, new DexClassLoader(g.a(context), context.getFilesDir().getAbsolutePath(), null, c.class.getClass().getClassLoader()));
        } catch (Throwable th) {
            a2.d(th);
        }
        a2.d("jar.path=, clz=" + cls);
        return cls;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:5:0x0008, B:8:0x000c, B:10:0x0018, B:12:0x001c, B:9:0x0011), top: B:18:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(Object obj, String str, Object... objArr) {
        Object invoke;
        try {
            Method a2 = a(str);
            if (a2 == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                invoke = a2.invoke(obj, objArr);
                if (invoke instanceof String) {
                    return null;
                }
                return (String) invoke;
            }
            invoke = a2.invoke(obj, new Object[0]);
            if (invoke instanceof String) {
            }
        } catch (Throwable th) {
            q.a().d(th);
            return null;
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f8388a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                q.a().d(th);
                return null;
            }
        }
        constructor = this.f8388a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    return a2.invoke(obj, objArr);
                }
                return a2.invoke(obj, new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            q.a().d(th);
            return null;
        }
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    a2.invoke(obj, objArr);
                }
                a2.invoke(obj, new Object[0]);
            }
        } catch (Throwable th) {
            q.a().d(th);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.f8389b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
