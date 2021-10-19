package c.a.r0.k2.o.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import c.a.q0.s.q.d2;
import c.a.r0.k2.h.v;
import c.a.r0.k2.k.e.k;
import c.a.r0.k2.k.e.r0;
import c.a.r0.k2.k.e.y;
import c.a.r0.k3.i0.p;
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
    public final List<c.a.e.l.e.a> f20791a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f20792b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.k2.h.e f20793c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f20794d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f20795e;

    /* renamed from: f  reason: collision with root package name */
    public h f20796f;

    /* renamed from: g  reason: collision with root package name */
    public f f20797g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20798h;

    /* renamed from: i  reason: collision with root package name */
    public k f20799i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.k2.k.e.i f20800j;
    public y k;
    public PbFirstFloorItemAdapter l;
    public r0 m;
    public c.a.e.l.e.a n;
    public c.a.e.l.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20801e;

        /* renamed from: c.a.r0.k2.o.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0982a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f20802a;

            /* renamed from: c.a.r0.k2.o.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0983a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0982a f20803e;

                public RunnableC0983a(C0982a c0982a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0982a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f20803e = c0982a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f20803e.f20802a.f20801e.f20792b.getPbModel().Y1(3);
                    }
                }
            }

            public C0982a(a aVar) {
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
                this.f20802a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!c.a.e.e.p.j.z()) {
                        this.f20802a.f20801e.f20792b.refreshByBrowseMode();
                    } else {
                        c.a.e.e.m.e.a().postDelayed(new RunnableC0983a(this), 10L);
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
            this.f20801e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20801e.f20792b == null || this.f20801e.f20792b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f20801e.f20792b.getPageContext(), new C0982a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20804e;

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
            this.f20804e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f20804e.f(11009)) {
                        this.f20804e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f20804e.f(11009)) {
                        this.f20804e.i(3);
                    }
                } else if (this.f20804e.f20792b == null || this.f20804e.f20792b.getVideoPbFragment() == null || this.f20804e.f20792b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f20804e.f20792b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.r0.k2.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0984c extends i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20805a;

        public C0984c(c cVar) {
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
            this.f20805a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.k2.k.e.f1.b.d(this.f20805a.f20792b.getContext(), this.f20805a.h(), ShareSwitch.isOn() ? 1 : 6, this.f20805a.f20792b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20807b;

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
            this.f20807b = cVar;
            this.f20806a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20807b.f20792b.getContext(), this.f20806a, shareItem, false));
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
        this.f20791a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f20792b = detailInfoFragment;
        this.f20794d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f20793c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new c.a.q0.s.q.e();
        if (this.f20793c.y() != null) {
            pVar.getAdvertAppInfo().g4.f14167b = this.f20793c.y().a();
        }
        pVar.getAdvertAppInfo().g4.f14166a = pVar.G0();
        if (this.f20793c.m() != null && (m = this.f20793c.m()) != null) {
            pVar.getAdvertAppInfo().g4.f14169d = m.getId();
            pVar.getAdvertAppInfo().g4.f14170e = m.getFirst_class();
            pVar.getAdvertAppInfo().g4.f14171f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().g4.f14172g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().g4.f14173h = pVar.getAdvertAppInfo().e4;
        pVar.getAdvertAppInfo().g4.f14174i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f20792b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20792b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            p pVar = null;
            if (eVar == null) {
                return null;
            }
            this.f20795e = new ArrayList();
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
                this.f20795e.add(postData);
            }
            if (c.a.q0.g1.b.c.d()) {
                return this.f20795e;
            }
            v vVar = new v();
            d2 O = eVar.O();
            vVar.f19876e = O;
            if (O != null && c.a.e.e.p.k.isEmpty(O.Z())) {
                vVar.f19876e.H3(eVar.o());
            }
            this.f20795e.add(vVar);
            c.a.r0.k2.h.p pVar2 = new c.a.r0.k2.h.p(eVar.O(), eVar.d());
            pVar2.f19850f = true;
            this.f20795e.add(pVar2);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f20792b.getPbModel().q0()) || !this.f20792b.getPbModel().v0())) {
                c.a.r0.k2.h.h hVar = new c.a.r0.k2.h.h(postData.p0);
                hVar.f19821f = this.f20792b.getPbModel().f1();
                this.f20795e.add(hVar);
            }
            List<p> Y = eVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.r0.q1.o.k.a.e(Y) && (pVar = (p) c.a.r0.q1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (eVar.f() != null) {
                c.a.r0.k2.h.d dVar = new c.a.r0.k2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f20795e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f20795e.add(new c.a.r0.k2.h.q());
                } else {
                    int i4 = 1;
                    for (c.a.q0.s.q.q qVar : eVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.r0.q1.o.k.a.a(this.f20795e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.s4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.r0.q1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.r0.q1.o.k.a.a(this.f20795e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.C() != null) {
                            c.a.r0.q1.o.k.a.a(this.f20795e, eVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f20795e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.k2.h.e eVar = this.f20793c;
            if (eVar == null || eVar.O() == null) {
                return -1;
            }
            return this.f20793c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            l0.b(new C0984c(this), new d(this, i2));
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
            this.n = c.a.r0.z2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.o = c.a.r0.z2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            this.f20791a.add(this.n);
            this.f20791a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f20796f = new h(videoPbFragment, videoPbFragment, PostData.u0);
            this.f20797g = new f(detailInfoFragment.getContext(), v.f19875f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), c.a.r0.k2.h.p.f19848j);
            this.f20798h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.v0(this.q);
            this.f20799i = new k(detailInfoFragment.getVideoPbFragment(), c.a.r0.k2.h.d.f19800g);
            c.a.r0.k2.k.e.i iVar = new c.a.r0.k2.k.e.i(detailInfoFragment.getVideoPbFragment(), c.a.q0.s.q.q.b4);
            this.f20800j = iVar;
            iVar.o0(true);
            this.k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.r0.k2.h.h.f19819g);
            r0 r0Var = new r0(detailInfoFragment.getVideoPbFragment(), c.a.r0.k2.h.q.f19854e);
            this.m = r0Var;
            r0Var.l0(this.p);
            this.f20791a.add(this.f20796f);
            this.f20791a.add(this.f20797g);
            this.f20791a.add(this.f20798h);
            this.f20791a.add(this.f20799i);
            this.f20791a.add(this.f20800j);
            this.f20791a.add(this.k);
            this.f20791a.add(this.l);
            this.f20791a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f20791a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f20794d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f20794d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f20796f) == null) {
            return;
        }
        hVar.P();
    }

    public void n(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f20793c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20794d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f20796f.I0(eVar);
        this.f20800j.n0(eVar);
        this.k.l0(eVar);
        this.f20794d.setData(g(eVar));
    }
}
