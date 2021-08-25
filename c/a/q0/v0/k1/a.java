package c.a.q0.v0.k1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.v0.m1.d.a0;
import c.a.q0.v0.m1.d.e;
import c.a.q0.v0.m1.d.g;
import c.a.q0.v0.m1.d.h;
import c.a.q0.v0.m1.d.j;
import c.a.q0.v0.m1.d.k;
import c.a.q0.v0.m1.d.l;
import c.a.q0.v0.m1.d.m;
import c.a.q0.v0.m1.d.p;
import c.a.q0.v0.m1.d.s;
import c.a.q0.v0.m1.d.t;
import c.a.q0.v0.m1.d.u;
import c.a.q0.v0.m1.d.v;
import c.a.q0.v0.m1.d.w;
import c.a.q0.v0.m1.d.x;
import c.a.q0.v0.m1.d.y;
import c.a.q0.v0.m1.d.z;
import c.a.q0.v0.r;
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
    public FrsCommonTabFragment f26292a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26293b;

    /* renamed from: c  reason: collision with root package name */
    public r f26294c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26295d;

    /* renamed from: e  reason: collision with root package name */
    public y f26296e;

    /* renamed from: f  reason: collision with root package name */
    public k f26297f;

    /* renamed from: g  reason: collision with root package name */
    public v f26298g;

    /* renamed from: h  reason: collision with root package name */
    public s f26299h;

    /* renamed from: i  reason: collision with root package name */
    public j f26300i;

    /* renamed from: j  reason: collision with root package name */
    public m f26301j;
    public w k;
    public a0 l;
    public u m;
    public c.a.q0.v0.m1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.q0.v0.m1.d.a t;
    public c.a.q0.v0.m1.d.c u;
    public c.a.q0.v0.m1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.q0.v0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1225a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26302a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1225a(a aVar, int i2) {
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
            this.f26302a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<c.a.e.l.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.q0.a0.y) {
                        c.a.q0.a0.y yVar = (c.a.q0.a0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.f26302a.f26295d != null) {
                            yVar.o(this.f26302a.f26292a.getPageContext(), this.f26302a.f26292a.getUniqueId());
                            if (this.f26302a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.f26302a.f26295d.add(next);
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
        this.f26295d = new LinkedList();
        this.B = new C1225a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f26293b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f26292a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f26292a.registerListener(this.B);
            this.f26296e = new y(frsCommonTabFragment.getTbPageContext(), c2.c3, frsCommonTabFragment.getUniqueId());
            this.f26297f = new k(frsCommonTabFragment.getTbPageContext(), c2.d3, frsCommonTabFragment.getUniqueId());
            this.f26298g = new v(frsCommonTabFragment.getTbPageContext(), c2.f3, frsCommonTabFragment.getUniqueId());
            this.f26299h = new s(frsCommonTabFragment.getTbPageContext(), c2.g3, frsCommonTabFragment.getUniqueId());
            this.f26300i = new j(frsCommonTabFragment.getTbPageContext(), c2.i3, frsCommonTabFragment.getUniqueId());
            this.f26301j = new m(frsCommonTabFragment.getTbPageContext(), c2.j3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), c2.H3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), c2.o3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), c2.p3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.w0(frsCommonTabFragment.tabType);
            c.a.q0.v0.m1.d.r rVar = new c.a.q0.v0.m1.d.r(frsCommonTabFragment.getTbPageContext(), c2.q3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.w0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), c2.t3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), c2.M3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), c2.s3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), c2.r3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), c2.y3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.q0.v0.m1.d.a(frsCommonTabFragment.getPageContext(), c2.l3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.q0.v0.m1.d.c(frsCommonTabFragment.getPageContext(), c2.h3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.q0.v0.m1.d.b(frsCommonTabFragment.getPageContext(), c2.A3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), c2.z3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), c2.B3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), c2.C3, frsCommonTabFragment.getUniqueId());
            this.f26294c = new r(frsCommonTabFragment.getPageContext(), c.a.q0.v0.s.f27155f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), c2.n3, frsCommonTabFragment.getUniqueId());
            }
            this.f26295d.add(this.f26296e);
            this.f26295d.add(this.f26297f);
            this.f26295d.add(this.f26298g);
            this.f26295d.add(this.f26299h);
            this.f26295d.add(this.f26300i);
            this.f26295d.add(this.f26301j);
            this.f26295d.add(this.k);
            this.f26295d.add(this.l);
            this.f26295d.add(this.m);
            this.f26295d.add(this.n);
            this.f26295d.add(this.o);
            this.f26295d.add(this.p);
            this.f26295d.add(this.q);
            this.f26295d.add(this.r);
            this.f26295d.add(this.s);
            this.f26295d.add(this.t);
            this.f26295d.add(this.u);
            this.f26295d.add(this.v);
            this.f26295d.add(this.w);
            this.f26295d.add(this.x);
            this.f26295d.add(this.y);
            this.f26295d.add(this.f26294c);
            if (!z) {
                this.f26295d.add(this.z);
            }
            e();
            for (c.a.e.l.e.a aVar : this.f26295d) {
                if (aVar instanceof c.a.q0.v0.k) {
                    c.a.q0.v0.k kVar = (c.a.q0.v0.k) aVar;
                    kVar.q0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof c.a.q0.a0.z) {
                    ((c.a.q0.a0.z) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f26292a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.q0.v0.k) {
                        ((c.a.q0.v0.k) next).o(this.f26292a.getPageContext(), this.f26292a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.l.e.a> list = this.f26295d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f26295d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.l.e.a<?, ?> f2 = c.a.q0.x2.y.o().f(this.f26292a, AdvertAppInfo.n4);
            c.a.e.l.e.a<?, ?> f3 = c.a.q0.x2.y.o().f(this.f26292a, AdvertAppInfo.q4);
            c.a.e.l.e.a<?, ?> f4 = c.a.q0.x2.y.o().f(this.f26292a, AdvertAppInfo.r4);
            c.a.e.l.e.a<?, ?> f5 = c.a.q0.x2.y.o().f(this.f26292a, AdvertAppInfo.s4);
            c.a.e.l.e.a<?, ?> f6 = c.a.q0.x2.y.o().f(this.f26292a, AdvertAppInfo.t4);
            this.f26295d.add(f2);
            this.f26295d.add(f3);
            this.f26295d.add(f4);
            this.f26295d.add(f5);
            this.f26295d.add(f6);
            c.a.e.l.e.a<?, ?> d2 = c.a.q0.w0.b.e().d(this.f26292a.getBaseFragmentActivity(), AdvertAppInfo.y4);
            c.a.e.l.e.a<?, ?> d3 = c.a.q0.w0.b.e().d(this.f26292a.getBaseFragmentActivity(), AdvertAppInfo.x4);
            this.f26295d.add(d2);
            this.f26295d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26293b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.e.l.e.a aVar : this.f26295d) {
                if (aVar instanceof c.a.q0.v0.k) {
                    ((c.a.q0.v0.k) aVar).k0();
                } else if (aVar instanceof c.a.q0.x2.p) {
                    ((c.a.q0.x2.p) aVar).onDestroy();
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
                if (next instanceof c2) {
                    c2 c2Var = (c2) next;
                    if (c2Var.q0() != null) {
                        if (!c2Var.D2()) {
                            arrayList2.add(next);
                        } else {
                            c2Var.Q3(null);
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
            this.f26293b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f26295d) || this.f26292a == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26295d) {
            if (aVar instanceof c.a.q0.v0.k) {
                ((c.a.q0.v0.k) aVar).s0(this.f26292a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f26295d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26295d) {
            if (aVar instanceof c.a.q0.v0.k) {
                ((c.a.q0.v0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f26292a == null || ListUtils.isEmpty(this.f26295d)) {
            return;
        }
        for (c.a.e.l.e.a aVar : this.f26295d) {
            if (aVar instanceof c.a.q0.v0.j2.d) {
                c.a.q0.v0.j2.d dVar = (c.a.q0.v0.j2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f26273a = this.f26292a.needLog;
                    dVar.j().f26275c = this.f26292a.forumId;
                    dVar.j().f26276d = this.f26292a.tabId;
                    c.a.q0.v0.j2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f26292a;
                    j2.f26279g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f26278f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f26278f = 12;
                    }
                }
            }
        }
    }
}
