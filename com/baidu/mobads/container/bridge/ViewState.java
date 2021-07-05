package com.baidu.mobads.container.bridge;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ViewState {
    public static final /* synthetic */ ViewState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ViewState DEFAULT;
    public static final ViewState EXPANDED;
    public static final ViewState HIDDEN;
    public static final ViewState LOADING;
    public static final ViewState RESIZED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-208894762, "Lcom/baidu/mobads/container/bridge/ViewState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-208894762, "Lcom/baidu/mobads/container/bridge/ViewState;");
                return;
            }
        }
        LOADING = new ViewState("LOADING", 0);
        DEFAULT = new ViewState("DEFAULT", 1);
        RESIZED = new ViewState("RESIZED", 2);
        EXPANDED = new ViewState("EXPANDED", 3);
        ViewState viewState = new ViewState("HIDDEN", 4);
        HIDDEN = viewState;
        $VALUES = new ViewState[]{LOADING, DEFAULT, RESIZED, EXPANDED, viewState};
    }

    public ViewState(String str, int i2) {
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

    public static ViewState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ViewState) Enum.valueOf(ViewState.class, str) : (ViewState) invokeL.objValue;
    }

    public static ViewState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ViewState[]) $VALUES.clone() : (ViewState[]) invokeV.objValue;
    }

    public String toJavascriptString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? toString().toLowerCase(Locale.US) : (String) invokeV.objValue;
    }
}
