package com.alipay.sdk.app;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1799a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1800b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f1801c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PayTask f1802d;

    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payTask, str, Boolean.valueOf(z), h5PayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1802d = payTask;
        this.f1799a = str;
        this.f1800b = z;
        this.f1801c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1801c.onPayResult(this.f1802d.h5Pay(this.f1799a, this.f1800b));
        }
    }
}
