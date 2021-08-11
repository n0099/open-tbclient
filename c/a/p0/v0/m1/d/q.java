package c.a.p0.v0.m1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
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
/* loaded from: classes4.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26121a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.k.e.s f26122b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f26123c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, c2> f26124d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.e.k.e.n> f26125e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f26126f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26127g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.v0.i f26128h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f26129i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.k.e.a f26130j;
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

    public q(FrsFragment frsFragment, c.a.e.k.e.s sVar, boolean z) {
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
        this.f26123c = new LinkedList();
        this.f26127g = false;
        this.f26122b = sVar;
        this.f26128h = new c.a.p0.v0.i();
        q(frsFragment, sVar);
        this.f26124d = new HashMap<>();
        o(z);
    }

    public final void A(List<c.a.e.k.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : list) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).l0(this.f26128h);
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void a(String str) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f26123c) == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : list) {
            if (aVar instanceof c.a.p0.a0.z) {
                ((c.a.p0.a0.z) aVar).a(str);
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void b(boolean z) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).p0(z);
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void c() {
        c.a.e.k.e.s sVar;
        List<c.a.e.k.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f26122b) == null || sVar.getData() == null || this.f26122b.getData().size() == 0 || (data = this.f26122b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.e.k.e.n nVar : data) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.p0() != 0) {
                    c2Var.W2();
                }
            } else if (nVar instanceof b2) {
                b2 b2Var = (b2) nVar;
                if (b2Var.w.p0() != 0) {
                    b2Var.w.W2();
                }
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f26130j != null) {
                return R.id.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void e(c.a.e.k.e.w wVar) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).d0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.d0(wVar);
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void f() {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).o(this.f26121a.getPageContext(), this.f26121a.getUniqueId());
            }
        }
        A(this.f26123c);
    }

    @Override // c.a.p0.v0.m1.d.e0
    public List<c.a.e.k.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.e.k.e.s sVar = this.f26122b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void h(ArrayList<c.a.e.k.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            c.a.p0.i3.v.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<c.a.e.k.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.e.k.e.n next = it.next();
                if ((next instanceof b2) && ((b2) next).w.w2()) {
                    it.remove();
                }
            }
            this.f26122b.setData(arrayList);
            this.f26126f = frsViewData;
            x();
            z();
            this.f26125e = arrayList;
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public HashMap<Integer, c2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26124d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f26130j != null) {
                return R.id.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f26130j != null) {
                return R.id.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.e.k.e.a aVar : this.f26123c) {
                if (aVar != null && aVar.K() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void m(c.a.p0.v0.f fVar) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).m0(fVar);
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (c.a.e.k.e.a aVar : this.f26123c) {
                if (aVar instanceof c.a.p0.v0.k) {
                    ((c.a.p0.v0.k) aVar).k0();
                } else if (aVar instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f26122b.getListAdapter() == null) {
            return;
        }
        this.f26122b.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f26127g == z) {
            return;
        }
        this.f26127g = z;
    }

    public final ArrayList<Integer> p(ArrayList<c.a.e.k.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c.a.e.k.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, c2> hashMap = this.f26124d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f26124d.put(Integer.valueOf(i2), (c2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, c.a.e.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.f26121a = frsFragment;
            this.f26130j = c.a.p0.v0.e.e().c(frsFragment.getPageContext(), c.a.p0.i3.x.W3, this.f26121a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), c2.c3, this.f26121a.getUniqueId());
            this.k = yVar;
            yVar.q0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), c2.d3, this.f26121a.getUniqueId());
            this.l = kVar;
            kVar.q0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), c2.f3, this.f26121a.getUniqueId());
            this.m = vVar;
            vVar.q0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), c2.g3, this.f26121a.getUniqueId());
            this.n = sVar2;
            sVar2.q0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), c2.i3, this.f26121a.getUniqueId());
            this.o = jVar;
            jVar.q0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), c2.j3, this.f26121a.getUniqueId());
            this.p = mVar;
            mVar.q0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), c2.o3, this.f26121a.getUniqueId());
            this.r = a0Var;
            a0Var.q0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), c2.H3, this.f26121a.getUniqueId());
            this.q = wVar;
            wVar.q0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), c2.p3, this.f26121a.getUniqueId());
            this.s = uVar;
            uVar.q0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), c2.q3, this.f26121a.getUniqueId());
            this.t = rVar;
            rVar.q0(sVar);
            z zVar = new z(frsFragment.getPageContext(), c2.t3, this.f26121a.getUniqueId());
            this.u = zVar;
            zVar.q0(sVar);
            l lVar = new l(frsFragment.getPageContext(), c2.M3, this.f26121a.getUniqueId());
            this.v = lVar;
            lVar.q0(sVar);
            p pVar = new p(frsFragment.getPageContext(), c2.r3, this.f26121a.getUniqueId());
            pVar.q0(sVar);
            x xVar = new x(frsFragment.getPageContext(), c2.y3, this.f26121a.getUniqueId());
            xVar.q0(sVar);
            a aVar = new a(frsFragment.getPageContext(), c2.l3, frsFragment.getUniqueId());
            aVar.q0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), c2.h3, frsFragment.getUniqueId());
            cVar.q0(sVar);
            b bVar = new b(frsFragment.getPageContext(), c2.A3, this.f26121a.getUniqueId());
            bVar.q0(sVar);
            bVar.T0(true);
            g gVar = new g(frsFragment.getPageContext(), c2.z3, this.f26121a.getUniqueId());
            gVar.q0(sVar);
            gVar.T0(true);
            h hVar = new h(frsFragment.getPageContext(), c2.B3, this.f26121a.getUniqueId());
            hVar.q0(sVar);
            hVar.U0(true);
            z zVar2 = new z(frsFragment.getPageContext(), c2.C3, this.f26121a.getUniqueId());
            zVar2.q0(sVar);
            o oVar = new o(frsFragment.getPageContext(), c2.L3, this.f26121a.getUniqueId());
            oVar.q0(sVar);
            n nVar = new n(frsFragment.getPageContext(), c2.D3, this.f26121a.getUniqueId());
            nVar.q0(sVar);
            this.f26129i = new d0(frsFragment.getPageContext(), c.a.p0.i3.q.f20148g, this.f26121a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), c2.s3, this.f26121a.getUniqueId());
            this.w = tVar;
            tVar.q0(sVar);
            c.a.e.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> a2 = c.a.p0.v0.e.e().a(frsFragment.getPageContext(), this.f26121a.getUniqueId(), true);
            c.a.e.k.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> d2 = c.a.p0.v0.e.e().d(frsFragment.getPageContext(), c2.Q3, this.f26121a.getUniqueId());
            c.a.p0.v0.r rVar2 = new c.a.p0.v0.r(frsFragment.getPageContext(), c.a.p0.v0.s.f26816f);
            i iVar = new i(frsFragment.getPageContext(), c.a.p0.v0.u.f26860e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.p0.v0.w.f26967i, this.f26121a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), c2.n3, this.f26121a.getUniqueId());
            eVar.k0((BdTypeRecyclerView) sVar);
            this.f26123c.add(this.f26130j);
            this.f26123c.add(this.k);
            this.f26123c.add(this.l);
            this.f26123c.add(this.m);
            this.f26123c.add(this.n);
            this.f26123c.add(this.o);
            this.f26123c.add(this.p);
            this.f26123c.add(this.q);
            this.f26123c.add(this.r);
            this.f26123c.add(this.s);
            this.f26123c.add(this.t);
            this.f26123c.add(this.f26129i);
            this.f26123c.add(pVar);
            this.f26123c.add(xVar);
            this.f26123c.add(aVar);
            this.f26123c.add(cVar);
            this.f26123c.add(bVar);
            this.f26123c.add(gVar);
            this.f26123c.add(hVar);
            this.f26123c.add(this.w);
            this.f26123c.add(this.u);
            this.f26123c.add(this.v);
            this.f26123c.add(a2);
            this.f26123c.add(d2);
            this.f26123c.add(rVar2);
            this.f26123c.add(iVar);
            this.f26123c.add(oVar);
            this.f26123c.add(nVar);
            this.f26123c.add(frsUserRecommendAdapter);
            this.f26123c.add(zVar2);
            this.f26123c.add(eVar);
            this.f26123c.add(c.a.p0.w0.b.e().b(this.f26121a.getBaseFragmentActivity(), AdvertAppInfo.y4));
            c.a.p0.f.f.b bVar2 = new c.a.p0.f.f.b(this.f26121a, 1);
            bVar2.t(this.f26123c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f26123c);
            sVar.addAdapters(this.f26123c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f26121a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            u("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<c.a.e.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.e.k.e.a<?, ?> next = it.next();
                if (next instanceof c.a.p0.v0.k) {
                    ((c.a.p0.v0.k) next).o(this.f26121a.getPageContext(), this.f26121a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.e.k.e.a> list = this.f26123c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.e.k.e.s sVar3 = this.f26122b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(c.a.e.k.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == c2.W2 || type == c2.s3 || type == c2.t3 || type == c2.C3 || type == c2.L3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<c.a.e.k.e.n> arrayList = this.f26125e;
            if (arrayList != null) {
                this.f26122b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.p0.v0.m1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).setFromCDN(z);
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

    public final void t(ArrayList<c.a.e.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                c.a.e.k.e.n nVar = (c.a.e.k.e.n) ListUtils.getItem(arrayList, i2 - 1);
                c.a.e.k.e.n nVar2 = (c.a.e.k.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof b2) {
                    c2 c2Var = ((b2) nVar2).w;
                    if (i2 == 0) {
                        c2Var.isFirstFloor = true;
                    } else {
                        c2Var.isFirstFloor = false;
                    }
                    String recomReason = c2Var.getRecomReason();
                    if (nVar instanceof c.a.p0.v0.u) {
                        c2Var.needTopMargin = false;
                    } else if (nVar != null && !r(nVar)) {
                        c2Var.needTopMargin = false;
                    } else if ((nVar instanceof b2) && r(nVar) && !TextUtils.isEmpty(((b2) nVar).w.getRecomReason())) {
                        c2Var.needTopMargin = true;
                    } else if (r(nVar2) && !TextUtils.isEmpty(recomReason)) {
                        c2Var.needTopMargin = true;
                    } else {
                        c2Var.needTopMargin = false;
                    }
                }
            }
        }
    }

    public final void u(String str) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f26123c) == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : list) {
            if (aVar instanceof c.a.p0.o.f) {
                ((c.a.p0.o.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f26123c) || this.f26121a == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).s0(this.f26121a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void x() {
        c.a.p0.v0.j2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f26126f == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if ((aVar instanceof c.a.p0.v0.j2.d) && (j2 = ((c.a.p0.v0.j2.d) aVar).j()) != null) {
                if (this.f26126f.needLog == 1) {
                    j2.f25937a = true;
                } else {
                    j2.f25937a = false;
                }
                if (this.f26126f.getForum() != null) {
                    j2.f25939c = this.f26126f.getForum().getId();
                }
                FrsFragment frsFragment = this.f26121a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.f26121a.getModelController().R();
                    if (R == -1) {
                        R = this.f26121a.getModelController().Q();
                    }
                    j2.f25938b = R;
                }
            }
        }
    }

    public final void y(ArrayList<c.a.e.k.e.n> arrayList) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f26123c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.e.k.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == c2.V2.getId()) {
                i2++;
            }
        }
        for (c.a.e.k.e.a aVar : this.f26123c) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).t0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f26126f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f26126f.getForum().getId()) || (d0Var = this.f26129i) == null) {
            return;
        }
        d0Var.z0(this.f26126f.getForum().getId());
    }
}
