package com.baidu.searchbox.ubcprocessor;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pa1;
import com.repackage.ra1;
/* loaded from: classes2.dex */
public class UBCCloudConfigObservers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public ra1<UBCCloudConfigObserver> mObservers;

    public UBCCloudConfigObservers() {
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
        initmObservers();
    }

    public void initmObservers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pa1 b = pa1.b();
            this.mObservers = b;
            b.a(new UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider());
        }
    }
}
