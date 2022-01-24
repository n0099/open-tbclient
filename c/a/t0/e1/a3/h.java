package c.a.t0.e1.a3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.e1.f1;
import c.a.t0.e1.i1;
import c.a.t0.e1.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class h extends c.a.d.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f16077b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.e1.d3.b f16078c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.e1.z1.e.a f16079d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16080e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f16081f;

    /* renamed from: g  reason: collision with root package name */
    public int f16082g;

    /* renamed from: h  reason: collision with root package name */
    public String f16083h;

    /* renamed from: i  reason: collision with root package name */
    public int f16084i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16085j;
    public int k;
    public c.a.t0.r0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16086e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16086e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q frsView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16086e.a != null && this.f16086e.f16084i == 0 && (frsView = this.f16086e.a.getFrsView()) != null && frsView.X() != null && !frsView.X().o() && !frsView.Z() && this.f16086e.f16077b.isShown() && this.f16086e.a.isPrimary() && !this.f16086e.f16085j && this.f16086e.a.canShowSpeedTipView() && this.f16086e.k == 1 && this.f16086e.x() && this.f16086e.f16078c != null && this.f16086e.f16078c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f16086e.j0();
                this.f16086e.a.mSpeedUpTipShowing = true;
                this.f16086e.f16085j = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16087e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16087e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16087e.a == null || this.f16087e.f16084i != 0 || this.f16087e.a.getFrsView().Z() || !this.f16087e.f16077b.isShown() || !this.f16087e.a.isPrimary() || this.f16087e.a.getActivity() == null || this.f16087e.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f16087e.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f16087e.g0();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16088e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16088e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof c.a.d.g.a.h) {
                ((c.a.d.g.a.h) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16088e.f16077b == null) {
                return;
            }
            int childCount = this.f16088e.f16077b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f16088e.f16077b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16089e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16089e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16089e.a == null) {
                return;
            }
            FrsViewData frsViewData = this.f16089e.a.getFrsViewData();
            if (frsViewData != null && frsViewData.getForum() != null && this.f16089e.f16078c != null && (view == this.f16089e.f16078c.e() || view == this.f16089e.f16078c.f() || view == this.f16089e.f16078c.i())) {
                if (this.f16089e.a != null && frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", frsViewData.getForum().getId()).param("obj_locate", this.f16089e.a.isFromMainTab() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < frsViewData.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(frsViewData.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f16089e.getPageContext().getPageActivity(), frsViewData.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == f1.tv_love) {
                if (this.f16089e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f16089e.a.showToast(i1.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f16089e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f16089e.a.getForumId()));
                } else {
                    this.f16089e.l0(true);
                    if (c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f16089e.a.getForumId());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == f1.tv_sign) {
                if (this.f16089e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f16089e.a.showToast(i1.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f16089e.mContext.getPageActivity())) {
                    if (!this.f16089e.t()) {
                        this.f16089e.m0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f16089e.a.getPageContext().getPageActivity(), c.a.d.f.m.b.e(this.f16089e.a.getForumId(), 0), 24002)));
                    }
                }
            } else if (id == f1.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f16089e.mContext.getPageActivity()) || frsViewData == null || frsViewData.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f16089e.getPageContext(), new String[]{frsViewData.getGameUrl()}, true);
            } else if (id == f1.frs_bawu_center) {
                if (frsViewData == null || frsViewData.getUserData() == null || !frsViewData.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = frsViewData.getBawuCenterUrl();
                if (c.a.d.f.p.m.isEmpty(bawuCenterUrl)) {
                    return;
                }
                c.a.s0.m.a.m(this.f16089e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", frsViewData.getForum().getId()).param("uid", frsViewData.getUserData().getUserId()));
                }
            } else if (id == f1.level_container) {
                if (this.f16089e.a.getIsRefresh() || this.f16089e.f16084i != 0 || !this.f16089e.x() || this.f16089e.f16078c == null) {
                    return;
                }
                this.f16089e.f16078c.M(view, false);
            } else if (id == f1.frs_hot_rank_entry) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f16089e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(frsViewData.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", frsViewData.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == f1.frs_manager_info_layout) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f16089e.getPageContext().getPageActivity(), String.valueOf(frsViewData.getForum().getId()), frsViewData.getForum().getName())));
            } else if (id == f1.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f16089e.mContext.getPageActivity()) && frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f16089e.a.getTbPageContext();
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + frsViewData.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, c.a.t0.e1.z1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, aVar, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16080e = false;
        this.f16082g = 0;
        this.f16083h = FrsFragment.NORMAL_FRS;
        this.f16084i = 0;
        this.f16085j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.f16079d = aVar;
        this.f16077b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f16081f = gen;
        this.n = new g(this.a, gen);
        this.o = new f(this.a);
        this.l = new c.a.t0.r0.a();
    }

    public static boolean A(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean B(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData != null) {
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void C(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            g gVar = this.n;
            if (gVar != null) {
                gVar.n();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.j();
            }
            this.f16085j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.e1.d3.b bVar = this.f16078c;
            if (bVar != null) {
                bVar.r();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.k();
            }
            if (this.p != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.q);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.e1.d3.b bVar = this.f16078c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f16077b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f16082g = i2;
            c.a.t0.e1.d3.b bVar = this.f16078c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void G(boolean z) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void H(MotionEvent motionEvent) {
        c.a.t0.r0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.c(motionEvent);
    }

    public void I(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
            c0(num.intValue());
            if (x()) {
                N();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16078c.w();
        }
    }

    public void K(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float u = u(forumData);
        c.a.t0.e1.d3.b bVar = this.f16078c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f16078c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), u, false);
        this.f16078c.G(forumData.getSignData());
    }

    public void L(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) && frsViewData != null && x()) {
            K(frsViewData.getForum(), frsViewData);
            if (FrsFragment.BRAND_FRS.equals(this.f16083h)) {
                this.f16078c.b();
            }
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && x()) {
            W(i2);
        }
    }

    public void N() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.S();
    }

    public void O() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (frsHeaderViewContainer = this.f16077b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f16077b.postDelayed(this.r, 100L);
    }

    public void P(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) || frsViewData == null || this.f16078c == null || !x()) {
            return;
        }
        this.f16078c.u(u(frsViewData.getForum()));
    }

    public void Q() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.x();
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || this.a.getModelController() == null || this.a.getModelController().T() == null) {
            return;
        }
        int B = this.a.getModelController().T().B();
        int y = this.a.getModelController().T().y();
        int x = this.a.getModelController().T().x();
        c.a.t0.x3.e i2 = c.a.t0.x3.e.i();
        c.a.t0.x3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.t0.e1.d3.b bVar = this.f16078c;
            if (bVar != null) {
                this.f16077b.removeHeaderView(bVar.k());
                this.f16077b.removeHeaderView(this.f16078c.g());
                T();
            }
            this.f16080e = false;
        }
    }

    public final void T() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.getListView() == null) {
            return;
        }
        this.a.getListView().removeHeaderView(this.m.G());
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                c.a.t0.e1.d3.b bVar = this.f16078c;
                if (bVar != null) {
                    this.f16077b.removeHeaderView(bVar.g());
                    this.f16080e = false;
                    return;
                }
                return;
            }
            c.a.t0.e1.d3.b bVar2 = this.f16078c;
            if (bVar2 == null || bVar2.g() == null || this.f16080e) {
                return;
            }
            this.f16077b.addHeaderView(this.f16078c.g(), this.f16077b.getHeaderViewsCount());
            this.f16080e = true;
        }
    }

    public void V(int i2) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bVar = this.f16078c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f16078c.g().findViewById(f1.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f16078c.m();
    }

    public void W(int i2) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void X(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f16078c.E(i2, forumData.getLevelName(), forumData.getUser_level(), u(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f16078c.a(false);
    }

    public void Y(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, frsViewData, z) == null) && frsViewData != null && x()) {
            X(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void Z(int i2) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && x() && (bVar = this.f16078c) != null) {
            bVar.F(i2);
        }
    }

    public void a0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && x() && (gVar = this.n) != null) {
            gVar.t(this.f16078c, frsViewData);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && x()) {
            W(0);
        }
    }

    public void c0(int i2) {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 > 1) {
                c.a.t0.e1.d3.b bVar = this.f16078c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            c.a.t0.e1.d3.b bVar2 = this.f16078c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f16084i = i2;
        }
    }

    public void f0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void g0() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.N();
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public void i0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        q(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void j0() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && x() && (bVar = this.f16078c) != null) {
            bVar.O();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public void l0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.o(z);
    }

    public void m0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (gVar = this.n) == null) {
            return;
        }
        c.a.t0.e1.d3.b bVar = this.f16078c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f16078c.d());
        } else {
            gVar.v(false, "");
        }
        c.a.t0.e1.d3.b bVar2 = this.f16078c;
        if (bVar2 != null) {
            this.n.u(bVar2.j());
        }
    }

    public void n0() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.p();
    }

    public void o0(int i2, int i3, int i4) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048614, this, i2, i3, i4) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.w(i2, i3, i4);
    }

    public void p() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f16080e || (bVar = this.f16078c) == null) {
            return;
        }
        this.f16077b.addHeaderView(bVar.g());
        this.f16080e = true;
    }

    public final void q(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f16083h, str);
            this.k = i3;
            this.f16083h = str;
            S();
            if (this.f16078c == null || z) {
                c.a.t0.e1.d3.b e2 = this.f16079d.e(str, this.a, i2);
                this.f16078c = e2;
                e2.c(this.f16082g);
                this.f16078c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f16078c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f16078c.I(fVar);
            }
            this.f16077b.addHeaderView(this.f16078c.k());
            r(str);
            k0();
            h0();
        }
    }

    public final void r(String str) {
        FrsFragment frsFragment;
        RelativeLayout G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.getListView() == null || (G = this.m.G()) == null) {
            return;
        }
        if (FrsFragment.BRAND_FRS.equals(str)) {
            this.a.getListView().removeHeaderView(G);
            return;
        }
        this.a.getListView().removeHeaderView(G);
        this.a.getListView().addHeaderView(G, 0);
    }

    public boolean s() {
        InterceptResult invokeV;
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!x() || (bVar = this.f16078c) == null) {
                return false;
            }
            return bVar.l();
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!x() || (bVar = this.f16078c) == null) {
                return false;
            }
            return bVar.h();
        }
        return invokeV.booleanValue;
    }

    public final float u(ForumData forumData) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public void w() {
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.f16078c) == null) {
            return;
        }
        bVar.m();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? FrsFragment.STAR_FRS.equals(this.f16083h) || FrsFragment.NORMAL_FRS.equals(this.f16083h) || FrsFragment.BOOK_FRS.equals(this.f16083h) || FrsFragment.BRAND_FRS.equals(this.f16083h) : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        c.a.t0.e1.d3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!x() || (bVar = this.f16078c) == null) {
                return false;
            }
            return bVar.o();
        }
        return invokeV.booleanValue;
    }
}
