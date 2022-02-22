package c.a.t0.b1.c;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f12535b;

    /* renamed from: c  reason: collision with root package name */
    public s f12536c;

    /* renamed from: d  reason: collision with root package name */
    public p f12537d;

    /* renamed from: e  reason: collision with root package name */
    public l f12538e;

    /* renamed from: f  reason: collision with root package name */
    public e f12539f;

    /* renamed from: g  reason: collision with root package name */
    public g f12540g;

    /* renamed from: h  reason: collision with root package name */
    public f f12541h;

    /* renamed from: i  reason: collision with root package name */
    public h f12542i;

    /* renamed from: j  reason: collision with root package name */
    public i f12543j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.f12535b = tbPageContext;
        this.f12536c = sVar;
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
        this.f12536c.addAdapters(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p pVar = new p(this.f12535b);
            this.f12537d = pVar;
            pVar.q0(this.f12536c);
            this.a.add(this.f12537d);
            l lVar = new l(this.f12535b);
            this.f12538e = lVar;
            lVar.q0(this.f12536c);
            this.a.add(this.f12538e);
            o oVar = new o(this.f12535b);
            this.o = oVar;
            oVar.q0(this.f12536c);
            this.a.add(this.o);
            e eVar = new e(this.f12535b);
            this.f12539f = eVar;
            eVar.q0(this.f12536c);
            this.a.add(this.f12539f);
            g gVar = new g(this.f12535b);
            this.f12540g = gVar;
            gVar.q0(this.f12536c);
            this.a.add(this.f12540g);
            f fVar = new f(this.f12535b);
            this.f12541h = fVar;
            fVar.q0(this.f12536c);
            this.a.add(this.f12541h);
            h hVar = new h(this.f12535b);
            this.f12542i = hVar;
            hVar.q0(this.f12536c);
            this.a.add(this.f12542i);
            i iVar = new i(this.f12535b);
            this.f12543j = iVar;
            iVar.q0(this.f12536c);
            this.a.add(this.f12543j);
            k kVar = new k(this.f12535b);
            this.k = kVar;
            kVar.q0(this.f12536c);
            this.a.add(this.k);
            j jVar = new j(this.f12535b);
            this.l = jVar;
            jVar.q0(this.f12536c);
            this.a.add(this.l);
            n nVar = new n(this.f12535b);
            this.m = nVar;
            nVar.q0(this.f12536c);
            this.a.add(this.m);
            m mVar = new m(this.f12535b);
            this.n = mVar;
            mVar.q0(this.f12536c);
            this.a.add(this.n);
            c cVar = new c(this.f12535b);
            this.p = cVar;
            cVar.q0(this.f12536c);
            this.a.add(this.p);
            b bVar = new b(this.f12535b, c.a.u0.g0.d0.j.R0);
            this.q = bVar;
            this.a.add(bVar);
            this.f12536c.addAdapters(this.a);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f12536c) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f12536c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            for (c.a.d.o.e.a aVar : this.a) {
                if (aVar instanceof d) {
                    ((d) aVar).Z(i2);
                }
            }
        }
    }

    public void f(c.a.t0.b1.c.q.a aVar) {
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
        this.f12536c.addAdapters(this.a);
    }

    public void h(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f12536c.setData(list);
        }
    }

    public void i(c.a.t0.n.f fVar) {
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
