package b.a.r0.x0.q2;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.m3.w;
import b.a.r0.x0.y1.d.a0;
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
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f27732a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f27733b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27734c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f27735d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f27736e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<b.a.e.m.e.n> f27737f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f27738g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f27739h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27740a;

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
            this.f27740a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f27740a.f27734c)) {
                f fVar = this.f27740a;
                fVar.g(fVar.f27733b);
                f fVar2 = this.f27740a;
                fVar2.q(fVar2.f27737f, this.f27740a.f27738g);
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
        this.f27735d = new LinkedList();
        this.f27739h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f27733b = bdTypeRecyclerView;
        this.f27736e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f27732a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f27732a.registerListener(this.f27739h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f27732a != null && bdTypeRecyclerView != null) {
                this.f27734c = new ArrayList();
                ArrayList<BdUniqueId> g2 = w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        b.a.r0.x0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = b.a.r0.x0.e.e().b(this.f27732a.getPageContext(), g2.get(i2), this.f27732a.getUniqueId());
                        if (b2 != null) {
                            this.f27735d.add(b2);
                            this.f27734c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f27734c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f27734c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27736e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<b.a.e.m.e.n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            b.a.e.m.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f27736e) != null && !hashMap.containsValue(nVar)) {
                this.f27736e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<b.a.e.m.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27737f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f27732a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), d2.h3, this.f27732a.getUniqueId());
            yVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.k kVar = new b.a.r0.x0.y1.d.k(frsNewAreaFragment.getTbPageContext(), d2.i3, this.f27732a.getUniqueId());
            kVar.p0(bdTypeRecyclerView);
            v vVar = new v(frsNewAreaFragment.getTbPageContext(), d2.k3, this.f27732a.getUniqueId());
            vVar.p0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), d2.l3, this.f27732a.getUniqueId());
            sVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.j jVar = new b.a.r0.x0.y1.d.j(frsNewAreaFragment.getTbPageContext(), d2.o3, this.f27732a.getUniqueId());
            jVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.m mVar = new b.a.r0.x0.y1.d.m(frsNewAreaFragment.getTbPageContext(), d2.p3, this.f27732a.getUniqueId());
            mVar.p0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), d2.u3, this.f27732a.getUniqueId());
            a0Var.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.w wVar = new b.a.r0.x0.y1.d.w(frsNewAreaFragment.getTbPageContext(), d2.N3, this.f27732a.getUniqueId());
            wVar.p0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), d2.v3, this.f27732a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), d2.w3, this.f27732a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), d2.z3, this.f27732a.getUniqueId());
            zVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.l lVar = new b.a.r0.x0.y1.d.l(frsNewAreaFragment.getPageContext(), d2.R3, this.f27732a.getUniqueId());
            lVar.p0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), d2.x3, this.f27732a.getUniqueId());
            pVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.b bVar = new b.a.r0.x0.y1.d.b(frsNewAreaFragment.getPageContext(), d2.G3, this.f27732a.getUniqueId());
            bVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.g gVar = new b.a.r0.x0.y1.d.g(frsNewAreaFragment.getPageContext(), d2.F3, this.f27732a.getUniqueId());
            gVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.h hVar = new b.a.r0.x0.y1.d.h(frsNewAreaFragment.getPageContext(), d2.H3, this.f27732a.getUniqueId());
            hVar.p0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), d2.y3, this.f27732a.getUniqueId());
            tVar.p0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), d2.I3, this.f27732a.getUniqueId());
            zVar2.p0(bdTypeRecyclerView);
            b.a.r0.x0.r rVar2 = new b.a.r0.x0.r(frsNewAreaFragment.getPageContext(), b.a.r0.x0.s.f27833f);
            rVar2.p0(bdTypeRecyclerView);
            b.a.e.m.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = b.a.r0.x0.e.e().a(frsNewAreaFragment.getPageContext(), this.f27732a.getUniqueId(), true);
            b.a.e.m.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = b.a.r0.x0.e.e().d(frsNewAreaFragment.getPageContext(), d2.V3, this.f27732a.getUniqueId());
            b.a.e.m.e.a<?, ?> f2 = b.a.r0.a3.y.o().f(this.f27732a, AdvertAppInfo.s4);
            b.a.e.m.e.a<?, ?> f3 = b.a.r0.a3.y.o().f(this.f27732a, AdvertAppInfo.v4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), d2.E3, this.f27732a.getUniqueId());
            xVar.p0(bdTypeRecyclerView);
            b.a.r0.x0.y1.d.e eVar = new b.a.r0.x0.y1.d.e(frsNewAreaFragment.getPageContext(), d2.t3, this.f27732a.getUniqueId());
            eVar.j0(bdTypeRecyclerView);
            this.f27735d.add(yVar);
            this.f27735d.add(kVar);
            this.f27735d.add(vVar);
            this.f27735d.add(sVar);
            this.f27735d.add(jVar);
            this.f27735d.add(mVar);
            this.f27735d.add(wVar);
            this.f27735d.add(a0Var);
            this.f27735d.add(uVar);
            this.f27735d.add(rVar);
            this.f27735d.add(zVar);
            this.f27735d.add(pVar);
            this.f27735d.add(bVar);
            this.f27735d.add(gVar);
            this.f27735d.add(hVar);
            this.f27735d.add(tVar);
            this.f27735d.add(rVar2);
            this.f27735d.add(lVar);
            this.f27735d.add(zVar2);
            this.f27735d.add(xVar);
            this.f27735d.add(eVar);
            if (a2 != null) {
                this.f27735d.add(a2);
            }
            if (d2 != null) {
                this.f27735d.add(d2);
            }
            this.f27735d.add(f2);
            this.f27735d.add(f3);
            b.a.e.m.e.a<?, ?> b2 = b.a.r0.y0.b.e().b(this.f27732a.getBaseFragmentActivity(), AdvertAppInfo.D4);
            b.a.e.m.e.a<?, ?> b3 = b.a.r0.y0.b.e().b(this.f27732a.getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.f27735d.add(b2);
            this.f27735d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f27732a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<b.a.e.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    b.a.e.m.e.a<?, ?> next = it.next();
                    if (next instanceof b.a.r0.x0.k) {
                        ((b.a.r0.x0.k) next).o(this.f27732a.getPageContext(), this.f27732a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<b.a.e.m.e.a> list = this.f27735d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            b.a.r0.g.f.b bVar2 = new b.a.r0.g.f.b(this.f27732a, 1);
            bVar2.t(this.f27735d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f27735d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27733b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27733b.getAdapter().notifyDataSetChanged();
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
            for (b.a.e.m.e.a aVar : this.f27735d) {
                if (aVar instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) aVar).j0();
                } else if (aVar instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f27733b.setData(this.f27737f);
            l();
        }
    }

    public void q(ArrayList<b.a.e.m.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            w.f(arrayList, 1);
            i(arrayList);
            this.f27733b.setData(arrayList);
            this.f27737f = arrayList;
            this.f27738g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f27735d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27735d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f27735d) || this.f27732a == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27735d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).r0(this.f27732a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f27735d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27735d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).m0(frsViewData);
            }
        }
    }

    public void u(b.a.e.m.e.w wVar) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f27735d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27735d) {
            if (aVar != null && (aVar instanceof b.a.r0.x0.k)) {
                ((b.a.r0.x0.k) aVar).c0(wVar);
            }
        }
    }

    public final void v() {
        b.a.r0.x0.v2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f27738g == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f27735d) {
            if ((aVar instanceof b.a.r0.x0.v2.d) && (j = ((b.a.r0.x0.v2.d) aVar).j()) != null) {
                if (this.f27738g.needLog == 1) {
                    j.f27991a = true;
                } else {
                    j.f27991a = false;
                }
                if (this.f27738g.getForum() != null) {
                    j.f27993c = this.f27738g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f27733b) == null || bdTypeRecyclerView.getData() == null || this.f27733b.getData().size() == 0) {
            return;
        }
        for (b.a.e.m.e.n nVar : this.f27733b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.e3();
                }
            }
        }
    }
}
