package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m6a;
import com.baidu.tieba.u6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LooperContextDispatcher extends m6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LooperContextDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.m6a
    public boolean displayNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LooperRuntime.getInstance().getLooperUIContext().displayNotification();
        }
        return invokeV.booleanValue;
    }

    public void addLooperPrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, printer) == null) {
            LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
        }
    }

    public void removeLooperPrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, printer) == null) {
            LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
        }
    }

    @Override // com.baidu.tieba.m6a, com.baidu.tieba.o6a
    public void onBlock(Context context, u6a u6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, u6aVar) == null) {
            super.onBlock(context, u6aVar);
            LooperRuntime.getInstance().dispatchBlock(context, u6aVar);
        }
    }
}
