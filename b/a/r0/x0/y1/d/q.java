package b.a.r0.x0.y1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f28258a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.m.e.s f28259b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f28260c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, d2> f28261d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b.a.e.m.e.n> f28262e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f28263f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28264g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.r0.x0.i f28265h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f28266i;
    public b.a.e.m.e.a j;
    public y k;
    public k l;
    public v m;
    public s n;
    public j o;
    public m p;
    public w q;
    public a0 r;
    public u s;
    public r t;
    public z u;
    public l v;
    public t w;

    public q(FrsFragment frsFragment, b.a.e.m.e.s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, sVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28260c = new LinkedList();
        this.f28264g = false;
        this.f28259b = sVar;
        this.f28265h = new b.a.r0.x0.i();
        q(frsFragment, sVar);
        this.f28261d = new HashMap<>();
        o(z);
    }

    public final void A(List<b.a.e.m.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).k0(this.f28265h);
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void a(String str) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f28260c) == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof b.a.r0.b0.b0) {
                ((b.a.r0.b0.b0) aVar).a(str);
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void b(boolean z) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).o0(z);
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void c() {
        b.a.e.m.e.s sVar;
        List<b.a.e.m.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f28259b) == null || sVar.getData() == null || this.f28259b.getData().size() == 0 || (data = this.f28259b.getData()) == null || data.size() == 0) {
            return;
        }
        for (b.a.e.m.e.n nVar : data) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.r0() != 0) {
                    d2Var.e3();
                }
            } else if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.e3();
                }
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.j != null) {
                return f1.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void e(b.a.e.m.e.w wVar) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).c0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.c0(wVar);
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void f() {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).o(this.f28258a.getPageContext(), this.f28258a.getUniqueId());
            }
        }
        A(this.f28260c);
    }

    @Override // b.a.r0.x0.y1.d.e0
    public List<b.a.e.m.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.e.m.e.s sVar = this.f28259b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void h(ArrayList<b.a.e.m.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            b.a.r0.m3.w.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<b.a.e.m.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.e.m.e.n next = it.next();
                if ((next instanceof c2) && ((c2) next).w.C2()) {
                    it.remove();
                }
            }
            this.f28259b.setData(arrayList);
            this.f28263f = frsViewData;
            x();
            z();
            this.f28262e = arrayList;
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public HashMap<Integer, d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28261d : (HashMap) invokeV.objValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null) {
                return f1.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j != null) {
                return f1.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (b.a.e.m.e.a aVar : this.f28260c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void m(b.a.r0.x0.f fVar) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).l0(fVar);
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (b.a.e.m.e.a aVar : this.f28260c) {
                if (aVar instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) aVar).j0();
                } else if (aVar instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f28259b.getListAdapter() == null) {
            return;
        }
        this.f28259b.getListAdapter().notifyDataSetChanged();
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f28264g == z) {
            return;
        }
        this.f28264g = z;
    }

    public final ArrayList<Integer> p(ArrayList<b.a.e.m.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                b.a.e.m.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, d2> hashMap = this.f28261d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f28261d.put(Integer.valueOf(i2), (d2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.f28258a = frsFragment;
            this.j = b.a.r0.x0.e.e().c(frsFragment.getPageContext(), b.a.r0.m3.z.b4, this.f28258a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), d2.h3, this.f28258a.getUniqueId());
            this.k = yVar;
            yVar.p0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), d2.i3, this.f28258a.getUniqueId());
            this.l = kVar;
            kVar.p0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), d2.k3, this.f28258a.getUniqueId());
            this.m = vVar;
            vVar.p0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), d2.l3, this.f28258a.getUniqueId());
            this.n = sVar2;
            sVar2.p0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), d2.o3, this.f28258a.getUniqueId());
            this.o = jVar;
            jVar.p0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), d2.p3, this.f28258a.getUniqueId());
            this.p = mVar;
            mVar.p0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), d2.u3, this.f28258a.getUniqueId());
            this.r = a0Var;
            a0Var.p0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), d2.N3, this.f28258a.getUniqueId());
            this.q = wVar;
            wVar.p0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), d2.v3, this.f28258a.getUniqueId());
            this.s = uVar;
            uVar.p0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), d2.w3, this.f28258a.getUniqueId());
            this.t = rVar;
            rVar.p0(sVar);
            z zVar = new z(frsFragment.getPageContext(), d2.z3, this.f28258a.getUniqueId());
            this.u = zVar;
            zVar.p0(sVar);
            l lVar = new l(frsFragment.getPageContext(), d2.R3, this.f28258a.getUniqueId());
            this.v = lVar;
            lVar.p0(sVar);
            p pVar = new p(frsFragment.getPageContext(), d2.x3, this.f28258a.getUniqueId());
            pVar.p0(sVar);
            x xVar = new x(frsFragment.getPageContext(), d2.E3, this.f28258a.getUniqueId());
            xVar.p0(sVar);
            a aVar = new a(frsFragment.getPageContext(), d2.r3, frsFragment.getUniqueId());
            aVar.p0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), d2.m3, frsFragment.getUniqueId());
            cVar.p0(sVar);
            b bVar = new b(frsFragment.getPageContext(), d2.G3, this.f28258a.getUniqueId());
            bVar.p0(sVar);
            bVar.S0(true);
            g gVar = new g(frsFragment.getPageContext(), d2.F3, this.f28258a.getUniqueId());
            gVar.p0(sVar);
            gVar.S0(true);
            h hVar = new h(frsFragment.getPageContext(), d2.H3, this.f28258a.getUniqueId());
            hVar.p0(sVar);
            hVar.T0(true);
            z zVar2 = new z(frsFragment.getPageContext(), d2.I3, this.f28258a.getUniqueId());
            zVar2.p0(sVar);
            o oVar = new o(frsFragment.getPageContext(), d2.Q3, this.f28258a.getUniqueId());
            oVar.p0(sVar);
            n nVar = new n(frsFragment.getPageContext(), d2.J3, this.f28258a.getUniqueId());
            nVar.p0(sVar);
            this.f28266i = new d0(frsFragment.getPageContext(), b.a.r0.m3.r.f22653g, this.f28258a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), d2.y3, this.f28258a.getUniqueId());
            this.w = tVar;
            tVar.p0(sVar);
            b.a.e.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = b.a.r0.x0.e.e().a(frsFragment.getPageContext(), this.f28258a.getUniqueId(), true);
            b.a.e.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = b.a.r0.x0.e.e().d(frsFragment.getPageContext(), d2.V3, this.f28258a.getUniqueId());
            b.a.r0.x0.r rVar2 = new b.a.r0.x0.r(frsFragment.getPageContext(), b.a.r0.x0.s.f27833f);
            i iVar = new i(frsFragment.getPageContext(), b.a.r0.x0.u.f27925e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), b.a.r0.x0.w.f28009i, this.f28258a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), d2.t3, this.f28258a.getUniqueId());
            eVar.j0((BdTypeRecyclerView) sVar);
            this.f28260c.add(this.j);
            this.f28260c.add(this.k);
            this.f28260c.add(this.l);
            this.f28260c.add(this.m);
            this.f28260c.add(this.n);
            this.f28260c.add(this.o);
            this.f28260c.add(this.p);
            this.f28260c.add(this.q);
            this.f28260c.add(this.r);
            this.f28260c.add(this.s);
            this.f28260c.add(this.t);
            this.f28260c.add(this.f28266i);
            this.f28260c.add(pVar);
            this.f28260c.add(xVar);
            this.f28260c.add(aVar);
            this.f28260c.add(cVar);
            this.f28260c.add(bVar);
            this.f28260c.add(gVar);
            this.f28260c.add(hVar);
            this.f28260c.add(this.w);
            this.f28260c.add(this.u);
            this.f28260c.add(this.v);
            this.f28260c.add(a2);
            this.f28260c.add(d2);
            this.f28260c.add(rVar2);
            this.f28260c.add(iVar);
            this.f28260c.add(oVar);
            this.f28260c.add(nVar);
            this.f28260c.add(frsUserRecommendAdapter);
            this.f28260c.add(zVar2);
            this.f28260c.add(eVar);
            this.f28260c.add(b.a.r0.y0.b.e().b(this.f28258a.getBaseFragmentActivity(), AdvertAppInfo.D4));
            b.a.r0.g.f.b bVar2 = new b.a.r0.g.f.b(this.f28258a, 1);
            bVar2.t(this.f28260c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f28260c);
            sVar.addAdapters(this.f28260c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f28258a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            u("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<b.a.e.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                b.a.e.m.e.a<?, ?> next = it.next();
                if (next instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) next).o(this.f28258a.getPageContext(), this.f28258a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<b.a.e.m.e.a> list = this.f28260c;
            if (list != null) {
                list.addAll(arrayList);
            }
            b.a.e.m.e.s sVar3 = this.f28259b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(b.a.e.m.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == d2.b3 || type == d2.y3 || type == d2.z3 || type == d2.I3 || type == d2.Q3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<b.a.e.m.e.n> arrayList = this.f28262e;
            if (arrayList != null) {
                this.f28259b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // b.a.r0.x0.y1.d.e0
    public void setFromCDN(boolean z) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).setFromCDN(z);
            }
        }
        y yVar = this.k;
        if (yVar != null) {
            yVar.setFromCDN(z);
        }
        k kVar = this.l;
        if (kVar != null) {
            kVar.setFromCDN(z);
        }
        v vVar = this.m;
        if (vVar != null) {
            vVar.setFromCDN(z);
        }
        s sVar = this.n;
        if (sVar != null) {
            sVar.setFromCDN(z);
        }
        j jVar = this.o;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.setFromCDN(z);
        }
        z zVar = this.u;
        if (zVar != null) {
            zVar.setFromCDN(z);
        }
        t tVar = this.w;
        if (tVar != null) {
            tVar.setFromCDN(z);
        }
    }

    public final void t(ArrayList<b.a.e.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                b.a.e.m.e.n nVar = (b.a.e.m.e.n) ListUtils.getItem(arrayList, i2 - 1);
                b.a.e.m.e.n nVar2 = (b.a.e.m.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof c2) {
                    d2 d2Var = ((c2) nVar2).w;
                    if (i2 == 0) {
                        d2Var.isFirstFloor = true;
                    } else {
                        d2Var.isFirstFloor = false;
                    }
                    String recomReason = d2Var.getRecomReason();
                    if (nVar instanceof b.a.r0.x0.u) {
                        d2Var.needTopMargin = false;
                    } else if (nVar != null && !r(nVar)) {
                        d2Var.needTopMargin = false;
                    } else if ((nVar instanceof c2) && r(nVar) && !TextUtils.isEmpty(((c2) nVar).w.getRecomReason())) {
                        d2Var.needTopMargin = true;
                    } else if (r(nVar2) && !TextUtils.isEmpty(recomReason)) {
                        d2Var.needTopMargin = true;
                    } else {
                        d2Var.needTopMargin = false;
                    }
                }
            }
        }
    }

    public final void u(String str) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f28260c) == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f28260c) || this.f28258a == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).r0(this.f28258a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void x() {
        b.a.r0.x0.v2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f28263f == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if ((aVar instanceof b.a.r0.x0.v2.d) && (j = ((b.a.r0.x0.v2.d) aVar).j()) != null) {
                if (this.f28263f.needLog == 1) {
                    j.f27991a = true;
                } else {
                    j.f27991a = false;
                }
                if (this.f28263f.getForum() != null) {
                    j.f27993c = this.f28263f.getForum().getId();
                }
                FrsFragment frsFragment = this.f28258a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.f28258a.getModelController().R();
                    if (R == -1) {
                        R = this.f28258a.getModelController().Q();
                    }
                    j.f27992b = R;
                }
            }
        }
    }

    public final void y(ArrayList<b.a.e.m.e.n> arrayList) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f28260c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<b.a.e.m.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == d2.a3.getId()) {
                i2++;
            }
        }
        for (b.a.e.m.e.a aVar : this.f28260c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).s0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f28263f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f28263f.getForum().getId()) || (d0Var = this.f28266i) == null) {
            return;
        }
        d0Var.y0(this.f28263f.getForum().getId());
    }
}
