package c.a.p0.f1.n1;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.f1.p1.d.a0;
import c.a.p0.f1.p1.d.e;
import c.a.p0.f1.p1.d.g;
import c.a.p0.f1.p1.d.h;
import c.a.p0.f1.p1.d.j;
import c.a.p0.f1.p1.d.k;
import c.a.p0.f1.p1.d.l;
import c.a.p0.f1.p1.d.m;
import c.a.p0.f1.p1.d.p;
import c.a.p0.f1.p1.d.s;
import c.a.p0.f1.p1.d.t;
import c.a.p0.f1.p1.d.u;
import c.a.p0.f1.p1.d.v;
import c.a.p0.f1.p1.d.w;
import c.a.p0.f1.p1.d.x;
import c.a.p0.f1.p1.d.y;
import c.a.p0.f1.p1.d.z;
import c.a.p0.f1.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
    public BdTypeRecyclerView f14250b;

    /* renamed from: c  reason: collision with root package name */
    public r f14251c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14252d;

    /* renamed from: e  reason: collision with root package name */
    public y f14253e;

    /* renamed from: f  reason: collision with root package name */
    public k f14254f;

    /* renamed from: g  reason: collision with root package name */
    public v f14255g;

    /* renamed from: h  reason: collision with root package name */
    public s f14256h;
    public j i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public c.a.p0.f1.p1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public c.a.p0.f1.p1.d.a t;
    public c.a.p0.f1.p1.d.c u;
    public c.a.p0.f1.p1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: c.a.p0.f1.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1071a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1071a(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (next instanceof c.a.p0.h0.y) {
                        c.a.p0.h0.y yVar = (c.a.p0.h0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.a.f14252d != null) {
                            yVar.o(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.a.f14252d.add(next);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14252d = new LinkedList();
        this.B = new C1071a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f14250b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.a.registerListener(this.B);
            this.f14253e = new y(frsCommonTabFragment.j(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f14254f = new k(frsCommonTabFragment.j(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f14255g = new v(frsCommonTabFragment.j(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f14256h = new s(frsCommonTabFragment.j(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new j(frsCommonTabFragment.j(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new m(frsCommonTabFragment.j(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.j(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.j(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.j(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.n0(frsCommonTabFragment.f32441h);
            c.a.p0.f1.p1.d.r rVar = new c.a.p0.f1.p1.d.r(frsCommonTabFragment.j(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.n0(frsCommonTabFragment.f32441h);
            this.o = new z(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new c.a.p0.f1.p1.d.a(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new c.a.p0.f1.p1.d.c(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new c.a.p0.f1.p1.d.b(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.f14251c = new r(frsCommonTabFragment.getPageContext(), c.a.p0.f1.s.f14508b);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
            }
            this.f14252d.add(this.f14253e);
            this.f14252d.add(this.f14254f);
            this.f14252d.add(this.f14255g);
            this.f14252d.add(this.f14256h);
            this.f14252d.add(this.i);
            this.f14252d.add(this.j);
            this.f14252d.add(this.k);
            this.f14252d.add(this.l);
            this.f14252d.add(this.m);
            this.f14252d.add(this.n);
            this.f14252d.add(this.o);
            this.f14252d.add(this.p);
            this.f14252d.add(this.q);
            this.f14252d.add(this.r);
            this.f14252d.add(this.s);
            this.f14252d.add(this.t);
            this.f14252d.add(this.u);
            this.f14252d.add(this.v);
            this.f14252d.add(this.w);
            this.f14252d.add(this.x);
            this.f14252d.add(this.y);
            this.f14252d.add(this.f14251c);
            if (!z) {
                this.f14252d.add(this.z);
            }
            e();
            for (c.a.d.o.e.a aVar : this.f14252d) {
                if (aVar instanceof c.a.p0.f1.k) {
                    c.a.p0.f1.k kVar = (c.a.p0.f1.k) aVar;
                    kVar.h0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.f32440g == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof c.a.p0.h0.z) {
                    ((c.a.p0.h0.z) aVar).r(frsCommonTabFragment.f32440g);
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
                    if (next instanceof c.a.p0.f1.k) {
                        ((c.a.p0.f1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<c.a.d.o.e.a> list = this.f14252d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.f32440g == 502 || frsCommonTabFragment.j == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.a(this.f14252d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.o.e.a<?, ?> f2 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.w);
            c.a.d.o.e.a<?, ?> f3 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.z);
            c.a.d.o.e.a<?, ?> f4 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.A);
            c.a.d.o.e.a<?, ?> f5 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.B);
            c.a.d.o.e.a<?, ?> f6 = c.a.p0.l3.z.q().f(this.a, AdvertAppInfo.C);
            this.f14252d.add(f2);
            this.f14252d.add(f3);
            this.f14252d.add(f4);
            this.f14252d.add(f5);
            this.f14252d.add(f6);
            c.a.d.o.e.a<?, ?> d2 = c.a.p0.g1.c.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            c.a.d.o.e.a<?, ?> d3 = c.a.p0.g1.c.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.f14252d.add(d2);
            this.f14252d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14250b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.d.o.e.a aVar : this.f14252d) {
                if (aVar instanceof c.a.p0.f1.k) {
                    ((c.a.p0.f1.k) aVar).c0();
                } else if (aVar instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar).onDestroy();
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
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getItem() != null) {
                        if (!threadData.isVoteThreadType()) {
                            arrayList2.add(next);
                        } else {
                            threadData.setItem(null);
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
            this.f14250b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f14252d) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14252d) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f14252d) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14252d) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.f14252d)) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14252d) {
            if (aVar instanceof c.a.p0.f1.o2.d) {
                c.a.p0.f1.o2.d dVar = (c.a.p0.f1.o2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().a = this.a.k;
                    dVar.j().f14300c = this.a.f32438e;
                    dVar.j().f14301d = this.a.f32439f;
                    dVar.j().f14302e = this.a.f32440g;
                    c.a.p0.f1.o2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    j.f14305h = frsCommonTabFragment.f32441h;
                    if (frsCommonTabFragment.f32440g == 502) {
                        dVar.j().f14304g = 10;
                    } else if (frsCommonTabFragment.j == 1) {
                        dVar.j().f14304g = 12;
                    }
                }
            }
        }
    }
}
