package b.a.r0.x0.z2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
import b.a.r0.x0.q;
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
/* loaded from: classes6.dex */
public class h extends b.a.e.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f28484a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f28485b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.x0.c3.b f28486c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x0.y1.e.a f28487d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28488e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f28489f;

    /* renamed from: g  reason: collision with root package name */
    public int f28490g;

    /* renamed from: h  reason: collision with root package name */
    public String f28491h;

    /* renamed from: i  reason: collision with root package name */
    public int f28492i;
    public boolean j;
    public int k;
    public b.a.r0.k0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28493e;

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
            this.f28493e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q frsView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f28493e.f28484a != null && this.f28493e.f28492i == 0 && (frsView = this.f28493e.f28484a.getFrsView()) != null && frsView.X() != null && !frsView.X().o() && !frsView.Z() && this.f28493e.f28485b.isShown() && this.f28493e.f28484a.isPrimary() && !this.f28493e.j && this.f28493e.f28484a.canShowSpeedTipView() && this.f28493e.k == 1 && this.f28493e.x() && this.f28493e.f28486c != null && this.f28493e.f28486c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f28493e.q0();
                this.f28493e.f28484a.mSpeedUpTipShowing = true;
                this.f28493e.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28494e;

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
            this.f28494e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28494e.f28484a == null || this.f28494e.f28492i != 0 || this.f28494e.f28484a.getFrsView().Z() || !this.f28494e.f28485b.isShown() || !this.f28494e.f28484a.isPrimary() || this.f28494e.f28484a.getActivity() == null || this.f28494e.f28484a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f28494e.f28484a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f28494e.n0();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28495e;

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
            this.f28495e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof b.a.e.g.a.h) {
                ((b.a.e.g.a.h) view).refresh();
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28495e.f28485b == null) {
                return;
            }
            int childCount = this.f28495e.f28485b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f28495e.f28485b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28496e;

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
            this.f28496e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f28496e.f28484a == null) {
                return;
            }
            FrsViewData frsViewData = this.f28496e.f28484a.getFrsViewData();
            if (frsViewData != null && frsViewData.getForum() != null && this.f28496e.f28486c != null && (view == this.f28496e.f28486c.e() || view == this.f28496e.f28486c.f() || view == this.f28496e.f28486c.i())) {
                if (this.f28496e.f28484a != null && frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", frsViewData.getForum().getId()).param("obj_locate", this.f28496e.f28484a.isFromMainTab() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().f22587a != null) {
                    for (int i2 = 0; i2 < frsViewData.getEntelechyTabInfo().f22587a.size(); i2++) {
                        arrayList.add(frsViewData.getEntelechyTabInfo().f22587a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f28496e.getPageContext().getPageActivity(), frsViewData.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == f1.tv_love) {
                if (this.f28496e.f28484a.getIsRefresh()) {
                    return;
                }
                if (!b.a.e.f.p.j.z()) {
                    this.f28496e.f28484a.showToast(i1.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f28496e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f28496e.f28484a.getForumId()));
                } else {
                    this.f28496e.s0(true);
                    if (b.a.e.f.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f28496e.f28484a.getForumId());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == f1.tv_sign) {
                if (this.f28496e.f28484a.getIsRefresh()) {
                    return;
                }
                if (!b.a.e.f.p.j.z()) {
                    this.f28496e.f28484a.showToast(i1.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f28496e.mContext.getPageActivity())) {
                    if (!this.f28496e.t()) {
                        this.f28496e.t0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f28496e.f28484a.getPageContext().getPageActivity(), b.a.e.f.m.b.e(this.f28496e.f28484a.getForumId(), 0), 24002)));
                    }
                }
            } else if (id == f1.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f28496e.mContext.getPageActivity()) || frsViewData == null || frsViewData.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f28496e.getPageContext(), new String[]{frsViewData.getGameUrl()}, true);
            } else if (id == f1.frs_bawu_center) {
                if (frsViewData == null || frsViewData.getUserData() == null || !frsViewData.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = frsViewData.getBawuCenterUrl();
                if (b.a.e.f.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                b.a.q0.m.a.m(this.f28496e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", frsViewData.getForum().getId()).param("uid", frsViewData.getUserData().getUserId()));
                }
            } else if (id == f1.level_container) {
                if (this.f28496e.f28484a.getIsRefresh() || this.f28496e.f28492i != 0 || !this.f28496e.x() || this.f28496e.f28486c == null) {
                    return;
                }
                this.f28496e.f28486c.M(view, false);
            } else if (id == f1.frs_hot_rank_entry) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f28496e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(b.a.e.f.m.b.g(frsViewData.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", frsViewData.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == f1.frs_manager_info_layout) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f28496e.getPageContext().getPageActivity(), String.valueOf(frsViewData.getForum().getId()), frsViewData.getForum().getName())));
            } else if (id == f1.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f28496e.mContext.getPageActivity()) && frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f28496e.f28484a.getTbPageContext();
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + frsViewData.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, b.a.r0.x0.y1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28488e = false;
        this.f28490g = 0;
        this.f28491h = FrsFragment.NORMAL_FRS;
        this.f28492i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.f28484a = frsFragment;
        this.f28487d = aVar;
        this.f28485b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f28489f = gen;
        this.n = new g(this.f28484a, gen);
        this.o = new f(this.f28484a);
        this.l = new b.a.r0.k0.a();
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

    public void D(Bundle bundle) {
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
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.x0.c3.b bVar = this.f28486c;
            if (bVar != null) {
                bVar.r();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.k();
            }
            if (this.p != null) {
                b.a.e.f.m.e.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                b.a.e.f.m.e.a().removeCallbacks(this.q);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.x0.c3.b bVar = this.f28486c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f28485b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f28490g = i2;
            b.a.r0.x0.c3.b bVar = this.f28486c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void N(boolean z) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void O(MotionEvent motionEvent) {
        b.a.r0.k0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.c(motionEvent);
    }

    public void P(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
            j0(num.intValue());
            if (x()) {
                U();
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28486c.w();
        }
    }

    public void R(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float u = u(forumData);
        b.a.r0.x0.c3.b bVar = this.f28486c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f28486c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), u, false);
        this.f28486c.G(forumData.getSignData());
    }

    public void S(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) && frsViewData != null && x()) {
            R(frsViewData.getForum(), frsViewData);
            if (FrsFragment.BRAND_FRS.equals(this.f28491h)) {
                this.f28486c.b();
            }
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && x()) {
            d0(i2);
        }
    }

    public void U() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.S();
    }

    public void V() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (frsHeaderViewContainer = this.f28485b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f28485b.postDelayed(this.r, 100L);
    }

    public void W(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) || frsViewData == null || this.f28486c == null || !x()) {
            return;
        }
        this.f28486c.u(u(frsViewData.getForum()));
    }

    public void X() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.x();
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || this.f28484a.getModelController() == null || this.f28484a.getModelController().T() == null) {
            return;
        }
        int B = this.f28484a.getModelController().T().B();
        int y = this.f28484a.getModelController().T().y();
        int x = this.f28484a.getModelController().T().x();
        b.a.r0.m3.e i2 = b.a.r0.m3.e.i();
        b.a.r0.m3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.r0.x0.c3.b bVar = this.f28486c;
            if (bVar != null) {
                this.f28485b.removeHeaderView(bVar.k());
                this.f28485b.removeHeaderView(this.f28486c.g());
                a0();
            }
            this.f28488e = false;
        }
    }

    public final void a0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.m == null || (frsFragment = this.f28484a) == null || frsFragment.getListView() == null) {
            return;
        }
        this.f28484a.getListView().removeHeaderView(this.m.F());
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                b.a.r0.x0.c3.b bVar = this.f28486c;
                if (bVar != null) {
                    this.f28485b.removeHeaderView(bVar.g());
                    this.f28488e = false;
                    return;
                }
                return;
            }
            b.a.r0.x0.c3.b bVar2 = this.f28486c;
            if (bVar2 == null || bVar2.g() == null || this.f28488e) {
                return;
            }
            this.f28485b.addHeaderView(this.f28486c.g(), this.f28485b.getHeaderViewsCount());
            this.f28488e = true;
        }
    }

    public void c0(int i2) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bVar = this.f28486c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f28486c.g().findViewById(f1.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f28486c.m();
    }

    public void d0(int i2) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void e0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f28486c.E(i2, forumData.getLevelName(), forumData.getUser_level(), u(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f28486c.a(false);
    }

    public void f0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, frsViewData, z) == null) && frsViewData != null && x()) {
            e0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void g0(int i2) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && x() && (bVar = this.f28486c) != null) {
            bVar.F(i2);
        }
    }

    public void h0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && x() && (gVar = this.n) != null) {
            gVar.t(this.f28486c, frsViewData);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && x()) {
            d0(0);
        }
    }

    public void j0(int i2) {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 > 1) {
                b.a.r0.x0.c3.b bVar = this.f28486c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            b.a.r0.x0.c3.b bVar2 = this.f28486c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f28492i = i2;
        }
    }

    public void m0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void n0() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.N();
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            b.a.e.f.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public void p() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.f28488e || (bVar = this.f28486c) == null) {
            return;
        }
        this.f28485b.addHeaderView(bVar.g());
        this.f28488e = true;
    }

    public void p0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        q(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void q(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048610, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f28491h, str);
            this.k = i3;
            this.f28491h = str;
            Z();
            if (this.f28486c == null || z) {
                b.a.r0.x0.c3.b e2 = this.f28487d.e(str, this.f28484a, i2);
                this.f28486c = e2;
                e2.c(this.f28490g);
                this.f28486c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f28486c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f28486c.I(fVar);
            }
            this.f28485b.addHeaderView(this.f28486c.k());
            r(str);
            r0();
            o0();
        }
    }

    public final void q0() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && x() && (bVar = this.f28486c) != null) {
            bVar.O();
        }
    }

    public final void r(String str) {
        FrsFragment frsFragment;
        RelativeLayout F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || this.m == null || (frsFragment = this.f28484a) == null || frsFragment.getListView() == null || (F = this.m.F()) == null) {
            return;
        }
        if (FrsFragment.BRAND_FRS.equals(str)) {
            this.f28484a.getListView().removeHeaderView(F);
            return;
        }
        this.f28484a.getListView().removeHeaderView(F);
        this.f28484a.getListView().addHeaderView(F, 0);
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            b.a.e.f.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (!x() || (bVar = this.f28486c) == null) {
                return false;
            }
            return bVar.l();
        }
        return invokeV.booleanValue;
    }

    public void s0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.o(z);
    }

    public boolean t() {
        InterceptResult invokeV;
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!x() || (bVar = this.f28486c) == null) {
                return false;
            }
            return bVar.h();
        }
        return invokeV.booleanValue;
    }

    public void t0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (gVar = this.n) == null) {
            return;
        }
        b.a.r0.x0.c3.b bVar = this.f28486c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f28486c.d());
        } else {
            gVar.v(false, "");
        }
        b.a.r0.x0.c3.b bVar2 = this.f28486c;
        if (bVar2 != null) {
            this.n.u(bVar2.j());
        }
    }

    public final float u(ForumData forumData) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void u0() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.p();
    }

    public f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public void v0(int i2, int i3, int i4) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048621, this, i2, i3, i4) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.w(i2, i3, i4);
    }

    public void w() {
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.f28486c) == null) {
            return;
        }
        bVar.m();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? FrsFragment.STAR_FRS.equals(this.f28491h) || FrsFragment.NORMAL_FRS.equals(this.f28491h) || FrsFragment.BOOK_FRS.equals(this.f28491h) || FrsFragment.BRAND_FRS.equals(this.f28491h) : invokeV.booleanValue;
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
        b.a.r0.x0.c3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!x() || (bVar = this.f28486c) == null) {
                return false;
            }
            return bVar.o();
        }
        return invokeV.booleanValue;
    }
}
