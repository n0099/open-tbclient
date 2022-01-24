package c.a.t0.w2.f;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f24835b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f24836c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24837d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f24838e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f24839f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24840g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.w2.c.c f24841h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.n4.c f24842i;

    /* renamed from: j  reason: collision with root package name */
    public View f24843j;
    public FrameLayout k;
    public c.a.s0.g0.h l;
    public PluginErrorTipView m;
    public InterfaceC1502c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes8.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24844e;

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
            this.f24844e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f24844e.f24838e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f24844e.f24838e.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f24844e.f24838e != null && i2 == 1) {
                this.f24844e.f24838e.show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24845e;

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
            this.f24845e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.f24845e.d();
                if (this.f24845e.n != null) {
                    this.f24845e.n.a(view);
                }
            }
        }
    }

    /* renamed from: c.a.t0.w2.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1502c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.o = new a(this);
        if (view == null) {
            return;
        }
        this.f24835b = tbPageContext;
        this.f24836c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f24837d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f24838e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f24839f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.f24843j = view2;
        view2.setLayoutParams(layoutParams);
        this.f24839f.addFooterView(this.f24843j);
        this.f24839f.setOnScrollListener(this.o);
        this.f24841h = new c.a.t0.w2.c.c(this.f24839f, tbPageContext, bdUniqueId);
        this.f24842i = new c.a.t0.n4.c(1);
    }

    public void c() {
        c.a.t0.w2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f24841h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.l) == null) {
            return;
        }
        hVar.dettachView(this.k);
        this.l = null;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24840g = this.f24837d.setCenterTextTitle(this.f24835b.getString(R.string.mine));
            this.f24842i.n(this.f24835b.getPageActivity(), this.f24837d);
            this.f24842i.k();
            this.f24842i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.g0.h hVar = this.l;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24841h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f24840g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f24843j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f24839f, R.color.CAM_X0201);
        this.f24837d.onChangeSkinType(this.f24835b, i2);
        SkinManager.setBackgroundColor(this.f24837d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f24841h.c();
        this.f24836c.onChangeSkinType(this.f24835b, i2);
        this.m.onChangeSkinType(this.f24835b, i2);
        this.f24842i.m(i2);
        c.a.s0.g0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f24838e, R.drawable.personalize_tab_shadow);
        this.a = i2;
    }

    public void i() {
        c.a.t0.w2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f24841h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(c.a.t0.w2.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f24841h.d(fVar.n());
    }

    public void k(InterfaceC1502c interfaceC1502c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1502c) == null) {
            this.n = interfaceC1502c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f24835b.showToast(str);
        }
    }

    public void m() {
        c.a.t0.w2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f24841h) == null) {
            return;
        }
        cVar.e();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || f()) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.s0.g0.h(this.f24835b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.p();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f24842i.p(i2, z);
        }
    }
}
