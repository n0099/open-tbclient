package com.baidu.live.arch.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MiniUniqueId {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_ID = 1000000;
    public static volatile int sBaseId;
    public transient /* synthetic */ FieldHolder $fh;
    public int mId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-440773226, "Lcom/baidu/live/arch/utils/MiniUniqueId;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-440773226, "Lcom/baidu/live/arch/utils/MiniUniqueId;");
        }
    }

    public MiniUniqueId() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mId = 0;
    }

    public static synchronized MiniUniqueId gen() {
        InterceptResult invokeV;
        MiniUniqueId miniUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (MiniUniqueId.class) {
                if (sBaseId < 1000000) {
                    sBaseId = 1000000;
                }
                miniUniqueId = new MiniUniqueId();
                miniUniqueId.mId = sBaseId;
                sBaseId++;
            }
            return miniUniqueId;
        }
        return (MiniUniqueId) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mId : invokeV.intValue;
    }
}
