package c.a.p0.f1.s2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.q;
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
import com.baidu.tieba.R;
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
import java.util.List;
/* loaded from: classes2.dex */
public class h extends c.a.d.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f14605b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.v2.d f14606c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.p1.e.a f14607d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14608e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f14609f;

    /* renamed from: g  reason: collision with root package name */
    public int f14610g;

    /* renamed from: h  reason: collision with root package name */
    public String f14611h;
    public int i;
    public boolean j;
    public int k;
    public c.a.p0.s0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q x0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (x0 = this.a.a.x0()) != null && x0.Y() != null && !x0.Y().o() && !x0.a0() && this.a.f14605b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.j2() && this.a.k == 1 && this.a.B() && this.a.f14606c != null && this.a.f14606c.u()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.r0();
                this.a.a.f32261c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.x0().a0() || !this.a.f14605b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.m0();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
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
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f14605b == null) {
                return;
            }
            int childCount = this.a.f14605b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(this.a.f14605b.getChildAt(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view.getTag(R.id.obfuscated_res_0x7f090659);
            FrsViewData f0 = this.a.a.f0();
            if (f0 != null && f0.getForum() != null && this.a.f14606c != null && (view == this.a.f14606c.g() || view == this.a.f14606c.h() || view == this.a.f14606c.k() || logicField == LogicField.INFO_AREA)) {
                if (this.a.a != null && f0.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", f0.getForum().getId()).param("fname", f0.getForum().getName()).param("obj_locate", this.a.a.V2() ? 1 : 2);
                    c.a.p0.f1.l2.a.a(param);
                    TiebaStatic.log(param);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (f0.getEntelechyTabInfo() != null && f0.getEntelechyTabInfo().a != null) {
                    for (int i = 0; i < f0.getEntelechyTabInfo().a.size(); i++) {
                        arrayList.add(f0.getEntelechyTabInfo().a.get(i).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), f0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(f0.serviceAreaFlutterData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f0921ce || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.D2()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.c()));
                } else {
                    Object tag = view.getTag(R.id.obfuscated_res_0x7f090fa7);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        c.a.p0.f1.l2.a.d(this.a.a.c(), this.a.a.a());
                    }
                    this.a.t0(true);
                    if (c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.a.a.c());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.obfuscated_res_0x7f092208 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.D2()) {
                    return;
                }
                if (!c.a.d.f.p.l.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.w()) {
                        this.a.u0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), c.a.d.f.m.b.e(this.a.a.c(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b2a) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || f0 == null || f0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{f0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090ac9) {
                if (f0 == null || f0.getUserData() == null || !f0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = f0.getBawuCenterUrl();
                if (c.a.d.f.p.m.isEmpty(bawuCenterUrl)) {
                    return;
                }
                c.a.o0.l.a.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (f0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", f0.getForum().getId()).param("uid", f0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f091232 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.D2() || this.a.i != 0 || !this.a.B() || this.a.f14606c == null) {
                    return;
                }
                this.a.f14606c.T(view, false);
            } else if (id == R.id.obfuscated_res_0x7f090b35) {
                if (f0 == null || f0.getForum() == null || TextUtils.isEmpty(f0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(c.a.d.f.m.b.g(f0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", f0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090b83) {
                if (id != R.id.obfuscated_res_0x7f090b82 || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || f0 == null || f0.getForum() == null || TextUtils.isEmpty(f0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> j = this.a.a.j();
                urlManager.dealOneLink(j, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + f0.getForum().getId()});
            } else if (f0 != null && f0.getForum() != null && !TextUtils.isEmpty(f0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(f0.getForum().getId()), f0.getForum().getName())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, c.a.p0.f1.p1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, aVar, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14608e = false;
        this.f14610g = 0;
        this.f14611h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.f14607d = aVar;
        this.f14605b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f14609f = gen;
        this.n = new g(this.a, gen);
        this.o = new f(this.a);
        this.l = new c.a.p0.s0.a();
    }

    public static boolean E(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean F(FrsViewData frsViewData) {
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

    public void A() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.q();
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "frs_page".equals(this.f14611h) || "normal_page".equals(this.f14611h) || "book_page".equals(this.f14611h) || "brand_page".equals(this.f14611h) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!B() || (dVar = this.f14606c) == null) {
                return false;
            }
            return dVar.s();
        }
        return invokeV.booleanValue;
    }

    public void G(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.f1.v2.d dVar = this.f14606c;
            if (dVar != null) {
                dVar.x();
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.f1.v2.d dVar = this.f14606c;
            if (dVar != null) {
                dVar.A();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f14605b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.f14610g = i;
            c.a.p0.f1.v2.d dVar = this.f14606c;
            if (dVar != null) {
                dVar.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void L(boolean z) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.z(z);
    }

    public void M(MotionEvent motionEvent) {
        c.a.p0.s0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, motionEvent) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.c(motionEvent);
    }

    public void N(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, num) == null) {
            i0(num.intValue());
            if (B()) {
                T();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f14606c.D();
        }
    }

    public void P(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float x = x(forumData);
        c.a.p0.f1.v2.d dVar = this.f14606c;
        if (dVar == null) {
            return;
        }
        dVar.I(forumData, frsViewData);
        this.f14606c.L(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), x, false);
        this.f14606c.N(forumData.getSignData());
    }

    public void Q(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && frsViewData != null && B()) {
            P(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f14611h)) {
                this.f14606c.c();
            }
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && B()) {
            c0(i);
        }
    }

    public void T() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.a0();
    }

    public void U() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsHeaderViewContainer = this.f14605b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f14605b.postDelayed(this.r, 100L);
    }

    public void V(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, frsViewData) == null) || frsViewData == null || this.f14606c == null || !B()) {
            return;
        }
        this.f14606c.B(x(frsViewData.getForum()));
    }

    public void W() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.E();
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || this.a.b0() == null || this.a.b0().V() == null) {
            return;
        }
        int D = this.a.b0().V().D();
        int A = this.a.b0().V().A();
        int z = this.a.b0().V().z();
        c.a.p0.a4.e i = c.a.p0.a4.e.i();
        c.a.p0.a4.e.i().n(i.g("1~" + str, D, A, z), false);
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.p0.f1.v2.d dVar = this.f14606c;
            if (dVar != null) {
                this.f14605b.d(dVar.m());
                this.f14605b.d(this.f14606c.i());
                Z();
            }
            this.f14608e = false;
        }
    }

    public final void Z() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.E2() == null) {
            return;
        }
        this.a.E2().removeHeaderView(this.m.G());
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                c.a.p0.f1.v2.d dVar = this.f14606c;
                if (dVar != null) {
                    this.f14605b.d(dVar.i());
                    this.f14608e = false;
                    return;
                }
                return;
            }
            c.a.p0.f1.v2.d dVar2 = this.f14606c;
            if (dVar2 == null || dVar2.i() == null || this.f14608e) {
                return;
            }
            this.f14605b.b(this.f14606c.i(), this.f14605b.getHeaderViewsCount());
            this.f14608e = true;
        }
    }

    public void b0(int i) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (dVar = this.f14606c) == null || dVar.i() == null) {
            return;
        }
        View findViewById = this.f14606c.i().findViewById(R.id.obfuscated_res_0x7f0907eb);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.f14606c.o();
    }

    public void c0(int i) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.K(i);
    }

    public void d0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.I(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f14606c.L(i, forumData.getLevelName(), forumData.getUser_level(), x(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f14606c.b(false);
    }

    public void e0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048602, this, frsViewData, z) == null) && frsViewData != null && B()) {
            d0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void f0(int i) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && B() && (dVar = this.f14606c) != null) {
            dVar.M(i);
        }
    }

    public void g0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, frsViewData) == null) && B() && (gVar = this.n) != null) {
            gVar.t(this.f14606c, frsViewData);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && B()) {
            c0(0);
        }
    }

    public void i0(int i) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.Q(i);
    }

    public void j0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i > 1) {
                c.a.p0.f1.v2.d dVar = this.f14606c;
                if (dVar != null) {
                    dVar.O(false);
                    return;
                }
                return;
            }
            c.a.p0.f1.v2.d dVar2 = this.f14606c;
            if (dVar2 != null) {
                dVar2.O(true);
            }
        }
    }

    public void k0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.i = i;
        }
    }

    public void l0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void m0() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.U();
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public void o0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        s(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public void p0(List<c.a.p0.a4.m> list) {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, list) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.V(list);
        this.f14606c.a();
    }

    public void r() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.f14608e || (dVar = this.f14606c) == null) {
            return;
        }
        this.f14605b.a(dVar.i());
        this.f14608e = true;
    }

    public final void r0() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && B() && (dVar = this.f14606c) != null) {
            dVar.W();
        }
    }

    public final void s(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.f14611h, str);
            this.k = i2;
            this.f14611h = str;
            Y();
            if (this.f14606c == null || z) {
                c.a.p0.f1.v2.d e2 = this.f14607d.e(str, this.a, i);
                this.f14606c = e2;
                e2.d(this.f14610g);
                this.f14606c.H(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f14606c.R(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f14606c.P(fVar);
            }
            this.f14605b.a(this.f14606c.m());
            t(str);
            s0();
            n0();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.E2() == null || (G = this.m.G()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.E2().removeHeaderView(G);
            return;
        }
        this.a.E2().removeHeaderView(G);
        this.a.E2().t(G, 0);
    }

    public void t0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        c.a.p0.f1.v2.d dVar = this.f14606c;
        fVar.m(dVar != null && dVar.r());
        this.o.p(z);
    }

    public void u() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.a();
    }

    public void u0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (gVar = this.n) == null) {
            return;
        }
        c.a.p0.f1.v2.d dVar = this.f14606c;
        if (dVar != null) {
            gVar.v(dVar.t(), this.f14606c.f());
        } else {
            gVar.v(false, "");
        }
        c.a.p0.f1.v2.d dVar2 = this.f14606c;
        if (dVar2 != null) {
            this.n.u(dVar2.l());
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (!B() || (dVar = this.f14606c) == null) {
                return false;
            }
            return dVar.n();
        }
        return invokeV.booleanValue;
    }

    public void v0() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.q();
    }

    public boolean w() {
        InterceptResult invokeV;
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (!B() || (dVar = this.f14606c) == null) {
                return false;
            }
            return dVar.j();
        }
        return invokeV.booleanValue;
    }

    public void w0(int i, int i2, int i3) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048625, this, i, i2, i3) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.w(i, i2, i3);
    }

    public final float x(ForumData forumData) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public f y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public void z() {
        c.a.p0.f1.v2.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (dVar = this.f14606c) == null) {
            return;
        }
        dVar.o();
    }
}
