package b.a.r0.o3;

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
import b.a.q0.s.s.a;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public Runnable B;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f22074a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f22075b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22076c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22077d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22078e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f22079f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22080g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f22081h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.f0.j f22082i;
    public b.a.r0.z3.e j;
    public MaintabBottomIndicator k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public b.a.r0.o3.g r;
    public FragmentTabHost.a s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public final ItemCardHelper.c v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public Runnable z;

    /* loaded from: classes5.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22083a;

        /* renamed from: b.a.r0.o3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1077a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f22084e;

            public RunnableC1077a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f22084e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f22084e);
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
            this.f22083a = dVar;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            b.a.q0.h0.c cVar = new b.a.q0.h0.c();
            cVar.f12618g = redIcon.image;
            cVar.f12616e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }

        public final void b(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (this.f22083a.f22075b.getTabSpec(i2).f45183a == 2) {
                    m = TbPageExtraHelper.l(this.f22083a.f22074a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                b.a.e.e.m.e.a().postDelayed(new RunnableC1077a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.f22083a.f22075b.getTabSpec(i2).f45183a;
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
                FragmentTabHost.b tabSpec = this.f22083a.f22075b.getTabSpec(i2);
                if (tabSpec.f45183a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f22083a.f22074a.getPageContext(), null)) {
                    int i3 = tabSpec.f45183a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f22083a.f22074a.getActivity())) {
                            if (this.f22083a.k != null) {
                                this.f22083a.k.hideLottieView();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = tabSpec.f45183a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f22083a.f22074a.getActivity())) {
                                return false;
                            }
                            if (tabSpec.f45183a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f22083a.f22074a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new b.a.q0.u.k(0)));
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
                FragmentTabHost.b tabSpec = this.f22083a.f22075b.getTabSpec(i2);
                int i3 = tabSpec.f45183a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.f22083a.k != null && this.f22083a.k.getAnimationView() != null && this.f22083a.k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f22083a.k != null) {
                        this.f22083a.k.hideLottieView();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (tabSpec.f45183a == 2) {
                    if (this.f22083a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f22083a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f22083a.o != 2 || this.f22083a.m == i2 || homeBarShowType != 1 || this.f22083a.l == null) {
                        if (this.f22083a.o == 1 && this.f22083a.l != null) {
                            this.f22083a.l.playNormalAnimation(this.f22083a.n);
                        }
                    } else {
                        this.f22083a.l.playStaticAnimation();
                    }
                    this.f22083a.p = false;
                } else {
                    this.f22083a.p = true;
                    if (this.f22083a.n && this.f22083a.l != null) {
                        this.f22083a.l.playNormalAnimation(this.f22083a.n);
                    }
                    this.f22083a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f22083a.x() != null) {
                    this.f22083a.x().isSelectHome = this.f22083a.n;
                }
                if (!this.f22083a.n) {
                    b.a.r0.y0.a.i().r();
                }
                c(this.f22083a.m);
                b(this.f22083a.m);
                this.f22083a.m = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (tabSpec.f45183a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = tabSpec.f45184b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("video_msg") != null && (maintabBottomIndicator.getTip("video_msg").f45973a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.getTip("video_msg").f45973a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.f22083a.q) {
                        this.f22083a.q = false;
                    } else {
                        i4 = i5;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    }
                    if (this.f22083a.f22075b.getTabSpec(this.f22083a.f22075b.getCurrentTabIndex()) == null || this.f22083a.f22075b.getTabSpec(this.f22083a.f22075b.getCurrentTabIndex()).f45183a != 22) {
                        if (this.f22083a.f22075b.getFragmentTabWidget() != null) {
                            this.f22083a.f22075b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                        }
                        this.f22083a.f22075b.makeIndicatorDarkSkin(true);
                        if (!b.a.e.e.p.j.z()) {
                            b.a.e.e.p.l.J(this.f22083a.f22074a, this.f22083a.f22074a.getResources().getString(R.string.neterror));
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
                        this.f22083a.f22075b.refreshVideoFragment(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    if (this.f22083a.f22075b.getFragmentTabWidget() != null) {
                        this.f22083a.f22075b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
                    }
                    this.f22083a.f22075b.makeIndicatorDarkSkin(false);
                }
                if (tabSpec.f45183a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                int i6 = tabSpec.f45183a;
                if (i6 == 22 || i6 == 23) {
                    this.f22083a.r.g(true);
                } else {
                    this.f22083a.r.g(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f22085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f22087g;

        public b(d dVar, b.a.q0.s.s.a aVar, int i2) {
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
            this.f22087g = dVar;
            this.f22085e = aVar;
            this.f22086f = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22085e.dismiss();
                int i2 = this.f22086f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f22087g.f22074a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f22087g.f22074a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f22088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f22090g;

        public c(d dVar, b.a.q0.s.s.a aVar, int i2) {
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
            this.f22090g = dVar;
            this.f22088e = aVar;
            this.f22089f = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22088e.dismiss();
                int i2 = this.f22089f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f22090g.f22074a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f22090g.f22074a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f22090g.f22074a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: b.a.r0.o3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1078d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22091e;

        public RunnableC1078d(d dVar) {
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
            this.f22091e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22091e.f22075b == null || this.f22091e.f22079f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f22091e.f22075b.getFragmentTabWidget();
            b.a.e.e.p.l.k(this.f22091e.f22074a.getActivity());
            int g2 = b.a.e.e.p.l.g(this.f22091e.f22074a.getActivity(), R.dimen.ds178);
            View contentView = this.f22091e.f22079f.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b tabSpecByType = this.f22091e.f22075b.getTabSpecByType(3);
            if (tabSpecByType == null || (tbFragmentTabIndicator = tabSpecByType.f45184b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = b.a.e.e.p.l.g(this.f22091e.f22074a.getActivity(), R.dimen.tbds570);
            }
            b.a.e.e.m.g.l(this.f22091e.f22079f, fragmentTabWidget, measuredWidth2, -g2);
            b.a.q0.s.e0.b.j().t("show_maintab_last_message_tips", true);
            this.f22091e.f22080g = true;
            this.f22091e.f22081h.postDelayed(this.f22091e.B, 5000L);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22092e;

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
            this.f22092e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22092e.w();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                b.a.r0.e1.a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22093a;

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
            this.f22093a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.q0.h0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f22093a.f22075b == null || !(customResponsedMessage.getData() instanceof b.a.q0.h0.c) || (cVar = (b.a.q0.h0.c) customResponsedMessage.getData()) == null || this.f22093a.f22075b.getTabSpecByType(cVar.f12616e) == null || this.f22093a.f22075b.getCurrentTabType() == cVar.f12616e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f22093a.f22075b.getTabSpecByType(cVar.f12616e).f45184b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f12618g, cVar.f12614c);
                if (TextUtils.isEmpty(cVar.f12618g)) {
                    return;
                }
                this.f22093a.q = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22094a;

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
            this.f22094a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f22094a.f22074a, this.f22094a.f22074a.getUniqueId(), (View) customResponsedMessage.getData(), this.f22094a.f22074a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22095a;

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
            this.f22095a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.f22095a.f22074a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f22095a.f22074a.getActivityRootView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f22095a.f22074a, ItemCardHelper.OrderTipStatus.FAIL, this.f22095a.f22074a.getActivityRootView(), 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22096a;

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
            this.f22096a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.q0.h0.e.a c2;
            b.a.q0.h0.e.a c3;
            b.a.q0.h0.e.a c4;
            b.a.q0.h0.e.a c5;
            b.a.q0.h0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f22096a.f22075b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b tabSpecByType = this.f22096a.f22075b.getTabSpecByType(2);
                if (tabSpecByType != null && (tabSpecByType.f45184b instanceof MaintabBottomIndicator) && (c6 = b.a.q0.h0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType.f45184b).setDynamicIconData(c6);
                }
                FragmentTabHost.b tabSpecByType2 = this.f22096a.f22075b.getTabSpecByType(1);
                if (tabSpecByType2 != null && (tabSpecByType2.f45184b instanceof MaintabBottomIndicator) && (c5 = b.a.q0.h0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType2.f45184b).setDynamicIconData(c5);
                }
                FragmentTabHost.b tabSpecByType3 = this.f22096a.f22075b.getTabSpecByType(22);
                if (tabSpecByType3 != null && (tabSpecByType3.f45184b instanceof MaintabBottomIndicator) && (c4 = b.a.q0.h0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType3.f45184b).setDynamicIconData(c4);
                }
                FragmentTabHost.b tabSpecByType4 = this.f22096a.f22075b.getTabSpecByType(3);
                if (tabSpecByType4 != null && (tabSpecByType4.f45184b instanceof MaintabBottomIndicator) && (c3 = b.a.q0.h0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType4.f45184b).setDynamicIconData(c3);
                }
                FragmentTabHost.b tabSpecByType5 = this.f22096a.f22075b.getTabSpecByType(8);
                if (tabSpecByType5 == null || !(tabSpecByType5.f45184b instanceof MaintabBottomIndicator) || (c2 = b.a.q0.h0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) tabSpecByType5.f45184b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22097a;

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
            this.f22097a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f22097a.x() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f22097a.p = true;
                    this.f22097a.n = true;
                    if (this.f22097a.o != 2) {
                        if (this.f22097a.l == null || !this.f22097a.l.isAnimating()) {
                            return;
                        }
                        this.f22097a.l.playNormalAnimation(this.f22097a.n);
                        return;
                    }
                    this.f22097a.x().playLoadedAnimation();
                    return;
                }
                if (intValue == 6) {
                    this.f22097a.p = false;
                    if (this.f22097a.o == 1) {
                        return;
                    }
                } else {
                    this.f22097a.o = intValue;
                }
                if (this.f22097a.o == 1) {
                    this.f22097a.x().playNormalAnimation(this.f22097a.n);
                } else if (this.f22097a.o == 2) {
                    this.f22097a.x().playStaticAnimation();
                } else if (intValue == 5) {
                    this.f22097a.o = 1;
                    this.f22097a.n = true;
                    if (!this.f22097a.p) {
                        this.f22097a.x().playLoadedAnimation();
                    }
                } else {
                    this.f22097a.x().playDynamicAnimation();
                }
                this.f22097a.x().isHomePageIndicator = true;
                this.f22097a.x().iconStatus = this.f22097a.o;
                this.f22097a.x().isSelectHome = this.f22097a.n;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22098a;

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
            this.f22098a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f22098a.n = true;
                if (this.f22098a.x() != null) {
                    this.f22098a.x().isSelectHome = this.f22098a.n;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22099e;

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
            this.f22099e = dVar;
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
                if (this.f22099e.f22075b.getCurrentTabType() != 2) {
                    if (this.f22099e.f22075b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.f22099e.f22075b.getCurrentTabType() != this.f22099e.f22075b.getTabSpec(i2).f45183a) {
                    this.f22099e.f22075b.setCurrentTab(i2);
                }
                if (this.f22099e.f22075b.getCurrentTabType() == 1 && !b.a.q0.s.e0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (b.a.q0.s.e0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f22099e.f22075b.getCurrentTabType() != 3) {
                        if (this.f22099e.f22075b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f22099e.f22075b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22100e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f22101f;

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
            this.f22101f = dVar;
            this.f22100e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22101f.M(this.f22100e);
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
        this.f22077d = false;
        this.f22080g = false;
        this.f22081h = new Handler();
        this.m = 0;
        this.n = true;
        this.o = 1;
        this.p = false;
        this.q = false;
        this.s = new a(this);
        this.t = new h(this, 2921492);
        this.u = new i(this, 2001440);
        this.v = new j(this);
        this.w = new k(this, 2921551);
        this.x = new l(this, 2921382);
        this.y = new m(this, 2921410);
        this.A = new RunnableC1078d(this);
        this.B = new e(this);
        this.f22074a = mainTabActivity;
    }

    public SeekBar A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.o3.g gVar = this.r;
            if (gVar != null) {
                return gVar.f();
            }
            return null;
        }
        return (SeekBar) invokeV.objValue;
    }

    public void B(ArrayList<b.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f22075b.reset();
            Iterator<b.a.q0.h0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.q0.h0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    v(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f22074a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f22075b.initViewPager(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22075b.initViewPager(1);
            } else {
                this.f22075b.initViewPager(0);
            }
            this.f22075b.setViewPagerScrollable(false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22078e : invokeV.booleanValue;
    }

    public void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22075b.setShouldDrawTopLine(false);
            }
            this.f22075b.onChangeSkinType(i2);
            FragmentTabHost fragmentTabHost = this.f22075b;
            FragmentTabHost.b tabSpec = fragmentTabHost.getTabSpec(fragmentTabHost.getCurrentTabIndex());
            if (tabSpec != null && ((i3 = tabSpec.f45183a) == 22 || i3 == 23)) {
                if (this.f22075b.getFragmentTabWidget() != null) {
                    this.f22075b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                }
                this.f22075b.makeIndicatorDarkSkin(true);
                return;
            }
            if (this.f22075b.getFragmentTabWidget() != null) {
                this.f22075b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
            }
            this.f22075b.makeIndicatorDarkSkin(false);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            L();
            if (z() != null) {
                z().reset();
            }
            w();
            b.a.r0.f0.j jVar = this.f22082i;
            if (jVar != null) {
                jVar.h();
            }
            b.a.r0.z3.e eVar = this.j;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void G(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (fragmentTabHost = this.f22075b) == null) {
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
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f22074a.findViewById(R.id.tab_host);
            this.f22075b = fragmentTabHost;
            fragmentTabHost.setup(this.f22074a.getSupportFragmentManager());
            this.f22075b.setAbsoluteWeight(true);
            this.f22075b.setOnTabSelectionListener(this.s);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f22075b.setShouldDrawIndicatorLine(false);
                this.f22075b.setShouldDrawTopLine(true);
            }
            this.f22075b.setOnPageChangeListener(new n(this));
            this.f22077d = b.a.q0.s.e0.b.j().g("has_show_message_tab_tips", false);
            this.f22076c = (TextView) this.f22074a.findViewById(R.id.activity_prize_my_tip);
            this.f22075b.setUIType(0);
            this.f22075b.setTabContainerShadowShow(false);
            this.f22075b.setBackGroundStyle(0);
            this.f22075b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            b.a.r0.o3.g gVar = new b.a.r0.o3.g(this.f22074a, this.f22075b.getTabWrapper());
            this.r = gVar;
            gVar.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f22074a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f22074a.registerListener(this.x);
            }
            this.f22074a.registerListener(this.y);
            this.f22074a.registerListener(this.t);
            this.f22074a.registerListener(this.w);
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
            b.a.q0.s.e0.b.j().t("has_show_message_tab_tips", this.f22077d);
        }
    }

    public void M(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f22076c.setVisibility(8);
                return;
            }
            FragmentTabHost.b tabSpecByType = this.f22075b.getTabSpecByType(8);
            if (tabSpecByType != null) {
                if (this.f22080g && ((popupWindow = this.f22079f) == null || !popupWindow.isShowing())) {
                    N(str, tabSpecByType);
                    return;
                }
                if (this.z == null) {
                    this.z = new o(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.z);
                TbadkCoreApplication.getInst().handler.postDelayed(this.z, 5000L);
                return;
            }
            this.f22076c.setVisibility(8);
        }
    }

    public final void N(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f45184b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f45184b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22076c.getLayoutParams();
            layoutParams.rightMargin = (b.a.e.e.p.l.q(this.f22074a).widthPixels - width) - b.a.e.e.p.l.g(this.f22074a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f22076c.setLayoutParams(layoutParams);
            this.f22076c.setVisibility(0);
            this.f22076c.setText(str);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f22074a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new f(this));
            aVar.setNegativeButton(R.string.check, new g(this));
            aVar.create(this.f22074a.getPageContext()).show();
        }
    }

    public void P(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f22074a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f22074a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f22074a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f22074a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f22074a.getPageContext()).show();
        b.a.q0.s.e0.b.j().t("show_member_deid_line", false);
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.f22074a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.j == null) {
            MainTabActivity mainTabActivity = this.f22074a;
            this.j = new b.a.r0.z3.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.j.g(postWriteCallBackData);
    }

    public void R(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            if (this.f22082i == null) {
                this.f22082i = new b.a.r0.f0.j(this.f22074a.getPageContext(), (NavigationBarCoverTip) this.f22074a.findViewById(R.id.navigation_cover_tip));
            }
            this.f22082i.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f22078e = z;
            if (z) {
                return;
            }
            b.a.q0.s.e0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean u(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || b.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (b.a.q0.s.e0.b.j().g(b.a.q0.s.e0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f22074a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void v(b.a.q0.h0.b bVar, b.a.q0.h0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f45185c = cVar.f12612a;
            bVar2.f45183a = cVar.f12616e;
            maintabBottomIndicator.setShowIconType(cVar.f12620i);
            int i2 = cVar.f12620i;
            if (i2 == b.a.q0.h0.c.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == b.a.q0.h0.c.m) {
                maintabBottomIndicator.setText(cVar.f12613b);
                maintabBottomIndicator.setAnimationResId(cVar.f12617f);
                this.k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f12613b);
                maintabBottomIndicator.setAnimationResId(cVar.f12617f);
            }
            if (!b.a.e.e.p.k.isEmpty(cVar.f12618g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f12618g, cVar.f12614c);
            }
            b.a.q0.h0.e.a aVar = cVar.f12619h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f45183a == 2) {
                maintabBottomIndicator.isSelected = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f45184b = maintabBottomIndicator;
            bVar2.f45186d = bVar;
            this.f22075b.addTabSpec(bVar2, -1, z);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f22081h.removeCallbacks(this.A);
            this.f22081h.removeCallbacks(this.B);
            b.a.e.e.m.g.c(this.f22079f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f22075b : (FragmentTabHost) invokeV.objValue;
    }
}
