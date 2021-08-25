package c.a.q0.v0.e2;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.q0.i3.v;
import c.a.q0.v0.m1.d.a0;
import c.a.q0.v0.m1.d.p;
import c.a.q0.v0.m1.d.r;
import c.a.q0.v0.m1.d.s;
import c.a.q0.v0.m1.d.t;
import c.a.q0.v0.m1.d.u;
import c.a.q0.v0.m1.d.w;
import c.a.q0.v0.m1.d.x;
import c.a.q0.v0.m1.d.y;
import c.a.q0.v0.m1.d.z;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f25979a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25980b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25981c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25982d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, c2> f25983e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f25984f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f25985g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f25986h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f25987a;

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
            this.f25987a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f25987a.f25981c)) {
                f fVar = this.f25987a;
                fVar.g(fVar.f25980b);
                f fVar2 = this.f25987a;
                fVar2.q(fVar2.f25984f, this.f25987a.f25985g);
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
        this.f25982d = new LinkedList();
        this.f25986h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f25980b = bdTypeRecyclerView;
        this.f25983e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f25979a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f25979a.registerListener(this.f25986h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f25979a != null && bdTypeRecyclerView != null) {
                this.f25981c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.q0.v0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.q0.v0.e.e().b(this.f25979a.getPageContext(), g2.get(i2), this.f25979a.getUniqueId());
                        if (b2 != null) {
                            this.f25982d.add(b2);
                            this.f25981c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f25981c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f25981c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, c2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25983e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.e.l.e.n> arrayList) {
        HashMap<Integer, c2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.e.l.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f25983e) != null && !hashMap.containsValue(nVar)) {
                this.f25983e.put(Integer.valueOf(i2), (c2) nVar);
            }
        }
    }

    public List<c.a.e.l.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25984f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f25979a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), c2.c3, this.f25979a.getUniqueId());
            yVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.k kVar = new c.a.q0.v0.m1.d.k(frsNewAreaFragment.getTbPageContext(), c2.d3, this.f25979a.getUniqueId());
            kVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.v vVar = new c.a.q0.v0.m1.d.v(frsNewAreaFragment.getTbPageContext(), c2.f3, this.f25979a.getUniqueId());
            vVar.q0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), c2.g3, this.f25979a.getUniqueId());
            sVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.j jVar = new c.a.q0.v0.m1.d.j(frsNewAreaFragment.getTbPageContext(), c2.i3, this.f25979a.getUniqueId());
            jVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.m mVar = new c.a.q0.v0.m1.d.m(frsNewAreaFragment.getTbPageContext(), c2.j3, this.f25979a.getUniqueId());
            mVar.q0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), c2.o3, this.f25979a.getUniqueId());
            a0Var.q0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.getTbPageContext(), c2.H3, this.f25979a.getUniqueId());
            wVar.q0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), c2.p3, this.f25979a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), c2.q3, this.f25979a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), c2.t3, this.f25979a.getUniqueId());
            zVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.l lVar = new c.a.q0.v0.m1.d.l(frsNewAreaFragment.getPageContext(), c2.M3, this.f25979a.getUniqueId());
            lVar.q0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), c2.r3, this.f25979a.getUniqueId());
            pVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.b bVar = new c.a.q0.v0.m1.d.b(frsNewAreaFragment.getPageContext(), c2.A3, this.f25979a.getUniqueId());
            bVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.g gVar = new c.a.q0.v0.m1.d.g(frsNewAreaFragment.getPageContext(), c2.z3, this.f25979a.getUniqueId());
            gVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.h hVar = new c.a.q0.v0.m1.d.h(frsNewAreaFragment.getPageContext(), c2.B3, this.f25979a.getUniqueId());
            hVar.q0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), c2.s3, this.f25979a.getUniqueId());
            tVar.q0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), c2.C3, this.f25979a.getUniqueId());
            zVar2.q0(bdTypeRecyclerView);
            c.a.q0.v0.r rVar2 = new c.a.q0.v0.r(frsNewAreaFragment.getPageContext(), c.a.q0.v0.s.f27155f);
            rVar2.q0(bdTypeRecyclerView);
            c.a.e.l.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> a2 = c.a.q0.v0.e.e().a(frsNewAreaFragment.getPageContext(), this.f25979a.getUniqueId(), true);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> d2 = c.a.q0.v0.e.e().d(frsNewAreaFragment.getPageContext(), c2.Q3, this.f25979a.getUniqueId());
            c.a.e.l.e.a<?, ?> f2 = c.a.q0.x2.y.o().f(this.f25979a, AdvertAppInfo.n4);
            c.a.e.l.e.a<?, ?> f3 = c.a.q0.x2.y.o().f(this.f25979a, AdvertAppInfo.q4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), c2.y3, this.f25979a.getUniqueId());
            xVar.q0(bdTypeRecyclerView);
            c.a.q0.v0.m1.d.e eVar = new c.a.q0.v0.m1.d.e(frsNewAreaFragment.getPageContext(), c2.n3, this.f25979a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f25982d.add(yVar);
            this.f25982d.add(kVar);
            this.f25982d.add(vVar);
            this.f25982d.add(sVar);
            this.f25982d.add(jVar);
            this.f25982d.add(mVar);
            this.f25982d.add(wVar);
            this.f25982d.add(a0Var);
            this.f25982d.add(uVar);
            this.f25982d.add(rVar);
            this.f25982d.add(zVar);
            this.f25982d.add(pVar);
            this.f25982d.add(bVar);
            this.f25982d.add(gVar);
            this.f25982d.add(hVar);
            this.f25982d.add(tVar);
            this.f25982d.add(rVar2);
            this.f25982d.add(lVar);
            this.f25982d.add(zVar2);
            this.f25982d.add(xVar);
            this.f25982d.add(eVar);
            if (a2 != null) {
                this.f25982d.add(a2);
            }
            if (d2 != null) {
                this.f25982d.add(d2);
            }
            this.f25982d.add(f2);
            this.f25982d.add(f3);
            c.a.e.l.e.a<?, ?> b2 = c.a.q0.w0.b.e().b(this.f25979a.getBaseFragmentActivity(), AdvertAppInfo.y4);
            c.a.e.l.e.a<?, ?> b3 = c.a.q0.w0.b.e().b(this.f25979a.getBaseFragmentActivity(), AdvertAppInfo.x4);
            this.f25982d.add(b2);
            this.f25982d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f25979a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.q0.v0.k) {
                        ((c.a.q0.v0.k) next).o(this.f25979a.getPageContext(), this.f25979a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.l.e.a> list = this.f25982d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.q0.f.f.b bVar2 = new c.a.q0.f.f.b(this.f25979a, 1);
            bVar2.t(this.f25982d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f25982d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25980b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25980b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.l.e.a aVar : this.f25982d) {
                if (aVar instanceof c.a.q0.v0.k) {
                    ((c.a.q0.v0.k) aVar).k0();
                } else if (aVar instanceof c.a.q0.x2.p) {
                    ((c.a.q0.x2.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f25980b.setData(this.f25984f);
            l();
        }
    }

    public void q(ArrayList<c.a.e.l.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            v.f(arrayList, 1);
            i(arrayList);
            this.f25980b.setData(arrayList);
            this.f25984f = arrayList;
            this.f25985g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f25982d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f25982d) {
            if (aVar instanceof c.a.q0.v0.k) {
                ((c.a.q0.v0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f25982d) || this.f25979a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f25982d) {
            if (aVar instanceof c.a.q0.v0.k) {
                ((c.a.q0.v0.k) aVar).s0(this.f25979a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f25982d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f25982d) {
            if (aVar instanceof c.a.q0.v0.k) {
                ((c.a.q0.v0.k) aVar).n0(frsViewData);
            }
        }
    }

    public void u(c.a.e.l.e.w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f25982d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f25982d) {
            if (aVar != null && (aVar instanceof c.a.q0.v0.k)) {
                ((c.a.q0.v0.k) aVar).d0(wVar);
            }
        }
    }

    public final void v() {
        c.a.q0.v0.j2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f25985g == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f25982d) {
            if ((aVar instanceof c.a.q0.v0.j2.d) && (j2 = ((c.a.q0.v0.j2.d) aVar).j()) != null) {
                if (this.f25985g.needLog == 1) {
                    j2.f26273a = true;
                } else {
                    j2.f26273a = false;
                }
                if (this.f25985g.getForum() != null) {
                    j2.f26275c = this.f25985g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f25980b) == null || bdTypeRecyclerView.getData() == null || this.f25980b.getData().size() == 0) {
            return;
        }
        for (c.a.e.l.e.n nVar : this.f25980b.getData()) {
            if (nVar instanceof b2) {
                b2 b2Var = (b2) nVar;
                if (b2Var.w.p0() != 0) {
                    b2Var.w.W2();
                }
            }
        }
    }
}
