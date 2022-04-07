package com.baidu.adp.widget.refresh;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class IRefreshable$State {
    public static final /* synthetic */ IRefreshable$State[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final IRefreshable$State animating;
    public static final IRefreshable$State idle;
    public static final IRefreshable$State pulling_no_refresh;
    public static final IRefreshable$State pulling_refresh;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2090621331, "Lcom/baidu/adp/widget/refresh/IRefreshable$State;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2090621331, "Lcom/baidu/adp/widget/refresh/IRefreshable$State;");
                return;
            }
        }
        idle = new IRefreshable$State("idle", 0);
        pulling_no_refresh = new IRefreshable$State("pulling_no_refresh", 1);
        animating = new IRefreshable$State("animating", 2);
        IRefreshable$State iRefreshable$State = new IRefreshable$State("pulling_refresh", 3);
        pulling_refresh = iRefreshable$State;
        $VALUES = new IRefreshable$State[]{idle, pulling_no_refresh, animating, iRefreshable$State};
    }

    public IRefreshable$State(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static IRefreshable$State valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IRefreshable$State) Enum.valueOf(IRefreshable$State.class, str) : (IRefreshable$State) invokeL.objValue;
    }

    public static IRefreshable$State[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IRefreshable$State[]) $VALUES.clone() : (IRefreshable$State[]) invokeV.objValue;
    }
}
