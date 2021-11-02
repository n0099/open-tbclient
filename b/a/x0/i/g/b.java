package b.a.x0.i.g;

import b.a.x0.i.e;
import b.a.x0.l.d.d;
import b.a.x0.t.m;
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
/* loaded from: classes6.dex */
public class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f29588a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f29589b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.x0.l.d.j.c.a f29590c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29591d;

    /* renamed from: e  reason: collision with root package name */
    public int f29592e;

    /* renamed from: f  reason: collision with root package name */
    public int f29593f;

    /* renamed from: g  reason: collision with root package name */
    public String f29594g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f29595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f29596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f29597g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f29598h;

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
            this.f29598h = bVar;
            this.f29595e = bArr;
            this.f29596f = i2;
            this.f29597g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f29598h.f29588a.c(this.f29595e, this.f29596f, this.f29597g);
                } catch (Exception e2) {
                    if (this.f29598h.f29590c == null || this.f29598h.f29591d) {
                        return;
                    }
                    this.f29598h.f29590c.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    /* renamed from: b.a.x0.i.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1425b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29599e;

        public RunnableC1425b(b bVar) {
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
            this.f29599e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f29599e.f29588a.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.f29599e.f29590c == null || this.f29599e.f29591d) {
                        return;
                    }
                    this.f29599e.f29590c.onFinishedWriting(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29600e;

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
            this.f29600e = bVar;
        }

        @Override // b.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f29600e.f29590c == null || this.f29600e.f29591d) {
                return;
            }
            this.f29600e.f29590c.onFinishedWriting(z);
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
        this.f29592e = i2;
        this.f29593f = i3;
        this.f29589b = Executors.newSingleThreadExecutor();
        this.f29591d = false;
    }

    public void b() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29589b.isShutdown()) {
            return;
        }
        this.f29589b.submit(new RunnableC1425b(this));
        this.f29589b.shutdown();
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f29592e = i2;
            this.f29593f = i3;
            try {
                b.a.x0.l.d.j.a aVar = new b.a.x0.l.d.j.a(i2, i3);
                this.f29588a = aVar;
                aVar.b(this.f29594g);
                this.f29588a.d(new c(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                b.a.x0.l.d.j.c.a aVar2 = this.f29590c;
                if (aVar2 != null) {
                    aVar2.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    @Override // b.a.x0.i.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(b.a.x0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f29590c = aVar;
        }
    }

    public void e(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f29594g = str;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29591d = true;
            try {
                this.f29589b.shutdownNow();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.a.x0.i.e
    public int write(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            if (!this.f29589b.isShutdown()) {
                this.f29589b.submit(new a(this, copyOf, i2, i3));
            }
            return i3 - i2;
        }
        return invokeLII.intValue;
    }
}
