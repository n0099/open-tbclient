package c.a.t0.q1.o;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.q1.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.DisableScrollLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.hottopic.adapter.HotTopicThreadPagerAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicHeaderView;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f21602b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21603c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f21604d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21605e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21606f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f21607g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.q1.o.e f21608h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicHeaderView f21609i;

    /* renamed from: j  reason: collision with root package name */
    public CustomViewPager f21610j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public c.a.t0.q1.k.c r;
    public NoNetworkView.b s;
    public final c.a.s0.g1.j.e t;
    public final c.a.s0.g1.j.e u;
    public boolean v;
    public float w;
    public boolean x;
    public String y;
    public f z;

    /* loaded from: classes8.dex */
    public class a implements c.a.s0.g1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
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

        @Override // c.a.s0.g1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a.o = i3;
                if (this.a.f21609i != null) {
                    this.a.f21609i.changePlaceHolderHeight(i3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.s0.g1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
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

        @Override // c.a.s0.g1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a.n = i3;
                this.a.k.changeListViewFakeHeaderHeight(i3);
                this.a.l.setHeaderViewHeight(i3);
            }
        }
    }

    /* renamed from: c.a.t0.q1.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1342c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21611e;

        public View$OnClickListenerC1342c(c cVar) {
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
            this.f21611e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.z()) {
                    ((HotTopicActivity) this.f21611e.a.getOrignalPage()).showToast(h.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f21611e.a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f21611e.a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f21611e.a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f21611e.a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21612e;

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
            this.f21612e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.z()) {
                    ((HotTopicActivity) this.f21612e.a.getOrignalPage()).showToast(h.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f21612e.a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f21612e.a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f21612e.a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f21612e.a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21613e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21613e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicView currentTab;
            HotTopicActivity hotTopicActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || (currentTab = this.f21613e.k.getCurrentTab()) == null) {
                return;
            }
            if (absListView == currentTab.getListView()) {
                if (this.f21613e.f21608h != null) {
                    this.f21613e.f21608h.m(i2);
                }
                this.f21613e.G();
            }
            if (this.f21613e.k != null && this.f21613e.f21609i.getNavigationBarSwitchHeight() != this.f21613e.o) {
                if (this.f21613e.x) {
                    float navigationBarSwitchHeight = (-this.f21613e.f21609i.getY()) / (this.f21613e.f21609i.getNavigationBarSwitchHeight() - this.f21613e.o);
                    this.f21613e.f21603c.setAlpha(1.0f - navigationBarSwitchHeight);
                    this.f21613e.f21604d.setAlpha(navigationBarSwitchHeight);
                    if (this.f21613e.p != null) {
                        this.f21613e.p.setAlpha((-this.f21613e.f21609i.getY()) / (this.f21613e.f21609i.getNavigationBarSwitchHeight() - this.f21613e.o));
                    }
                } else {
                    if (this.f21613e.p != null) {
                        this.f21613e.p.setAlpha((-this.f21613e.f21609i.getY()) / (this.f21613e.f21609i.getNavigationBarSwitchHeight() - this.f21613e.o));
                    }
                    if (Math.abs(this.f21613e.w) == this.f21613e.v()) {
                        this.f21613e.f21604d.hideBottomLine();
                    } else {
                        this.f21613e.f21604d.showBottomLine();
                    }
                }
            }
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) this.f21613e.a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            HotTopicView currentTab;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (currentTab = this.f21613e.k.getCurrentTab()) != null && absListView == currentTab.getListView() && i2 == 0) {
                this.f21613e.v = true;
                float y = this.f21613e.f21609i.getY();
                if (this.f21613e.k != null) {
                    if (Math.abs(this.f21613e.w) != this.f21613e.v() || this.f21613e.w == y) {
                        this.f21613e.k.scrollOtherListView((int) (this.f21613e.w - y));
                        return;
                    }
                    this.f21613e.k.scrollOtherListViewToTop(y);
                    this.f21613e.f21603c.hideBottomLine();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class f implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(c cVar) {
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
                }
            }
        }
    }

    public c(TbPageContext<HotTopicActivity> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        this.u = new b(this);
        this.x = false;
        this.z = new e(this);
        this.a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<c.a.t0.q1.l.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.k.updateList(list);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            NavigationBar navigationBar = this.f21603c;
            if (navigationBar != null && this.x) {
                navigationBar.onChangeSkinType(this.a, i2);
                this.f21603c.setBackgroundResource(c.a.t0.q1.d.black_alpha_from_30_to_0);
                SkinManager.setImageResource(this.f21603c.getBackImageView(), c.a.t0.q1.d.selector_topbar_return_white);
                this.f21603c.setAlpha((this.f21609i.getY() / (this.f21609i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
            }
            NavigationBar navigationBar2 = this.f21604d;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.a, i2);
                if (this.x) {
                    this.f21604d.setAlpha((-this.f21609i.getY()) / (this.f21609i.getNavigationBarSwitchHeight() - this.o));
                } else {
                    this.f21604d.setAlpha(1.0f);
                }
            }
            NoNetworkView noNetworkView = this.f21607g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a, i2);
            }
            if (this.f21606f != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21606f, c.a.t0.q1.d.icon_pure_topbar_share44_svg, c.a.t0.q1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.f21605e != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21605e, c.a.t0.q1.d.icon_pure_topbar_share44_svg, c.a.t0.q1.b.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            HotTopicHeaderView hotTopicHeaderView = this.f21609i;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.onChangeSkinType();
            }
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.onChangeSkinType(i2);
            }
            ImageView imageView = this.q;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, c.a.t0.q1.d.icon_tabbar_chaticon_n);
                SkinManager.setImageResource(this.q, c.a.t0.q1.d.icon_tabbar_add_n);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.completePullRefresh(false);
        }
    }

    public void D() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.pause();
    }

    public void E(boolean z) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (noNetworkView = this.f21607g) == null) {
            return;
        }
        if (z) {
            noNetworkView.setVisibility(0);
        } else {
            noNetworkView.setVisibility(8);
        }
    }

    public void F() {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.resume();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.v) {
            this.w = this.f21609i.getY();
            this.v = false;
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            TextView textView = this.p;
            if (textView != null) {
                textView.setText(str);
                return;
            }
            NavigationBar navigationBar = this.f21604d;
            if (navigationBar != null) {
                this.p = navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f21609i.setVisibility(i2);
            this.f21610j.setVisibility(i2);
        }
    }

    public void J(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.s = bVar;
            NoNetworkView noNetworkView = this.f21607g;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void K(View.OnTouchListener onTouchListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, onTouchListener) == null) || onTouchListener == null || (imageView = this.q) == null) {
            return;
        }
        imageView.setOnTouchListener(onTouchListener);
    }

    public void L(c.a.t0.q1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.f21609i.isDataSet()) {
            this.f21609i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().f21547i);
            this.x = z;
            this.f21603c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f21604d.setAlpha(1.0f);
                this.f21604d.showBottomLine();
            }
        }
        String str = eVar.h().f21544f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(c.a.t0.q1.n.a.a(str, 10));
        }
        this.f21609i.setHeaderBottomLineShow(true);
    }

    public void M(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.showLoadMoreView(i2);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.showLoadingView();
        }
    }

    public void O(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.showNoMoreView(i2);
    }

    public void P(AbsListView absListView, int i2) {
        HotTopicView currentTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, absListView, i2) == null) || this.f21609i == null || this.l == null || (currentTab = this.k.getCurrentTab()) == null || currentTab.getListView() == null || absListView != currentTab.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i2);
        this.f21609i.setY(-i2);
        if (i2 == 0) {
            this.l.enableHeaderMoveDown(false);
        } else {
            this.l.enableHeaderMoveDown(true);
        }
    }

    public void p() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.destroy();
            }
            c.a.t0.q1.o.e eVar = this.f21608h;
            if (eVar != null) {
                eVar.k();
            }
            NoNetworkView noNetworkView = this.f21607g;
            if (noNetworkView == null || (bVar = this.s) == null) {
                return;
            }
            noNetworkView.removeNetworkChangeListener(bVar);
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f21610j.getCurrentItem() < 0) {
                return 0;
            }
            return this.f21610j.getCurrentItem();
        }
        return invokeV.intValue;
    }

    public HotTopicView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k.getCurrentTab() : (HotTopicView) invokeV.objValue;
    }

    public HotTopicHeaderView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f21609i : (HotTopicHeaderView) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f21602b : (View) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.n - this.m) - this.o : invokeV.intValue;
    }

    public void w(int i2) {
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (hotTopicThreadPagerAdapter = this.k) == null) {
            return;
        }
        hotTopicThreadPagerAdapter.hideLoadMoreView(i2);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.k.hideNetRefreshView();
        }
    }

    public void y(int i2, boolean z, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f21608h.l(i2, z, j2, i3);
        }
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(c.a.t0.q1.f.hot_topic_activity);
        this.m = n.f(this.a.getPageActivity(), c.a.t0.q1.c.ds80);
        c.a.t0.q1.k.c cVar = new c.a.t0.q1.k.c(this.a.getOrignalPage().findViewById(c.a.t0.q1.e.topic_post_forum_button), this.a);
        this.r = cVar;
        cVar.e(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.a.getOrignalPage().findViewById(c.a.t0.q1.e.hot_topic_root_view);
        this.f21602b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(c.a.t0.q1.e.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.a.getOrignalPage().findViewById(c.a.t0.q1.e.view_navigation_bar);
        this.f21603c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.a.getOrignalPage().findViewById(c.a.t0.q1.e.view_navigation_bar_after_scroll);
        this.f21604d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f21604d.hideBottomLine();
        this.f21603c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f21603c.getBackImageView(), c.a.t0.q1.d.selector_topbar_return_white);
        this.f21604d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21605e = (ImageView) this.f21603c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.t0.q1.f.hot_topic_share, new View$OnClickListenerC1342c(this));
        this.f21606f = (ImageView) this.f21604d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.t0.q1.f.hot_topic_share, new d(this));
        this.f21607g = (NoNetworkView) this.f21602b.findViewById(c.a.t0.q1.e.view_no_network);
        ((ObservedChangeLinearLayout) this.f21602b.findViewById(c.a.t0.q1.e.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f21608h = new c.a.t0.q1.o.e(this.a, this.f21602b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f21602b.findViewById(c.a.t0.q1.e.hot_topic_header);
        this.f21609i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.f21610j = (CustomViewPager) this.f21602b.findViewById(c.a.t0.q1.e.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.setMainView(this);
        this.f21610j.setAdapter(this.k);
        this.f21609i.setViewPager(this.f21610j);
        this.f21609i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f21602b.findViewById(c.a.t0.q1.e.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}
