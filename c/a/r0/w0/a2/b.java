package c.a.r0.w0.a2;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.a0.z;
import c.a.r0.j3.v;
import c.a.r0.o.f;
import c.a.r0.w0.e;
import c.a.r0.w0.k;
import c.a.r0.w0.k2.d;
import c.a.r0.w0.n1.d.a0;
import c.a.r0.w0.n1.d.g;
import c.a.r0.w0.n1.d.h;
import c.a.r0.w0.n1.d.j;
import c.a.r0.w0.n1.d.m;
import c.a.r0.w0.n1.d.p;
import c.a.r0.w0.n1.d.r;
import c.a.r0.w0.n1.d.s;
import c.a.r0.w0.n1.d.t;
import c.a.r0.w0.n1.d.u;
import c.a.r0.w0.n1.d.x;
import c.a.r0.w0.n1.d.y;
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
    public FrsGoodFragment f26436a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26437b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26438c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26439d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f26440e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f26441f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f26442g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f26443h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f26444i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f26445j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26446a;

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
            this.f26446a = bVar;
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
                        ((k) next).o(this.f26446a.f26436a.getPageContext(), this.f26446a.f26436a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f26446a.f26439d != null) {
                    this.f26446a.f26439d.addAll(arrayList);
                }
                if (this.f26446a.f26437b != null) {
                    this.f26446a.f26437b.addAdapters(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.r0.w0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1244b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26447a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1244b(b bVar, int i2) {
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
            this.f26447a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f26447a.f26438c)) {
                b bVar = this.f26447a;
                bVar.i(bVar.f26437b);
                b bVar2 = this.f26447a;
                bVar2.w(bVar2.f26441f, this.f26447a.f26443h);
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
        this.f26439d = new LinkedList();
        this.f26444i = new a(this, 2003008);
        this.f26445j = new C1244b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f26437b = bdTypeRecyclerView;
        this.f26440e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.e.l.e.a aVar : this.f26439d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f26439d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26439d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).d0(wVar);
            }
        }
    }

    public final void C() {
        c.a.r0.w0.k2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26443h == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26439d) {
            if ((aVar instanceof d) && (j2 = ((d) aVar).j()) != null) {
                if (this.f26443h.needLog == 1) {
                    j2.f26939a = true;
                } else {
                    j2.f26939a = false;
                }
                if (this.f26443h.getForum() != null) {
                    j2.f26941c = this.f26443h.getForum().getId();
                }
                if (this.f26436a != null) {
                    j2.f26940b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f26437b) == null || bdTypeRecyclerView.getData() == null || this.f26437b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f26437b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.c3();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f26436a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f26436a.registerListener(this.f26445j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f26436a != null && bdTypeRecyclerView != null) {
                this.f26438c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f26436a.getPageContext(), g2.get(i2), this.f26436a.getUniqueId());
                        if (b2 != null) {
                            this.f26439d.add(b2);
                            this.f26438c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f26438c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f26438c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26440e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f26440e) != null && !hashMap.containsValue(nVar)) {
                this.f26440e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26441f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26442g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f26436a = frsGoodFragment;
            this.f26444i.setPriority(1);
            this.f26444i.setSelfListener(true);
            this.f26436a.registerListener(this.f26444i);
            y yVar = new y(frsGoodFragment.getTbPageContext(), d2.f3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.k kVar = new c.a.r0.w0.n1.d.k(frsGoodFragment.getTbPageContext(), d2.g3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.v vVar = new c.a.r0.w0.n1.d.v(frsGoodFragment.getTbPageContext(), d2.i3, this.f26436a.getUniqueId());
            s sVar = new s(frsGoodFragment.getTbPageContext(), d2.j3, this.f26436a.getUniqueId());
            j jVar = new j(frsGoodFragment.getTbPageContext(), d2.l3, this.f26436a.getUniqueId());
            m mVar = new m(frsGoodFragment.getTbPageContext(), d2.m3, this.f26436a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.getTbPageContext(), d2.r3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.w wVar = new c.a.r0.w0.n1.d.w(frsGoodFragment.getTbPageContext(), d2.K3, this.f26436a.getUniqueId());
            u uVar = new u(frsGoodFragment.getTbPageContext(), d2.s3, this.f26436a.getUniqueId());
            r rVar = new r(frsGoodFragment.getTbPageContext(), d2.t3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.z zVar = new c.a.r0.w0.n1.d.z(frsGoodFragment.getPageContext(), d2.w3, this.f26436a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), d2.u3, this.f26436a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), d2.v3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.z zVar2 = new c.a.r0.w0.n1.d.z(frsGoodFragment.getPageContext(), d2.F3, this.f26436a.getUniqueId());
            c.a.r0.w0.r rVar2 = new c.a.r0.w0.r(frsGoodFragment.getPageContext(), c.a.r0.w0.s.f27756f);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f26436a.getUniqueId(), true);
            c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), d2.T3, this.f26436a.getUniqueId());
            c.a.e.l.e.a<?, ?> f2 = c.a.r0.y2.y.o().f(this.f26436a, AdvertAppInfo.q4);
            c.a.e.l.e.a<?, ?> f3 = c.a.r0.y2.y.o().f(this.f26436a, AdvertAppInfo.t4);
            x xVar = new x(frsGoodFragment.getPageContext(), d2.B3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.b bVar = new c.a.r0.w0.n1.d.b(frsGoodFragment.getPageContext(), d2.D3, this.f26436a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), d2.C3, this.f26436a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), d2.E3, this.f26436a.getUniqueId());
            c.a.r0.w0.n1.d.e eVar = new c.a.r0.w0.n1.d.e(frsGoodFragment.getPageContext(), d2.q3, this.f26436a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f26439d.add(yVar);
            this.f26439d.add(kVar);
            this.f26439d.add(vVar);
            this.f26439d.add(sVar);
            this.f26439d.add(jVar);
            this.f26439d.add(mVar);
            this.f26439d.add(wVar);
            this.f26439d.add(a0Var);
            this.f26439d.add(uVar);
            this.f26439d.add(rVar);
            this.f26439d.add(zVar);
            this.f26439d.add(pVar);
            this.f26439d.add(pVar);
            this.f26439d.add(tVar);
            this.f26439d.add(rVar2);
            this.f26439d.add(zVar);
            this.f26439d.add(zVar2);
            this.f26439d.add(xVar);
            this.f26439d.add(bVar);
            this.f26439d.add(gVar);
            this.f26439d.add(hVar);
            this.f26439d.add(eVar);
            if (a2 != null) {
                this.f26439d.add(a2);
            }
            if (d2 != null) {
                this.f26439d.add(d2);
            }
            this.f26439d.add(f2);
            this.f26439d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f26436a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f26439d.add(c.a.r0.x0.b.e().b(this.f26436a.getBaseFragmentActivity(), AdvertAppInfo.B4));
            this.f26439d.add(c.a.r0.x0.b.e().b(this.f26436a.getBaseFragmentActivity(), AdvertAppInfo.A4));
            c.a.r0.f.f.b bVar2 = new c.a.r0.f.f.b(this.f26436a, 1);
            bVar2.t(this.f26439d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f26439d);
            v("page_frs_good");
            for (c.a.e.l.e.a aVar : this.f26439d) {
                if (aVar instanceof c.a.r0.a0.a0) {
                    ((c.a.r0.a0.a0) aVar).l(true);
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
            for (c.a.e.l.e.a aVar : this.f26439d) {
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
            this.f26437b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26437b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.l.e.a aVar : this.f26439d) {
                if (aVar instanceof k) {
                    ((k) aVar).k0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f26444i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f26437b.setData(this.f26442g);
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
            if (it.next().getType() == d2.Y2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f26439d) == null) {
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
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.r0.w0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            v.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f26437b.setData(switchThreadDataToThreadCardInfo);
            this.f26442g = switchThreadDataToThreadCardInfo;
            this.f26441f = arrayList;
            this.f26443h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f26439d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26439d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f26439d) || this.f26436a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26439d) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f26436a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f26439d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26439d) {
            if (aVar instanceof k) {
                ((k) aVar).n0(frsViewData);
            }
        }
    }
}
