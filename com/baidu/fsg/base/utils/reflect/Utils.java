package com.baidu.fsg.base.utils.reflect;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class Utils {

    /* renamed from: c  reason: collision with root package name */
    public static final String f5391c = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f5389a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f5390b = new Class[0];

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f5392d = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");

    public static boolean a(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && (objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length);
    }

    public static Object[] b(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? f5389a : objArr;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMethodDeclaredThrowable(Method method, Throwable th) {
        Class<?>[] exceptionTypes;
        String name;
        boolean z;
        if (th instanceof RuntimeException) {
            return true;
        }
        if (method == null || th == null || ((exceptionTypes = method.getExceptionTypes()) == null && exceptionTypes.length <= 0)) {
            return false;
        }
        try {
            name = method.getName();
        } catch (Throwable unused) {
        }
        if (!BOSTokenRequest.ACCEPT.equals(name) && !"sendto".equals(name)) {
            z = false;
            if ((th instanceof SocketException) && z) {
                if (method.getDeclaringClass().getName().indexOf("libcore") >= 0) {
                    return true;
                }
            }
            for (Class<?> cls : exceptionTypes) {
                if (cls.isInstance(th) || cls.isAssignableFrom(th.getClass())) {
                    return true;
                }
            }
            return false;
        }
        z = true;
        if (th instanceof SocketException) {
            if (method.getDeclaringClass().getName().indexOf("libcore") >= 0) {
            }
        }
        while (r3 < r6) {
        }
        return false;
    }

    public static boolean validateJavaIdentifier(String str) {
        return f5392d.matcher(str).matches();
    }

    public static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return f5390b;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
        }
        return clsArr;
    }

    public static Class<?>[] a(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? f5390b : clsArr;
    }

    public static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
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
}
