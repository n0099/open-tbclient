package c.a.r0.d1.c2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
import c.a.r0.d1.e;
import c.a.r0.d1.k;
import c.a.r0.d1.o2.d;
import c.a.r0.d1.p1.d.a0;
import c.a.r0.d1.p1.d.g;
import c.a.r0.d1.p1.d.h;
import c.a.r0.d1.p1.d.j;
import c.a.r0.d1.p1.d.m;
import c.a.r0.d1.p1.d.p;
import c.a.r0.d1.p1.d.r;
import c.a.r0.d1.p1.d.s;
import c.a.r0.d1.p1.d.t;
import c.a.r0.d1.p1.d.u;
import c.a.r0.d1.p1.d.w;
import c.a.r0.d1.p1.d.y;
import c.a.r0.f0.z;
import c.a.r0.t.f;
import c.a.r0.y3.x;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f15383b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15384c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15385d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, e2> f15386e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f15387f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f15388g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f15389h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15390i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f15391j;

    /* loaded from: classes2.dex */
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
                Iterator<c.a.d.o.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.f15385d != null) {
                    this.a.f15385d.addAll(arrayList);
                }
                if (this.a.f15383b != null) {
                    this.a.f15383b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.r0.d1.c2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0993b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0993b(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f15384c)) {
                b bVar = this.a;
                bVar.i(bVar.f15383b);
                b bVar2 = this.a;
                bVar2.w(bVar2.f15387f, this.a.f15389h);
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
        this.f15385d = new LinkedList();
        this.f15390i = new a(this, 2003008);
        this.f15391j = new C0993b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f15383b = bdTypeRecyclerView;
        this.f15386e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.d.o.e.a aVar : this.f15385d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(v vVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar) == null) || (list = this.f15385d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15385d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).V(vVar);
            }
        }
    }

    public final void C() {
        c.a.r0.d1.o2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f15389h == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15385d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f15389h.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f15389h.getForum() != null) {
                    j2.f15918c = this.f15389h.getForum().getId();
                    j2.f15919d = this.f15389h.getForum().getName();
                }
                if (this.a != null) {
                    j2.f15917b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f15383b) == null || bdTypeRecyclerView.getData() == null || this.f15383b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f15383b.getData()) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.w.t0() != 0) {
                    d2Var.w.h3();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f15391j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f15384c = new ArrayList();
                ArrayList<BdUniqueId> g2 = x.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.a.getPageContext(), g2.get(i2), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f15385d.add(b2);
                            this.f15384c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f15384c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f15384c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15386e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, e2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f15386e) != null && !hashMap.containsValue(nVar)) {
                this.f15386e.put(Integer.valueOf(i2), (e2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15387f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15388g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.f15390i.setPriority(1);
            this.f15390i.setSelfListener(true);
            this.a.registerListener(this.f15390i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), e2.p3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.k kVar = new c.a.r0.d1.p1.d.k(frsGoodFragment.getTbPageContext(), e2.q3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.v vVar = new c.a.r0.d1.p1.d.v(frsGoodFragment.getTbPageContext(), e2.s3, this.a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), e2.t3, this.a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), e2.w3, this.a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), e2.x3, this.a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), e2.C3, this.a.getUniqueId());
            w wVar = new w(frsGoodFragment.getTbPageContext(), e2.V3, this.a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), e2.D3, this.a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), e2.E3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.z zVar = new c.a.r0.d1.p1.d.z(frsGoodFragment.getPageContext(), e2.H3, this.a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), e2.F3, this.a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), e2.G3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.z zVar2 = new c.a.r0.d1.p1.d.z(frsGoodFragment.getPageContext(), e2.Q3, this.a.getUniqueId());
            c.a.r0.d1.r rVar2 = new c.a.r0.d1.r(frsGoodFragment.getPageContext(), c.a.r0.d1.s.f16241f);
            c.a.d.o.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.o.e.a<? extends e2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), e2.d4, this.a.getUniqueId());
            c.a.d.o.e.a<?, ?> f2 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.B4);
            c.a.d.o.e.a<?, ?> f3 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.E4);
            c.a.r0.d1.p1.d.x xVar = new c.a.r0.d1.p1.d.x(frsGoodFragment.getPageContext(), e2.M3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.b bVar = new c.a.r0.d1.p1.d.b(frsGoodFragment.getPageContext(), e2.O3, this.a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), e2.N3, this.a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), e2.P3, this.a.getUniqueId());
            c.a.r0.d1.p1.d.e eVar = new c.a.r0.d1.p1.d.e(frsGoodFragment.getPageContext(), e2.B3, this.a.getUniqueId());
            eVar.c0(bdTypeRecyclerView);
            this.f15385d.add(yVar);
            this.f15385d.add(kVar);
            this.f15385d.add(vVar);
            this.f15385d.add(sVar);
            this.f15385d.add(jVar);
            this.f15385d.add(mVar);
            this.f15385d.add(wVar);
            this.f15385d.add(a0Var);
            this.f15385d.add(uVar);
            this.f15385d.add(rVar);
            this.f15385d.add(zVar);
            this.f15385d.add(pVar);
            this.f15385d.add(pVar);
            this.f15385d.add(tVar);
            this.f15385d.add(rVar2);
            this.f15385d.add(zVar);
            this.f15385d.add(zVar2);
            this.f15385d.add(xVar);
            this.f15385d.add(bVar);
            this.f15385d.add(gVar);
            this.f15385d.add(hVar);
            this.f15385d.add(eVar);
            if (a2 != null) {
                this.f15385d.add(a2);
            }
            if (d2 != null) {
                this.f15385d.add(d2);
            }
            this.f15385d.add(f2);
            this.f15385d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f15385d.add(c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.M4));
            this.f15385d.add(c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4));
            c.a.r0.h.f.b bVar2 = new c.a.r0.h.f.b(this.a, 1);
            bVar2.t(this.f15385d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f15385d);
            v("page_frs_good");
            for (c.a.d.o.e.a aVar : this.f15385d) {
                if (aVar instanceof c.a.r0.f0.a0) {
                    ((c.a.r0.f0.a0) aVar).l(true);
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
            for (c.a.d.o.e.a aVar : this.f15385d) {
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
            this.f15383b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f15383b.getAdapter().notifyDataSetChanged();
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
            for (c.a.d.o.e.a aVar : this.f15385d) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f15390i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f15383b.setData(this.f15388g);
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
            if (it.next().getType() == e2.i3) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f15385d) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.r0.d1.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            x.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f15383b.setData(switchThreadDataToThreadCardInfo);
            this.f15388g = switchThreadDataToThreadCardInfo;
            this.f15387f = arrayList;
            this.f15389h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f15385d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15385d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f15385d) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15385d) {
            if (aVar instanceof k) {
                ((k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f15385d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15385d) {
            if (aVar instanceof k) {
                ((k) aVar).f0(frsViewData);
            }
        }
    }
}
