package c.a.t0.e1.r2;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.e1.z1.d.a0;
import c.a.t0.e1.z1.d.p;
import c.a.t0.e1.z1.d.r;
import c.a.t0.e1.z1.d.s;
import c.a.t0.e1.z1.d.t;
import c.a.t0.e1.z1.d.u;
import c.a.t0.e1.z1.d.v;
import c.a.t0.e1.z1.d.x;
import c.a.t0.e1.z1.d.y;
import c.a.t0.e1.z1.d.z;
import c.a.t0.x3.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16820b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16821c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16822d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, e2> f16823e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.d.n.e.n> f16824f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f16825g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f16826h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f16821c)) {
                f fVar = this.a;
                fVar.g(fVar.f16820b);
                f fVar2 = this.a;
                fVar2.q(fVar2.f16824f, this.a.f16825g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16822d = new LinkedList();
        this.f16826h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f16820b = bdTypeRecyclerView;
        this.f16823e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f16826h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f16821c = new ArrayList();
                ArrayList<BdUniqueId> g2 = w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.t0.e1.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.t0.e1.e.e().b(this.a.getPageContext(), g2.get(i2), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f16822d.add(b2);
                            this.f16821c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f16821c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f16821c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, e2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16823e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.d.n.e.n> arrayList) {
        HashMap<Integer, e2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.d.n.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f16823e) != null && !hashMap.containsValue(nVar)) {
                this.f16823e.put(Integer.valueOf(i2), (e2) nVar);
            }
        }
    }

    public List<c.a.d.n.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16824f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), e2.p3, this.a.getUniqueId());
            yVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.k kVar = new c.a.t0.e1.z1.d.k(frsNewAreaFragment.getTbPageContext(), e2.q3, this.a.getUniqueId());
            kVar.i0(bdTypeRecyclerView);
            v vVar = new v(frsNewAreaFragment.getTbPageContext(), e2.s3, this.a.getUniqueId());
            vVar.i0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), e2.t3, this.a.getUniqueId());
            sVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.j jVar = new c.a.t0.e1.z1.d.j(frsNewAreaFragment.getTbPageContext(), e2.w3, this.a.getUniqueId());
            jVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.m mVar = new c.a.t0.e1.z1.d.m(frsNewAreaFragment.getTbPageContext(), e2.x3, this.a.getUniqueId());
            mVar.i0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), e2.C3, this.a.getUniqueId());
            a0Var.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.w wVar = new c.a.t0.e1.z1.d.w(frsNewAreaFragment.getTbPageContext(), e2.V3, this.a.getUniqueId());
            wVar.i0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), e2.D3, this.a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), e2.E3, this.a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), e2.H3, this.a.getUniqueId());
            zVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.l lVar = new c.a.t0.e1.z1.d.l(frsNewAreaFragment.getPageContext(), e2.Z3, this.a.getUniqueId());
            lVar.i0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), e2.F3, this.a.getUniqueId());
            pVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.b bVar = new c.a.t0.e1.z1.d.b(frsNewAreaFragment.getPageContext(), e2.O3, this.a.getUniqueId());
            bVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.g gVar = new c.a.t0.e1.z1.d.g(frsNewAreaFragment.getPageContext(), e2.N3, this.a.getUniqueId());
            gVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.h hVar = new c.a.t0.e1.z1.d.h(frsNewAreaFragment.getPageContext(), e2.P3, this.a.getUniqueId());
            hVar.i0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), e2.G3, this.a.getUniqueId());
            tVar.i0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), e2.Q3, this.a.getUniqueId());
            zVar2.i0(bdTypeRecyclerView);
            c.a.t0.e1.r rVar2 = new c.a.t0.e1.r(frsNewAreaFragment.getPageContext(), c.a.t0.e1.s.f16855f);
            rVar2.i0(bdTypeRecyclerView);
            c.a.d.n.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> a2 = c.a.t0.e1.e.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.n.e.a<? extends e2, ? extends TypeAdapter.ViewHolder> d2 = c.a.t0.e1.e.e().d(frsNewAreaFragment.getPageContext(), e2.d4, this.a.getUniqueId());
            c.a.d.n.e.a<?, ?> f2 = c.a.t0.k3.y.q().f(this.a, AdvertAppInfo.B4);
            c.a.d.n.e.a<?, ?> f3 = c.a.t0.k3.y.q().f(this.a, AdvertAppInfo.E4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), e2.M3, this.a.getUniqueId());
            xVar.i0(bdTypeRecyclerView);
            c.a.t0.e1.z1.d.e eVar = new c.a.t0.e1.z1.d.e(frsNewAreaFragment.getPageContext(), e2.B3, this.a.getUniqueId());
            eVar.c0(bdTypeRecyclerView);
            this.f16822d.add(yVar);
            this.f16822d.add(kVar);
            this.f16822d.add(vVar);
            this.f16822d.add(sVar);
            this.f16822d.add(jVar);
            this.f16822d.add(mVar);
            this.f16822d.add(wVar);
            this.f16822d.add(a0Var);
            this.f16822d.add(uVar);
            this.f16822d.add(rVar);
            this.f16822d.add(zVar);
            this.f16822d.add(pVar);
            this.f16822d.add(bVar);
            this.f16822d.add(gVar);
            this.f16822d.add(hVar);
            this.f16822d.add(tVar);
            this.f16822d.add(rVar2);
            this.f16822d.add(lVar);
            this.f16822d.add(zVar2);
            this.f16822d.add(xVar);
            this.f16822d.add(eVar);
            if (a2 != null) {
                this.f16822d.add(a2);
            }
            if (d2 != null) {
                this.f16822d.add(d2);
            }
            this.f16822d.add(f2);
            this.f16822d.add(f3);
            c.a.d.n.e.a<?, ?> b2 = c.a.t0.f1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.M4);
            c.a.d.n.e.a<?, ?> b3 = c.a.t0.f1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4);
            this.f16822d.add(b2);
            this.f16822d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.d.n.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.t0.e1.k) {
                        ((c.a.t0.e1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.n.e.a> list = this.f16822d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.t0.h.f.b bVar2 = new c.a.t0.h.f.b(this.a, 1);
            bVar2.t(this.f16822d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f16822d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16820b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16820b.getAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (c.a.d.n.e.a aVar : this.f16822d) {
                if (aVar instanceof c.a.t0.e1.k) {
                    ((c.a.t0.e1.k) aVar).c0();
                } else if (aVar instanceof c.a.t0.k3.p) {
                    ((c.a.t0.k3.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16820b.setData(this.f16824f);
            l();
        }
    }

    public void q(ArrayList<c.a.d.n.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            w.f(arrayList, 1);
            i(arrayList);
            this.f16820b.setData(arrayList);
            this.f16824f = arrayList;
            this.f16825g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f16822d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16822d) {
            if (aVar instanceof c.a.t0.e1.k) {
                ((c.a.t0.e1.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f16822d) || this.a == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16822d) {
            if (aVar instanceof c.a.t0.e1.k) {
                ((c.a.t0.e1.k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f16822d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16822d) {
            if (aVar instanceof c.a.t0.e1.k) {
                ((c.a.t0.e1.k) aVar).f0(frsViewData);
            }
        }
    }

    public void u(c.a.d.n.e.v vVar) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, vVar) == null) || (list = this.f16822d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16822d) {
            if (aVar != null && (aVar instanceof c.a.t0.e1.k)) {
                ((c.a.t0.e1.k) aVar).V(vVar);
            }
        }
    }

    public final void v() {
        c.a.t0.e1.w2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f16825g == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16822d) {
            if ((aVar instanceof c.a.t0.e1.w2.d) && (j2 = ((c.a.t0.e1.w2.d) aVar).j()) != null) {
                if (this.f16825g.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f16825g.getForum() != null) {
                    j2.f17048c = this.f16825g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f16820b) == null || bdTypeRecyclerView.getData() == null || this.f16820b.getData().size() == 0) {
            return;
        }
        for (c.a.d.n.e.n nVar : this.f16820b.getData()) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.w.t0() != 0) {
                    d2Var.w.h3();
                }
            }
        }
    }
}
