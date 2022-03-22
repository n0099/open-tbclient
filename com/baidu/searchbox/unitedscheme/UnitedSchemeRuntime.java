package com.baidu.searchbox.unitedscheme;

import c.a.g0.a.b.b;
import c.a.g0.a.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UnitedSchemeRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public d<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public d<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public UnitedSchemeRuntime() {
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
        initsInterceptChainList();
        initsSubDispatchersList();
    }

    public void initsInterceptChainList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b b2 = b.b();
            this.sInterceptChainList = b2;
            b2.a(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
        }
    }

    public void initsSubDispatchersList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b b2 = b.b();
            this.sSubDispatchersList = b2;
            b2.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
        }
    }
}
