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
    public static final Object f4120j;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public d<c.a.j.h.c.c.c.c<T>, a<T>.c> f4121b;

    /* renamed from: c  reason: collision with root package name */
    public int f4122c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f4123d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f4124e;

    /* renamed from: f  reason: collision with root package name */
    public int f4125f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4126g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4127h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f4128i;

    /* renamed from: c.a.j.h.c.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0188a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4129e;

        public RunnableC0188a(a aVar) {
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
            this.f4129e = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: c.a.j.h.c.c.c.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f4129e.a) {
                    obj = this.f4129e.f4124e;
                    this.f4129e.f4124e = a.f4120j;
                }
                this.f4129e.p(obj);
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
        public boolean f4130b;

        /* renamed from: c  reason: collision with root package name */
        public int f4131c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4132d;

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
            this.f4132d = aVar;
            this.f4131c = -1;
            this.a = cVar;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.f4130b) {
                return;
            }
            this.f4130b = z;
            boolean z2 = this.f4132d.f4122c == 0;
            this.f4132d.f4122c += this.f4130b ? 1 : -1;
            if (z2 && this.f4130b) {
                this.f4132d.m();
            }
            if (this.f4132d.f4122c == 0 && !this.f4130b) {
                this.f4132d.n();
            }
            if (this.f4130b) {
                this.f4132d.j(this);
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
        f4120j = new Object();
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
        this.f4121b = new d<>();
        this.f4122c = 0;
        this.f4123d = f4120j;
        this.f4124e = f4120j;
        this.f4125f = -1;
        this.f4128i = new RunnableC0188a(this);
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && cVar.f4130b) {
            if (!cVar.b()) {
                cVar.a(false);
                return;
            }
            int i2 = cVar.f4131c;
            int i3 = this.f4125f;
            if (i2 >= i3) {
                return;
            }
            cVar.f4131c = i3;
            cVar.a.onChanged(this.f4123d);
        }
    }

    public final void j(a<T>.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (this.f4126g) {
                this.f4127h = true;
                return;
            }
            this.f4126g = true;
            do {
                this.f4127h = false;
                if (cVar != null) {
                    i(cVar);
                    cVar = null;
                } else {
                    d<c.a.j.h.c.c.c.c<T>, a<T>.c>.C0189d g2 = this.f4121b.g();
                    while (g2.hasNext()) {
                        i((c) ((Map.Entry) g2.next()).getValue());
                        if (this.f4127h) {
                            break;
                        }
                    }
                }
            } while (this.f4127h);
            this.f4126g = false;
        }
    }

    public T k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = (T) this.f4123d;
            if (t != f4120j) {
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
            if (this.f4121b.e(cVar, bVar) != null) {
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
                z = this.f4124e == f4120j;
                this.f4124e = t;
            }
            if (z) {
                e.c(this.f4128i);
            }
        }
    }

    public void p(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
            h("setValue");
            this.f4125f++;
            this.f4123d = t;
            j(null);
        }
    }
}
