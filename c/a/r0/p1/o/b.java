package c.a.r0.p1.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.r0.p1.f;
import c.a.r0.p1.h;
import c.a.r0.p1.l.p;
import c.a.r0.p1.o.f.c;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotRanklistActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21203b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f21204c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f21205d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f21206e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.p1.o.f.a f21207f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f21208g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f21209h;

    /* renamed from: i  reason: collision with root package name */
    public View f21210i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.p1.o.f.c f21211j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21212k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final c.a.q0.f1.j.e p;
    public c.InterfaceC1253c q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21213e;

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
            this.f21213e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21213e.m()) {
                    this.f21213e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f21213e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: c.a.r0.p1.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1249b implements c.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1249b(b bVar) {
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

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.a.l = i3;
                if (this.a.f21208g != null) {
                    this.a.f21208g.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
                }
                if (this.a.f21211j != null) {
                    this.a.f21211j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.InterfaceC1253c {
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

        @Override // c.a.r0.p1.o.f.c.InterfaceC1253c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f21207f != null) {
                    this.a.f21207f.d();
                }
                if (this.a.f21211j != null) {
                    this.a.f21211j.l(null);
                    b bVar = this.a;
                    bVar.f21212k = true;
                    bVar.f21211j = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21214e;

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
            this.f21214e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f21214e.a.showToast(h.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f21214e.a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f21214e.a.shareTopic();
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
        this.f21203b = null;
        this.f21205d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C1249b(this);
        this.q = new c(this);
        this.a = hotRanklistActivity;
        l();
    }

    public void g() {
        c.a.r0.p1.o.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f21211j) == null) {
            return;
        }
        cVar.f(this.a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21206e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21209h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f21208g;
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
            this.f21208g.hideNetRefreshView();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(f.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f21210i = inflate;
        this.a.setContentView(inflate);
        this.f21209h = (FrameLayout) this.a.findViewById(c.a.r0.p1.e.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.r0.p1.e.topic_fragment_navigation_bar);
        this.f21203b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21205d = (ImageView) this.f21203b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.hot_topic_share, new d(this));
        this.f21203b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(h.hot_topic_card_title));
        this.f21204c = (NoNetworkView) this.a.findViewById(c.a.r0.p1.e.topic_view_no_network);
        this.m = (ImageView) this.f21210i.findViewById(c.a.r0.p1.e.topic_tab_bottom_line);
        c.a.r0.p1.o.f.a aVar = new c.a.r0.p1.o.f.a(this.a.getActivity(), this.a.findViewById(c.a.r0.p1.e.topic_tab_container));
        this.f21207f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.a.findViewById(c.a.r0.p1.e.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f21206e = (CustomViewPager) this.a.findViewById(c.a.r0.p1.e.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.a.getActivity());
        this.f21208g = scrollFragmentAdapter;
        this.f21206e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.p1.o.f.c cVar = this.f21211j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<c.a.r0.p1.l.j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f21208g.updateList(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f21203b.onChangeSkinType(this.a.getPageContext(), i2);
            SkinManager.setImageResource(this.f21205d, c.a.r0.p1.d.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21205d, c.a.r0.p1.d.icon_pure_topbar_share44_svg, c.a.r0.p1.b.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f21207f.g(i2);
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f21210i);
            this.f21204c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f21208g.updateList(null);
            SkinManager.setBackgroundColor(this.m, c.a.r0.p1.b.CAM_X0204);
            SkinManager.setBackgroundColor(this.f21209h, c.a.r0.p1.b.CAM_X0201);
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
            this.f21208g.completePullRefresh(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f21204c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f21208g.getCount()) {
            return;
        }
        this.f21206e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f21204c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f21204c;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void v(int i2) {
        c.a.r0.p1.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f21207f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f21206e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f21208g.showLoadingView();
        }
    }

    public void y() {
        c.a.r0.p1.l.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f21211j == null) {
                c.a.r0.p1.o.f.c cVar = new c.a.r0.p1.o.f.c(this.f21209h);
                this.f21211j = cVar;
                cVar.l(this.q);
            }
            this.f21211j.m(this.l);
            if (this.f21211j.j() || (jVar = (c.a.r0.p1.l.j) ListUtils.getItem(this.f21208g.getHotTopicRanklistDataList(), 0)) == null) {
                return;
            }
            this.f21211j.n(this.a.getActivity(), jVar.f21166b, this.f21206e.getCurrentItem());
            c.a.r0.p1.o.f.a aVar = this.f21207f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f21207f.i(this.f21206e);
        }
    }
}
