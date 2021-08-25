package c.a.q0.h1.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.h1.c.p;
import c.a.q0.h1.f.f.c;
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
    public HotRanklistActivity f18679a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18680b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f18681c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f18682d;

    /* renamed from: e  reason: collision with root package name */
    public CustomViewPager f18683e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.h1.f.f.a f18684f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentAdapter f18685g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f18686h;

    /* renamed from: i  reason: collision with root package name */
    public View f18687i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.h1.f.f.c f18688j;
    public boolean k;
    public int l;
    public ImageView m;
    public NoNetworkView.b n;
    public View.OnClickListener o;
    public final c.a.p0.d1.j.e p;
    public c.InterfaceC0898c q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18689e;

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
            this.f18689e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18689e.m()) {
                    this.f18689e.g();
                    view.setContentDescription("展开");
                    return;
                }
                this.f18689e.y();
                view.setContentDescription("折叠");
            }
        }
    }

    /* renamed from: c.a.q0.h1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0894b implements c.a.p0.d1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18690a;

        public C0894b(b bVar) {
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
            this.f18690a = bVar;
        }

        @Override // c.a.p0.d1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f18690a.l = i3;
                if (this.f18690a.f18685g != null) {
                    this.f18690a.f18685g.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
                }
                if (this.f18690a.f18688j != null) {
                    this.f18690a.f18688j.k(i3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.InterfaceC0898c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f18691a;

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
            this.f18691a = bVar;
        }

        @Override // c.a.q0.h1.f.f.c.InterfaceC0898c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18691a.f18684f != null) {
                    this.f18691a.f18684f.d();
                }
                if (this.f18691a.f18688j != null) {
                    this.f18691a.f18688j.l(null);
                    b bVar = this.f18691a;
                    bVar.k = true;
                    bVar.f18688j = null;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18692e;

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
            this.f18692e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f18692e.f18679a.showToast(R.string.topic_share_no_network);
                } else if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f18692e.f18679a)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", "6"));
                    this.f18692e.f18679a.shareTopic();
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
        this.f18680b = null;
        this.f18682d = null;
        this.n = null;
        this.o = new a(this);
        this.p = new C0894b(this);
        this.q = new c(this);
        this.f18679a = hotRanklistActivity;
        l();
    }

    public void g() {
        c.a.q0.h1.f.f.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f18688j) == null) {
            return;
        }
        cVar.f(this.f18679a.getActivity());
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18683e.getCurrentItem() : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18686h : (View) invokeV.objValue;
    }

    public int j(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pVar)) == null) {
            ScrollFragmentAdapter scrollFragmentAdapter = this.f18685g;
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
            this.f18685g.hideNetRefreshView();
        }
    }

    public final void l() {
        HotRanklistActivity hotRanklistActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hotRanklistActivity = this.f18679a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(hotRanklistActivity.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
        this.f18687i = inflate;
        this.f18679a.setContentView(inflate);
        this.f18686h = (FrameLayout) this.f18679a.findViewById(R.id.topic_tab_widget_content_container);
        NavigationBar navigationBar = (NavigationBar) this.f18679a.findViewById(R.id.topic_fragment_navigation_bar);
        this.f18680b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18682d = (ImageView) this.f18680b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new d(this));
        this.f18680b.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
        this.f18681c = (NoNetworkView) this.f18679a.findViewById(R.id.topic_view_no_network);
        this.m = (ImageView) this.f18687i.findViewById(R.id.topic_tab_bottom_line);
        c.a.q0.h1.f.f.a aVar = new c.a.q0.h1.f.f.a(this.f18679a.getActivity(), this.f18679a.findViewById(R.id.topic_tab_container));
        this.f18684f = aVar;
        aVar.h(this.o);
        ((ObservedChangeLinearLayout) this.f18679a.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.p);
        this.f18683e = (CustomViewPager) this.f18679a.findViewById(R.id.topic_tab_widget_view_pager);
        ScrollFragmentAdapter scrollFragmentAdapter = new ScrollFragmentAdapter(this.f18679a.getActivity());
        this.f18685g = scrollFragmentAdapter;
        this.f18683e.setAdapter(scrollFragmentAdapter);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.q0.h1.f.f.c cVar = this.f18688j;
            return cVar != null && cVar.j();
        }
        return invokeV.booleanValue;
    }

    public void n(List<c.a.q0.h1.c.j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18685g.updateList(list);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f18680b.onChangeSkinType(this.f18679a.getPageContext(), i2);
            SkinManager.setImageResource(this.f18682d, R.drawable.icon_nav_hot_share_selector);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18682d, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f18684f.g(i2);
            this.f18679a.getLayoutMode().k(i2 == 1);
            this.f18679a.getLayoutMode().j(this.f18687i);
            this.f18681c.onChangeSkinType(this.f18679a.getPageContext(), i2);
            this.f18685g.updateList(null);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f18686h, R.color.CAM_X0201);
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
            this.f18685g.completePullRefresh(false);
        }
    }

    public void r() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (noNetworkView = this.f18681c) == null || (bVar = this.n) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0 || i2 >= this.f18685g.getCount()) {
            return;
        }
        this.f18683e.setCurrentItem(i2, false);
    }

    public void t(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (noNetworkView = this.f18681c) == null) {
            return;
        }
        noNetworkView.setVisibility(i2);
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.n = bVar;
            NoNetworkView noNetworkView = this.f18681c;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void v(int i2) {
        c.a.q0.h1.f.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (aVar = this.f18684f) == null) {
            return;
        }
        aVar.j(i2);
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f18683e.setVisibility(i2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f18685g.showLoadingView();
        }
    }

    public void y() {
        c.a.q0.h1.c.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f18688j == null) {
                c.a.q0.h1.f.f.c cVar = new c.a.q0.h1.f.f.c(this.f18686h);
                this.f18688j = cVar;
                cVar.l(this.q);
            }
            this.f18688j.m(this.l);
            if (this.f18688j.j() || (jVar = (c.a.q0.h1.c.j) ListUtils.getItem(this.f18685g.getHotTopicRanklistDataList(), 0)) == null) {
                return;
            }
            this.f18688j.n(this.f18679a.getActivity(), jVar.f18639b, this.f18683e.getCurrentItem());
            c.a.q0.h1.f.f.a aVar = this.f18684f;
            if (aVar != null) {
                aVar.k();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f18684f.i(this.f18683e);
        }
    }
}
