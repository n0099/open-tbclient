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
/* loaded from: classes4.dex */
public final class y implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final w f32196e;

    /* renamed from: f  reason: collision with root package name */
    public final c.d.b.e0.i.j f32197f;

    /* renamed from: g  reason: collision with root package name */
    public final AsyncTimeout f32198g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public p f32199h;

    /* renamed from: i  reason: collision with root package name */
    public final z f32200i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f32201j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f32202a;

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
            this.f32202a = yVar;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32202a.cancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final f f32203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ y f32204g;

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
            super("OkHttp %s", yVar.h());
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
            this.f32204g = yVar;
            this.f32203f = fVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Throwable th;
            boolean z;
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32204g.f32198g.enter();
                try {
                    try {
                        z = true;
                        try {
                            this.f32203f.b(this.f32204g, this.f32204g.f());
                        } catch (IOException e3) {
                            e2 = e3;
                            IOException i2 = this.f32204g.i(e2);
                            if (!z) {
                                this.f32204g.f32199h.callFailed(this.f32204g, i2);
                                this.f32203f.a(this.f32204g, i2);
                            } else {
                                c.d.b.e0.m.g m = c.d.b.e0.m.g.m();
                                m.u(4, "Callback failure for " + this.f32204g.j(), i2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this.f32204g.cancel();
                            if (!z) {
                                this.f32203f.a(this.f32204g, new IOException("canceled due to " + th));
                            }
                            throw th;
                        }
                    } finally {
                        this.f32204g.f32196e.k().d(this);
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
                        this.f32204g.f32199h.callFailed(this.f32204g, interruptedIOException);
                        this.f32203f.a(this.f32204g, interruptedIOException);
                        this.f32204g.f32196e.k().d(this);
                    }
                } catch (Throwable th) {
                    this.f32204g.f32196e.k().d(this);
                    throw th;
                }
            }
        }

        public y f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32204g : (y) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32204g.f32200i.h().l() : (String) invokeV.objValue;
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
        this.f32196e = wVar;
        this.f32200i = zVar;
        this.f32201j = z;
        this.f32197f = new c.d.b.e0.i.j(wVar, z);
        a aVar = new a(this);
        this.f32198g = aVar;
        aVar.timeout(wVar.e(), TimeUnit.MILLISECONDS);
    }

    public static y g(w wVar, z zVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, wVar, zVar, z)) == null) {
            y yVar = new y(wVar, zVar, z);
            yVar.f32199h = wVar.m().create(yVar);
            return yVar;
        }
        return (y) invokeLLZ.objValue;
    }

    @Override // c.d.b.e
    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.k = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            d();
            this.f32199h.callStart(this);
            this.f32196e.k().a(new b(this, fVar));
        }
    }

    @Override // c.d.b.e
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32197f.b();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f32197f.k(c.d.b.e0.m.g.m().q("response.body().close()"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public y clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g(this.f32196e, this.f32200i, this.f32201j) : (y) invokeV.objValue;
    }

    @Override // c.d.b.e
    public b0 execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.k = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            d();
            this.f32198g.enter();
            this.f32199h.callStart(this);
            try {
                try {
                    this.f32196e.k().b(this);
                    b0 f2 = f();
                    if (f2 != null) {
                        return f2;
                    }
                    throw new IOException(ResponseException.CANCELED);
                } catch (IOException e2) {
                    IOException i2 = i(e2);
                    this.f32199h.callFailed(this, i2);
                    throw i2;
                }
            } finally {
                this.f32196e.k().e(this);
            }
        }
        return (b0) invokeV.objValue;
    }

    public b0 f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f32196e.r());
            arrayList.add(this.f32197f);
            arrayList.add(new c.d.b.e0.i.a(this.f32196e.j()));
            arrayList.add(new c.d.b.e0.g.a(this.f32196e.s()));
            arrayList.add(new c.d.b.e0.h.a(this.f32196e));
            if (!this.f32201j) {
                arrayList.addAll(this.f32196e.u());
            }
            arrayList.add(new c.d.b.e0.i.b(this.f32201j));
            b0 a2 = new c.d.b.e0.i.g(arrayList, null, null, null, 0, this.f32200i, this, this.f32199h, this.f32196e.g(), this.f32196e.D(), this.f32196e.H()).a(this.f32200i);
            if (this.f32197f.e()) {
                c.d.b.e0.e.f(a2);
                throw new IOException(ResponseException.CANCELED);
            }
            return a2;
        }
        return (b0) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32200i.h().z() : (String) invokeV.objValue;
    }

    @Nullable
    public IOException i(@Nullable IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOException)) == null) {
            if (this.f32198g.exit()) {
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

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32197f.e() : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(isCanceled() ? "canceled " : "");
            sb.append(this.f32201j ? "web socket" : NotificationCompat.CATEGORY_CALL);
            sb.append(" to ");
            sb.append(h());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.d.b.e
    public z request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f32200i : (z) invokeV.objValue;
    }
}
