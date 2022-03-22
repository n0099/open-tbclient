package c.a.p0.f1.h2;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.a2;
import c.a.p0.a4.x;
import c.a.p0.f1.p1.d.a0;
import c.a.p0.f1.p1.d.p;
import c.a.p0.f1.p1.d.r;
import c.a.p0.f1.p1.d.s;
import c.a.p0.f1.p1.d.t;
import c.a.p0.f1.p1.d.u;
import c.a.p0.f1.p1.d.v;
import c.a.p0.f1.p1.d.w;
import c.a.p0.f1.p1.d.y;
import c.a.p0.f1.p1.d.z;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f14031b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14032c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14033d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, ThreadData> f14034e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.d.o.e.n> f14035f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f14036g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f14037h;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i)};
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
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f14032c)) {
                f fVar = this.a;
                fVar.g(fVar.f14031b);
                f fVar2 = this.a;
                fVar2.q(fVar2.f14035f, this.a.f14036g);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14033d = new LinkedList();
        this.f14037h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f14031b = bdTypeRecyclerView;
        this.f14034e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f14037h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f14032c = new ArrayList();
                ArrayList<BdUniqueId> g2 = x.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i = 0; i < size; i++) {
                        c.a.p0.f1.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.p0.f1.e.e().b(this.a.getPageContext(), g2.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f14033d.add(b2);
                            this.f14032c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f14032c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f14032c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14034e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.d.o.e.n> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            c.a.d.o.e.n nVar = arrayList.get(i);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f14034e) != null && !hashMap.containsValue(nVar)) {
                this.f14034e.put(Integer.valueOf(i), (ThreadData) nVar);
            }
        }
    }

    public List<c.a.d.o.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14035f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.j(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            yVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.k kVar = new c.a.p0.f1.p1.d.k(frsNewAreaFragment.j(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            kVar.h0(bdTypeRecyclerView);
            v vVar = new v(frsNewAreaFragment.j(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            vVar.h0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.j(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            sVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.j jVar = new c.a.p0.f1.p1.d.j(frsNewAreaFragment.j(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            jVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.m mVar = new c.a.p0.f1.p1.d.m(frsNewAreaFragment.j(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            mVar.h0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.j(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            a0Var.h0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.j(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            wVar.h0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.j(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.j(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            zVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.l lVar = new c.a.p0.f1.p1.d.l(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            lVar.h0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            pVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.b bVar = new c.a.p0.f1.p1.d.b(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            bVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.g gVar = new c.a.p0.f1.p1.d.g(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            gVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.h hVar = new c.a.p0.f1.p1.d.h(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            hVar.h0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            tVar.h0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            zVar2.h0(bdTypeRecyclerView);
            c.a.p0.f1.r rVar2 = new c.a.p0.f1.r(frsNewAreaFragment.getPageContext(), c.a.p0.f1.s.f14508b);
            rVar2.h0(bdTypeRecyclerView);
            c.a.d.o.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = c.a.p0.f1.e.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.o.e.a<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d2 = c.a.p0.f1.e.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            c.a.d.o.e.a<?, ?> f2 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.w);
            c.a.d.o.e.a<?, ?> f3 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.z);
            c.a.p0.f1.p1.d.x xVar = new c.a.p0.f1.p1.d.x(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xVar.h0(bdTypeRecyclerView);
            c.a.p0.f1.p1.d.e eVar = new c.a.p0.f1.p1.d.e(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            eVar.c0(bdTypeRecyclerView);
            this.f14033d.add(yVar);
            this.f14033d.add(kVar);
            this.f14033d.add(vVar);
            this.f14033d.add(sVar);
            this.f14033d.add(jVar);
            this.f14033d.add(mVar);
            this.f14033d.add(wVar);
            this.f14033d.add(a0Var);
            this.f14033d.add(uVar);
            this.f14033d.add(rVar);
            this.f14033d.add(zVar);
            this.f14033d.add(pVar);
            this.f14033d.add(bVar);
            this.f14033d.add(gVar);
            this.f14033d.add(hVar);
            this.f14033d.add(tVar);
            this.f14033d.add(rVar2);
            this.f14033d.add(lVar);
            this.f14033d.add(zVar2);
            this.f14033d.add(xVar);
            this.f14033d.add(eVar);
            if (a2 != null) {
                this.f14033d.add(a2);
            }
            if (d2 != null) {
                this.f14033d.add(d2);
            }
            this.f14033d.add(f2);
            this.f14033d.add(f3);
            c.a.d.o.e.a<?, ?> b2 = c.a.p0.g1.c.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            c.a.d.o.e.a<?, ?> b3 = c.a.p0.g1.c.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.f14033d.add(b2);
            this.f14033d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.d.o.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.p0.f1.k) {
                        ((c.a.p0.f1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.o.e.a> list = this.f14033d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.p0.h.f.b bVar2 = new c.a.p0.h.f.b(this.a, 1);
            bVar2.t(this.f14033d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f14033d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f14031b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14031b.getAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (c.a.d.o.e.a aVar : this.f14033d) {
                if (aVar instanceof c.a.p0.f1.k) {
                    ((c.a.p0.f1.k) aVar).c0();
                } else if (aVar instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f14031b.setData(this.f14035f);
            l();
        }
    }

    public void q(ArrayList<c.a.d.o.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            x.f(arrayList, 1);
            i(arrayList);
            this.f14031b.setData(arrayList);
            this.f14035f = arrayList;
            this.f14036g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f14033d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14033d) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f14033d) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14033d) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f14033d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14033d) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).f0(frsViewData);
            }
        }
    }

    public void u(c.a.d.o.e.w wVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f14033d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14033d) {
            if (aVar != null && (aVar instanceof c.a.p0.f1.k)) {
                ((c.a.p0.f1.k) aVar).V(wVar);
            }
        }
    }

    public final void v() {
        c.a.p0.f1.o2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f14036g == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14033d) {
            if ((aVar instanceof c.a.p0.f1.o2.d) && (j = ((c.a.p0.f1.o2.d) aVar).j()) != null) {
                if (this.f14036g.needLog == 1) {
                    j.a = true;
                } else {
                    j.a = false;
                }
                if (this.f14036g.getForum() != null) {
                    j.f14300c = this.f14036g.getForum().getId();
                    j.f14301d = this.f14036g.getForum().getName();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f14031b) == null || bdTypeRecyclerView.getData() == null || this.f14031b.getData().size() == 0) {
            return;
        }
        for (c.a.d.o.e.n nVar : this.f14031b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.s.getIs_top() != 0) {
                    a2Var.s.parser_title();
                }
            }
        }
    }
}
