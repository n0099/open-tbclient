package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ Future a;
    public /* synthetic */ int b;
    public /* synthetic */ r c;
    public /* synthetic */ String d;
    public /* synthetic */ Context e;
    public /* synthetic */ PreCodeListener f;
    public /* synthetic */ a g;

    public e(a aVar, Future future, int i, r rVar, String str, Context context, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, future, Integer.valueOf(i), rVar, str, context, preCodeListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = aVar;
        this.a = future;
        this.b = i;
        this.c = rVar;
        this.d = str;
        this.e = context;
        this.f = preCodeListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Context context;
        String str2;
        PreCodeListener preCodeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.a.get(this.b, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                try {
                    this.c.a(true);
                    String str3 = "{\"result\":80000,\"msg\":\"请求超时\"}";
                    if (th instanceof TimeoutException) {
                        cn.com.chinatelecom.gateway.lib.b.d.a(this.d, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                        cn.com.chinatelecom.gateway.lib.b.d.a(this.d).h("submitOnTimeoutInterrupted()");
                        context = this.e;
                        str2 = this.d;
                        preCodeListener = this.f;
                    } else {
                        cn.com.chinatelecom.gateway.lib.b.d.a(this.d, "{\"result\":80001,\"msg\":\"请求异常\"}", "");
                        cn.com.chinatelecom.gateway.lib.b.a a = cn.com.chinatelecom.gateway.lib.b.d.a(this.d);
                        a.h("submitOnTimeoutInterrupted other exception : " + th.getMessage());
                        str = a.a;
                        CtAuth.warn(str, "submitOnTimeoutInterrupted other exception", th);
                        context = this.e;
                        str2 = this.d;
                        preCodeListener = this.f;
                        str3 = "{\"result\":80001,\"msg\":\"请求异常\"}";
                    }
                    CtAuth.postResult(context, str3, str2, preCodeListener);
                    Future future = this.a;
                    if (future == null || future.isDone()) {
                        return;
                    }
                } finally {
                    Future future2 = this.a;
                    if (future2 != null && !future2.isDone()) {
                        this.a.cancel(true);
                    }
                }
            }
        }
    }
}
