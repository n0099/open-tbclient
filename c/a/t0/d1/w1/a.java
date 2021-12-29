package c.a.t0.d1.w1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.t0.d1.r;
import c.a.t0.d1.y1.d.a0;
import c.a.t0.d1.y1.d.e;
import c.a.t0.d1.y1.d.g;
import c.a.t0.d1.y1.d.h;
import c.a.t0.d1.y1.d.j;
import c.a.t0.d1.y1.d.k;
import c.a.t0.d1.y1.d.l;
import c.a.t0.d1.y1.d.m;
import c.a.t0.d1.y1.d.p;
import c.a.t0.d1.y1.d.s;
import c.a.t0.d1.y1.d.t;
import c.a.t0.d1.y1.d.u;
import c.a.t0.d1.y1.d.v;
import c.a.t0.d1.y1.d.w;
import c.a.t0.d1.y1.d.x;
import c.a.t0.d1.y1.d.y;
import c.a.t0.d1.y1.d.z;
import c.a.t0.g0.b0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17007b;

    /* renamed from: c  reason: collision with root package name */
    public r f17008c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.n.e.a> f17009d;

    /* renamed from: e  reason: collision with root package name */
    public y f17010e;

    /* renamed from: f  reason: collision with root package name */
    public k f17011f;

    /* renamed from: g  reason: collision with root package name */
    public v f17012g;

    /* renamed from: h  reason: collision with root package name */
    public s f17013h;

    /* renamed from: i  reason: collision with root package name */
    public j f17014i;

    /* renamed from: j  reason: collision with root package name */
    public m f17015j;

    /* renamed from: k  reason: collision with root package name */
    public w f17016k;
    public a0 l;
    public u m;
    public c.a.t0.d1.y1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.t0.d1.y1.d.a t;
    public c.a.t0.d1.y1.d.c u;
    public c.a.t0.d1.y1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.t0.d1.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1038a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1038a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<c.a.d.n.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.t0.g0.a0) {
                        c.a.t0.g0.a0 a0Var = (c.a.t0.g0.a0) next;
                        if ("FrsHottopicDelegateAdapter".equals(a0Var.from()) && this.a.f17009d != null) {
                            a0Var.o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                a0Var.setFrom("c13010");
                            }
                            this.a.f17009d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17009d = new LinkedList();
        this.B = new C1038a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f17007b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.a.registerListener(this.B);
            this.f17010e = new y(frsCommonTabFragment.getTbPageContext(), d2.o3, frsCommonTabFragment.getUniqueId());
            this.f17011f = new k(frsCommonTabFragment.getTbPageContext(), d2.p3, frsCommonTabFragment.getUniqueId());
            this.f17012g = new v(frsCommonTabFragment.getTbPageContext(), d2.r3, frsCommonTabFragment.getUniqueId());
            this.f17013h = new s(frsCommonTabFragment.getTbPageContext(), d2.s3, frsCommonTabFragment.getUniqueId());
            this.f17014i = new j(frsCommonTabFragment.getTbPageContext(), d2.v3, frsCommonTabFragment.getUniqueId());
            this.f17015j = new m(frsCommonTabFragment.getTbPageContext(), d2.w3, frsCommonTabFragment.getUniqueId());
            this.f17016k = new w(frsCommonTabFragment.getTbPageContext(), d2.U3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), d2.B3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), d2.C3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.o0(frsCommonTabFragment.tabType);
            c.a.t0.d1.y1.d.r rVar = new c.a.t0.d1.y1.d.r(frsCommonTabFragment.getTbPageContext(), d2.D3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.o0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), d2.G3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), d2.Y3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), d2.F3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), d2.E3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), d2.L3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.t0.d1.y1.d.a(frsCommonTabFragment.getPageContext(), d2.y3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.t0.d1.y1.d.c(frsCommonTabFragment.getPageContext(), d2.t3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.t0.d1.y1.d.b(frsCommonTabFragment.getPageContext(), d2.N3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), d2.M3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), d2.O3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), d2.P3, frsCommonTabFragment.getUniqueId());
            this.f17008c = new r(frsCommonTabFragment.getPageContext(), c.a.t0.d1.s.f16847f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), d2.A3, frsCommonTabFragment.getUniqueId());
            }
            this.f17009d.add(this.f17010e);
            this.f17009d.add(this.f17011f);
            this.f17009d.add(this.f17012g);
            this.f17009d.add(this.f17013h);
            this.f17009d.add(this.f17014i);
            this.f17009d.add(this.f17015j);
            this.f17009d.add(this.f17016k);
            this.f17009d.add(this.l);
            this.f17009d.add(this.m);
            this.f17009d.add(this.n);
            this.f17009d.add(this.o);
            this.f17009d.add(this.p);
            this.f17009d.add(this.q);
            this.f17009d.add(this.r);
            this.f17009d.add(this.s);
            this.f17009d.add(this.t);
            this.f17009d.add(this.u);
            this.f17009d.add(this.v);
            this.f17009d.add(this.w);
            this.f17009d.add(this.x);
            this.f17009d.add(this.y);
            this.f17009d.add(this.f17008c);
            if (!z) {
                this.f17009d.add(this.z);
            }
            e();
            for (c.a.d.n.e.a aVar : this.f17009d) {
                if (aVar instanceof c.a.t0.d1.k) {
                    c.a.t0.d1.k kVar = (c.a.t0.d1.k) aVar;
                    kVar.i0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof b0) {
                    ((b0) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.d.n.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.t0.d1.k) {
                        ((c.a.t0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.n.e.a> list = this.f17009d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f17009d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.n.e.a<?, ?> f2 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.A4);
            c.a.d.n.e.a<?, ?> f3 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.D4);
            c.a.d.n.e.a<?, ?> f4 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.E4);
            c.a.d.n.e.a<?, ?> f5 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.F4);
            c.a.d.n.e.a<?, ?> f6 = c.a.t0.j3.y.q().f(this.a, AdvertAppInfo.G4);
            this.f17009d.add(f2);
            this.f17009d.add(f3);
            this.f17009d.add(f4);
            this.f17009d.add(f5);
            this.f17009d.add(f6);
            c.a.d.n.e.a<?, ?> d2 = c.a.t0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4);
            c.a.d.n.e.a<?, ?> d3 = c.a.t0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.K4);
            this.f17009d.add(d2);
            this.f17009d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17007b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.d.n.e.a aVar : this.f17009d) {
                if (aVar instanceof c.a.t0.d1.k) {
                    ((c.a.t0.d1.k) aVar).c0();
                } else if (aVar instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar).onDestroy();
                }
            }
        }
    }

    public final ArrayList<n> h(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    if (d2Var.t0() != null) {
                        if (!d2Var.L2()) {
                            arrayList2.add(next);
                        } else {
                            d2Var.d4(null);
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void i(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            k();
            this.f17007b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f17009d) || this.a == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f17009d) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f17009d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f17009d) {
            if (aVar instanceof c.a.t0.d1.k) {
                ((c.a.t0.d1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.f17009d)) {
            return;
        }
        for (c.a.d.n.e.a aVar : this.f17009d) {
            if (aVar instanceof c.a.t0.d1.v2.d) {
                c.a.t0.d1.v2.d dVar = (c.a.t0.d1.v2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().a = this.a.needLog;
                    dVar.j().f16989c = this.a.forumId;
                    dVar.j().f16990d = this.a.tabId;
                    c.a.t0.d1.v2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    j2.f16993g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f16992f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f16992f = 12;
                    }
                }
            }
        }
    }
}
