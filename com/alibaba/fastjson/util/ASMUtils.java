package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.asm.ClassReader;
import com.alibaba.fastjson.asm.TypeCollector;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class ASMUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean IS_ANDROID;
    public static final String JAVA_VM_NAME;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1936133686, "Lcom/alibaba/fastjson/util/ASMUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1936133686, "Lcom/alibaba/fastjson/util/ASMUtils;");
                return;
            }
        }
        String property = System.getProperty("java.vm.name");
        JAVA_VM_NAME = property;
        IS_ANDROID = isAndroid(property);
    }

    public ASMUtils() {
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

    public static boolean checkName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt < 1 || charAt > 127 || charAt == '.') {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String desc(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, method)) == null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder sb = new StringBuilder((parameterTypes.length + 1) << 4);
            sb.append('(');
            for (Class<?> cls : parameterTypes) {
                sb.append(desc(cls));
            }
            sb.append(')');
            sb.append(desc(method.getReturnType()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Type getMethodType(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, cls, str)) == null) {
            try {
                return cls.getMethod(str, new Class[0]).getGenericReturnType();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Type) invokeLL.objValue;
    }

    public static String getPrimitiveLetter(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) {
            if (Integer.TYPE == cls) {
                return "I";
            }
            if (Void.TYPE == cls) {
                return "V";
            }
            if (Boolean.TYPE == cls) {
                return "Z";
            }
            if (Character.TYPE == cls) {
                return "C";
            }
            if (Byte.TYPE == cls) {
                return "B";
            }
            if (Short.TYPE == cls) {
                return "S";
            }
            if (Float.TYPE == cls) {
                return "F";
            }
            if (Long.TYPE == cls) {
                return "J";
            }
            if (Double.TYPE == cls) {
                return "D";
            }
            throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
        }
        return (String) invokeL.objValue;
    }

    public static boolean isAndroid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            return lowerCase.contains("dalvik") || lowerCase.contains("lemur");
        }
        return invokeL.booleanValue;
    }

    public static String[] lookupParameterNames(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        Annotation[][] parameterAnnotations;
        String str;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, accessibleObject)) == null) {
            if (IS_ANDROID) {
                return new String[0];
            }
            if (accessibleObject instanceof Method) {
                Method method = (Method) accessibleObject;
                parameterTypes = method.getParameterTypes();
                str = method.getName();
                declaringClass = method.getDeclaringClass();
                parameterAnnotations = TypeUtils.getParameterAnnotations(method);
            } else {
                Constructor constructor = (Constructor) accessibleObject;
                parameterTypes = constructor.getParameterTypes();
                declaringClass = constructor.getDeclaringClass();
                parameterAnnotations = TypeUtils.getParameterAnnotations(constructor);
                str = "<init>";
            }
            if (parameterTypes.length == 0) {
                return new String[0];
            }
            ClassLoader classLoader = declaringClass.getClassLoader();
            if (classLoader == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
            String name2 = declaringClass.getName();
            InputStream resourceAsStream = classLoader.getResourceAsStream(name2.replace(IStringUtil.EXTENSION_SEPARATOR, '/') + ".class");
            if (resourceAsStream == null) {
                return new String[0];
            }
            try {
                ClassReader classReader = new ClassReader(resourceAsStream, false);
                TypeCollector typeCollector = new TypeCollector(str, parameterTypes);
                classReader.accept(typeCollector);
                String[] parameterNamesForMethod = typeCollector.getParameterNamesForMethod();
                for (int i2 = 0; i2 < parameterNamesForMethod.length; i2++) {
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    if (annotationArr != null) {
                        for (int i3 = 0; i3 < annotationArr.length; i3++) {
                            if ((annotationArr[i3] instanceof JSONField) && (name = ((JSONField) annotationArr[i3]).name()) != null && name.length() > 0) {
                                parameterNamesForMethod[i2] = name;
                            }
                        }
                    }
                }
                return parameterNamesForMethod;
            } catch (IOException unused) {
                return new String[0];
            } finally {
                IOUtils.close(resourceAsStream);
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static String type(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            if (cls.isArray()) {
                return PreferencesUtil.LEFT_MOUNT + desc(cls.getComponentType());
            } else if (!cls.isPrimitive()) {
                return cls.getName().replace(IStringUtil.EXTENSION_SEPARATOR, '/');
            } else {
                return getPrimitiveLetter(cls);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String desc(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            if (cls.isPrimitive()) {
                return getPrimitiveLetter(cls);
            }
            if (cls.isArray()) {
                return PreferencesUtil.LEFT_MOUNT + desc(cls.getComponentType());
            }
            return "L" + type(cls) + ";";
        }
        return (String) invokeL.objValue;
    }
}
