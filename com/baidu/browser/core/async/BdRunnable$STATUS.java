package com.baidu.browser.core.async;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class BdRunnable$STATUS {
    public static final /* synthetic */ BdRunnable$STATUS[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BdRunnable$STATUS COMPLETE;
    public static final BdRunnable$STATUS FAIL;
    public static final BdRunnable$STATUS INITED;
    public static final BdRunnable$STATUS QUEUED;
    public static final BdRunnable$STATUS RUNNING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1985849230, "Lcom/baidu/browser/core/async/BdRunnable$STATUS;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1985849230, "Lcom/baidu/browser/core/async/BdRunnable$STATUS;");
                return;
            }
        }
        INITED = new BdRunnable$STATUS("INITED", 0);
        QUEUED = new BdRunnable$STATUS("QUEUED", 1);
        RUNNING = new BdRunnable$STATUS("RUNNING", 2);
        FAIL = new BdRunnable$STATUS("FAIL", 3);
        BdRunnable$STATUS bdRunnable$STATUS = new BdRunnable$STATUS("COMPLETE", 4);
        COMPLETE = bdRunnable$STATUS;
        $VALUES = new BdRunnable$STATUS[]{INITED, QUEUED, RUNNING, FAIL, bdRunnable$STATUS};
    }

    public BdRunnable$STATUS(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BdRunnable$STATUS valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdRunnable$STATUS) Enum.valueOf(BdRunnable$STATUS.class, str) : (BdRunnable$STATUS) invokeL.objValue;
    }

    public static BdRunnable$STATUS[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdRunnable$STATUS[]) $VALUES.clone() : (BdRunnable$STATUS[]) invokeV.objValue;
    }
}
