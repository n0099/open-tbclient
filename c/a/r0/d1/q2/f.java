package c.a.r0.d1.q2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.y1.d.a0;
import c.a.r0.d1.y1.d.p;
import c.a.r0.d1.y1.d.r;
import c.a.r0.d1.y1.d.s;
import c.a.r0.d1.y1.d.t;
import c.a.r0.d1.y1.d.u;
import c.a.r0.d1.y1.d.v;
import c.a.r0.d1.y1.d.x;
import c.a.r0.d1.y1.d.y;
import c.a.r0.d1.y1.d.z;
import c.a.r0.t3.w;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f15852b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f15853c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f15854d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f15855e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.d.m.e.n> f15856f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f15857g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f15858h;

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.f15853c)) {
                f fVar = this.a;
                fVar.g(fVar.f15852b);
                f fVar2 = this.a;
                fVar2.q(fVar2.f15856f, this.a.f15857g);
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
        this.f15854d = new LinkedList();
        this.f15858h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f15852b = bdTypeRecyclerView;
        this.f15855e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.f15858h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.f15853c = new ArrayList();
                ArrayList<BdUniqueId> g2 = w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.r0.d1.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.r0.d1.e.e().b(this.a.getPageContext(), g2.get(i2), this.a.getUniqueId());
                        if (b2 != null) {
                            this.f15854d.add(b2);
                            this.f15853c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f15853c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f15853c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, d2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15855e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.d.m.e.n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.d.m.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f15855e) != null && !hashMap.containsValue(nVar)) {
                this.f15855e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<c.a.d.m.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15856f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), d2.l3, this.a.getUniqueId());
            yVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.k kVar = new c.a.r0.d1.y1.d.k(frsNewAreaFragment.getTbPageContext(), d2.m3, this.a.getUniqueId());
            kVar.p0(bdTypeRecyclerView);
            v vVar = new v(frsNewAreaFragment.getTbPageContext(), d2.o3, this.a.getUniqueId());
            vVar.p0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), d2.p3, this.a.getUniqueId());
            sVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.j jVar = new c.a.r0.d1.y1.d.j(frsNewAreaFragment.getTbPageContext(), d2.s3, this.a.getUniqueId());
            jVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.m mVar = new c.a.r0.d1.y1.d.m(frsNewAreaFragment.getTbPageContext(), d2.t3, this.a.getUniqueId());
            mVar.p0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), d2.y3, this.a.getUniqueId());
            a0Var.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.w wVar = new c.a.r0.d1.y1.d.w(frsNewAreaFragment.getTbPageContext(), d2.R3, this.a.getUniqueId());
            wVar.p0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), d2.z3, this.a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), d2.A3, this.a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), d2.D3, this.a.getUniqueId());
            zVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.l lVar = new c.a.r0.d1.y1.d.l(frsNewAreaFragment.getPageContext(), d2.V3, this.a.getUniqueId());
            lVar.p0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), d2.B3, this.a.getUniqueId());
            pVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.b bVar = new c.a.r0.d1.y1.d.b(frsNewAreaFragment.getPageContext(), d2.K3, this.a.getUniqueId());
            bVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.g gVar = new c.a.r0.d1.y1.d.g(frsNewAreaFragment.getPageContext(), d2.J3, this.a.getUniqueId());
            gVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.h hVar = new c.a.r0.d1.y1.d.h(frsNewAreaFragment.getPageContext(), d2.L3, this.a.getUniqueId());
            hVar.p0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), d2.C3, this.a.getUniqueId());
            tVar.p0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), d2.M3, this.a.getUniqueId());
            zVar2.p0(bdTypeRecyclerView);
            c.a.r0.d1.r rVar2 = new c.a.r0.d1.r(frsNewAreaFragment.getPageContext(), c.a.r0.d1.s.f15942f);
            rVar2.p0(bdTypeRecyclerView);
            c.a.d.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = c.a.r0.d1.e.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.d1.e.e().d(frsNewAreaFragment.getPageContext(), d2.Z3, this.a.getUniqueId());
            c.a.d.m.e.a<?, ?> f2 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.x4);
            c.a.d.m.e.a<?, ?> f3 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.A4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), d2.I3, this.a.getUniqueId());
            xVar.p0(bdTypeRecyclerView);
            c.a.r0.d1.y1.d.e eVar = new c.a.r0.d1.y1.d.e(frsNewAreaFragment.getPageContext(), d2.x3, this.a.getUniqueId());
            eVar.j0(bdTypeRecyclerView);
            this.f15854d.add(yVar);
            this.f15854d.add(kVar);
            this.f15854d.add(vVar);
            this.f15854d.add(sVar);
            this.f15854d.add(jVar);
            this.f15854d.add(mVar);
            this.f15854d.add(wVar);
            this.f15854d.add(a0Var);
            this.f15854d.add(uVar);
            this.f15854d.add(rVar);
            this.f15854d.add(zVar);
            this.f15854d.add(pVar);
            this.f15854d.add(bVar);
            this.f15854d.add(gVar);
            this.f15854d.add(hVar);
            this.f15854d.add(tVar);
            this.f15854d.add(rVar2);
            this.f15854d.add(lVar);
            this.f15854d.add(zVar2);
            this.f15854d.add(xVar);
            this.f15854d.add(eVar);
            if (a2 != null) {
                this.f15854d.add(a2);
            }
            if (d2 != null) {
                this.f15854d.add(d2);
            }
            this.f15854d.add(f2);
            this.f15854d.add(f3);
            c.a.d.m.e.a<?, ?> b2 = c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.I4);
            c.a.d.m.e.a<?, ?> b3 = c.a.r0.e1.b.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H4);
            this.f15854d.add(b2);
            this.f15854d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.d.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.m.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.d1.k) {
                        ((c.a.r0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.m.e.a> list = this.f15854d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.r0.h.f.b bVar2 = new c.a.r0.h.f.b(this.a, 1);
            bVar2.t(this.f15854d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f15854d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15852b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15852b.getAdapter().notifyDataSetChanged();
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
            for (c.a.d.m.e.a aVar : this.f15854d) {
                if (aVar instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) aVar).j0();
                } else if (aVar instanceof c.a.r0.h3.p) {
                    ((c.a.r0.h3.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f15852b.setData(this.f15856f);
            l();
        }
    }

    public void q(ArrayList<c.a.d.m.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            w.f(arrayList, 1);
            i(arrayList);
            this.f15852b.setData(arrayList);
            this.f15856f = arrayList;
            this.f15857g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f15854d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f15854d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f15854d) || this.a == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f15854d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).r0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f15854d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f15854d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).m0(frsViewData);
            }
        }
    }

    public void u(c.a.d.m.e.w wVar) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f15854d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f15854d) {
            if (aVar != null && (aVar instanceof c.a.r0.d1.k)) {
                ((c.a.r0.d1.k) aVar).c0(wVar);
            }
        }
    }

    public final void v() {
        c.a.r0.d1.v2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f15857g == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f15854d) {
            if ((aVar instanceof c.a.r0.d1.v2.d) && (j2 = ((c.a.r0.d1.v2.d) aVar).j()) != null) {
                if (this.f15857g.needLog == 1) {
                    j2.a = true;
                } else {
                    j2.a = false;
                }
                if (this.f15857g.getForum() != null) {
                    j2.f16084c = this.f15857g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f15852b) == null || bdTypeRecyclerView.getData() == null || this.f15852b.getData().size() == 0) {
            return;
        }
        for (c.a.d.m.e.n nVar : this.f15852b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.s0() != 0) {
                    c2Var.w.g3();
                }
            }
        }
    }
}
