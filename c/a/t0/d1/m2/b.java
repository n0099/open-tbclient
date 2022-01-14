package c.a.t0.d1.m2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.d1.e;
import c.a.t0.d1.k;
import c.a.t0.d1.w2.d;
import c.a.t0.d1.z1.d.a0;
import c.a.t0.d1.z1.d.g;
import c.a.t0.d1.z1.d.h;
import c.a.t0.d1.z1.d.j;
import c.a.t0.d1.z1.d.m;
import c.a.t0.d1.z1.d.p;
import c.a.t0.d1.z1.d.r;
import c.a.t0.d1.z1.d.s;
import c.a.t0.d1.z1.d.t;
import c.a.t0.d1.z1.d.u;
import c.a.t0.d1.z1.d.v;
import c.a.t0.d1.z1.d.x;
import c.a.t0.d1.z1.d.y;
import c.a.t0.d1.z1.d.z;
import c.a.t0.g0.b0;
import c.a.t0.g0.c0;
import c.a.t0.t.f;
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
import com.baidu.tieba.frs.good.FrsGoodFragment;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16267b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16268c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f16269d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, e2> f16270e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f16271f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f16272g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f16273h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16274i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f16275j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<c.a.d.n.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.f16269d != null) {
                    this.a.f16269d.addAll(arrayList);
                }
                if (this.a.f16267b != null) {
                    this.a.f16267b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.t0.d1.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1040b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1040b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f16268c)) {
                b bVar = this.a;
                bVar.i(bVar.f16267b);
                b bVar2 = this.a;
                bVar2.w(bVar2.f16271f, this.a.f16273h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16269d = new LinkedList();
        this.f16274i = new a(this, 2003008);
        this.f16275j = new C1040b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f16267b = bdTypeRecyclerView;
        this.f16270e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.d.n.e.a aVar : this.f16269d) {
                if (aVar instanceof b0) {
                    ((b0) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f16269d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16269d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).V(wVar);
            }
        }
    }

    public final void C() {
        c.a.t0.d1.w2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f16273h == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16269d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f16273h.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f16273h.getForum() != null) {
                    j2.f16716c = this.f16273h.getForum().getId();
                }
                if (this.a != null) {
                    j2.f16715b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f16267b) == null || bdTypeRecyclerView.getData() == null || this.f16267b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f16267b.getData()) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.w.s0() != 0) {
                    d2Var.w.g3();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f16275j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f16268c = new ArrayList();
                ArrayList<BdUniqueId> g2 = c.a.t0.w3.w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.a.getPageContext(), g2.get(i2), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f16269d.add(b2);
                            this.f16268c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f16268c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f16268c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, e2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16270e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, e2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f16270e) != null && !hashMap.containsValue(nVar)) {
                this.f16270e.put(Integer.valueOf(i2), (e2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16271f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16272g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.f16274i.setPriority(1);
            this.f16274i.setSelfListener(true);
            this.a.registerListener(this.f16274i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), e2.o3, this.a.getUniqueId());
            c.a.t0.d1.z1.d.k kVar = new c.a.t0.d1.z1.d.k(frsGoodFragment.getTbPageContext(), e2.p3, this.a.getUniqueId());
            v vVar = new v(frsGoodFragment.getTbPageContext(), e2.r3, this.a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), e2.s3, this.a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), e2.v3, this.a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), e2.w3, this.a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), e2.B3, this.a.getUniqueId());
            c.a.t0.d1.z1.d.w wVar = new c.a.t0.d1.z1.d.w(frsGoodFragment.getTbPageContext(), e2.U3, this.a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), e2.C3, this.a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), e2.D3, this.a.getUniqueId());
            z zVar = new z(frsGoodFragment.getPageContext(), e2.G3, this.a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), e2.E3, this.a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), e2.F3, this.a.getUniqueId());
            z zVar2 = new z(frsGoodFragment.getPageContext(), e2.P3, this.a.getUniqueId());
            c.a.t0.d1.r rVar2 = new c.a.t0.d1.r(frsGoodFragment.getPageContext(), c.a.t0.d1.s.f16523f);
            c.a.d.n.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.n.e.a<? extends e2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), e2.c4, this.a.getUniqueId());
            c.a.d.n.e.a<?, ?> f2 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.A4);
            c.a.d.n.e.a<?, ?> f3 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.D4);
            x xVar = new x(frsGoodFragment.getPageContext(), e2.L3, this.a.getUniqueId());
            c.a.t0.d1.z1.d.b bVar = new c.a.t0.d1.z1.d.b(frsGoodFragment.getPageContext(), e2.N3, this.a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), e2.M3, this.a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), e2.O3, this.a.getUniqueId());
            c.a.t0.d1.z1.d.e eVar = new c.a.t0.d1.z1.d.e(frsGoodFragment.getPageContext(), e2.A3, this.a.getUniqueId());
            eVar.c0(bdTypeRecyclerView);
            this.f16269d.add(yVar);
            this.f16269d.add(kVar);
            this.f16269d.add(vVar);
            this.f16269d.add(sVar);
            this.f16269d.add(jVar);
            this.f16269d.add(mVar);
            this.f16269d.add(wVar);
            this.f16269d.add(a0Var);
            this.f16269d.add(uVar);
            this.f16269d.add(rVar);
            this.f16269d.add(zVar);
            this.f16269d.add(pVar);
            this.f16269d.add(pVar);
            this.f16269d.add(tVar);
            this.f16269d.add(rVar2);
            this.f16269d.add(zVar);
            this.f16269d.add(zVar2);
            this.f16269d.add(xVar);
            this.f16269d.add(bVar);
            this.f16269d.add(gVar);
            this.f16269d.add(hVar);
            this.f16269d.add(eVar);
            if (a2 != null) {
                this.f16269d.add(a2);
            }
            if (d2 != null) {
                this.f16269d.add(d2);
            }
            this.f16269d.add(f2);
            this.f16269d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f16269d.add(c.a.t0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4));
            this.f16269d.add(c.a.t0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.K4));
            c.a.t0.h.f.b bVar2 = new c.a.t0.h.f.b(this.a, 1);
            bVar2.t(this.f16269d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f16269d);
            v("page_frs_good");
            for (c.a.d.n.e.a aVar : this.f16269d) {
                if (aVar instanceof c0) {
                    ((c0) aVar).l(true);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.d.n.e.a aVar : this.f16269d) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f16267b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f16267b.getAdapter().notifyDataSetChanged();
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (c.a.d.n.e.a aVar : this.f16269d) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f16274i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f16267b.setData(this.f16272g);
            p();
        }
    }

    public final void u(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == e2.h3) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f16269d) == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.t0.d1.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            c.a.t0.w3.w.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f16267b.setData(switchThreadDataToThreadCardInfo);
            this.f16272g = switchThreadDataToThreadCardInfo;
            this.f16271f = arrayList;
            this.f16273h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f16269d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16269d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f16269d) || this.a == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16269d) {
            if (aVar instanceof k) {
                ((k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f16269d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f16269d) {
            if (aVar instanceof k) {
                ((k) aVar).f0(frsViewData);
            }
        }
    }
}
