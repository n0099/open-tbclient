package c.a.p0.v0.z1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.a0.z;
import c.a.p0.i3.v;
import c.a.p0.o.f;
import c.a.p0.v0.e;
import c.a.p0.v0.j2.d;
import c.a.p0.v0.k;
import c.a.p0.v0.m1.d.a0;
import c.a.p0.v0.m1.d.g;
import c.a.p0.v0.m1.d.h;
import c.a.p0.v0.m1.d.j;
import c.a.p0.v0.m1.d.m;
import c.a.p0.v0.m1.d.p;
import c.a.p0.v0.m1.d.r;
import c.a.p0.v0.m1.d.s;
import c.a.p0.v0.m1.d.t;
import c.a.p0.v0.m1.d.u;
import c.a.p0.v0.m1.d.x;
import c.a.p0.v0.m1.d.y;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f27061a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27062b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f27063c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f27064d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, c2> f27065e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f27066f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f27067g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f27068h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f27069i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f27070j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27071a;

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
            this.f27071a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<c.a.e.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.k.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.f27071a.f27061a.getPageContext(), this.f27071a.f27061a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f27071a.f27064d != null) {
                    this.f27071a.f27064d.addAll(arrayList);
                }
                if (this.f27071a.f27062b != null) {
                    this.f27071a.f27062b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.p0.v0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1271b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27072a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1271b(b bVar, int i2) {
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
            this.f27072a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f27072a.f27063c)) {
                b bVar = this.f27072a;
                bVar.i(bVar.f27062b);
                b bVar2 = this.f27072a;
                bVar2.w(bVar2.f27066f, this.f27072a.f27068h);
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
        this.f27064d = new LinkedList();
        this.f27069i = new a(this, 2003008);
        this.f27070j = new C1271b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f27062b = bdTypeRecyclerView;
        this.f27065e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.e.k.e.a aVar : this.f27064d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f27064d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f27064d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).d0(wVar);
            }
        }
    }

    public final void C() {
        c.a.p0.v0.j2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27068h == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f27064d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f27068h.needLog == 1) {
                    j2.f25937a = true;
                } else {
                    j2.f25937a = false;
                }
                if (this.f27068h.getForum() != null) {
                    j2.f25939c = this.f27068h.getForum().getId();
                }
                if (this.f27061a != null) {
                    j2.f25938b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f27062b) == null || bdTypeRecyclerView.getData() == null || this.f27062b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f27062b.getData()) {
            if (nVar instanceof b2) {
                b2 b2Var = (b2) nVar;
                if (b2Var.w.p0() != 0) {
                    b2Var.w.W2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f27061a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f27061a.registerListener(this.f27070j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f27061a != null && bdTypeRecyclerView != null) {
                this.f27063c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f27061a.getPageContext(), g2.get(i2), this.f27061a.getUniqueId());
                        if (b2 != null) {
                            this.f27064d.add(b2);
                            this.f27063c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f27063c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f27063c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, c2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27065e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, c2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f27065e) != null && !hashMap.containsValue(nVar)) {
                this.f27065e.put(Integer.valueOf(i2), (c2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27066f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27067g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f27061a = frsGoodFragment;
            this.f27069i.setPriority(1);
            this.f27069i.setSelfListener(true);
            this.f27061a.registerListener(this.f27069i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), c2.c3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.k kVar = new c.a.p0.v0.m1.d.k(frsGoodFragment.getTbPageContext(), c2.d3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.v vVar = new c.a.p0.v0.m1.d.v(frsGoodFragment.getTbPageContext(), c2.f3, this.f27061a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), c2.g3, this.f27061a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), c2.i3, this.f27061a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), c2.j3, this.f27061a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), c2.o3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.w wVar = new c.a.p0.v0.m1.d.w(frsGoodFragment.getTbPageContext(), c2.H3, this.f27061a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), c2.p3, this.f27061a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), c2.q3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.z zVar = new c.a.p0.v0.m1.d.z(frsGoodFragment.getPageContext(), c2.t3, this.f27061a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), c2.r3, this.f27061a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), c2.s3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.z zVar2 = new c.a.p0.v0.m1.d.z(frsGoodFragment.getPageContext(), c2.C3, this.f27061a.getUniqueId());
            c.a.p0.v0.r rVar2 = new c.a.p0.v0.r(frsGoodFragment.getPageContext(), c.a.p0.v0.s.f26816f);
            c.a.e.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f27061a.getUniqueId(), true);
            c.a.e.k.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), c2.Q3, this.f27061a.getUniqueId());
            c.a.e.k.e.a<?, ?> f2 = c.a.p0.x2.y.o().f(this.f27061a, AdvertAppInfo.n4);
            c.a.e.k.e.a<?, ?> f3 = c.a.p0.x2.y.o().f(this.f27061a, AdvertAppInfo.q4);
            x xVar = new x(frsGoodFragment.getPageContext(), c2.y3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.b bVar = new c.a.p0.v0.m1.d.b(frsGoodFragment.getPageContext(), c2.A3, this.f27061a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), c2.z3, this.f27061a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), c2.B3, this.f27061a.getUniqueId());
            c.a.p0.v0.m1.d.e eVar = new c.a.p0.v0.m1.d.e(frsGoodFragment.getPageContext(), c2.n3, this.f27061a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f27064d.add(yVar);
            this.f27064d.add(kVar);
            this.f27064d.add(vVar);
            this.f27064d.add(sVar);
            this.f27064d.add(jVar);
            this.f27064d.add(mVar);
            this.f27064d.add(wVar);
            this.f27064d.add(a0Var);
            this.f27064d.add(uVar);
            this.f27064d.add(rVar);
            this.f27064d.add(zVar);
            this.f27064d.add(pVar);
            this.f27064d.add(pVar);
            this.f27064d.add(tVar);
            this.f27064d.add(rVar2);
            this.f27064d.add(zVar);
            this.f27064d.add(zVar2);
            this.f27064d.add(xVar);
            this.f27064d.add(bVar);
            this.f27064d.add(gVar);
            this.f27064d.add(hVar);
            this.f27064d.add(eVar);
            if (a2 != null) {
                this.f27064d.add(a2);
            }
            if (d2 != null) {
                this.f27064d.add(d2);
            }
            this.f27064d.add(f2);
            this.f27064d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f27061a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f27064d.add(c.a.p0.w0.b.e().b(this.f27061a.getBaseFragmentActivity(), AdvertAppInfo.y4));
            this.f27064d.add(c.a.p0.w0.b.e().b(this.f27061a.getBaseFragmentActivity(), AdvertAppInfo.x4));
            c.a.p0.f.f.b bVar2 = new c.a.p0.f.f.b(this.f27061a, 1);
            bVar2.t(this.f27064d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f27064d);
            v("page_frs_good");
            for (c.a.e.k.e.a aVar : this.f27064d) {
                if (aVar instanceof c.a.p0.a0.a0) {
                    ((c.a.p0.a0.a0) aVar).l(true);
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
            for (c.a.e.k.e.a aVar : this.f27064d) {
                if (aVar != null && aVar.K() == bdUniqueId) {
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
            this.f27062b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f27062b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.k.e.a aVar : this.f27064d) {
                if (aVar instanceof k) {
                    ((k) aVar).k0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f27069i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f27062b.setData(this.f27067g);
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
            if (it.next().getType() == c2.V2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f27064d) == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.p0.v0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            v.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f27062b.setData(switchThreadDataToThreadCardInfo);
            this.f27067g = switchThreadDataToThreadCardInfo;
            this.f27066f = arrayList;
            this.f27068h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f27064d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f27064d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f27064d) || this.f27061a == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f27064d) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f27061a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f27064d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f27064d) {
            if (aVar instanceof k) {
                ((k) aVar).n0(frsViewData);
            }
        }
    }
}
