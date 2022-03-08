package c.a.q0.a1.c;

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
    public TbPageContext<?> f11952b;

    /* renamed from: c  reason: collision with root package name */
    public s f11953c;

    /* renamed from: d  reason: collision with root package name */
    public p f11954d;

    /* renamed from: e  reason: collision with root package name */
    public l f11955e;

    /* renamed from: f  reason: collision with root package name */
    public e f11956f;

    /* renamed from: g  reason: collision with root package name */
    public g f11957g;

    /* renamed from: h  reason: collision with root package name */
    public f f11958h;

    /* renamed from: i  reason: collision with root package name */
    public h f11959i;

    /* renamed from: j  reason: collision with root package name */
    public i f11960j;
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
        this.f11952b = tbPageContext;
        this.f11953c = sVar;
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
        this.f11953c.addAdapters(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p pVar = new p(this.f11952b);
            this.f11954d = pVar;
            pVar.q0(this.f11953c);
            this.a.add(this.f11954d);
            l lVar = new l(this.f11952b);
            this.f11955e = lVar;
            lVar.q0(this.f11953c);
            this.a.add(this.f11955e);
            o oVar = new o(this.f11952b);
            this.o = oVar;
            oVar.q0(this.f11953c);
            this.a.add(this.o);
            e eVar = new e(this.f11952b);
            this.f11956f = eVar;
            eVar.q0(this.f11953c);
            this.a.add(this.f11956f);
            g gVar = new g(this.f11952b);
            this.f11957g = gVar;
            gVar.q0(this.f11953c);
            this.a.add(this.f11957g);
            f fVar = new f(this.f11952b);
            this.f11958h = fVar;
            fVar.q0(this.f11953c);
            this.a.add(this.f11958h);
            h hVar = new h(this.f11952b);
            this.f11959i = hVar;
            hVar.q0(this.f11953c);
            this.a.add(this.f11959i);
            i iVar = new i(this.f11952b);
            this.f11960j = iVar;
            iVar.q0(this.f11953c);
            this.a.add(this.f11960j);
            k kVar = new k(this.f11952b);
            this.k = kVar;
            kVar.q0(this.f11953c);
            this.a.add(this.k);
            j jVar = new j(this.f11952b);
            this.l = jVar;
            jVar.q0(this.f11953c);
            this.a.add(this.l);
            n nVar = new n(this.f11952b);
            this.m = nVar;
            nVar.q0(this.f11953c);
            this.a.add(this.m);
            m mVar = new m(this.f11952b);
            this.n = mVar;
            mVar.q0(this.f11953c);
            this.a.add(this.n);
            c cVar = new c(this.f11952b);
            this.p = cVar;
            cVar.q0(this.f11953c);
            this.a.add(this.p);
            b bVar = new b(this.f11952b, c.a.r0.f0.d0.j.R0);
            this.q = bVar;
            this.a.add(bVar);
            this.f11953c.addAdapters(this.a);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f11953c) == null || sVar.getListAdapter() == null) {
            return;
        }
        this.f11953c.getListAdapter().notifyDataSetChanged();
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

    public void f(c.a.q0.a1.c.q.a aVar) {
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
        this.f11953c.addAdapters(this.a);
    }

    public void h(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f11953c.setData(list);
        }
    }

    public void i(c.a.q0.m.f fVar) {
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
