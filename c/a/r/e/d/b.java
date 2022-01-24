package c.a.r.e.d;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class b extends c.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f4946g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.a.r.e.c.a f4947h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f4948i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f4949j;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p;
    public Object q;

    /* loaded from: classes.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4950e;

        public a(b bVar) {
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
            this.f4950e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f4950e.f4947h = new c.a.r.e.c.a();
                this.f4950e.f4947h.b(this.f4950e.f4914e);
                this.f4950e.f4947h.c(this.f4950e.f4915f);
                this.f4950e.f4949j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0246b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4951e;

        public CallableC0246b(b bVar) {
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
            this.f4951e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f4951e;
                bVar.f4946g = new g(bVar, bVar.o);
                this.f4951e.f4946g.b(this.f4951e.f4914e);
                this.f4951e.f4946g.c(this.f4951e.f4915f);
                this.f4951e.k = true;
                if (this.f4951e.f4946g.o()) {
                    this.f4951e.n = true;
                    return Boolean.TRUE;
                }
                this.f4951e.n = false;
                this.f4951e.f4948i = false;
                this.f4951e.n();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new Object();
        this.q = new Object();
        this.f4948i = true;
        this.f4949j = false;
        this.o = str;
    }

    @Override // c.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f4948i) {
                w();
                if (this.n) {
                    this.f4946g.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.f4947h.a(str, bundle, cVar);
        }
    }

    @Override // c.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f4948i) {
                w();
                if (this.n && this.f4946g != null) {
                    this.f4946g.d();
                    return;
                }
            }
            t();
            if (this.f4947h != null) {
                this.f4947h.d();
            }
        }
    }

    @Override // c.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f4948i) {
                w();
                if (this.n) {
                    return this.f4946g.e(str);
                }
            }
            t();
            return this.f4947h.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.f4948i) {
                synchronized (this.p) {
                    p();
                }
                return;
            }
            synchronized (this.q) {
                n();
            }
        }
    }

    @Override // c.a.r.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            if (this.f4948i) {
                w();
                if (this.n) {
                    a.d g2 = this.f4946g.g(str, bundle);
                    if (g2.b()) {
                        return g2;
                    }
                    this.f4948i = false;
                }
            }
            t();
            return this.f4947h.g(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4948i = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.f4949j && this.m == null) {
            this.m = this.f4914e.f4918d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.k && this.l == null) {
            this.l = this.f4914e.f4918d.submit(new CallableC0246b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f4948i || this.f4949j) {
            return;
        }
        synchronized (this.q) {
            n();
        }
        try {
            this.m.get();
        } catch (Exception unused) {
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f4948i) {
            if (!this.k) {
                synchronized (this.p) {
                    p();
                }
            }
            try {
                this.l.get();
            } catch (Exception unused) {
            }
        }
    }
}
