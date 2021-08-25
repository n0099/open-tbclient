package c.a.q0.v0.n2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.v0.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class h extends c.a.e.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26767a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f26768b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.v0.q2.b f26769c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.v0.m1.e.a f26770d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26771e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f26772f;

    /* renamed from: g  reason: collision with root package name */
    public int f26773g;

    /* renamed from: h  reason: collision with root package name */
    public String f26774h;

    /* renamed from: i  reason: collision with root package name */
    public int f26775i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26776j;
    public int k;
    public c.a.q0.i0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26777e;

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
            this.f26777e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q frsView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f26777e.f26767a != null && this.f26777e.f26775i == 0 && (frsView = this.f26777e.f26767a.getFrsView()) != null && frsView.Y() != null && !frsView.Y().o() && !frsView.a0() && this.f26777e.f26768b.isShown() && this.f26777e.f26767a.isPrimary() && !this.f26777e.f26776j && this.f26777e.f26767a.canShowSpeedTipView() && this.f26777e.k == 1 && this.f26777e.x() && this.f26777e.f26769c != null && this.f26777e.f26769c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f26777e.q0();
                this.f26777e.f26767a.mSpeedUpTipShowing = true;
                this.f26777e.f26776j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26778e;

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
            this.f26778e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26778e.f26767a == null || this.f26778e.f26775i != 0 || this.f26778e.f26767a.getFrsView().a0() || !this.f26778e.f26768b.isShown() || !this.f26778e.f26767a.isPrimary() || this.f26778e.f26767a.getActivity() == null || this.f26778e.f26767a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f26778e.f26767a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f26778e.n0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26779e;

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
            this.f26779e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof c.a.e.f.a.i) {
                ((c.a.e.f.a.i) view).refresh();
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f26779e.f26768b == null) {
                return;
            }
            int childCount = this.f26779e.f26768b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f26779e.f26768b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f26780e;

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
            this.f26780e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26780e.f26767a == null) {
                return;
            }
            FrsViewData frsViewData = this.f26780e.f26767a.getFrsViewData();
            if (frsViewData != null && frsViewData.getForum() != null && this.f26780e.f26769c != null && (view == this.f26780e.f26769c.e() || view == this.f26780e.f26769c.f() || view == this.f26780e.f26769c.i())) {
                if (this.f26780e.f26767a != null && frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", frsViewData.getForum().getId()).param("obj_locate", this.f26780e.f26767a.isFromMainTab() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
                    for (int i2 = 0; i2 < frsViewData.getEntelechyTabInfo().tab.size(); i2++) {
                        arrayList.add(frsViewData.getEntelechyTabInfo().tab.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f26780e.getPageContext().getPageActivity(), frsViewData.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (this.f26780e.f26767a.getIsRefresh()) {
                    return;
                }
                if (!c.a.e.e.p.j.z()) {
                    this.f26780e.f26767a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f26780e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f26780e.f26767a.getForumId()));
                } else {
                    this.f26780e.s0(true);
                    if (c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f26780e.f26767a.getForumId());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (this.f26780e.f26767a.getIsRefresh()) {
                    return;
                }
                if (!c.a.e.e.p.j.z()) {
                    this.f26780e.f26767a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f26780e.mContext.getPageActivity())) {
                    if (!this.f26780e.t()) {
                        this.f26780e.t0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f26780e.f26767a.getPageContext().getPageActivity(), c.a.e.e.m.b.d(this.f26780e.f26767a.getForumId(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f26780e.mContext.getPageActivity()) || frsViewData == null || frsViewData.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f26780e.getPageContext(), new String[]{frsViewData.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (frsViewData == null || frsViewData.getUserData() == null || !frsViewData.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = frsViewData.getBawuCenterUrl();
                if (c.a.e.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                c.a.p0.m.a.m(this.f26780e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", frsViewData.getForum().getId()).param("uid", frsViewData.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (this.f26780e.f26767a.getIsRefresh() || this.f26780e.f26775i != 0 || !this.f26780e.x() || this.f26780e.f26769c == null) {
                    return;
                }
                this.f26780e.f26769c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f26780e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.e.e.m.b.f(frsViewData.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", frsViewData.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f26780e.getPageContext().getPageActivity(), String.valueOf(frsViewData.getForum().getId()), frsViewData.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f26780e.mContext.getPageActivity()) && frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f26780e.f26767a.getTbPageContext();
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + frsViewData.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, c.a.q0.v0.m1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26771e = false;
        this.f26773g = 0;
        this.f26774h = FrsFragment.NORMAL_FRS;
        this.f26775i = 0;
        this.f26776j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.f26767a = frsFragment;
        this.f26770d = aVar;
        this.f26768b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f26772f = gen;
        this.n = new g(this.f26767a, gen);
        this.o = new f(this.f26767a);
        this.l = new c.a.q0.i0.a();
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
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().d() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
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
            this.f26776j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.v0.q2.b bVar = this.f26769c;
            if (bVar != null) {
                bVar.r();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.k();
            }
            if (this.p != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.q);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.v0.q2.b bVar = this.f26769c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f26768b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f26773g = i2;
            c.a.q0.v0.q2.b bVar = this.f26769c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void N(boolean z) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void O(MotionEvent motionEvent) {
        c.a.q0.i0.a aVar;
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
            this.f26769c.w();
        }
    }

    public void R(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float u = u(forumData);
        c.a.q0.v0.q2.b bVar = this.f26769c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f26769c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), u, false);
        this.f26769c.G(forumData.getSignData());
    }

    public void S(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) && frsViewData != null && x()) {
            R(frsViewData.getForum(), frsViewData);
            if (FrsFragment.BRAND_FRS.equals(this.f26774h)) {
                this.f26769c.b();
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
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.S();
    }

    public void V() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (frsHeaderViewContainer = this.f26768b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f26768b.postDelayed(this.r, 100L);
    }

    public void W(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) || frsViewData == null || this.f26769c == null || !x()) {
            return;
        }
        this.f26769c.u(u(frsViewData.getForum()));
    }

    public void X() {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.x();
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || this.f26767a.getModelController() == null || this.f26767a.getModelController().T() == null) {
            return;
        }
        int B = this.f26767a.getModelController().T().B();
        int y = this.f26767a.getModelController().T().y();
        int x = this.f26767a.getModelController().T().x();
        c.a.q0.i3.e i2 = c.a.q0.i3.e.i();
        c.a.q0.i3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.q0.v0.q2.b bVar = this.f26769c;
            if (bVar != null) {
                this.f26768b.removeHeaderView(bVar.k());
                this.f26768b.removeHeaderView(this.f26769c.g());
                a0();
            }
            this.f26771e = false;
        }
    }

    public final void a0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.m == null || (frsFragment = this.f26767a) == null || frsFragment.getListView() == null) {
            return;
        }
        this.f26767a.getListView().removeHeaderView(this.m.F());
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                c.a.q0.v0.q2.b bVar = this.f26769c;
                if (bVar != null) {
                    this.f26768b.removeHeaderView(bVar.g());
                    this.f26771e = false;
                    return;
                }
                return;
            }
            c.a.q0.v0.q2.b bVar2 = this.f26769c;
            if (bVar2 == null || bVar2.g() == null || this.f26771e) {
                return;
            }
            this.f26768b.addHeaderView(this.f26769c.g(), this.f26768b.getHeaderViewsCount());
            this.f26771e = true;
        }
    }

    public void c0(int i2) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (bVar = this.f26769c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f26769c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f26769c.m();
    }

    public void d0(int i2) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void e0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f26769c.E(i2, forumData.getLevelName(), forumData.getUser_level(), u(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f26769c.a(false);
    }

    public void f0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, frsViewData, z) == null) && frsViewData != null && x()) {
            e0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void g0(int i2) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && x() && (bVar = this.f26769c) != null) {
            bVar.F(i2);
        }
    }

    public void h0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && x() && (gVar = this.n) != null) {
            gVar.t(this.f26769c, frsViewData);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && x()) {
            d0(0);
        }
    }

    public void j0(int i2) {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 > 1) {
                c.a.q0.v0.q2.b bVar = this.f26769c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            c.a.q0.v0.q2.b bVar2 = this.f26769c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f26775i = i2;
        }
    }

    public void m0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void n0() {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.N();
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public void p() {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.f26771e || (bVar = this.f26769c) == null) {
            return;
        }
        this.f26768b.addHeaderView(bVar.g());
        this.f26771e = true;
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
            boolean z = !TextUtils.equals(this.f26774h, str);
            this.k = i3;
            this.f26774h = str;
            Z();
            if (this.f26769c == null || z) {
                c.a.q0.v0.q2.b e2 = this.f26770d.e(str, this.f26767a, i2);
                this.f26769c = e2;
                e2.c(this.f26773g);
                this.f26769c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f26769c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f26769c.I(fVar);
            }
            this.f26768b.addHeaderView(this.f26769c.k());
            r(str);
            r0();
            o0();
        }
    }

    public final void q0() {
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && x() && (bVar = this.f26769c) != null) {
            bVar.O();
        }
    }

    public final void r(String str) {
        FrsFragment frsFragment;
        RelativeLayout F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || this.m == null || (frsFragment = this.f26767a) == null || frsFragment.getListView() == null || (F = this.m.F()) == null) {
            return;
        }
        if (FrsFragment.BRAND_FRS.equals(str)) {
            this.f26767a.getListView().removeHeaderView(F);
            return;
        }
        this.f26767a.getListView().removeHeaderView(F);
        this.f26767a.getListView().addHeaderView(F, 0);
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.p, 4000L);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (!x() || (bVar = this.f26769c) == null) {
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
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!x() || (bVar = this.f26769c) == null) {
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
        c.a.q0.v0.q2.b bVar = this.f26769c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f26769c.d());
        } else {
            gVar.v(false, "");
        }
        c.a.q0.v0.q2.b bVar2 = this.f26769c;
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
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.f26769c) == null) {
            return;
        }
        bVar.m();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? FrsFragment.STAR_FRS.equals(this.f26774h) || FrsFragment.NORMAL_FRS.equals(this.f26774h) || FrsFragment.BOOK_FRS.equals(this.f26774h) || FrsFragment.BRAND_FRS.equals(this.f26774h) : invokeV.booleanValue;
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
        c.a.q0.v0.q2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!x() || (bVar = this.f26769c) == null) {
                return false;
            }
            return bVar.o();
        }
        return invokeV.booleanValue;
    }
}
