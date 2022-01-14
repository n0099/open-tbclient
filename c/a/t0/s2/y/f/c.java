package c.a.t0.s2.y.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.s0.e1.k0;
import c.a.s0.e1.n0;
import c.a.s0.e1.s;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.q;
import c.a.t0.s2.r.r;
import c.a.t0.s2.r.x;
import c.a.t0.s2.u.f.k;
import c.a.t0.s2.u.f.s0;
import c.a.t0.s2.u.f.y;
import c.a.t0.w3.j0.p;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.n.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f23290b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.s2.r.f f23291c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f23292d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f23293e;

    /* renamed from: f  reason: collision with root package name */
    public h f23294f;

    /* renamed from: g  reason: collision with root package name */
    public f f23295g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f23296h;

    /* renamed from: i  reason: collision with root package name */
    public k f23297i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.s2.u.f.i f23298j;
    public y k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public c.a.d.n.e.a n;
    public c.a.d.n.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23299e;

        /* renamed from: c.a.t0.s2.y.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1421a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: c.a.t0.s2.y.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1422a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1421a f23300e;

                public RunnableC1422a(C1421a c1421a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1421a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23300e = c1421a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f23300e.a.f23299e.f23290b.getPbModel().f2(3);
                    }
                }
            }

            public C1421a(a aVar) {
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
                this.a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!l.z()) {
                        this.a.f23299e.f23290b.refreshByBrowseMode();
                    } else {
                        c.a.d.f.m.e.a().postDelayed(new RunnableC1422a(this), 10L);
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
            this.f23299e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23299e.f23290b == null || this.f23299e.f23290b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f23299e.f23290b.getPageContext(), new C1421a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23301e;

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
            this.f23301e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.t0.s2.i.qq_share_container) {
                    if (this.f23301e.f(11009)) {
                        this.f23301e.i(8);
                    }
                } else if (view.getId() == c.a.t0.s2.i.share_num_container) {
                    if (this.f23301e.f(11009)) {
                        this.f23301e.i(3);
                    }
                } else if (this.f23301e.f23290b == null || this.f23301e.f23290b.getVideoPbFragment() == null || this.f23301e.f23290b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f23301e.f23290b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.t0.s2.y.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1423c extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1423c(c cVar) {
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.t0.s2.u.f.g1.b.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.f23290b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23302b;

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
            this.f23302b = cVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f23302b.f23290b.getContext(), this.a, shareItem, false));
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
        this.a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f23290b = detailInfoFragment;
        this.f23292d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f23291c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().o4 = new c.a.s0.s.q.e();
        if (this.f23291c.y() != null) {
            pVar.getAdvertAppInfo().o4.f13350b = this.f23291c.y().a();
        }
        pVar.getAdvertAppInfo().o4.a = pVar.L0();
        if (this.f23291c.l() != null && (l = this.f23291c.l()) != null) {
            pVar.getAdvertAppInfo().o4.f13352d = l.getId();
            pVar.getAdvertAppInfo().o4.f13353e = l.getFirst_class();
            pVar.getAdvertAppInfo().o4.f13354f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().o4.f13355g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().o4.f13356h = pVar.getAdvertAppInfo().m4;
        pVar.getAdvertAppInfo().o4.f13357i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f23290b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f23290b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            p pVar = null;
            if (fVar == null) {
                return null;
            }
            this.f23293e = new ArrayList();
            Iterator<PostData> it = fVar.F().iterator();
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
            if (postData == null && fVar.j() != null) {
                postData = fVar.j();
            }
            if (postData != null) {
                this.f23293e.add(postData);
            }
            if (c.a.s0.h1.b.c.d()) {
                return this.f23293e;
            }
            x xVar = new x();
            e2 O = fVar.O();
            xVar.f22467e = O;
            if (O != null && m.isEmpty(O.a0())) {
                xVar.f22467e.M3(fVar.n());
            }
            this.f23293e.add(xVar);
            r rVar = new r(fVar.O(), fVar.d());
            rVar.f22445f = true;
            this.f23293e.add(rVar);
            if (postData != null && postData.s0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f23290b.getPbModel().r0()) || !this.f23290b.getPbModel().x0())) {
                c.a.t0.s2.r.i iVar = new c.a.t0.s2.r.i(postData.s0);
                iVar.f22418f = this.f23290b.getPbModel().h1();
                this.f23293e.add(iVar);
            }
            List<p> Y = fVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.t0.x1.o.k.a.e(Y) && (pVar = (p) c.a.t0.x1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (fVar.f() != null) {
                c.a.t0.s2.r.e eVar = new c.a.t0.s2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.related_recommendation));
                this.f23293e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f23293e.add(new c.a.t0.s2.r.s());
                } else {
                    int i4 = 1;
                    for (q qVar : fVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.t0.x1.o.k.a.a(this.f23293e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.B4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.t0.x1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.t0.x1.o.k.a.a(this.f23293e, qVar);
                        i4++;
                        if (i4 == 4 && fVar.C() != null) {
                            c.a.t0.x1.o.k.a.a(this.f23293e, fVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f23293e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.t0.s2.r.f fVar = this.f23291c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f23291c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            n0.b(new C1423c(this), new d(this, i2));
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
            this.n = c.a.t0.j3.y.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.o = c.a.t0.j3.y.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.D4);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f23294f = new h(videoPbFragment, videoPbFragment, PostData.z0);
            this.f23295g = new f(detailInfoFragment.getContext(), x.f22466f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), r.f22443j);
            this.f23296h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.q);
            this.f23297i = new k(detailInfoFragment.getVideoPbFragment(), c.a.t0.s2.r.e.f22398g);
            c.a.t0.s2.u.f.i iVar = new c.a.t0.s2.u.f.i(detailInfoFragment.getVideoPbFragment(), q.j4);
            this.f23298j = iVar;
            iVar.g0(true);
            this.k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.t0.s2.r.i.f22416g);
            s0 s0Var = new s0(detailInfoFragment.getVideoPbFragment(), c.a.t0.s2.r.s.f22449e);
            this.m = s0Var;
            s0Var.e0(this.p);
            this.a.add(this.f23294f);
            this.a.add(this.f23295g);
            this.a.add(this.f23296h);
            this.a.add(this.f23297i);
            this.a.add(this.f23298j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f23292d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f23292d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f23294f) == null) {
            return;
        }
        hVar.H();
    }

    public void n(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23291c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f23292d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f23294f.A0(fVar);
        this.f23298j.f0(fVar);
        this.k.d0(fVar);
        this.f23292d.setData(g(fVar));
    }
}
