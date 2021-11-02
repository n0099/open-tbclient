package b.a.r.d.d;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.r.d.a;
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
public class b extends b.a.r.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f14388g;

    /* renamed from: h  reason: collision with root package name */
    public volatile b.a.r.d.c.a f14389h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f14390i;
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
        public final /* synthetic */ b f14391e;

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
            this.f14391e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f14391e.f14389h = new b.a.r.d.c.a();
                this.f14391e.f14389h.b(this.f14391e.f14347e);
                this.f14391e.f14389h.c(this.f14391e.f14348f);
                this.f14391e.j = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* renamed from: b.a.r.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0725b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14392e;

        public CallableC0725b(b bVar) {
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
            this.f14392e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f14392e;
                bVar.f14388g = new g(bVar, bVar.o);
                this.f14392e.f14388g.b(this.f14392e.f14347e);
                this.f14392e.f14388g.c(this.f14392e.f14348f);
                this.f14392e.k = true;
                if (this.f14392e.f14388g.n()) {
                    this.f14392e.n = true;
                    return Boolean.TRUE;
                }
                this.f14392e.n = false;
                this.f14392e.f14390i = false;
                this.f14392e.p();
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
        this.f14390i = true;
        this.j = false;
        this.o = str;
    }

    @Override // b.a.r.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.f14390i) {
                s();
                if (this.n) {
                    this.f14388g.a(str, bundle, cVar);
                    return;
                }
            }
            m();
            this.f14389h.a(str, bundle, cVar);
        }
    }

    @Override // b.a.r.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f14390i) {
                s();
                if (this.n) {
                    return this.f14388g.d(str);
                }
            }
            m();
            return this.f14389h.d(str);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (this.f14390i) {
                synchronized (this.p) {
                    v();
                }
                return;
            }
            synchronized (this.q) {
                p();
            }
        }
    }

    @Override // b.a.r.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            if (this.f14390i) {
                s();
                if (this.n) {
                    a.d f2 = this.f14388g.f(str, bundle);
                    if (f2.b()) {
                        return f2;
                    }
                    this.f14390i = false;
                }
            }
            m();
            return this.f14389h.f(str, bundle);
        }
        return (a.d) invokeLL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14390i = false;
            p();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f14390i || this.j) {
            return;
        }
        synchronized (this.q) {
            p();
        }
        try {
            this.m.get();
        } catch (Exception unused) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.j && this.m == null) {
            this.m = this.f14347e.f14352d.submit(new a(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f14390i) {
            if (!this.k) {
                synchronized (this.p) {
                    v();
                }
            }
            try {
                this.l.get();
            } catch (Exception unused) {
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.k && this.l == null) {
            this.l = this.f14347e.f14352d.submit(new CallableC0725b(this));
        }
    }
}
