package c.a.t0.d1.z1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.d1.f1;
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
/* loaded from: classes7.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.n.e.s f16955b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16956c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, e2> f16957d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.d.n.e.n> f16958e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16959f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16960g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.t0.d1.i f16961h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f16962i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.n.e.a f16963j;
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

    public q(FrsFragment frsFragment, c.a.d.n.e.s sVar, boolean z) {
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
        this.f16956c = new LinkedList();
        this.f16960g = false;
        this.f16955b = sVar;
        this.f16961h = new c.a.t0.d1.i();
        q(frsFragment, sVar);
        this.f16957d = new HashMap<>();
        o(z);
    }

    public final void A(List<c.a.d.n.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).d0(this.f16961h);
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void a(String str) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f16956c) == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof c.a.t0.g0.b0) {
                ((c.a.t0.g0.b0) aVar).a(str);
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void b(boolean z) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).h0(z);
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void c() {
        c.a.d.n.e.s sVar;
        List<c.a.d.n.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f16955b) == null || sVar.getData() == null || this.f16955b.getData().size() == 0 || (data = this.f16955b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.d.n.e.n nVar : data) {
            if (nVar instanceof e2) {
                e2 e2Var = (e2) nVar;
                if (e2Var.s0() != 0) {
                    e2Var.g3();
                }
            } else if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.w.s0() != 0) {
                    d2Var.w.g3();
                }
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f16963j != null) {
                return f1.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void e(c.a.d.n.e.w wVar) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).V(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.V(wVar);
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void f() {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).o(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.f16956c);
    }

    @Override // c.a.t0.d1.z1.d.e0
    public List<c.a.d.n.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.d.n.e.s sVar = this.f16955b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void h(ArrayList<c.a.d.n.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            c.a.t0.w3.w.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.n.e.n next = it.next();
                if ((next instanceof d2) && ((d2) next).w.D2()) {
                    it.remove();
                }
            }
            this.f16955b.setData(arrayList);
            this.f16959f = frsViewData;
            x();
            z();
            this.f16958e = arrayList;
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public HashMap<Integer, e2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16957d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f16963j != null) {
                return f1.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f16963j != null) {
                return f1.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.d.n.e.a aVar : this.f16956c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void m(c.a.t0.d1.f fVar) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).e0(fVar);
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (c.a.d.n.e.a aVar : this.f16956c) {
                if (aVar instanceof c.a.t0.d1.k) {
                    ((c.a.t0.d1.k) aVar).c0();
                } else if (aVar instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f16955b.getListAdapter() == null) {
            return;
        }
        this.f16955b.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f16960g == z) {
            return;
        }
        this.f16960g = z;
    }

    public final ArrayList<Integer> p(ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c.a.d.n.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, e2> hashMap = this.f16957d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f16957d.put(Integer.valueOf(i2), (e2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.a = frsFragment;
            this.f16963j = c.a.t0.d1.e.e().c(frsFragment.getPageContext(), c.a.t0.w3.z.i4, this.a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), e2.o3, this.a.getUniqueId());
            this.k = yVar;
            yVar.i0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), e2.p3, this.a.getUniqueId());
            this.l = kVar;
            kVar.i0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), e2.r3, this.a.getUniqueId());
            this.m = vVar;
            vVar.i0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), e2.s3, this.a.getUniqueId());
            this.n = sVar2;
            sVar2.i0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), e2.v3, this.a.getUniqueId());
            this.o = jVar;
            jVar.i0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), e2.w3, this.a.getUniqueId());
            this.p = mVar;
            mVar.i0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), e2.B3, this.a.getUniqueId());
            this.r = a0Var;
            a0Var.i0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), e2.U3, this.a.getUniqueId());
            this.q = wVar;
            wVar.i0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), e2.C3, this.a.getUniqueId());
            this.s = uVar;
            uVar.i0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), e2.D3, this.a.getUniqueId());
            this.t = rVar;
            rVar.i0(sVar);
            z zVar = new z(frsFragment.getPageContext(), e2.G3, this.a.getUniqueId());
            this.u = zVar;
            zVar.i0(sVar);
            l lVar = new l(frsFragment.getPageContext(), e2.Y3, this.a.getUniqueId());
            this.v = lVar;
            lVar.i0(sVar);
            p pVar = new p(frsFragment.getPageContext(), e2.E3, this.a.getUniqueId());
            pVar.i0(sVar);
            x xVar = new x(frsFragment.getPageContext(), e2.L3, this.a.getUniqueId());
            xVar.i0(sVar);
            a aVar = new a(frsFragment.getPageContext(), e2.y3, frsFragment.getUniqueId());
            aVar.i0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), e2.t3, frsFragment.getUniqueId());
            cVar.i0(sVar);
            b bVar = new b(frsFragment.getPageContext(), e2.N3, this.a.getUniqueId());
            bVar.i0(sVar);
            bVar.L0(true);
            g gVar = new g(frsFragment.getPageContext(), e2.M3, this.a.getUniqueId());
            gVar.i0(sVar);
            gVar.L0(true);
            h hVar = new h(frsFragment.getPageContext(), e2.O3, this.a.getUniqueId());
            hVar.i0(sVar);
            hVar.M0(true);
            z zVar2 = new z(frsFragment.getPageContext(), e2.P3, this.a.getUniqueId());
            zVar2.i0(sVar);
            o oVar = new o(frsFragment.getPageContext(), e2.X3, this.a.getUniqueId());
            oVar.i0(sVar);
            n nVar = new n(frsFragment.getPageContext(), e2.Q3, this.a.getUniqueId());
            nVar.i0(sVar);
            this.f16962i = new d0(frsFragment.getPageContext(), c.a.t0.w3.r.f24999g, this.a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), e2.F3, this.a.getUniqueId());
            this.w = tVar;
            tVar.i0(sVar);
            c.a.d.n.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> a = c.a.t0.d1.e.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.n.e.a<? extends e2, ? extends TypeAdapter.ViewHolder> d2 = c.a.t0.d1.e.e().d(frsFragment.getPageContext(), e2.c4, this.a.getUniqueId());
            c.a.t0.d1.r rVar2 = new c.a.t0.d1.r(frsFragment.getPageContext(), c.a.t0.d1.s.f16523f);
            i iVar = new i(frsFragment.getPageContext(), c.a.t0.d1.u.f16640e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.t0.d1.w.f16700i, this.a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), e2.A3, this.a.getUniqueId());
            eVar.c0((BdTypeRecyclerView) sVar);
            this.f16956c.add(this.f16963j);
            this.f16956c.add(this.k);
            this.f16956c.add(this.l);
            this.f16956c.add(this.m);
            this.f16956c.add(this.n);
            this.f16956c.add(this.o);
            this.f16956c.add(this.p);
            this.f16956c.add(this.q);
            this.f16956c.add(this.r);
            this.f16956c.add(this.s);
            this.f16956c.add(this.t);
            this.f16956c.add(this.f16962i);
            this.f16956c.add(pVar);
            this.f16956c.add(xVar);
            this.f16956c.add(aVar);
            this.f16956c.add(cVar);
            this.f16956c.add(bVar);
            this.f16956c.add(gVar);
            this.f16956c.add(hVar);
            this.f16956c.add(this.w);
            this.f16956c.add(this.u);
            this.f16956c.add(this.v);
            this.f16956c.add(a);
            this.f16956c.add(d2);
            this.f16956c.add(rVar2);
            this.f16956c.add(iVar);
            this.f16956c.add(oVar);
            this.f16956c.add(nVar);
            this.f16956c.add(frsUserRecommendAdapter);
            this.f16956c.add(zVar2);
            this.f16956c.add(eVar);
            this.f16956c.add(c.a.t0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4));
            c.a.t0.h.f.b bVar2 = new c.a.t0.h.f.b(this.a, 1);
            bVar2.t(this.f16956c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f16956c);
            sVar.addAdapters(this.f16956c);
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
            Iterator<c.a.d.n.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.d.n.e.a<?, ?> next = it.next();
                if (next instanceof c.a.t0.d1.k) {
                    ((c.a.t0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.d.n.e.a> list = this.f16956c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.d.n.e.s sVar3 = this.f16955b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(c.a.d.n.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == e2.i3 || type == e2.F3 || type == e2.G3 || type == e2.P3 || type == e2.X3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<c.a.d.n.e.n> arrayList = this.f16958e;
            if (arrayList != null) {
                this.f16955b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.t0.d1.z1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).setFromCDN(z);
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

    public final void t(ArrayList<c.a.d.n.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                c.a.d.n.e.n nVar = (c.a.d.n.e.n) ListUtils.getItem(arrayList, i2 - 1);
                c.a.d.n.e.n nVar2 = (c.a.d.n.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof d2) {
                    e2 e2Var = ((d2) nVar2).w;
                    if (i2 == 0) {
                        e2Var.isFirstFloor = true;
                    } else {
                        e2Var.isFirstFloor = false;
                    }
                    String recomReason = e2Var.getRecomReason();
                    if (nVar instanceof c.a.t0.d1.u) {
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
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f16956c) == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof c.a.t0.t.f) {
                ((c.a.t0.t.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f16956c) || this.a == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void x() {
        c.a.t0.d1.w2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f16959f == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if ((aVar instanceof c.a.t0.d1.w2.d) && (j2 = ((c.a.t0.d1.w2.d) aVar).j()) != null) {
                if (this.f16959f.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f16959f.getForum() != null) {
                    j2.f16716c = this.f16959f.getForum().getId();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.a.getModelController().R();
                    if (R == -1) {
                        R = this.a.getModelController().Q();
                    }
                    j2.f16715b = R;
                }
            }
        }
    }

    public final void y(ArrayList<c.a.d.n.e.n> arrayList) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f16956c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == e2.h3.getId()) {
                i2++;
            }
        }
        for (c.a.d.n.e.a aVar : this.f16956c) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).l0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f16959f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f16959f.getForum().getId()) || (d0Var = this.f16962i) == null) {
            return;
        }
        d0Var.r0(this.f16959f.getForum().getId());
    }
}
