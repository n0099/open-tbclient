package c.a.x0.i.g;

import c.a.x0.i.e;
import c.a.x0.l.d.d;
import c.a.x0.t.m;
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
    public d f30836a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30837b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x0.l.d.j.c.a f30838c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30839d;

    /* renamed from: e  reason: collision with root package name */
    public int f30840e;

    /* renamed from: f  reason: collision with root package name */
    public int f30841f;

    /* renamed from: g  reason: collision with root package name */
    public String f30842g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f30843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f30844f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f30845g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f30846h;

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
            this.f30846h = bVar;
            this.f30843e = bArr;
            this.f30844f = i2;
            this.f30845g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f30846h.f30836a.c(this.f30843e, this.f30844f, this.f30845g);
                } catch (Exception e2) {
                    if (this.f30846h.f30838c == null || this.f30846h.f30839d) {
                        return;
                    }
                    this.f30846h.f30838c.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    /* renamed from: c.a.x0.i.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1422b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30847e;

        public RunnableC1422b(b bVar) {
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
            this.f30847e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f30847e.f30836a.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.f30847e.f30838c == null || this.f30847e.f30839d) {
                        return;
                    }
                    this.f30847e.f30838c.onFinishedWriting(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30848e;

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
            this.f30848e = bVar;
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f30848e.f30838c == null || this.f30848e.f30839d) {
                return;
            }
            this.f30848e.f30838c.onFinishedWriting(z);
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
        this.f30840e = i2;
        this.f30841f = i3;
        this.f30837b = Executors.newSingleThreadExecutor();
        this.f30839d = false;
    }

    public void b() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30837b.isShutdown()) {
            return;
        }
        this.f30837b.submit(new RunnableC1422b(this));
        this.f30837b.shutdown();
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f30840e = i2;
            this.f30841f = i3;
            try {
                c.a.x0.l.d.j.a aVar = new c.a.x0.l.d.j.a(i2, i3);
                this.f30836a = aVar;
                aVar.b(this.f30842g);
                this.f30836a.d(new c(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.x0.l.d.j.c.a aVar2 = this.f30838c;
                if (aVar2 != null) {
                    aVar2.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    @Override // c.a.x0.i.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(c.a.x0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f30838c = aVar;
        }
    }

    public void e(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f30842g = str;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30839d = true;
            try {
                this.f30837b.shutdownNow();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.x0.i.e
    public int write(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            if (!this.f30837b.isShutdown()) {
                this.f30837b.submit(new a(this, copyOf, i2, i3));
            }
            return i3 - i2;
        }
        return invokeLII.intValue;
    }
}
