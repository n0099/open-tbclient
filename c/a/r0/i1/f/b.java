package c.a.r0.i1.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.r0.i1.c.p;
import c.a.r0.i1.f.f.c;
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
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.indicator.ScrollFragmentAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HotRanklistActivity f19335a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19336b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f19337c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19338d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f19339e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.i1.f.f.a f19340f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f19341g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f19342h;

    /* renamed from: i  reason: collision with root package name */
    public View f19343i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.i1.f.f.c f19344j;
    public boolean k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final c.a.q0.f1.j.e p;
    public c.InterfaceC0935c q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19345e;

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
            this.f19345e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19345e.m()) {
                    this.f19345e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f19345e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: c.a.r0.i1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0931b implements c.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19346a;

        public C0931b(b bVar) {
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
            this.f19346a = bVar;
        }

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f19346a.l = i3;
                if (this.f19346a.f19341g != null) {
                    this.f19346a.f19341g.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
                }
                if (this.f19346a.f19344j != null) {
                    this.f19346a.f19344j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.InterfaceC0935c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19347a;

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
            this.f19347a = bVar;
        }

        @Override // c.a.r0.i1.f.f.c.InterfaceC0935c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19347a.f19340f != null) {
                    this.f19347a.f19340f.d();
                }
                if (this.f19347a.f19344j != null) {
                    this.f19347a.f19344j.l(null);
                    b bVar = this.f19347a;
                    bVar.k = true;
                    bVar.f19344j = null;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19348e;

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
            this.f19348e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f19348e.f19335a.showToast(R.string.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f19348e.f19335a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f19348e.f19335a.shareTopic();
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
        this.f19336b = null;
        this.f19338d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C0931b(this);
        this.q = new c(this);
        this.f19335a = hotRanklistActivity;
        l();
    }

    public void g() {
        c.a.r0.i1.f.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f19344j) == null) {
            return;
        }
        cVar.f(this.f19335a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19339e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19342h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f19341g;
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
            this.f19341g.hideNetRefreshView();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.f19335a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f19343i = inflate;
        this.f19335a.setContentView(inflate);
        this.f19342h = (FrameLayout) this.f19335a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f19335a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f19336b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19338d = (ImageView) this.f19336b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f19336b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f19337c = (NoNetworkView) this.f19335a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f19343i.findViewById(R.id.topic_tab_bottom_line);
        c.a.r0.i1.f.f.a aVar = new c.a.r0.i1.f.f.a(this.f19335a.getActivity(), this.f19335a.findViewById(R.id.topic_tab_container));
        this.f19340f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f19335a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f19339e = (CustomViewPager) this.f19335a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f19335a.getActivity());
        this.f19341g = scrollFragmentAdapter;
        this.f19339e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.i1.f.f.c cVar = this.f19344j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<c.a.r0.i1.c.j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f19341g.updateList(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f19336b.onChangeSkinType(this.f19335a.getPageContext(), i2);
            SkinManager.setImageResource(this.f19338d, R.drawable.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19338d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f19340f.g(i2);
            this.f19335a.getLayoutMode().k(i2 == 1);
            this.f19335a.getLayoutMode().j(this.f19343i);
            this.f19337c.onChangeSkinType(this.f19335a.getPageContext(), i2);
            this.f19341g.updateList(null);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f19342h, R.color.CAM_X0201);
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
            this.f19341g.completePullRefresh(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f19337c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f19341g.getCount()) {
            return;
        }
        this.f19339e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f19337c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f19337c;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void v(int i2) {
        c.a.r0.i1.f.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f19340f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f19339e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f19341g.showLoadingView();
        }
    }

    public void y() {
        c.a.r0.i1.c.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f19344j == null) {
                c.a.r0.i1.f.f.c cVar = new c.a.r0.i1.f.f.c(this.f19342h);
                this.f19344j = cVar;
                cVar.l(this.q);
            }
            this.f19344j.m(this.l);
            if (this.f19344j.j() || (jVar = (c.a.r0.i1.c.j) ListUtils.getItem(this.f19341g.getHotTopicRanklistDataList(), 0)) == null) {
                return;
            }
            this.f19344j.n(this.f19335a.getActivity(), jVar.f19295b, this.f19339e.getCurrentItem());
            c.a.r0.i1.f.f.a aVar = this.f19340f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f19340f.i(this.f19339e);
        }
    }
}
