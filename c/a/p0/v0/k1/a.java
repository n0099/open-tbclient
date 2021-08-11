package c.a.p0.v0.k1;

import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.p0.v0.m1.d.a0;
import c.a.p0.v0.m1.d.e;
import c.a.p0.v0.m1.d.g;
import c.a.p0.v0.m1.d.h;
import c.a.p0.v0.m1.d.j;
import c.a.p0.v0.m1.d.k;
import c.a.p0.v0.m1.d.l;
import c.a.p0.v0.m1.d.m;
import c.a.p0.v0.m1.d.p;
import c.a.p0.v0.m1.d.s;
import c.a.p0.v0.m1.d.t;
import c.a.p0.v0.m1.d.u;
import c.a.p0.v0.m1.d.v;
import c.a.p0.v0.m1.d.w;
import c.a.p0.v0.m1.d.x;
import c.a.p0.v0.m1.d.y;
import c.a.p0.v0.m1.d.z;
import c.a.p0.v0.r;
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
    public FrsCommonTabFragment f25956a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f25957b;

    /* renamed from: c  reason: collision with root package name */
    public r f25958c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.e.k.e.a> f25959d;

    /* renamed from: e  reason: collision with root package name */
    public y f25960e;

    /* renamed from: f  reason: collision with root package name */
    public k f25961f;

    /* renamed from: g  reason: collision with root package name */
    public v f25962g;

    /* renamed from: h  reason: collision with root package name */
    public s f25963h;

    /* renamed from: i  reason: collision with root package name */
    public j f25964i;

    /* renamed from: j  reason: collision with root package name */
    public m f25965j;
    public w k;
    public a0 l;
    public u m;
    public c.a.p0.v0.m1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.p0.v0.m1.d.a t;
    public c.a.p0.v0.m1.d.c u;
    public c.a.p0.v0.m1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.p0.v0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1214a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25966a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1214a(a aVar, int i2) {
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
            this.f25966a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<c.a.e.k.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    c.a.e.k.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.p0.a0.y) {
                        c.a.p0.a0.y yVar = (c.a.p0.a0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.f25966a.f25959d != null) {
                            yVar.o(this.f25966a.f25956a.getPageContext(), this.f25966a.f25956a.getUniqueId());
                            if (this.f25966a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.f25966a.f25959d.add(next);
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
        this.f25959d = new LinkedList();
        this.B = new C1214a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f25957b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f25956a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f25956a.registerListener(this.B);
            this.f25960e = new y(frsCommonTabFragment.getTbPageContext(), c2.c3, frsCommonTabFragment.getUniqueId());
            this.f25961f = new k(frsCommonTabFragment.getTbPageContext(), c2.d3, frsCommonTabFragment.getUniqueId());
            this.f25962g = new v(frsCommonTabFragment.getTbPageContext(), c2.f3, frsCommonTabFragment.getUniqueId());
            this.f25963h = new s(frsCommonTabFragment.getTbPageContext(), c2.g3, frsCommonTabFragment.getUniqueId());
            this.f25964i = new j(frsCommonTabFragment.getTbPageContext(), c2.i3, frsCommonTabFragment.getUniqueId());
            this.f25965j = new m(frsCommonTabFragment.getTbPageContext(), c2.j3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), c2.H3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), c2.o3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), c2.p3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.w0(frsCommonTabFragment.tabType);
            c.a.p0.v0.m1.d.r rVar = new c.a.p0.v0.m1.d.r(frsCommonTabFragment.getTbPageContext(), c2.q3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.w0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), c2.t3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), c2.M3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), c2.s3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), c2.r3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), c2.y3, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.p0.v0.m1.d.a(frsCommonTabFragment.getPageContext(), c2.l3, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.p0.v0.m1.d.c(frsCommonTabFragment.getPageContext(), c2.h3, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.p0.v0.m1.d.b(frsCommonTabFragment.getPageContext(), c2.A3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), c2.z3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), c2.B3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), c2.C3, frsCommonTabFragment.getUniqueId());
            this.f25958c = new r(frsCommonTabFragment.getPageContext(), c.a.p0.v0.s.f26816f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), c2.n3, frsCommonTabFragment.getUniqueId());
            }
            this.f25959d.add(this.f25960e);
            this.f25959d.add(this.f25961f);
            this.f25959d.add(this.f25962g);
            this.f25959d.add(this.f25963h);
            this.f25959d.add(this.f25964i);
            this.f25959d.add(this.f25965j);
            this.f25959d.add(this.k);
            this.f25959d.add(this.l);
            this.f25959d.add(this.m);
            this.f25959d.add(this.n);
            this.f25959d.add(this.o);
            this.f25959d.add(this.p);
            this.f25959d.add(this.q);
            this.f25959d.add(this.r);
            this.f25959d.add(this.s);
            this.f25959d.add(this.t);
            this.f25959d.add(this.u);
            this.f25959d.add(this.v);
            this.f25959d.add(this.w);
            this.f25959d.add(this.x);
            this.f25959d.add(this.y);
            this.f25959d.add(this.f25958c);
            if (!z) {
                this.f25959d.add(this.z);
            }
            e();
            for (c.a.e.k.e.a aVar : this.f25959d) {
                if (aVar instanceof c.a.p0.v0.k) {
                    c.a.p0.v0.k kVar = (c.a.p0.v0.k) aVar;
                    kVar.q0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof c.a.p0.a0.z) {
                    ((c.a.p0.a0.z) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f25956a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<c.a.e.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    c.a.e.k.e.a<?, ?> next = it.next();
                    if (next instanceof c.a.p0.v0.k) {
                        ((c.a.p0.v0.k) next).o(this.f25956a.getPageContext(), this.f25956a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.e.k.e.a> list = this.f25959d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f25959d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.k.e.a<?, ?> f2 = c.a.p0.x2.y.o().f(this.f25956a, AdvertAppInfo.n4);
            c.a.e.k.e.a<?, ?> f3 = c.a.p0.x2.y.o().f(this.f25956a, AdvertAppInfo.q4);
            c.a.e.k.e.a<?, ?> f4 = c.a.p0.x2.y.o().f(this.f25956a, AdvertAppInfo.r4);
            c.a.e.k.e.a<?, ?> f5 = c.a.p0.x2.y.o().f(this.f25956a, AdvertAppInfo.s4);
            c.a.e.k.e.a<?, ?> f6 = c.a.p0.x2.y.o().f(this.f25956a, AdvertAppInfo.t4);
            this.f25959d.add(f2);
            this.f25959d.add(f3);
            this.f25959d.add(f4);
            this.f25959d.add(f5);
            this.f25959d.add(f6);
            c.a.e.k.e.a<?, ?> d2 = c.a.p0.w0.b.e().d(this.f25956a.getBaseFragmentActivity(), AdvertAppInfo.y4);
            c.a.e.k.e.a<?, ?> d3 = c.a.p0.w0.b.e().d(this.f25956a.getBaseFragmentActivity(), AdvertAppInfo.x4);
            this.f25959d.add(d2);
            this.f25959d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25957b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.e.k.e.a aVar : this.f25959d) {
                if (aVar instanceof c.a.p0.v0.k) {
                    ((c.a.p0.v0.k) aVar).k0();
                } else if (aVar instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar).onDestroy();
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
            this.f25957b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f25959d) || this.f25956a == null) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25959d) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).s0(this.f25956a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.e.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f25959d) == null || list.size() == 0) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25959d) {
            if (aVar instanceof c.a.p0.v0.k) {
                ((c.a.p0.v0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f25956a == null || ListUtils.isEmpty(this.f25959d)) {
            return;
        }
        for (c.a.e.k.e.a aVar : this.f25959d) {
            if (aVar instanceof c.a.p0.v0.j2.d) {
                c.a.p0.v0.j2.d dVar = (c.a.p0.v0.j2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f25937a = this.f25956a.needLog;
                    dVar.j().f25939c = this.f25956a.forumId;
                    dVar.j().f25940d = this.f25956a.tabId;
                    c.a.p0.v0.j2.b j2 = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f25956a;
                    j2.f25943g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f25942f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f25942f = 12;
                    }
                }
            }
        }
    }
}
