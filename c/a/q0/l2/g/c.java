package c.a.q0.l2.g;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f21813a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f21814b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f21815c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f21816d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f21817e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f21818f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21819g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.l2.d.c f21820h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.a4.c f21821i;

    /* renamed from: j  reason: collision with root package name */
    public View f21822j;
    public FrameLayout k;
    public c.a.p0.f0.h l;
    public PluginErrorTipView m;
    public InterfaceC1012c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21823e;

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
            this.f21823e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f21823e.f21817e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f21823e.f21817e.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f21823e.f21817e != null && i2 == 1) {
                this.f21823e.f21817e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21824e;

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
            this.f21824e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f21824e.d();
                if (this.f21824e.n != null) {
                    this.f21824e.n.a(view);
                }
            }
        }
    }

    /* renamed from: c.a.q0.l2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1012c {
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
        this.f21813a = 3;
        this.o = new a(this);
        if (view == null) {
            return;
        }
        this.f21814b = tbPageContext;
        this.f21815c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f21816d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f21817e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f21818f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.f21822j = view2;
        view2.setLayoutParams(layoutParams);
        this.f21818f.addFooterView(this.f21822j);
        this.f21818f.setOnScrollListener(this.o);
        this.f21820h = new c.a.q0.l2.d.c(this.f21818f, tbPageContext, bdUniqueId);
        this.f21821i = new c.a.q0.a4.c(1);
    }

    public void c() {
        c.a.q0.l2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f21820h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        c.a.p0.f0.h hVar;
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
            this.f21819g = this.f21816d.setCenterTextTitle(this.f21814b.getString(R.string.mine));
            this.f21821i.n(this.f21814b.getPageActivity(), this.f21816d);
            this.f21821i.k();
            this.f21821i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.f0.h hVar = this.l;
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
            this.f21820h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f21813a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f21819g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f21822j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f21818f, R.color.CAM_X0201);
        this.f21816d.onChangeSkinType(this.f21814b, i2);
        SkinManager.setBackgroundColor(this.f21816d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f21820h.c();
        this.f21815c.onChangeSkinType(this.f21814b, i2);
        this.m.onChangeSkinType(this.f21814b, i2);
        this.f21821i.m(i2);
        c.a.p0.f0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f21817e, R.drawable.personalize_tab_shadow);
        this.f21813a = i2;
    }

    public void i() {
        c.a.q0.l2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f21820h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(c.a.q0.l2.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f21820h.d(fVar.n());
    }

    public void k(InterfaceC1012c interfaceC1012c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1012c) == null) {
            this.n = interfaceC1012c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f21814b.showToast(str);
        }
    }

    public void m() {
        c.a.q0.l2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f21820h) == null) {
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
            this.l = new c.a.p0.f0.h(this.f21814b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f21821i.p(i2, z);
        }
    }
}
