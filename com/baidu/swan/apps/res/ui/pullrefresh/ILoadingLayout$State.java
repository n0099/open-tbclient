package com.baidu.swan.apps.res.ui.pullrefresh;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ILoadingLayout$State {
    public static final /* synthetic */ ILoadingLayout$State[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    @Deprecated
    public static final ILoadingLayout$State LOADING;
    public static final ILoadingLayout$State LONG_REFRESHING;
    public static final ILoadingLayout$State NONE;
    public static final ILoadingLayout$State NO_MORE_DATA;
    public static final ILoadingLayout$State PULL_TO_REFRESH;
    public static final ILoadingLayout$State REFRESHING;
    public static final ILoadingLayout$State RELEASE_TO_LONG_REFRESH;
    public static final ILoadingLayout$State RELEASE_TO_REFRESH;
    public static final ILoadingLayout$State RESET;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1240369209, "Lcom/baidu/swan/apps/res/ui/pullrefresh/ILoadingLayout$State;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1240369209, "Lcom/baidu/swan/apps/res/ui/pullrefresh/ILoadingLayout$State;");
                return;
            }
        }
        NONE = new ILoadingLayout$State("NONE", 0);
        RESET = new ILoadingLayout$State("RESET", 1);
        PULL_TO_REFRESH = new ILoadingLayout$State("PULL_TO_REFRESH", 2);
        RELEASE_TO_REFRESH = new ILoadingLayout$State("RELEASE_TO_REFRESH", 3);
        REFRESHING = new ILoadingLayout$State("REFRESHING", 4);
        LOADING = new ILoadingLayout$State("LOADING", 5);
        NO_MORE_DATA = new ILoadingLayout$State("NO_MORE_DATA", 6);
        RELEASE_TO_LONG_REFRESH = new ILoadingLayout$State("RELEASE_TO_LONG_REFRESH", 7);
        ILoadingLayout$State iLoadingLayout$State = new ILoadingLayout$State("LONG_REFRESHING", 8);
        LONG_REFRESHING = iLoadingLayout$State;
        $VALUES = new ILoadingLayout$State[]{NONE, RESET, PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, LOADING, NO_MORE_DATA, RELEASE_TO_LONG_REFRESH, iLoadingLayout$State};
    }

    public ILoadingLayout$State(String str, int i2) {
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

    public static ILoadingLayout$State valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ILoadingLayout$State) Enum.valueOf(ILoadingLayout$State.class, str) : (ILoadingLayout$State) invokeL.objValue;
    }

    public static ILoadingLayout$State[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ILoadingLayout$State[]) $VALUES.clone() : (ILoadingLayout$State[]) invokeV.objValue;
    }
}
