package com.baidu.sofire.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
/* loaded from: classes4.dex */
public class PluginloaderDexClassLoader extends DexClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginloaderDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, classLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
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
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                }
            }
            if (z) {
                resolveClass(findLoadedClass);
            }
            if (findLoadedClass == null) {
                try {
                    return super.loadClass(str, z);
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                }
            }
            return findLoadedClass;
        }
        return (Class) invokeLZ.objValue;
    }

    public Class<?> loadClassWithoutParentClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass == null) {
                try {
                    return findClass(str);
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return findLoadedClass;
                }
            }
            return findLoadedClass;
        }
        return (Class) invokeL.objValue;
    }
}
