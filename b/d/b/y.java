package b.d.b;

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
/* loaded from: classes6.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final w f30593e;

    /* renamed from: f  reason: collision with root package name */
    public final b.d.b.e0.i.j f30594f;

    /* renamed from: g  reason: collision with root package name */
    public final AsyncTimeout f30595g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public p f30596h;

    /* renamed from: i  reason: collision with root package name */
    public final z f30597i;
    public final boolean j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f30598a;

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
            this.f30598a = yVar;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30598a.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends b.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final f f30599f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ y f30600g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-455738859, "Lb/d/b/y$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-455738859, "Lb/d/b/y$b;");
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
            this.f30600g = yVar;
            this.f30599f = fVar;
        }

        @Override // b.d.b.e0.c
        public void d() {
            Throwable th;
            boolean z;
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30600g.f30595g.enter();
                try {
                    try {
                        z = true;
                        try {
                            this.f30599f.b(this.f30600g, this.f30600g.e());
                        } catch (IOException e3) {
                            e2 = e3;
                            IOException h2 = this.f30600g.h(e2);
                            if (!z) {
                                this.f30600g.f30596h.callFailed(this.f30600g, h2);
                                this.f30599f.a(this.f30600g, h2);
                            } else {
                                b.d.b.e0.n.g m = b.d.b.e0.n.g.m();
                                m.u(4, "Callback failure for " + this.f30600g.i(), h2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this.f30600g.cancel();
                            if (!z) {
                                this.f30599f.a(this.f30600g, new IOException("canceled due to " + th));
                            }
                            throw th;
                        }
                    } finally {
                        this.f30600g.f30593e.i().d(this);
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
                        this.f30600g.f30596h.callFailed(this.f30600g, interruptedIOException);
                        this.f30599f.a(this.f30600g, interruptedIOException);
                        this.f30600g.f30593e.i().d(this);
                    }
                } catch (Throwable th) {
                    this.f30600g.f30593e.i().d(this);
                    throw th;
                }
            }
        }

        public y f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30600g : (y) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30600g.f30597i.h().l() : (String) invokeV.objValue;
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
        this.f30593e = wVar;
        this.f30597i = zVar;
        this.j = z;
        this.f30594f = new b.d.b.e0.i.j(wVar, z);
        a aVar = new a(this);
        this.f30595g = aVar;
        aVar.timeout(wVar.b(), TimeUnit.MILLISECONDS);
    }

    public static y f(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f30596h = wVar.k().create(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30594f.k(b.d.b.e0.n.g.m().q("response.body().close()"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f(this.f30593e, this.f30597i, this.j) : (y) invokeV.objValue;
    }

    @Override // b.d.b.e
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30594f.b();
        }
    }

    @Override // b.d.b.e
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
            this.f30596h.callStart(this);
            this.f30593e.i().a(new b(this, fVar));
        }
    }

    public b0 e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f30593e.p());
            arrayList.add(this.f30594f);
            arrayList.add(new b.d.b.e0.i.a(this.f30593e.h()));
            arrayList.add(new b.d.b.e0.g.a(this.f30593e.q()));
            arrayList.add(new b.d.b.e0.h.a(this.f30593e));
            if (!this.j) {
                arrayList.addAll(this.f30593e.s());
            }
            arrayList.add(new b.d.b.e0.i.b(this.j));
            b0 a2 = new b.d.b.e0.i.g(arrayList, null, null, null, 0, this.f30597i, this, this.f30596h, this.f30593e.e(), this.f30593e.B(), this.f30593e.F()).a(this.f30597i);
            if (this.f30594f.e()) {
                b.d.b.e0.e.f(a2);
                throw new IOException(ResponseException.CANCELED);
            }
            return a2;
        }
        return (b0) invokeV.objValue;
    }

    @Override // b.d.b.e
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
            this.f30595g.enter();
            this.f30596h.callStart(this);
            try {
                try {
                    this.f30593e.i().b(this);
                    b0 e2 = e();
                    if (e2 != null) {
                        return e2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e3) {
                    IOException h2 = h(e3);
                    this.f30596h.callFailed(this, h2);
                    throw h2;
                }
            } finally {
                this.f30593e.i().e(this);
            }
        }
        return (b0) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30597i.h().y() : (String) invokeV.objValue;
    }

    @Nullable
    public IOException h(@Nullable IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOException)) == null) {
            if (this.f30595g.exit()) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
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
            sb.append(this.j ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(g());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30594f.e() : invokeV.booleanValue;
    }

    @Override // b.d.b.e
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30597i : (z) invokeV.objValue;
    }
}
