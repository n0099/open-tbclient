package c.a.o0.a1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f9747b;

    /* renamed from: c  reason: collision with root package name */
    public s f9748c;

    /* renamed from: d  reason: collision with root package name */
    public p f9749d;

    /* renamed from: e  reason: collision with root package name */
    public l f9750e;

    /* renamed from: f  reason: collision with root package name */
    public e f9751f;

    /* renamed from: g  reason: collision with root package name */
    public g f9752g;

    /* renamed from: h  reason: collision with root package name */
    public f f9753h;
    public h i;
    public i j;
    public k k;
    public j l;
    public n m;
    public m n;
    public o o;
    public c p;
    public b q;

    public a(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.f9747b = tbPageContext;
        this.f9748c = sVar;
        b();
    }

    public void a(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (!c(aVar.getType())) {
                this.a.add(aVar);
            }
        }
        this.f9748c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p pVar = new p(this.f9747b);
            this.f9749d = pVar;
            pVar.q0(this.f9748c);
            this.a.add(this.f9749d);
            l lVar = new l(this.f9747b);
            this.f9750e = lVar;
            lVar.q0(this.f9748c);
            this.a.add(this.f9750e);
            o oVar = new o(this.f9747b);
            this.o = oVar;
            oVar.q0(this.f9748c);
            this.a.add(this.o);
            e eVar = new e(this.f9747b);
            this.f9751f = eVar;
            eVar.q0(this.f9748c);
            this.a.add(this.f9751f);
            g gVar = new g(this.f9747b);
            this.f9752g = gVar;
            gVar.q0(this.f9748c);
            this.a.add(this.f9752g);
            f fVar = new f(this.f9747b);
            this.f9753h = fVar;
            fVar.q0(this.f9748c);
            this.a.add(this.f9753h);
            h hVar = new h(this.f9747b);
            this.i = hVar;
            hVar.q0(this.f9748c);
            this.a.add(this.i);
            i iVar = new i(this.f9747b);
            this.j = iVar;
            iVar.q0(this.f9748c);
            this.a.add(this.j);
            k kVar = new k(this.f9747b);
            this.k = kVar;
            kVar.q0(this.f9748c);
            this.a.add(this.k);
            j jVar = new j(this.f9747b);
            this.l = jVar;
            jVar.q0(this.f9748c);
            this.a.add(this.l);
            n nVar = new n(this.f9747b);
            this.m = nVar;
            nVar.q0(this.f9748c);
            this.a.add(this.m);
            m mVar = new m(this.f9747b);
            this.n = mVar;
            mVar.q0(this.f9748c);
            this.a.add(this.n);
            c cVar = new c(this.f9747b);
            this.p = cVar;
            cVar.q0(this.f9748c);
            this.a.add(this.p);
            b bVar = new b(this.f9747b, c.a.p0.h0.e0.j.N0);
            this.q = bVar;
            this.a.add(bVar);
            this.f9748c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (c.a.d.o.e.a aVar : this.a) {
                    if (aVar != null && aVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f9748c) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f9748c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (c.a.d.o.e.a aVar : this.a) {
                if (aVar instanceof d) {
                    ((d) aVar).Z(i);
                }
            }
        }
    }

    public void f(c.a.o0.a1.c.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            for (c.a.d.o.e.a aVar2 : this.a) {
                if (aVar2 instanceof d) {
                    ((d) aVar2).n0(aVar);
                }
            }
        }
    }

    public void g(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.f9748c.a(this.a);
    }

    public void h(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f9748c.setData(list);
        }
    }

    public void i(c.a.o0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            for (c.a.d.o.e.a aVar : this.a) {
                if (aVar instanceof d) {
                    ((d) aVar).o0(fVar);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (c.a.d.o.e.a aVar : this.a) {
                if (aVar instanceof d) {
                    ((d) aVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sVar) == null) {
            for (c.a.d.o.e.a aVar : this.a) {
                if (aVar instanceof d) {
                    ((d) aVar).q0(sVar);
                }
            }
        }
    }
}
