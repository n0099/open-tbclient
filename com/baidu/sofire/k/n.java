package com.baidu.sofire.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
/* loaded from: classes4.dex */
public final class n implements IIdentifierListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String[] a;
    public final /* synthetic */ boolean[] b;

    public n(String[] strArr, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, zArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = strArr;
        this.b = zArr;
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void onSupport(IdSupplier idSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
            if (idSupplier.isSupported()) {
                this.a[0] = idSupplier.getOAID();
            }
            this.b[0] = true;
            Object obj = o.a;
            synchronized (o.b) {
                o.b.notifyAll();
            }
        }
    }
}
