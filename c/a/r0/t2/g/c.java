package c.a.r0.t2.g;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23731b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f23732c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23733d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f23734e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f23735f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23736g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.t2.d.c f23737h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.k4.c f23738i;

    /* renamed from: j  reason: collision with root package name */
    public View f23739j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f23740k;
    public c.a.q0.g0.h l;
    public PluginErrorTipView m;
    public InterfaceC1365c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes6.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23741e;

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
            this.f23741e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f23741e.f23734e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f23741e.f23734e.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f23741e.f23734e != null && i2 == 1) {
                this.f23741e.f23734e.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23742e;

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
            this.f23742e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f23742e.d();
                if (this.f23742e.n != null) {
                    this.f23742e.n.a(view);
                }
            }
        }
    }

    /* renamed from: c.a.r0.t2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1365c {
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
        this.f23731b = tbPageContext;
        this.f23732c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f23733d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f23734e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.f23740k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f23735f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.f23739j = view2;
        view2.setLayoutParams(layoutParams);
        this.f23735f.addFooterView(this.f23739j);
        this.f23735f.setOnScrollListener(this.o);
        this.f23737h = new c.a.r0.t2.d.c(this.f23735f, tbPageContext, bdUniqueId);
        this.f23738i = new c.a.r0.k4.c(1);
    }

    public void c() {
        c.a.r0.t2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f23737h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        c.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.l) == null) {
            return;
        }
        hVar.dettachView(this.f23740k);
        this.l = null;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23736g = this.f23733d.setCenterTextTitle(this.f23731b.getString(R.string.mine));
            this.f23738i.n(this.f23731b.getPageActivity(), this.f23733d);
            this.f23738i.k();
            this.f23738i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.q0.g0.h hVar = this.l;
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
            this.f23737h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f23736g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f23739j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f23735f, R.color.CAM_X0201);
        this.f23733d.onChangeSkinType(this.f23731b, i2);
        SkinManager.setBackgroundColor(this.f23733d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f23737h.c();
        this.f23732c.onChangeSkinType(this.f23731b, i2);
        this.m.onChangeSkinType(this.f23731b, i2);
        this.f23738i.m(i2);
        c.a.q0.g0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f23734e, R.drawable.personalize_tab_shadow);
        this.a = i2;
    }

    public void i() {
        c.a.r0.t2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f23737h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(c.a.r0.t2.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23737h.d(fVar.n());
    }

    public void k(InterfaceC1365c interfaceC1365c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1365c) == null) {
            this.n = interfaceC1365c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f23731b.showToast(str);
        }
    }

    public void m() {
        c.a.r0.t2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f23737h) == null) {
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
            this.l = new c.a.q0.g0.h(this.f23731b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.f23740k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f23738i.p(i2, z);
        }
    }
}
