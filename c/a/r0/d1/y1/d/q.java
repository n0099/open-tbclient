package c.a.r0.d1.y1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.f1;
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
/* loaded from: classes5.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.m.e.s f16318b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f16319c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, d2> f16320d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.d.m.e.n> f16321e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f16322f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16323g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.d1.i f16324h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f16325i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.m.e.a f16326j;

    /* renamed from: k  reason: collision with root package name */
    public y f16327k;
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

    public q(FrsFragment frsFragment, c.a.d.m.e.s sVar, boolean z) {
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
        this.f16319c = new LinkedList();
        this.f16323g = false;
        this.f16318b = sVar;
        this.f16324h = new c.a.r0.d1.i();
        q(frsFragment, sVar);
        this.f16320d = new HashMap<>();
        o(z);
    }

    public final void A(List<c.a.d.m.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).k0(this.f16324h);
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void a(String str) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f16319c) == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof c.a.r0.g0.b0) {
                ((c.a.r0.g0.b0) aVar).a(str);
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void b(boolean z) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).o0(z);
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void c() {
        c.a.d.m.e.s sVar;
        List<c.a.d.m.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f16318b) == null || sVar.getData() == null || this.f16318b.getData().size() == 0 || (data = this.f16318b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.d.m.e.n nVar : data) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.s0() != 0) {
                    d2Var.g3();
                }
            } else if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.s0() != 0) {
                    c2Var.w.g3();
                }
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f16326j != null) {
                return f1.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void e(c.a.d.m.e.w wVar) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).c0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.c0(wVar);
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void f() {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).o(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.f16319c);
    }

    @Override // c.a.r0.d1.y1.d.e0
    public List<c.a.d.m.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.d.m.e.s sVar = this.f16318b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void h(ArrayList<c.a.d.m.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            c.a.r0.t3.w.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<c.a.d.m.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.m.e.n next = it.next();
                if ((next instanceof c2) && ((c2) next).w.D2()) {
                    it.remove();
                }
            }
            this.f16318b.setData(arrayList);
            this.f16322f = frsViewData;
            x();
            z();
            this.f16321e = arrayList;
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public HashMap<Integer, d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16320d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f16326j != null) {
                return f1.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f16326j != null) {
                return f1.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.d.m.e.a aVar : this.f16319c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void m(c.a.r0.d1.f fVar) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).l0(fVar);
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (c.a.d.m.e.a aVar : this.f16319c) {
                if (aVar instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) aVar).j0();
                } else if (aVar instanceof c.a.r0.h3.p) {
                    ((c.a.r0.h3.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f16318b.getListAdapter() == null) {
            return;
        }
        this.f16318b.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f16323g == z) {
            return;
        }
        this.f16323g = z;
    }

    public final ArrayList<Integer> p(ArrayList<c.a.d.m.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                c.a.d.m.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, d2> hashMap = this.f16320d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f16320d.put(Integer.valueOf(i2), (d2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, c.a.d.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.a = frsFragment;
            this.f16326j = c.a.r0.d1.e.e().c(frsFragment.getPageContext(), c.a.r0.t3.z.f4, this.a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), d2.l3, this.a.getUniqueId());
            this.f16327k = yVar;
            yVar.p0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), d2.m3, this.a.getUniqueId());
            this.l = kVar;
            kVar.p0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), d2.o3, this.a.getUniqueId());
            this.m = vVar;
            vVar.p0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), d2.p3, this.a.getUniqueId());
            this.n = sVar2;
            sVar2.p0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), d2.s3, this.a.getUniqueId());
            this.o = jVar;
            jVar.p0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), d2.t3, this.a.getUniqueId());
            this.p = mVar;
            mVar.p0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), d2.y3, this.a.getUniqueId());
            this.r = a0Var;
            a0Var.p0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), d2.R3, this.a.getUniqueId());
            this.q = wVar;
            wVar.p0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), d2.z3, this.a.getUniqueId());
            this.s = uVar;
            uVar.p0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), d2.A3, this.a.getUniqueId());
            this.t = rVar;
            rVar.p0(sVar);
            z zVar = new z(frsFragment.getPageContext(), d2.D3, this.a.getUniqueId());
            this.u = zVar;
            zVar.p0(sVar);
            l lVar = new l(frsFragment.getPageContext(), d2.V3, this.a.getUniqueId());
            this.v = lVar;
            lVar.p0(sVar);
            p pVar = new p(frsFragment.getPageContext(), d2.B3, this.a.getUniqueId());
            pVar.p0(sVar);
            x xVar = new x(frsFragment.getPageContext(), d2.I3, this.a.getUniqueId());
            xVar.p0(sVar);
            a aVar = new a(frsFragment.getPageContext(), d2.v3, frsFragment.getUniqueId());
            aVar.p0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), d2.q3, frsFragment.getUniqueId());
            cVar.p0(sVar);
            b bVar = new b(frsFragment.getPageContext(), d2.K3, this.a.getUniqueId());
            bVar.p0(sVar);
            bVar.S0(true);
            g gVar = new g(frsFragment.getPageContext(), d2.J3, this.a.getUniqueId());
            gVar.p0(sVar);
            gVar.S0(true);
            h hVar = new h(frsFragment.getPageContext(), d2.L3, this.a.getUniqueId());
            hVar.p0(sVar);
            hVar.T0(true);
            z zVar2 = new z(frsFragment.getPageContext(), d2.M3, this.a.getUniqueId());
            zVar2.p0(sVar);
            o oVar = new o(frsFragment.getPageContext(), d2.U3, this.a.getUniqueId());
            oVar.p0(sVar);
            n nVar = new n(frsFragment.getPageContext(), d2.N3, this.a.getUniqueId());
            nVar.p0(sVar);
            this.f16325i = new d0(frsFragment.getPageContext(), c.a.r0.t3.r.f23978g, this.a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), d2.C3, this.a.getUniqueId());
            this.w = tVar;
            tVar.p0(sVar);
            c.a.d.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a = c.a.r0.d1.e.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.d1.e.e().d(frsFragment.getPageContext(), d2.Z3, this.a.getUniqueId());
            c.a.r0.d1.r rVar2 = new c.a.r0.d1.r(frsFragment.getPageContext(), c.a.r0.d1.s.f15942f);
            i iVar = new i(frsFragment.getPageContext(), c.a.r0.d1.u.f16022e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.r0.d1.w.f16097i, this.a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), d2.x3, this.a.getUniqueId());
            eVar.j0((BdTypeRecyclerView) sVar);
            this.f16319c.add(this.f16326j);
            this.f16319c.add(this.f16327k);
            this.f16319c.add(this.l);
            this.f16319c.add(this.m);
            this.f16319c.add(this.n);
            this.f16319c.add(this.o);
            this.f16319c.add(this.p);
            this.f16319c.add(this.q);
            this.f16319c.add(this.r);
            this.f16319c.add(this.s);
            this.f16319c.add(this.t);
            this.f16319c.add(this.f16325i);
            this.f16319c.add(pVar);
            this.f16319c.add(xVar);
            this.f16319c.add(aVar);
            this.f16319c.add(cVar);
            this.f16319c.add(bVar);
            this.f16319c.add(gVar);
            this.f16319c.add(hVar);
            this.f16319c.add(this.w);
            this.f16319c.add(this.u);
            this.f16319c.add(this.v);
            this.f16319c.add(a);
            this.f16319c.add(d2);
            this.f16319c.add(rVar2);
            this.f16319c.add(iVar);
            this.f16319c.add(oVar);
            this.f16319c.add(nVar);
            this.f16319c.add(frsUserRecommendAdapter);
            this.f16319c.add(zVar2);
            this.f16319c.add(eVar);
            this.f16319c.add(c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.I4));
            c.a.r0.h.f.b bVar2 = new c.a.r0.h.f.b(this.a, 1);
            bVar2.t(this.f16319c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f16319c);
            sVar.addAdapters(this.f16319c);
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
            Iterator<c.a.d.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.d.m.e.a<?, ?> next = it.next();
                if (next instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.d.m.e.a> list = this.f16319c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.d.m.e.s sVar3 = this.f16318b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(c.a.d.m.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == d2.f3 || type == d2.C3 || type == d2.D3 || type == d2.M3 || type == d2.U3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<c.a.d.m.e.n> arrayList = this.f16321e;
            if (arrayList != null) {
                this.f16318b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.d1.y1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).setFromCDN(z);
            }
        }
        y yVar = this.f16327k;
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

    public final void t(ArrayList<c.a.d.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                c.a.d.m.e.n nVar = (c.a.d.m.e.n) ListUtils.getItem(arrayList, i2 - 1);
                c.a.d.m.e.n nVar2 = (c.a.d.m.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof c2) {
                    d2 d2Var = ((c2) nVar2).w;
                    if (i2 == 0) {
                        d2Var.isFirstFloor = true;
                    } else {
                        d2Var.isFirstFloor = false;
                    }
                    String recomReason = d2Var.getRecomReason();
                    if (nVar instanceof c.a.r0.d1.u) {
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
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f16319c) == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof c.a.r0.t.f) {
                ((c.a.r0.t.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f16319c) || this.a == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).r0(this.a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void x() {
        c.a.r0.d1.v2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f16322f == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if ((aVar instanceof c.a.r0.d1.v2.d) && (j2 = ((c.a.r0.d1.v2.d) aVar).j()) != null) {
                if (this.f16322f.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f16322f.getForum() != null) {
                    j2.f16084c = this.f16322f.getForum().getId();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.a.getModelController().R();
                    if (R == -1) {
                        R = this.a.getModelController().Q();
                    }
                    j2.f16083b = R;
                }
            }
        }
    }

    public final void y(ArrayList<c.a.d.m.e.n> arrayList) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f16319c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.d.m.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == d2.e3.getId()) {
                i2++;
            }
        }
        for (c.a.d.m.e.a aVar : this.f16319c) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).s0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f16322f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f16322f.getForum().getId()) || (d0Var = this.f16325i) == null) {
            return;
        }
        d0Var.y0(this.f16322f.getForum().getId());
    }
}
