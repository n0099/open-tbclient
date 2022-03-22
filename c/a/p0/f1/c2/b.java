package c.a.p0.f1.c2;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.o0.r.r.a2;
import c.a.p0.a4.x;
import c.a.p0.f1.e;
import c.a.p0.f1.k;
import c.a.p0.f1.o2.d;
import c.a.p0.f1.p1.d.a0;
import c.a.p0.f1.p1.d.g;
import c.a.p0.f1.p1.d.h;
import c.a.p0.f1.p1.d.j;
import c.a.p0.f1.p1.d.m;
import c.a.p0.f1.p1.d.p;
import c.a.p0.f1.p1.d.r;
import c.a.p0.f1.p1.d.s;
import c.a.p0.f1.p1.d.t;
import c.a.p0.f1.p1.d.u;
import c.a.p0.f1.p1.d.v;
import c.a.p0.f1.p1.d.y;
import c.a.p0.g1.c;
import c.a.p0.h0.z;
import c.a.p0.v.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
    public BdTypeRecyclerView f13875b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f13876c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f13877d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, ThreadData> f13878e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f13879f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f13880g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f13881h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f13877d != null) {
                    this.a.f13877d.addAll(arrayList);
                }
                if (this.a.f13875b != null) {
                    this.a.f13875b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: c.a.p0.f1.c2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1052b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1052b(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f13876c)) {
                b bVar = this.a;
                bVar.i(bVar.f13875b);
                b bVar2 = this.a;
                bVar2.w(bVar2.f13879f, this.a.f13881h);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13877d = new LinkedList();
        this.i = new a(this, 2003008);
        this.j = new C1052b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f13875b = bdTypeRecyclerView;
        this.f13878e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c.a.d.o.e.a aVar : this.f13877d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f13877d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f13877d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).V(wVar);
            }
        }
    }

    public final void C() {
        c.a.p0.f1.o2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f13881h == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f13877d) {
            if ((aVar instanceof d) && (j = ((d) aVar).j()) != null) {
                if (this.f13881h.needLog == 1) {
                    j.a = true;
                } else {
                    j.a = false;
                }
                if (this.f13881h.getForum() != null) {
                    j.f14300c = this.f13881h.getForum().getId();
                    j.f14301d = this.f13881h.getForum().getName();
                }
                if (this.a != null) {
                    j.f14299b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f13875b) == null || bdTypeRecyclerView.getData() == null || this.f13875b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f13875b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.s.getIs_top() != 0) {
                    a2Var.s.parser_title();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f13876c = new ArrayList();
                ArrayList<BdUniqueId> g2 = x.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i = 0; i < size; i++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.a.getPageContext(), g2.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f13877d.add(b2);
                            this.f13876c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f13876c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f13876c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13878e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f13878e) != null && !hashMap.containsValue(nVar)) {
                this.f13878e.put(Integer.valueOf(i), (ThreadData) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13879f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13880g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            y yVar = new y(frsGoodFragment.j(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            c.a.p0.f1.p1.d.k kVar = new c.a.p0.f1.p1.d.k(frsGoodFragment.j(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            v vVar = new v(frsGoodFragment.j(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            s sVar = new s(frsGoodFragment.j(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            j jVar = new j(frsGoodFragment.j(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            m mVar = new m(frsGoodFragment.j(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.j(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            c.a.p0.f1.p1.d.w wVar = new c.a.p0.f1.p1.d.w(frsGoodFragment.j(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            u uVar = new u(frsGoodFragment.j(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            r rVar = new r(frsGoodFragment.j(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            c.a.p0.f1.p1.d.z zVar = new c.a.p0.f1.p1.d.z(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            c.a.p0.f1.p1.d.z zVar2 = new c.a.p0.f1.p1.d.z(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            c.a.p0.f1.r rVar2 = new c.a.p0.f1.r(frsGoodFragment.getPageContext(), c.a.p0.f1.s.f14508b);
            c.a.d.o.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.o.e.a<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            c.a.d.o.e.a<?, ?> f2 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.w);
            c.a.d.o.e.a<?, ?> f3 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.z);
            c.a.p0.f1.p1.d.x xVar = new c.a.p0.f1.p1.d.x(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            c.a.p0.f1.p1.d.b bVar = new c.a.p0.f1.p1.d.b(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            c.a.p0.f1.p1.d.e eVar = new c.a.p0.f1.p1.d.e(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            eVar.c0(bdTypeRecyclerView);
            this.f13877d.add(yVar);
            this.f13877d.add(kVar);
            this.f13877d.add(vVar);
            this.f13877d.add(sVar);
            this.f13877d.add(jVar);
            this.f13877d.add(mVar);
            this.f13877d.add(wVar);
            this.f13877d.add(a0Var);
            this.f13877d.add(uVar);
            this.f13877d.add(rVar);
            this.f13877d.add(zVar);
            this.f13877d.add(pVar);
            this.f13877d.add(pVar);
            this.f13877d.add(tVar);
            this.f13877d.add(rVar2);
            this.f13877d.add(zVar);
            this.f13877d.add(zVar2);
            this.f13877d.add(xVar);
            this.f13877d.add(bVar);
            this.f13877d.add(gVar);
            this.f13877d.add(hVar);
            this.f13877d.add(eVar);
            if (a2 != null) {
                this.f13877d.add(a2);
            }
            if (d2 != null) {
                this.f13877d.add(d2);
            }
            this.f13877d.add(f2);
            this.f13877d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f13877d.add(c.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H));
            this.f13877d.add(c.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.G));
            c.a.p0.h.f.b bVar2 = new c.a.p0.h.f.b(this.a, 1);
            bVar2.t(this.f13877d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f13877d);
            v("page_frs_good");
            for (c.a.d.o.e.a aVar : this.f13877d) {
                if (aVar instanceof c.a.p0.h0.a0) {
                    ((c.a.p0.h0.a0) aVar).l(true);
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
            for (c.a.d.o.e.a aVar : this.f13877d) {
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
            this.f13875b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f13875b.getAdapter().notifyDataSetChanged();
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (c.a.d.o.e.a aVar : this.f13877d) {
                if (aVar instanceof k) {
                    ((k) aVar).c0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f13875b.setData(this.f13880g);
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
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f13877d) == null) {
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
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof c.a.p0.f1.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            x.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f13875b.setData(switchThreadDataToThreadCardInfo);
            this.f13880g = switchThreadDataToThreadCardInfo;
            this.f13879f = arrayList;
            this.f13881h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f13877d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f13877d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f13877d) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f13877d) {
            if (aVar instanceof k) {
                ((k) aVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f13877d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f13877d) {
            if (aVar instanceof k) {
                ((k) aVar).f0(frsViewData);
            }
        }
    }
}
