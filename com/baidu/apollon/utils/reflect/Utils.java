package com.baidu.apollon.utils.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f38064a;

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f38065b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f38066c = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f38067d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-461907176, "Lcom/baidu/apollon/utils/reflect/Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-461907176, "Lcom/baidu/apollon/utils/reflect/Utils;");
                return;
            }
        }
        f38064a = new Object[0];
        f38065b = new Class[0];
        f38067d = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
    }

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, objArr, objArr2)) == null) {
            if (objArr != null || objArr2 == null || objArr2.length <= 0) {
                if (objArr2 != null || objArr == null || objArr.length <= 0) {
                    return objArr == null || objArr2 == null || objArr.length == objArr2.length;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Object[] b(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, objArr)) == null) ? (objArr == null || objArr.length == 0) ? f38064a : objArr : (Object[]) invokeL.objValue;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            a(cls, linkedHashSet);
            return new ArrayList(linkedHashSet);
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMethodDeclaredThrowable(Method method, Throwable th) {
        InterceptResult invokeLL;
        Class<?>[] exceptionTypes;
        String name;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, method, th)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static boolean validateJavaIdentifier(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? f38067d.matcher(str).matches() : invokeL.booleanValue;
    }

    public static Class<?>[] a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            if (objArr.length == 0) {
                return f38065b;
            }
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public static Class<?>[] a(Class<?>[] clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, clsArr)) == null) ? (clsArr == null || clsArr.length == 0) ? f38065b : clsArr : (Class[]) invokeL.objValue;
    }

    public static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cls, hashSet) == null) {
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
}
