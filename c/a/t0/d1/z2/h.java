package c.a.t0.d1.z2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
import c.a.t0.d1.q;
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
    public FrsHeaderViewContainer f17413b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.d1.c3.b f17414c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.d1.y1.e.a f17415d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17416e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f17417f;

    /* renamed from: g  reason: collision with root package name */
    public int f17418g;

    /* renamed from: h  reason: collision with root package name */
    public String f17419h;

    /* renamed from: i  reason: collision with root package name */
    public int f17420i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17421j;

    /* renamed from: k  reason: collision with root package name */
    public int f17422k;
    public c.a.t0.q0.a l;
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
        public final /* synthetic */ h f17423e;

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
            this.f17423e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q frsView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f17423e.a != null && this.f17423e.f17420i == 0 && (frsView = this.f17423e.a.getFrsView()) != null && frsView.X() != null && !frsView.X().o() && !frsView.Z() && this.f17423e.f17413b.isShown() && this.f17423e.a.isPrimary() && !this.f17423e.f17421j && this.f17423e.a.canShowSpeedTipView() && this.f17423e.f17422k == 1 && this.f17423e.x() && this.f17423e.f17414c != null && this.f17423e.f17414c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f17423e.j0();
                this.f17423e.a.mSpeedUpTipShowing = true;
                this.f17423e.f17421j = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f17424e;

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
            this.f17424e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17424e.a == null || this.f17424e.f17420i != 0 || this.f17424e.a.getFrsView().Z() || !this.f17424e.f17413b.isShown() || !this.f17424e.a.isPrimary() || this.f17424e.a.getActivity() == null || this.f17424e.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f17424e.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f17424e.g0();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f17425e;

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
            this.f17425e = hVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17425e.f17413b == null) {
                return;
            }
            int childCount = this.f17425e.f17413b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f17425e.f17413b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f17426e;

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
            this.f17426e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17426e.a == null) {
                return;
            }
            FrsViewData frsViewData = this.f17426e.a.getFrsViewData();
            if (frsViewData != null && frsViewData.getForum() != null && this.f17426e.f17414c != null && (view == this.f17426e.f17414c.e() || view == this.f17426e.f17414c.f() || view == this.f17426e.f17414c.i())) {
                if (this.f17426e.a != null && frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", frsViewData.getForum().getId()).param("obj_locate", this.f17426e.a.isFromMainTab() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < frsViewData.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(frsViewData.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f17426e.getPageContext().getPageActivity(), frsViewData.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == f1.tv_love) {
                if (this.f17426e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f17426e.a.showToast(i1.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f17426e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f17426e.a.getForumId()));
                } else {
                    this.f17426e.l0(true);
                    if (c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f17426e.a.getForumId());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == f1.tv_sign) {
                if (this.f17426e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f17426e.a.showToast(i1.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f17426e.mContext.getPageActivity())) {
                    if (!this.f17426e.t()) {
                        this.f17426e.m0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f17426e.a.getPageContext().getPageActivity(), c.a.d.f.m.b.e(this.f17426e.a.getForumId(), 0), 24002)));
                    }
                }
            } else if (id == f1.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f17426e.mContext.getPageActivity()) || frsViewData == null || frsViewData.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f17426e.getPageContext(), new String[]{frsViewData.getGameUrl()}, true);
            } else if (id == f1.frs_bawu_center) {
                if (frsViewData == null || frsViewData.getUserData() == null || !frsViewData.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = frsViewData.getBawuCenterUrl();
                if (c.a.d.f.p.m.isEmpty(bawuCenterUrl)) {
                    return;
                }
                c.a.s0.m.a.m(this.f17426e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", frsViewData.getForum().getId()).param("uid", frsViewData.getUserData().getUserId()));
                }
            } else if (id == f1.level_container) {
                if (this.f17426e.a.getIsRefresh() || this.f17426e.f17420i != 0 || !this.f17426e.x() || this.f17426e.f17414c == null) {
                    return;
                }
                this.f17426e.f17414c.M(view, false);
            } else if (id == f1.frs_hot_rank_entry) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f17426e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(frsViewData.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", frsViewData.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == f1.frs_manager_info_layout) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f17426e.getPageContext().getPageActivity(), String.valueOf(frsViewData.getForum().getId()), frsViewData.getForum().getName())));
            } else if (id == f1.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f17426e.mContext.getPageActivity()) && frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f17426e.a.getTbPageContext();
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + frsViewData.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, c.a.t0.d1.y1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
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
        this.f17416e = false;
        this.f17418g = 0;
        this.f17419h = FrsFragment.NORMAL_FRS;
        this.f17420i = 0;
        this.f17421j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.f17415d = aVar;
        this.f17413b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f17417f = gen;
        this.n = new g(this.a, gen);
        this.o = new f(this.a);
        this.l = new c.a.t0.q0.a();
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
            this.f17421j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.d1.c3.b bVar = this.f17414c;
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
            c.a.t0.d1.c3.b bVar = this.f17414c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f17413b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f17418g = i2;
            c.a.t0.d1.c3.b bVar = this.f17414c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void G(boolean z) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void H(MotionEvent motionEvent) {
        c.a.t0.q0.a aVar;
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
            this.f17414c.w();
        }
    }

    public void K(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float u = u(forumData);
        c.a.t0.d1.c3.b bVar = this.f17414c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f17414c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), u, false);
        this.f17414c.G(forumData.getSignData());
    }

    public void L(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) && frsViewData != null && x()) {
            K(frsViewData.getForum(), frsViewData);
            if (FrsFragment.BRAND_FRS.equals(this.f17419h)) {
                this.f17414c.b();
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.S();
    }

    public void O() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (frsHeaderViewContainer = this.f17413b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f17413b.postDelayed(this.r, 100L);
    }

    public void P(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) || frsViewData == null || this.f17414c == null || !x()) {
            return;
        }
        this.f17414c.u(u(frsViewData.getForum()));
    }

    public void Q() {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.f17414c) == null) {
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
        c.a.t0.w3.e i2 = c.a.t0.w3.e.i();
        c.a.t0.w3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.t0.d1.c3.b bVar = this.f17414c;
            if (bVar != null) {
                this.f17413b.removeHeaderView(bVar.k());
                this.f17413b.removeHeaderView(this.f17414c.g());
                T();
            }
            this.f17416e = false;
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
                c.a.t0.d1.c3.b bVar = this.f17414c;
                if (bVar != null) {
                    this.f17413b.removeHeaderView(bVar.g());
                    this.f17416e = false;
                    return;
                }
                return;
            }
            c.a.t0.d1.c3.b bVar2 = this.f17414c;
            if (bVar2 == null || bVar2.g() == null || this.f17416e) {
                return;
            }
            this.f17413b.addHeaderView(this.f17414c.g(), this.f17413b.getHeaderViewsCount());
            this.f17416e = true;
        }
    }

    public void V(int i2) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bVar = this.f17414c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f17414c.g().findViewById(f1.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f17414c.m();
    }

    public void W(int i2) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void X(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f17414c.E(i2, forumData.getLevelName(), forumData.getUser_level(), u(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f17414c.a(false);
    }

    public void Y(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, frsViewData, z) == null) && frsViewData != null && x()) {
            X(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void Z(int i2) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && x() && (bVar = this.f17414c) != null) {
            bVar.F(i2);
        }
    }

    public void a0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && x() && (gVar = this.n) != null) {
            gVar.t(this.f17414c, frsViewData);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && x()) {
            W(0);
        }
    }

    public void c0(int i2) {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 > 1) {
                c.a.t0.d1.c3.b bVar = this.f17414c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            c.a.t0.d1.c3.b bVar2 = this.f17414c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f17420i = i2;
        }
    }

    public void f0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void g0() {
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.f17414c) == null) {
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && x() && (bVar = this.f17414c) != null) {
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
        c.a.t0.d1.c3.b bVar = this.f17414c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f17414c.d());
        } else {
            gVar.v(false, "");
        }
        c.a.t0.d1.c3.b bVar2 = this.f17414c;
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f17416e || (bVar = this.f17414c) == null) {
            return;
        }
        this.f17413b.addHeaderView(bVar.g());
        this.f17416e = true;
    }

    public final void q(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f17419h, str);
            this.f17422k = i3;
            this.f17419h = str;
            S();
            if (this.f17414c == null || z) {
                c.a.t0.d1.c3.b e2 = this.f17415d.e(str, this.a, i2);
                this.f17414c = e2;
                e2.c(this.f17418g);
                this.f17414c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f17414c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f17414c.I(fVar);
            }
            this.f17413b.addHeaderView(this.f17414c.k());
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!x() || (bVar = this.f17414c) == null) {
                return false;
            }
            return bVar.l();
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!x() || (bVar = this.f17414c) == null) {
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.f17414c) == null) {
            return;
        }
        bVar.m();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? FrsFragment.STAR_FRS.equals(this.f17419h) || FrsFragment.NORMAL_FRS.equals(this.f17419h) || FrsFragment.BOOK_FRS.equals(this.f17419h) || FrsFragment.BRAND_FRS.equals(this.f17419h) : invokeV.booleanValue;
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
        c.a.t0.d1.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!x() || (bVar = this.f17414c) == null) {
                return false;
            }
            return bVar.o();
        }
        return invokeV.booleanValue;
    }
}
