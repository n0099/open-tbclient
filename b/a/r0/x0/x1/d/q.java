package b.a.r0.x0.x1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.e1;
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

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26663a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.e.l.e.s f26664b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.a> f26665c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, d2> f26666d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b.a.e.l.e.n> f26667e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f26668f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26669g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.r0.x0.i f26670h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f26671i;
    public b.a.e.l.e.a j;
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

    public q(FrsFragment frsFragment, b.a.e.l.e.s sVar, boolean z) {
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
        this.f26665c = new LinkedList();
        this.f26669g = false;
        this.f26664b = sVar;
        this.f26670h = new b.a.r0.x0.i();
        q(frsFragment, sVar);
        this.f26666d = new HashMap<>();
        o(z);
    }

    public final void A(List<b.a.e.l.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).k0(this.f26670h);
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void a(String str) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.f26665c) == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.b0.a0) {
                ((b.a.r0.b0.a0) aVar).a(str);
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void b(boolean z) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).o0(z);
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void c() {
        b.a.e.l.e.s sVar;
        List<b.a.e.l.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (sVar = this.f26664b) == null || sVar.getData() == null || this.f26664b.getData().size() == 0 || (data = this.f26664b.getData()) == null || data.size() == 0) {
            return;
        }
        for (b.a.e.l.e.n nVar : data) {
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

    @Override // b.a.r0.x0.x1.d.e0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.j != null) {
                return e1.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void e(b.a.e.l.e.w wVar) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).c0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.c0(wVar);
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void f() {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).o(this.f26663a.getPageContext(), this.f26663a.getUniqueId());
            }
        }
        A(this.f26665c);
    }

    @Override // b.a.r0.x0.x1.d.e0
    public List<b.a.e.l.e.n> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.e.l.e.s sVar = this.f26664b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void h(ArrayList<b.a.e.l.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            b.a.r0.l3.w.f(arrayList, 1);
            p(arrayList);
            y(arrayList);
            t(arrayList);
            Iterator<b.a.e.l.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.e.l.e.n next = it.next();
                if ((next instanceof c2) && ((c2) next).w.A2()) {
                    it.remove();
                }
            }
            this.f26664b.setData(arrayList);
            this.f26668f = frsViewData;
            x();
            z();
            this.f26667e = arrayList;
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public HashMap<Integer, d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26666d : (HashMap) invokeV.objValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null) {
                return e1.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j != null) {
                return e1.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public boolean l(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (b.a.e.l.e.a aVar : this.f26665c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void m(b.a.r0.x0.f fVar) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).l0(fVar);
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (b.a.e.l.e.a aVar : this.f26665c) {
                if (aVar instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) aVar).j0();
                } else if (aVar instanceof b.a.r0.z2.p) {
                    ((b.a.r0.z2.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f26664b.getListAdapter() == null) {
            return;
        }
        this.f26664b.getListAdapter().notifyDataSetChanged();
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.f26669g == z) {
            return;
        }
        this.f26669g = z;
    }

    public final ArrayList<Integer> p(ArrayList<b.a.e.l.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                b.a.e.l.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, d2> hashMap = this.f26666d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f26666d.put(Integer.valueOf(i2), (d2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void q(FrsFragment frsFragment, b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, frsFragment, sVar) == null) {
            this.f26663a = frsFragment;
            this.j = b.a.r0.x0.e.e().c(frsFragment.getPageContext(), b.a.r0.l3.z.a4, this.f26663a.getUniqueId(), false);
            y yVar = new y(frsFragment.getTbPageContext(), d2.g3, this.f26663a.getUniqueId());
            this.k = yVar;
            yVar.p0(sVar);
            k kVar = new k(frsFragment.getTbPageContext(), d2.h3, this.f26663a.getUniqueId());
            this.l = kVar;
            kVar.p0(sVar);
            v vVar = new v(frsFragment.getTbPageContext(), d2.j3, this.f26663a.getUniqueId());
            this.m = vVar;
            vVar.p0(sVar);
            s sVar2 = new s(frsFragment.getTbPageContext(), d2.k3, this.f26663a.getUniqueId());
            this.n = sVar2;
            sVar2.p0(sVar);
            j jVar = new j(frsFragment.getTbPageContext(), d2.m3, this.f26663a.getUniqueId());
            this.o = jVar;
            jVar.p0(sVar);
            m mVar = new m(frsFragment.getTbPageContext(), d2.n3, this.f26663a.getUniqueId());
            this.p = mVar;
            mVar.p0(sVar);
            a0 a0Var = new a0(frsFragment.getTbPageContext(), d2.s3, this.f26663a.getUniqueId());
            this.r = a0Var;
            a0Var.p0(sVar);
            w wVar = new w(frsFragment.getTbPageContext(), d2.L3, this.f26663a.getUniqueId());
            this.q = wVar;
            wVar.p0(sVar);
            u uVar = new u(frsFragment.getTbPageContext(), d2.t3, this.f26663a.getUniqueId());
            this.s = uVar;
            uVar.p0(sVar);
            r rVar = new r(frsFragment.getTbPageContext(), d2.u3, this.f26663a.getUniqueId());
            this.t = rVar;
            rVar.p0(sVar);
            z zVar = new z(frsFragment.getPageContext(), d2.x3, this.f26663a.getUniqueId());
            this.u = zVar;
            zVar.p0(sVar);
            l lVar = new l(frsFragment.getPageContext(), d2.Q3, this.f26663a.getUniqueId());
            this.v = lVar;
            lVar.p0(sVar);
            p pVar = new p(frsFragment.getPageContext(), d2.v3, this.f26663a.getUniqueId());
            pVar.p0(sVar);
            x xVar = new x(frsFragment.getPageContext(), d2.C3, this.f26663a.getUniqueId());
            xVar.p0(sVar);
            a aVar = new a(frsFragment.getPageContext(), d2.p3, frsFragment.getUniqueId());
            aVar.p0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), d2.l3, frsFragment.getUniqueId());
            cVar.p0(sVar);
            b bVar = new b(frsFragment.getPageContext(), d2.E3, this.f26663a.getUniqueId());
            bVar.p0(sVar);
            bVar.S0(true);
            g gVar = new g(frsFragment.getPageContext(), d2.D3, this.f26663a.getUniqueId());
            gVar.p0(sVar);
            gVar.S0(true);
            h hVar = new h(frsFragment.getPageContext(), d2.F3, this.f26663a.getUniqueId());
            hVar.p0(sVar);
            hVar.T0(true);
            z zVar2 = new z(frsFragment.getPageContext(), d2.G3, this.f26663a.getUniqueId());
            zVar2.p0(sVar);
            o oVar = new o(frsFragment.getPageContext(), d2.P3, this.f26663a.getUniqueId());
            oVar.p0(sVar);
            n nVar = new n(frsFragment.getPageContext(), d2.H3, this.f26663a.getUniqueId());
            nVar.p0(sVar);
            this.f26671i = new d0(frsFragment.getPageContext(), b.a.r0.l3.r.f20803g, this.f26663a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), d2.w3, this.f26663a.getUniqueId());
            this.w = tVar;
            tVar.p0(sVar);
            b.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = b.a.r0.x0.e.e().a(frsFragment.getPageContext(), this.f26663a.getUniqueId(), true);
            b.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = b.a.r0.x0.e.e().d(frsFragment.getPageContext(), d2.U3, this.f26663a.getUniqueId());
            b.a.r0.x0.r rVar2 = new b.a.r0.x0.r(frsFragment.getPageContext(), b.a.r0.x0.s.f26311f);
            i iVar = new i(frsFragment.getPageContext(), b.a.r0.x0.u.f26361e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), b.a.r0.x0.w.f26491i, this.f26663a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), d2.r3, this.f26663a.getUniqueId());
            eVar.j0((BdTypeRecyclerView) sVar);
            this.f26665c.add(this.j);
            this.f26665c.add(this.k);
            this.f26665c.add(this.l);
            this.f26665c.add(this.m);
            this.f26665c.add(this.n);
            this.f26665c.add(this.o);
            this.f26665c.add(this.p);
            this.f26665c.add(this.q);
            this.f26665c.add(this.r);
            this.f26665c.add(this.s);
            this.f26665c.add(this.t);
            this.f26665c.add(this.f26671i);
            this.f26665c.add(pVar);
            this.f26665c.add(xVar);
            this.f26665c.add(aVar);
            this.f26665c.add(cVar);
            this.f26665c.add(bVar);
            this.f26665c.add(gVar);
            this.f26665c.add(hVar);
            this.f26665c.add(this.w);
            this.f26665c.add(this.u);
            this.f26665c.add(this.v);
            this.f26665c.add(a2);
            this.f26665c.add(d2);
            this.f26665c.add(rVar2);
            this.f26665c.add(iVar);
            this.f26665c.add(oVar);
            this.f26665c.add(nVar);
            this.f26665c.add(frsUserRecommendAdapter);
            this.f26665c.add(zVar2);
            this.f26665c.add(eVar);
            this.f26665c.add(b.a.r0.y0.b.e().b(this.f26663a.getBaseFragmentActivity(), AdvertAppInfo.C4));
            b.a.r0.g.f.b bVar2 = new b.a.r0.g.f.b(this.f26663a, 1);
            bVar2.t(this.f26665c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            A(this.f26665c);
            sVar.addAdapters(this.f26665c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f26663a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            u("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<b.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                b.a.e.l.e.a<?, ?> next = it.next();
                if (next instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) next).o(this.f26663a.getPageContext(), this.f26663a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<b.a.e.l.e.a> list = this.f26665c;
            if (list != null) {
                list.addAll(arrayList);
            }
            b.a.e.l.e.s sVar3 = this.f26664b;
            if (sVar3 != null) {
                sVar3.addAdapters(arrayList);
            }
        }
    }

    public final boolean r(b.a.e.l.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == d2.a3 || type == d2.w3 || type == d2.x3 || type == d2.G3 || type == d2.P3;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ArrayList<b.a.e.l.e.n> arrayList = this.f26667e;
            if (arrayList != null) {
                this.f26664b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // b.a.r0.x0.x1.d.e0
    public void setFromCDN(boolean z) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
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

    public final void t(ArrayList<b.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                b.a.e.l.e.n nVar = (b.a.e.l.e.n) ListUtils.getItem(arrayList, i2 - 1);
                b.a.e.l.e.n nVar2 = (b.a.e.l.e.n) ListUtils.getItem(arrayList, i2);
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
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.f26665c) == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.f26665c) || this.f26663a == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).r0(this.f26663a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void x() {
        b.a.r0.x0.u2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f26668f == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if ((aVar instanceof b.a.r0.x0.u2.d) && (j = ((b.a.r0.x0.u2.d) aVar).j()) != null) {
                if (this.f26668f.needLog == 1) {
                    j.f26385a = true;
                } else {
                    j.f26385a = false;
                }
                if (this.f26668f.getForum() != null) {
                    j.f26387c = this.f26668f.getForum().getId();
                }
                FrsFragment frsFragment = this.f26663a;
                if (frsFragment != null && frsFragment.getModelController() != null) {
                    int R = this.f26663a.getModelController().R();
                    if (R == -1) {
                        R = this.f26663a.getModelController().Q();
                    }
                    j.f26386b = R;
                }
            }
        }
    }

    public final void y(ArrayList<b.a.e.l.e.n> arrayList) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.f26665c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<b.a.e.l.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == d2.Z2.getId()) {
                i2++;
            }
        }
        for (b.a.e.l.e.a aVar : this.f26665c) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).s0(i2);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f26668f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f26668f.getForum().getId()) || (d0Var = this.f26671i) == null) {
            return;
        }
        d0Var.y0(this.f26668f.getForum().getId());
    }
}
