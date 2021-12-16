package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class RegisterIntentConfigHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final RegisterIntentConfigHelper inst;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Class<?>, Class<?>> mActicyConfig;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502380820, "Lcom/baidu/tbadk/core/util/RegisterIntentConfigHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502380820, "Lcom/baidu/tbadk/core/util/RegisterIntentConfigHelper;");
                return;
            }
        }
        inst = new RegisterIntentConfigHelper();
    }

    public RegisterIntentConfigHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActicyConfig = new HashMap<>();
    }

    public static final RegisterIntentConfigHelper getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? inst : (RegisterIntentConfigHelper) invokeV.objValue;
    }

    public void RegisterIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
            if (!this.mActicyConfig.containsKey(cls)) {
                logStaticRegister(cls, cls2);
                this.mActicyConfig.put(cls, cls2);
                return;
            }
            BdLog.e("register Intent failed, " + cls.getName() + " exist");
        }
    }

    public void RegisterOrUpdateIntent(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2) == null) {
            logStaticRegister(cls, cls2);
            this.mActicyConfig.put(cls, cls2);
        }
    }

    public boolean appResponseToIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? getIntentClass(cls) != null : invokeL.booleanValue;
    }

    public int getConfigSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActicyConfig.size() : invokeV.intValue;
    }

    public Class<?> getIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            HashMap<Class<?>, Class<?>> hashMap = this.mActicyConfig;
            if (hashMap != null) {
                return hashMap.get(cls);
            }
            return null;
        }
        return (Class) invokeL.objValue;
    }

    public void logStaticRegister(Class<?> cls, Class<?> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, cls, cls2) == null) {
        }
    }
}
