package com.baidu.sofire.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
/* loaded from: classes6.dex */
public final class e extends DexClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, classLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    return findClass(str);
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    return findLoadedClass;
                }
            }
            return findLoadedClass;
        }
        return (Class) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    findLoadedClass = findClass(str);
                } catch (Throwable unused) {
                }
                if (findLoadedClass == null) {
                    try {
                        if (getParent() != null) {
                            findLoadedClass = getParent().loadClass(str);
                        } else {
                            findLoadedClass = (Class) getClass().getDeclaredMethod("findBootstrapClassOrNull", String.class).invoke(this, str);
                        }
                    } catch (Throwable unused2) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
            }
            if (z) {
                resolveClass(findLoadedClass);
            }
            if (findLoadedClass == null) {
                try {
                    return super.loadClass(str, z);
                } catch (Throwable unused3) {
                    com.baidu.sofire.utility.c.a();
                }
            }
            return findLoadedClass;
        }
        return (Class) invokeLZ.objValue;
    }
}
