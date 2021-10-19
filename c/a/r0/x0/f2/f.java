package c.a.r0.x0.f2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.k3.w;
import c.a.r0.x0.n1.d.a0;
import c.a.r0.x0.n1.d.p;
import c.a.r0.x0.n1.d.r;
import c.a.r0.x0.n1.d.s;
import c.a.r0.x0.n1.d.t;
import c.a.r0.x0.n1.d.u;
import c.a.r0.x0.n1.d.v;
import c.a.r0.x0.n1.d.x;
import c.a.r0.x0.n1.d.y;
import c.a.r0.x0.n1.d.z;
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
    public FrsNewAreaFragment f26864a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26865b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26866c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26867d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f26868e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f26869f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f26870g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f26871h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26872a;

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
            this.f26872a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f26872a.f26866c)) {
                f fVar = this.f26872a;
                fVar.g(fVar.f26865b);
                f fVar2 = this.f26872a;
                fVar2.q(fVar2.f26869f, this.f26872a.f26870g);
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
        this.f26867d = new LinkedList();
        this.f26871h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f26865b = bdTypeRecyclerView;
        this.f26868e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f26864a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f26864a.registerListener(this.f26871h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f26864a != null && bdTypeRecyclerView != null) {
                this.f26866c = new ArrayList();
                ArrayList<BdUniqueId> g2 = w.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.r0.x0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.r0.x0.e.e().b(this.f26864a.getPageContext(), g2.get(i2), this.f26864a.getUniqueId());
                        if (b2 != null) {
                            this.f26867d.add(b2);
                            this.f26866c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f26866c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f26866c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26868e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.e.l.e.n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.e.l.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f26868e) != null && !hashMap.containsValue(nVar)) {
                this.f26868e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<c.a.e.l.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26869f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f26864a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), d2.g3, this.f26864a.getUniqueId());
            yVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.k kVar = new c.a.r0.x0.n1.d.k(frsNewAreaFragment.getTbPageContext(), d2.h3, this.f26864a.getUniqueId());
            kVar.q0(bdTypeRecyclerView);
            v vVar = new v(frsNewAreaFragment.getTbPageContext(), d2.j3, this.f26864a.getUniqueId());
            vVar.q0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), d2.k3, this.f26864a.getUniqueId());
            sVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.j jVar = new c.a.r0.x0.n1.d.j(frsNewAreaFragment.getTbPageContext(), d2.m3, this.f26864a.getUniqueId());
            jVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.m mVar = new c.a.r0.x0.n1.d.m(frsNewAreaFragment.getTbPageContext(), d2.n3, this.f26864a.getUniqueId());
            mVar.q0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), d2.s3, this.f26864a.getUniqueId());
            a0Var.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.w wVar = new c.a.r0.x0.n1.d.w(frsNewAreaFragment.getTbPageContext(), d2.L3, this.f26864a.getUniqueId());
            wVar.q0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), d2.t3, this.f26864a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), d2.u3, this.f26864a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), d2.x3, this.f26864a.getUniqueId());
            zVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.l lVar = new c.a.r0.x0.n1.d.l(frsNewAreaFragment.getPageContext(), d2.Q3, this.f26864a.getUniqueId());
            lVar.q0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), d2.v3, this.f26864a.getUniqueId());
            pVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.b bVar = new c.a.r0.x0.n1.d.b(frsNewAreaFragment.getPageContext(), d2.E3, this.f26864a.getUniqueId());
            bVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.g gVar = new c.a.r0.x0.n1.d.g(frsNewAreaFragment.getPageContext(), d2.D3, this.f26864a.getUniqueId());
            gVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.h hVar = new c.a.r0.x0.n1.d.h(frsNewAreaFragment.getPageContext(), d2.F3, this.f26864a.getUniqueId());
            hVar.q0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), d2.w3, this.f26864a.getUniqueId());
            tVar.q0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), d2.G3, this.f26864a.getUniqueId());
            zVar2.q0(bdTypeRecyclerView);
            c.a.r0.x0.r rVar2 = new c.a.r0.x0.r(frsNewAreaFragment.getPageContext(), c.a.r0.x0.s.f27952f);
            rVar2.q0(bdTypeRecyclerView);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = c.a.r0.x0.e.e().a(frsNewAreaFragment.getPageContext(), this.f26864a.getUniqueId(), true);
            c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.x0.e.e().d(frsNewAreaFragment.getPageContext(), d2.U3, this.f26864a.getUniqueId());
            c.a.e.l.e.a<?, ?> f2 = c.a.r0.z2.y.o().f(this.f26864a, AdvertAppInfo.r4);
            c.a.e.l.e.a<?, ?> f3 = c.a.r0.z2.y.o().f(this.f26864a, AdvertAppInfo.u4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), d2.C3, this.f26864a.getUniqueId());
            xVar.q0(bdTypeRecyclerView);
            c.a.r0.x0.n1.d.e eVar = new c.a.r0.x0.n1.d.e(frsNewAreaFragment.getPageContext(), d2.r3, this.f26864a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f26867d.add(yVar);
            this.f26867d.add(kVar);
            this.f26867d.add(vVar);
            this.f26867d.add(sVar);
            this.f26867d.add(jVar);
            this.f26867d.add(mVar);
            this.f26867d.add(wVar);
            this.f26867d.add(a0Var);
            this.f26867d.add(uVar);
            this.f26867d.add(rVar);
            this.f26867d.add(zVar);
            this.f26867d.add(pVar);
            this.f26867d.add(bVar);
            this.f26867d.add(gVar);
            this.f26867d.add(hVar);
            this.f26867d.add(tVar);
            this.f26867d.add(rVar2);
            this.f26867d.add(lVar);
            this.f26867d.add(zVar2);
            this.f26867d.add(xVar);
            this.f26867d.add(eVar);
            if (a2 != null) {
                this.f26867d.add(a2);
            }
            if (d2 != null) {
                this.f26867d.add(d2);
            }
            this.f26867d.add(f2);
            this.f26867d.add(f3);
            c.a.e.l.e.a<?, ?> b2 = c.a.r0.y0.b.e().b(this.f26864a.getBaseFragmentActivity(), AdvertAppInfo.C4);
            c.a.e.l.e.a<?, ?> b3 = c.a.r0.y0.b.e().b(this.f26864a.getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.f26867d.add(b2);
            this.f26867d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f26864a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.x0.k) {
                        ((c.a.r0.x0.k) next).o(this.f26864a.getPageContext(), this.f26864a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.l.e.a> list = this.f26867d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.r0.g.f.b bVar2 = new c.a.r0.g.f.b(this.f26864a, 1);
            bVar2.t(this.f26867d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f26867d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26865b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26865b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.l.e.a aVar : this.f26867d) {
                if (aVar instanceof c.a.r0.x0.k) {
                    ((c.a.r0.x0.k) aVar).k0();
                } else if (aVar instanceof c.a.r0.z2.p) {
                    ((c.a.r0.z2.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26865b.setData(this.f26869f);
            l();
        }
    }

    public void q(ArrayList<c.a.e.l.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            w.f(arrayList, 1);
            i(arrayList);
            this.f26865b.setData(arrayList);
            this.f26869f = arrayList;
            this.f26870g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f26867d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26867d) {
            if (aVar instanceof c.a.r0.x0.k) {
                ((c.a.r0.x0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f26867d) || this.f26864a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26867d) {
            if (aVar instanceof c.a.r0.x0.k) {
                ((c.a.r0.x0.k) aVar).s0(this.f26864a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f26867d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26867d) {
            if (aVar instanceof c.a.r0.x0.k) {
                ((c.a.r0.x0.k) aVar).n0(frsViewData);
            }
        }
    }

    public void u(c.a.e.l.e.w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f26867d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26867d) {
            if (aVar != null && (aVar instanceof c.a.r0.x0.k)) {
                ((c.a.r0.x0.k) aVar).d0(wVar);
            }
        }
    }

    public final void v() {
        c.a.r0.x0.k2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f26870g == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26867d) {
            if ((aVar instanceof c.a.r0.x0.k2.d) && (j2 = ((c.a.r0.x0.k2.d) aVar).j()) != null) {
                if (this.f26870g.needLog == 1) {
                    j2.f27134a = true;
                } else {
                    j2.f27134a = false;
                }
                if (this.f26870g.getForum() != null) {
                    j2.f27136c = this.f26870g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f26865b) == null || bdTypeRecyclerView.getData() == null || this.f26865b.getData().size() == 0) {
            return;
        }
        for (c.a.e.l.e.n nVar : this.f26865b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.c3();
                }
            }
        }
    }
}
