package c.a.p0.v0.e2;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.i3.v;
import c.a.p0.v0.m1.d.a0;
import c.a.p0.v0.m1.d.p;
import c.a.p0.v0.m1.d.r;
import c.a.p0.v0.m1.d.s;
import c.a.p0.v0.m1.d.t;
import c.a.p0.v0.m1.d.u;
import c.a.p0.v0.m1.d.w;
import c.a.p0.v0.m1.d.x;
import c.a.p0.v0.m1.d.y;
import c.a.p0.v0.m1.d.z;
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
    public FrsNewAreaFragment f25643a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25644b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f25645c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f25646d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, c2> f25647e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.e.k.e.n> f25648f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f25649g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f25650h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f25651a;

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
            this.f25651a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f25651a.f25645c)) {
                f fVar = this.f25651a;
                fVar.g(fVar.f25644b);
                f fVar2 = this.f25651a;
                fVar2.q(fVar2.f25648f, this.f25651a.f25649g);
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
        this.f25646d = new LinkedList();
        this.f25650h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f25644b = bdTypeRecyclerView;
        this.f25647e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f25643a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f25643a.registerListener(this.f25650h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f25643a != null && bdTypeRecyclerView != null) {
                this.f25645c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.p0.v0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = c.a.p0.v0.e.e().b(this.f25643a.getPageContext(), g2.get(i2), this.f25643a.getUniqueId());
                        if (b2 != null) {
                            this.f25646d.add(b2);
                            this.f25645c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f25645c)) {
                        return true;
                    }
                    bdTypeRecyclerView.addAdapters(this.f25645c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25647e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<c.a.e.k.e.n> arrayList) {
        HashMap<Integer, c2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.e.k.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f25647e) != null && !hashMap.containsValue(nVar)) {
                this.f25647e.put(Integer.valueOf(i2), (c2) nVar);
            }
        }
    }

    public List<c.a.e.k.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25648f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f25643a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.getTbPageContext(), c2.c3, this.f25643a.getUniqueId());
            yVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.k kVar = new c.a.p0.v0.m1.d.k(frsNewAreaFragment.getTbPageContext(), c2.d3, this.f25643a.getUniqueId());
            kVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.v vVar = new c.a.p0.v0.m1.d.v(frsNewAreaFragment.getTbPageContext(), c2.f3, this.f25643a.getUniqueId());
            vVar.q0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.getTbPageContext(), c2.g3, this.f25643a.getUniqueId());
            sVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.j jVar = new c.a.p0.v0.m1.d.j(frsNewAreaFragment.getTbPageContext(), c2.i3, this.f25643a.getUniqueId());
            jVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.m mVar = new c.a.p0.v0.m1.d.m(frsNewAreaFragment.getTbPageContext(), c2.j3, this.f25643a.getUniqueId());
            mVar.q0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.getTbPageContext(), c2.o3, this.f25643a.getUniqueId());
            a0Var.q0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.getTbPageContext(), c2.H3, this.f25643a.getUniqueId());
            wVar.q0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.getTbPageContext(), c2.p3, this.f25643a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.getTbPageContext(), c2.q3, this.f25643a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), c2.t3, this.f25643a.getUniqueId());
            zVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.l lVar = new c.a.p0.v0.m1.d.l(frsNewAreaFragment.getPageContext(), c2.M3, this.f25643a.getUniqueId());
            lVar.q0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), c2.r3, this.f25643a.getUniqueId());
            pVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.b bVar = new c.a.p0.v0.m1.d.b(frsNewAreaFragment.getPageContext(), c2.A3, this.f25643a.getUniqueId());
            bVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.g gVar = new c.a.p0.v0.m1.d.g(frsNewAreaFragment.getPageContext(), c2.z3, this.f25643a.getUniqueId());
            gVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.h hVar = new c.a.p0.v0.m1.d.h(frsNewAreaFragment.getPageContext(), c2.B3, this.f25643a.getUniqueId());
            hVar.q0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), c2.s3, this.f25643a.getUniqueId());
            tVar.q0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), c2.C3, this.f25643a.getUniqueId());
            zVar2.q0(bdTypeRecyclerView);
            c.a.p0.v0.r rVar2 = new c.a.p0.v0.r(frsNewAreaFragment.getPageContext(), c.a.p0.v0.s.f26816f);
            rVar2.q0(bdTypeRecyclerView);
            c.a.e.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> a2 = c.a.p0.v0.e.e().a(frsNewAreaFragment.getPageContext(), this.f25643a.getUniqueId(), true);
            c.a.e.k.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> d2 = c.a.p0.v0.e.e().d(frsNewAreaFragment.getPageContext(), c2.Q3, this.f25643a.getUniqueId());
            c.a.e.k.e.a<?, ?> f2 = c.a.p0.x2.y.o().f(this.f25643a, AdvertAppInfo.n4);
            c.a.e.k.e.a<?, ?> f3 = c.a.p0.x2.y.o().f(this.f25643a, AdvertAppInfo.q4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), c2.y3, this.f25643a.getUniqueId());
            xVar.q0(bdTypeRecyclerView);
            c.a.p0.v0.m1.d.e eVar = new c.a.p0.v0.m1.d.e(frsNewAreaFragment.getPageContext(), c2.n3, this.f25643a.getUniqueId());
            eVar.k0(bdTypeRecyclerView);
            this.f25646d.add(yVar);
            this.f25646d.add(kVar);
            this.f25646d.add(vVar);
            this.f25646d.add(sVar);
            this.f25646d.add(jVar);
            this.f25646d.add(mVar);
            this.f25646d.add(wVar);
            this.f25646d.add(a0Var);
            this.f25646d.add(uVar);
            this.f25646d.add(rVar);
            this.f25646d.add(zVar);
            this.f25646d.add(pVar);
            this.f25646d.add(bVar);
            this.f25646d.add(gVar);
            this.f25646d.add(hVar);
            this.f25646d.add(tVar);
            this.f25646d.add(rVar2);
            this.f25646d.add(lVar);
            this.f25646d.add(zVar2);
            this.f25646d.add(xVar);
            this.f25646d.add(eVar);
            if (a2 != null) {
                this.f25646d.add(a2);
            }
            if (d2 != null) {
                this.f25646d.add(d2);
            }
            this.f25646d.add(f2);
            this.f25646d.add(f3);
            c.a.e.k.e.a<?, ?> b2 = c.a.p0.w0.b.e().b(this.f25643a.getBaseFragmentActivity(), AdvertAppInfo.y4);
            c.a.e.k.e.a<?, ?> b3 = c.a.p0.w0.b.e().b(this.f25643a.getBaseFragmentActivity(), AdvertAppInfo.x4);
            this.f25646d.add(b2);
            this.f25646d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f25643a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.k.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.p0.v0.k) {
                        ((c.a.p0.v0.k) next).o(this.f25643a.getPageContext(), this.f25643a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.k.e.a> list = this.f25646d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            c.a.p0.f.f.b bVar2 = new c.a.p0.f.f.b(this.f25643a, 1);
            bVar2.t(this.f25646d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.addAdapters(this.f25646d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25644b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25644b.getAdapter().notifyDataSetChanged();
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
            for (c.a.e.k.e.a aVar : this.f25646d) {
                if (aVar instanceof c.a.p0.v0.k) {
                    ((c.a.p0.v0.k) aVar).k0();
                } else if (aVar instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f25644b.setData(this.f25648f);
            l();
        }
    }

    public void q(ArrayList<c.a.e.k.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            v.f(arrayList, 1);
            i(arrayList);
            this.f25644b.setData(arrayList);
            this.f25648f = arrayList;
            this.f25649g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f25646d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25646d) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f25646d) || this.f25643a == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25646d) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).s0(this.f25643a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f25646d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25646d) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).n0(frsViewData);
            }
        }
    }

    public void u(c.a.e.k.e.w wVar) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f25646d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25646d) {
            if (aVar != null && (aVar instanceof c.a.p0.v0.k)) {
                ((c.a.p0.v0.k) aVar).d0(wVar);
            }
        }
    }

    public final void v() {
        c.a.p0.v0.j2.b j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f25649g == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25646d) {
            if ((aVar instanceof c.a.p0.v0.j2.d) && (j2 = ((c.a.p0.v0.j2.d) aVar).j()) != null) {
                if (this.f25649g.needLog == 1) {
                    j2.f25937a = true;
                } else {
                    j2.f25937a = false;
                }
                if (this.f25649g.getForum() != null) {
                    j2.f25939c = this.f25649g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f25644b) == null || bdTypeRecyclerView.getData() == null || this.f25644b.getData().size() == 0) {
            return;
        }
        for (c.a.e.k.e.n nVar : this.f25644b.getData()) {
            if (nVar instanceof b2) {
                b2 b2Var = (b2) nVar;
                if (b2Var.w.p0() != 0) {
                    b2Var.w.W2();
                }
            }
        }
    }
}
