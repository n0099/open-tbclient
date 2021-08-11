package c.a.p0.l3;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.s.s.a;
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
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentTabHost.a A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public final ItemCardHelper.b D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public Runnable H;
    public Runnable I;
    public Runnable J;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f21514a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f21515b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21516c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21517d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21518e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21519f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21520g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21521h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21522i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f21523j;
    public TextView k;
    public boolean l;
    public int m;
    public boolean n;
    public PopupWindow o;
    public boolean p;
    public Handler q;
    public c.a.p0.e0.h r;
    public c.a.p0.w3.e s;
    public MaintabBottomIndicator t;
    public MaintabBottomIndicator u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21524a;

        /* renamed from: c.a.p0.l3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1003a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f21525e;

            public RunnableC1003a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f21525e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f21525e);
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
            this.f21524a = dVar;
        }

        public final void a(int i2) {
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f21524a.f21515b.getTabSpec(i2).f47341a == 2) {
                    m = TbPageExtraHelper.l(this.f21524a.f21514a.getPageContext().getContext());
                } else {
                    m = TbPageExtraHelper.m();
                }
                c.a.e.e.m.e.a().postDelayed(new RunnableC1003a(this, new CustomResponsedMessage(2921520, m)), 100L);
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = this.f21524a.f21515b.getTabSpec(i2).f47341a;
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
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.b tabSpec = this.f21524a.f21515b.getTabSpec(i2);
                if (tabSpec.f47341a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f21524a.f21514a.getPageContext(), null)) {
                    int i3 = tabSpec.f47341a;
                    if (i3 != 9) {
                        if (i3 == 8 && !ViewHelper.checkUpIsLogin(this.f21524a.f21514a.getActivity())) {
                            if (this.f21524a.t != null) {
                                this.f21524a.t.hideLottieView();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                            return false;
                        }
                        int i4 = tabSpec.f47341a;
                        if (i4 != 15) {
                            if (i4 == 3 && !ViewHelper.checkUpIsLogin(this.f21524a.f21514a.getActivity())) {
                                return false;
                            }
                            if (tabSpec.f47341a == 1) {
                                TiebaStatic.log(new StatisticItem("c13001"));
                            }
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f21524a.f21514a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new c.a.o0.u.j(0)));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x01bd, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r9) != false) goto L48;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b tabSpec = this.f21524a.f21515b.getTabSpec(i2);
                int i3 = tabSpec.f47341a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.f21524a.t != null && this.f21524a.t.getAnimationView() != null && this.f21524a.t.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.f21524a.t != null) {
                        this.f21524a.t.hideLottieView();
                    }
                    TiebaStatic.log("c13841");
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (tabSpec.f47341a == 2) {
                    if (this.f21524a.w) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.f21524a.w = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.f21524a.x != 2 || this.f21524a.v == i2 || homeBarShowType != 1 || this.f21524a.u == null) {
                        if (this.f21524a.x == 1 && this.f21524a.u != null) {
                            this.f21524a.u.playNormalAnimation(this.f21524a.w);
                        }
                    } else {
                        this.f21524a.u.playStaticAnimation();
                    }
                    this.f21524a.y = false;
                } else {
                    this.f21524a.y = true;
                    if (this.f21524a.w && this.f21524a.u != null) {
                        this.f21524a.u.playNormalAnimation(this.f21524a.w);
                    }
                    this.f21524a.w = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.f21524a.C() != null) {
                    this.f21524a.C().isSelectHome = this.f21524a.w;
                }
                if (!this.f21524a.w) {
                    c.a.p0.w0.a.i().r();
                }
                b(this.f21524a.v);
                a(this.f21524a.v);
                this.f21524a.v = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
                if (tabSpec.f47341a != 22) {
                    if (this.f21524a.f21515b.getFragmentTabWidget() != null) {
                        this.f21524a.f21515b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
                    }
                    this.f21524a.f21515b.makeIndicatorDarkSkin(false);
                } else {
                    TbFragmentTabIndicator tbFragmentTabIndicator = tabSpec.f47342b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("video_msg") != null && (maintabBottomIndicator.getTip("video_msg").f48176a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.getTip("video_msg").f48176a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i5 = 1;
                    if (this.f21524a.z) {
                        this.f21524a.z = false;
                    } else {
                        i4 = i5;
                    }
                    TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                    if (this.f21524a.f21515b.getTabSpec(this.f21524a.f21515b.getCurrentTabIndex()).f47341a != 22) {
                        if (this.f21524a.f21515b.getFragmentTabWidget() != null) {
                            this.f21524a.f21515b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                        }
                        this.f21524a.f21515b.makeIndicatorDarkSkin(true);
                        if (!c.a.e.e.p.j.z()) {
                            c.a.e.e.p.l.J(this.f21524a.f21514a, this.f21524a.f21514a.getResources().getString(R.string.neterror));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    }
                }
                if (tabSpec.f47341a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
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
        public final /* synthetic */ c.a.o0.s.s.a f21526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f21528g;

        public b(d dVar, c.a.o0.s.s.a aVar, int i2) {
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
            this.f21528g = dVar;
            this.f21526e = aVar;
            this.f21527f = i2;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21526e.dismiss();
                int i2 = this.f21527f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f21528g.f21514a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f21528g.f21514a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.a f21529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21530f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f21531g;

        public c(d dVar, c.a.o0.s.s.a aVar, int i2) {
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
            this.f21531g = dVar;
            this.f21529e = aVar;
            this.f21530f = i2;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21529e.dismiss();
                int i2 = this.f21530f;
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f21531g.f21514a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4006001000";
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f21531g.f21514a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    str = "4005001000";
                } else {
                    str = null;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f21531g.f21514a.getPageContext().getPageActivity(), 2);
                if (!StringUtils.isNULL(str)) {
                    memberPayActivityConfig.setSceneId(str);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* renamed from: c.a.p0.l3.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1004d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21532e;

        public View$OnClickListenerC1004d(d dVar) {
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
            this.f21532e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21532e.T(false);
                this.f21532e.f21520g.setVisibility(8);
                c.a.o0.s.d0.b.j().t("game_is_show_tip", false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, this.f21532e.f21514a.getPageContext()));
                TiebaStatic.eventStat(this.f21532e.f21514a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21533e;

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
            this.f21533e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21533e.f21514a.sendMessage(new CustomMessage(2015003, new IntentConfig(this.f21533e.f21514a.getPageContext().getPageActivity())));
                int i2 = 3;
                if (this.f21533e.f21515b.getCurrentTabType() != 3) {
                    i2 = this.f21533e.f21515b.getCurrentTabType() == 2 ? 1 : 0;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21534e;

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
                    return;
                }
            }
            this.f21534e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                this.f21534e.f21514a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f21534e.f21514a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21535e;

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
                    return;
                }
            }
            this.f21535e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f21535e.f21514a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.f21535e.f21514a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21536e;

        public h(d dVar) {
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
            this.f21536e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f21536e.f21514a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                int i2 = this.f21536e.m;
                TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
                ViewHelper.skipToRegisterActivity(this.f21536e.f21514a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21537e;

        public i(d dVar) {
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
            this.f21537e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21537e.f21515b == null || this.f21537e.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f21537e.f21515b.getFragmentTabWidget();
            c.a.e.e.p.l.k(this.f21537e.f21514a.getActivity());
            int g2 = c.a.e.e.p.l.g(this.f21537e.f21514a.getActivity(), R.dimen.ds178);
            View contentView = this.f21537e.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b tabSpecByType = this.f21537e.f21515b.getTabSpecByType(3);
            if (tabSpecByType == null || (tbFragmentTabIndicator = tabSpecByType.f47342b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = c.a.e.e.p.l.g(this.f21537e.f21514a.getActivity(), R.dimen.tbds570);
            }
            c.a.e.e.m.g.l(this.f21537e.o, fragmentTabWidget, measuredWidth2, -g2);
            c.a.o0.s.d0.b.j().t("show_maintab_last_message_tips", true);
            this.f21537e.p = true;
            this.f21537e.q.postDelayed(this.f21537e.J, 5000L);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21538e;

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
            this.f21538e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21538e.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(d dVar) {
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

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
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
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(d dVar) {
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

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                c.a.p0.c1.a.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21539a;

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
            this.f21539a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.o0.g0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f21539a.f21515b == null || !(customResponsedMessage.getData() instanceof c.a.o0.g0.c) || (cVar = (c.a.o0.g0.c) customResponsedMessage.getData()) == null || this.f21539a.f21515b.getTabSpecByType(cVar.f13189e) == null || this.f21539a.f21515b.getCurrentTabType() == cVar.f13189e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.f21539a.f21515b.getTabSpecByType(cVar.f13189e).f47342b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f13191g, cVar.f13187c);
                if (TextUtils.isEmpty(cVar.f13191g)) {
                    return;
                }
                this.f21539a.z = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21540a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(d dVar, int i2) {
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
            this.f21540a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.j(this.f21540a.f21514a, this.f21540a.f21514a.getUniqueId(), (View) customResponsedMessage.getData(), this.f21540a.f21514a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21541a;

        public o(d dVar) {
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
            this.f21541a = dVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f21541a.f21514a, ItemCardHelper.OrderTipStatus.FAIL, this.f21541a.f21514a.getActivityRootView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f21541a.f21514a, ItemCardHelper.OrderTipStatus.SUCCESS, this.f21541a.f21514a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21542a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(d dVar, int i2) {
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
            this.f21542a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.o0.g0.e.a c2;
            c.a.o0.g0.e.a c3;
            c.a.o0.g0.e.a c4;
            c.a.o0.g0.e.a c5;
            c.a.o0.g0.e.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f21542a.f21515b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b tabSpecByType = this.f21542a.f21515b.getTabSpecByType(2);
                if (tabSpecByType != null && (tabSpecByType.f47342b instanceof MaintabBottomIndicator) && (c6 = c.a.o0.g0.e.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType.f47342b).setDynamicIconData(c6);
                }
                FragmentTabHost.b tabSpecByType2 = this.f21542a.f21515b.getTabSpecByType(1);
                if (tabSpecByType2 != null && (tabSpecByType2.f47342b instanceof MaintabBottomIndicator) && (c5 = c.a.o0.g0.e.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType2.f47342b).setDynamicIconData(c5);
                }
                FragmentTabHost.b tabSpecByType3 = this.f21542a.f21515b.getTabSpecByType(22);
                if (tabSpecByType3 != null && (tabSpecByType3.f47342b instanceof MaintabBottomIndicator) && (c4 = c.a.o0.g0.e.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType3.f47342b).setDynamicIconData(c4);
                }
                FragmentTabHost.b tabSpecByType4 = this.f21542a.f21515b.getTabSpecByType(3);
                if (tabSpecByType4 != null && (tabSpecByType4.f47342b instanceof MaintabBottomIndicator) && (c3 = c.a.o0.g0.e.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) tabSpecByType4.f47342b).setDynamicIconData(c3);
                }
                FragmentTabHost.b tabSpecByType5 = this.f21542a.f21515b.getTabSpecByType(8);
                if (tabSpecByType5 == null || !(tabSpecByType5.f47342b instanceof MaintabBottomIndicator) || (c2 = c.a.o0.g0.e.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) tabSpecByType5.f47342b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(d dVar, int i2) {
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
            this.f21543a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f21543a.C() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    this.f21543a.y = true;
                    this.f21543a.w = true;
                    if (this.f21543a.x != 2) {
                        if (this.f21543a.u == null || !this.f21543a.u.isAnimating()) {
                            return;
                        }
                        this.f21543a.u.playNormalAnimation(this.f21543a.w);
                        return;
                    }
                    this.f21543a.C().playLoadedAnimation();
                    return;
                }
                if (intValue == 6) {
                    this.f21543a.y = false;
                    if (this.f21543a.x == 1) {
                        return;
                    }
                } else {
                    this.f21543a.x = intValue;
                }
                if (this.f21543a.x == 1) {
                    this.f21543a.C().playNormalAnimation(this.f21543a.w);
                } else if (this.f21543a.x == 2) {
                    this.f21543a.C().playStaticAnimation();
                } else if (intValue == 5) {
                    this.f21543a.x = 1;
                    this.f21543a.w = true;
                    if (!this.f21543a.y) {
                        this.f21543a.C().playLoadedAnimation();
                    }
                } else {
                    this.f21543a.C().playDynamicAnimation();
                }
                this.f21543a.C().isHomePageIndicator = true;
                this.f21543a.C().iconStatus = this.f21543a.x;
                this.f21543a.C().isSelectHome = this.f21543a.w;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f21544a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(d dVar, int i2) {
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
            this.f21544a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f21544a.w = true;
                if (this.f21544a.C() != null) {
                    this.f21544a.C().isSelectHome = this.f21544a.w;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f21545e;

        public s(d dVar) {
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
            this.f21545e = dVar;
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
                if (this.f21545e.f21515b.getCurrentTabType() != 2) {
                    if (this.f21545e.f21515b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                this.f21545e.R();
                if (this.f21545e.f21515b.getCurrentTabType() != this.f21545e.f21515b.getTabSpec(i2).f47341a) {
                    this.f21545e.f21515b.setCurrentTab(i2);
                }
                if (this.f21545e.f21515b.getCurrentTabType() != 1) {
                    this.f21545e.f21518e.setVisibility(8);
                    this.f21545e.f21521h.setVisibility(0);
                }
                if (this.f21545e.f21515b.getCurrentTabType() == 1 && !c.a.o0.s.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d dVar = this.f21545e;
                dVar.m = dVar.f21515b.getCurrentTabType();
                this.f21545e.U();
                if (c.a.o0.s.d0.b.j().g("enter_forum_edit_mode", false)) {
                    if (this.f21545e.f21515b.getCurrentTabType() != 3) {
                        if (this.f21545e.f21515b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.f21545e.f21515b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f21547f;

        public t(d dVar, String str) {
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
            this.f21547f = dVar;
            this.f21546e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21547f.W(this.f21546e);
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
        this.l = false;
        this.m = -1;
        this.p = false;
        this.q = new Handler();
        this.v = 0;
        this.w = true;
        this.x = 1;
        this.y = false;
        this.z = false;
        this.A = new a(this);
        this.B = new m(this, 2921492);
        this.C = new n(this, 2001440);
        this.D = new o(this);
        this.E = new p(this, 2921551);
        this.F = new q(this, 2921382);
        this.G = new r(this, 2921410);
        this.I = new i(this);
        this.J = new j(this);
        this.f21514a = mainTabActivity;
    }

    public final void A(c.a.o0.g0.b bVar, c.a.o0.g0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f47343c = cVar.f13185a;
            bVar2.f47341a = cVar.f13189e;
            maintabBottomIndicator.setShowIconType(cVar.f13193i);
            int i2 = cVar.f13193i;
            if (i2 == c.a.o0.g0.c.f13184j) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == c.a.o0.g0.c.m) {
                maintabBottomIndicator.setText(cVar.f13186b);
                maintabBottomIndicator.setAnimationResId(cVar.f13190f);
                this.t = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f13186b);
                maintabBottomIndicator.setAnimationResId(cVar.f13190f);
            }
            if (!c.a.e.e.p.k.isEmpty(cVar.f13191g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f13191g, cVar.f13187c);
            }
            c.a.o0.g0.e.a aVar = cVar.f13192h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.f47341a == 2) {
                maintabBottomIndicator.isSelected = true;
                this.u = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f47342b = maintabBottomIndicator;
            bVar2.f47344d = bVar;
            this.f21515b.addTabSpec(bVar2, -1, z);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.removeCallbacks(this.I);
            this.q.removeCallbacks(this.J);
            c.a.e.e.m.g.c(this.o);
        }
    }

    public MaintabBottomIndicator C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21515b : (FragmentTabHost) invokeV.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageView imageView = this.f21523j;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f21514a.findViewById(R.id.view_navigation_bar);
            this.f21516c = navigationBar;
            if (navigationBar != null) {
                this.f21517d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f21514a.getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(dimension, dimension, 0, dimension);
                this.f21517d.setLayoutParams(layoutParams);
                View addCustomView = this.f21516c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
                this.f21519f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
                this.f21520g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
                this.f21519f.setOnClickListener(new View$OnClickListenerC1004d(this));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(0, 0, c.a.e.e.p.l.g(this.f21514a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
                ImageView imageView = (ImageView) this.f21516c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
                this.f21521h = imageView;
                imageView.setLayoutParams(layoutParams2);
                this.f21521h.setVisibility(8);
                this.f21521h.setOnClickListener(new e(this));
                ImageView imageView2 = (ImageView) this.f21516c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
                this.f21518e = imageView2;
                imageView2.setLayoutParams(layoutParams2);
                this.f21518e.setVisibility(8);
                this.f21518e.setOnClickListener(new f(this));
                this.f21516c.setLoginClickListener(new g(this));
                this.f21516c.setRegisterClickListener(new h(this));
            }
        }
    }

    public void H(ArrayList<c.a.o0.g0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            this.f21515b.reset();
            Iterator<c.a.o0.g0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.o0.g0.b next = it.next();
                if (next != null && next.isAvailable()) {
                    A(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f21514a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f21515b.initViewPager(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f21515b.initViewPager(1);
            } else {
                this.f21515b.initViewPager(0);
            }
            this.f21515b.setViewPagerScrollable(false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.y = false;
            this.x = 1;
            if (C() != null) {
                C().iconStatus = this.x;
            }
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageView imageView = this.f21519f;
            return imageView != null && imageView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f21515b.setShouldDrawTopLine(false);
            }
            this.f21515b.onChangeSkinType(i2);
            FragmentTabHost fragmentTabHost = this.f21515b;
            FragmentTabHost.b tabSpec = fragmentTabHost.getTabSpec(fragmentTabHost.getCurrentTabIndex());
            if (tabSpec != null && tabSpec.f47341a == 22) {
                if (this.f21515b.getFragmentTabWidget() != null) {
                    this.f21515b.getFragmentTabWidget().makeWidgetDarkSkin(true, R.color.CAM_X0215);
                }
                this.f21515b.makeIndicatorDarkSkin(true);
            } else {
                if (this.f21515b.getFragmentTabWidget() != null) {
                    this.f21515b.getFragmentTabWidget().makeWidgetDarkSkin(false, R.color.CAM_X0207);
                }
                this.f21515b.makeIndicatorDarkSkin(false);
            }
            this.f21516c.onChangeSkinType(this.f21514a.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.f21517d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
            SkinManager.setImageResource(this.f21520g, R.drawable.icon_news_down_bar_one);
            SkinManager.setNavbarIconSrc(this.f21519f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21521h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21518e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            V();
            if (E() != null) {
                E().reset();
            }
            B();
            c.a.p0.e0.h hVar = this.r;
            if (hVar != null) {
                hVar.h();
            }
            c.a.p0.w3.e eVar = this.s;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void N(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (fragmentTabHost = this.f21515b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.hideTabWidget();
            F();
            return;
        }
        fragmentTabHost.showTabWidget();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ItemCardHelper.s(this.D);
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f21514a.findViewById(R.id.tab_host);
            this.f21515b = fragmentTabHost;
            fragmentTabHost.setup(this.f21514a.getSupportFragmentManager());
            this.f21515b.setAbsoluteWeight(true);
            this.f21515b.setOnTabSelectionListener(this.A);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f21515b.setShouldDrawIndicatorLine(false);
                this.f21515b.setShouldDrawTopLine(true);
            }
            this.f21515b.setOnPageChangeListener(new s(this));
            this.l = c.a.o0.s.d0.b.j().g("has_show_message_tab_tips", false);
            G();
            this.f21523j = (ImageView) this.f21514a.findViewById(R.id.home_page_new_write_icon);
            this.k = (TextView) this.f21514a.findViewById(R.id.view_bottom_text);
            this.f21522i = (TextView) this.f21514a.findViewById(R.id.activity_prize_my_tip);
            this.f21515b.setUIType(0);
            this.f21515b.setTabContainerShadowShow(false);
            this.f21515b.setBackGroundStyle(0);
            this.f21515b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            F();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f21514a.getPageContext()));
            f0(z);
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.f21514a.registerListener(this.F);
            }
            this.f21514a.registerListener(this.G);
            this.f21514a.registerListener(this.B);
            this.f21514a.registerListener(this.E);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    public void R() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (fragmentTabHost = this.f21515b) == null) {
            return;
        }
        if (fragmentTabHost.getCurrentTabType() == 8 || this.f21515b.getCurrentTabType() == 3 || this.f21515b.getCurrentTabType() == 2 || this.f21515b.getCurrentTabType() == 15 || this.f21515b.getCurrentTabType() == 1) {
            NavigationBar navigationBar = this.f21516c;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            this.f21521h.setVisibility(8);
        }
    }

    public void S(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            E().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.y = true;
                if (this.w && (maintabBottomIndicator = this.u) != null) {
                    maintabBottomIndicator.playNormalAnimation(false);
                }
                this.w = false;
                if (C() != null) {
                    C().isSelectHome = this.w;
                }
            }
        }
    }

    public final void T(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (layoutParams = (FrameLayout.LayoutParams) this.f21519f.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.rightMargin = c.a.e.e.p.l.g(this.f21514a.getPageContext().getPageActivity(), R.dimen.ds32);
        } else {
            layoutParams.rightMargin = c.a.e.e.p.l.g(this.f21514a.getPageContext().getPageActivity(), R.dimen.ds20);
        }
        this.f21519f.setLayoutParams(layoutParams);
    }

    public void U() {
        FragmentTabHost fragmentTabHost;
        FragmentTabHost.b tabSpecByType;
        c.a.o0.g0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fragmentTabHost = this.f21515b) == null || (tabSpecByType = fragmentTabHost.getTabSpecByType(fragmentTabHost.getCurrentTabType())) == null || (bVar = tabSpecByType.f47344d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f21514a.getPageContext().getString(tabSpecByType.f47344d.getFragmentTabStructure().f13186b);
        TextView textView = this.f21517d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.o0.s.d0.b.j().t("has_show_message_tab_tips", this.l);
        }
    }

    public void W(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f21522i.setVisibility(8);
                return;
            }
            FragmentTabHost.b tabSpecByType = this.f21515b.getTabSpecByType(8);
            if (tabSpecByType != null) {
                if (this.p && ((popupWindow = this.o) == null || !popupWindow.isShowing())) {
                    X(str, tabSpecByType);
                    return;
                }
                if (this.H == null) {
                    this.H = new t(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.H);
                TbadkCoreApplication.getInst().handler.postDelayed(this.H, 5000L);
                return;
            }
            this.f21522i.setVisibility(8);
        }
    }

    public final void X(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f47342b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f47342b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21522i.getLayoutParams();
            layoutParams.rightMargin = (c.a.e.e.p.l.q(this.f21514a).widthPixels - width) - c.a.e.e.p.l.g(this.f21514a.getPageContext().getPageActivity(), R.dimen.ds26);
            this.f21522i.setLayoutParams(layoutParams);
            this.f21522i.setVisibility(0);
            this.f21522i.setText(str);
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f21514a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.close, new k(this));
            aVar.setNegativeButton(R.string.check, new l(this));
            aVar.create(this.f21514a.getPageContext()).show();
        }
    }

    public void Z(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (imageView = this.f21519f) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && J()) {
            if (z) {
                if (this.f21520g.getVisibility() != 0) {
                    this.f21520g.setVisibility(0);
                    T(true);
                    SkinManager.setImageResource(this.f21520g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            T(false);
            this.f21520g.setVisibility(8);
        }
    }

    public void b0(PayMemberInfoData payMemberInfoData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048603, this, payMemberInfoData, i2) == null) || payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f21514a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.x())) {
            textView.setText(payMemberInfoData.x());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setIsNight(z);
        } else {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
        }
        c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f21514a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new b(this, aVar, i2));
        String string = this.f21514a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f21514a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new c(this, aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f21514a.getPageContext()).show();
        c.a.o0.s.d0.b.j().t("show_member_deid_line", false);
    }

    public void c0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.s == null) {
                MainTabActivity mainTabActivity = this.f21514a;
                this.s = new c.a.p0.w3.e(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.s.g(postWriteCallBackData);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.f21518e.setVisibility(0);
                this.f21521h.setVisibility(8);
                return;
            }
            this.f21518e.setVisibility(8);
            this.f21521h.setVisibility(0);
        }
    }

    public void e0(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, postWriteCallBackData) == null) {
            if (this.r == null) {
                this.r = new c.a.p0.e0.h(this.f21514a.getPageContext(), (NavigationBarCoverTip) this.f21514a.findViewById(R.id.navigation_cover_tip));
            }
            this.r.l(postWriteCallBackData);
        }
    }

    public void f0(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (navigationBar = this.f21516c) == null) {
            return;
        }
        navigationBar.switchNaviBarStatus(z);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.n = z;
            if (z) {
                return;
            }
            c.a.o0.s.d0.b.j().t("enter_forum_edit_mode", false);
        }
    }

    public boolean z(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.e.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.o0.s.d0.b.j().g(c.a.o0.s.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f21514a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
