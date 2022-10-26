package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qr9;
import com.baidu.tieba.yr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends qr9 {
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

    @Override // com.baidu.tieba.qr9
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

    @Override // com.baidu.tieba.qr9, com.baidu.tieba.sr9
    public void onBlock(Context context, yr9 yr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, yr9Var) == null) {
            super.onBlock(context, yr9Var);
            LooperRuntime.getInstance().dispatchBlock(context, yr9Var);
        }
    }
}
