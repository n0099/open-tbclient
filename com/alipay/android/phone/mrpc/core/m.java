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

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f1658b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, callable, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Callable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1658b = lVar;
        this.f1657a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o a2 = this.f1657a.a();
            if (a2.f() == null) {
                super.done();
                return;
            }
            try {
                get();
                if (isCancelled() || a2.h()) {
                    a2.g();
                    if (isCancelled() && isDone()) {
                        return;
                    }
                    cancel(false);
                }
            } catch (InterruptedException e2) {
                new StringBuilder().append(e2);
            } catch (CancellationException unused) {
                a2.g();
            } catch (ExecutionException e3) {
                if (e3.getCause() == null || !(e3.getCause() instanceof HttpException)) {
                    new StringBuilder().append(e3);
                    return;
                }
                HttpException httpException = (HttpException) e3.getCause();
                httpException.getCode();
                httpException.getMsg();
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing http request", th);
            }
        }
    }
}
