package c.a.r0.j1.f;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f19535a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f19536b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19537c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f19538d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19539e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19540f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f19541g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j1.f.e f19542h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicHeaderView f19543i;

    /* renamed from: j  reason: collision with root package name */
    public CustomViewPager f19544j;
    public HotTopicThreadPagerAdapter k;
    public DisableScrollLayout l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public ImageView q;
    public c.a.r0.j1.b.c r;
    public NoNetworkView.b s;
    public final c.a.q0.f1.j.e t;
    public final c.a.q0.f1.j.e u;
    public boolean v;
    public float w;
    public boolean x;
    public String y;
    public f z;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19545a;

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
            this.f19545a = cVar;
        }

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f19545a.o = i3;
                if (this.f19545a.f19543i != null) {
                    this.f19545a.f19543i.changePlaceHolderHeight(i3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19546a;

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
            this.f19546a = cVar;
        }

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f19546a.n = i3;
                this.f19546a.k.changeListViewFakeHeaderHeight(i3);
                this.f19546a.l.setHeaderViewHeight(i3);
            }
        }
    }

    /* renamed from: c.a.r0.j1.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0939c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19547e;

        public View$OnClickListenerC0939c(c cVar) {
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
            this.f19547e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f19547e.f19535a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f19547e.f19535a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f19547e.f19535a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f19547e.f19535a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f19547e.f19535a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19548e;

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
            this.f19548e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    ((HotTopicActivity) this.f19548e.f19535a.getOrignalPage()).showToast(R.string.topic_share_no_network);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f19548e.f19535a.getContext())) {
                    TiebaStatic.log(new StatisticItem("c10521").param("obj_id", ((HotTopicActivity) this.f19548e.f19535a.getOrignalPage()).getHotTopicId()).param("topic_id", ((HotTopicActivity) this.f19548e.f19535a.getOrignalPage()).getHotTopicId()));
                    ((HotTopicActivity) this.f19548e.f19535a.getOrignalPage()).shareTopic();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19549e;

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
            this.f19549e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicView currentTab;
            HotTopicActivity hotTopicActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || (currentTab = this.f19549e.k.getCurrentTab()) == null) {
                return;
            }
            if (absListView == currentTab.getListView()) {
                if (this.f19549e.f19542h != null) {
                    this.f19549e.f19542h.m(i2);
                }
                this.f19549e.G();
            }
            if (this.f19549e.k != null && this.f19549e.f19543i.getNavigationBarSwitchHeight() != this.f19549e.o) {
                if (this.f19549e.x) {
                    float navigationBarSwitchHeight = (-this.f19549e.f19543i.getY()) / (this.f19549e.f19543i.getNavigationBarSwitchHeight() - this.f19549e.o);
                    this.f19549e.f19537c.setAlpha(1.0f - navigationBarSwitchHeight);
                    this.f19549e.f19538d.setAlpha(navigationBarSwitchHeight);
                    if (this.f19549e.p != null) {
                        this.f19549e.p.setAlpha((-this.f19549e.f19543i.getY()) / (this.f19549e.f19543i.getNavigationBarSwitchHeight() - this.f19549e.o));
                    }
                } else {
                    if (this.f19549e.p != null) {
                        this.f19549e.p.setAlpha((-this.f19549e.f19543i.getY()) / (this.f19549e.f19543i.getNavigationBarSwitchHeight() - this.f19549e.o));
                    }
                    if (Math.abs(this.f19549e.w) == this.f19549e.v()) {
                        this.f19549e.f19538d.hideBottomLine();
                    } else {
                        this.f19549e.f19538d.showBottomLine();
                    }
                }
            }
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && (hotTopicActivity = (HotTopicActivity) this.f19549e.f19535a.getOrignalPage()) != null) {
                hotTopicActivity.onScrollToBottom();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            HotTopicView currentTab;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (currentTab = this.f19549e.k.getCurrentTab()) != null && absListView == currentTab.getListView() && i2 == 0) {
                this.f19549e.v = true;
                float y = this.f19549e.f19543i.getY();
                if (this.f19549e.k != null) {
                    if (Math.abs(this.f19549e.w) != this.f19549e.v() || this.f19549e.w == y) {
                        this.f19549e.k.scrollOtherListView((int) (this.f19549e.w - y));
                        return;
                    }
                    this.f19549e.k.scrollOtherListViewToTop(y);
                    this.f19549e.f19537c.hideBottomLine();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f19535a = tbPageContext;
        this.y = str;
        z();
    }

    public void A(List<c.a.r0.j1.c.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.k.updateList(list);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            NavigationBar navigationBar = this.f19537c;
            if (navigationBar != null && this.x) {
                navigationBar.onChangeSkinType(this.f19535a, i2);
                this.f19537c.setBackgroundResource(R.drawable.black_alpha_from_30_to_0);
                SkinManager.setImageResource(this.f19537c.getBackImageView(), R.drawable.selector_topbar_return_white);
                this.f19537c.setAlpha((this.f19543i.getY() / (this.f19543i.getNavigationBarSwitchHeight() - this.o)) + 1.0f);
            }
            NavigationBar navigationBar2 = this.f19538d;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.f19535a, i2);
                if (this.x) {
                    this.f19538d.setAlpha((-this.f19543i.getY()) / (this.f19543i.getNavigationBarSwitchHeight() - this.o));
                } else {
                    this.f19538d.setAlpha(1.0f);
                }
            }
            NoNetworkView noNetworkView = this.f19541g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f19535a, i2);
            }
            if (this.f19540f != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19540f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.f19539e != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19539e, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            HotTopicHeaderView hotTopicHeaderView = this.f19543i;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.onChangeSkinType();
            }
            HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = this.k;
            if (hotTopicThreadPagerAdapter != null) {
                hotTopicThreadPagerAdapter.onChangeSkinType(i2);
            }
            ImageView imageView = this.q;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_tabbar_chaticon_n);
                SkinManager.setImageResource(this.q, R.drawable.icon_tabbar_add_n);
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
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (noNetworkView = this.f19541g) == null) {
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
            this.w = this.f19543i.getY();
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
            NavigationBar navigationBar = this.f19538d;
            if (navigationBar != null) {
                this.p = navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f19543i.setVisibility(i2);
            this.f19544j.setVisibility(i2);
        }
    }

    public void J(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.s = bVar;
            NoNetworkView noNetworkView = this.f19541g;
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

    public void L(c.a.r0.j1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        if (!this.f19543i.isDataSet()) {
            this.f19543i.setData(eVar.h());
        }
        if (eVar.h() != null) {
            boolean z = !StringUtils.isNull(eVar.h().f19469i);
            this.x = z;
            this.f19537c.setVisibility(z ? 0 : 8);
            if (!this.x) {
                this.f19538d.setAlpha(1.0f);
                this.f19538d.showBottomLine();
            }
        }
        String str = eVar.h().f19466f;
        if (StringUtils.isNull(str)) {
            this.q.setVisibility(8);
            H("");
        } else {
            H(c.a.r0.j1.e.a.a(str, 10));
        }
        this.f19543i.setHeaderBottomLineShow(true);
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
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, absListView, i2) == null) || this.f19543i == null || this.l == null || (currentTab = this.k.getCurrentTab()) == null || currentTab.getListView() == null || absListView != currentTab.getListView()) {
            return;
        }
        this.l.setHeaderViewHeight(this.n - i2);
        this.f19543i.setY(-i2);
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
            c.a.r0.j1.f.e eVar = this.f19542h;
            if (eVar != null) {
                eVar.k();
            }
            NoNetworkView noNetworkView = this.f19541g;
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
            if (this.f19544j.getCurrentItem() < 0) {
                return 0;
            }
            return this.f19544j.getCurrentItem();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19543i : (HotTopicHeaderView) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : invokeV.intValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f19536b : (View) invokeV.objValue;
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
            this.f19542h.l(i2, z, j2, i3);
        }
    }

    public final void z() {
        TbPageContext<HotTopicActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tbPageContext = this.f19535a) == null) {
            return;
        }
        tbPageContext.getOrignalPage().setContentView(R.layout.hot_topic_activity);
        this.m = l.g(this.f19535a.getPageActivity(), R.dimen.ds80);
        c.a.r0.j1.b.c cVar = new c.a.r0.j1.b.c(this.f19535a.getOrignalPage().findViewById(R.id.topic_post_forum_button), this.f19535a);
        this.r = cVar;
        cVar.e(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) this.f19535a.getOrignalPage().findViewById(R.id.hot_topic_root_view);
        this.f19536b = relativeLayout;
        this.l = (DisableScrollLayout) relativeLayout.findViewById(R.id.disable_scroll_layout);
        NavigationBar navigationBar = (NavigationBar) this.f19535a.getOrignalPage().findViewById(R.id.view_navigation_bar);
        this.f19537c = navigationBar;
        navigationBar.hideBottomLine();
        NavigationBar navigationBar2 = (NavigationBar) this.f19535a.getOrignalPage().findViewById(R.id.view_navigation_bar_after_scroll);
        this.f19538d = navigationBar2;
        TextView centerTextTitle = navigationBar2.setCenterTextTitle("");
        this.p = centerTextTitle;
        centerTextTitle.setAlpha(0.0f);
        this.f19538d.hideBottomLine();
        this.f19537c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        SkinManager.setImageResource(this.f19537c.getBackImageView(), R.drawable.selector_topbar_return_white);
        this.f19538d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19539e = (ImageView) this.f19537c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View$OnClickListenerC0939c(this));
        this.f19540f = (ImageView) this.f19538d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f19541g = (NoNetworkView) this.f19536b.findViewById(R.id.view_no_network);
        ((ObservedChangeLinearLayout) this.f19536b.findViewById(R.id.hot_topic_observed_change_layout)).setOnSizeChangeListener(this.t);
        this.f19542h = new c.a.r0.j1.f.e(this.f19535a, this.f19536b);
        HotTopicHeaderView hotTopicHeaderView = (HotTopicHeaderView) this.f19536b.findViewById(R.id.hot_topic_header);
        this.f19543i = hotTopicHeaderView;
        hotTopicHeaderView.setOnSizeChangeListener(this.u);
        this.f19544j = (CustomViewPager) this.f19536b.findViewById(R.id.hot_topic_view_pager);
        HotTopicThreadPagerAdapter hotTopicThreadPagerAdapter = new HotTopicThreadPagerAdapter(this.f19535a.getPageActivity(), this.z);
        this.k = hotTopicThreadPagerAdapter;
        hotTopicThreadPagerAdapter.setMainView(this);
        this.f19544j.setAdapter(this.k);
        this.f19543i.setViewPager(this.f19544j);
        this.f19543i.setHeaderBottomLineShow(false);
        ImageView imageView = (ImageView) this.f19536b.findViewById(R.id.normal_write_icon);
        this.q = imageView;
        imageView.setVisibility(8);
    }
}
