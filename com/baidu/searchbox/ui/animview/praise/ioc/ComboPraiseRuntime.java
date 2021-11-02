package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes7.dex */
public final class ComboPraiseRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ComboPraiseRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public static IComboPraiseContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new IComboPraiseContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public void doLogin(Context context, ILoginStatusListener iLoginStatusListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, iLoginStatusListener) == null) {
                }
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public boolean getPraiseSwitchState() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public boolean isLogin() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public boolean isPraiseLoginSupported() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public boolean isPraiseOptimized() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public void notifyPraiseAnimationEvent(Context context, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048581, this, context, str, str2) == null) {
                }
            }
        } : (IComboPraiseContext) invokeV.objValue;
    }
}
