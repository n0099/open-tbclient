package c.a.j.h.c.c.c;

import c.a.j.h.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Object f3593j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public d<c.a.j.h.c.c.c.c<T>, a<T>.c> f3594b;

    /* renamed from: c  reason: collision with root package name */
    public int f3595c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f3596d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f3597e;

    /* renamed from: f  reason: collision with root package name */
    public int f3598f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3599g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3600h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f3601i;

    /* renamed from: c.a.j.h.c.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0147a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3602e;

        public RunnableC0147a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3602e = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: c.a.j.h.c.c.c.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f3602e.a) {
                    obj = this.f3602e.f3597e;
                    this.f3602e.f3597e = a.f3593j;
                }
                this.f3602e.p(obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends a<T>.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, c.a.j.h.c.c.c.c<T> cVar) {
            super(aVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (c.a.j.h.c.c.c.c) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.j.h.c.c.c.a.c
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.j.h.c.c.c.c<T> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3603b;

        /* renamed from: c  reason: collision with root package name */
        public int f3604c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3605d;

        public c(a aVar, c.a.j.h.c.c.c.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3605d = aVar;
            this.f3604c = -1;
            this.a = cVar;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.f3603b) {
                return;
            }
            this.f3603b = z;
            boolean z2 = this.f3605d.f3595c == 0;
            this.f3605d.f3595c += this.f3603b ? 1 : -1;
            if (z2 && this.f3603b) {
                this.f3605d.m();
            }
            if (this.f3605d.f3595c == 0 && !this.f3603b) {
                this.f3605d.n();
            }
            if (this.f3603b) {
                this.f3605d.j(this);
            }
        }

        public abstract boolean b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1774879376, "Lc/a/j/h/c/c/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1774879376, "Lc/a/j/h/c/c/c/a;");
                return;
            }
        }
        f3593j = new Object();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f3594b = new d<>();
        this.f3595c = 0;
        this.f3596d = f3593j;
        this.f3597e = f3593j;
        this.f3598f = -1;
        this.f3601i = new RunnableC0147a(this);
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || e.b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: c.a.j.h.c.c.c.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i(a<T>.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && cVar.f3603b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i2 = cVar.f3604c;
            int i3 = this.f3598f;
            if (i2 >= i3) {
                return;
            }
            cVar.f3604c = i3;
            cVar.a.onChanged(this.f3596d);
        }
    }

    public final void j(a<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.f3599g) {
                this.f3600h = true;
                return;
            }
            this.f3599g = true;
            do {
                this.f3600h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    d<c.a.j.h.c.c.c.c<T>, a<T>.c>.C0148d g2 = this.f3594b.g();
                    while (g2.hasNext()) {
                        i((c) ((Map.Entry) g2.next()).getValue());
                        if (this.f3600h) {
                            break;
                        }
                    }
                }
            } while (this.f3600h);
            this.f3599g = false;
        }
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.f3596d;
            if (t != f3593j) {
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public void l(c.a.j.h.c.c.c.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            b bVar = new b(this, cVar);
            if (this.f3594b.e(cVar, bVar) != null) {
                return;
            }
            bVar.a(true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void o(T t) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            synchronized (this.a) {
                z = this.f3597e == f3593j;
                this.f3597e = t;
            }
            if (z) {
                e.c(this.f3601i);
            }
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f3598f++;
            this.f3596d = t;
            j(null);
        }
    }
}
