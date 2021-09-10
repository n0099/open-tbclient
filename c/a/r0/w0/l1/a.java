package c.a.r0.w0.l1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.w0.n1.d.a0;
import c.a.r0.w0.n1.d.e;
import c.a.r0.w0.n1.d.g;
import c.a.r0.w0.n1.d.h;
import c.a.r0.w0.n1.d.j;
import c.a.r0.w0.n1.d.k;
import c.a.r0.w0.n1.d.l;
import c.a.r0.w0.n1.d.m;
import c.a.r0.w0.n1.d.p;
import c.a.r0.w0.n1.d.s;
import c.a.r0.w0.n1.d.t;
import c.a.r0.w0.n1.d.u;
import c.a.r0.w0.n1.d.v;
import c.a.r0.w0.n1.d.w;
import c.a.r0.w0.n1.d.x;
import c.a.r0.w0.n1.d.y;
import c.a.r0.w0.n1.d.z;
import c.a.r0.w0.r;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f26959a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26960b;

    /* renamed from: c  reason: collision with root package name */
    public r f26961c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26962d;

    /* renamed from: e  reason: collision with root package name */
    public y f26963e;

    /* renamed from: f  reason: collision with root package name */
    public k f26964f;

    /* renamed from: g  reason: collision with root package name */
    public v f26965g;

    /* renamed from: h  reason: collision with root package name */
    public s f26966h;

    /* renamed from: i  reason: collision with root package name */
    public j f26967i;

    /* renamed from: j  reason: collision with root package name */
    public m f26968j;
    public w k;
    public a0 l;
    public u m;
    public c.a.r0.w0.n1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.r0.w0.n1.d.a t;
    public c.a.r0.w0.n1.d.c u;
    public c.a.r0.w0.n1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.r0.w0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1264a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26969a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1264a(a aVar, int i2) {
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
            this.f26969a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<c.a.e.l.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.a0.y) {
                        c.a.r0.a0.y yVar = (c.a.r0.a0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.f26969a.f26962d != null) {
                            yVar.o(this.f26969a.f26959a.getPageContext(), this.f26969a.f26959a.getUniqueId());
                            if (this.f26969a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.f26969a.f26962d.add(next);
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
        this.f26962d = new LinkedList();
        this.B = new C1264a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f26960b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f26959a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f26959a.registerListener(this.B);
            this.f26963e = new y(frsCommonTabFragment.getTbPageContext(), d2.f3, frsCommonTabFragment.getUniqueId());
            this.f26964f = new k(frsCommonTabFragment.getTbPageContext(), d2.g3, frsCommonTabFragment.getUniqueId());
            this.f26965g = new v(frsCommonTabFragment.getTbPageContext(), d2.i3, frsCommonTabFragment.getUniqueId());
            this.f26966h = new s(frsCommonTabFragment.getTbPageContext(), d2.j3, frsCommonTabFragment.getUniqueId());
            this.f26967i = new j(frsCommonTabFragment.getTbPageContext(), d2.l3, frsCommonTabFragment.getUniqueId());
            this.f26968j = new m(frsCommonTabFragment.getTbPageContext(), d2.m3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), d2.K3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), d2.r3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), d2.s3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.w0(frsCommonTabFragment.tabType);
            c.a.r0.w0.n1.d.r rVar = new c.a.r0.w0.n1.d.r(frsCommonTabFragment.getTbPageContext(), d2.t3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.w0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), d2.w3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), d2.P3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), d2.v3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), d2.u3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), d2.B3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.r0.w0.n1.d.a(frsCommonTabFragment.getPageContext(), d2.o3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.r0.w0.n1.d.c(frsCommonTabFragment.getPageContext(), d2.k3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.r0.w0.n1.d.b(frsCommonTabFragment.getPageContext(), d2.D3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), d2.C3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), d2.E3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), d2.F3, frsCommonTabFragment.getUniqueId());
            this.f26961c = new r(frsCommonTabFragment.getPageContext(), c.a.r0.w0.s.f27756f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), d2.q3, frsCommonTabFragment.getUniqueId());
            }
            this.f26962d.add(this.f26963e);
            this.f26962d.add(this.f26964f);
            this.f26962d.add(this.f26965g);
            this.f26962d.add(this.f26966h);
            this.f26962d.add(this.f26967i);
            this.f26962d.add(this.f26968j);
            this.f26962d.add(this.k);
            this.f26962d.add(this.l);
            this.f26962d.add(this.m);
            this.f26962d.add(this.n);
            this.f26962d.add(this.o);
            this.f26962d.add(this.p);
            this.f26962d.add(this.q);
            this.f26962d.add(this.r);
            this.f26962d.add(this.s);
            this.f26962d.add(this.t);
            this.f26962d.add(this.u);
            this.f26962d.add(this.v);
            this.f26962d.add(this.w);
            this.f26962d.add(this.x);
            this.f26962d.add(this.y);
            this.f26962d.add(this.f26961c);
            if (!z) {
                this.f26962d.add(this.z);
            }
            e();
            for (c.a.e.l.e.a aVar : this.f26962d) {
                if (aVar instanceof c.a.r0.w0.k) {
                    c.a.r0.w0.k kVar = (c.a.r0.w0.k) aVar;
                    kVar.q0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof c.a.r0.a0.z) {
                    ((c.a.r0.a0.z) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f26959a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.w0.k) {
                        ((c.a.r0.w0.k) next).o(this.f26959a.getPageContext(), this.f26959a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.l.e.a> list = this.f26962d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f26962d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.l.e.a<?, ?> f2 = c.a.r0.y2.y.o().f(this.f26959a, AdvertAppInfo.q4);
            c.a.e.l.e.a<?, ?> f3 = c.a.r0.y2.y.o().f(this.f26959a, AdvertAppInfo.t4);
            c.a.e.l.e.a<?, ?> f4 = c.a.r0.y2.y.o().f(this.f26959a, AdvertAppInfo.u4);
            c.a.e.l.e.a<?, ?> f5 = c.a.r0.y2.y.o().f(this.f26959a, AdvertAppInfo.v4);
            c.a.e.l.e.a<?, ?> f6 = c.a.r0.y2.y.o().f(this.f26959a, AdvertAppInfo.w4);
            this.f26962d.add(f2);
            this.f26962d.add(f3);
            this.f26962d.add(f4);
            this.f26962d.add(f5);
            this.f26962d.add(f6);
            c.a.e.l.e.a<?, ?> d2 = c.a.r0.x0.b.e().d(this.f26959a.getBaseFragmentActivity(), AdvertAppInfo.B4);
            c.a.e.l.e.a<?, ?> d3 = c.a.r0.x0.b.e().d(this.f26959a.getBaseFragmentActivity(), AdvertAppInfo.A4);
            this.f26962d.add(d2);
            this.f26962d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26960b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.e.l.e.a aVar : this.f26962d) {
                if (aVar instanceof c.a.r0.w0.k) {
                    ((c.a.r0.w0.k) aVar).k0();
                } else if (aVar instanceof c.a.r0.y2.p) {
                    ((c.a.r0.y2.p) aVar).onDestroy();
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
                    if (d2Var.s0() != null) {
                        if (!d2Var.H2()) {
                            arrayList2.add(next);
                        } else {
                            d2Var.Z3(null);
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
            this.f26960b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f26962d) || this.f26959a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26962d) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).s0(this.f26959a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f26962d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26962d) {
            if (aVar instanceof c.a.r0.w0.k) {
                ((c.a.r0.w0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f26959a == null || ListUtils.isEmpty(this.f26962d)) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26962d) {
            if (aVar instanceof c.a.r0.w0.k2.d) {
                c.a.r0.w0.k2.d dVar = (c.a.r0.w0.k2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f26939a = this.f26959a.needLog;
                    dVar.j().f26941c = this.f26959a.forumId;
                    dVar.j().f26942d = this.f26959a.tabId;
                    c.a.r0.w0.k2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f26959a;
                    j2.f26945g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f26944f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f26944f = 12;
                    }
                }
            }
        }
    }
}
