package c.a.q0.i2.o.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.l.e.n;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.s.q.c2;
import c.a.q0.i2.h.q;
import c.a.q0.i2.h.v;
import c.a.q0.i2.k.e.p0;
import c.a.q0.i2.k.e.x;
import c.a.q0.i3.i0.p;
import c.a.q0.x2.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f20035a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f20036b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.i2.h.e f20037c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f20038d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f20039e;

    /* renamed from: f  reason: collision with root package name */
    public h f20040f;

    /* renamed from: g  reason: collision with root package name */
    public f f20041g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20042h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.i2.k.e.j f20043i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.i2.k.e.h f20044j;
    public x k;
    public PbFirstFloorItemAdapter l;
    public p0 m;
    public c.a.e.l.e.a n;
    public c.a.e.l.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20045e;

        /* renamed from: c.a.q0.i2.o.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0942a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f20046a;

            /* renamed from: c.a.q0.i2.o.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0943a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0942a f20047e;

                public RunnableC0943a(C0942a c0942a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0942a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f20047e = c0942a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f20047e.f20046a.f20045e.f20036b.getPbModel().W1(3);
                    }
                }
            }

            public C0942a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20046a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!c.a.e.e.p.j.z()) {
                        this.f20046a.f20045e.f20036b.refreshByBrowseMode();
                    } else {
                        c.a.e.e.m.e.a().postDelayed(new RunnableC0943a(this), 10L);
                    }
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20045e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20045e.f20036b == null || this.f20045e.f20036b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f20045e.f20036b.getPageContext(), new C0942a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20048e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20048e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f20048e.f(11009)) {
                        this.f20048e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f20048e.f(11009)) {
                        this.f20048e.i(3);
                    }
                } else if (this.f20048e.f20036b == null || this.f20048e.f20036b.getVideoPbFragment() == null || this.f20048e.f20036b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f20048e.f20036b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.q0.i2.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0944c extends h0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20049a;

        public C0944c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20049a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.q0.i2.k.e.d1.b.d(this.f20049a.f20036b.getContext(), this.f20049a.h(), ShareSwitch.isOn() ? 1 : 6, this.f20049a.f20036b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.b1.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20050a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20051b;

        public d(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20051b = cVar;
            this.f20050a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20051b.f20036b.getContext(), this.f20050a, shareItem, false));
            }
        }
    }

    public c(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20035a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f20036b = detailInfoFragment;
        this.f20038d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f20037c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().c4 = new c.a.p0.s.q.e();
        if (this.f20037c.y() != null) {
            pVar.getAdvertAppInfo().c4.f14193b = this.f20037c.y().a();
        }
        pVar.getAdvertAppInfo().c4.f14192a = pVar.E0();
        if (this.f20037c.m() != null && (m = this.f20037c.m()) != null) {
            pVar.getAdvertAppInfo().c4.f14195d = m.getId();
            pVar.getAdvertAppInfo().c4.f14196e = m.getFirst_class();
            pVar.getAdvertAppInfo().c4.f14197f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().c4.f14198g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().c4.f14199h = pVar.getAdvertAppInfo().a4;
        pVar.getAdvertAppInfo().c4.f14200i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f20036b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20036b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            p pVar = null;
            if (eVar == null) {
                return null;
            }
            this.f20039e = new ArrayList();
            Iterator<PostData> it = eVar.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.A() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && eVar.j() != null) {
                postData = eVar.j();
            }
            if (postData != null) {
                this.f20039e.add(postData);
            }
            if (c.a.p0.e1.b.e.d()) {
                return this.f20039e;
            }
            v vVar = new v();
            c2 O = eVar.O();
            vVar.f19135e = O;
            if (O != null && k.isEmpty(O.Z())) {
                vVar.f19135e.B3(eVar.o());
            }
            this.f20039e.add(vVar);
            c.a.q0.i2.h.p pVar2 = new c.a.q0.i2.h.p(eVar.O(), eVar.d());
            pVar2.f19109f = true;
            this.f20039e.add(pVar2);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f20036b.getPbModel().p0()) || !this.f20036b.getPbModel().u0())) {
                c.a.q0.i2.h.h hVar = new c.a.q0.i2.h.h(postData.p0);
                hVar.f19080f = this.f20036b.getPbModel().e1();
                this.f20039e.add(hVar);
            }
            List<p> Y = eVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.q0.o1.o.k.a.e(Y) && (pVar = (p) c.a.q0.o1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (eVar.f() != null) {
                c.a.q0.i2.h.d dVar = new c.a.q0.i2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f20039e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f20039e.add(new q());
                } else {
                    int i4 = 1;
                    for (c.a.p0.s.q.q qVar : eVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.q0.o1.o.k.a.a(this.f20039e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.o4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.q0.o1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.q0.o1.o.k.a.a(this.f20039e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.C() != null) {
                            c.a.q0.o1.o.k.a.a(this.f20039e, eVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f20039e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.q0.i2.h.e eVar = this.f20037c;
            if (eVar == null || eVar.O() == null) {
                return -1;
            }
            return this.f20037c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            k0.b(new C0944c(this), new d(this, i2));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i2 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.o = y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.q4);
            this.f20035a.add(this.n);
            this.f20035a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f20040f = new h(videoPbFragment, videoPbFragment, PostData.u0);
            this.f20041g = new f(detailInfoFragment.getContext(), v.f19134f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), c.a.q0.i2.h.p.f19107j);
            this.f20042h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
            this.f20043i = new c.a.q0.i2.k.e.j(detailInfoFragment.getVideoPbFragment(), c.a.q0.i2.h.d.f19059g);
            c.a.q0.i2.k.e.h hVar = new c.a.q0.i2.k.e.h(detailInfoFragment.getVideoPbFragment(), c.a.p0.s.q.q.X3);
            this.f20044j = hVar;
            hVar.o0(true);
            this.k = new x(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.q0.i2.h.h.f19078g);
            p0 p0Var = new p0(detailInfoFragment.getVideoPbFragment(), q.f19113e);
            this.m = p0Var;
            p0Var.l0(this.p);
            this.f20035a.add(this.f20040f);
            this.f20035a.add(this.f20041g);
            this.f20035a.add(this.f20042h);
            this.f20035a.add(this.f20043i);
            this.f20035a.add(this.f20044j);
            this.f20035a.add(this.k);
            this.f20035a.add(this.l);
            this.f20035a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f20035a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f20038d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f20038d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f20040f) == null) {
            return;
        }
        hVar.P();
    }

    public void n(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f20037c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20038d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f20040f.I0(eVar);
        this.f20044j.n0(eVar);
        this.k.l0(eVar);
        this.f20038d.setData(g(eVar));
    }
}
