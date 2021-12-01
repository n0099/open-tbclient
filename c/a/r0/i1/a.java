package c.a.r0.i1;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbListView a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f18176b;

    /* renamed from: c  reason: collision with root package name */
    public View f18177c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f18178d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f18179e;

    /* renamed from: f  reason: collision with root package name */
    public g f18180f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.i1.b.a f18181g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f18182h;

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
        this.f18176b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f18177c = this.f18176b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f18176b.findViewById(R.id.view_navigation_bar);
        this.f18178d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f18178d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18182h = (NoNetworkView) this.f18176b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f18176b.getPageContext().getPageActivity());
        this.a = pbListView;
        pbListView.a();
        this.a.Q();
        this.f18179e = (BdTypeListView) this.f18176b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f18176b.getPageContext());
        this.f18180f = gVar;
        BaseActivity baseActivity2 = this.f18176b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f18176b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f18179e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f18179e.setPullRefresh(this.f18180f);
        c.a.r0.i1.b.a aVar = new c.a.r0.i1.b.a(this.f18176b.getPageContext(), this.f18179e);
        this.f18181g = aVar;
        this.f18179e.addAdapters(aVar.a());
        this.f18179e.setNextPage(this.a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18179e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18179e.setVisibility(0);
            this.f18176b.hideLoadingView(this.f18177c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18179e.setVisibility(0);
            this.f18176b.hideNetRefreshView(this.f18177c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.C(this.f18176b.getResources().getString(R.string.network_ungeilivable));
            this.a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.C(this.f18176b.getResources().getString(R.string.list_no_more));
            this.a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.Q();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18181g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f18178d.onChangeSkinType(this.f18176b.getPageContext(), i2);
            this.a.p(R.color.CAM_X0204);
            this.a.E(SkinManager.getColor(R.color.CAM_X0109));
            this.a.d(i2);
            this.f18182h.onChangeSkinType(this.f18176b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f18182h.addNetworkChangeListener(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f18179e.setVisibility(8);
            this.f18176b.showLoadingView(this.f18177c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f18179e.setVisibility(8);
            this.f18176b.showNetRefreshView(this.f18177c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f18179e.startPullRefresh();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f18179e.setData(list);
    }
}
