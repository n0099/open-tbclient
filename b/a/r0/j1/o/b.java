package b.a.r0.j1.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.r0.j1.f;
import b.a.r0.j1.h;
import b.a.r0.j1.l.p;
import b.a.r0.j1.o.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.indicator.ScrollFragmentAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f18498a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18499b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f18500c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f18501d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f18502e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.j1.o.f.a f18503f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f18504g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f18505h;

    /* renamed from: i  reason: collision with root package name */
    public View f18506i;
    public b.a.r0.j1.o.f.c j;
    public boolean k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final b.a.q0.f1.j.e p;
    public c.InterfaceC0940c q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18507e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18507e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18507e.m()) {
                    this.f18507e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f18507e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: b.a.r0.j1.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0936b implements b.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18508a;

        public C0936b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18508a = bVar;
        }

        @Override // b.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f18508a.l = i3;
                if (this.f18508a.f18504g != null) {
                    this.f18508a.f18504g.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
                }
                if (this.f18508a.j != null) {
                    this.f18508a.j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.InterfaceC0940c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18509a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18509a = bVar;
        }

        @Override // b.a.r0.j1.o.f.c.InterfaceC0940c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18509a.f18503f != null) {
                    this.f18509a.f18503f.d();
                }
                if (this.f18509a.j != null) {
                    this.f18509a.j.l(null);
                    b bVar = this.f18509a;
                    bVar.k = true;
                    bVar.j = null;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18510e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18510e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f18510e.f18498a.showToast(h.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f18510e.f18498a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f18510e.f18498a.shareTopic();
                }
            }
        }
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18499b = null;
        this.f18501d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C0936b(this);
        this.q = new c(this);
        this.f18498a = hotRanklistActivity;
        l();
    }

    public void g() {
        b.a.r0.j1.o.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.f(this.f18498a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18502e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18505h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f18504g;
            if (scrollFragmentAdapter == null) {
                return -1;
            }
            return scrollFragmentAdapter.getTagIndex(pVar);
        }
        return invokeL.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f18504g.hideNetRefreshView();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.f18498a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(f.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f18506i = inflate;
        this.f18498a.setContentView(inflate);
        this.f18505h = (FrameLayout) this.f18498a.findViewById(b.a.r0.j1.e.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f18498a.findViewById(b.a.r0.j1.e.topic_fragment_navigation_bar);
        this.f18499b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18501d = (ImageView) this.f18499b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.hot_topic_share, new d(this));
        this.f18499b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(h.hot_topic_card_title));
        this.f18500c = (NoNetworkView) this.f18498a.findViewById(b.a.r0.j1.e.topic_view_no_network);
        this.m = (ImageView) this.f18506i.findViewById(b.a.r0.j1.e.topic_tab_bottom_line);
        b.a.r0.j1.o.f.a aVar = new b.a.r0.j1.o.f.a(this.f18498a.getActivity(), this.f18498a.findViewById(b.a.r0.j1.e.topic_tab_container));
        this.f18503f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f18498a.findViewById(b.a.r0.j1.e.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f18502e = (CustomViewPager) this.f18498a.findViewById(b.a.r0.j1.e.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f18498a.getActivity());
        this.f18504g = scrollFragmentAdapter;
        this.f18502e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.r0.j1.o.f.c cVar = this.j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<b.a.r0.j1.l.j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18504g.updateList(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f18499b.onChangeSkinType(this.f18498a.getPageContext(), i2);
            SkinManager.setImageResource(this.f18501d, b.a.r0.j1.d.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18501d, b.a.r0.j1.d.icon_pure_topbar_share44_svg, b.a.r0.j1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f18503f.g(i2);
            this.f18498a.getLayoutMode().k(i2 == 1);
            this.f18498a.getLayoutMode().j(this.f18506i);
            this.f18500c.onChangeSkinType(this.f18498a.getPageContext(), i2);
            this.f18504g.updateList(null);
            SkinManager.setBackgroundColor(this.m, b.a.r0.j1.b.CAM_X0204);
            SkinManager.setBackgroundColor(this.f18505h, b.a.r0.j1.b.CAM_X0201);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (m()) {
                g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18504g.completePullRefresh(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f18500c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f18504g.getCount()) {
            return;
        }
        this.f18502e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f18500c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f18500c;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void v(int i2) {
        b.a.r0.j1.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f18503f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f18502e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f18504g.showLoadingView();
        }
    }

    public void y() {
        b.a.r0.j1.l.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.j == null) {
                b.a.r0.j1.o.f.c cVar = new b.a.r0.j1.o.f.c(this.f18505h);
                this.j = cVar;
                cVar.l(this.q);
            }
            this.j.m(this.l);
            if (this.j.j() || (jVar = (b.a.r0.j1.l.j) ListUtils.getItem(this.f18504g.getHotTopicRanklistDataList(), 0)) == null) {
                return;
            }
            this.j.n(this.f18498a.getActivity(), jVar.f18461b, this.f18502e.getCurrentItem());
            b.a.r0.j1.o.f.a aVar = this.f18503f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f18503f.i(this.f18502e);
        }
    }
}
