package c.a.s0.y3;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.r0.s.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public Runnable B;
    public MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f26180b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26181c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26182d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26183e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f26184f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26185g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f26186h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.k0.j f26187i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.j4.e f26188j;

    /* renamed from: k  reason: collision with root package name */
    public MaintabBottomIndicator f26189k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public s r;
    public FragmentTabHost.a s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public final ItemCardHelper.c v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public Runnable z;

    /* loaded from: classes8.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: c.a.s0.y3.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1516a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f26190e;

            public RunnableC1516a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26190e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f26190e);
                }
            }
        }

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            c.a.r0.i0.c cVar = new c.a.r0.i0.c();
            cVar.f12655g = redIcon.image;
            cVar.f12653e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }

        public final void b(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (this.a.f26180b.getTabSpec(i2).a == 2) {
                    m = TbPageExtraHelper.l(this.a.a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                c.a.d.f.m.e.a().postDelayed(new RunnableC1516a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.a.f26180b.getTabSpec(i2).a;
                if (i3 == 8) {
                    TbPageExtraHelper.v("a011");
                } else if (i3 == 2) {
                    TbPageExtraHelper.v("a002");
                } else if (i3 == 3) {
                    TbPageExtraHelper.v("a079");
                } else if (i3 == 1) {
                    TbPageExtraHelper.v("a025");
                } else if (i3 == 21) {
                    TbPageExtraHelper.v("a075");
                } else if (i3 == 22) {
                    TbPageExtraHelper.v("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.b tabSpec = this.a.f26180b.getTabSpec(i2);
                if (tabSpec.a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.a.getPageContext(), null)) {
                    int i3 = tabSpec.a;
                    if (i3 == 9) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new c.a.r0.u.j(0)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                        return false;
                    } else if (i3 == 8 && !c.a.r0.b.d.H() && !ViewHelper.checkUpIsLogin(this.a.a.getActivity())) {
                        if (this.a.f26189k != null) {
                            this.a.f26189k.hideLottieView();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                        return false;
                    } else {
                        int i4 = tabSpec.a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.a.a.getActivity())) {
                                return false;
                            }
                            if (tabSpec.a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x01bd, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r10) != false) goto L48;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b tabSpec = this.a.f26180b.getTabSpec(i2);
                int i3 = tabSpec.a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.a.f26189k != null && this.a.f26189k.getAnimationView() != null && this.a.f26189k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.f26189k != null) {
                        this.a.f26189k.hideLottieView();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (tabSpec.a == 2) {
                    if (this.a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.a.o != 2 || this.a.m == i2 || homeBarShowType != 1 || this.a.l == null) {
                        if (this.a.o == 1 && this.a.l != null) {
                            this.a.l.playNormalAnimation(this.a.n);
                        }
                    } else {
                        this.a.l.playStaticAnimation();
                    }
                    this.a.p = false;
                } else {
                    this.a.p = true;
                    if (this.a.n && this.a.l != null) {
                        this.a.l.playNormalAnimation(this.a.n);
                    }
                    this.a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.a.x() != null) {
                    this.a.x().isSelectHome = this.a.n;
                }
                if (!this.a.n) {
                    c.a.s0.e1.a.i().r();
                }
                c(this.a.m);
                b(this.a.m);
                this.a.m = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (tabSpec.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = tabSpec.f41540b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("video_msg") != null && (maintabBottomIndicator.getTip("video_msg").a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.getTip("video_msg").a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.a.q) {
                        this.a.q = false;
                    } else {
                        i4 = i5;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    }
                    if (this.a.f26180b.getTabSpec(this.a.f26180b.getCurrentTabIndex()) == null || this.a.f26180b.getTabSpec(this.a.f26180b.getCurrentTabIndex()).a != 22) {
                        if (this.a.f26180b.getFragmentTabWidget() != null) {
                            this.a.f26180b.getFragmentTabWidget().makeWidgetDarkSkin(true, c.a.s0.y3.l.CAM_X0215);
                        }
                        this.a.f26180b.makeIndicatorDarkSkin(true);
                        if (!c.a.d.f.p.k.z()) {
                            c.a.d.f.p.m.J(this.a.a, this.a.a.getResources().getString(c.a.s0.y3.q.neterror));
                        }
                        if (!TbSingleton.getInstance().isFromFeedVideoClick()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
                        }
                    } else if (!TbSingleton.getInstance().isFromFeedVideoClick()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                } else {
                    if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                        this.a.f26180b.refreshVideoFragment(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    if (this.a.f26180b.getFragmentTabWidget() != null) {
                        this.a.f26180b.getFragmentTabWidget().makeWidgetDarkSkin(false, c.a.s0.y3.l.CAM_X0207);
                    }
                    this.a.f26180b.makeIndicatorDarkSkin(false);
                }
                if (tabSpec.a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                int i6 = tabSpec.a;
                if (i6 == 22 || i6 == 23) {
                    this.a.r.g(true);
                } else {
                    this.a.r.g(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26191e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26191e = fVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f26191e.f26180b.getCurrentTabType() != 2) {
                    if (this.f26191e.f26180b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.f26191e.f26180b.getCurrentTabType() != this.f26191e.f26180b.getTabSpec(i2).a) {
                    this.f26191e.f26180b.setCurrentTab(i2);
                }
                if (this.f26191e.f26180b.getCurrentTabType() == 1 && !c.a.r0.s.g0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (c.a.r0.s.g0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f26191e.f26180b.getCurrentTabType() != 3) {
                        if (this.f26191e.f26180b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f26191e.f26180b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f26193f;

        public c(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26193f = fVar;
            this.f26192e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26193f.M(this.f26192e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f26194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f26196g;

        public d(f fVar, c.a.r0.s.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26196g = fVar;
            this.f26194e = aVar;
            this.f26195f = i2;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f26194e.dismiss();
                int i2 = this.f26195f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f26196g.a.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f26196g.a.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f26197e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26198f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f26199g;

        public e(f fVar, c.a.r0.s.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26199g = fVar;
            this.f26197e = aVar;
            this.f26198f = i2;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f26197e.dismiss();
                int i2 = this.f26198f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f26199g.a.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f26199g.a.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f26199g.a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: c.a.s0.y3.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1517f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26200e;

        public RunnableC1517f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26200e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26200e.f26180b == null || this.f26200e.f26184f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f26200e.f26180b.getFragmentTabWidget();
            c.a.d.f.p.m.k(this.f26200e.a.getActivity());
            int f2 = c.a.d.f.p.m.f(this.f26200e.a.getActivity(), c.a.s0.y3.m.ds178);
            View contentView = this.f26200e.f26184f.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b tabSpecByType = this.f26200e.f26180b.getTabSpecByType(3);
            if (tabSpecByType == null || (tbFragmentTabIndicator = tabSpecByType.f41540b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = c.a.d.f.p.m.f(this.f26200e.a.getActivity(), c.a.s0.y3.m.tbds570);
            }
            c.a.d.f.m.g.l(this.f26200e.f26184f, fragmentTabWidget, measuredWidth2, -f2);
            c.a.r0.s.g0.b.j().t("show_maintab_last_message_tips", true);
            this.f26200e.f26185g = true;
            this.f26200e.f26186h.postDelayed(this.f26200e.B, 5000L);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26201e;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26201e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26201e.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                c.a.s0.k1.a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.i0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f26180b == null || !(customResponsedMessage.getData() instanceof c.a.r0.i0.c) || (cVar = (c.a.r0.i0.c) customResponsedMessage.getData()) == null || this.a.f26180b.getTabSpecByType(cVar.f12653e) == null || this.a.f26180b.getCurrentTabType() == cVar.f12653e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.a.f26180b.getTabSpecByType(cVar.f12653e).f41540b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f12655g, cVar.f12651c);
                if (TextUtils.isEmpty(cVar.f12655g)) {
                    return;
                }
                this.a.q = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public l(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.i0.e.a c2;
            c.a.r0.i0.e.a c3;
            c.a.r0.i0.e.a c4;
            c.a.r0.i0.e.a c5;
            c.a.r0.i0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.f26180b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b tabSpecByType = this.a.f26180b.getTabSpecByType(2);
                if (tabSpecByType != null && (tabSpecByType.f41540b instanceof MaintabBottomIndicator) && (c6 = c.a.r0.i0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType.f41540b).setDynamicIconData(c6);
                }
                FragmentTabHost.b tabSpecByType2 = this.a.f26180b.getTabSpecByType(1);
                if (tabSpecByType2 != null && (tabSpecByType2.f41540b instanceof MaintabBottomIndicator) && (c5 = c.a.r0.i0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType2.f41540b).setDynamicIconData(c5);
                }
                FragmentTabHost.b tabSpecByType3 = this.a.f26180b.getTabSpecByType(22);
                if (tabSpecByType3 != null && (tabSpecByType3.f41540b instanceof MaintabBottomIndicator) && (c4 = c.a.r0.i0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType3.f41540b).setDynamicIconData(c4);
                }
                FragmentTabHost.b tabSpecByType4 = this.a.f26180b.getTabSpecByType(3);
                if (tabSpecByType4 != null && (tabSpecByType4.f41540b instanceof MaintabBottomIndicator) && (c3 = c.a.r0.i0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType4.f41540b).setDynamicIconData(c3);
                }
                FragmentTabHost.b tabSpecByType5 = this.a.f26180b.getTabSpecByType(8);
                if (tabSpecByType5 == null || !(tabSpecByType5.f41540b instanceof MaintabBottomIndicator) || (c2 = c.a.r0.i0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) tabSpecByType5.f41540b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.x() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.a.p = true;
                    this.a.n = true;
                    if (this.a.o != 2) {
                        if (this.a.l == null || !this.a.l.isAnimating()) {
                            return;
                        }
                        this.a.l.playNormalAnimation(this.a.n);
                        return;
                    }
                    this.a.x().playLoadedAnimation();
                    return;
                }
                if (intValue == 6) {
                    this.a.p = false;
                    if (this.a.o == 1) {
                        return;
                    }
                } else {
                    this.a.o = intValue;
                }
                if (this.a.o == 1) {
                    this.a.x().playNormalAnimation(this.a.n);
                } else if (this.a.o == 2) {
                    this.a.x().playStaticAnimation();
                } else if (intValue == 5) {
                    this.a.o = 1;
                    this.a.n = true;
                    if (!this.a.p) {
                        this.a.x().playLoadedAnimation();
                    }
                } else {
                    this.a.x().playDynamicAnimation();
                }
                this.a.x().isHomePageIndicator = true;
                this.a.x().iconStatus = this.a.o;
                this.a.x().isSelectHome = this.a.n;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.n = true;
                if (this.a.x() != null) {
                    this.a.x().isSelectHome = this.a.n;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26202e;

        public p(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26202e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26202e.f26180b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26203e;

        public q(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26203e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26203e.f26180b.setVisibility(0);
            }
        }
    }

    public f(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26182d = false;
        this.f26185g = false;
        this.f26186h = new Handler();
        this.m = 0;
        this.n = true;
        this.o = 1;
        this.p = false;
        this.q = false;
        this.s = new a(this);
        this.t = new j(this, 2921492);
        this.u = new k(this, 2001440);
        this.v = new l(this);
        this.w = new m(this, 2921551);
        this.x = new n(this, 2921382);
        this.y = new o(this, 2921410);
        this.A = new RunnableC1517f(this);
        this.B = new g(this);
        this.a = mainTabActivity;
    }

    public SeekBar A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            s sVar = this.r;
            if (sVar != null) {
                return sVar.f();
            }
            return null;
        }
        return (SeekBar) invokeV.objValue;
    }

    public void B(ArrayList<c.a.r0.i0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f26180b.reset();
            Iterator<c.a.r0.i0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.r0.i0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    v(next, next.getFragmentTabStructure(), next.getTabIndicator(this.a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f26180b.initViewPager(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f26180b.initViewPager(1);
            } else {
                this.f26180b.initViewPager(0);
            }
            this.f26180b.setViewPagerScrollable(false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = false;
            this.o = 1;
            if (x() != null) {
                x().iconStatus = this.o;
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26183e : invokeV.booleanValue;
    }

    public void E(int i2) {
        FragmentTabHost fragmentTabHost;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (fragmentTabHost = this.f26180b) == null) {
            return;
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            fragmentTabHost.setShouldDrawTopLine(false);
        }
        this.f26180b.onChangeSkinType(i2);
        FragmentTabHost fragmentTabHost2 = this.f26180b;
        FragmentTabHost.b tabSpec = fragmentTabHost2.getTabSpec(fragmentTabHost2.getCurrentTabIndex());
        if (tabSpec != null && ((i3 = tabSpec.a) == 22 || i3 == 23)) {
            if (this.f26180b.getFragmentTabWidget() != null) {
                this.f26180b.getFragmentTabWidget().makeWidgetDarkSkin(true, c.a.s0.y3.l.CAM_X0215);
            }
            this.f26180b.makeIndicatorDarkSkin(true);
            return;
        }
        if (this.f26180b.getFragmentTabWidget() != null) {
            this.f26180b.getFragmentTabWidget().makeWidgetDarkSkin(false, c.a.s0.y3.l.CAM_X0207);
        }
        this.f26180b.makeIndicatorDarkSkin(false);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            L();
            if (z() != null) {
                z().reset();
            }
            w();
            c.a.s0.k0.j jVar = this.f26187i;
            if (jVar != null) {
                jVar.h();
            }
            c.a.s0.j4.e eVar = this.f26188j;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void G(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (fragmentTabHost = this.f26180b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.hideTabWidget();
        } else {
            fragmentTabHost.showTabWidget();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ItemCardHelper.v(this.v);
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(c.a.s0.y3.o.tab_host);
            this.f26180b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            c.a.s0.y3.c.b(new p(this), 1);
            c.a.s0.y3.c.b(new q(this), 7);
            this.f26180b.setup(this.a.getSupportFragmentManager());
            this.f26180b.setAbsoluteWeight(true);
            this.f26180b.setOnTabSelectionListener(this.s);
            this.f26180b.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f26180b.setShouldDrawIndicatorLine(false);
                this.f26180b.setShouldDrawTopLine(true);
            }
            this.f26180b.setOnPageChangeListener(new b(this));
            this.f26182d = c.a.r0.s.g0.b.j().g("has_show_message_tab_tips", false);
            this.f26181c = (TextView) this.a.findViewById(c.a.s0.y3.o.activity_prize_my_tip);
            this.f26180b.setUIType(0);
            this.f26180b.setTabContainerShadowShow(false);
            this.f26180b.setBackGroundStyle(0);
            this.f26180b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            s sVar = new s(this.a, this.f26180b.getTabWrapper());
            this.r = sVar;
            sVar.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.a.registerListener(this.x);
            }
            this.a.registerListener(this.y);
            this.a.registerListener(this.t);
            this.a.registerListener(this.w);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    public void K(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            z().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.p = true;
                if (this.n && (maintabBottomIndicator = this.l) != null) {
                    maintabBottomIndicator.playNormalAnimation(false);
                }
                this.n = false;
                if (x() != null) {
                    x().isSelectHome = this.n;
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.s.g0.b.j().t("has_show_message_tab_tips", this.f26182d);
        }
    }

    public void M(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f26181c.setVisibility(8);
                return;
            }
            FragmentTabHost.b tabSpecByType = this.f26180b.getTabSpecByType(8);
            if (tabSpecByType != null) {
                if (this.f26185g && ((popupWindow = this.f26184f) == null || !popupWindow.isShowing())) {
                    N(str, tabSpecByType);
                    return;
                }
                if (this.z == null) {
                    this.z = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.z);
                TbadkCoreApplication.getInst().handler.postDelayed(this.z, 5000L);
                return;
            }
            this.f26181c.setVisibility(8);
        }
    }

    public final void N(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f41540b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f41540b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26181c.getLayoutParams();
            layoutParams.rightMargin = (c.a.d.f.p.m.q(this.a).widthPixels - width) - c.a.d.f.p.m.f(this.a.getPageContext().getPageActivity(), c.a.s0.y3.m.ds26);
            this.f26181c.setLayoutParams(layoutParams);
            this.f26181c.setVisibility(0);
            this.f26181c.setText(str);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(c.a.s0.y3.q.close, new h(this));
            aVar.setNegativeButton(c.a.s0.y3.q.check, new i(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public void P(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.s0.y3.p.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(c.a.s0.y3.o.member_icon);
        TextView textView = (TextView) inflate.findViewById(c.a.s0.y3.o.member_died_line_tip);
        SkinManager.setViewTextColor(textView, c.a.s0.y3.l.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.x())) {
            textView.setText(payMemberInfoData.x());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setSkinType(TbadkCoreApplication.getInst().getSkinType());
        } else {
            SkinManager.setImageResource(tbImageView, c.a.s0.y3.n.icon_vip_advanced);
        }
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(c.a.s0.y3.l.CAM_X0305);
        aVar.setNegativeButton(c.a.s0.y3.q.know, new d(this, aVar, i2));
        String string = this.a.getPageContext().getString(c.a.s0.y3.q.member_continue_pay);
        if (i2 == 0) {
            string = this.a.getPageContext().getString(c.a.s0.y3.q.open_member);
        }
        aVar.setPositiveButton(string, new e(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.a.getPageContext()).show();
        c.a.r0.s.g0.b.j().t("show_member_deid_line", false);
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.f26188j == null) {
            MainTabActivity mainTabActivity = this.a;
            this.f26188j = new c.a.s0.j4.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.f26188j.g(postWriteCallBackData);
    }

    public void R(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            if (this.f26187i == null) {
                this.f26187i = new c.a.s0.k0.j(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(c.a.s0.y3.o.navigation_cover_tip));
            }
            this.f26187i.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f26183e = z;
            if (z) {
                return;
            }
            c.a.r0.s.g0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean u(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.d.f.p.l.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.r0.s.g0.b.j().g(c.a.r0.s.g0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.r0.i0.b bVar, c.a.r0.i0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f41541c = cVar.a;
            bVar2.a = cVar.f12653e;
            maintabBottomIndicator.setShowIconType(cVar.f12657i);
            int i2 = cVar.f12657i;
            if (i2 == c.a.r0.i0.c.f12648j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == c.a.r0.i0.c.m) {
                maintabBottomIndicator.setText(cVar.f12650b);
                maintabBottomIndicator.setAnimationResId(cVar.f12654f);
                this.f26189k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f12650b);
                maintabBottomIndicator.setAnimationResId(cVar.f12654f);
            }
            if (!c.a.d.f.p.l.isEmpty(cVar.f12655g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f12655g, cVar.f12651c);
            }
            c.a.r0.i0.e.a aVar = cVar.f12656h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.a == 2) {
                maintabBottomIndicator.isSelected = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f41540b = maintabBottomIndicator;
            bVar2.f41542d = bVar;
            this.f26180b.addTabSpec(bVar2, -1, z);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f26186h.removeCallbacks(this.A);
            this.f26186h.removeCallbacks(this.B);
            c.a.d.f.m.g.c(this.f26184f);
        }
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f26189k : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f26180b : (FragmentTabHost) invokeV.objValue;
    }
}
