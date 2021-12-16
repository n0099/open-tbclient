package c.b.a.a;

import c.b.b.q.g0;
import c.b.b.q.w;
import c.b.b.q.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.a.c.b<d> a;

    /* renamed from: b  reason: collision with root package name */
    public w<g, c.b.b.q.a<d>> f27671b;

    /* renamed from: c  reason: collision with root package name */
    public w<g, c.b.a.c.b<d>> f27672c;

    /* renamed from: d  reason: collision with root package name */
    public g0<c> f27673d;

    /* renamed from: e  reason: collision with root package name */
    public w<g, c.b.b.q.d> f27674e;

    /* renamed from: f  reason: collision with root package name */
    public b f27675f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27676g;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b extends z<c.b.b.q.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.z
        /* renamed from: g */
        public c.b.b.q.d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c.b.b.q.d() : (c.b.b.q.d) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;

        /* renamed from: b  reason: collision with root package name */
        public int f27677b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public h(c.b.a.c.b<d> bVar) {
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
        this.f27671b = new w<>();
        this.f27672c = new w<>();
        this.f27673d = new g0<>(true, 16);
        this.f27674e = new w<>();
        this.f27675f = new b(null);
        this.f27676g = false;
        this.a = bVar;
    }

    public void a(g gVar, int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, gVar, i2, eVar) == null) {
            d(gVar);
            int i3 = 0;
            while (true) {
                g0<c> g0Var = this.f27673d;
                if (i3 >= g0Var.f28143f || g0Var.get(i3).f27677b > i2) {
                    break;
                }
                i3++;
            }
            w.e<c.b.b.q.d> n = this.f27674e.n();
            n.d();
            while (n.hasNext()) {
                c.b.b.q.d next = n.next();
                for (int h2 = next.h(); h2 > i3; h2--) {
                    if (next.e(h2 - 1)) {
                        next.k(h2);
                    } else {
                        next.c(h2);
                    }
                }
                next.c(i3);
            }
            this.f27674e.c(gVar).k(i3);
            c cVar = new c(null);
            cVar.a = eVar;
            cVar.f27677b = i2;
            this.f27673d.insert(i3, cVar);
        }
    }

    public c.b.a.c.b<d> b(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) ? d(gVar) : (c.b.a.c.b) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27676g : invokeV.booleanValue;
    }

    public final c.b.a.c.b<d> d(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            c.b.a.c.b<d> c2 = this.f27672c.c(gVar);
            if (c2 == null) {
                c.b.b.q.a<d> aVar = new c.b.b.q.a<>(false, 16);
                c.b.a.c.b<d> bVar = new c.b.a.c.b<>(aVar);
                this.f27671b.i(gVar, aVar);
                this.f27672c.i(gVar, bVar);
                this.f27674e.i(gVar, new c.b.b.q.d());
                Iterator<d> it = this.a.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                return bVar;
            }
            return c2;
        }
        return (c.b.a.c.b) invokeL.objValue;
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, eVar) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            g0<c> g0Var = this.f27673d;
            if (i2 >= g0Var.f28143f) {
                return;
            }
            if (g0Var.get(i2).a == eVar) {
                w.e<c.b.b.q.d> n = this.f27674e.n();
                n.d();
                while (n.hasNext()) {
                    c.b.b.q.d next = n.next();
                    int h2 = next.h();
                    int i3 = i2;
                    while (i3 < h2) {
                        int i4 = i3 + 1;
                        if (next.e(i4)) {
                            next.k(i3);
                        } else {
                            next.c(i3);
                        }
                        i3 = i4;
                    }
                }
                this.f27673d.h(i2);
                i2--;
            }
            i2++;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            c.b.b.q.d e2 = this.f27675f.e();
            c.b.b.q.d e3 = this.f27675f.e();
            w.c<g> f2 = this.f27674e.f();
            f2.d();
            while (true) {
                boolean z = false;
                if (!f2.hasNext()) {
                    break;
                }
                g next = f2.next();
                int g2 = next.g();
                c.b.b.q.d f3 = dVar.f();
                boolean e4 = f3.e(g2);
                if (next.h(dVar) && !dVar.f27653d) {
                    z = true;
                }
                if (e4 != z) {
                    c.b.b.q.d c2 = this.f27674e.c(next);
                    c.b.b.q.a<d> c3 = this.f27671b.c(next);
                    if (z) {
                        e2.j(c2);
                        c3.a(dVar);
                        f3.k(g2);
                    } else {
                        e3.j(c2);
                        c3.i(dVar, true);
                        f3.c(g2);
                    }
                }
            }
            this.f27676g = true;
            c[] o = this.f27673d.o();
            try {
                for (int i2 = e3.i(0); i2 >= 0; i2 = e3.i(i2 + 1)) {
                    o[i2].a.a(dVar);
                }
                for (int i3 = e2.i(0); i3 >= 0; i3 = e2.i(i3 + 1)) {
                    o[i3].a.b(dVar);
                }
            } finally {
                e2.b();
                e3.b();
                this.f27675f.c(e2);
                this.f27675f.c(e3);
                this.f27673d.p();
                this.f27676g = false;
            }
        }
    }
}
