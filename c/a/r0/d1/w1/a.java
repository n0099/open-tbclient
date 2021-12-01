package c.a.r0.d1.w1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.d1.r;
import c.a.r0.d1.y1.d.a0;
import c.a.r0.d1.y1.d.e;
import c.a.r0.d1.y1.d.g;
import c.a.r0.d1.y1.d.h;
import c.a.r0.d1.y1.d.j;
import c.a.r0.d1.y1.d.k;
import c.a.r0.d1.y1.d.l;
import c.a.r0.d1.y1.d.m;
import c.a.r0.d1.y1.d.p;
import c.a.r0.d1.y1.d.s;
import c.a.r0.d1.y1.d.t;
import c.a.r0.d1.y1.d.u;
import c.a.r0.d1.y1.d.v;
import c.a.r0.d1.y1.d.w;
import c.a.r0.d1.y1.d.x;
import c.a.r0.d1.y1.d.y;
import c.a.r0.d1.y1.d.z;
import c.a.r0.g0.b0;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f16102b;

    /* renamed from: c  reason: collision with root package name */
    public r f16103c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.m.e.a> f16104d;

    /* renamed from: e  reason: collision with root package name */
    public y f16105e;

    /* renamed from: f  reason: collision with root package name */
    public k f16106f;

    /* renamed from: g  reason: collision with root package name */
    public v f16107g;

    /* renamed from: h  reason: collision with root package name */
    public s f16108h;

    /* renamed from: i  reason: collision with root package name */
    public j f16109i;

    /* renamed from: j  reason: collision with root package name */
    public m f16110j;

    /* renamed from: k  reason: collision with root package name */
    public w f16111k;
    public a0 l;
    public u m;
    public c.a.r0.d1.y1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.r0.d1.y1.d.a t;
    public c.a.r0.d1.y1.d.c u;
    public c.a.r0.d1.y1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.r0.d1.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0969a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0969a(a aVar, int i2) {
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
                Iterator<c.a.d.m.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.d.m.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.g0.a0) {
                        c.a.r0.g0.a0 a0Var = (c.a.r0.g0.a0) next;
                        if ("FrsHottopicDelegateAdapter".equals(a0Var.from()) && this.a.f16104d != null) {
                            a0Var.o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                a0Var.setFrom("c13010");
                            }
                            this.a.f16104d.add(next);
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
        this.f16104d = new LinkedList();
        this.B = new C0969a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f16102b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.a.registerListener(this.B);
            this.f16105e = new y(frsCommonTabFragment.getTbPageContext(), d2.l3, frsCommonTabFragment.getUniqueId());
            this.f16106f = new k(frsCommonTabFragment.getTbPageContext(), d2.m3, frsCommonTabFragment.getUniqueId());
            this.f16107g = new v(frsCommonTabFragment.getTbPageContext(), d2.o3, frsCommonTabFragment.getUniqueId());
            this.f16108h = new s(frsCommonTabFragment.getTbPageContext(), d2.p3, frsCommonTabFragment.getUniqueId());
            this.f16109i = new j(frsCommonTabFragment.getTbPageContext(), d2.s3, frsCommonTabFragment.getUniqueId());
            this.f16110j = new m(frsCommonTabFragment.getTbPageContext(), d2.t3, frsCommonTabFragment.getUniqueId());
            this.f16111k = new w(frsCommonTabFragment.getTbPageContext(), d2.R3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), d2.y3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), d2.z3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.v0(frsCommonTabFragment.tabType);
            c.a.r0.d1.y1.d.r rVar = new c.a.r0.d1.y1.d.r(frsCommonTabFragment.getTbPageContext(), d2.A3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.v0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), d2.D3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), d2.V3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), d2.C3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), d2.B3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), d2.I3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.r0.d1.y1.d.a(frsCommonTabFragment.getPageContext(), d2.v3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.r0.d1.y1.d.c(frsCommonTabFragment.getPageContext(), d2.q3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.r0.d1.y1.d.b(frsCommonTabFragment.getPageContext(), d2.K3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), d2.J3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), d2.L3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), d2.M3, frsCommonTabFragment.getUniqueId());
            this.f16103c = new r(frsCommonTabFragment.getPageContext(), c.a.r0.d1.s.f15942f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), d2.x3, frsCommonTabFragment.getUniqueId());
            }
            this.f16104d.add(this.f16105e);
            this.f16104d.add(this.f16106f);
            this.f16104d.add(this.f16107g);
            this.f16104d.add(this.f16108h);
            this.f16104d.add(this.f16109i);
            this.f16104d.add(this.f16110j);
            this.f16104d.add(this.f16111k);
            this.f16104d.add(this.l);
            this.f16104d.add(this.m);
            this.f16104d.add(this.n);
            this.f16104d.add(this.o);
            this.f16104d.add(this.p);
            this.f16104d.add(this.q);
            this.f16104d.add(this.r);
            this.f16104d.add(this.s);
            this.f16104d.add(this.t);
            this.f16104d.add(this.u);
            this.f16104d.add(this.v);
            this.f16104d.add(this.w);
            this.f16104d.add(this.x);
            this.f16104d.add(this.y);
            this.f16104d.add(this.f16103c);
            if (!z) {
                this.f16104d.add(this.z);
            }
            e();
            for (c.a.d.m.e.a aVar : this.f16104d) {
                if (aVar instanceof c.a.r0.d1.k) {
                    c.a.r0.d1.k kVar = (c.a.r0.d1.k) aVar;
                    kVar.p0(bdTypeRecyclerView);
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
                Iterator<c.a.d.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.m.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.d1.k) {
                        ((c.a.r0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.m.e.a> list = this.f16104d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f16104d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.m.e.a<?, ?> f2 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.x4);
            c.a.d.m.e.a<?, ?> f3 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.A4);
            c.a.d.m.e.a<?, ?> f4 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.B4);
            c.a.d.m.e.a<?, ?> f5 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.C4);
            c.a.d.m.e.a<?, ?> f6 = c.a.r0.h3.y.q().f(this.a, AdvertAppInfo.D4);
            this.f16104d.add(f2);
            this.f16104d.add(f3);
            this.f16104d.add(f4);
            this.f16104d.add(f5);
            this.f16104d.add(f6);
            c.a.d.m.e.a<?, ?> d2 = c.a.r0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.I4);
            c.a.d.m.e.a<?, ?> d3 = c.a.r0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H4);
            this.f16104d.add(d2);
            this.f16104d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16102b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.d.m.e.a aVar : this.f16104d) {
                if (aVar instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) aVar).j0();
                } else if (aVar instanceof c.a.r0.h3.p) {
                    ((c.a.r0.h3.p) aVar).onDestroy();
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
            this.f16102b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f16104d) || this.a == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16104d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).r0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f16104d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16104d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.f16104d)) {
            return;
        }
        for (c.a.d.m.e.a aVar : this.f16104d) {
            if (aVar instanceof c.a.r0.d1.v2.d) {
                c.a.r0.d1.v2.d dVar = (c.a.r0.d1.v2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().a = this.a.needLog;
                    dVar.j().f16084c = this.a.forumId;
                    dVar.j().f16085d = this.a.tabId;
                    c.a.r0.d1.v2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    j2.f16088g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f16087f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f16087f = 12;
                    }
                }
            }
        }
    }
}
