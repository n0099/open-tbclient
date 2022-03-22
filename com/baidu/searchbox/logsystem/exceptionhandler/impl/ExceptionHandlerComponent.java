package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import c.a.g0.a.b.a;
import c.a.g0.a.b.c;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public c<IExceptionHandlerContext> exceptionHandlerContext;

    public ExceptionHandlerComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initexceptionHandlerContext();
    }

    public void initexceptionHandlerContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a b2 = a.b();
            this.exceptionHandlerContext = b2;
            b2.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
        }
    }
}
