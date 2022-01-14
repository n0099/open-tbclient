package c.d.b;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okio.AsyncTimeout;
/* loaded from: classes9.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final w f28023e;

    /* renamed from: f  reason: collision with root package name */
    public final c.d.b.e0.i.j f28024f;

    /* renamed from: g  reason: collision with root package name */
    public final AsyncTimeout f28025g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public p f28026h;

    /* renamed from: i  reason: collision with root package name */
    public final z f28027i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f28028j;
    public boolean k;

    /* loaded from: classes9.dex */
    public class a extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y a;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yVar;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class b extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final f f28029f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ y f28030g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-652252364, "Lc/d/b/y$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-652252364, "Lc/d/b/y$b;");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y yVar, f fVar) {
            super("OkHttp %s", yVar.g());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, fVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28030g = yVar;
            this.f28029f = fVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Throwable th;
            boolean z;
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28030g.f28025g.enter();
                try {
                    try {
                        z = true;
                        try {
                            this.f28029f.b(this.f28030g, this.f28030g.e());
                        } catch (IOException e3) {
                            e2 = e3;
                            IOException h2 = this.f28030g.h(e2);
                            if (!z) {
                                this.f28030g.f28026h.callFailed(this.f28030g, h2);
                                this.f28029f.a(this.f28030g, h2);
                            } else {
                                c.d.b.e0.n.g m = c.d.b.e0.n.g.m();
                                m.u(4, "Callback failure for " + this.f28030g.i(), h2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this.f28030g.cancel();
                            if (!z) {
                                this.f28029f.a(this.f28030g, new IOException("canceled due to " + th));
                            }
                            throw th;
                        }
                    } finally {
                        this.f28030g.f28023e.i().d(this);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    z = false;
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                }
            }
        }

        public void e(ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executorService) == null) {
                try {
                    try {
                        executorService.execute(this);
                    } catch (RejectedExecutionException e2) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e2);
                        this.f28030g.f28026h.callFailed(this.f28030g, interruptedIOException);
                        this.f28029f.a(this.f28030g, interruptedIOException);
                        this.f28030g.f28023e.i().d(this);
                    }
                } catch (Throwable th) {
                    this.f28030g.f28023e.i().d(this);
                    throw th;
                }
            }
        }

        public y f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28030g : (y) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28030g.f28027i.h().l() : (String) invokeV.objValue;
        }
    }

    public y(w wVar, z zVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, zVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28023e = wVar;
        this.f28027i = zVar;
        this.f28028j = z;
        this.f28024f = new c.d.b.e0.i.j(wVar, z);
        a aVar = new a(this);
        this.f28025g = aVar;
        aVar.timeout(wVar.b(), TimeUnit.MILLISECONDS);
    }

    public static y f(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f28026h = wVar.k().create(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28024f.k(c.d.b.e0.n.g.m().q("response.body().close()"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f(this.f28023e, this.f28027i, this.f28028j) : (y) invokeV.objValue;
    }

    @Override // c.d.b.e
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28024f.b();
        }
    }

    @Override // c.d.b.e
    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.k = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            b();
            this.f28026h.callStart(this);
            this.f28023e.i().a(new b(this, fVar));
        }
    }

    public b0 e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f28023e.p());
            arrayList.add(this.f28024f);
            arrayList.add(new c.d.b.e0.i.a(this.f28023e.h()));
            arrayList.add(new c.d.b.e0.g.a(this.f28023e.q()));
            arrayList.add(new c.d.b.e0.h.a(this.f28023e));
            if (!this.f28028j) {
                arrayList.addAll(this.f28023e.s());
            }
            arrayList.add(new c.d.b.e0.i.b(this.f28028j));
            b0 a2 = new c.d.b.e0.i.g(arrayList, null, null, null, 0, this.f28027i, this, this.f28026h, this.f28023e.e(), this.f28023e.B(), this.f28023e.F()).a(this.f28027i);
            if (this.f28024f.e()) {
                c.d.b.e0.e.f(a2);
                throw new IOException(ResponseException.CANCELED);
            }
            return a2;
        }
        return (b0) invokeV.objValue;
    }

    @Override // c.d.b.e
    public b0 execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.k = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            b();
            this.f28025g.enter();
            this.f28026h.callStart(this);
            try {
                try {
                    this.f28023e.i().b(this);
                    b0 e2 = e();
                    if (e2 != null) {
                        return e2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e3) {
                    IOException h2 = h(e3);
                    this.f28026h.callFailed(this, h2);
                    throw h2;
                }
            } finally {
                this.f28023e.i().e(this);
            }
        }
        return (b0) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28027i.h().y() : (String) invokeV.objValue;
    }

    @Nullable
    public IOException h(@Nullable IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOException)) == null) {
            if (this.f28025g.exit()) {
                InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.O);
                if (iOException != null) {
                    interruptedIOException.initCause(iOException);
                }
                return interruptedIOException;
            }
            return iOException;
        }
        return (IOException) invokeL.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(isCanceled() ? "canceled " : "");
            sb.append(this.f28028j ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(g());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28024f.e() : invokeV.booleanValue;
    }

    @Override // c.d.b.e
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28027i : (z) invokeV.objValue;
    }
}
