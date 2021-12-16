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
/* loaded from: classes6.dex */
public class b extends c.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f11622g;

    /* renamed from: h  reason: collision with root package name */
    public volatile c.a.r.e.c.a f11623h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f11624i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f11625j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f11626k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p;
    public Object q;

    /* loaded from: classes6.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11627e;

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
            this.f11627e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f11627e.f11623h = new c.a.r.e.c.a();
                this.f11627e.f11623h.b(this.f11627e.f11590e);
                this.f11627e.f11623h.c(this.f11627e.f11591f);
                this.f11627e.f11625j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class CallableC0763b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11628e;

        public CallableC0763b(b bVar) {
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
            this.f11628e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f11628e;
                bVar.f11622g = new g(bVar, bVar.o);
                this.f11628e.f11622g.b(this.f11628e.f11590e);
                this.f11628e.f11622g.c(this.f11628e.f11591f);
                this.f11628e.f11626k = true;
                if (this.f11628e.f11622g.o()) {
                    this.f11628e.n = true;
                    return Boolean.TRUE;
                }
                this.f11628e.n = false;
                this.f11628e.f11624i = false;
                this.f11628e.n();
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
        this.f11624i = true;
        this.f11625j = false;
        this.o = str;
    }

    @Override // c.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f11624i) {
                w();
                if (this.n) {
                    this.f11622g.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.f11623h.a(str, bundle, cVar);
        }
    }

    @Override // c.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f11624i) {
                w();
                if (this.n && this.f11622g != null) {
                    this.f11622g.d();
                    return;
                }
            }
            t();
            if (this.f11623h != null) {
                this.f11623h.d();
            }
        }
    }

    @Override // c.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f11624i) {
                w();
                if (this.n) {
                    return this.f11622g.e(str);
                }
            }
            t();
            return this.f11623h.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.f11624i) {
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
            if (this.f11624i) {
                w();
                if (this.n) {
                    a.d g2 = this.f11622g.g(str, bundle);
                    if (g2.b()) {
                        return g2;
                    }
                    this.f11624i = false;
                }
            }
            t();
            return this.f11623h.g(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f11624i = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.f11625j && this.m == null) {
            this.m = this.f11590e.f11594d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.f11626k && this.l == null) {
            this.l = this.f11590e.f11594d.submit(new CallableC0763b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f11624i || this.f11625j) {
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f11624i) {
            if (!this.f11626k) {
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
