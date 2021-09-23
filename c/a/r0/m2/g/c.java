package c.a.r0.m2.g;

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
    public int f22402a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f22403b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f22404c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f22405d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f22406e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f22407f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22408g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.m2.d.c f22409h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.b4.c f22410i;

    /* renamed from: j  reason: collision with root package name */
    public View f22411j;
    public FrameLayout k;
    public c.a.q0.g0.h l;
    public PluginErrorTipView m;
    public InterfaceC1043c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22412e;

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
            this.f22412e = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f22412e.f22406e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f22412e.f22406e.hide();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && this.f22412e.f22406e != null && i2 == 1) {
                this.f22412e.f22406e.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22413e;

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
            this.f22413e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f22413e.d();
                if (this.f22413e.n != null) {
                    this.f22413e.n.a(view);
                }
            }
        }
    }

    /* renamed from: c.a.r0.m2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1043c {
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
        this.f22402a = 3;
        this.o = new a(this);
        if (view == null) {
            return;
        }
        this.f22403b = tbPageContext;
        this.f22404c = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
        this.f22405d = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
        this.f22406e = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
        this.m = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
        this.k = (FrameLayout) view.findViewById(R.id.layout_container);
        this.f22407f = (BdTypeListView) view.findViewById(R.id.person_center_listview);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
        View view2 = new View(tbPageContext.getPageActivity());
        this.f22411j = view2;
        view2.setLayoutParams(layoutParams);
        this.f22407f.addFooterView(this.f22411j);
        this.f22407f.setOnScrollListener(this.o);
        this.f22409h = new c.a.r0.m2.d.c(this.f22407f, tbPageContext, bdUniqueId);
        this.f22410i = new c.a.r0.b4.c(1);
    }

    public void c() {
        c.a.r0.m2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f22409h) == null) {
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
        hVar.dettachView(this.k);
        this.l = null;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22408g = this.f22405d.setCenterTextTitle(this.f22403b.getString(R.string.mine));
            this.f22410i.n(this.f22403b.getPageActivity(), this.f22405d);
            this.f22410i.k();
            this.f22410i.o(null);
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
            this.f22409h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f22402a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f22408g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f22411j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f22407f, R.color.CAM_X0201);
        this.f22405d.onChangeSkinType(this.f22403b, i2);
        SkinManager.setBackgroundColor(this.f22405d.getBarBgView(), R.color.CAM_X0207, i2);
        this.f22409h.c();
        this.f22404c.onChangeSkinType(this.f22403b, i2);
        this.m.onChangeSkinType(this.f22403b, i2);
        this.f22410i.m(i2);
        c.a.q0.g0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f22406e, R.drawable.personalize_tab_shadow);
        this.f22402a = i2;
    }

    public void i() {
        c.a.r0.m2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f22409h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(c.a.r0.m2.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f22409h.d(fVar.n());
    }

    public void k(InterfaceC1043c interfaceC1043c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC1043c) == null) {
            this.n = interfaceC1043c;
        }
    }

    public void l(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            this.f22403b.showToast(str);
        }
    }

    public void m() {
        c.a.r0.m2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f22409h) == null) {
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
            this.l = new c.a.q0.g0.h(this.f22403b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.o();
        this.l.onChangeSkinType();
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f22410i.p(i2, z);
        }
    }
}
