package com.baidu.http.engine.urlconnect.connect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class CronetDelegator$AppState {
    public static final /* synthetic */ CronetDelegator$AppState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CronetDelegator$AppState APP_STATE_BACKGROUND;
    public static final CronetDelegator$AppState APP_STATE_FOREGROUND;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-44111928, "Lcom/baidu/http/engine/urlconnect/connect/CronetDelegator$AppState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-44111928, "Lcom/baidu/http/engine/urlconnect/connect/CronetDelegator$AppState;");
                return;
            }
        }
        APP_STATE_BACKGROUND = new CronetDelegator$AppState("APP_STATE_BACKGROUND", 0);
        CronetDelegator$AppState cronetDelegator$AppState = new CronetDelegator$AppState("APP_STATE_FOREGROUND", 1);
        APP_STATE_FOREGROUND = cronetDelegator$AppState;
        $VALUES = new CronetDelegator$AppState[]{APP_STATE_BACKGROUND, cronetDelegator$AppState};
    }

    public CronetDelegator$AppState(String str, int i) {
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

    public static CronetDelegator$AppState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (CronetDelegator$AppState) Enum.valueOf(CronetDelegator$AppState.class, str);
        }
        return (CronetDelegator$AppState) invokeL.objValue;
    }

    public static CronetDelegator$AppState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (CronetDelegator$AppState[]) $VALUES.clone();
        }
        return (CronetDelegator$AppState[]) invokeV.objValue;
    }
}
