package b.a.r0.c1;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbListView f16558a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f16559b;

    /* renamed from: c  reason: collision with root package name */
    public View f16560c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f16561d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f16562e;

    /* renamed from: f  reason: collision with root package name */
    public g f16563f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.c1.b.a f16564g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f16565h;

    public a(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16559b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f16560c = this.f16559b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f16559b.findViewById(R.id.view_navigation_bar);
        this.f16561d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f16561d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16565h = (NoNetworkView) this.f16559b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f16559b.getPageContext().getPageActivity());
        this.f16558a = pbListView;
        pbListView.a();
        this.f16558a.Q();
        this.f16562e = (BdTypeListView) this.f16559b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f16559b.getPageContext());
        this.f16563f = gVar;
        BaseActivity baseActivity2 = this.f16559b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f16559b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f16562e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f16562e.setPullRefresh(this.f16563f);
        b.a.r0.c1.b.a aVar = new b.a.r0.c1.b.a(this.f16559b.getPageContext(), this.f16562e);
        this.f16564g = aVar;
        this.f16562e.addAdapters(aVar.a());
        this.f16562e.setNextPage(this.f16558a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16562e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16562e.setVisibility(0);
            this.f16559b.hideLoadingView(this.f16560c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16562e.setVisibility(0);
            this.f16559b.hideNetRefreshView(this.f16560c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16558a.C(this.f16559b.getResources().getString(R.string.network_ungeilivable));
            this.f16558a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16558a.C(this.f16559b.getResources().getString(R.string.list_no_more));
            this.f16558a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16558a.Q();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16564g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f16561d.onChangeSkinType(this.f16559b.getPageContext(), i2);
            this.f16558a.p(R.color.CAM_X0204);
            this.f16558a.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f16558a.d(i2);
            this.f16565h.onChangeSkinType(this.f16559b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f16565h.addNetworkChangeListener(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16562e.setVisibility(8);
            this.f16559b.showLoadingView(this.f16560c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f16562e.setVisibility(8);
            this.f16559b.showNetRefreshView(this.f16560c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f16562e.startPullRefresh();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f16562e.setData(list);
    }
}
