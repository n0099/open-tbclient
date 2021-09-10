package c.a.r0.w0.f2;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.j3.v;
import c.a.r0.w0.n1.d.a0;
import c.a.r0.w0.n1.d.p;
import c.a.r0.w0.n1.d.r;
import c.a.r0.w0.n1.d.s;
import c.a.r0.w0.n1.d.t;
import c.a.r0.w0.n1.d.u;
import c.a.r0.w0.n1.d.w;
import c.a.r0.w0.n1.d.x;
import c.a.r0.w0.n1.d.y;
import c.a.r0.w0.n1.d.z;
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
    public FrsNewAreaFragment f26666a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26667b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26668c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26669d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, d2> f26670e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.e.l.e.n> f26671f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f26672g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f26673h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26674a;

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
            this.f26674a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f26674a.f26668c)) {
                f fVar = this.f26674a;
                fVar.g(fVar.f26667b);
                f fVar2 = this.f26674a;
                fVar2.q(fVar2.f26671f, this.f26674a.f26672g);
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
        this.f26669d = new LinkedList();
        this.f26673h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f26667b = bdTypeRecyclerView;
        this.f26670e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f26666a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f26666a.registerListener(this.f26673h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f26666a != null && bdTypeRecyclerView != null) {
                this.f26668c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.r0.w0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.r0.w0.e.e().b(this.f26666a.getPageContext(), g2.get(i2), this.f26666a.getUniqueId());
                        if (b2 != null) {
                            this.f26669d.add(b2);
                            this.f26668c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f26668c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f26668c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26670e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.e.l.e.n> arrayList) {
        HashMap<Integer, d2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.e.l.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f26670e) != null && !hashMap.containsValue(nVar)) {
                this.f26670e.put(Integer.valueOf(i2), (d2) nVar);
            }
        }
    }

    public List<c.a.e.l.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26671f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f26666a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), d2.f3, this.f26666a.getUniqueId());
            yVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.k kVar = new c.a.r0.w0.n1.d.k(frsNewAreaFragment.getTbPageContext(), d2.g3, this.f26666a.getUniqueId());
            kVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.v vVar = new c.a.r0.w0.n1.d.v(frsNewAreaFragment.getTbPageContext(), d2.i3, this.f26666a.getUniqueId());
            vVar.q0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), d2.j3, this.f26666a.getUniqueId());
            sVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.j jVar = new c.a.r0.w0.n1.d.j(frsNewAreaFragment.getTbPageContext(), d2.l3, this.f26666a.getUniqueId());
            jVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.m mVar = new c.a.r0.w0.n1.d.m(frsNewAreaFragment.getTbPageContext(), d2.m3, this.f26666a.getUniqueId());
            mVar.q0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), d2.r3, this.f26666a.getUniqueId());
            a0Var.q0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.getTbPageContext(), d2.K3, this.f26666a.getUniqueId());
            wVar.q0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), d2.s3, this.f26666a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), d2.t3, this.f26666a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), d2.w3, this.f26666a.getUniqueId());
            zVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.l lVar = new c.a.r0.w0.n1.d.l(frsNewAreaFragment.getPageContext(), d2.P3, this.f26666a.getUniqueId());
            lVar.q0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), d2.u3, this.f26666a.getUniqueId());
            pVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.b bVar = new c.a.r0.w0.n1.d.b(frsNewAreaFragment.getPageContext(), d2.D3, this.f26666a.getUniqueId());
            bVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.g gVar = new c.a.r0.w0.n1.d.g(frsNewAreaFragment.getPageContext(), d2.C3, this.f26666a.getUniqueId());
            gVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.h hVar = new c.a.r0.w0.n1.d.h(frsNewAreaFragment.getPageContext(), d2.E3, this.f26666a.getUniqueId());
            hVar.q0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), d2.v3, this.f26666a.getUniqueId());
            tVar.q0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), d2.F3, this.f26666a.getUniqueId());
            zVar2.q0(bdTypeRecyclerView);
            c.a.r0.w0.r rVar2 = new c.a.r0.w0.r(frsNewAreaFragment.getPageContext(), c.a.r0.w0.s.f27756f);
            rVar2.q0(bdTypeRecyclerView);
            c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a2 = c.a.r0.w0.e.e().a(frsNewAreaFragment.getPageContext(), this.f26666a.getUniqueId(), true);
            c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d2 = c.a.r0.w0.e.e().d(frsNewAreaFragment.getPageContext(), d2.T3, this.f26666a.getUniqueId());
            c.a.e.l.e.a<?, ?> f2 = c.a.r0.y2.y.o().f(this.f26666a, AdvertAppInfo.q4);
            c.a.e.l.e.a<?, ?> f3 = c.a.r0.y2.y.o().f(this.f26666a, AdvertAppInfo.t4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), d2.B3, this.f26666a.getUniqueId());
            xVar.q0(bdTypeRecyclerView);
            c.a.r0.w0.n1.d.e eVar = new c.a.r0.w0.n1.d.e(frsNewAreaFragment.getPageContext(), d2.q3, this.f26666a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f26669d.add(yVar);
            this.f26669d.add(kVar);
            this.f26669d.add(vVar);
            this.f26669d.add(sVar);
            this.f26669d.add(jVar);
            this.f26669d.add(mVar);
            this.f26669d.add(wVar);
            this.f26669d.add(a0Var);
            this.f26669d.add(uVar);
            this.f26669d.add(rVar);
            this.f26669d.add(zVar);
            this.f26669d.add(pVar);
            this.f26669d.add(bVar);
            this.f26669d.add(gVar);
            this.f26669d.add(hVar);
            this.f26669d.add(tVar);
            this.f26669d.add(rVar2);
            this.f26669d.add(lVar);
            this.f26669d.add(zVar2);
            this.f26669d.add(xVar);
            this.f26669d.add(eVar);
            if (a2 != null) {
                this.f26669d.add(a2);
            }
            if (d2 != null) {
                this.f26669d.add(d2);
            }
            this.f26669d.add(f2);
            this.f26669d.add(f3);
            c.a.e.l.e.a<?, ?> b2 = c.a.r0.x0.b.e().b(this.f26666a.getBaseFragmentActivity(), AdvertAppInfo.B4);
            c.a.e.l.e.a<?, ?> b3 = c.a.r0.x0.b.e().b(this.f26666a.getBaseFragmentActivity(), AdvertAppInfo.A4);
            this.f26669d.add(b2);
            this.f26669d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f26666a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.w0.k) {
                        ((c.a.r0.w0.k) next).o(this.f26666a.getPageContext(), this.f26666a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.l.e.a> list = this.f26669d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.r0.f.f.b bVar2 = new c.a.r0.f.f.b(this.f26666a, 1);
            bVar2.t(this.f26669d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f26669d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26667b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26667b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.l.e.a aVar : this.f26669d) {
                if (aVar instanceof c.a.r0.w0.k) {
                    ((c.a.r0.w0.k) aVar).k0();
                } else if (aVar instanceof c.a.r0.y2.p) {
                    ((c.a.r0.y2.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26667b.setData(this.f26671f);
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
            this.f26667b.setData(arrayList);
            this.f26671f = arrayList;
            this.f26672g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f26669d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26669d) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f26669d) || this.f26666a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26669d) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).s0(this.f26666a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f26669d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26669d) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).n0(frsViewData);
            }
        }
    }

    public void u(c.a.e.l.e.w wVar) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f26669d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26669d) {
            if (aVar != null && (aVar instanceof c.a.r0.w0.k)) {
                ((c.a.r0.w0.k) aVar).d0(wVar);
            }
        }
    }

    public final void v() {
        c.a.r0.w0.k2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f26672g == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26669d) {
            if ((aVar instanceof c.a.r0.w0.k2.d) && (j2 = ((c.a.r0.w0.k2.d) aVar).j()) != null) {
                if (this.f26672g.needLog == 1) {
                    j2.f26939a = true;
                } else {
                    j2.f26939a = false;
                }
                if (this.f26672g.getForum() != null) {
                    j2.f26941c = this.f26672g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f26667b) == null || bdTypeRecyclerView.getData() == null || this.f26667b.getData().size() == 0) {
            return;
        }
        for (c.a.e.l.e.n nVar : this.f26667b.getData()) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.w.r0() != 0) {
                    c2Var.w.c3();
                }
            }
        }
    }
}
