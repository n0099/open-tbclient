package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class m {
    private static Map<Class, Integer> yl = new HashMap();
    private static Map<Class, List<Constructor<? extends g>>> ym = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static h i(Object obj) {
        int i = 0;
        if (obj instanceof e) {
            return new f((e) obj);
        }
        if (obj instanceof h) {
            return (h) obj;
        }
        Class<?> cls = obj.getClass();
        if (i(cls) == 2) {
            List<Constructor<? extends g>> list = ym.get(cls);
            if (list.size() == 1) {
                return new v(a(list.get(0), obj));
            }
            g[] gVarArr = new g[list.size()];
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    gVarArr[i2] = a(list.get(i2), obj);
                    i = i2 + 1;
                } else {
                    return new c(gVarArr);
                }
            }
        } else {
            return new t(obj);
        }
    }

    private static g a(Constructor<? extends g> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    private static Constructor<? extends g> h(Class<?> cls) {
        try {
            Package r1 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r1 != null ? r1.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String aR = aR(canonicalName);
            if (!name.isEmpty()) {
                aR = name + "." + aR;
            }
            Constructor declaredConstructor = Class.forName(aR).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
                return declaredConstructor;
            }
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int i(Class<?> cls) {
        if (yl.containsKey(cls)) {
            return yl.get(cls).intValue();
        }
        int j = j(cls);
        yl.put(cls, Integer.valueOf(j));
        return j;
    }

    private static int j(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends g> h = h(cls);
        if (h != null) {
            ym.put(cls, Collections.singletonList(h));
            return 2;
        } else if (b.xK.e(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (k(superclass)) {
                if (i((Class<?>) superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(ym.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (k(cls2)) {
                    if (i(cls2) == 1) {
                        return 1;
                    }
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.addAll(ym.get(cls2));
                    arrayList = arrayList2;
                }
            }
            if (arrayList != null) {
                ym.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }

    private static boolean k(Class<?> cls) {
        return cls != null && i.class.isAssignableFrom(cls);
    }

    public static String aR(String str) {
        return str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + "_LifecycleAdapter";
    }
}
