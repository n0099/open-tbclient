package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class g implements AlipayResultActivity.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f2010a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f2011b;

    public g(e eVar, CountDownLatch countDownLatch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, countDownLatch};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2011b = eVar;
        this.f2010a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
            this.f2011b.f2008i = com.alipay.sdk.app.j.a(i2, str, str2);
            this.f2010a.countDown();
        }
    }
}
