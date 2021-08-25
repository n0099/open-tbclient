package c.a.q0.v0.z1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.q0.a0.z;
import c.a.q0.i3.v;
import c.a.q0.o.f;
import c.a.q0.v0.e;
import c.a.q0.v0.j2.d;
import c.a.q0.v0.k;
import c.a.q0.v0.m1.d.a0;
import c.a.q0.v0.m1.d.g;
import c.a.q0.v0.m1.d.h;
import c.a.q0.v0.m1.d.j;
import c.a.q0.v0.m1.d.m;
import c.a.q0.v0.m1.d.p;
import c.a.q0.v0.m1.d.r;
import c.a.q0.v0.m1.d.s;
import c.a.q0.v0.m1.d.t;
import c.a.q0.v0.m1.d.u;
import c.a.q0.v0.m1.d.x;
import c.a.q0.v0.m1.d.y;
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
    public FrsGoodFragment f27400a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27401b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f27402c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f27403d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, c2> f27404e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f27405f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f27406g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f27407h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f27408i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f27409j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27410a;

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
            this.f27410a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.f27410a.f27400a.getPageContext(), this.f27410a.f27400a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f27410a.f27403d != null) {
                    this.f27410a.f27403d.addAll(arrayList);
                }
                if (this.f27410a.f27401b != null) {
                    this.f27410a.f27401b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.q0.v0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1281b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27411a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1281b(b bVar, int i2) {
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
            this.f27411a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f27411a.f27402c)) {
                b bVar = this.f27411a;
                bVar.i(bVar.f27401b);
                b bVar2 = this.f27411a;
                bVar2.w(bVar2.f27405f, this.f27411a.f27407h);
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
        this.f27403d = new LinkedList();
        this.f27408i = new a(this, 2003008);
        this.f27409j = new C1281b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f27401b = bdTypeRecyclerView;
        this.f27404e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.e.l.e.a aVar : this.f27403d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f27403d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27403d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).d0(wVar);
            }
        }
    }

    public final void C() {
        c.a.q0.v0.j2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27407h == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27403d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f27407h.needLog == 1) {
                    j2.f26273a = true;
                } else {
                    j2.f26273a = false;
                }
                if (this.f27407h.getForum() != null) {
                    j2.f26275c = this.f27407h.getForum().getId();
                }
                if (this.f27400a != null) {
                    j2.f26274b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f27401b) == null || bdTypeRecyclerView.getData() == null || this.f27401b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f27401b.getData()) {
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f27400a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f27400a.registerListener(this.f27409j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f27400a != null && bdTypeRecyclerView != null) {
                this.f27402c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f27400a.getPageContext(), g2.get(i2), this.f27400a.getUniqueId());
                        if (b2 != null) {
                            this.f27403d.add(b2);
                            this.f27402c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f27402c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f27402c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27404e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, c2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f27404e) != null && !hashMap.containsValue(nVar)) {
                this.f27404e.put(Integer.valueOf(i2), (c2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27405f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27406g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f27400a = frsGoodFragment;
            this.f27408i.setPriority(1);
            this.f27408i.setSelfListener(true);
            this.f27400a.registerListener(this.f27408i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), c2.c3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.k kVar = new c.a.q0.v0.m1.d.k(frsGoodFragment.getTbPageContext(), c2.d3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.v vVar = new c.a.q0.v0.m1.d.v(frsGoodFragment.getTbPageContext(), c2.f3, this.f27400a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), c2.g3, this.f27400a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), c2.i3, this.f27400a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), c2.j3, this.f27400a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), c2.o3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.w wVar = new c.a.q0.v0.m1.d.w(frsGoodFragment.getTbPageContext(), c2.H3, this.f27400a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), c2.p3, this.f27400a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), c2.q3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.z zVar = new c.a.q0.v0.m1.d.z(frsGoodFragment.getPageContext(), c2.t3, this.f27400a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), c2.r3, this.f27400a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), c2.s3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.z zVar2 = new c.a.q0.v0.m1.d.z(frsGoodFragment.getPageContext(), c2.C3, this.f27400a.getUniqueId());
            c.a.q0.v0.r rVar2 = new c.a.q0.v0.r(frsGoodFragment.getPageContext(), c.a.q0.v0.s.f27155f);
            c.a.e.l.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f27400a.getUniqueId(), true);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), c2.Q3, this.f27400a.getUniqueId());
            c.a.e.l.e.a<?, ?> f2 = c.a.q0.x2.y.o().f(this.f27400a, AdvertAppInfo.n4);
            c.a.e.l.e.a<?, ?> f3 = c.a.q0.x2.y.o().f(this.f27400a, AdvertAppInfo.q4);
            x xVar = new x(frsGoodFragment.getPageContext(), c2.y3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.b bVar = new c.a.q0.v0.m1.d.b(frsGoodFragment.getPageContext(), c2.A3, this.f27400a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), c2.z3, this.f27400a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), c2.B3, this.f27400a.getUniqueId());
            c.a.q0.v0.m1.d.e eVar = new c.a.q0.v0.m1.d.e(frsGoodFragment.getPageContext(), c2.n3, this.f27400a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f27403d.add(yVar);
            this.f27403d.add(kVar);
            this.f27403d.add(vVar);
            this.f27403d.add(sVar);
            this.f27403d.add(jVar);
            this.f27403d.add(mVar);
            this.f27403d.add(wVar);
            this.f27403d.add(a0Var);
            this.f27403d.add(uVar);
            this.f27403d.add(rVar);
            this.f27403d.add(zVar);
            this.f27403d.add(pVar);
            this.f27403d.add(pVar);
            this.f27403d.add(tVar);
            this.f27403d.add(rVar2);
            this.f27403d.add(zVar);
            this.f27403d.add(zVar2);
            this.f27403d.add(xVar);
            this.f27403d.add(bVar);
            this.f27403d.add(gVar);
            this.f27403d.add(hVar);
            this.f27403d.add(eVar);
            if (a2 != null) {
                this.f27403d.add(a2);
            }
            if (d2 != null) {
                this.f27403d.add(d2);
            }
            this.f27403d.add(f2);
            this.f27403d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f27400a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f27403d.add(c.a.q0.w0.b.e().b(this.f27400a.getBaseFragmentActivity(), AdvertAppInfo.y4));
            this.f27403d.add(c.a.q0.w0.b.e().b(this.f27400a.getBaseFragmentActivity(), AdvertAppInfo.x4));
            c.a.q0.f.f.b bVar2 = new c.a.q0.f.f.b(this.f27400a, 1);
            bVar2.t(this.f27403d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f27403d);
            v("page_frs_good");
            for (c.a.e.l.e.a aVar : this.f27403d) {
                if (aVar instanceof c.a.q0.a0.a0) {
                    ((c.a.q0.a0.a0) aVar).l(true);
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
            for (c.a.e.l.e.a aVar : this.f27403d) {
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
            this.f27401b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f27401b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.l.e.a aVar : this.f27403d) {
                if (aVar instanceof k) {
                    ((k) aVar).k0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f27408i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f27401b.setData(this.f27406g);
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
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f27403d) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.q0.v0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            v.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f27401b.setData(switchThreadDataToThreadCardInfo);
            this.f27406g = switchThreadDataToThreadCardInfo;
            this.f27405f = arrayList;
            this.f27407h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f27403d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27403d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f27403d) || this.f27400a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27403d) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f27400a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f27403d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f27403d) {
            if (aVar instanceof k) {
                ((k) aVar).n0(frsViewData);
            }
        }
    }
}
