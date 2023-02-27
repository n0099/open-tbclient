package com.baidu.sofire.b;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.core.CallArgs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes3.dex */
public final class f extends Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ CallArgs b;
    public final /* synthetic */ CountDownLatch c;

    public f(Bundle bundle, CallArgs callArgs, CountDownLatch countDownLatch, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle, callArgs, countDownLatch, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bundle;
        this.b = callArgs;
        this.c = countDownLatch;
    }

    @Override // com.baidu.sofire.ac.Callback
    public Object onEnd(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            try {
                try {
                    this.a.putInt("status", 0);
                    this.b.f = objArr[0];
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                this.c.countDown();
                return null;
            } catch (Throwable th) {
                this.c.countDown();
                throw th;
            }
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.Callback
    public Object onError(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
            try {
                try {
                    this.a.putInt("status", ((Integer) objArr[0]).intValue());
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                this.c.countDown();
                return null;
            } catch (Throwable th) {
                this.c.countDown();
                throw th;
            }
        }
        return invokeL.objValue;
    }
}
