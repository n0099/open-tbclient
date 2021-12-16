package c.a.s0.s2.y.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.r0.d1.k0;
import c.a.r0.d1.n0;
import c.a.r0.d1.s;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.q;
import c.a.s0.s2.r.r;
import c.a.s0.s2.r.x;
import c.a.s0.s2.u.f.k;
import c.a.s0.s2.u.f.s0;
import c.a.s0.s2.u.f.y;
import c.a.s0.v3.j0.p;
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
    public final List<c.a.d.m.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f23444b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.s2.r.f f23445c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f23446d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f23447e;

    /* renamed from: f  reason: collision with root package name */
    public h f23448f;

    /* renamed from: g  reason: collision with root package name */
    public f f23449g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f23450h;

    /* renamed from: i  reason: collision with root package name */
    public k f23451i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s2.u.f.i f23452j;

    /* renamed from: k  reason: collision with root package name */
    public y f23453k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public c.a.d.m.e.a n;
    public c.a.d.m.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23454e;

        /* renamed from: c.a.s0.s2.y.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1378a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: c.a.s0.s2.y.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1379a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1378a f23455e;

                public RunnableC1379a(C1378a c1378a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1378a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23455e = c1378a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f23455e.a.f23454e.f23444b.getPbModel().f2(3);
                    }
                }
            }

            public C1378a(a aVar) {
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
                    if (!c.a.d.f.p.k.z()) {
                        this.a.f23454e.f23444b.refreshByBrowseMode();
                    } else {
                        c.a.d.f.m.e.a().postDelayed(new RunnableC1379a(this), 10L);
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
            this.f23454e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23454e.f23444b == null || this.f23454e.f23444b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f23454e.f23444b.getPageContext(), new C1378a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23456e;

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
            this.f23456e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.s0.s2.i.qq_share_container) {
                    if (this.f23456e.f(11009)) {
                        this.f23456e.i(8);
                    }
                } else if (view.getId() == c.a.s0.s2.i.share_num_container) {
                    if (this.f23456e.f(11009)) {
                        this.f23456e.i(3);
                    }
                } else if (this.f23456e.f23444b == null || this.f23456e.f23444b.getVideoPbFragment() == null || this.f23456e.f23444b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f23456e.f23444b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.s0.s2.y.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1380c extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1380c(c cVar) {
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
        @Override // c.a.r0.d1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.s0.s2.u.f.g1.b.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.f23444b.getPbModel());
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
        public final /* synthetic */ c f23457b;

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
            this.f23457b = cVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f23457b.f23444b.getContext(), this.a, shareItem, false));
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
        this.f23444b = detailInfoFragment;
        this.f23446d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f23445c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().m4 = new c.a.r0.s.r.e();
        if (this.f23445c.y() != null) {
            pVar.getAdvertAppInfo().m4.f13289b = this.f23445c.y().a();
        }
        pVar.getAdvertAppInfo().m4.a = pVar.K0();
        if (this.f23445c.l() != null && (l = this.f23445c.l()) != null) {
            pVar.getAdvertAppInfo().m4.f13291d = l.getId();
            pVar.getAdvertAppInfo().m4.f13292e = l.getFirst_class();
            pVar.getAdvertAppInfo().m4.f13293f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().m4.f13294g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().m4.f13295h = pVar.getAdvertAppInfo().k4;
        pVar.getAdvertAppInfo().m4.f13296i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f23444b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f23444b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.s0.s2.r.f fVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            p pVar = null;
            if (fVar == null) {
                return null;
            }
            this.f23447e = new ArrayList();
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
                this.f23447e.add(postData);
            }
            if (c.a.r0.g1.b.c.d()) {
                return this.f23447e;
            }
            x xVar = new x();
            d2 O = fVar.O();
            xVar.f22592e = O;
            if (O != null && l.isEmpty(O.a0())) {
                xVar.f22592e.M3(fVar.n());
            }
            this.f23447e.add(xVar);
            r rVar = new r(fVar.O(), fVar.d());
            rVar.f22569f = true;
            this.f23447e.add(rVar);
            if (postData != null && postData.s0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f23444b.getPbModel().r0()) || !this.f23444b.getPbModel().x0())) {
                c.a.s0.s2.r.i iVar = new c.a.s0.s2.r.i(postData.s0);
                iVar.f22541f = this.f23444b.getPbModel().h1();
                this.f23447e.add(iVar);
            }
            List<p> Y = fVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.s0.x1.o.k.a.e(Y) && (pVar = (p) c.a.s0.x1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (fVar.f() != null) {
                c.a.s0.s2.r.e eVar = new c.a.s0.s2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.related_recommendation));
                this.f23447e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f23447e.add(new c.a.s0.s2.r.s());
                } else {
                    int i4 = 1;
                    for (q qVar : fVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.s0.x1.o.k.a.a(this.f23447e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.z4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.s0.x1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.s0.x1.o.k.a.a(this.f23447e, qVar);
                        i4++;
                        if (i4 == 4 && fVar.C() != null) {
                            c.a.s0.x1.o.k.a.a(this.f23447e, fVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f23447e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.s2.r.f fVar = this.f23445c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f23445c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            n0.b(new C1380c(this), new d(this, i2));
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
            this.n = c.a.s0.j3.y.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.z4);
            this.o = c.a.s0.j3.y.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f23448f = new h(videoPbFragment, videoPbFragment, PostData.y0);
            this.f23449g = new f(detailInfoFragment.getContext(), x.f22591f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), r.f22567j);
            this.f23450h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.u0(this.q);
            this.f23451i = new k(detailInfoFragment.getVideoPbFragment(), c.a.s0.s2.r.e.f22519g);
            c.a.s0.s2.u.f.i iVar = new c.a.s0.s2.u.f.i(detailInfoFragment.getVideoPbFragment(), q.h4);
            this.f23452j = iVar;
            iVar.n0(true);
            this.f23453k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.s0.s2.r.i.f22539g);
            s0 s0Var = new s0(detailInfoFragment.getVideoPbFragment(), c.a.s0.s2.r.s.f22573e);
            this.m = s0Var;
            s0Var.l0(this.p);
            this.a.add(this.f23448f);
            this.a.add(this.f23449g);
            this.a.add(this.f23450h);
            this.a.add(this.f23451i);
            this.a.add(this.f23452j);
            this.a.add(this.f23453k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f23446d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f23446d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f23448f) == null) {
            return;
        }
        hVar.K();
    }

    public void n(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23445c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f23446d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f23448f.H0(fVar);
        this.f23452j.m0(fVar);
        this.f23453k.k0(fVar);
        this.f23446d.setData(g(fVar));
    }
}
