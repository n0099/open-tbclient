package c.a.p0.z2.f;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f20969b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f20970c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f20971d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f20972e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f20973f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20974g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.z2.c.c f20975h;
    public c.a.p0.q4.d i;
    public View j;
    public FrameLayout k;
    public c.a.o0.f0.h l;
    public PluginErrorTipView m;
    public InterfaceC1563c n;
    public AbsListView.OnScrollListener o;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.a.f20972e == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.a.f20972e.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && this.a.f20972e != null && i == 1) {
                this.a.f20972e.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.a.d();
                if (this.a.n != null) {
                    this.a.n.a(view);
                }
            }
        }
    }

    /* renamed from: c.a.p0.z2.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1563c {
        void a(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f20969b = tbPageContext;
        this.f20970c = (NoNetworkView) view.findViewById(R.id.obfuscated_res_0x7f091796);
        this.f20971d = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f091795);
        this.f20972e = (NavigationBarShadowView) view.findViewById(R.id.obfuscated_res_0x7f09150b);
        this.m = (PluginErrorTipView) view.findViewById(R.id.obfuscated_res_0x7f091799);
        this.k = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f0911d1);
        this.f20973f = (BdTypeListView) view.findViewById(R.id.obfuscated_res_0x7f09178b);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070263));
        View view2 = new View(tbPageContext.getPageActivity());
        this.j = view2;
        view2.setLayoutParams(layoutParams);
        this.f20973f.addFooterView(this.j);
        this.f20973f.setOnScrollListener(this.o);
        this.f20975h = new c.a.p0.z2.c.c(this.f20973f, tbPageContext, bdUniqueId);
        this.i = new c.a.p0.q4.d(1);
    }

    public void c() {
        c.a.p0.z2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f20975h) == null) {
            return;
        }
        cVar.a();
    }

    public void d() {
        c.a.o0.f0.h hVar;
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
            this.f20974g = this.f20971d.setCenterTextTitle(this.f20969b.getString(R.string.mine));
            this.i.n(this.f20969b.getPageActivity(), this.f20971d);
            this.i.k();
            this.i.o(null);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.f0.h hVar = this.l;
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
            this.f20975h.b();
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f20974g, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f20973f, R.color.CAM_X0201);
        this.f20971d.onChangeSkinType(this.f20969b, i);
        SkinManager.setBackgroundColor(this.f20971d.getBarBgView(), R.color.CAM_X0207, i);
        this.f20975h.c();
        this.f20970c.c(this.f20969b, i);
        this.m.e(this.f20969b, i);
        this.i.m(i);
        c.a.o0.f0.h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f20972e, R.drawable.personalize_tab_shadow);
        this.a = i;
    }

    public void i() {
        c.a.p0.z2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.f20975h) == null) {
            return;
        }
        cVar.a();
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.f20973f.setVisibility(8);
            } else {
                this.f20973f.setVisibility(0);
            }
        }
    }

    public void k(c.a.p0.z2.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f20975h.d(fVar.n());
    }

    public void l(InterfaceC1563c interfaceC1563c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, interfaceC1563c) == null) {
            this.n = interfaceC1563c;
        }
    }

    public void m(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            this.f20969b.showToast(str);
        }
    }

    public void n() {
        c.a.p0.z2.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.f20975h) == null) {
            return;
        }
        cVar.e();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || f()) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.o0.f0.h(this.f20969b.getPageActivity(), new b(this));
        }
        this.l.attachView(this.k, false);
        this.l.p();
        this.l.onChangeSkinType();
    }

    public void p(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.i.p(i, z);
        }
    }
}
