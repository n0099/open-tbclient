package b.a.r0.x0.l2;

import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.b0;
import b.a.r0.b0.c0;
import b.a.r0.p.f;
import b.a.r0.x0.e;
import b.a.r0.x0.k;
import b.a.r0.x0.v2.d;
import b.a.r0.x0.y1.d.a0;
import b.a.r0.x0.y1.d.g;
import b.a.r0.x0.y1.d.h;
import b.a.r0.x0.y1.d.j;
import b.a.r0.x0.y1.d.m;
import b.a.r0.x0.y1.d.p;
import b.a.r0.x0.y1.d.r;
import b.a.r0.x0.y1.d.s;
import b.a.r0.x0.y1.d.t;
import b.a.r0.x0.y1.d.u;
import b.a.r0.x0.y1.d.v;
import b.a.r0.x0.y1.d.x;
import b.a.r0.x0.y1.d.y;
import b.a.r0.x0.y1.d.z;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f27495a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27496b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27497c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27498d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f27499e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f27500f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f27501g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f27502h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f27503i;
    public CustomMessageListener j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27504a;

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
            this.f27504a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<b.a.e.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    b.a.e.m.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.f27504a.f27495a.getPageContext(), this.f27504a.f27495a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f27504a.f27498d != null) {
                    this.f27504a.f27498d.addAll(arrayList);
                }
                if (this.f27504a.f27496b != null) {
                    this.f27504a.f27496b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: b.a.r0.x0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1348b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27505a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1348b(b bVar, int i2) {
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
            this.f27505a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f27505a.f27497c)) {
                b bVar = this.f27505a;
                bVar.i(bVar.f27496b);
                b bVar2 = this.f27505a;
                bVar2.w(bVar2.f27500f, this.f27505a.f27502h);
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
        this.f27498d = new LinkedList();
        this.f27503i = new a(this, 2003008);
        this.j = new C1348b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f27496b = bdTypeRecyclerView;
        this.f27499e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (b.a.e.m.e.a aVar : this.f27498d) {
                if (aVar instanceof b0) {
                    ((b0) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f27498d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27498d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).c0(wVar);
            }
        }
    }

    public final void C() {
        b.a.r0.x0.v2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27502h == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27498d) {
            if ((aVar instanceof d) && (j = ((d) aVar).j()) != null) {
                if (this.f27502h.needLog == 1) {
                    j.f27991a = true;
                } else {
                    j.f27991a = false;
                }
                if (this.f27502h.getForum() != null) {
                    j.f27993c = this.f27502h.getForum().getId();
                }
                if (this.f27495a != null) {
                    j.f27992b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f27496b) == null || bdTypeRecyclerView.getData() == null || this.f27496b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f27496b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.e3();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f27495a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f27495a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f27495a != null && bdTypeRecyclerView != null) {
                this.f27497c = new ArrayList();
                ArrayList<BdUniqueId> g2 = b.a.r0.m3.w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f27495a.getPageContext(), g2.get(i2), this.f27495a.getUniqueId());
                        if (b2 != null) {
                            this.f27498d.add(b2);
                            this.f27497c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f27497c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f27497c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27499e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f27499e) != null && !hashMap.containsValue(nVar)) {
                this.f27499e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27500f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27501g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f27495a = frsGoodFragment;
            this.f27503i.setPriority(1);
            this.f27503i.setSelfListener(true);
            this.f27495a.registerListener(this.f27503i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), d2.h3, this.f27495a.getUniqueId());
            b.a.r0.x0.y1.d.k kVar = new b.a.r0.x0.y1.d.k(frsGoodFragment.getTbPageContext(), d2.i3, this.f27495a.getUniqueId());
            v vVar = new v(frsGoodFragment.getTbPageContext(), d2.k3, this.f27495a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), d2.l3, this.f27495a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), d2.o3, this.f27495a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), d2.p3, this.f27495a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), d2.u3, this.f27495a.getUniqueId());
            b.a.r0.x0.y1.d.w wVar = new b.a.r0.x0.y1.d.w(frsGoodFragment.getTbPageContext(), d2.N3, this.f27495a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), d2.v3, this.f27495a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), d2.w3, this.f27495a.getUniqueId());
            z zVar = new z(frsGoodFragment.getPageContext(), d2.z3, this.f27495a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), d2.x3, this.f27495a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), d2.y3, this.f27495a.getUniqueId());
            z zVar2 = new z(frsGoodFragment.getPageContext(), d2.I3, this.f27495a.getUniqueId());
            b.a.r0.x0.r rVar2 = new b.a.r0.x0.r(frsGoodFragment.getPageContext(), b.a.r0.x0.s.f27833f);
            b.a.e.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f27495a.getUniqueId(), true);
            b.a.e.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), d2.V3, this.f27495a.getUniqueId());
            b.a.e.m.e.a<?, ?> f2 = b.a.r0.a3.y.o().f(this.f27495a, AdvertAppInfo.s4);
            b.a.e.m.e.a<?, ?> f3 = b.a.r0.a3.y.o().f(this.f27495a, AdvertAppInfo.v4);
            x xVar = new x(frsGoodFragment.getPageContext(), d2.E3, this.f27495a.getUniqueId());
            b.a.r0.x0.y1.d.b bVar = new b.a.r0.x0.y1.d.b(frsGoodFragment.getPageContext(), d2.G3, this.f27495a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), d2.F3, this.f27495a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), d2.H3, this.f27495a.getUniqueId());
            b.a.r0.x0.y1.d.e eVar = new b.a.r0.x0.y1.d.e(frsGoodFragment.getPageContext(), d2.t3, this.f27495a.getUniqueId());
            eVar.j0(bdTypeRecyclerView);
            this.f27498d.add(yVar);
            this.f27498d.add(kVar);
            this.f27498d.add(vVar);
            this.f27498d.add(sVar);
            this.f27498d.add(jVar);
            this.f27498d.add(mVar);
            this.f27498d.add(wVar);
            this.f27498d.add(a0Var);
            this.f27498d.add(uVar);
            this.f27498d.add(rVar);
            this.f27498d.add(zVar);
            this.f27498d.add(pVar);
            this.f27498d.add(pVar);
            this.f27498d.add(tVar);
            this.f27498d.add(rVar2);
            this.f27498d.add(zVar);
            this.f27498d.add(zVar2);
            this.f27498d.add(xVar);
            this.f27498d.add(bVar);
            this.f27498d.add(gVar);
            this.f27498d.add(hVar);
            this.f27498d.add(eVar);
            if (a2 != null) {
                this.f27498d.add(a2);
            }
            if (d2 != null) {
                this.f27498d.add(d2);
            }
            this.f27498d.add(f2);
            this.f27498d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f27495a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f27498d.add(b.a.r0.y0.b.e().b(this.f27495a.getBaseFragmentActivity(), AdvertAppInfo.D4));
            this.f27498d.add(b.a.r0.y0.b.e().b(this.f27495a.getBaseFragmentActivity(), AdvertAppInfo.C4));
            b.a.r0.g.f.b bVar2 = new b.a.r0.g.f.b(this.f27495a, 1);
            bVar2.t(this.f27498d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f27498d);
            v("page_frs_good");
            for (b.a.e.m.e.a aVar : this.f27498d) {
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
            for (b.a.e.m.e.a aVar : this.f27498d) {
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
            this.f27496b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f27496b.getAdapter().notifyDataSetChanged();
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
            for (b.a.e.m.e.a aVar : this.f27498d) {
                if (aVar instanceof k) {
                    ((k) aVar).j0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f27503i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f27496b.setData(this.f27501g);
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
            if (it.next().getType() == d2.a3) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f27498d) == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof b.a.r0.x0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            b.a.r0.m3.w.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f27496b.setData(switchThreadDataToThreadCardInfo);
            this.f27501g = switchThreadDataToThreadCardInfo;
            this.f27500f = arrayList;
            this.f27502h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f27498d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27498d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f27498d) || this.f27495a == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27498d) {
            if (aVar instanceof k) {
                ((k) aVar).r0(this.f27495a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f27498d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27498d) {
            if (aVar instanceof k) {
                ((k) aVar).m0(frsViewData);
            }
        }
    }
}
