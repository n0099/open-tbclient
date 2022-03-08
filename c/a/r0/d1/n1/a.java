package c.a.r0.d1.n1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.r0.d1.p1.d.a0;
import c.a.r0.d1.p1.d.e;
import c.a.r0.d1.p1.d.g;
import c.a.r0.d1.p1.d.h;
import c.a.r0.d1.p1.d.j;
import c.a.r0.d1.p1.d.k;
import c.a.r0.d1.p1.d.l;
import c.a.r0.d1.p1.d.m;
import c.a.r0.d1.p1.d.p;
import c.a.r0.d1.p1.d.s;
import c.a.r0.d1.p1.d.t;
import c.a.r0.d1.p1.d.u;
import c.a.r0.d1.p1.d.v;
import c.a.r0.d1.p1.d.w;
import c.a.r0.d1.p1.d.x;
import c.a.r0.d1.p1.d.y;
import c.a.r0.d1.p1.d.z;
import c.a.r0.d1.r;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public FrsCommonTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f15857b;

    /* renamed from: c  reason: collision with root package name */
    public r f15858c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15859d;

    /* renamed from: e  reason: collision with root package name */
    public y f15860e;

    /* renamed from: f  reason: collision with root package name */
    public k f15861f;

    /* renamed from: g  reason: collision with root package name */
    public v f15862g;

    /* renamed from: h  reason: collision with root package name */
    public s f15863h;

    /* renamed from: i  reason: collision with root package name */
    public j f15864i;

    /* renamed from: j  reason: collision with root package name */
    public m f15865j;
    public w k;
    public a0 l;
    public u m;
    public c.a.r0.d1.p1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.r0.d1.p1.d.a t;
    public c.a.r0.d1.p1.d.c u;
    public c.a.r0.d1.p1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.r0.d1.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1012a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1012a(a aVar, int i2) {
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
                Iterator<c.a.d.o.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.f0.y) {
                        c.a.r0.f0.y yVar = (c.a.r0.f0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.a.f15859d != null) {
                            yVar.o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.a.f15859d.add(next);
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
        this.f15859d = new LinkedList();
        this.B = new C1012a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f15857b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.a.registerListener(this.B);
            this.f15860e = new y(frsCommonTabFragment.getTbPageContext(), e2.p3, frsCommonTabFragment.getUniqueId());
            this.f15861f = new k(frsCommonTabFragment.getTbPageContext(), e2.q3, frsCommonTabFragment.getUniqueId());
            this.f15862g = new v(frsCommonTabFragment.getTbPageContext(), e2.s3, frsCommonTabFragment.getUniqueId());
            this.f15863h = new s(frsCommonTabFragment.getTbPageContext(), e2.t3, frsCommonTabFragment.getUniqueId());
            this.f15864i = new j(frsCommonTabFragment.getTbPageContext(), e2.w3, frsCommonTabFragment.getUniqueId());
            this.f15865j = new m(frsCommonTabFragment.getTbPageContext(), e2.x3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), e2.V3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), e2.C3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), e2.D3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.o0(frsCommonTabFragment.tabType);
            c.a.r0.d1.p1.d.r rVar = new c.a.r0.d1.p1.d.r(frsCommonTabFragment.getTbPageContext(), e2.E3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.o0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), e2.H3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), e2.Z3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), e2.G3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), e2.F3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), e2.M3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.r0.d1.p1.d.a(frsCommonTabFragment.getPageContext(), e2.z3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.r0.d1.p1.d.c(frsCommonTabFragment.getPageContext(), e2.u3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.r0.d1.p1.d.b(frsCommonTabFragment.getPageContext(), e2.O3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), e2.N3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), e2.P3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), e2.Q3, frsCommonTabFragment.getUniqueId());
            this.f15858c = new r(frsCommonTabFragment.getPageContext(), c.a.r0.d1.s.f16241f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), e2.B3, frsCommonTabFragment.getUniqueId());
            }
            this.f15859d.add(this.f15860e);
            this.f15859d.add(this.f15861f);
            this.f15859d.add(this.f15862g);
            this.f15859d.add(this.f15863h);
            this.f15859d.add(this.f15864i);
            this.f15859d.add(this.f15865j);
            this.f15859d.add(this.k);
            this.f15859d.add(this.l);
            this.f15859d.add(this.m);
            this.f15859d.add(this.n);
            this.f15859d.add(this.o);
            this.f15859d.add(this.p);
            this.f15859d.add(this.q);
            this.f15859d.add(this.r);
            this.f15859d.add(this.s);
            this.f15859d.add(this.t);
            this.f15859d.add(this.u);
            this.f15859d.add(this.v);
            this.f15859d.add(this.w);
            this.f15859d.add(this.x);
            this.f15859d.add(this.y);
            this.f15859d.add(this.f15858c);
            if (!z) {
                this.f15859d.add(this.z);
            }
            e();
            for (c.a.d.o.e.a aVar : this.f15859d) {
                if (aVar instanceof c.a.r0.d1.k) {
                    c.a.r0.d1.k kVar = (c.a.r0.d1.k) aVar;
                    kVar.i0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof c.a.r0.f0.z) {
                    ((c.a.r0.f0.z) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.d.o.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.r0.d1.k) {
                        ((c.a.r0.d1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.o.e.a> list = this.f15859d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f15859d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.o.e.a<?, ?> f2 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.B4);
            c.a.d.o.e.a<?, ?> f3 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.E4);
            c.a.d.o.e.a<?, ?> f4 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.F4);
            c.a.d.o.e.a<?, ?> f5 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.G4);
            c.a.d.o.e.a<?, ?> f6 = c.a.r0.j3.z.q().f(this.a, AdvertAppInfo.H4);
            this.f15859d.add(f2);
            this.f15859d.add(f3);
            this.f15859d.add(f4);
            this.f15859d.add(f5);
            this.f15859d.add(f6);
            c.a.d.o.e.a<?, ?> d2 = c.a.r0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.M4);
            c.a.d.o.e.a<?, ?> d3 = c.a.r0.e1.b.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.L4);
            this.f15859d.add(d2);
            this.f15859d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15857b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.d.o.e.a aVar : this.f15859d) {
                if (aVar instanceof c.a.r0.d1.k) {
                    ((c.a.r0.d1.k) aVar).c0();
                } else if (aVar instanceof c.a.r0.j3.p) {
                    ((c.a.r0.j3.p) aVar).onDestroy();
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
                if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    if (e2Var.u0() != null) {
                        if (!e2Var.M2()) {
                            arrayList2.add(next);
                        } else {
                            e2Var.e4(null);
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
            this.f15857b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f15859d) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15859d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).k0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f15859d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15859d) {
            if (aVar instanceof c.a.r0.d1.k) {
                ((c.a.r0.d1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.f15859d)) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f15859d) {
            if (aVar instanceof c.a.r0.d1.o2.d) {
                c.a.r0.d1.o2.d dVar = (c.a.r0.d1.o2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().a = this.a.needLog;
                    dVar.j().f15918c = this.a.forumId;
                    dVar.j().f15919d = this.a.forumName;
                    dVar.j().f15920e = this.a.tabId;
                    c.a.r0.d1.o2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    j2.f15923h = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f15922g = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f15922g = 12;
                    }
                }
            }
        }
    }
}
