package c.a.r0.u0.h;

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
import c.a.d.f.p.l;
import c.a.r0.g0.v;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends c.a.d.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.c.g.a A;
    public CustomMessageListener B;
    public ViewPager.OnPageChangeListener C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumTabFragment f24166e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f24167f;

    /* renamed from: g  reason: collision with root package name */
    public ForumHeaderView f24168g;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f24169h;

    /* renamed from: i  reason: collision with root package name */
    public PullLeftViewPager f24170i;

    /* renamed from: j  reason: collision with root package name */
    public EnterForumTabPagerAdapter f24171j;

    /* renamed from: k  reason: collision with root package name */
    public List<EnterForumTabPagerAdapter.a> f24172k;
    public View l;
    public AlphaAnimation m;
    public AlphaAnimation n;
    public c.a.r0.u0.d.c o;
    public c.a.r0.u0.d.c p;
    public ImageView q;
    public View r;
    public View s;
    public NavigationBar t;
    public View u;
    public NoNetworkView v;
    public c.a.r0.u0.m.b w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().w();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().w();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.a.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.W();
                } else {
                    this.a.n();
                }
            }
        }
    }

    /* renamed from: c.a.r0.u0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1380c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24173e;

        public C1380c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24173e = cVar;
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
                this.f24173e.K(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f24173e.G(i2);
                if (this.f24173e.f24172k == null || this.f24173e.f24172k.size() <= i2) {
                    return;
                }
                if (this.f24173e.w != null) {
                    this.f24173e.w.N();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.f24173e.f24172k.get(i2);
                if (aVar == null || (fragment = aVar.a) == null) {
                    return;
                }
                if (fragment instanceof EnterForumFragment) {
                    z = ((EnterForumFragment) fragment).isAtTop();
                } else if (fragment instanceof EnterForumTabFeedFragment) {
                    v.b().e(false);
                    boolean isAtTop = ((EnterForumTabFeedFragment) aVar.a).isAtTop();
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.a).getTabName()));
                    z = isAtTop;
                } else {
                    z = true;
                }
                if (!z) {
                    this.f24173e.W();
                } else {
                    this.f24173e.n();
                }
                if (i2 == 0) {
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                }
                if (i2 == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24174e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24174e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.f24174e.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.f24174e.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f24174e.getPageContext().getPageActivity());
                } else {
                    this.f24174e.f24166e.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f24174e.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.u.setVisibility(8);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = false;
        this.A = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.B = new b(this, 2001630);
        this.C = new C1380c(this);
        this.f24166e = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.A);
        this.f24166e.registerListener(this.B);
        this.x = l.f(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.y = UtilHelper.getStatusBarHeight() + l.f(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String A(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            return "android:switcher:" + i2 + ":" + j2;
        }
        return (String) invokeCommon.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void C(int i2, int i3, Intent intent) {
        List<EnterForumTabPagerAdapter.a> list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) || (list = this.f24172k) == null || list.size() <= 0 || (pullLeftViewPager = this.f24170i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.f24172k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.f24166e;
            if (enterForumTabFragment != null && this.f24172k != null && this.f24170i != null && this.f24171j != null) {
                FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i2 = 0; i2 < this.f24172k.size(); i2++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(A(this.f24170i.getId(), this.f24171j.getItemId(i2)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.v;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this);
            }
        }
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.f24172k, i2) == null || !(this.f24172k.get(i2).a instanceof EnterForumTabFeedFragment)) {
            } else {
                ((EnterForumTabFeedFragment) this.f24172k.get(i2).a).callRefresh(true);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            G(this.f24170i.getCurrentItem());
        }
    }

    public final void G(int i2) {
        c.a.r0.u0.d.c cVar;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.q != null) {
                if (i2 == 0) {
                    c.a.r0.u0.d.c cVar2 = this.o;
                    if (cVar2 != null && cVar2.a && cVar2.f24106c > 0) {
                        c.a.r0.u0.m.b bVar = this.w;
                        if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            c.a.r0.u0.d.c cVar3 = this.o;
                            int i5 = cVar3.f24107d;
                            if (i5 > 0 && cVar3.f24106c > i5 / 2) {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    } else {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            NavigationBar navigationBar = this.t;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                if (i2 == 0) {
                    c.a.r0.u0.d.c cVar4 = this.o;
                    if (cVar4 != null && cVar4.a && cVar4.f24106c > 0) {
                        c.a.r0.u0.m.b bVar2 = this.w;
                        if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            c.a.r0.u0.d.c cVar5 = this.o;
                            int i6 = cVar5.f24107d;
                            if (i6 > 0) {
                                int i7 = (cVar5.f24106c * 255) / i6;
                                if (i7 > 255) {
                                    i7 = 255;
                                }
                                i4 = 255 - i7;
                            } else {
                                i4 = 0;
                            }
                            this.t.setBackgroundColor(0);
                            SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, i4 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                        }
                    } else {
                        SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            }
            if (i2 == 0) {
                c.a.r0.u0.d.c cVar6 = this.o;
                if (cVar6 != null && cVar6.a && (i3 = cVar6.f24106c) > 0) {
                    int i8 = cVar6.f24107d;
                    if (i8 > 0 && i3 > i8 / 2) {
                        c.a.r0.u0.m.b bVar3 = this.w;
                        if (bVar3 != null && bVar3.M() != null && this.w.M().isViewAttached()) {
                            this.f24169h.setWhiteStyle(false);
                        } else {
                            this.f24169h.setWhiteStyle(true);
                        }
                    } else {
                        this.f24169h.setWhiteStyle(false);
                    }
                } else {
                    this.f24169h.setWhiteStyle(false);
                }
            } else {
                this.f24169h.setWhiteStyle(false);
            }
            if (i2 == 0) {
                this.f24168g.setAdState(this.o);
            } else {
                this.f24168g.setAdState(null);
            }
            if (i2 == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.f24166e.isPrimary() && (cVar = this.o) != null && cVar.a && i2 == 0) {
                int i9 = cVar.f24106c;
                int i10 = cVar.f24107d;
                if (i9 > i10 / 2) {
                    c.a.r0.u0.d.c cVar7 = this.p;
                    if (cVar7 == null || cVar7.f24106c > i10 / 2) {
                        return;
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                    return;
                }
                c.a.r0.u0.d.c cVar8 = this.p;
                if (cVar8 == null || cVar8.f24106c < i10 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public final void K(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.t == null) {
            return;
        }
        if (i2 == 0) {
            if (i3 == 0) {
                G(i2);
                return;
            }
            c.a.r0.u0.d.c cVar = this.o;
            if (cVar == null || !cVar.a || cVar.f24106c <= 0) {
                return;
            }
            c.a.r0.u0.m.b bVar = this.w;
            if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.t.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
        } else if (i3 == 0) {
            G(i2);
        } else {
            c.a.r0.u0.d.c cVar2 = this.o;
            if (cVar2 == null || !cVar2.a || cVar2.f24106c <= 0) {
                return;
            }
            c.a.r0.u0.m.b bVar2 = this.w;
            if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.t.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                if (this.f24170i.getCurrentItem() == 0 && this.f24166e.isPrimary()) {
                    c.a.r0.u0.m.b bVar = this.w;
                    if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    }
                    c.a.r0.u0.d.c cVar = this.o;
                    if (cVar != null && cVar.a) {
                        int i2 = cVar.f24106c;
                        if (i2 <= cVar.f24107d / 2 && i2 != 0) {
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

    public boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 < 0 || i2 > this.f24172k.size()) {
                return false;
            }
            this.f24170i.setCurrentItem(i2, true);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void O(c.a.r0.u0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.p = this.o;
            this.o = cVar;
            this.f24168g.setAdState(cVar);
            G(this.f24170i.getCurrentItem());
        }
    }

    public void Q(c.a.r0.u0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.w = bVar;
        }
    }

    public void S(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f24171j;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.setPrimary(z);
            }
            List<EnterForumTabPagerAdapter.a> list = this.f24172k;
            if (list == null || list.size() <= 0 || (pullLeftViewPager = this.f24170i) == null) {
                return;
            }
            EnterForumTabPagerAdapter.a aVar = this.f24172k.get(pullLeftViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f24168g.setSearchHint(str);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LinearLayout linearLayout = this.f24167f;
            if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
                o();
                return;
            }
            View view = this.u;
            if (view == null) {
                return;
            }
            view.clearAnimation();
            if (this.u.getVisibility() == 0) {
                return;
            }
            this.u.setVisibility(0);
            if (this.m == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.m = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.m.setDuration(300L);
            }
            this.u.startAnimation(this.m);
        }
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
            layoutParams.topMargin = this.y + i2;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public void m(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) || (newPagerSlidingTabBaseStrip = this.f24169h) == null || cVar == null) {
            return;
        }
        newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
    }

    public void n() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (view = this.u) == null || view.getVisibility() == 8) {
            return;
        }
        if (this.n == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.n = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.n.setDuration(300L);
            this.n.setAnimationListener(new e(this));
        }
        this.u.startAnimation(this.n);
    }

    public final void o() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (view = this.u) == null || view.getVisibility() == 8) {
            return;
        }
        this.u.clearAnimation();
        this.u.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            G(this.f24170i.getCurrentItem());
            NoNetworkView noNetworkView = this.v;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
            List<EnterForumTabPagerAdapter.a> list = this.f24172k;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.f24172k.size(); i3++) {
                    EnterForumTabPagerAdapter.a aVar = this.f24172k.get(i3);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i2);
                    }
                }
            }
            SkinManager.setBackgroundResource(this.u, R.drawable.personalize_tab_shadow);
            this.f24169h.onChangeSkinType();
            this.f24168g.onChangeSkinType();
            SkinManager.setBackgroundColorToTransparent(this.s, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
            SkinManager.setBackgroundColorToTransparent(this.r, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            List<EnterForumTabPagerAdapter.a> list = this.f24172k;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.f24172k.size(); i2++) {
                    EnterForumTabPagerAdapter.a aVar = this.f24172k.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).onNetworkChange(z);
                    }
                }
            }
            G(this.f24170i.getCurrentItem());
        }
    }

    public int p(String str) {
        InterceptResult invokeL;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.f24172k) == null || list.size() <= 0) {
                return -1;
            }
            int i2 = -1;
            for (int i3 = 0; i3 < this.f24172k.size(); i3++) {
                if (str.equals(this.f24172k.get(i3).f43508d)) {
                    i2 = i3;
                }
            }
            if (i2 == -1 && this.f24166e.getResources().getString(R.string.my_forum).equals(str)) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f24171j;
            if (enterForumTabPagerAdapter != null) {
                return enterForumTabPagerAdapter.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f24170i.getCurrentItem() : invokeV.intValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getPageContext().getPageActivity().getWindow().getDecorView() : (View) invokeV.objValue;
    }

    public String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.f24172k, i2);
            if (aVar != null) {
                Fragment fragment = aVar.a;
                return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).getTabName() : "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f24167f : (View) invokeV.objValue;
    }

    public final void v(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.l.findViewById(R.id.navigation_bar);
            this.t = navigationBar;
            navigationBar.setNavHeight(this.x);
            this.t.hideBottomLine();
            this.u = this.l.findViewById(R.id.divider_shadow);
            X(0);
            ImageView imageView = (ImageView) this.f24167f.findViewById(R.id.navigationBarGoSignall);
            this.q = imageView;
            imageView.setOnClickListener(new d(this));
            if (this.f24169h != null) {
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.f24167f, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f24167f.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f24169h;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.f24169h.getPaddingTop(), this.f24169h.getPaddingRight(), this.f24169h.getPaddingBottom());
            }
        }
    }

    public final void w(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f24166e.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
            this.f24167f = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.recommend_forum_header_serch_view);
            this.f24168g = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.f24168g.onChangeSkinType();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f24167f.findViewById(R.id.tab_layout);
            this.f24169h = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.f24169h.setRectPaintColor(R.color.CAM_X0302);
            this.f24169h.init(l.f(this.f24166e.getContext(), R.dimen.tbds46), l.f(this.f24166e.getContext(), R.dimen.tbds46), l.f(this.f24166e.getContext(), R.dimen.tbds10), l.f(this.f24166e.getContext(), R.dimen.tbds46), true);
            this.f24169h.setmIndicatorWidth(l.f(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.f24169h.setIndicatorOvershot(l.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f24169h.setIndicatorRadius(l.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f24169h.setIndicatorMarginBottom(l.f(this.f24166e.getContext(), R.dimen.tbds0));
            this.f24169h.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f24169h.setTabPadding(l.f(this.f24166e.getContext(), R.dimen.tbds36), 0, l.f(this.f24166e.getContext(), R.dimen.tbds36), 0);
            this.f24169h.setViewPager(this.f24170i);
            this.f24169h.setOnPageChangeListener(this.C);
            this.s = this.f24167f.findViewById(R.id.enter_forum_tab_left_grandient);
            this.r = this.f24167f.findViewById(R.id.enter_forum_tab_right_grandient);
        }
    }

    public void x(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, view, bundle) == null) || view == null) {
            return;
        }
        this.l = view;
        y(bundle);
        w(bundle);
        v(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.l.findViewById(R.id.view_no_network);
        this.v = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
    }

    public final void y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            this.f24170i = (PullLeftViewPager) this.l.findViewById(R.id.enter_forum_viewpager);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.a = new EnterForumFragment();
            aVar.f43506b = this.f24166e.getResources().getString(R.string.my_forum);
            ((EnterForumFragment) aVar.a).setTabViewController(this);
            ArrayList arrayList = new ArrayList();
            this.f24172k = arrayList;
            arrayList.add(aVar);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.f24166e.getActivity().getSupportFragmentManager(), this.f24172k);
            this.f24171j = enterForumTabPagerAdapter;
            this.f24170i.setAdapter(enterForumTabPagerAdapter);
            this.f24170i.setOffscreenPageLimit(this.f24172k.size());
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.z : invokeV.booleanValue;
    }
}
