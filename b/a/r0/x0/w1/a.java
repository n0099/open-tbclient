package b.a.r0.x0.w1;

import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.b0.b0;
import b.a.r0.x0.r;
import b.a.r0.x0.y1.d.a0;
import b.a.r0.x0.y1.d.e;
import b.a.r0.x0.y1.d.g;
import b.a.r0.x0.y1.d.h;
import b.a.r0.x0.y1.d.j;
import b.a.r0.x0.y1.d.k;
import b.a.r0.x0.y1.d.l;
import b.a.r0.x0.y1.d.m;
import b.a.r0.x0.y1.d.p;
import b.a.r0.x0.y1.d.s;
import b.a.r0.x0.y1.d.t;
import b.a.r0.x0.y1.d.u;
import b.a.r0.x0.y1.d.v;
import b.a.r0.x0.y1.d.w;
import b.a.r0.x0.y1.d.x;
import b.a.r0.x0.y1.d.y;
import b.a.r0.x0.y1.d.z;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f28014a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f28015b;

    /* renamed from: c  reason: collision with root package name */
    public r f28016c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.m.e.a> f28017d;

    /* renamed from: e  reason: collision with root package name */
    public y f28018e;

    /* renamed from: f  reason: collision with root package name */
    public k f28019f;

    /* renamed from: g  reason: collision with root package name */
    public v f28020g;

    /* renamed from: h  reason: collision with root package name */
    public s f28021h;

    /* renamed from: i  reason: collision with root package name */
    public j f28022i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public b.a.r0.x0.y1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public b.a.r0.x0.y1.d.a t;
    public b.a.r0.x0.y1.d.c u;
    public b.a.r0.x0.y1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: b.a.r0.x0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1368a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28023a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1368a(a aVar, int i2) {
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
            this.f28023a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<b.a.e.m.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    b.a.e.m.e.a<?, ?> next = it.next();
                    if (next instanceof b.a.r0.b0.a0) {
                        b.a.r0.b0.a0 a0Var = (b.a.r0.b0.a0) next;
                        if ("FrsHottopicDelegateAdapter".equals(a0Var.from()) && this.f28023a.f28017d != null) {
                            a0Var.o(this.f28023a.f28014a.getPageContext(), this.f28023a.f28014a.getUniqueId());
                            if (this.f28023a.A) {
                                a0Var.setFrom("c13010");
                            }
                            this.f28023a.f28017d.add(next);
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
        this.f28017d = new LinkedList();
        this.B = new C1368a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f28015b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f28014a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f28014a.registerListener(this.B);
            this.f28018e = new y(frsCommonTabFragment.getTbPageContext(), d2.h3, frsCommonTabFragment.getUniqueId());
            this.f28019f = new k(frsCommonTabFragment.getTbPageContext(), d2.i3, frsCommonTabFragment.getUniqueId());
            this.f28020g = new v(frsCommonTabFragment.getTbPageContext(), d2.k3, frsCommonTabFragment.getUniqueId());
            this.f28021h = new s(frsCommonTabFragment.getTbPageContext(), d2.l3, frsCommonTabFragment.getUniqueId());
            this.f28022i = new j(frsCommonTabFragment.getTbPageContext(), d2.o3, frsCommonTabFragment.getUniqueId());
            this.j = new m(frsCommonTabFragment.getTbPageContext(), d2.p3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), d2.N3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), d2.u3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), d2.v3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.v0(frsCommonTabFragment.tabType);
            b.a.r0.x0.y1.d.r rVar = new b.a.r0.x0.y1.d.r(frsCommonTabFragment.getTbPageContext(), d2.w3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.v0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), d2.z3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), d2.R3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), d2.y3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), d2.x3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), d2.E3, frsCommonTabFragment.getUniqueId());
            this.t = new b.a.r0.x0.y1.d.a(frsCommonTabFragment.getPageContext(), d2.r3, frsCommonTabFragment.getUniqueId());
            this.u = new b.a.r0.x0.y1.d.c(frsCommonTabFragment.getPageContext(), d2.m3, frsCommonTabFragment.getUniqueId());
            this.v = new b.a.r0.x0.y1.d.b(frsCommonTabFragment.getPageContext(), d2.G3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), d2.F3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), d2.H3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), d2.I3, frsCommonTabFragment.getUniqueId());
            this.f28016c = new r(frsCommonTabFragment.getPageContext(), b.a.r0.x0.s.f27833f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), d2.t3, frsCommonTabFragment.getUniqueId());
            }
            this.f28017d.add(this.f28018e);
            this.f28017d.add(this.f28019f);
            this.f28017d.add(this.f28020g);
            this.f28017d.add(this.f28021h);
            this.f28017d.add(this.f28022i);
            this.f28017d.add(this.j);
            this.f28017d.add(this.k);
            this.f28017d.add(this.l);
            this.f28017d.add(this.m);
            this.f28017d.add(this.n);
            this.f28017d.add(this.o);
            this.f28017d.add(this.p);
            this.f28017d.add(this.q);
            this.f28017d.add(this.r);
            this.f28017d.add(this.s);
            this.f28017d.add(this.t);
            this.f28017d.add(this.u);
            this.f28017d.add(this.v);
            this.f28017d.add(this.w);
            this.f28017d.add(this.x);
            this.f28017d.add(this.y);
            this.f28017d.add(this.f28016c);
            if (!z) {
                this.f28017d.add(this.z);
            }
            e();
            for (b.a.e.m.e.a aVar : this.f28017d) {
                if (aVar instanceof b.a.r0.x0.k) {
                    b.a.r0.x0.k kVar = (b.a.r0.x0.k) aVar;
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
            customMessage.setTag(this.f28014a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<b.a.e.m.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    b.a.e.m.e.a<?, ?> next = it.next();
                    if (next instanceof b.a.r0.x0.k) {
                        ((b.a.r0.x0.k) next).o(this.f28014a.getPageContext(), this.f28014a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<b.a.e.m.e.a> list = this.f28017d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f28017d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.m.e.a<?, ?> f2 = b.a.r0.a3.y.o().f(this.f28014a, AdvertAppInfo.s4);
            b.a.e.m.e.a<?, ?> f3 = b.a.r0.a3.y.o().f(this.f28014a, AdvertAppInfo.v4);
            b.a.e.m.e.a<?, ?> f4 = b.a.r0.a3.y.o().f(this.f28014a, AdvertAppInfo.w4);
            b.a.e.m.e.a<?, ?> f5 = b.a.r0.a3.y.o().f(this.f28014a, AdvertAppInfo.x4);
            b.a.e.m.e.a<?, ?> f6 = b.a.r0.a3.y.o().f(this.f28014a, AdvertAppInfo.y4);
            this.f28017d.add(f2);
            this.f28017d.add(f3);
            this.f28017d.add(f4);
            this.f28017d.add(f5);
            this.f28017d.add(f6);
            b.a.e.m.e.a<?, ?> d2 = b.a.r0.y0.b.e().d(this.f28014a.getBaseFragmentActivity(), AdvertAppInfo.D4);
            b.a.e.m.e.a<?, ?> d3 = b.a.r0.y0.b.e().d(this.f28014a.getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.f28017d.add(d2);
            this.f28017d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28015b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (b.a.e.m.e.a aVar : this.f28017d) {
                if (aVar instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) aVar).j0();
                } else if (aVar instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar).onDestroy();
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
                        if (!d2Var.J2()) {
                            arrayList2.add(next);
                        } else {
                            d2Var.b4(null);
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
            this.f28015b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f28017d) || this.f28014a == null) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28017d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).r0(this.f28014a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<b.a.e.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f28017d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28017d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f28014a == null || ListUtils.isEmpty(this.f28017d)) {
            return;
        }
        for (b.a.e.m.e.a aVar : this.f28017d) {
            if (aVar instanceof b.a.r0.x0.v2.d) {
                b.a.r0.x0.v2.d dVar = (b.a.r0.x0.v2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f27991a = this.f28014a.needLog;
                    dVar.j().f27993c = this.f28014a.forumId;
                    dVar.j().f27994d = this.f28014a.tabId;
                    b.a.r0.x0.v2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f28014a;
                    j.f27997g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f27996f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f27996f = 12;
                    }
                }
            }
        }
    }
}
