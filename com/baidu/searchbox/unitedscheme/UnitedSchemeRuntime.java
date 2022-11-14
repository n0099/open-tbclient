package com.baidu.searchbox.unitedscheme;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider;
import com.baidu.tieba.lf1;
import com.baidu.tieba.nf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class UnitedSchemeRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public nf1<UnitedSchemeBaseInterceptor> sInterceptChainList;
    @Inject(force = false)
    public nf1<UnitedSchemeBaseDispatcher> sSubDispatchersList;

    public void initsInterceptChainList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            lf1 b = lf1.b();
            this.sInterceptChainList = b;
            b.a(new UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider());
        }
    }

    public void initsSubDispatchersList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lf1 b = lf1.b();
            this.sSubDispatchersList = b;
            b.a(new UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider());
        }
    }

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
}
