package b.a.r0.x0.v1;

import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.r0.x0.r;
import b.a.r0.x0.x1.d.a0;
import b.a.r0.x0.x1.d.e;
import b.a.r0.x0.x1.d.g;
import b.a.r0.x0.x1.d.h;
import b.a.r0.x0.x1.d.j;
import b.a.r0.x0.x1.d.k;
import b.a.r0.x0.x1.d.l;
import b.a.r0.x0.x1.d.m;
import b.a.r0.x0.x1.d.p;
import b.a.r0.x0.x1.d.s;
import b.a.r0.x0.x1.d.t;
import b.a.r0.x0.x1.d.u;
import b.a.r0.x0.x1.d.v;
import b.a.r0.x0.x1.d.w;
import b.a.r0.x0.x1.d.x;
import b.a.r0.x0.x1.d.y;
import b.a.r0.x0.x1.d.z;
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

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f26414a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26415b;

    /* renamed from: c  reason: collision with root package name */
    public r f26416c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.e.l.e.a> f26417d;

    /* renamed from: e  reason: collision with root package name */
    public y f26418e;

    /* renamed from: f  reason: collision with root package name */
    public k f26419f;

    /* renamed from: g  reason: collision with root package name */
    public v f26420g;

    /* renamed from: h  reason: collision with root package name */
    public s f26421h;

    /* renamed from: i  reason: collision with root package name */
    public j f26422i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public b.a.r0.x0.x1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public b.a.r0.x0.x1.d.a t;
    public b.a.r0.x0.x1.d.c u;
    public b.a.r0.x0.x1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: b.a.r0.x0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1295a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26423a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1295a(a aVar, int i2) {
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
            this.f26423a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<b.a.e.l.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    b.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof b.a.r0.b0.z) {
                        b.a.r0.b0.z zVar = (b.a.r0.b0.z) next;
                        if ("FrsHottopicDelegateAdapter".equals(zVar.from()) && this.f26423a.f26417d != null) {
                            zVar.o(this.f26423a.f26414a.getPageContext(), this.f26423a.f26414a.getUniqueId());
                            if (this.f26423a.A) {
                                zVar.setFrom("c13010");
                            }
                            this.f26423a.f26417d.add(next);
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
        this.f26417d = new LinkedList();
        this.B = new C1295a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f26415b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f26414a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f26414a.registerListener(this.B);
            this.f26418e = new y(frsCommonTabFragment.getTbPageContext(), d2.g3, frsCommonTabFragment.getUniqueId());
            this.f26419f = new k(frsCommonTabFragment.getTbPageContext(), d2.h3, frsCommonTabFragment.getUniqueId());
            this.f26420g = new v(frsCommonTabFragment.getTbPageContext(), d2.j3, frsCommonTabFragment.getUniqueId());
            this.f26421h = new s(frsCommonTabFragment.getTbPageContext(), d2.k3, frsCommonTabFragment.getUniqueId());
            this.f26422i = new j(frsCommonTabFragment.getTbPageContext(), d2.m3, frsCommonTabFragment.getUniqueId());
            this.j = new m(frsCommonTabFragment.getTbPageContext(), d2.n3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.getTbPageContext(), d2.L3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.getTbPageContext(), d2.s3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.getTbPageContext(), d2.t3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.v0(frsCommonTabFragment.tabType);
            b.a.r0.x0.x1.d.r rVar = new b.a.r0.x0.x1.d.r(frsCommonTabFragment.getTbPageContext(), d2.u3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.v0(frsCommonTabFragment.tabType);
            this.o = new z(frsCommonTabFragment.getPageContext(), d2.x3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), d2.Q3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), d2.w3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), d2.v3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), d2.C3, frsCommonTabFragment.getUniqueId());
            this.t = new b.a.r0.x0.x1.d.a(frsCommonTabFragment.getPageContext(), d2.p3, frsCommonTabFragment.getUniqueId());
            this.u = new b.a.r0.x0.x1.d.c(frsCommonTabFragment.getPageContext(), d2.l3, frsCommonTabFragment.getUniqueId());
            this.v = new b.a.r0.x0.x1.d.b(frsCommonTabFragment.getPageContext(), d2.E3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), d2.D3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), d2.F3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), d2.G3, frsCommonTabFragment.getUniqueId());
            this.f26416c = new r(frsCommonTabFragment.getPageContext(), b.a.r0.x0.s.f26311f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), d2.r3, frsCommonTabFragment.getUniqueId());
            }
            this.f26417d.add(this.f26418e);
            this.f26417d.add(this.f26419f);
            this.f26417d.add(this.f26420g);
            this.f26417d.add(this.f26421h);
            this.f26417d.add(this.f26422i);
            this.f26417d.add(this.j);
            this.f26417d.add(this.k);
            this.f26417d.add(this.l);
            this.f26417d.add(this.m);
            this.f26417d.add(this.n);
            this.f26417d.add(this.o);
            this.f26417d.add(this.p);
            this.f26417d.add(this.q);
            this.f26417d.add(this.r);
            this.f26417d.add(this.s);
            this.f26417d.add(this.t);
            this.f26417d.add(this.u);
            this.f26417d.add(this.v);
            this.f26417d.add(this.w);
            this.f26417d.add(this.x);
            this.f26417d.add(this.y);
            this.f26417d.add(this.f26416c);
            if (!z) {
                this.f26417d.add(this.z);
            }
            e();
            for (b.a.e.l.e.a aVar : this.f26417d) {
                if (aVar instanceof b.a.r0.x0.k) {
                    b.a.r0.x0.k kVar = (b.a.r0.x0.k) aVar;
                    kVar.p0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.tabId == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof b.a.r0.b0.a0) {
                    ((b.a.r0.b0.a0) aVar).r(frsCommonTabFragment.tabId);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f26414a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<b.a.e.l.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    b.a.e.l.e.a<?, ?> next = it.next();
                    if (next instanceof b.a.r0.x0.k) {
                        ((b.a.r0.x0.k) next).o(this.f26414a.getPageContext(), this.f26414a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<b.a.e.l.e.a> list = this.f26417d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.addAdapters(this.f26417d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.l.e.a<?, ?> f2 = b.a.r0.z2.y.o().f(this.f26414a, AdvertAppInfo.r4);
            b.a.e.l.e.a<?, ?> f3 = b.a.r0.z2.y.o().f(this.f26414a, AdvertAppInfo.u4);
            b.a.e.l.e.a<?, ?> f4 = b.a.r0.z2.y.o().f(this.f26414a, AdvertAppInfo.v4);
            b.a.e.l.e.a<?, ?> f5 = b.a.r0.z2.y.o().f(this.f26414a, AdvertAppInfo.w4);
            b.a.e.l.e.a<?, ?> f6 = b.a.r0.z2.y.o().f(this.f26414a, AdvertAppInfo.x4);
            this.f26417d.add(f2);
            this.f26417d.add(f3);
            this.f26417d.add(f4);
            this.f26417d.add(f5);
            this.f26417d.add(f6);
            b.a.e.l.e.a<?, ?> d2 = b.a.r0.y0.b.e().d(this.f26414a.getBaseFragmentActivity(), AdvertAppInfo.C4);
            b.a.e.l.e.a<?, ?> d3 = b.a.r0.y0.b.e().d(this.f26414a.getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.f26417d.add(d2);
            this.f26417d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26415b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (b.a.e.l.e.a aVar : this.f26417d) {
                if (aVar instanceof b.a.r0.x0.k) {
                    ((b.a.r0.x0.k) aVar).j0();
                } else if (aVar instanceof b.a.r0.z2.p) {
                    ((b.a.r0.z2.p) aVar).onDestroy();
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
            this.f26415b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f26417d) || this.f26414a == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26417d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).r0(this.f26414a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f26417d) == null || list.size() == 0) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26417d) {
            if (aVar instanceof b.a.r0.x0.k) {
                ((b.a.r0.x0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f26414a == null || ListUtils.isEmpty(this.f26417d)) {
            return;
        }
        for (b.a.e.l.e.a aVar : this.f26417d) {
            if (aVar instanceof b.a.r0.x0.u2.d) {
                b.a.r0.x0.u2.d dVar = (b.a.r0.x0.u2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f26385a = this.f26414a.needLog;
                    dVar.j().f26387c = this.f26414a.forumId;
                    dVar.j().f26388d = this.f26414a.tabId;
                    b.a.r0.x0.u2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f26414a;
                    j.f26391g = frsCommonTabFragment.tabType;
                    if (frsCommonTabFragment.tabId == 502) {
                        dVar.j().f26390f = 10;
                    } else if (frsCommonTabFragment.isGeneralTab == 1) {
                        dVar.j().f26390f = 12;
                    }
                }
            }
        }
    }
}
