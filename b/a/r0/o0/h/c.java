package b.a.r0.o0.h;

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
import b.a.e.a.f;
import b.a.e.e.p.l;
import b.a.r0.b0.u;
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
/* loaded from: classes5.dex */
public class c extends b.a.e.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.e.c.g.a A;
    public CustomMessageListener B;
    public ViewPager.OnPageChangeListener C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumTabFragment f21639e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21640f;

    /* renamed from: g  reason: collision with root package name */
    public ForumHeaderView f21641g;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f21642h;

    /* renamed from: i  reason: collision with root package name */
    public PullLeftViewPager f21643i;
    public EnterForumTabPagerAdapter j;
    public List<EnterForumTabPagerAdapter.a> k;
    public View l;
    public AlphaAnimation m;
    public AlphaAnimation n;
    public b.a.r0.o0.d.c o;
    public b.a.r0.o0.d.c p;
    public ImageView q;
    public View r;
    public View s;
    public NavigationBar t;
    public View u;
    public NoNetworkView v;
    public b.a.r0.o0.m.b w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21644a;

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
            this.f21644a = cVar;
        }

        @Override // b.a.e.c.g.a
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
                    str = this.f21644a.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21645a;

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
            this.f21645a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.f21645a.W();
                } else {
                    this.f21645a.n();
                }
            }
        }
    }

    /* renamed from: b.a.r0.o0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1060c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21646e;

        public C1060c(c cVar) {
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
            this.f21646e = cVar;
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
                this.f21646e.O(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f21646e.M(i2);
                if (this.f21646e.k == null || this.f21646e.k.size() <= i2) {
                    return;
                }
                if (this.f21646e.w != null) {
                    this.f21646e.w.N();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.f21646e.k.get(i2);
                if (aVar == null || (fragment = aVar.f47634a) == null) {
                    return;
                }
                if (fragment instanceof EnterForumFragment) {
                    z = ((EnterForumFragment) fragment).isAtTop();
                } else if (fragment instanceof EnterForumTabFeedFragment) {
                    u.b().e(false);
                    boolean isAtTop = ((EnterForumTabFeedFragment) aVar.f47634a).isAtTop();
                    TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.f47634a).getTabName()));
                    z = isAtTop;
                } else {
                    z = true;
                }
                if (!z) {
                    this.f21646e.W();
                } else {
                    this.f21646e.n();
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21647e;

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
            this.f21647e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.f21647e.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.f21647e.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f21647e.getPageContext().getPageActivity());
                } else {
                    this.f21647e.f21639e.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.f21647e.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f21648a;

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
            this.f21648a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f21648a.u.setVisibility(8);
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
        this.C = new C1060c(this);
        this.f21639e = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.A);
        this.f21639e.registerListener(this.B);
        this.x = l.g(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.y = UtilHelper.getStatusBarHeight() + l.g(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String A(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i2 + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void D(int i2, int i3, Intent intent) {
        List<EnterForumTabPagerAdapter.a> list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) || (list = this.k) == null || list.size() <= 0 || (pullLeftViewPager = this.f21643i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f47634a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.f21639e;
            if (enterForumTabFragment != null && this.k != null && this.f21643i != null && this.j != null) {
                FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(A(this.f21643i.getId(), this.j.getItemId(i2)));
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

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.k, i2) == null || !(this.k.get(i2).f47634a instanceof EnterForumTabFeedFragment)) {
            } else {
                ((EnterForumTabFeedFragment) this.k.get(i2).f47634a).callRefresh(true);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            M(this.f21643i.getCurrentItem());
        }
    }

    public final void M(int i2) {
        b.a.r0.o0.d.c cVar;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.q != null) {
                if (i2 == 0) {
                    b.a.r0.o0.d.c cVar2 = this.o;
                    if (cVar2 != null && cVar2.f21561a && cVar2.f21563c > 0) {
                        b.a.r0.o0.m.b bVar = this.w;
                        if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            b.a.r0.o0.d.c cVar3 = this.o;
                            int i5 = cVar3.f21564d;
                            if (i5 > 0 && cVar3.f21563c > i5 / 2) {
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
                    b.a.r0.o0.d.c cVar4 = this.o;
                    if (cVar4 != null && cVar4.f21561a && cVar4.f21563c > 0) {
                        b.a.r0.o0.m.b bVar2 = this.w;
                        if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            b.a.r0.o0.d.c cVar5 = this.o;
                            int i6 = cVar5.f21564d;
                            if (i6 > 0) {
                                int i7 = (cVar5.f21563c * 255) / i6;
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
                b.a.r0.o0.d.c cVar6 = this.o;
                if (cVar6 != null && cVar6.f21561a && (i3 = cVar6.f21563c) > 0) {
                    int i8 = cVar6.f21564d;
                    if (i8 > 0 && i3 > i8 / 2) {
                        b.a.r0.o0.m.b bVar3 = this.w;
                        if (bVar3 != null && bVar3.M() != null && this.w.M().isViewAttached()) {
                            this.f21642h.setWhiteStyle(false);
                        } else {
                            this.f21642h.setWhiteStyle(true);
                        }
                    } else {
                        this.f21642h.setWhiteStyle(false);
                    }
                } else {
                    this.f21642h.setWhiteStyle(false);
                }
            } else {
                this.f21642h.setWhiteStyle(false);
            }
            if (i2 == 0) {
                this.f21641g.setAdState(this.o);
            } else {
                this.f21641g.setAdState(null);
            }
            if (i2 == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.f21639e.isPrimary() && (cVar = this.o) != null && cVar.f21561a && i2 == 0) {
                int i9 = cVar.f21563c;
                int i10 = cVar.f21564d;
                if (i9 > i10 / 2) {
                    b.a.r0.o0.d.c cVar7 = this.p;
                    if (cVar7 == null || cVar7.f21563c > i10 / 2) {
                        return;
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                    return;
                }
                b.a.r0.o0.d.c cVar8 = this.p;
                if (cVar8 == null || cVar8.f21563c < i10 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public final void O(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.t == null) {
            return;
        }
        if (i2 == 0) {
            if (i3 == 0) {
                M(i2);
                return;
            }
            b.a.r0.o0.d.c cVar = this.o;
            if (cVar == null || !cVar.f21561a || cVar.f21563c <= 0) {
                return;
            }
            b.a.r0.o0.m.b bVar = this.w;
            if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.t.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
        } else if (i3 == 0) {
            M(i2);
        } else {
            b.a.r0.o0.d.c cVar2 = this.o;
            if (cVar2 == null || !cVar2.f21561a || cVar2.f21563c <= 0) {
                return;
            }
            b.a.r0.o0.m.b bVar2 = this.w;
            if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.t.setBackgroundColor(0);
            SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                if (this.f21643i.getCurrentItem() == 0 && this.f21639e.isPrimary()) {
                    b.a.r0.o0.m.b bVar = this.w;
                    if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    }
                    b.a.r0.o0.d.c cVar = this.o;
                    if (cVar != null && cVar.f21561a) {
                        int i2 = cVar.f21563c;
                        if (i2 <= cVar.f21564d / 2 && i2 != 0) {
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

    public boolean Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 < 0 || i2 > this.k.size()) {
                return false;
            }
            this.f21643i.setCurrentItem(i2, true);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void R(b.a.r0.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.p = this.o;
            this.o = cVar;
            this.f21641g.setAdState(cVar);
            M(this.f21643i.getCurrentItem());
        }
    }

    public void S(b.a.r0.o0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.w = bVar;
        }
    }

    public void T(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.setPrimary(z);
            }
            List<EnterForumTabPagerAdapter.a> list = this.k;
            if (list == null || list.size() <= 0 || (pullLeftViewPager = this.f21643i) == null) {
                return;
            }
            EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.f47634a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f21641g.setSearchHint(str);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            LinearLayout linearLayout = this.f21640f;
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
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) || (newPagerSlidingTabBaseStrip = this.f21642h) == null || cVar == null) {
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
            M(this.f21643i.getCurrentItem());
            NoNetworkView noNetworkView = this.v;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
            List<EnterForumTabPagerAdapter.a> list = this.k;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.k.size(); i3++) {
                    EnterForumTabPagerAdapter.a aVar = this.k.get(i3);
                    if (aVar != null && (fragment = aVar.f47634a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i2);
                    }
                }
            }
            SkinManager.setBackgroundResource(this.u, R.drawable.personalize_tab_shadow);
            this.f21642h.onChangeSkinType();
            this.f21641g.onChangeSkinType();
            SkinManager.setBackgroundColorToTransparent(this.s, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
            SkinManager.setBackgroundColorToTransparent(this.r, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            List<EnterForumTabPagerAdapter.a> list = this.k;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    EnterForumTabPagerAdapter.a aVar = this.k.get(i2);
                    if (aVar != null && (fragment = aVar.f47634a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).onNetworkChange(z);
                    }
                }
            }
            M(this.f21643i.getCurrentItem());
        }
    }

    public int p(String str) {
        InterceptResult invokeL;
        List<EnterForumTabPagerAdapter.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.k) == null || list.size() <= 0) {
                return -1;
            }
            int i2 = -1;
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                if (str.equals(this.k.get(i3).f47637d)) {
                    i2 = i3;
                }
            }
            if (i2 == -1 && this.f21639e.getResources().getString(R.string.my_forum).equals(str)) {
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
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f21643i.getCurrentItem() : invokeV.intValue;
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
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.k, i2);
            if (aVar != null) {
                Fragment fragment = aVar.f47634a;
                return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).getTabName() : "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f21640f : (View) invokeV.objValue;
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
            ImageView imageView = (ImageView) this.f21640f.findViewById(R.id.navigationBarGoSignall);
            this.q = imageView;
            imageView.setOnClickListener(new d(this));
            if (this.f21642h != null) {
                this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.f21640f, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f21640f.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f21642h;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.f21642h.getPaddingTop(), this.f21642h.getPaddingRight(), this.f21642h.getPaddingBottom());
            }
        }
    }

    public final void w(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f21639e.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
            this.f21640f = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.recommend_forum_header_serch_view);
            this.f21641g = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.f21641g.onChangeSkinType();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f21640f.findViewById(R.id.tab_layout);
            this.f21642h = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.f21642h.setRectPaintColor(R.color.CAM_X0302);
            this.f21642h.init(l.g(this.f21639e.getContext(), R.dimen.tbds46), l.g(this.f21639e.getContext(), R.dimen.tbds46), l.g(this.f21639e.getContext(), R.dimen.tbds10), l.g(this.f21639e.getContext(), R.dimen.tbds46), true);
            this.f21642h.setmIndicatorWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.f21642h.setIndicatorOvershot(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f21642h.setIndicatorRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.f21642h.setIndicatorMarginBottom(l.g(this.f21639e.getContext(), R.dimen.tbds0));
            this.f21642h.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f21642h.setTabPadding(l.g(this.f21639e.getContext(), R.dimen.tbds36), 0, l.g(this.f21639e.getContext(), R.dimen.tbds36), 0);
            this.f21642h.setViewPager(this.f21643i);
            this.f21642h.setOnPageChangeListener(this.C);
            this.s = this.f21640f.findViewById(R.id.enter_forum_tab_left_grandient);
            this.r = this.f21640f.findViewById(R.id.enter_forum_tab_right_grandient);
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
            this.f21643i = (PullLeftViewPager) this.l.findViewById(R.id.enter_forum_viewpager);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.f47634a = new EnterForumFragment();
            aVar.f47635b = this.f21639e.getResources().getString(R.string.my_forum);
            ((EnterForumFragment) aVar.f47634a).setTabViewController(this);
            ArrayList arrayList = new ArrayList();
            this.k = arrayList;
            arrayList.add(aVar);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.f21639e.getActivity().getSupportFragmentManager(), this.k);
            this.j = enterForumTabPagerAdapter;
            this.f21643i.setAdapter(enterForumTabPagerAdapter);
            this.f21643i.setOffscreenPageLimit(this.k.size());
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.z : invokeV.booleanValue;
    }
}
