package c.a.u0.e1.c3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import c.a.u0.e1.q;
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
import com.baidu.tieba.frs.shrinkhead.LogicField;
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
    public FrsHeaderViewContainer f16338b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.e1.f3.b f16339c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.e1.z1.e.a f16340d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16341e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f16342f;

    /* renamed from: g  reason: collision with root package name */
    public int f16343g;

    /* renamed from: h  reason: collision with root package name */
    public String f16344h;

    /* renamed from: i  reason: collision with root package name */
    public int f16345i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16346j;
    public int k;
    public c.a.u0.r0.a l;
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
        public final /* synthetic */ h f16347e;

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
            this.f16347e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q frsView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16347e.a != null && this.f16347e.f16345i == 0 && (frsView = this.f16347e.a.getFrsView()) != null && frsView.Y() != null && !frsView.Y().o() && !frsView.a0() && this.f16347e.f16338b.isShown() && this.f16347e.a.isPrimary() && !this.f16347e.f16346j && this.f16347e.a.canShowSpeedTipView() && this.f16347e.k == 1 && this.f16347e.y() && this.f16347e.f16339c != null && this.f16347e.f16339c.s()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f16347e.k0();
                this.f16347e.a.mSpeedUpTipShowing = true;
                this.f16347e.f16346j = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16348e;

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
            this.f16348e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16348e.a == null || this.f16348e.f16345i != 0 || this.f16348e.a.getFrsView().a0() || !this.f16348e.f16338b.isShown() || !this.f16348e.a.isPrimary() || this.f16348e.a.getActivity() == null || this.f16348e.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f16348e.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f16348e.h0();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16349e;

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
            this.f16349e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof c.a.d.h.a.h) {
                ((c.a.d.h.a.h) view).refresh();
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16349e.f16338b == null) {
                return;
            }
            int childCount = this.f16349e.f16338b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f16349e.f16338b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16350e;

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
            this.f16350e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16350e.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view.getTag(f1.click_view_tag);
            FrsViewData frsViewData = this.f16350e.a.getFrsViewData();
            if (frsViewData != null && frsViewData.getForum() != null && this.f16350e.f16339c != null && (view == this.f16350e.f16339c.f() || view == this.f16350e.f16339c.g() || view == this.f16350e.f16339c.j() || logicField == LogicField.INFO_AREA)) {
                if (this.f16350e.a != null && frsViewData.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", frsViewData.getForum().getId()).param("fname", frsViewData.getForum().getName()).param("obj_locate", this.f16350e.a.isFromMainTab() ? 1 : 2);
                    c.a.u0.e1.v2.a.a(param);
                    TiebaStatic.log(param);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < frsViewData.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(frsViewData.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f16350e.getPageContext().getPageActivity(), frsViewData.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(frsViewData.serviceAreaFlutterData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == f1.tv_love || logicField == LogicField.LIKE_BTN) {
                if (this.f16350e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f16350e.a.showToast(i1.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f16350e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f16350e.a.getForumId()));
                } else {
                    Object tag = view.getTag(f1.item_tag_data);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        c.a.u0.e1.v2.a.d(this.f16350e.a.getForumId(), this.f16350e.a.getForumName());
                    }
                    this.f16350e.m0(true);
                    if (c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f16350e.a.getForumId());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == f1.tv_sign || logicField == LogicField.SIGN_BTN) {
                if (this.f16350e.a.getIsRefresh()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.f16350e.a.showToast(i1.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f16350e.mContext.getPageActivity())) {
                    if (!this.f16350e.u()) {
                        this.f16350e.n0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f16350e.a.getPageContext().getPageActivity(), c.a.d.f.m.b.e(this.f16350e.a.getForumId(), 0), 24002)));
                    }
                }
            } else if (id == f1.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f16350e.mContext.getPageActivity()) || frsViewData == null || frsViewData.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f16350e.getPageContext(), new String[]{frsViewData.getGameUrl()}, true);
            } else if (id == f1.frs_bawu_center) {
                if (frsViewData == null || frsViewData.getUserData() == null || !frsViewData.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = frsViewData.getBawuCenterUrl();
                if (c.a.d.f.p.m.isEmpty(bawuCenterUrl)) {
                    return;
                }
                c.a.t0.m.a.m(this.f16350e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (frsViewData.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", frsViewData.getForum().getId()).param("uid", frsViewData.getUserData().getUserId()));
                }
            } else if (id == f1.level_container || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.f16350e.a.getIsRefresh() || this.f16350e.f16345i != 0 || !this.f16350e.y() || this.f16350e.f16339c == null) {
                    return;
                }
                this.f16350e.f16339c.P(view, false);
            } else if (id == f1.frs_hot_rank_entry) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f16350e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(frsViewData.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", frsViewData.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == f1.frs_manager_info_layout) {
                if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f16350e.getPageContext().getPageActivity(), String.valueOf(frsViewData.getForum().getId()), frsViewData.getForum().getName())));
            } else if (id == f1.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f16350e.mContext.getPageActivity()) && frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f16350e.a.getTbPageContext();
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + frsViewData.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, c.a.u0.e1.z1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
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
        this.f16341e = false;
        this.f16343g = 0;
        this.f16344h = FrsFragment.NORMAL_FRS;
        this.f16345i = 0;
        this.f16346j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.f16340d = aVar;
        this.f16338b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f16342f = gen;
        this.n = new g(this.a, gen);
        this.o = new f(this.a);
        this.l = new c.a.u0.r0.a();
    }

    public static boolean B(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean C(FrsViewData frsViewData) {
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

    public boolean A() {
        InterceptResult invokeV;
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!y() || (bVar = this.f16339c) == null) {
                return false;
            }
            return bVar.q();
        }
        return invokeV.booleanValue;
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            g gVar = this.n;
            if (gVar != null) {
                gVar.n();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.j();
            }
            this.f16346j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.u0.e1.f3.b bVar = this.f16339c;
            if (bVar != null) {
                bVar.t();
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

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.u0.e1.f3.b bVar = this.f16339c;
            if (bVar != null) {
                bVar.w();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f16338b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f16343g = i2;
            c.a.u0.e1.f3.b bVar = this.f16339c;
            if (bVar != null) {
                bVar.d(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void H(boolean z) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.v(z);
    }

    public void I(MotionEvent motionEvent) {
        c.a.u0.r0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, motionEvent) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.c(motionEvent);
    }

    public void J(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            d0(num.intValue());
            if (y()) {
                O();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16339c.z();
        }
    }

    public void L(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float v = v(forumData);
        c.a.u0.e1.f3.b bVar = this.f16339c;
        if (bVar == null) {
            return;
        }
        bVar.E(forumData, frsViewData);
        this.f16339c.H(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), v, false);
        this.f16339c.J(forumData.getSignData());
    }

    public void M(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, frsViewData) == null) && frsViewData != null && y()) {
            L(frsViewData.getForum(), frsViewData);
            if (FrsFragment.BRAND_FRS.equals(this.f16344h)) {
                this.f16339c.c();
            }
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && y()) {
            X(i2);
        }
    }

    public void O() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.V();
    }

    public void P() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (frsHeaderViewContainer = this.f16338b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f16338b.postDelayed(this.r, 100L);
    }

    public void Q(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || frsViewData == null || this.f16339c == null || !y()) {
            return;
        }
        this.f16339c.x(v(frsViewData.getForum()));
    }

    public void R() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.A();
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || this.a.getModelController() == null || this.a.getModelController().T() == null) {
            return;
        }
        int B = this.a.getModelController().T().B();
        int y = this.a.getModelController().T().y();
        int x = this.a.getModelController().T().x();
        c.a.u0.z3.e i2 = c.a.u0.z3.e.i();
        c.a.u0.z3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.u0.e1.f3.b bVar = this.f16339c;
            if (bVar != null) {
                this.f16338b.removeHeaderView(bVar.l());
                this.f16338b.removeHeaderView(this.f16339c.h());
                U();
            }
            this.f16341e = false;
        }
    }

    public final void U() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.getListView() == null) {
            return;
        }
        this.a.getListView().removeHeaderView(this.m.G());
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                c.a.u0.e1.f3.b bVar = this.f16339c;
                if (bVar != null) {
                    this.f16338b.removeHeaderView(bVar.h());
                    this.f16341e = false;
                    return;
                }
                return;
            }
            c.a.u0.e1.f3.b bVar2 = this.f16339c;
            if (bVar2 == null || bVar2.h() == null || this.f16341e) {
                return;
            }
            this.f16338b.addHeaderView(this.f16339c.h(), this.f16338b.getHeaderViewsCount());
            this.f16341e = true;
        }
    }

    public void W(int i2) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (bVar = this.f16339c) == null || bVar.h() == null) {
            return;
        }
        View findViewById = this.f16339c.h().findViewById(f1.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f16339c.n();
    }

    public void X(int i2) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.G(i2);
    }

    public void Y(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.E(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f16339c.H(i2, forumData.getLevelName(), forumData.getUser_level(), v(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f16339c.b(false);
    }

    public void Z(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048599, this, frsViewData, z) == null) && frsViewData != null && y()) {
            Y(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void a0(int i2) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && y() && (bVar = this.f16339c) != null) {
            bVar.I(i2);
        }
    }

    public void b0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) && y() && (gVar = this.n) != null) {
            gVar.t(this.f16339c, frsViewData);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && y()) {
            X(0);
        }
    }

    public void d0(int i2) {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.M(i2);
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 1) {
                c.a.u0.e1.f3.b bVar = this.f16339c;
                if (bVar != null) {
                    bVar.K(false);
                    return;
                }
                return;
            }
            c.a.u0.e1.f3.b bVar2 = this.f16339c;
            if (bVar2 != null) {
                bVar2.K(true);
            }
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.f16345i = i2;
        }
    }

    public void g0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void h0() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.Q();
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public void j0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        q(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void k0() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && y() && (bVar = this.f16339c) != null) {
            bVar.R();
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public void m0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        c.a.u0.e1.f3.b bVar = this.f16339c;
        fVar.m(bVar != null && bVar.p());
        this.o.p(z);
    }

    public void n0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (gVar = this.n) == null) {
            return;
        }
        c.a.u0.e1.f3.b bVar = this.f16339c;
        if (bVar != null) {
            gVar.v(bVar.r(), this.f16339c.e());
        } else {
            gVar.v(false, "");
        }
        c.a.u0.e1.f3.b bVar2 = this.f16339c;
        if (bVar2 != null) {
            this.n.u(bVar2.k());
        }
    }

    public void o0() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.q();
    }

    public void p() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f16341e || (bVar = this.f16339c) == null) {
            return;
        }
        this.f16338b.addHeaderView(bVar.h());
        this.f16341e = true;
    }

    public void p0(int i2, int i3, int i4) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048616, this, i2, i3, i4) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.w(i2, i3, i4);
    }

    public final void q(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f16344h, str);
            this.k = i3;
            this.f16344h = str;
            T();
            if (this.f16339c == null || z) {
                c.a.u0.e1.f3.b e2 = this.f16340d.e(str, this.a, i2);
                this.f16339c = e2;
                e2.d(this.f16343g);
                this.f16339c.D(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f16339c.N(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f16339c.L(fVar);
            }
            this.f16338b.addHeaderView(this.f16339c.l());
            r(str);
            l0();
            i0();
        }
    }

    public final void r(String str) {
        FrsFragment frsFragment;
        RelativeLayout G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.getListView() == null || (G = this.m.G()) == null) {
            return;
        }
        if (FrsFragment.BRAND_FRS.equals(str)) {
            this.a.getListView().removeHeaderView(G);
            return;
        }
        this.a.getListView().removeHeaderView(G);
        this.a.getListView().addHeaderView(G, 0);
    }

    public void s() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.a();
    }

    public boolean t() {
        InterceptResult invokeV;
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!y() || (bVar = this.f16339c) == null) {
                return false;
            }
            return bVar.m();
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!y() || (bVar = this.f16339c) == null) {
                return false;
            }
            return bVar.i();
        }
        return invokeV.booleanValue;
    }

    public final float v(ForumData forumData) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public f w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public void x() {
        c.a.u0.e1.f3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (bVar = this.f16339c) == null) {
            return;
        }
        bVar.n();
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? FrsFragment.STAR_FRS.equals(this.f16344h) || FrsFragment.NORMAL_FRS.equals(this.f16344h) || FrsFragment.BOOK_FRS.equals(this.f16344h) || FrsFragment.BRAND_FRS.equals(this.f16344h) : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
