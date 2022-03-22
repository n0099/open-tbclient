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
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public d<c.a.j.h.c.c.c.c<T>, a<T>.c> f3219b;

    /* renamed from: c  reason: collision with root package name */
    public int f3220c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f3221d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f3222e;

    /* renamed from: f  reason: collision with root package name */
    public int f3223f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3224g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3225h;
    public final Runnable i;

    /* renamed from: c.a.j.h.c.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0176a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0176a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: c.a.j.h.c.c.c.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.a) {
                    obj = this.a.f3222e;
                    this.a.f3222e = a.j;
                }
                this.a.p(obj);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public boolean f3226b;

        /* renamed from: c  reason: collision with root package name */
        public int f3227c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3228d;

        public c(a aVar, c.a.j.h.c.c.c.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3228d = aVar;
            this.f3227c = -1;
            this.a = cVar;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.f3226b) {
                return;
            }
            this.f3226b = z;
            boolean z2 = this.f3228d.f3220c == 0;
            this.f3228d.f3220c += this.f3226b ? 1 : -1;
            if (z2 && this.f3226b) {
                this.f3228d.m();
            }
            if (this.f3228d.f3220c == 0 && !this.f3226b) {
                this.f3228d.n();
            }
            if (this.f3226b) {
                this.f3228d.j(this);
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
        j = new Object();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f3219b = new d<>();
        this.f3220c = 0;
        this.f3221d = j;
        this.f3222e = j;
        this.f3223f = -1;
        this.i = new RunnableC0176a(this);
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && cVar.f3226b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i = cVar.f3227c;
            int i2 = this.f3223f;
            if (i >= i2) {
                return;
            }
            cVar.f3227c = i2;
            cVar.a.onChanged(this.f3221d);
        }
    }

    public final void j(a<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.f3224g) {
                this.f3225h = true;
                return;
            }
            this.f3224g = true;
            do {
                this.f3225h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    d<c.a.j.h.c.c.c.c<T>, a<T>.c>.C0177d g2 = this.f3219b.g();
                    while (g2.hasNext()) {
                        i((c) ((Map.Entry) g2.next()).getValue());
                        if (this.f3225h) {
                            break;
                        }
                    }
                }
            } while (this.f3225h);
            this.f3224g = false;
        }
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.f3221d;
            if (t != j) {
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
            if (this.f3219b.e(cVar, bVar) != null) {
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
                z = this.f3222e == j;
                this.f3222e = t;
            }
            if (z) {
                e.c(this.i);
            }
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f3223f++;
            this.f3221d = t;
            j(null);
        }
    }
}
