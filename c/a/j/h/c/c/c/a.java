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
    public static final Object f4021j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public d<c.a.j.h.c.c.c.c<T>, a<T>.c> f4022b;

    /* renamed from: c  reason: collision with root package name */
    public int f4023c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f4024d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f4025e;

    /* renamed from: f  reason: collision with root package name */
    public int f4026f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4027g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4028h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f4029i;

    /* renamed from: c.a.j.h.c.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0168a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4030e;

        public RunnableC0168a(a aVar) {
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
            this.f4030e = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: c.a.j.h.c.c.c.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f4030e.a) {
                    obj = this.f4030e.f4025e;
                    this.f4030e.f4025e = a.f4021j;
                }
                this.f4030e.p(obj);
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
        public boolean f4031b;

        /* renamed from: c  reason: collision with root package name */
        public int f4032c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4033d;

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
            this.f4033d = aVar;
            this.f4032c = -1;
            this.a = cVar;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.f4031b) {
                return;
            }
            this.f4031b = z;
            boolean z2 = this.f4033d.f4023c == 0;
            this.f4033d.f4023c += this.f4031b ? 1 : -1;
            if (z2 && this.f4031b) {
                this.f4033d.m();
            }
            if (this.f4033d.f4023c == 0 && !this.f4031b) {
                this.f4033d.n();
            }
            if (this.f4031b) {
                this.f4033d.j(this);
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
        f4021j = new Object();
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
        this.f4022b = new d<>();
        this.f4023c = 0;
        this.f4024d = f4021j;
        this.f4025e = f4021j;
        this.f4026f = -1;
        this.f4029i = new RunnableC0168a(this);
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && cVar.f4031b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i2 = cVar.f4032c;
            int i3 = this.f4026f;
            if (i2 >= i3) {
                return;
            }
            cVar.f4032c = i3;
            cVar.a.onChanged(this.f4024d);
        }
    }

    public final void j(a<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.f4027g) {
                this.f4028h = true;
                return;
            }
            this.f4027g = true;
            do {
                this.f4028h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    d<c.a.j.h.c.c.c.c<T>, a<T>.c>.C0169d g2 = this.f4022b.g();
                    while (g2.hasNext()) {
                        i((c) ((Map.Entry) g2.next()).getValue());
                        if (this.f4028h) {
                            break;
                        }
                    }
                }
            } while (this.f4028h);
            this.f4027g = false;
        }
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.f4024d;
            if (t != f4021j) {
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
            if (this.f4022b.e(cVar, bVar) != null) {
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
                z = this.f4025e == f4021j;
                this.f4025e = t;
            }
            if (z) {
                e.c(this.f4029i);
            }
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f4026f++;
            this.f4024d = t;
            j(null);
        }
    }
}
