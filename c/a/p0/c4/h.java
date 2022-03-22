package c.a.p0.c4;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.r.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public Runnable B;
    public MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f13540b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13541c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13542d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13543e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f13544f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13545g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f13546h;
    public c.a.p0.l0.j i;
    public c.a.p0.n4.e j;
    public MaintabBottomIndicator k;
    public MaintabBottomIndicator l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public c.a.p0.c4.o r;
    public FragmentTabHost.a s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public final ItemCardHelper.c v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public Runnable z;

    /* loaded from: classes2.dex */
    public class a implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: c.a.p0.c4.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1018a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC1018a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

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

        public final void a(RedIcon redIcon) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, redIcon) == null) || redIcon == null) {
                return;
            }
            c.a.o0.h0.c cVar = new c.a.o0.h0.c();
            cVar.f10301g = redIcon.image;
            cVar.f10299e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }

        public final void b(int i) {
            String prePageKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.a.f13540b.i(i).a == 2) {
                    prePageKey = TbPageExtraHelper.getCurrentVisiblePageKey(this.a.a.getPageContext().getContext());
                } else {
                    prePageKey = TbPageExtraHelper.getPrePageKey();
                }
                c.a.d.f.m.e.a().postDelayed(new RunnableC1018a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
            }
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                int i2 = this.a.f13540b.i(i).a;
                if (i2 == 8) {
                    TbPageExtraHelper.setPrePageKey("a011");
                } else if (i2 == 2) {
                    TbPageExtraHelper.setPrePageKey("a002");
                } else if (i2 == 3) {
                    TbPageExtraHelper.setPrePageKey("a079");
                } else if (i2 == 1) {
                    TbPageExtraHelper.setPrePageKey("a025");
                } else if (i2 == 21) {
                    TbPageExtraHelper.setPrePageKey("a075");
                } else if (i2 == 22) {
                    TbPageExtraHelper.setPrePageKey("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.b i2 = this.a.f13540b.i(i);
                if (i2.a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.a.getPageContext(), null)) {
                    int i3 = i2.a;
                    if (i3 == 9) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new c.a.o0.t.m(0)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                        return false;
                    } else if (i3 == 8 && !TbadkCoreApplication.isLogin()) {
                        if (UbsABTestHelper.isMinePageForVisitor() && TbSingleton.getInstance().isFlutterPluginLoadSuccess()) {
                            return true;
                        }
                        ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                        if (this.a.k != null) {
                            this.a.k.n();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                        return false;
                    } else {
                        int i4 = i2.a;
                        if (i4 == 15) {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                                return false;
                            }
                        } else if (i4 == 3 && !TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_msg");
                            return false;
                        } else if (i2.a == 1) {
                            TiebaStatic.log(new StatisticItem("c13001"));
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x0204, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r10) != false) goto L54;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.b i2 = this.a.f13540b.i(i);
                int i3 = i2.a;
                int i4 = 3;
                if (i3 == 8) {
                    if (this.a.k != null && this.a.k.getAnimationView() != null && this.a.k.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.k != null) {
                        this.a.k.n();
                    }
                    TiebaStatic.log("c13841");
                    SoLoadUtils.checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
                    SoLoadUtils.checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
                    SoLoadUtils.checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
                    SoLoadUtils.checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
                    c.a.o0.h0.b bVar = i2.f29926d;
                    if (bVar != null && bVar.b() != null && i2.f29926d.b().j) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680));
                    }
                } else if (i3 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                }
                int i5 = 2;
                if (i2.a == 2) {
                    if (this.a.n) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.n = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.a.o != 2 || this.a.m == i || homeBarShowType != 1 || this.a.l == null) {
                        if (this.a.o == 1 && this.a.l != null) {
                            this.a.l.x(this.a.n);
                        }
                    } else {
                        this.a.l.y();
                    }
                    this.a.p = false;
                } else {
                    this.a.p = true;
                    if (this.a.n && this.a.l != null) {
                        this.a.l.x(this.a.n);
                    }
                    this.a.n = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                }
                if (this.a.x() != null) {
                    this.a.x().w = this.a.n;
                }
                if (!this.a.n) {
                    c.a.p0.g1.b.j().t();
                }
                c(this.a.m);
                b(this.a.m);
                this.a.m = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
                if (i2.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator = i2.f29924b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.d("video_msg") != null && (maintabBottomIndicator.d("video_msg").a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator.d("video_msg").a).getRedNum();
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
                        long logWithBackTime = TiebaStatic.logWithBackTime(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i4));
                        if (this.a.f13540b.i(this.a.f13540b.getCurrentTabIndex()) != null && this.a.f13540b.i(this.a.f13540b.getCurrentTabIndex()).a != 22) {
                            TbSingleton.getInstance().setCurrentClickTime(logWithBackTime);
                        }
                    }
                    c.a.o0.i0.g.c.b().c();
                    c.a.o0.i0.g.c.b().l(true);
                    if (this.a.f13540b.i(this.a.f13540b.getCurrentTabIndex()) == null || this.a.f13540b.i(this.a.f13540b.getCurrentTabIndex()).a != 22) {
                        if (this.a.f13540b.getFragmentTabWidget() != null) {
                            this.a.f13540b.getFragmentTabWidget().h(true, R.color.CAM_X0215);
                        }
                        this.a.f13540b.q(true);
                        if (!c.a.d.f.p.l.z()) {
                            c.a.d.f.p.n.K(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15));
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
                        this.a.f13540b.t(false, null);
                        TbSingleton.getInstance().setFromFeedVideoClick(false);
                        RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                        TbSingleton.getInstance().setVideoChannelRecommendRedIcon(videoChannelRecommendRedIcon);
                        a(videoChannelRecommendRedIcon);
                    }
                    c.a.o0.i0.g.c.b().o();
                    c.a.o0.i0.g.c.b().l(false);
                    if (this.a.f13540b.getFragmentTabWidget() != null) {
                        this.a.f13540b.getFragmentTabWidget().h(false, R.color.CAM_X0207);
                    }
                    if (!c.a.o0.h0.e.e().g()) {
                        this.a.f13540b.q(false);
                    }
                }
                if (i2.a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                int i6 = i2.a;
                if (i6 == 22 || i6 == 23) {
                    this.a.r.g(true);
                } else {
                    this.a.r.g(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.f13540b.getCurrentTabType() != 2) {
                    if (this.a.f13540b.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                if (this.a.f13540b.getCurrentTabType() != this.a.f13540b.i(i).a) {
                    this.a.f13540b.setCurrentTab(i);
                }
                if (this.a.f13540b.getCurrentTabType() == 1 && !c.a.o0.r.j0.b.k().h("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (c.a.o0.r.j0.b.k().h("enter_forum_edit_mode", false)) {
                    if (this.a.f13540b.getCurrentTabType() != 3) {
                        if (this.a.f13540b.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (this.a.f13540b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f13547b;

        public c(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13547b = hVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13547b.M(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f13540b == null || this.a.f13544f == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.a.f13540b.getFragmentTabWidget();
            c.a.d.f.p.n.k(this.a.a.getActivity());
            int f2 = c.a.d.f.p.n.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070256);
            View contentView = this.a.f13544f.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b j = this.a.f13540b.j(3);
            if (j == null || (tbFragmentTabIndicator = j.f29924b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = c.a.d.f.p.n.f(this.a.a.getActivity(), R.dimen.tbds570);
            }
            c.a.d.f.m.g.l(this.a.f13544f, fragmentTabWidget, measuredWidth2, -f2);
            c.a.o0.r.j0.b.k().u("show_maintab_last_message_tips", true);
            this.a.f13545g = true;
            this.a.f13546h.postDelayed(this.a.B, 5000L);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public e(h hVar) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(h hVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(h hVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                aVar.dismiss();
                c.a.p0.m1.a.d();
            }
        }
    }

    /* renamed from: c.a.p0.c4.h$h  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1019h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1019h(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.o0.h0.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f13540b == null || !(customResponsedMessage.getData() instanceof c.a.o0.h0.c) || (cVar = (c.a.o0.h0.c) customResponsedMessage.getData()) == null || this.a.f13540b.j(cVar.f10299e) == null || this.a.f13540b.getCurrentTabType() == cVar.f10299e) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = this.a.f13540b.j(cVar.f10299e).f29924b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f10301g, cVar.f10297c);
                if (TextUtils.isEmpty(cVar.f10301g)) {
                    return;
                }
                this.a.q = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
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

    /* loaded from: classes2.dex */
    public class j implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public j(h hVar) {
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

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.o0.h0.g.a c2;
            c.a.o0.h0.g.a c3;
            c.a.o0.h0.g.a c4;
            c.a.o0.h0.g.a c5;
            c.a.o0.h0.g.a c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.f13540b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                FragmentTabHost.b j = this.a.f13540b.j(2);
                if (j != null && (j.f29924b instanceof MaintabBottomIndicator) && (c6 = c.a.o0.h0.g.c.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) j.f29924b).setDynamicIconData(c6);
                }
                FragmentTabHost.b j2 = this.a.f13540b.j(1);
                if (j2 != null && (j2.f29924b instanceof MaintabBottomIndicator) && (c5 = c.a.o0.h0.g.c.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) j2.f29924b).setDynamicIconData(c5);
                }
                FragmentTabHost.b j3 = this.a.f13540b.j(22);
                if (j3 != null && (j3.f29924b instanceof MaintabBottomIndicator) && (c4 = c.a.o0.h0.g.c.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) j3.f29924b).setDynamicIconData(c4);
                }
                FragmentTabHost.b j4 = this.a.f13540b.j(3);
                if (j4 != null && (j4.f29924b instanceof MaintabBottomIndicator) && (c3 = c.a.o0.h0.g.c.d().c("message")) != null) {
                    ((MaintabBottomIndicator) j4.f29924b).setDynamicIconData(c3);
                }
                FragmentTabHost.b j5 = this.a.f13540b.j(8);
                if (j5 == null || !(j5.f29924b instanceof MaintabBottomIndicator) || (c2 = c.a.o0.h0.g.c.d().c("person")) == null) {
                    return;
                }
                ((MaintabBottomIndicator) j5.f29924b).setDynamicIconData(c2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
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
                        if (this.a.l == null || !this.a.l.p()) {
                            return;
                        }
                        this.a.l.x(this.a.n);
                        return;
                    }
                    this.a.x().w();
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
                    this.a.x().x(this.a.n);
                } else if (this.a.o == 2) {
                    this.a.x().y();
                } else if (intValue == 5) {
                    this.a.o = 1;
                    this.a.n = true;
                    if (!this.a.p) {
                        this.a.x().w();
                    }
                } else {
                    this.a.x().v();
                }
                this.a.x().v = true;
                this.a.x().x = this.a.o;
                this.a.x().w = this.a.n;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.n = true;
                if (this.a.x() != null) {
                    this.a.x().w = this.a.n;
                }
                if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(TbSingleton.getInstance().accountWhenColdStart) && !TbSingleton.getInstance().accountWhenColdStart.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c.a.p0.x3.b.r().D(true);
                }
                c.a.o0.r.j0.b.k().u("key_member_auto_ban_renewal_show", false);
                TbSingleton.getInstance().hasPerformInterestPanelShow = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public n(h hVar) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f13540b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public o(h hVar) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f13540b.setVisibility(0);
            }
        }
    }

    public h(MainTabActivity mainTabActivity) {
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
        this.f13542d = false;
        this.f13545g = false;
        this.f13546h = new Handler();
        this.m = 0;
        this.n = true;
        this.o = 1;
        this.p = false;
        this.q = false;
        this.s = new a(this);
        this.t = new C1019h(this, 2921492);
        this.u = new i(this, 2001440);
        this.v = new j(this);
        this.w = new k(this, 2921551);
        this.x = new l(this, 2921382);
        this.y = new m(this, 2921410);
        this.A = new d(this);
        this.B = new e(this);
        this.a = mainTabActivity;
    }

    public SeekBar A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.c4.o oVar = this.r;
            if (oVar != null) {
                return oVar.f();
            }
            return null;
        }
        return (SeekBar) invokeV.objValue;
    }

    public void B(ArrayList<c.a.o0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f13540b.u();
            if (c.a.o0.h0.e.e().g() && this.f13540b.getFragmentTabWidget() != null) {
                this.f13540b.getFragmentTabWidget().j();
            }
            Iterator<c.a.o0.h0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.o0.h0.b next = it.next();
                if (next != null && next.d()) {
                    v(next, next.b(), next.c(this.a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.f13540b.n(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f13540b.n(1);
            } else {
                this.f13540b.n(0);
            }
            this.f13540b.setViewPagerScrollable(false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = false;
            this.o = 1;
            if (x() != null) {
                x().x = this.o;
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13543e : invokeV.booleanValue;
    }

    public void E(int i2) {
        FragmentTabHost fragmentTabHost;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (fragmentTabHost = this.f13540b) == null) {
            return;
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            fragmentTabHost.setShouldDrawTopLine(true);
        }
        this.f13540b.s(i2);
        FragmentTabHost fragmentTabHost2 = this.f13540b;
        FragmentTabHost.b i4 = fragmentTabHost2.i(fragmentTabHost2.getCurrentTabIndex());
        if (i4 != null && ((i3 = i4.a) == 22 || i3 == 23)) {
            if (this.f13540b.getFragmentTabWidget() != null) {
                this.f13540b.getFragmentTabWidget().h(true, R.color.CAM_X0215);
            }
            this.f13540b.q(true);
            return;
        }
        if (this.f13540b.getFragmentTabWidget() != null) {
            this.f13540b.getFragmentTabWidget().h(false, R.color.CAM_X0207);
        }
        this.f13540b.q(false);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            L();
            if (z() != null) {
                z().u();
            }
            w();
            c.a.p0.l0.j jVar = this.i;
            if (jVar != null) {
                jVar.h();
            }
            c.a.p0.n4.e eVar = this.j;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void G(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (fragmentTabHost = this.f13540b) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.k();
        } else {
            fragmentTabHost.v();
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
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f091e43);
            this.f13540b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            c.a.p0.c4.c.b(new n(this), 1);
            c.a.p0.c4.c.b(new o(this), 6);
            this.f13540b.setup(this.a.getSupportFragmentManager());
            this.f13540b.setAbsoluteWeight(true);
            this.f13540b.setOnTabSelectionListener(this.s);
            this.f13540b.s(TbadkCoreApplication.getInst().getSkinType());
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.f13540b.setShouldDrawIndicatorLine(false);
                this.f13540b.setShouldDrawTopLine(true);
            }
            this.f13540b.setOnPageChangeListener(new b(this));
            this.f13542d = c.a.o0.r.j0.b.k().h("has_show_message_tab_tips", false);
            this.f13541c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090075);
            this.f13540b.setUIType(0);
            this.f13540b.setTabContainerShadowShow(false);
            this.f13540b.setBackGroundStyle(0);
            this.f13540b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            c.a.p0.c4.o oVar = new c.a.p0.c4.o(this.a, this.f13540b.getTabWrapper());
            this.r = oVar;
            oVar.g(false);
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
                    maintabBottomIndicator.x(false);
                }
                this.n = false;
                if (x() != null) {
                    x().w = this.n;
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.o0.r.j0.b.k().u("has_show_message_tab_tips", this.f13542d);
        }
    }

    public void M(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f13541c.setVisibility(8);
                return;
            }
            FragmentTabHost.b j2 = this.f13540b.j(8);
            if (j2 != null) {
                if (this.f13545g && ((popupWindow = this.f13544f) == null || !popupWindow.isShowing())) {
                    N(str, j2);
                    return;
                }
                if (this.z == null) {
                    this.z = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.z);
                TbadkCoreApplication.getInst().handler.postDelayed(this.z, 5000L);
                return;
            }
            this.f13541c.setVisibility(8);
        }
    }

    public final void N(String str, FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, bVar) == null) {
            int[] iArr = new int[2];
            bVar.f29924b.getLocationInWindow(iArr);
            int width = iArr[0] + (bVar.f29924b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13541c.getLayoutParams();
            layoutParams.rightMargin = (c.a.d.f.p.n.q(this.a).widthPixels - width) - c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.f13541c.setLayoutParams(layoutParams);
            this.f13541c.setVisibility(0);
            this.f13541c.setText(str);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f03e1, new f(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f03a5, new g(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public void P(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.a.getActivityRootView() == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.j == null) {
            MainTabActivity mainTabActivity = this.a;
            this.j = new c.a.p0.n4.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.j.g(postWriteCallBackData);
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.i == null) {
                this.i = new c.a.p0.l0.j(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f091525));
            }
            this.i.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f13543e = z;
            if (z) {
                return;
            }
            c.a.o0.r.j0.b.k().u("enter_forum_edit_mode", false);
        }
    }

    public boolean u(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || c.a.d.f.p.m.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (c.a.o0.r.j0.b.k().h(c.a.o0.r.j0.b.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.o0.h0.b bVar, c.a.o0.h0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, bVar, cVar, tbFragmentTabIndicator) == null) && cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.f29925c = cVar.a;
            bVar2.a = cVar.f10299e;
            maintabBottomIndicator.setShowIconType(cVar.i);
            int i2 = cVar.i;
            if (i2 == c.a.o0.h0.c.k) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (i2 == c.a.o0.h0.c.n) {
                maintabBottomIndicator.setText(cVar.f10296b);
                maintabBottomIndicator.setAnimationResId(cVar.f10300f);
                this.k = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.f10296b);
                maintabBottomIndicator.setAnimationResId(cVar.f10300f);
            }
            if (!c.a.d.f.p.m.isEmpty(cVar.f10301g)) {
                maintabBottomIndicator.setImageIconUrl(cVar.f10301g, cVar.f10297c);
            }
            c.a.o0.h0.g.a aVar = cVar.f10302h;
            if (aVar != null) {
                maintabBottomIndicator.setDynamicIconData(aVar);
            }
            if (bVar2.a == 2) {
                maintabBottomIndicator.z = true;
                this.l = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.f29924b = maintabBottomIndicator;
            bVar2.f29926d = bVar;
            this.f13540b.e(bVar2, -1, z);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f13546h.removeCallbacks(this.A);
            this.f13546h.removeCallbacks(this.B);
            c.a.d.f.m.g.c(this.f13544f);
        }
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f13540b : (FragmentTabHost) invokeV.objValue;
    }
}
