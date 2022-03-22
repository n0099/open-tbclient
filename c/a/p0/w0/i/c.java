package c.a.p0.w0.i;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.p0.h0.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.ForumSquareFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends c.a.d.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19411b;

    /* renamed from: c  reason: collision with root package name */
    public ForumHeaderView f19412c;

    /* renamed from: d  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f19413d;

    /* renamed from: e  reason: collision with root package name */
    public PullLeftViewPager f19414e;

    /* renamed from: f  reason: collision with root package name */
    public EnterForumTabPagerAdapter f19415f;

    /* renamed from: g  reason: collision with root package name */
    public List<EnterForumTabPagerAdapter.a> f19416g;

    /* renamed from: h  reason: collision with root package name */
    public View f19417h;
    public AlphaAnimation i;
    public AlphaAnimation j;
    public c.a.p0.w0.e.e k;
    public c.a.p0.w0.e.e l;
    public ImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public NoNetworkView r;
    public c.a.p0.w0.o.b s;
    public int t;
    public int u;
    public boolean v;
    public c.a.d.c.g.a w;
    public CustomMessageListener x;
    public ViewPager.OnPageChangeListener y;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().y();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().y();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.a.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0560);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.U();
                } else {
                    this.a.p();
                }
            }
        }
    }

    /* renamed from: c.a.p0.w0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1467c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1467c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
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
                this.a.K(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.I(i);
                if (this.a.f19416g == null || this.a.f19416g.size() <= i) {
                    return;
                }
                if (this.a.s != null) {
                    this.a.s.U();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.a.f19416g.get(i);
                if (aVar == null || (fragment = aVar.a) == null) {
                    return;
                }
                if (fragment instanceof EnterForumFragment) {
                    z = ((EnterForumFragment) fragment).I0();
                } else if (fragment instanceof EnterForumTabFeedFragment) {
                    u.b().e(false);
                    boolean F0 = ((EnterForumTabFeedFragment) aVar.a).F0();
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.a).E0()));
                    z = F0;
                } else {
                    z = true;
                }
                if (!z) {
                    this.a.U();
                } else {
                    this.a.p();
                }
                if (i == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                }
                if (i == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.a.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.a.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.q.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = false;
        this.w = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.x = new b(this, 2001630);
        this.y = new C1467c(this);
        this.a = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.w);
        this.a.registerListener(this.x);
        this.t = n.f(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.u = UtilHelper.getStatusBarHeight() + n.f(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String C(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public final void A(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f19414e = (PullLeftViewPager) this.f19417h.findViewById(R.id.obfuscated_res_0x7f0908e1);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.a = new EnterForumFragment();
            aVar.f31861b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b26);
            ((EnterForumFragment) aVar.a).L0(this);
            EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
            aVar2.a = new ForumSquareFragment();
            aVar2.f31861b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f069e);
            aVar2.f31863d = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f069e);
            ArrayList arrayList = new ArrayList();
            this.f19416g = arrayList;
            arrayList.add(aVar);
            this.f19416g.add(aVar2);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.a.getActivity().getSupportFragmentManager(), this.f19416g);
            this.f19415f = enterForumTabPagerAdapter;
            this.f19414e.setAdapter(enterForumTabPagerAdapter);
            this.f19414e.setOffscreenPageLimit(this.f19416g.size());
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void E(int i, int i2, Intent intent) {
        List<EnterForumTabPagerAdapter.a> list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) || (list = this.f19416g) == null || list.size() <= 0 || (pullLeftViewPager = this.f19414e) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.f19416g.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.a;
            if (enterForumTabFragment != null && this.f19416g != null && this.f19414e != null && this.f19415f != null) {
                FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.f19416g.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(C(this.f19414e.getId(), this.f19415f.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.d(this);
            }
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.f19416g, i) == null || !(this.f19416g.get(i).a instanceof EnterForumTabFeedFragment)) {
            } else {
                ((EnterForumTabFeedFragment) this.f19416g.get(i).a).C0(true);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            I(this.f19414e.getCurrentItem());
        }
    }

    public final void I(int i) {
        c.a.p0.w0.e.e eVar;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (this.m != null) {
                if (i == 0) {
                    c.a.p0.w0.e.e eVar2 = this.k;
                    if (eVar2 != null && eVar2.a && eVar2.f19354c > 0) {
                        c.a.p0.w0.o.b bVar = this.s;
                        if (bVar != null && bVar.T() != null && this.s.T().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            c.a.p0.w0.e.e eVar3 = this.k;
                            int i4 = eVar3.f19355d;
                            if (i4 > 0 && eVar3.f19354c > i4 / 2) {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    } else {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                if (i == 0) {
                    c.a.p0.w0.e.e eVar4 = this.k;
                    if (eVar4 != null && eVar4.a && eVar4.f19354c > 0) {
                        c.a.p0.w0.o.b bVar2 = this.s;
                        if (bVar2 != null && bVar2.T() != null && this.s.T().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            c.a.p0.w0.e.e eVar5 = this.k;
                            int i5 = eVar5.f19355d;
                            if (i5 > 0) {
                                int i6 = (eVar5.f19354c * 255) / i5;
                                if (i6 > 255) {
                                    i6 = 255;
                                }
                                i3 = 255 - i6;
                            } else {
                                i3 = 0;
                            }
                            this.p.setBackgroundColor(0);
                            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, i3 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                        }
                    } else {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            }
            if (i == 0) {
                c.a.p0.w0.e.e eVar6 = this.k;
                if (eVar6 != null && eVar6.a && (i2 = eVar6.f19354c) > 0) {
                    int i7 = eVar6.f19355d;
                    if (i7 > 0 && i2 > i7 / 2) {
                        c.a.p0.w0.o.b bVar3 = this.s;
                        if (bVar3 != null && bVar3.T() != null && this.s.T().isViewAttached()) {
                            this.f19413d.setWhiteStyle(false);
                        } else {
                            this.f19413d.setWhiteStyle(true);
                        }
                    } else {
                        this.f19413d.setWhiteStyle(false);
                    }
                } else {
                    this.f19413d.setWhiteStyle(false);
                }
            } else {
                this.f19413d.setWhiteStyle(false);
            }
            if (i == 0) {
                this.f19412c.setAdState(this.k);
            } else {
                this.f19412c.setAdState(null);
            }
            if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.a.isPrimary() && (eVar = this.k) != null && eVar.a && i == 0) {
                int i8 = eVar.f19354c;
                int i9 = eVar.f19355d;
                if (i8 > i9 / 2) {
                    c.a.p0.w0.e.e eVar7 = this.l;
                    if (eVar7 == null || eVar7.f19354c > i9 / 2) {
                        return;
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                    return;
                }
                c.a.p0.w0.e.e eVar8 = this.l;
                if (eVar8 == null || eVar8.f19354c < i9 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public final void K(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.p == null) {
            return;
        }
        if (i == 0) {
            if (i2 == 0) {
                I(i);
                return;
            }
            c.a.p0.w0.e.e eVar = this.k;
            if (eVar == null || !eVar.a || eVar.f19354c <= 0) {
                return;
            }
            c.a.p0.w0.o.b bVar = this.s;
            if (bVar != null && bVar.T() != null && this.s.T().isViewAttached()) {
                SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.p.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
        } else if (i2 == 0) {
            I(i);
        } else {
            c.a.p0.w0.e.e eVar2 = this.k;
            if (eVar2 == null || !eVar2.a || eVar2.f19354c <= 0) {
                return;
            }
            c.a.p0.w0.o.b bVar2 = this.s;
            if (bVar2 != null && bVar2.T() != null && this.s.T().isViewAttached()) {
                SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.p.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                if (this.f19414e.getCurrentItem() == 0 && this.a.isPrimary()) {
                    c.a.p0.w0.o.b bVar = this.s;
                    if (bVar != null && bVar.T() != null && this.s.T().isViewAttached()) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    }
                    c.a.p0.w0.e.e eVar = this.k;
                    if (eVar != null && eVar.a) {
                        int i = eVar.f19354c;
                        if (i <= eVar.f19355d / 2 && i != 0) {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                            return;
                        } else {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                            return;
                        }
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        }
    }

    public boolean M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i < 0 || i > this.f19416g.size()) {
                return false;
            }
            this.f19414e.setCurrentItem(i, true);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void N(c.a.p0.w0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.l = this.k;
            this.k = eVar;
            this.f19412c.setAdState(eVar);
            I(this.f19414e.getCurrentItem());
        }
    }

    public void O(c.a.p0.w0.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.s = bVar;
        }
    }

    public void P(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f19415f;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.c(z);
            }
            List<EnterForumTabPagerAdapter.a> list = this.f19416g;
            if (list == null || list.size() <= 0 || (pullLeftViewPager = this.f19414e) == null) {
                return;
            }
            EnterForumTabPagerAdapter.a aVar = this.f19416g.get(pullLeftViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f19412c.setSearchHint(str);
        }
    }

    public void T(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048592, this, i, str) == null) || i < 0 || i > this.f19416g.size()) {
            return;
        }
        this.f19414e.setCurrentItem(i, true);
        if (this.f19416g.get(i) == null || !(this.f19416g.get(i).a instanceof ForumSquareFragment)) {
            return;
        }
        ((ForumSquareFragment) this.f19416g.get(i).a).C0(str);
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LinearLayout linearLayout = this.f19411b;
            if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
                q();
                return;
            }
            View view = this.q;
            if (view == null) {
                return;
            }
            view.clearAnimation();
            if (this.q.getVisibility() == 0) {
                return;
            }
            this.q.setVisibility(0);
            if (this.i == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.i = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.i.setDuration(300L);
            }
            this.q.startAnimation(this.i);
        }
    }

    public final void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.topMargin = this.u + i;
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void f(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            List<EnterForumTabPagerAdapter.a> list = this.f19416g;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.f19416g.size(); i++) {
                    EnterForumTabPagerAdapter.a aVar = this.f19416g.get(i);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).f(z);
                    }
                }
            }
            I(this.f19414e.getCurrentItem());
        }
    }

    public void o(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) || (newPagerSlidingTabBaseStrip = this.f19413d) == null || cVar == null) {
            return;
        }
        newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            I(this.f19414e.getCurrentItem());
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i);
            }
            List<EnterForumTabPagerAdapter.a> list = this.f19416g;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.f19416g.size(); i2++) {
                    EnterForumTabPagerAdapter.a aVar = this.f19416g.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i);
                    }
                }
            }
            SkinManager.setBackgroundResource(this.q, R.drawable.personalize_tab_shadow);
            this.f19413d.G();
            this.f19412c.b();
            SkinManager.setBackgroundColorToTransparent(this.o, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
            SkinManager.setBackgroundColorToTransparent(this.n, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
        }
    }

    public void p() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (view = this.q) == null || view.getVisibility() == 8) {
            return;
        }
        if (this.j == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.j = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.j.setDuration(300L);
            this.j.setAnimationListener(new e(this));
        }
        this.q.startAnimation(this.j);
    }

    public final void q() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (view = this.q) == null || view.getVisibility() == 8) {
            return;
        }
        this.q.clearAnimation();
        this.q.setVisibility(8);
    }

    public int r(String str) {
        InterceptResult invokeL;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.f19416g) == null || list.size() <= 0) {
                return -1;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.f19416g.size(); i2++) {
                if (str.equals(this.f19416g.get(i2).f31863d)) {
                    i = i2;
                }
            }
            if (i == -1 && this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b26).equals(str)) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f19415f;
            if (enterForumTabPagerAdapter != null) {
                return enterForumTabPagerAdapter.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f19414e.getCurrentItem() : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getPageContext().getPageActivity().getWindow().getDecorView() : (View) invokeV.objValue;
    }

    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.f19416g, i);
            if (aVar != null) {
                Fragment fragment = aVar.a;
                return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).E0() : "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f19411b : (View) invokeV.objValue;
    }

    public final void x(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19417h.findViewById(R.id.obfuscated_res_0x7f091519);
            this.p = navigationBar;
            navigationBar.setNavHeight(this.t);
            this.p.hideBottomLine();
            this.q = this.f19417h.findViewById(R.id.obfuscated_res_0x7f090801);
            V(0);
            ImageView imageView = (ImageView) this.f19411b.findViewById(R.id.obfuscated_res_0x7f091512);
            this.m = imageView;
            imageView.setOnClickListener(new d(this));
            if (this.f19413d != null) {
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.f19411b, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f19411b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f19413d;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.f19413d.getPaddingTop(), this.f19413d.getPaddingRight(), this.f19413d.getPaddingBottom());
            }
        }
    }

    public final void y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d027e, (ViewGroup) null);
            this.f19411b = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a01);
            this.f19412c = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.f19412c.b();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f19411b.findViewById(R.id.obfuscated_res_0x7f091e46);
            this.f19413d = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.f19413d.setRectPaintColor(R.color.CAM_X0302);
            this.f19413d.B(n.f(this.a.getContext(), R.dimen.tbds46), n.f(this.a.getContext(), R.dimen.tbds46), n.f(this.a.getContext(), R.dimen.tbds10), n.f(this.a.getContext(), R.dimen.tbds46), true);
            this.f19413d.setmIndicatorWidth(n.f(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.f19413d.setIndicatorOvershot(n.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f19413d.setIndicatorRadius(n.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f19413d.setIndicatorMarginBottom(n.f(this.a.getContext(), R.dimen.tbds0));
            this.f19413d.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f19413d.setTabPadding(n.f(this.a.getContext(), R.dimen.tbds36), 0, n.f(this.a.getContext(), R.dimen.tbds36), 0);
            this.f19413d.setViewPager(this.f19414e);
            this.f19413d.setOnPageChangeListener(this.y);
            this.o = this.f19411b.findViewById(R.id.obfuscated_res_0x7f0908dd);
            this.n = this.f19411b.findViewById(R.id.obfuscated_res_0x7f0908de);
        }
    }

    public void z(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, view, bundle) == null) || view == null) {
            return;
        }
        this.f19417h = view;
        A(bundle);
        y(bundle);
        x(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.f19417h.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.r = noNetworkView;
        noNetworkView.a(this);
    }
}
