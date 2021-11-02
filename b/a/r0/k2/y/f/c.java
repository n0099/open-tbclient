package b.a.r0.k2.y.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import b.a.q0.s.q.d2;
import b.a.r0.k2.l;
import b.a.r0.k2.r.r;
import b.a.r0.k2.r.w;
import b.a.r0.k2.u.f.k;
import b.a.r0.k2.u.f.r0;
import b.a.r0.k2.u.f.y;
import b.a.r0.l3.j0.p;
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
    public final List<b.a.e.l.e.a> f19768a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f19769b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k2.r.f f19770c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f19771d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f19772e;

    /* renamed from: f  reason: collision with root package name */
    public h f19773f;

    /* renamed from: g  reason: collision with root package name */
    public f f19774g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f19775h;

    /* renamed from: i  reason: collision with root package name */
    public k f19776i;
    public b.a.r0.k2.u.f.i j;
    public y k;
    public PbFirstFloorItemAdapter l;
    public r0 m;
    public b.a.e.l.e.a n;
    public b.a.e.l.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19777e;

        /* renamed from: b.a.r0.k2.y.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0981a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f19778a;

            /* renamed from: b.a.r0.k2.y.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0982a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0981a f19779e;

                public RunnableC0982a(C0981a c0981a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0981a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f19779e = c0981a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f19779e.f19778a.f19777e.f19769b.getPbModel().Z1(3);
                    }
                }
            }

            public C0981a(a aVar) {
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
                this.f19778a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!b.a.e.e.p.j.z()) {
                        this.f19778a.f19777e.f19769b.refreshByBrowseMode();
                    } else {
                        b.a.e.e.m.e.a().postDelayed(new RunnableC0982a(this), 10L);
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
            this.f19777e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19777e.f19769b == null || this.f19777e.f19769b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f19777e.f19769b.getPageContext(), new C0981a(this));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19780e;

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
            this.f19780e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == b.a.r0.k2.i.qq_share_container) {
                    if (this.f19780e.f(11009)) {
                        this.f19780e.i(8);
                    }
                } else if (view.getId() == b.a.r0.k2.i.share_num_container) {
                    if (this.f19780e.f(11009)) {
                        this.f19780e.i(3);
                    }
                } else if (this.f19780e.f19769b == null || this.f19780e.f19769b.getVideoPbFragment() == null || this.f19780e.f19769b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f19780e.f19769b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: b.a.r0.k2.y.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0983c extends i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19781a;

        public C0983c(c cVar) {
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
            this.f19781a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.r0.k2.u.f.f1.b.d(this.f19781a.f19769b.getContext(), this.f19781a.h(), ShareSwitch.isOn() ? 1 : 6, this.f19781a.f19769b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19782a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19783b;

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
            this.f19783b = cVar;
            this.f19782a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f19783b.f19769b.getContext(), this.f19782a, shareItem, false));
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
        this.f19768a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f19769b = detailInfoFragment;
        this.f19771d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f19770c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new b.a.q0.s.q.e();
        if (this.f19770c.y() != null) {
            pVar.getAdvertAppInfo().g4.f13277b = this.f19770c.y().a();
        }
        pVar.getAdvertAppInfo().g4.f13276a = pVar.K0();
        if (this.f19770c.l() != null && (l = this.f19770c.l()) != null) {
            pVar.getAdvertAppInfo().g4.f13279d = l.getId();
            pVar.getAdvertAppInfo().g4.f13280e = l.getFirst_class();
            pVar.getAdvertAppInfo().g4.f13281f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().g4.f13282g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().g4.f13283h = pVar.getAdvertAppInfo().e4;
        pVar.getAdvertAppInfo().g4.f13284i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f19769b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f19769b.getPbActivity(), true, i2)));
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
            this.f19772e = new ArrayList();
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
                this.f19772e.add(postData);
            }
            if (b.a.q0.g1.b.c.d()) {
                return this.f19772e;
            }
            w wVar = new w();
            d2 O = fVar.O();
            wVar.f18825e = O;
            if (O != null && b.a.e.e.p.k.isEmpty(O.Z())) {
                wVar.f18825e.I3(fVar.n());
            }
            this.f19772e.add(wVar);
            b.a.r0.k2.r.q qVar = new b.a.r0.k2.r.q(fVar.O(), fVar.d());
            qVar.f18800f = true;
            this.f19772e.add(qVar);
            if (postData != null && postData.r0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f19769b.getPbModel().q0()) || !this.f19769b.getPbModel().v0())) {
                b.a.r0.k2.r.i iVar = new b.a.r0.k2.r.i(postData.r0);
                iVar.f18773f = this.f19769b.getPbModel().f1();
                this.f19772e.add(iVar);
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
                this.f19772e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f19772e.add(new r());
                } else {
                    int i4 = 1;
                    for (b.a.q0.s.q.q qVar2 : fVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                b.a.r0.q1.o.k.a.a(this.f19772e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.s4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) b.a.r0.q1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        b.a.r0.q1.o.k.a.a(this.f19772e, qVar2);
                        i4++;
                        if (i4 == 4 && fVar.C() != null) {
                            b.a.r0.q1.o.k.a.a(this.f19772e, fVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f19772e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.k2.r.f fVar = this.f19770c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f19770c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            l0.b(new C0983c(this), new d(this, i2));
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
            this.n = b.a.r0.z2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.o = b.a.r0.z2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            this.f19768a.add(this.n);
            this.f19768a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f19773f = new h(videoPbFragment, videoPbFragment, PostData.x0);
            this.f19774g = new f(detailInfoFragment.getContext(), w.f18824f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), b.a.r0.k2.r.q.j);
            this.f19775h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.u0(this.q);
            this.f19776i = new k(detailInfoFragment.getVideoPbFragment(), b.a.r0.k2.r.e.f18754g);
            b.a.r0.k2.u.f.i iVar = new b.a.r0.k2.u.f.i(detailInfoFragment.getVideoPbFragment(), b.a.q0.s.q.q.b4);
            this.j = iVar;
            iVar.n0(true);
            this.k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), b.a.r0.k2.r.i.f18771g);
            r0 r0Var = new r0(detailInfoFragment.getVideoPbFragment(), r.f18804e);
            this.m = r0Var;
            r0Var.k0(this.p);
            this.f19768a.add(this.f19773f);
            this.f19768a.add(this.f19774g);
            this.f19768a.add(this.f19775h);
            this.f19768a.add(this.f19776i);
            this.f19768a.add(this.j);
            this.f19768a.add(this.k);
            this.f19768a.add(this.l);
            this.f19768a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f19768a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f19771d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f19771d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f19773f) == null) {
            return;
        }
        hVar.O();
    }

    public void n(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f19770c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19771d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f19773f.H0(fVar);
        this.j.m0(fVar);
        this.k.k0(fVar);
        this.f19771d.setData(g(fVar));
    }
}
