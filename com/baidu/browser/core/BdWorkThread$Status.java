package com.baidu.browser.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class BdWorkThread$Status {
    public static final /* synthetic */ BdWorkThread$Status[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BdWorkThread$Status PENDING;
    public static final BdWorkThread$Status PROCESS;
    public static final BdWorkThread$Status RUNNING;
    public static final BdWorkThread$Status Status;
    public static final BdWorkThread$Status WAITING;
    public static final BdWorkThread$Status WORKING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1644946883, "Lcom/baidu/browser/core/BdWorkThread$Status;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1644946883, "Lcom/baidu/browser/core/BdWorkThread$Status;");
                return;
            }
        }
        PENDING = new BdWorkThread$Status("PENDING", 0);
        RUNNING = new BdWorkThread$Status(TornadoLiteRuntime.STATE_RUNNING, 1);
        WORKING = new BdWorkThread$Status("WORKING", 2);
        PROCESS = new BdWorkThread$Status("PROCESS", 3);
        WAITING = new BdWorkThread$Status("WAITING", 4);
        BdWorkThread$Status bdWorkThread$Status = new BdWorkThread$Status("Status", 5);
        Status = bdWorkThread$Status;
        $VALUES = new BdWorkThread$Status[]{PENDING, RUNNING, WORKING, PROCESS, WAITING, bdWorkThread$Status};
    }

    public BdWorkThread$Status(String str, int i2) {
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

    public static BdWorkThread$Status valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdWorkThread$Status) Enum.valueOf(BdWorkThread$Status.class, str) : (BdWorkThread$Status) invokeL.objValue;
    }

    public static BdWorkThread$Status[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdWorkThread$Status[]) $VALUES.clone() : (BdWorkThread$Status[]) invokeV.objValue;
    }
}
