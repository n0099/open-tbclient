package c.a.r0.d1.p1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.o.e.s f15986b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15987c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, e2> f15988d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.d.o.e.n> f15989e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f15990f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15991g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.d1.i f15992h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f15993i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.o.e.a f15994j;
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

    public q(FrsFragment frsFragment, c.a.d.o.e.s sVar, boolean z) {
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
        this.f15987c = new LinkedList();
        this.f15991g = false;
        this.f15986b = sVar;
        this.f15992h = new c.a.r0.d1.i();
        q(frsFragment, sVar);
        this.f15988d = new HashMap<>();
        o(z);
    }

    public final void A(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).d0(this.f15992h);
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void a(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f15987c) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.r0.f0.z) {
                ((c.a.r0.f0.z) aVar).a(str);
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void b(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).h0(z);
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void c() {
        c.a.d.o.e.s sVar;
        List<c.a.d.o.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f15986b) == null || sVar.getData() == null || this.f15986b.getData().size() == 0 || (data = this.f15986b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.d.o.e.n nVar : data) {
            if (nVar instanceof e2) {
                e2 e2Var = (e2) nVar;
                if (e2Var.t0() != 0) {
                    e2Var.h3();
                }
            } else if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.w.t0() != 0) {
                    d2Var.w.h3();
                }
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f15994j != null) {
                return R.id.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void e(c.a.d.o.e.v vVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vVar) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).V(vVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.V(vVar);
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void f() {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).o(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.f15987c);
    }

    @Override // c.a.r0.d1.p1.d.e0
    public List<c.a.d.o.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.d.o.e.s sVar = this.f15986b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void h(ArrayList<c.a.d.o.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            c.a.r0.y3.x.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if ((next instanceof d2) && ((d2) next).w.E2()) {
                    it.remove();
                }
            }
            this.f15986b.setData(arrayList);
            this.f15990f = frsViewData;
            x();
            z();
            this.f15989e = arrayList;
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public HashMap<Integer, e2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15988d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f15994j != null) {
                return R.id.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f15994j != null) {
                return R.id.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.d.o.e.a aVar : this.f15987c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void m(c.a.r0.d1.f fVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).e0(fVar);
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (c.a.d.o.e.a aVar : this.f15987c) {
                if (aVar instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) aVar).c0();
                } else if (aVar instanceof c.a.r0.j3.p) {
                    ((c.a.r0.j3.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f15986b.getListAdapter() == null) {
            return;
        }
        this.f15986b.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f15991g == z) {
            return;
        }
        this.f15991g = z;
    }

    public final ArrayList<Integer> p(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c.a.d.o.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, e2> hashMap = this.f15988d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f15988d.put(Integer.valueOf(i2), (e2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.a = frsFragment;
            this.f15994j = c.a.r0.d1.e.e().c(frsFragment.getPageContext(), c.a.r0.y3.a0.j4, this.a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), e2.p3, this.a.getUniqueId());
            this.k = yVar;
            yVar.i0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), e2.q3, this.a.getUniqueId());
            this.l = kVar;
            kVar.i0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), e2.s3, this.a.getUniqueId());
            this.m = vVar;
            vVar.i0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), e2.t3, this.a.getUniqueId());
            this.n = sVar2;
            sVar2.i0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), e2.w3, this.a.getUniqueId());
            this.o = jVar;
            jVar.i0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), e2.x3, this.a.getUniqueId());
            this.p = mVar;
            mVar.i0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), e2.C3, this.a.getUniqueId());
            this.r = a0Var;
            a0Var.i0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), e2.V3, this.a.getUniqueId());
            this.q = wVar;
            wVar.i0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), e2.D3, this.a.getUniqueId());
            this.s = uVar;
            uVar.i0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), e2.E3, this.a.getUniqueId());
            this.t = rVar;
            rVar.i0(sVar);
            z zVar = new z(frsFragment.getPageContext(), e2.H3, this.a.getUniqueId());
            this.u = zVar;
            zVar.i0(sVar);
            l lVar = new l(frsFragment.getPageContext(), e2.Z3, this.a.getUniqueId());
            this.v = lVar;
            lVar.i0(sVar);
            p pVar = new p(frsFragment.getPageContext(), e2.F3, this.a.getUniqueId());
            pVar.i0(sVar);
            x xVar = new x(frsFragment.getPageContext(), e2.M3, this.a.getUniqueId());
            xVar.i0(sVar);
            a aVar = new a(frsFragment.getPageContext(), e2.z3, frsFragment.getUniqueId());
            aVar.i0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), e2.u3, frsFragment.getUniqueId());
            cVar.i0(sVar);
            b bVar = new b(frsFragment.getPageContext(), e2.O3, this.a.getUniqueId());
            bVar.i0(sVar);
            bVar.L0(true);
            g gVar = new g(frsFragment.getPageContext(), e2.N3, this.a.getUniqueId());
            gVar.i0(sVar);
            gVar.L0(true);
            h hVar = new h(frsFragment.getPageContext(), e2.P3, this.a.getUniqueId());
            hVar.i0(sVar);
            hVar.M0(true);
            z zVar2 = new z(frsFragment.getPageContext(), e2.Q3, this.a.getUniqueId());
            zVar2.i0(sVar);
            o oVar = new o(frsFragment.getPageContext(), e2.Y3, this.a.getUniqueId());
            oVar.i0(sVar);
            n nVar = new n(frsFragment.getPageContext(), e2.R3, this.a.getUniqueId());
            nVar.i0(sVar);
            this.f15993i = new d0(frsFragment.getPageContext(), c.a.r0.y3.s.f25192g, this.a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), e2.G3, this.a.getUniqueId());
            this.w = tVar;
            tVar.i0(sVar);
            c.a.d.o.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> a = c.a.r0.d1.e.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.o.e.a<? extends e2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.d1.e.e().d(frsFragment.getPageContext(), e2.d4, this.a.getUniqueId());
            c.a.r0.d1.r rVar2 = new c.a.r0.d1.r(frsFragment.getPageContext(), c.a.r0.d1.s.f16241f);
            i iVar = new i(frsFragment.getPageContext(), c.a.r0.d1.u.f16490e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.r0.d1.w.f16640i, this.a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), e2.B3, this.a.getUniqueId());
            eVar.c0((BdTypeRecyclerView) sVar);
            this.f15987c.add(this.f15994j);
            this.f15987c.add(this.k);
            this.f15987c.add(this.l);
            this.f15987c.add(this.m);
            this.f15987c.add(this.n);
            this.f15987c.add(this.o);
            this.f15987c.add(this.p);
            this.f15987c.add(this.q);
            this.f15987c.add(this.r);
            this.f15987c.add(this.s);
            this.f15987c.add(this.t);
            this.f15987c.add(this.f15993i);
            this.f15987c.add(pVar);
            this.f15987c.add(xVar);
            this.f15987c.add(aVar);
            this.f15987c.add(cVar);
            this.f15987c.add(bVar);
            this.f15987c.add(gVar);
            this.f15987c.add(hVar);
            this.f15987c.add(this.w);
            this.f15987c.add(this.u);
            this.f15987c.add(this.v);
            this.f15987c.add(a);
            this.f15987c.add(d2);
            this.f15987c.add(rVar2);
            this.f15987c.add(iVar);
            this.f15987c.add(oVar);
            this.f15987c.add(nVar);
            this.f15987c.add(frsUserRecommendAdapter);
            this.f15987c.add(zVar2);
            this.f15987c.add(eVar);
            this.f15987c.add(c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.M4));
            c.a.r0.h.f.b bVar2 = new c.a.r0.h.f.b(this.a, 1);
            bVar2.t(this.f15987c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f15987c);
            sVar.addAdapters(this.f15987c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            u("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<c.a.d.o.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.a<?, ?> next = it.next();
                if (next instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.d.o.e.a> list = this.f15987c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.d.o.e.s sVar3 = this.f15986b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(c.a.d.o.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == e2.j3 || type == e2.G3 || type == e2.H3 || type == e2.Q3 || type == e2.Y3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = this.f15989e;
            if (arrayList != null) {
                this.f15986b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.d1.p1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).setFromCDN(z);
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

    public final void t(ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList, i2 - 1);
                c.a.d.o.e.n nVar2 = (c.a.d.o.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof d2) {
                    e2 e2Var = ((d2) nVar2).w;
                    if (i2 == 0) {
                        e2Var.isFirstFloor = true;
                    } else {
                        e2Var.isFirstFloor = false;
                    }
                    String recomReason = e2Var.getRecomReason();
                    if (nVar instanceof c.a.r0.d1.u) {
                        e2Var.needTopMargin = false;
                    } else if (nVar != null && !r(nVar)) {
                        e2Var.needTopMargin = false;
                    } else if ((nVar instanceof d2) && r(nVar) && !TextUtils.isEmpty(((d2) nVar).w.getRecomReason())) {
                        e2Var.needTopMargin = true;
                    } else if (r(nVar2) && !TextUtils.isEmpty(recomReason)) {
                        e2Var.needTopMargin = true;
                    } else {
                        e2Var.needTopMargin = false;
                    }
                }
            }
        }
    }

    public final void u(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f15987c) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.r0.t.f) {
                ((c.a.r0.t.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f15987c) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void x() {
        c.a.r0.d1.o2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f15990f == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if ((aVar instanceof c.a.r0.d1.o2.d) && (j2 = ((c.a.r0.d1.o2.d) aVar).j()) != null) {
                if (this.f15990f.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f15990f.getForum() != null) {
                    j2.f15918c = this.f15990f.getForum().getId();
                    j2.f15919d = this.f15990f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.a.getModelController().R();
                    if (R == -1) {
                        R = this.a.getModelController().Q();
                    }
                    j2.f15917b = R;
                }
            }
        }
    }

    public final void y(ArrayList<c.a.d.o.e.n> arrayList) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f15987c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == e2.i3.getId()) {
                i2++;
            }
        }
        for (c.a.d.o.e.a aVar : this.f15987c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).l0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f15990f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f15990f.getForum().getId()) || (d0Var = this.f15993i) == null) {
            return;
        }
        d0Var.r0(this.f15990f.getForum().getId());
    }
}
