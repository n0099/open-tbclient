package b.a.r.e.d;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.r.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class b extends b.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f15160g;

    /* renamed from: h  reason: collision with root package name */
    public volatile b.a.r.e.c.a f15161h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f15162i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p;
    public Object q;

    /* loaded from: classes4.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15163e;

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
            this.f15163e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f15163e.f15161h = new b.a.r.e.c.a();
                this.f15163e.f15161h.b(this.f15163e.f15117e);
                this.f15163e.f15161h.c(this.f15163e.f15118f);
                this.f15163e.j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: b.a.r.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0761b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15164e;

        public CallableC0761b(b bVar) {
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
            this.f15164e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f15164e;
                bVar.f15160g = new g(bVar, bVar.o);
                this.f15164e.f15160g.b(this.f15164e.f15117e);
                this.f15164e.f15160g.c(this.f15164e.f15118f);
                this.f15164e.k = true;
                if (this.f15164e.f15160g.o()) {
                    this.f15164e.n = true;
                    return Boolean.TRUE;
                }
                this.f15164e.n = false;
                this.f15164e.f15162i = false;
                this.f15164e.n();
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
        this.f15162i = true;
        this.j = false;
        this.o = str;
    }

    @Override // b.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f15162i) {
                w();
                if (this.n) {
                    this.f15160g.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.f15161h.a(str, bundle, cVar);
        }
    }

    @Override // b.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f15162i) {
                w();
                if (this.n && this.f15160g != null) {
                    this.f15160g.d();
                    return;
                }
            }
            t();
            if (this.f15161h != null) {
                this.f15161h.d();
            }
        }
    }

    @Override // b.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f15162i) {
                w();
                if (this.n) {
                    return this.f15160g.e(str);
                }
            }
            t();
            return this.f15161h.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.f15162i) {
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

    @Override // b.a.r.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            if (this.f15162i) {
                w();
                if (this.n) {
                    a.d g2 = this.f15160g.g(str, bundle);
                    if (g2.b()) {
                        return g2;
                    }
                    this.f15162i = false;
                }
            }
            t();
            return this.f15161h.g(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15162i = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.j && this.m == null) {
            this.m = this.f15117e.f15122d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.k && this.l == null) {
            this.l = this.f15117e.f15122d.submit(new CallableC0761b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f15162i || this.j) {
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f15162i) {
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
