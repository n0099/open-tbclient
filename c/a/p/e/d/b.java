package c.a.p.e.d;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b extends c.a.p.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public volatile g f11638c;

    /* renamed from: d  reason: collision with root package name */
    public volatile c.a.p.e.c.a f11639d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f11640e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f11641f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f11642g;

    /* renamed from: h  reason: collision with root package name */
    public volatile Future<Boolean> f11643h;
    public volatile Future<Boolean> i;
    public volatile boolean j;
    public String k;
    public Object l;
    public Object m;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.f11639d = new c.a.p.e.c.a();
                this.a.f11639d.b(this.a.a);
                this.a.f11639d.c(this.a.f11614b);
                this.a.f11641f = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: c.a.p.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC0878b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public CallableC0878b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.a;
                bVar.f11638c = new g(bVar, bVar.k);
                this.a.f11638c.b(this.a.a);
                this.a.f11638c.c(this.a.f11614b);
                this.a.f11642g = true;
                if (this.a.f11638c.o()) {
                    this.a.j = true;
                    return Boolean.TRUE;
                }
                this.a.j = false;
                this.a.f11640e = false;
                this.a.n();
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new Object();
        this.m = new Object();
        this.f11640e = true;
        this.f11641f = false;
        this.k = str;
    }

    @Override // c.a.p.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f11640e) {
                w();
                if (this.j) {
                    this.f11638c.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.f11639d.a(str, bundle, cVar);
        }
    }

    @Override // c.a.p.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f11640e) {
                w();
                if (this.j && this.f11638c != null) {
                    this.f11638c.d();
                    return;
                }
            }
            t();
            if (this.f11639d != null) {
                this.f11639d.d();
            }
        }
    }

    @Override // c.a.p.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f11640e) {
                w();
                if (this.j) {
                    return this.f11638c.e(str);
                }
            }
            t();
            return this.f11639d.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.f11640e) {
                synchronized (this.l) {
                    p();
                }
                return;
            }
            synchronized (this.m) {
                n();
            }
        }
    }

    @Override // c.a.p.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            if (this.f11640e) {
                w();
                if (this.j) {
                    a.d g2 = this.f11638c.g(str, bundle);
                    if (g2.b()) {
                        return g2;
                    }
                    this.f11640e = false;
                }
            }
            t();
            return this.f11639d.g(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f11640e = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.f11641f && this.i == null) {
            this.i = this.a.f11617d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.f11642g && this.f11643h == null) {
            this.f11643h = this.a.f11617d.submit(new CallableC0878b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f11640e || this.f11641f) {
            return;
        }
        synchronized (this.m) {
            n();
        }
        try {
            this.i.get();
        } catch (Exception unused) {
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f11640e) {
            if (!this.f11642g) {
                synchronized (this.l) {
                    p();
                }
            }
            try {
                this.f11643h.get();
            } catch (Exception unused) {
            }
        }
    }
}
