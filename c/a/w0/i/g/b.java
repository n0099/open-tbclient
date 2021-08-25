package c.a.w0.i.g;

import c.a.w0.i.e;
import c.a.w0.l.d.d;
import c.a.w0.t.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f30583a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30584b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.w0.l.d.j.c.a f30585c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30586d;

    /* renamed from: e  reason: collision with root package name */
    public int f30587e;

    /* renamed from: f  reason: collision with root package name */
    public int f30588f;

    /* renamed from: g  reason: collision with root package name */
    public String f30589g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f30590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f30591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f30592g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f30593h;

        public a(b bVar, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30593h = bVar;
            this.f30590e = bArr;
            this.f30591f = i2;
            this.f30592g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f30593h.f30583a.c(this.f30590e, this.f30591f, this.f30592g);
                } catch (Exception e2) {
                    if (this.f30593h.f30585c == null || this.f30593h.f30586d) {
                        return;
                    }
                    this.f30593h.f30585c.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    /* renamed from: c.a.w0.i.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1420b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30594e;

        public RunnableC1420b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30594e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f30594e.f30583a.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.f30594e.f30585c == null || this.f30594e.f30586d) {
                        return;
                    }
                    this.f30594e.f30585c.onFinishedWriting(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.w0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30595e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30595e = bVar;
        }

        @Override // c.a.w0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f30595e.f30585c == null || this.f30595e.f30586d) {
                return;
            }
            this.f30595e.f30585c.onFinishedWriting(z);
        }
    }

    public b(String str, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30587e = i2;
        this.f30588f = i3;
        this.f30584b = Executors.newSingleThreadExecutor();
        this.f30586d = false;
    }

    public void b() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30584b.isShutdown()) {
            return;
        }
        this.f30584b.submit(new RunnableC1420b(this));
        this.f30584b.shutdown();
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f30587e = i2;
            this.f30588f = i3;
            try {
                c.a.w0.l.d.j.a aVar = new c.a.w0.l.d.j.a(i2, i3);
                this.f30583a = aVar;
                aVar.b(this.f30589g);
                this.f30583a.d(new c(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.w0.l.d.j.c.a aVar2 = this.f30585c;
                if (aVar2 != null) {
                    aVar2.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    @Override // c.a.w0.i.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(c.a.w0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f30585c = aVar;
        }
    }

    public void e(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f30589g = str;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30586d = true;
            try {
                this.f30584b.shutdownNow();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.w0.i.e
    public int write(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            if (!this.f30584b.isShutdown()) {
                this.f30584b.submit(new a(this, copyOf, i2, i3));
            }
            return i3 - i2;
        }
        return invokeLII.intValue;
    }
}
