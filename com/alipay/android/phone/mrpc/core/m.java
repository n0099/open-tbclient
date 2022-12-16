package com.alipay.android.phone.mrpc.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public final class m extends FutureTask<u> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q a;
    public final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, callable, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Callable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = lVar;
        this.a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o a = this.a.a();
            if (a.f() == null) {
                super.done();
                return;
            }
            try {
                get();
                if (isCancelled() || a.h()) {
                    a.g();
                    if (isCancelled() && isDone()) {
                        return;
                    }
                    cancel(false);
                }
            } catch (InterruptedException e) {
                new StringBuilder().append(e);
            } catch (CancellationException unused) {
                a.g();
            } catch (ExecutionException e2) {
                if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                    new StringBuilder().append(e2);
                    return;
                }
                HttpException httpException = (HttpException) e2.getCause();
                httpException.getCode();
                httpException.getMsg();
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing http request", th);
            }
        }
    }
}
