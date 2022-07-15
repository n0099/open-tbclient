package com.baidu.searchbox.network.outback;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ob1;
import com.repackage.qb1;
/* loaded from: classes2.dex */
public class OutbackComponentHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public qb1<IOutbackContext> outbackContextHolder;

    public OutbackComponentHolder() {
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
        initoutbackContextHolder();
    }

    public void initoutbackContextHolder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ob1 b = ob1.b();
            this.outbackContextHolder = b;
            b.a(new IOutbackContext_OutbackComponentHolder_Provider());
        }
    }
}
