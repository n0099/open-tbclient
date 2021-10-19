package c.a.r0.n3;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f22617a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f22618b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22619c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22620d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22621e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f22622f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22623g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f22624h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.f0.h f22625i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.y3.e f22626j;
    public MaintabBottomIndicator k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public FragmentTabHost.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final ItemCardHelper.c u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public Runnable y;
    public Runnable z;

    /* loaded from: classes3.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22627a;

        /* renamed from: c.a.r0.n3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1055a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f22628e;

            public RunnableC1055a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f22628e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f22628e);
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22627a = dVar;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            c.a.q0.h0.c cVar = new c.a.q0.h0.c();
            cVar.f13477g = redIcon.image;
            cVar.f13475e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }

        public final void b(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (this.f22627a.f22618b.getTabSpec(i2).f47589a == 2) {
                    m = TbPageExtraHelper.l(this.f22627a.f22617a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                c.a.e.e.m.e.a().postDelayed(new RunnableC1055a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.f22627a.f22618b.getTabSpec(i2).f47589a;
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
                FragmentTabHost.b tabSpec = this.f22627a.f22618b.getTabSpec(i2);
                if (tabSpec.f47589a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f22627a.f22617a.getPageContext(), null)) {
                    int i3 = tabSpec.f47589a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f22627a.f22617a.getActivity())) {
                            if (this.f22627a.k != null) {
                                this.f22627a.k.hideLottieView();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = tabSpec.f47589a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f22627a.f22617a.getActivity())) {
                                return false;
                            }
                            if (tabSpec.f47589a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f22627a.f22617a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new c.a.q0.u.j(0)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                    return false;
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
                FragmentTabHost.b tabSpec = this.f22627a.f22618b.getTabSpec(i2);
                int i3 = tabSpec.f47589a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.f22627a.k != null && this.f22627a.k.getAnimationView() != null && this.f22627a.k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f22627a.k != null) {
                        this.f22627a.k.hideLottieView();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (tabSpec.f47589a == 2) {
                    if (this.f22627a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f22627a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f22627a.o != 2 || this.f22627a.m == i2 || homeBarShowType != 1 || this.f22627a.l == null) {
                        if (this.f22627a.o == 1 && this.f22627a.l != null) {
                            this.f22627a.l.playNormalAnimation(this.f22627a.n);
                        }
                    } else {
                        this.f22627a.l.playStaticAnimation();
                    }
                    this.f22627a.p = false;
                } else {
                    this.f22627a.p = true;
                    if (this.f22627a.n && this.f22627a.l != null) {
                        this.f22627a.l.playNormalAnimation(this.f22627a.n);
                    }
                    this.f22627a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f22627a.w() != null) {
                    this.f22627a.w().isSelectHome = this.f22627a.n;
                }
                if (!this.f22627a.n) {
                    c.a.r0.y0.a.i().r();
                }
                c(this.f22627a.m);
                b(this.f22627a.m);
                this.f22627a.m = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (tabSpec.f47589a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = tabSpec.f47590b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("video_msg") != null && (maintabBottomIndicator.getTip("video_msg").f48445a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.getTip("video_msg").f48445a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.f22627a.q) {
                        this.f22627a.q = false;
                    } else {
                        i4 = i5;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    }
                    if (this.f22627a.f22618b.getTabSpec(this.f22627a.f22618b.getCurrentTabIndex()).f47589a != 22) {
                        if (this.f22627a.f22618b.getFragmentTabWidget() != null) {
                            this.f22627a.f22618b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                        }
                        this.f22627a.f22618b.makeIndicatorDarkSkin(true);
                        if (!c.a.e.e.p.j.z()) {
                            c.a.e.e.p.l.J(this.f22627a.f22617a, this.f22627a.f22617a.getResources().getString(R.string.neterror));
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
                        this.f22627a.f22618b.refreshVideoFragment(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    if (this.f22627a.f22618b.getFragmentTabWidget() != null) {
                        this.f22627a.f22618b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
                    }
                    this.f22627a.f22618b.makeIndicatorDarkSkin(false);
                }
                if (tabSpec.f47589a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f22629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22630f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f22631g;

        public b(d dVar, c.a.q0.s.s.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22631g = dVar;
            this.f22629e = aVar;
            this.f22630f = i2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22629e.dismiss();
                int i2 = this.f22630f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f22631g.f22617a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f22631g.f22617a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f22632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f22634g;

        public c(d dVar, c.a.q0.s.s.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22634g = dVar;
            this.f22632e = aVar;
            this.f22633f = i2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22632e.dismiss();
                int i2 = this.f22633f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f22634g.f22617a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f22634g.f22617a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f22634g.f22617a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: c.a.r0.n3.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1056d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22635e;

        public RunnableC1056d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22635e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22635e.f22618b == null || this.f22635e.f22622f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f22635e.f22618b.getFragmentTabWidget();
            c.a.e.e.p.l.k(this.f22635e.f22617a.getActivity());
            int g2 = c.a.e.e.p.l.g(this.f22635e.f22617a.getActivity(), R.dimen.ds178);
            View contentView = this.f22635e.f22622f.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b tabSpecByType = this.f22635e.f22618b.getTabSpecByType(3);
            if (tabSpecByType == null || (tbFragmentTabIndicator = tabSpecByType.f47590b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = c.a.e.e.p.l.g(this.f22635e.f22617a.getActivity(), R.dimen.tbds570);
            }
            c.a.e.e.m.g.l(this.f22635e.f22622f, fragmentTabWidget, measuredWidth2, -g2);
            c.a.q0.s.d0.b.j().t("show_maintab_last_message_tips", true);
            this.f22635e.f22623g = true;
            this.f22635e.f22624h.postDelayed(this.f22635e.A, 5000L);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22636e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22636e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22636e.v();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                c.a.r0.e1.a.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22637a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22637a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.q0.h0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f22637a.f22618b == null || !(customResponsedMessage.getData() instanceof c.a.q0.h0.c) || (cVar = (c.a.q0.h0.c) customResponsedMessage.getData()) == null || this.f22637a.f22618b.getTabSpecByType(cVar.f13475e) == null || this.f22637a.f22618b.getCurrentTabType() == cVar.f13475e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f22637a.f22618b.getTabSpecByType(cVar.f13475e).f47590b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f13477g, cVar.f13473c);
                if (TextUtils.isEmpty(cVar.f13477g)) {
                    return;
                }
                this.f22637a.q = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22638a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22638a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f22638a.f22617a, this.f22638a.f22617a.getUniqueId(), (View) customResponsedMessage.getData(), this.f22638a.f22617a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22639a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22639a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.f22639a.f22617a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f22639a.f22617a.getActivityRootView(), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f22639a.f22617a, ItemCardHelper.OrderTipStatus.FAIL, this.f22639a.f22617a.getActivityRootView(), 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22640a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22640a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.q0.h0.e.a c2;
            c.a.q0.h0.e.a c3;
            c.a.q0.h0.e.a c4;
            c.a.q0.h0.e.a c5;
            c.a.q0.h0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f22640a.f22618b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b tabSpecByType = this.f22640a.f22618b.getTabSpecByType(2);
                if (tabSpecByType != null && (tabSpecByType.f47590b instanceof MaintabBottomIndicator) && (c6 = c.a.q0.h0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType.f47590b).setDynamicIconData(c6);
                }
                FragmentTabHost.b tabSpecByType2 = this.f22640a.f22618b.getTabSpecByType(1);
                if (tabSpecByType2 != null && (tabSpecByType2.f47590b instanceof MaintabBottomIndicator) && (c5 = c.a.q0.h0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType2.f47590b).setDynamicIconData(c5);
                }
                FragmentTabHost.b tabSpecByType3 = this.f22640a.f22618b.getTabSpecByType(22);
                if (tabSpecByType3 != null && (tabSpecByType3.f47590b instanceof MaintabBottomIndicator) && (c4 = c.a.q0.h0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType3.f47590b).setDynamicIconData(c4);
                }
                FragmentTabHost.b tabSpecByType4 = this.f22640a.f22618b.getTabSpecByType(3);
                if (tabSpecByType4 != null && (tabSpecByType4.f47590b instanceof MaintabBottomIndicator) && (c3 = c.a.q0.h0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType4.f47590b).setDynamicIconData(c3);
                }
                FragmentTabHost.b tabSpecByType5 = this.f22640a.f22618b.getTabSpecByType(8);
                if (tabSpecByType5 == null || !(tabSpecByType5.f47590b instanceof MaintabBottomIndicator) || (c2 = c.a.q0.h0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) tabSpecByType5.f47590b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22641a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22641a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f22641a.w() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f22641a.p = true;
                    this.f22641a.n = true;
                    if (this.f22641a.o != 2) {
                        if (this.f22641a.l == null || !this.f22641a.l.isAnimating()) {
                            return;
                        }
                        this.f22641a.l.playNormalAnimation(this.f22641a.n);
                        return;
                    }
                    this.f22641a.w().playLoadedAnimation();
                    return;
                }
                if (intValue == 6) {
                    this.f22641a.p = false;
                    if (this.f22641a.o == 1) {
                        return;
                    }
                } else {
                    this.f22641a.o = intValue;
                }
                if (this.f22641a.o == 1) {
                    this.f22641a.w().playNormalAnimation(this.f22641a.n);
                } else if (this.f22641a.o == 2) {
                    this.f22641a.w().playStaticAnimation();
                } else if (intValue == 5) {
                    this.f22641a.o = 1;
                    this.f22641a.n = true;
                    if (!this.f22641a.p) {
                        this.f22641a.w().playLoadedAnimation();
                    }
                } else {
                    this.f22641a.w().playDynamicAnimation();
                }
                this.f22641a.w().isHomePageIndicator = true;
                this.f22641a.w().iconStatus = this.f22641a.o;
                this.f22641a.w().isSelectHome = this.f22641a.n;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22642a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f22642a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f22642a.n = true;
                if (this.f22642a.w() != null) {
                    this.f22642a.w().isSelectHome = this.f22642a.n;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22643e;

        public n(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22643e = dVar;
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
                if (this.f22643e.f22618b.getCurrentTabType() != 2) {
                    if (this.f22643e.f22618b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.f22643e.f22618b.getCurrentTabType() != this.f22643e.f22618b.getTabSpec(i2).f47589a) {
                    this.f22643e.f22618b.setCurrentTab(i2);
                }
                if (this.f22643e.f22618b.getCurrentTabType() == 1 && !c.a.q0.s.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (c.a.q0.s.d0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f22643e.f22618b.getCurrentTabType() != 3) {
                        if (this.f22643e.f22618b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f22643e.f22618b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f22645f;

        public o(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22645f = dVar;
            this.f22644e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22645f.K(this.f22644e);
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
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
        this.f22620d = false;
        this.f22623g = false;
        this.f22624h = new Handler();
        this.m = 0;
        this.n = true;
        this.o = 1;
        this.p = false;
        this.q = false;
        this.r = new a(this);
        this.s = new h(this, 2921492);
        this.t = new i(this, 2001440);
        this.u = new j(this);
        this.v = new k(this, 2921551);
        this.w = new l(this, 2921382);
        this.x = new m(this, 2921410);
        this.z = new RunnableC1056d(this);
        this.A = new e(this);
        this.f22617a = mainTabActivity;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p = false;
            this.o = 1;
            if (w() != null) {
                w().iconStatus = this.o;
            }
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22621e : invokeV.booleanValue;
    }

    public void C(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22618b.setShouldDrawTopLine(false);
            }
            this.f22618b.onChangeSkinType(i2);
            FragmentTabHost fragmentTabHost = this.f22618b;
            FragmentTabHost.b tabSpec = fragmentTabHost.getTabSpec(fragmentTabHost.getCurrentTabIndex());
            if (tabSpec != null && ((i3 = tabSpec.f47589a) == 22 || i3 == 23)) {
                if (this.f22618b.getFragmentTabWidget() != null) {
                    this.f22618b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                }
                this.f22618b.makeIndicatorDarkSkin(true);
                return;
            }
            if (this.f22618b.getFragmentTabWidget() != null) {
                this.f22618b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
            }
            this.f22618b.makeIndicatorDarkSkin(false);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            J();
            if (y() != null) {
                y().reset();
            }
            v();
            c.a.r0.f0.h hVar = this.f22625i;
            if (hVar != null) {
                hVar.h();
            }
            c.a.r0.y3.e eVar = this.f22626j;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void E(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (fragmentTabHost = this.f22618b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.hideTabWidget();
        } else {
            fragmentTabHost.showTabWidget();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ItemCardHelper.v(this.u);
            MessageManager.getInstance().registerListener(this.t);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f22617a.findViewById(R.id.tab_host);
            this.f22618b = fragmentTabHost;
            fragmentTabHost.setup(this.f22617a.getSupportFragmentManager());
            this.f22618b.setAbsoluteWeight(true);
            this.f22618b.setOnTabSelectionListener(this.r);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22618b.setShouldDrawIndicatorLine(false);
                this.f22618b.setShouldDrawTopLine(true);
            }
            this.f22618b.setOnPageChangeListener(new n(this));
            this.f22620d = c.a.q0.s.d0.b.j().g("has_show_message_tab_tips", false);
            this.f22619c = (TextView) this.f22617a.findViewById(R.id.activity_prize_my_tip);
            this.f22618b.setUIType(0);
            this.f22618b.setTabContainerShadowShow(false);
            this.f22618b.setBackGroundStyle(0);
            this.f22618b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f22617a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f22617a.registerListener(this.w);
            }
            this.f22617a.registerListener(this.x);
            this.f22617a.registerListener(this.s);
            this.f22617a.registerListener(this.v);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public void I(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            y().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.p = true;
                if (this.n && (maintabBottomIndicator = this.l) != null) {
                    maintabBottomIndicator.playNormalAnimation(false);
                }
                this.n = false;
                if (w() != null) {
                    w().isSelectHome = this.n;
                }
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.s.d0.b.j().t("has_show_message_tab_tips", this.f22620d);
        }
    }

    public void K(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f22619c.setVisibility(8);
                return;
            }
            FragmentTabHost.b tabSpecByType = this.f22618b.getTabSpecByType(8);
            if (tabSpecByType != null) {
                if (this.f22623g && ((popupWindow = this.f22622f) == null || !popupWindow.isShowing())) {
                    L(str, tabSpecByType);
                    return;
                }
                if (this.y == null) {
                    this.y = new o(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.y);
                TbadkCoreApplication.getInst().handler.postDelayed(this.y, 5000L);
                return;
            }
            this.f22619c.setVisibility(8);
        }
    }

    public final void L(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f47590b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f47590b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22619c.getLayoutParams();
            layoutParams.rightMargin = (c.a.e.e.p.l.q(this.f22617a).widthPixels - width) - c.a.e.e.p.l.g(this.f22617a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f22619c.setLayoutParams(layoutParams);
            this.f22619c.setVisibility(0);
            this.f22619c.setText(str);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22617a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new f(this));
            aVar.setNegativeButton(R.string.check, new g(this));
            aVar.create(this.f22617a.getPageContext()).show();
        }
    }

    public void N(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f22617a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.x())) {
            textView.setText(payMemberInfoData.x());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setSkinType(TbadkCoreApplication.getInst().getSkinType());
        } else {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22617a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f22617a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f22617a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f22617a.getPageContext()).show();
        c.a.q0.s.d0.b.j().t("show_member_deid_line", false);
    }

    public void O(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.f22617a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.f22626j == null) {
            MainTabActivity mainTabActivity = this.f22617a;
            this.f22626j = new c.a.r0.y3.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.f22626j.g(postWriteCallBackData);
    }

    public void P(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, postWriteCallBackData) == null) {
            if (this.f22625i == null) {
                this.f22625i = new c.a.r0.f0.h(this.f22617a.getPageContext(), (NavigationBarCoverTip) this.f22617a.findViewById(R.id.navigation_cover_tip));
            }
            this.f22625i.l(postWriteCallBackData);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f22621e = z;
            if (z) {
                return;
            }
            c.a.q0.s.d0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean t(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.q0.s.d0.b.j().g(c.a.q0.s.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f22617a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(c.a.q0.h0.b bVar, c.a.q0.h0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f47591c = cVar.f13471a;
            bVar2.f47589a = cVar.f13475e;
            maintabBottomIndicator.setShowIconType(cVar.f13479i);
            int i2 = cVar.f13479i;
            if (i2 == c.a.q0.h0.c.f13470j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == c.a.q0.h0.c.m) {
                maintabBottomIndicator.setText(cVar.f13472b);
                maintabBottomIndicator.setAnimationResId(cVar.f13476f);
                this.k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f13472b);
                maintabBottomIndicator.setAnimationResId(cVar.f13476f);
            }
            if (!c.a.e.e.p.k.isEmpty(cVar.f13477g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f13477g, cVar.f13473c);
            }
            c.a.q0.h0.e.a aVar = cVar.f13478h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f47589a == 2) {
                maintabBottomIndicator.isSelected = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f47590b = maintabBottomIndicator;
            bVar2.f47592d = bVar;
            this.f22618b.addTabSpec(bVar2, -1, z);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f22624h.removeCallbacks(this.z);
            this.f22624h.removeCallbacks(this.A);
            c.a.e.e.m.g.c(this.f22622f);
        }
    }

    public MaintabBottomIndicator w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f22618b : (FragmentTabHost) invokeV.objValue;
    }

    public void z(ArrayList<c.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, arrayList) == null) {
            this.f22618b.reset();
            Iterator<c.a.q0.h0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.q0.h0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    u(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f22617a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f22618b.initViewPager(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22618b.initViewPager(1);
            } else {
                this.f22618b.initViewPager(0);
            }
            this.f22618b.setViewPagerScrollable(false);
        }
    }
}
