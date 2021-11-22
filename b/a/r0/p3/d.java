package b.a.r0.p3;

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
    public MainTabActivity f23941a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f23942b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23943c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23945e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f23946f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23947g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f23948h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.f0.j f23949i;
    public b.a.r0.a4.e j;
    public MaintabBottomIndicator k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public b.a.r0.p3.g r;
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
        public final /* synthetic */ d f23950a;

        /* renamed from: b.a.r0.p3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1161a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f23951e;

            public RunnableC1161a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f23951e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f23951e);
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
            this.f23950a = dVar;
        }

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            b.a.q0.h0.c cVar = new b.a.q0.h0.c();
            cVar.f13365g = redIcon.image;
            cVar.f13363e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }

        public final void b(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (this.f23950a.f23942b.getTabSpec(i2).f46033a == 2) {
                    m = TbPageExtraHelper.l(this.f23950a.f23941a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                b.a.e.f.m.e.a().postDelayed(new RunnableC1161a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.f23950a.f23942b.getTabSpec(i2).f46033a;
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
                FragmentTabHost.b tabSpec = this.f23950a.f23942b.getTabSpec(i2);
                if (tabSpec.f46033a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f23950a.f23941a.getPageContext(), null)) {
                    int i3 = tabSpec.f46033a;
                    if (i3 == 9) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new b.a.q0.u.k(0)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                        return false;
                    } else if (i3 == 8 && !b.a.q0.b.d.E() && !ViewHelper.checkUpIsLogin(this.f23950a.f23941a.getActivity())) {
                        if (this.f23950a.k != null) {
                            this.f23950a.k.hideLottieView();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                        return false;
                    } else {
                        int i4 = tabSpec.f46033a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f23950a.f23941a.getActivity())) {
                                return false;
                            }
                            if (tabSpec.f46033a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f23950a.f23941a.getPageContext(), new String[]{(String) runTask.getData()}, true);
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
                FragmentTabHost.b tabSpec = this.f23950a.f23942b.getTabSpec(i2);
                int i3 = tabSpec.f46033a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.f23950a.k != null && this.f23950a.k.getAnimationView() != null && this.f23950a.k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f23950a.k != null) {
                        this.f23950a.k.hideLottieView();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (tabSpec.f46033a == 2) {
                    if (this.f23950a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f23950a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f23950a.o != 2 || this.f23950a.m == i2 || homeBarShowType != 1 || this.f23950a.l == null) {
                        if (this.f23950a.o == 1 && this.f23950a.l != null) {
                            this.f23950a.l.playNormalAnimation(this.f23950a.n);
                        }
                    } else {
                        this.f23950a.l.playStaticAnimation();
                    }
                    this.f23950a.p = false;
                } else {
                    this.f23950a.p = true;
                    if (this.f23950a.n && this.f23950a.l != null) {
                        this.f23950a.l.playNormalAnimation(this.f23950a.n);
                    }
                    this.f23950a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f23950a.x() != null) {
                    this.f23950a.x().isSelectHome = this.f23950a.n;
                }
                if (!this.f23950a.n) {
                    b.a.r0.y0.a.i().r();
                }
                c(this.f23950a.m);
                b(this.f23950a.m);
                this.f23950a.m = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (tabSpec.f46033a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = tabSpec.f46034b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("video_msg") != null && (maintabBottomIndicator.getTip("video_msg").f46823a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.getTip("video_msg").f46823a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.f23950a.q) {
                        this.f23950a.q = false;
                    } else {
                        i4 = i5;
                    }
                    if (z && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    }
                    if (this.f23950a.f23942b.getTabSpec(this.f23950a.f23942b.getCurrentTabIndex()) == null || this.f23950a.f23942b.getTabSpec(this.f23950a.f23942b.getCurrentTabIndex()).f46033a != 22) {
                        if (this.f23950a.f23942b.getFragmentTabWidget() != null) {
                            this.f23950a.f23942b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                        }
                        this.f23950a.f23942b.makeIndicatorDarkSkin(true);
                        if (!b.a.e.f.p.j.z()) {
                            b.a.e.f.p.l.J(this.f23950a.f23941a, this.f23950a.f23941a.getResources().getString(R.string.neterror));
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
                        this.f23950a.f23942b.refreshVideoFragment(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    if (this.f23950a.f23942b.getFragmentTabWidget() != null) {
                        this.f23950a.f23942b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
                    }
                    this.f23950a.f23942b.makeIndicatorDarkSkin(false);
                }
                if (tabSpec.f46033a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                int i6 = tabSpec.f46033a;
                if (i6 == 22 || i6 == 23) {
                    this.f23950a.r.g(true);
                } else {
                    this.f23950a.r.g(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f23954g;

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
            this.f23954g = dVar;
            this.f23952e = aVar;
            this.f23953f = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23952e.dismiss();
                int i2 = this.f23953f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f23954g.f23941a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f23954g.f23941a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f23955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23956f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f23957g;

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
            this.f23957g = dVar;
            this.f23955e = aVar;
            this.f23956f = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23955e.dismiss();
                int i2 = this.f23956f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f23957g.f23941a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f23957g.f23941a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f23957g.f23941a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: b.a.r0.p3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1162d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23958e;

        public RunnableC1162d(d dVar) {
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
            this.f23958e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23958e.f23942b == null || this.f23958e.f23946f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f23958e.f23942b.getFragmentTabWidget();
            b.a.e.f.p.l.k(this.f23958e.f23941a.getActivity());
            int g2 = b.a.e.f.p.l.g(this.f23958e.f23941a.getActivity(), R.dimen.ds178);
            View contentView = this.f23958e.f23946f.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b tabSpecByType = this.f23958e.f23942b.getTabSpecByType(3);
            if (tabSpecByType == null || (tbFragmentTabIndicator = tabSpecByType.f46034b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = b.a.e.f.p.l.g(this.f23958e.f23941a.getActivity(), R.dimen.tbds570);
            }
            b.a.e.f.m.g.l(this.f23958e.f23946f, fragmentTabWidget, measuredWidth2, -g2);
            b.a.q0.s.e0.b.j().t("show_maintab_last_message_tips", true);
            this.f23958e.f23947g = true;
            this.f23958e.f23948h.postDelayed(this.f23958e.B, 5000L);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23959e;

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
            this.f23959e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23959e.w();
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
        public final /* synthetic */ d f23960a;

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
            this.f23960a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.q0.h0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f23960a.f23942b == null || !(customResponsedMessage.getData() instanceof b.a.q0.h0.c) || (cVar = (b.a.q0.h0.c) customResponsedMessage.getData()) == null || this.f23960a.f23942b.getTabSpecByType(cVar.f13363e) == null || this.f23960a.f23942b.getCurrentTabType() == cVar.f13363e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f23960a.f23942b.getTabSpecByType(cVar.f13363e).f46034b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f13365g, cVar.f13361c);
                if (TextUtils.isEmpty(cVar.f13365g)) {
                    return;
                }
                this.f23960a.q = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23961a;

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
            this.f23961a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f23961a.f23941a, this.f23961a.f23941a.getUniqueId(), (View) customResponsedMessage.getData(), this.f23961a.f23941a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23962a;

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
            this.f23962a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.f23962a.f23941a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f23962a.f23941a.getActivityRootView(), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f23962a.f23941a, ItemCardHelper.OrderTipStatus.FAIL, this.f23962a.f23941a.getActivityRootView(), 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23963a;

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
            this.f23963a = dVar;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f23963a.f23942b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b tabSpecByType = this.f23963a.f23942b.getTabSpecByType(2);
                if (tabSpecByType != null && (tabSpecByType.f46034b instanceof MaintabBottomIndicator) && (c6 = b.a.q0.h0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType.f46034b).setDynamicIconData(c6);
                }
                FragmentTabHost.b tabSpecByType2 = this.f23963a.f23942b.getTabSpecByType(1);
                if (tabSpecByType2 != null && (tabSpecByType2.f46034b instanceof MaintabBottomIndicator) && (c5 = b.a.q0.h0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType2.f46034b).setDynamicIconData(c5);
                }
                FragmentTabHost.b tabSpecByType3 = this.f23963a.f23942b.getTabSpecByType(22);
                if (tabSpecByType3 != null && (tabSpecByType3.f46034b instanceof MaintabBottomIndicator) && (c4 = b.a.q0.h0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType3.f46034b).setDynamicIconData(c4);
                }
                FragmentTabHost.b tabSpecByType4 = this.f23963a.f23942b.getTabSpecByType(3);
                if (tabSpecByType4 != null && (tabSpecByType4.f46034b instanceof MaintabBottomIndicator) && (c3 = b.a.q0.h0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType4.f46034b).setDynamicIconData(c3);
                }
                FragmentTabHost.b tabSpecByType5 = this.f23963a.f23942b.getTabSpecByType(8);
                if (tabSpecByType5 == null || !(tabSpecByType5.f46034b instanceof MaintabBottomIndicator) || (c2 = b.a.q0.h0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) tabSpecByType5.f46034b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23964a;

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
            this.f23964a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f23964a.x() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f23964a.p = true;
                    this.f23964a.n = true;
                    if (this.f23964a.o != 2) {
                        if (this.f23964a.l == null || !this.f23964a.l.isAnimating()) {
                            return;
                        }
                        this.f23964a.l.playNormalAnimation(this.f23964a.n);
                        return;
                    }
                    this.f23964a.x().playLoadedAnimation();
                    return;
                }
                if (intValue == 6) {
                    this.f23964a.p = false;
                    if (this.f23964a.o == 1) {
                        return;
                    }
                } else {
                    this.f23964a.o = intValue;
                }
                if (this.f23964a.o == 1) {
                    this.f23964a.x().playNormalAnimation(this.f23964a.n);
                } else if (this.f23964a.o == 2) {
                    this.f23964a.x().playStaticAnimation();
                } else if (intValue == 5) {
                    this.f23964a.o = 1;
                    this.f23964a.n = true;
                    if (!this.f23964a.p) {
                        this.f23964a.x().playLoadedAnimation();
                    }
                } else {
                    this.f23964a.x().playDynamicAnimation();
                }
                this.f23964a.x().isHomePageIndicator = true;
                this.f23964a.x().iconStatus = this.f23964a.o;
                this.f23964a.x().isSelectHome = this.f23964a.n;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23965a;

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
            this.f23965a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f23965a.n = true;
                if (this.f23965a.x() != null) {
                    this.f23965a.x().isSelectHome = this.f23965a.n;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23966e;

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
            this.f23966e = dVar;
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
                if (this.f23966e.f23942b.getCurrentTabType() != 2) {
                    if (this.f23966e.f23942b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.f23966e.f23942b.getCurrentTabType() != this.f23966e.f23942b.getTabSpec(i2).f46033a) {
                    this.f23966e.f23942b.setCurrentTab(i2);
                }
                if (this.f23966e.f23942b.getCurrentTabType() == 1 && !b.a.q0.s.e0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (b.a.q0.s.e0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f23966e.f23942b.getCurrentTabType() != 3) {
                        if (this.f23966e.f23942b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f23966e.f23942b.getCurrentTabType() == 3) {
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
        public final /* synthetic */ String f23967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23968f;

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
            this.f23968f = dVar;
            this.f23967e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23968f.M(this.f23967e);
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
        this.f23944d = false;
        this.f23947g = false;
        this.f23948h = new Handler();
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
        this.A = new RunnableC1162d(this);
        this.B = new e(this);
        this.f23941a = mainTabActivity;
    }

    public SeekBar A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.p3.g gVar = this.r;
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
            this.f23942b.reset();
            Iterator<b.a.q0.h0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.q0.h0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    v(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f23941a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f23942b.initViewPager(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f23942b.initViewPager(1);
            } else {
                this.f23942b.initViewPager(0);
            }
            this.f23942b.setViewPagerScrollable(false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23945e : invokeV.booleanValue;
    }

    public void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f23942b.setShouldDrawTopLine(false);
            }
            this.f23942b.onChangeSkinType(i2);
            FragmentTabHost fragmentTabHost = this.f23942b;
            FragmentTabHost.b tabSpec = fragmentTabHost.getTabSpec(fragmentTabHost.getCurrentTabIndex());
            if (tabSpec != null && ((i3 = tabSpec.f46033a) == 22 || i3 == 23)) {
                if (this.f23942b.getFragmentTabWidget() != null) {
                    this.f23942b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                }
                this.f23942b.makeIndicatorDarkSkin(true);
                return;
            }
            if (this.f23942b.getFragmentTabWidget() != null) {
                this.f23942b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
            }
            this.f23942b.makeIndicatorDarkSkin(false);
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
            b.a.r0.f0.j jVar = this.f23949i;
            if (jVar != null) {
                jVar.h();
            }
            b.a.r0.a4.e eVar = this.j;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void G(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (fragmentTabHost = this.f23942b) == null) {
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
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f23941a.findViewById(R.id.tab_host);
            this.f23942b = fragmentTabHost;
            fragmentTabHost.setup(this.f23941a.getSupportFragmentManager());
            this.f23942b.setAbsoluteWeight(true);
            this.f23942b.setOnTabSelectionListener(this.s);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f23942b.setShouldDrawIndicatorLine(false);
                this.f23942b.setShouldDrawTopLine(true);
            }
            this.f23942b.setOnPageChangeListener(new n(this));
            this.f23944d = b.a.q0.s.e0.b.j().g("has_show_message_tab_tips", false);
            this.f23943c = (TextView) this.f23941a.findViewById(R.id.activity_prize_my_tip);
            this.f23942b.setUIType(0);
            this.f23942b.setTabContainerShadowShow(false);
            this.f23942b.setBackGroundStyle(0);
            this.f23942b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            b.a.r0.p3.g gVar = new b.a.r0.p3.g(this.f23941a, this.f23942b.getTabWrapper());
            this.r = gVar;
            gVar.g(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f23941a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f23941a.registerListener(this.x);
            }
            this.f23941a.registerListener(this.y);
            this.f23941a.registerListener(this.t);
            this.f23941a.registerListener(this.w);
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
            b.a.q0.s.e0.b.j().t("has_show_message_tab_tips", this.f23944d);
        }
    }

    public void M(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f23943c.setVisibility(8);
                return;
            }
            FragmentTabHost.b tabSpecByType = this.f23942b.getTabSpecByType(8);
            if (tabSpecByType != null) {
                if (this.f23947g && ((popupWindow = this.f23946f) == null || !popupWindow.isShowing())) {
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
            this.f23943c.setVisibility(8);
        }
    }

    public final void N(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f46034b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f46034b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23943c.getLayoutParams();
            layoutParams.rightMargin = (b.a.e.f.p.l.q(this.f23941a).widthPixels - width) - b.a.e.f.p.l.g(this.f23941a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f23943c.setLayoutParams(layoutParams);
            this.f23943c.setVisibility(0);
            this.f23943c.setText(str);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23941a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new f(this));
            aVar.setNegativeButton(R.string.check, new g(this));
            aVar.create(this.f23941a.getPageContext()).show();
        }
    }

    public void P(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f23941a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f23941a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f23941a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f23941a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f23941a.getPageContext()).show();
        b.a.q0.s.e0.b.j().t("show_member_deid_line", false);
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.f23941a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.j == null) {
            MainTabActivity mainTabActivity = this.f23941a;
            this.j = new b.a.r0.a4.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.j.g(postWriteCallBackData);
    }

    public void R(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            if (this.f23949i == null) {
                this.f23949i = new b.a.r0.f0.j(this.f23941a.getPageContext(), (NavigationBarCoverTip) this.f23941a.findViewById(R.id.navigation_cover_tip));
            }
            this.f23949i.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f23945e = z;
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
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || b.a.e.f.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (b.a.q0.s.e0.b.j().g(b.a.q0.s.e0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f23941a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
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
            bVar2.f46035c = cVar.f13359a;
            bVar2.f46033a = cVar.f13363e;
            maintabBottomIndicator.setShowIconType(cVar.f13367i);
            int i2 = cVar.f13367i;
            if (i2 == b.a.q0.h0.c.j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == b.a.q0.h0.c.m) {
                maintabBottomIndicator.setText(cVar.f13360b);
                maintabBottomIndicator.setAnimationResId(cVar.f13364f);
                this.k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f13360b);
                maintabBottomIndicator.setAnimationResId(cVar.f13364f);
            }
            if (!b.a.e.f.p.k.isEmpty(cVar.f13365g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f13365g, cVar.f13361c);
            }
            b.a.q0.h0.e.a aVar = cVar.f13366h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f46033a == 2) {
                maintabBottomIndicator.isSelected = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f46034b = maintabBottomIndicator;
            bVar2.f46036d = bVar;
            this.f23942b.addTabSpec(bVar2, -1, z);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f23948h.removeCallbacks(this.A);
            this.f23948h.removeCallbacks(this.B);
            b.a.e.f.m.g.c(this.f23946f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f23942b : (FragmentTabHost) invokeV.objValue;
    }
}
