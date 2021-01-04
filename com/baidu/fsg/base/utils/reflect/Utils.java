package com.baidu.fsg.base.utils.reflect;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    static final Object[] f2056a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f2057b = new Class[0];
    private static final String c = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
    private static final Pattern d = Pattern.compile(c);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && (objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return f2057b;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] a(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return f2057b;
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return f2056a;
        }
        return objArr;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    a(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static boolean isMethodDeclaredThrowable(Method method, Throwable th) {
        if (th instanceof RuntimeException) {
            return true;
        }
        if (method == null || th == null) {
            return false;
        }
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (exceptionTypes != null || exceptionTypes.length > 0) {
            try {
                String name = method.getName();
                boolean z = UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET.equals(name) || "sendto".equals(name);
                if ((th instanceof SocketException) && z) {
                    if (method.getDeclaringClass().getName().indexOf("libcore") >= 0) {
                        return true;
                    }
                }
            } catch (Throwable th2) {
            }
            for (Class<?> cls : exceptionTypes) {
                if (cls.isInstance(th) || cls.isAssignableFrom(th.getClass())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean validateJavaIdentifier(String str) {
        return d.matcher(str).matches();
    }
}
