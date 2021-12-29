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
    public volatile g f4909g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.a.r.e.c.a f4910h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f4911i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f4912j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f4913k;
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
        public final /* synthetic */ b f4914e;

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
            this.f4914e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f4914e.f4910h = new c.a.r.e.c.a();
                this.f4914e.f4910h.b(this.f4914e.f4877e);
                this.f4914e.f4910h.c(this.f4914e.f4878f);
                this.f4914e.f4912j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0228b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4915e;

        public CallableC0228b(b bVar) {
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
            this.f4915e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f4915e;
                bVar.f4909g = new g(bVar, bVar.o);
                this.f4915e.f4909g.b(this.f4915e.f4877e);
                this.f4915e.f4909g.c(this.f4915e.f4878f);
                this.f4915e.f4913k = true;
                if (this.f4915e.f4909g.o()) {
                    this.f4915e.n = true;
                    return Boolean.TRUE;
                }
                this.f4915e.n = false;
                this.f4915e.f4911i = false;
                this.f4915e.n();
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
        this.f4911i = true;
        this.f4912j = false;
        this.o = str;
    }

    @Override // c.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f4911i) {
                w();
                if (this.n) {
                    this.f4909g.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.f4910h.a(str, bundle, cVar);
        }
    }

    @Override // c.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f4911i) {
                w();
                if (this.n && this.f4909g != null) {
                    this.f4909g.d();
                    return;
                }
            }
            t();
            if (this.f4910h != null) {
                this.f4910h.d();
            }
        }
    }

    @Override // c.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f4911i) {
                w();
                if (this.n) {
                    return this.f4909g.e(str);
                }
            }
            t();
            return this.f4910h.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.f4911i) {
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
            if (this.f4911i) {
                w();
                if (this.n) {
                    a.d g2 = this.f4909g.g(str, bundle);
                    if (g2.b()) {
                        return g2;
                    }
                    this.f4911i = false;
                }
            }
            t();
            return this.f4910h.g(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4911i = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.f4912j && this.m == null) {
            this.m = this.f4877e.f4881d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.f4913k && this.l == null) {
            this.l = this.f4877e.f4881d.submit(new CallableC0228b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f4911i || this.f4912j) {
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f4911i) {
            if (!this.f4913k) {
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
