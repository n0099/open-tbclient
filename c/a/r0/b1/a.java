package c.a.r0.b1;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbListView f15913a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f15914b;

    /* renamed from: c  reason: collision with root package name */
    public View f15915c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15916d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15917e;

    /* renamed from: f  reason: collision with root package name */
    public g f15918f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.b1.b.a f15919g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f15920h;

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
        this.f15914b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f15915c = this.f15914b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f15914b.findViewById(R.id.view_navigation_bar);
        this.f15916d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f15916d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15920h = (NoNetworkView) this.f15914b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f15914b.getPageContext().getPageActivity());
        this.f15913a = pbListView;
        pbListView.a();
        this.f15913a.O();
        this.f15917e = (BdTypeListView) this.f15914b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f15914b.getPageContext());
        this.f15918f = gVar;
        BaseActivity baseActivity2 = this.f15914b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f15914b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f15917e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f15917e.setPullRefresh(this.f15918f);
        c.a.r0.b1.b.a aVar = new c.a.r0.b1.b.a(this.f15914b.getPageContext(), this.f15917e);
        this.f15919g = aVar;
        this.f15917e.addAdapters(aVar.a());
        this.f15917e.setNextPage(this.f15913a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15917e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15917e.setVisibility(0);
            this.f15914b.hideLoadingView(this.f15915c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15917e.setVisibility(0);
            this.f15914b.hideNetRefreshView(this.f15915c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15913a.A(this.f15914b.getResources().getString(R.string.network_ungeilivable));
            this.f15913a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15913a.A(this.f15914b.getResources().getString(R.string.list_no_more));
            this.f15913a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15913a.O();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15919g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f15916d.onChangeSkinType(this.f15914b.getPageContext(), i2);
            this.f15913a.o(R.color.CAM_X0204);
            this.f15913a.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f15913a.d(i2);
            this.f15920h.onChangeSkinType(this.f15914b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f15920h.addNetworkChangeListener(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15917e.setVisibility(8);
            this.f15914b.showLoadingView(this.f15915c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f15917e.setVisibility(8);
            this.f15914b.showNetRefreshView(this.f15915c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15917e.startPullRefresh();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f15917e.setData(list);
    }
}
