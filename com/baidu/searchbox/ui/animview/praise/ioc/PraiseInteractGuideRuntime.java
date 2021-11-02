package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes7.dex */
public final class PraiseInteractGuideRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PraiseInteractGuideRuntime() {
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
    public static IPraiseInteractGuideContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new IPraiseInteractGuideContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.PraiseInteractGuideRuntime.1
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

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseInteractGuideContext
            public void guideLuckMoney(Context context, String str, String str2, String str3, ComboPraiseManager.NotifyPraiseAnimCallBack notifyPraiseAnimCallBack) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLLLL(1048576, this, context, str, str2, str3, notifyPraiseAnimCallBack) == null) {
                }
            }
        } : (IPraiseInteractGuideContext) invokeV.objValue;
    }
}
