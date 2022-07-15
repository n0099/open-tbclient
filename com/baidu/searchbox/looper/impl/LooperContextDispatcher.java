package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bj9;
import com.repackage.jj9;
/* loaded from: classes2.dex */
public class LooperContextDispatcher extends bj9 {
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

    public void addLooperPrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, printer) == null) {
            LooperRuntime.getInstance().getLooperNeedContext().addLooperPrinter(printer);
        }
    }

    @Override // com.repackage.bj9
    public boolean displayNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LooperRuntime.getInstance().getLooperUIContext().displayNotification() : invokeV.booleanValue;
    }

    @Override // com.repackage.bj9, com.repackage.dj9
    public void onBlock(Context context, jj9 jj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jj9Var) == null) {
            super.onBlock(context, jj9Var);
            LooperRuntime.getInstance().dispatchBlock(context, jj9Var);
        }
    }

    public void removeLooperPrinter(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, printer) == null) {
            LooperRuntime.getInstance().getLooperNeedContext().removeLooperPrinter(printer);
        }
    }
}
