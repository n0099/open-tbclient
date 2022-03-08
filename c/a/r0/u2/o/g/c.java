package c.a.r0.u2.o.g;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.q0.c1.k0;
import c.a.q0.c1.n0;
import c.a.q0.c1.s;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.q;
import c.a.r0.u2.h.r;
import c.a.r0.u2.h.x;
import c.a.r0.u2.k.f.l;
import c.a.r0.u2.k.f.t0;
import c.a.r0.u2.k.f.z;
import c.a.r0.y3.k0.o;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f23982b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.u2.h.f f23983c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f23984d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f23985e;

    /* renamed from: f  reason: collision with root package name */
    public h f23986f;

    /* renamed from: g  reason: collision with root package name */
    public f f23987g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f23988h;

    /* renamed from: i  reason: collision with root package name */
    public l f23989i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.u2.k.f.j f23990j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public t0 m;
    public c.a.d.o.e.a n;
    public c.a.d.o.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23991e;

        /* renamed from: c.a.r0.u2.o.g.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1472a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: c.a.r0.u2.o.g.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1473a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1472a f23992e;

                public RunnableC1473a(C1472a c1472a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1472a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23992e = c1472a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f23992e.a.f23991e.f23982b.getPbModel().f2(3);
                    }
                }
            }

            public C1472a(a aVar) {
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
                    if (!c.a.d.f.p.l.z()) {
                        this.a.f23991e.f23982b.refreshByBrowseMode();
                    } else {
                        c.a.d.f.m.e.a().postDelayed(new RunnableC1473a(this), 10L);
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
            this.f23991e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23991e.f23982b == null || this.f23991e.f23982b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f23991e.f23982b.getPageContext(), new C1472a(this));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23993e;

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
            this.f23993e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f23993e.f(11009)) {
                        this.f23993e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f23993e.f(11009)) {
                        this.f23993e.i(3);
                    }
                } else if (this.f23993e.f23982b == null || this.f23993e.f23982b.getVideoPbFragment() == null || this.f23993e.f23982b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f23993e.f23982b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.r0.u2.o.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1474c extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1474c(c cVar) {
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
        @Override // c.a.q0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.u2.k.f.h1.b.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.f23982b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23994b;

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
            this.f23994b = cVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f23994b.f23982b.getContext(), this.a, shareItem, false));
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
        this.f23982b = detailInfoFragment;
        this.f23984d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null || this.f23983c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().p4 = new c.a.q0.r.r.e();
        if (this.f23983c.y() != null) {
            oVar.getAdvertAppInfo().p4.f13236b = this.f23983c.y().a();
        }
        oVar.getAdvertAppInfo().p4.a = oVar.L0();
        if (this.f23983c.l() != null && (l = this.f23983c.l()) != null) {
            oVar.getAdvertAppInfo().p4.f13238d = l.getId();
            oVar.getAdvertAppInfo().p4.f13239e = l.getFirst_class();
            oVar.getAdvertAppInfo().p4.f13240f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().p4.f13241g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().p4.f13242h = oVar.getAdvertAppInfo().n4;
        oVar.getAdvertAppInfo().p4.f13243i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f23982b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f23982b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            o oVar = null;
            if (fVar == null) {
                return null;
            }
            this.f23985e = new ArrayList();
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
                this.f23985e.add(postData);
            }
            if (c.a.q0.f1.b.c.d()) {
                return this.f23985e;
            }
            x xVar = new x();
            e2 O = fVar.O();
            xVar.f23158e = O;
            if (O != null && m.isEmpty(O.b0())) {
                xVar.f23158e.N3(fVar.n());
            }
            this.f23985e.add(xVar);
            r rVar = new r(fVar.O(), fVar.d());
            rVar.f23136f = true;
            this.f23985e.add(rVar);
            if (postData != null && postData.s0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f23982b.getPbModel().r0()) || !this.f23982b.getPbModel().x0())) {
                c.a.r0.u2.h.i iVar = new c.a.r0.u2.h.i(postData.s0);
                iVar.f23109f = this.f23982b.getPbModel().h1();
                this.f23985e.add(iVar);
            }
            List<o> Y = fVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.r0.z1.o.k.a.e(Y) && (oVar = (o) c.a.r0.z1.o.k.a.d(Y, 0)) != null) {
                i3 = oVar.getPosition();
            }
            if (fVar.f() != null) {
                c.a.r0.u2.h.e eVar = new c.a.r0.u2.h.e();
                eVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f23985e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f23985e.add(new c.a.r0.u2.h.s());
                } else {
                    int i4 = 1;
                    for (q qVar : fVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (oVar != null) {
                                e(oVar);
                                c.a.r0.z1.o.k.a.a(this.f23985e, oVar);
                                i2++;
                                if (oVar.getType() != AdvertAppInfo.C4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (oVar = (o) c.a.r0.z1.o.k.a.d(Y, i2)) != null) {
                                i3 = oVar.getPosition();
                            }
                        }
                        c.a.r0.z1.o.k.a.a(this.f23985e, qVar);
                        i4++;
                        if (i4 == 4 && fVar.C() != null) {
                            c.a.r0.z1.o.k.a.a(this.f23985e, fVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f23985e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.u2.h.f fVar = this.f23983c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f23983c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            n0.b(new C1474c(this), new d(this, i2));
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
            this.n = c.a.r0.j3.z.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.o = c.a.r0.j3.z.q().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.E4);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f23986f = new h(videoPbFragment, videoPbFragment, PostData.z0);
            this.f23987g = new f(detailInfoFragment.getContext(), x.f23157f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), r.f23134j);
            this.f23988h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.q);
            this.f23989i = new l(detailInfoFragment.getVideoPbFragment(), c.a.r0.u2.h.e.f23089g);
            c.a.r0.u2.k.f.j jVar = new c.a.r0.u2.k.f.j(detailInfoFragment.getVideoPbFragment(), q.k4);
            this.f23990j = jVar;
            jVar.g0(true);
            this.k = new z(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.r0.u2.h.i.f23107g);
            t0 t0Var = new t0(detailInfoFragment.getVideoPbFragment(), c.a.r0.u2.h.s.f23140e);
            this.m = t0Var;
            t0Var.e0(this.p);
            this.a.add(this.f23986f);
            this.a.add(this.f23987g);
            this.a.add(this.f23988h);
            this.a.add(this.f23989i);
            this.a.add(this.f23990j);
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f23984d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f23984d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f23986f) == null) {
            return;
        }
        hVar.H();
    }

    public void n(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23983c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f23984d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f23986f.A0(fVar);
        this.f23990j.f0(fVar);
        this.k.d0(fVar);
        this.f23984d.setData(g(fVar));
    }
}
