package c.a.s0.q1.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.s0.q1.f;
import c.a.s0.q1.h;
import c.a.s0.q1.l.j;
import c.a.s0.q1.l.p;
import c.a.s0.q1.o.f.c;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotRanklistActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21688b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f21689c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f21690d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f21691e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.q1.o.f.a f21692f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f21693g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f21694h;

    /* renamed from: i  reason: collision with root package name */
    public View f21695i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.q1.o.f.c f21696j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21697k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final c.a.r0.f1.j.e p;
    public c.InterfaceC1304c q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21698e;

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
            this.f21698e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21698e.m()) {
                    this.f21698e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f21698e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: c.a.s0.q1.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1300b implements c.a.r0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1300b(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.r0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a.l = i3;
                if (this.a.f21693g != null) {
                    this.a.f21693g.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
                }
                if (this.a.f21696j != null) {
                    this.a.f21696j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.InterfaceC1304c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.s0.q1.o.f.c.InterfaceC1304c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f21692f != null) {
                    this.a.f21692f.d();
                }
                if (this.a.f21696j != null) {
                    this.a.f21696j.l(null);
                    b bVar = this.a;
                    bVar.f21697k = true;
                    bVar.f21696j = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21699e;

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
            this.f21699e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!k.z()) {
                    this.f21699e.a.showToast(h.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f21699e.a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f21699e.a.shareTopic();
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
        this.f21688b = null;
        this.f21690d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C1300b(this);
        this.q = new c(this);
        this.a = hotRanklistActivity;
        l();
    }

    public void g() {
        c.a.s0.q1.o.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f21696j) == null) {
            return;
        }
        cVar.f(this.a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21691e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21694h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f21693g;
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
            this.f21693g.hideNetRefreshView();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(f.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f21695i = inflate;
        this.a.setContentView(inflate);
        this.f21694h = (FrameLayout) this.a.findViewById(c.a.s0.q1.e.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.s0.q1.e.topic_fragment_navigation_bar);
        this.f21688b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21690d = (ImageView) this.f21688b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.hot_topic_share, new d(this));
        this.f21688b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(h.hot_topic_card_title));
        this.f21689c = (NoNetworkView) this.a.findViewById(c.a.s0.q1.e.topic_view_no_network);
        this.m = (ImageView) this.f21695i.findViewById(c.a.s0.q1.e.topic_tab_bottom_line);
        c.a.s0.q1.o.f.a aVar = new c.a.s0.q1.o.f.a(this.a.getActivity(), this.a.findViewById(c.a.s0.q1.e.topic_tab_container));
        this.f21692f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.a.findViewById(c.a.s0.q1.e.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f21691e = (CustomViewPager) this.a.findViewById(c.a.s0.q1.e.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.a.getActivity());
        this.f21693g = scrollFragmentAdapter;
        this.f21691e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.q1.o.f.c cVar = this.f21696j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f21693g.updateList(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f21688b.onChangeSkinType(this.a.getPageContext(), i2);
            SkinManager.setImageResource(this.f21690d, c.a.s0.q1.d.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21690d, c.a.s0.q1.d.icon_pure_topbar_share44_svg, c.a.s0.q1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f21692f.g(i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f21695i);
            this.f21689c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21693g.updateList(null);
            SkinManager.setBackgroundColor(this.m, c.a.s0.q1.b.CAM_X0204);
            SkinManager.setBackgroundColor(this.f21694h, c.a.s0.q1.b.CAM_X0201);
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
            this.f21693g.completePullRefresh(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f21689c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f21693g.getCount()) {
            return;
        }
        this.f21691e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f21689c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f21689c;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void v(int i2) {
        c.a.s0.q1.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f21692f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f21691e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f21693g.showLoadingView();
        }
    }

    public void y() {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f21696j == null) {
                c.a.s0.q1.o.f.c cVar = new c.a.s0.q1.o.f.c(this.f21694h);
                this.f21696j = cVar;
                cVar.l(this.q);
            }
            this.f21696j.m(this.l);
            if (this.f21696j.j() || (jVar = (j) ListUtils.getItem(this.f21693g.getHotTopicRanklistDataList(), 0)) == null) {
                return;
            }
            this.f21696j.n(this.a.getActivity(), jVar.f21651b, this.f21691e.getCurrentItem());
            c.a.s0.q1.o.f.a aVar = this.f21692f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f21692f.i(this.f21691e);
        }
    }
}
