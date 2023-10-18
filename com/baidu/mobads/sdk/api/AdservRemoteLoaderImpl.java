package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.mobads.sdk.internal.d;
import com.baidu.mobads.sdk.internal.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
@Route(path = c.a.a)
/* loaded from: classes3.dex */
public class AdservRemoteLoaderImpl implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AdservRemoteLoaderImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.sdk.internal.r
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, classLoader)) == null) {
            return d.a().a(str, str2, str3, classLoader);
        }
        return (DexClassLoader) invokeLLLL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.r
    public void startLoadRemotePhp(double d, am.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), bVar}) == null) {
            d.a().a(d, bVar);
        }
    }
}
