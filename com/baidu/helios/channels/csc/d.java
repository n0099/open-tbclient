package com.baidu.helios.channels.csc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.u30;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    public static Class<?> a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) {
            if (cls == Character.TYPE) {
                return Character.class;
            }
            if (cls == Boolean.TYPE) {
                return Boolean.class;
            }
            if (cls == Long.TYPE) {
                return Long.class;
            }
            if (cls == Integer.TYPE) {
                return Integer.class;
            }
            if (cls == Short.TYPE) {
                return Short.class;
            }
            if (cls == Byte.TYPE) {
                return Byte.class;
            }
            if (cls == Float.TYPE) {
                return Float.class;
            }
            if (cls == Double.TYPE) {
                return Double.class;
            }
            throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", cls));
        }
        return (Class) invokeL.objValue;
    }

    public static Object b(Class<?> cls, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, objArr)) == null) ? (objArr == null || objArr.length <= 0) ? cls.newInstance() : e(cls, objArr) : invokeLL.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? new String(new u30().a(bArr), "UTF-8") : (String) invokeL.objValue;
    }

    public static Method d(Class<?> cls, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object e(Class<?> cls, Object[] objArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, objArr)) == null) {
            Constructor<?> constructor = null;
            for (Constructor<?> constructor2 : cls.getConstructors()) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length >= objArr.length) {
                    int i = 0;
                    int i2 = 0;
                    while (i < objArr.length) {
                        Object obj = objArr[i];
                        while (obj != null && i2 < parameterTypes.length) {
                            Class<?> cls2 = parameterTypes[i2];
                            if (cls2.isPrimitive()) {
                                cls2 = a(cls2);
                            }
                            if (cls2.isInstance(obj)) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 == parameterTypes.length) {
                            break;
                        }
                        i2++;
                        i++;
                    }
                    if (i != objArr.length) {
                        continue;
                    } else if (constructor == null || parameterTypes.length < constructor.getParameterTypes().length) {
                        constructor = constructor2;
                    } else if (parameterTypes.length == constructor.getParameterTypes().length) {
                        throw new IllegalArgumentException("Multiple consturctors match parameters");
                    }
                }
            }
            if (constructor != null) {
                return constructor.newInstance(objArr);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
