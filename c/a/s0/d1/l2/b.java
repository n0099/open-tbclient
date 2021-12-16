package c.a.s0.d1.l2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.r0.s.r.c2;
import c.a.r0.s.r.d2;
import c.a.s0.d1.e;
import c.a.s0.d1.k;
import c.a.s0.d1.v2.d;
import c.a.s0.d1.y1.d.a0;
import c.a.s0.d1.y1.d.g;
import c.a.s0.d1.y1.d.h;
import c.a.s0.d1.y1.d.j;
import c.a.s0.d1.y1.d.m;
import c.a.s0.d1.y1.d.p;
import c.a.s0.d1.y1.d.r;
import c.a.s0.d1.y1.d.s;
import c.a.s0.d1.y1.d.t;
import c.a.s0.d1.y1.d.u;
import c.a.s0.d1.y1.d.v;
import c.a.s0.d1.y1.d.x;
import c.a.s0.d1.y1.d.y;
import c.a.s0.d1.y1.d.z;
import c.a.s0.g0.b0;
import c.a.s0.g0.c0;
import c.a.s0.t.f;
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
    public BdTypeRecyclerView f16055b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f16056c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f16057d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f16058e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f16059f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f16060g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f16061h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f16062i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f16063j;

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
                Iterator<c.a.d.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.m.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.f16057d != null) {
                    this.a.f16057d.addAll(arrayList);
                }
                if (this.a.f16055b != null) {
                    this.a.f16055b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.s0.d1.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0991b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0991b(b bVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f16056c)) {
                b bVar = this.a;
                bVar.i(bVar.f16055b);
                b bVar2 = this.a;
                bVar2.w(bVar2.f16059f, this.a.f16061h);
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
        this.f16057d = new LinkedList();
        this.f16062i = new a(this, 2003008);
        this.f16063j = new C0991b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f16055b = bdTypeRecyclerView;
        this.f16058e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.d.m.e.a aVar : this.f16057d) {
                if (aVar instanceof b0) {
                    ((b0) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f16057d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16057d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).c0(wVar);
            }
        }
    }

    public final void C() {
        c.a.s0.d1.v2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f16061h == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16057d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f16061h.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f16061h.getForum() != null) {
                    j2.f16494c = this.f16061h.getForum().getId();
                }
                if (this.a != null) {
                    j2.f16493b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f16055b) == null || bdTypeRecyclerView.getData() == null || this.f16055b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f16055b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.s0() != 0) {
                    c2Var.w.g3();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f16063j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f16056c = new ArrayList();
                ArrayList<BdUniqueId> g2 = c.a.s0.v3.w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.a.getPageContext(), g2.get(i2), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f16057d.add(b2);
                            this.f16056c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f16056c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f16056c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, d2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16058e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f16058e) != null && !hashMap.containsValue(nVar)) {
                this.f16058e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16059f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16060g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.f16062i.setPriority(1);
            this.f16062i.setSelfListener(true);
            this.a.registerListener(this.f16062i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), d2.m3, this.a.getUniqueId());
            c.a.s0.d1.y1.d.k kVar = new c.a.s0.d1.y1.d.k(frsGoodFragment.getTbPageContext(), d2.n3, this.a.getUniqueId());
            v vVar = new v(frsGoodFragment.getTbPageContext(), d2.p3, this.a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), d2.q3, this.a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), d2.t3, this.a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), d2.u3, this.a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), d2.z3, this.a.getUniqueId());
            c.a.s0.d1.y1.d.w wVar = new c.a.s0.d1.y1.d.w(frsGoodFragment.getTbPageContext(), d2.S3, this.a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), d2.A3, this.a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), d2.B3, this.a.getUniqueId());
            z zVar = new z(frsGoodFragment.getPageContext(), d2.E3, this.a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), d2.C3, this.a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), d2.D3, this.a.getUniqueId());
            z zVar2 = new z(frsGoodFragment.getPageContext(), d2.N3, this.a.getUniqueId());
            c.a.s0.d1.r rVar2 = new c.a.s0.d1.r(frsGoodFragment.getPageContext(), c.a.s0.d1.s.f16352f);
            c.a.d.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), d2.a4, this.a.getUniqueId());
            c.a.d.m.e.a<?, ?> f2 = c.a.s0.j3.y.q().f(this.a, AdvertAppInfo.y4);
            c.a.d.m.e.a<?, ?> f3 = c.a.s0.j3.y.q().f(this.a, AdvertAppInfo.B4);
            x xVar = new x(frsGoodFragment.getPageContext(), d2.J3, this.a.getUniqueId());
            c.a.s0.d1.y1.d.b bVar = new c.a.s0.d1.y1.d.b(frsGoodFragment.getPageContext(), d2.L3, this.a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), d2.K3, this.a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), d2.M3, this.a.getUniqueId());
            c.a.s0.d1.y1.d.e eVar = new c.a.s0.d1.y1.d.e(frsGoodFragment.getPageContext(), d2.y3, this.a.getUniqueId());
            eVar.j0(bdTypeRecyclerView);
            this.f16057d.add(yVar);
            this.f16057d.add(kVar);
            this.f16057d.add(vVar);
            this.f16057d.add(sVar);
            this.f16057d.add(jVar);
            this.f16057d.add(mVar);
            this.f16057d.add(wVar);
            this.f16057d.add(a0Var);
            this.f16057d.add(uVar);
            this.f16057d.add(rVar);
            this.f16057d.add(zVar);
            this.f16057d.add(pVar);
            this.f16057d.add(pVar);
            this.f16057d.add(tVar);
            this.f16057d.add(rVar2);
            this.f16057d.add(zVar);
            this.f16057d.add(zVar2);
            this.f16057d.add(xVar);
            this.f16057d.add(bVar);
            this.f16057d.add(gVar);
            this.f16057d.add(hVar);
            this.f16057d.add(eVar);
            if (a2 != null) {
                this.f16057d.add(a2);
            }
            if (d2 != null) {
                this.f16057d.add(d2);
            }
            this.f16057d.add(f2);
            this.f16057d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f16057d.add(c.a.s0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.J4));
            this.f16057d.add(c.a.s0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.I4));
            c.a.s0.h.f.b bVar2 = new c.a.s0.h.f.b(this.a, 1);
            bVar2.t(this.f16057d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f16057d);
            v("page_frs_good");
            for (c.a.d.m.e.a aVar : this.f16057d) {
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
            for (c.a.d.m.e.a aVar : this.f16057d) {
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
            this.f16055b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f16055b.getAdapter().notifyDataSetChanged();
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
            for (c.a.d.m.e.a aVar : this.f16057d) {
                if (aVar instanceof k) {
                    ((k) aVar).j0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f16062i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f16055b.setData(this.f16060g);
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
            if (it.next().getType() == d2.f3) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f16057d) == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.s0.d1.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            c.a.s0.v3.w.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f16055b.setData(switchThreadDataToThreadCardInfo);
            this.f16060g = switchThreadDataToThreadCardInfo;
            this.f16059f = arrayList;
            this.f16061h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f16057d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16057d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f16057d) || this.a == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16057d) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f16057d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16057d) {
            if (aVar instanceof k) {
                ((k) aVar).m0(frsViewData);
            }
        }
    }
}
