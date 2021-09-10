package c.a.r0.w0.n1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
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
    public FrsFragment f27217a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.l.e.s f27218b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f27219c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, d2> f27220d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f27221e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f27222f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27223g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.w0.i f27224h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f27225i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.l.e.a f27226j;
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

    public q(FrsFragment frsFragment, c.a.e.l.e.s sVar, boolean z) {
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
        this.f27219c = new LinkedList();
        this.f27223g = false;
        this.f27218b = sVar;
        this.f27224h = new c.a.r0.w0.i();
        q(frsFragment, sVar);
        this.f27220d = new HashMap<>();
        o(z);
    }

    public final void A(List<c.a.e.l.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).l0(this.f27224h);
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void a(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f27219c) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.a0.z) {
                ((c.a.r0.a0.z) aVar).a(str);
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void b(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).p0(z);
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void c() {
        c.a.e.l.e.s sVar;
        List<c.a.e.l.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f27218b) == null || sVar.getData() == null || this.f27218b.getData().size() == 0 || (data = this.f27218b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.e.l.e.n nVar : data) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.r0() != 0) {
                    d2Var.c3();
                }
            } else if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.c3();
                }
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f27226j != null) {
                return R.id.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void e(c.a.e.l.e.w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).d0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.d0(wVar);
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void f() {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).o(this.f27217a.getPageContext(), this.f27217a.getUniqueId());
            }
        }
        A(this.f27219c);
    }

    @Override // c.a.r0.w0.n1.d.e0
    public List<c.a.e.l.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.e.l.e.s sVar = this.f27218b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void h(ArrayList<c.a.e.l.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            c.a.r0.j3.v.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<c.a.e.l.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.e.l.e.n next = it.next();
                if ((next instanceof c2) && ((c2) next).w.A2()) {
                    it.remove();
                }
            }
            this.f27218b.setData(arrayList);
            this.f27222f = frsViewData;
            x();
            z();
            this.f27221e = arrayList;
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public HashMap<Integer, d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27220d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f27226j != null) {
                return R.id.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f27226j != null) {
                return R.id.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.e.l.e.a aVar : this.f27219c) {
                if (aVar != null && aVar.K() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void m(c.a.r0.w0.f fVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).m0(fVar);
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (c.a.e.l.e.a aVar : this.f27219c) {
                if (aVar instanceof c.a.r0.w0.k) {
                    ((c.a.r0.w0.k) aVar).k0();
                } else if (aVar instanceof c.a.r0.y2.p) {
                    ((c.a.r0.y2.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f27218b.getListAdapter() == null) {
            return;
        }
        this.f27218b.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f27223g == z) {
            return;
        }
        this.f27223g = z;
    }

    public final ArrayList<Integer> p(ArrayList<c.a.e.l.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c.a.e.l.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, d2> hashMap = this.f27220d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f27220d.put(Integer.valueOf(i2), (d2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.f27217a = frsFragment;
            this.f27226j = c.a.r0.w0.e.e().c(frsFragment.getPageContext(), c.a.r0.j3.x.Z3, this.f27217a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), d2.f3, this.f27217a.getUniqueId());
            this.k = yVar;
            yVar.q0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), d2.g3, this.f27217a.getUniqueId());
            this.l = kVar;
            kVar.q0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), d2.i3, this.f27217a.getUniqueId());
            this.m = vVar;
            vVar.q0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), d2.j3, this.f27217a.getUniqueId());
            this.n = sVar2;
            sVar2.q0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), d2.l3, this.f27217a.getUniqueId());
            this.o = jVar;
            jVar.q0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), d2.m3, this.f27217a.getUniqueId());
            this.p = mVar;
            mVar.q0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), d2.r3, this.f27217a.getUniqueId());
            this.r = a0Var;
            a0Var.q0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), d2.K3, this.f27217a.getUniqueId());
            this.q = wVar;
            wVar.q0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), d2.s3, this.f27217a.getUniqueId());
            this.s = uVar;
            uVar.q0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), d2.t3, this.f27217a.getUniqueId());
            this.t = rVar;
            rVar.q0(sVar);
            z zVar = new z(frsFragment.getPageContext(), d2.w3, this.f27217a.getUniqueId());
            this.u = zVar;
            zVar.q0(sVar);
            l lVar = new l(frsFragment.getPageContext(), d2.P3, this.f27217a.getUniqueId());
            this.v = lVar;
            lVar.q0(sVar);
            p pVar = new p(frsFragment.getPageContext(), d2.u3, this.f27217a.getUniqueId());
            pVar.q0(sVar);
            x xVar = new x(frsFragment.getPageContext(), d2.B3, this.f27217a.getUniqueId());
            xVar.q0(sVar);
            a aVar = new a(frsFragment.getPageContext(), d2.o3, frsFragment.getUniqueId());
            aVar.q0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), d2.k3, frsFragment.getUniqueId());
            cVar.q0(sVar);
            b bVar = new b(frsFragment.getPageContext(), d2.D3, this.f27217a.getUniqueId());
            bVar.q0(sVar);
            bVar.T0(true);
            g gVar = new g(frsFragment.getPageContext(), d2.C3, this.f27217a.getUniqueId());
            gVar.q0(sVar);
            gVar.T0(true);
            h hVar = new h(frsFragment.getPageContext(), d2.E3, this.f27217a.getUniqueId());
            hVar.q0(sVar);
            hVar.U0(true);
            z zVar2 = new z(frsFragment.getPageContext(), d2.F3, this.f27217a.getUniqueId());
            zVar2.q0(sVar);
            o oVar = new o(frsFragment.getPageContext(), d2.O3, this.f27217a.getUniqueId());
            oVar.q0(sVar);
            n nVar = new n(frsFragment.getPageContext(), d2.G3, this.f27217a.getUniqueId());
            nVar.q0(sVar);
            this.f27225i = new d0(frsFragment.getPageContext(), c.a.r0.j3.q.f21044g, this.f27217a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), d2.v3, this.f27217a.getUniqueId());
            this.w = tVar;
            tVar.q0(sVar);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = c.a.r0.w0.e.e().a(frsFragment.getPageContext(), this.f27217a.getUniqueId(), true);
            c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.w0.e.e().d(frsFragment.getPageContext(), d2.T3, this.f27217a.getUniqueId());
            c.a.r0.w0.r rVar2 = new c.a.r0.w0.r(frsFragment.getPageContext(), c.a.r0.w0.s.f27756f);
            i iVar = new i(frsFragment.getPageContext(), c.a.r0.w0.u.f27825e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.r0.w0.w.f27905i, this.f27217a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), d2.q3, this.f27217a.getUniqueId());
            eVar.k0((BdTypeRecyclerView) sVar);
            this.f27219c.add(this.f27226j);
            this.f27219c.add(this.k);
            this.f27219c.add(this.l);
            this.f27219c.add(this.m);
            this.f27219c.add(this.n);
            this.f27219c.add(this.o);
            this.f27219c.add(this.p);
            this.f27219c.add(this.q);
            this.f27219c.add(this.r);
            this.f27219c.add(this.s);
            this.f27219c.add(this.t);
            this.f27219c.add(this.f27225i);
            this.f27219c.add(pVar);
            this.f27219c.add(xVar);
            this.f27219c.add(aVar);
            this.f27219c.add(cVar);
            this.f27219c.add(bVar);
            this.f27219c.add(gVar);
            this.f27219c.add(hVar);
            this.f27219c.add(this.w);
            this.f27219c.add(this.u);
            this.f27219c.add(this.v);
            this.f27219c.add(a2);
            this.f27219c.add(d2);
            this.f27219c.add(rVar2);
            this.f27219c.add(iVar);
            this.f27219c.add(oVar);
            this.f27219c.add(nVar);
            this.f27219c.add(frsUserRecommendAdapter);
            this.f27219c.add(zVar2);
            this.f27219c.add(eVar);
            this.f27219c.add(c.a.r0.x0.b.e().b(this.f27217a.getBaseFragmentActivity(), AdvertAppInfo.B4));
            c.a.r0.f.f.b bVar2 = new c.a.r0.f.f.b(this.f27217a, 1);
            bVar2.t(this.f27219c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f27219c);
            sVar.addAdapters(this.f27219c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f27217a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            u("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.e.l.e.a<?, ?> next = it.next();
                if (next instanceof c.a.r0.w0.k) {
                    ((c.a.r0.w0.k) next).o(this.f27217a.getPageContext(), this.f27217a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.e.l.e.a> list = this.f27219c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.e.l.e.s sVar3 = this.f27218b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(c.a.e.l.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == d2.Z2 || type == d2.v3 || type == d2.w3 || type == d2.F3 || type == d2.O3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<c.a.e.l.e.n> arrayList = this.f27221e;
            if (arrayList != null) {
                this.f27218b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.w0.n1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).setFromCDN(z);
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

    public final void t(ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                c.a.e.l.e.n nVar = (c.a.e.l.e.n) ListUtils.getItem(arrayList, i2 - 1);
                c.a.e.l.e.n nVar2 = (c.a.e.l.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof c2) {
                    d2 d2Var = ((c2) nVar2).w;
                    if (i2 == 0) {
                        d2Var.isFirstFloor = true;
                    } else {
                        d2Var.isFirstFloor = false;
                    }
                    String recomReason = d2Var.getRecomReason();
                    if (nVar instanceof c.a.r0.w0.u) {
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
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f27219c) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.r0.o.f) {
                ((c.a.r0.o.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f27219c) || this.f27217a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).s0(this.f27217a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void x() {
        c.a.r0.w0.k2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f27222f == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if ((aVar instanceof c.a.r0.w0.k2.d) && (j2 = ((c.a.r0.w0.k2.d) aVar).j()) != null) {
                if (this.f27222f.needLog == 1) {
                    j2.f26939a = true;
                } else {
                    j2.f26939a = false;
                }
                if (this.f27222f.getForum() != null) {
                    j2.f26941c = this.f27222f.getForum().getId();
                }
                FrsFragment frsFragment = this.f27217a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.f27217a.getModelController().R();
                    if (R == -1) {
                        R = this.f27217a.getModelController().Q();
                    }
                    j2.f26940b = R;
                }
            }
        }
    }

    public final void y(ArrayList<c.a.e.l.e.n> arrayList) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f27219c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.e.l.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == d2.Y2.getId()) {
                i2++;
            }
        }
        for (c.a.e.l.e.a aVar : this.f27219c) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).t0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f27222f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f27222f.getForum().getId()) || (d0Var = this.f27225i) == null) {
            return;
        }
        d0Var.z0(this.f27222f.getForum().getId());
    }
}
