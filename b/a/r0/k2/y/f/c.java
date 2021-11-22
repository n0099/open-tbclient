package b.a.r0.k2.y.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.c1.q;
import b.a.q0.s.q.d2;
import b.a.r0.k2.l;
import b.a.r0.k2.r.r;
import b.a.r0.k2.r.s;
import b.a.r0.k2.r.x;
import b.a.r0.k2.u.f.k;
import b.a.r0.k2.u.f.s0;
import b.a.r0.k2.u.f.y;
import b.a.r0.m3.j0.p;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f21305a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f21306b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k2.r.f f21307c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f21308d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f21309e;

    /* renamed from: f  reason: collision with root package name */
    public h f21310f;

    /* renamed from: g  reason: collision with root package name */
    public f f21311g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f21312h;

    /* renamed from: i  reason: collision with root package name */
    public k f21313i;
    public b.a.r0.k2.u.f.i j;
    public y k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public b.a.e.m.e.a n;
    public b.a.e.m.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21314e;

        /* renamed from: b.a.r0.k2.y.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1050a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f21315a;

            /* renamed from: b.a.r0.k2.y.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1051a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1050a f21316e;

                public RunnableC1051a(C1050a c1050a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1050a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f21316e = c1050a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f21316e.f21315a.f21314e.f21306b.getPbModel().b2(3);
                    }
                }
            }

            public C1050a(a aVar) {
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
                this.f21315a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!b.a.e.f.p.j.z()) {
                        this.f21315a.f21314e.f21306b.refreshByBrowseMode();
                    } else {
                        b.a.e.f.m.e.a().postDelayed(new RunnableC1051a(this), 10L);
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
            this.f21314e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21314e.f21306b == null || this.f21314e.f21306b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f21314e.f21306b.getPageContext(), new C1050a(this));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21317e;

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
            this.f21317e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == b.a.r0.k2.i.qq_share_container) {
                    if (this.f21317e.f(11009)) {
                        this.f21317e.i(8);
                    }
                } else if (view.getId() == b.a.r0.k2.i.share_num_container) {
                    if (this.f21317e.f(11009)) {
                        this.f21317e.i(3);
                    }
                } else if (this.f21317e.f21306b == null || this.f21317e.f21306b.getVideoPbFragment() == null || this.f21317e.f21306b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f21317e.f21306b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: b.a.r0.k2.y.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1052c extends i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21318a;

        public C1052c(c cVar) {
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
            this.f21318a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.r0.k2.u.f.g1.b.d(this.f21318a.f21306b.getContext(), this.f21318a.h(), ShareSwitch.isOn() ? 1 : 6, this.f21318a.f21306b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f21320b;

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
            this.f21320b = cVar;
            this.f21319a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f21320b.f21306b.getContext(), this.f21319a, shareItem, false));
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
        this.f21305a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f21306b = detailInfoFragment;
        this.f21308d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f21307c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().h4 = new b.a.q0.s.q.e();
        if (this.f21307c.y() != null) {
            pVar.getAdvertAppInfo().h4.f14057b = this.f21307c.y().a();
        }
        pVar.getAdvertAppInfo().h4.f14056a = pVar.K0();
        if (this.f21307c.l() != null && (l = this.f21307c.l()) != null) {
            pVar.getAdvertAppInfo().h4.f14059d = l.getId();
            pVar.getAdvertAppInfo().h4.f14060e = l.getFirst_class();
            pVar.getAdvertAppInfo().h4.f14061f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().h4.f14062g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().h4.f14063h = pVar.getAdvertAppInfo().f4;
        pVar.getAdvertAppInfo().h4.f14064i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f21306b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f21306b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            p pVar = null;
            if (fVar == null) {
                return null;
            }
            this.f21309e = new ArrayList();
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
                this.f21309e.add(postData);
            }
            if (b.a.q0.f1.b.c.d()) {
                return this.f21309e;
            }
            x xVar = new x();
            d2 O = fVar.O();
            xVar.f20362e = O;
            if (O != null && b.a.e.f.p.k.isEmpty(O.Z())) {
                xVar.f20362e.K3(fVar.n());
            }
            this.f21309e.add(xVar);
            r rVar = new r(fVar.O(), fVar.d());
            rVar.f20337f = true;
            this.f21309e.add(rVar);
            if (postData != null && postData.r0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f21306b.getPbModel().q0()) || !this.f21306b.getPbModel().v0())) {
                b.a.r0.k2.r.i iVar = new b.a.r0.k2.r.i(postData.r0);
                iVar.f20309f = this.f21306b.getPbModel().f1();
                this.f21309e.add(iVar);
            }
            List<p> Y = fVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!b.a.r0.q1.o.k.a.e(Y) && (pVar = (p) b.a.r0.q1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (fVar.f() != null) {
                b.a.r0.k2.r.e eVar = new b.a.r0.k2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(l.related_recommendation));
                this.f21309e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f21309e.add(new s());
                } else {
                    int i4 = 1;
                    for (b.a.q0.s.q.q qVar : fVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                b.a.r0.q1.o.k.a.a(this.f21309e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.t4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) b.a.r0.q1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        b.a.r0.q1.o.k.a.a(this.f21309e, qVar);
                        i4++;
                        if (i4 == 4 && fVar.C() != null) {
                            b.a.r0.q1.o.k.a.a(this.f21309e, fVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f21309e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.k2.r.f fVar = this.f21307c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f21307c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            l0.b(new C1052c(this), new d(this, i2));
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
            this.n = b.a.r0.a3.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.t4);
            this.o = b.a.r0.a3.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.v4);
            this.f21305a.add(this.n);
            this.f21305a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f21310f = new h(videoPbFragment, videoPbFragment, PostData.x0);
            this.f21311g = new f(detailInfoFragment.getContext(), x.f20361f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), r.j);
            this.f21312h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.u0(this.q);
            this.f21313i = new k(detailInfoFragment.getVideoPbFragment(), b.a.r0.k2.r.e.f20290g);
            b.a.r0.k2.u.f.i iVar = new b.a.r0.k2.u.f.i(detailInfoFragment.getVideoPbFragment(), b.a.q0.s.q.q.c4);
            this.j = iVar;
            iVar.n0(true);
            this.k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), b.a.r0.k2.r.i.f20307g);
            s0 s0Var = new s0(detailInfoFragment.getVideoPbFragment(), s.f20341e);
            this.m = s0Var;
            s0Var.k0(this.p);
            this.f21305a.add(this.f21310f);
            this.f21305a.add(this.f21311g);
            this.f21305a.add(this.f21312h);
            this.f21305a.add(this.f21313i);
            this.f21305a.add(this.j);
            this.f21305a.add(this.k);
            this.f21305a.add(this.l);
            this.f21305a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f21305a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f21308d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f21308d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f21310f) == null) {
            return;
        }
        hVar.O();
    }

    public void n(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f21307c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f21308d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f21310f.H0(fVar);
        this.j.m0(fVar);
        this.k.k0(fVar);
        this.f21308d.setData(g(fVar));
    }
}
