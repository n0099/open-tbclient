package c.a.r0.c1;

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
    public PbListView f16085a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f16086b;

    /* renamed from: c  reason: collision with root package name */
    public View f16087c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f16088d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f16089e;

    /* renamed from: f  reason: collision with root package name */
    public g f16090f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.c1.b.a f16091g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f16092h;

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
        this.f16086b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f16087c = this.f16086b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f16086b.findViewById(R.id.view_navigation_bar);
        this.f16088d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f16088d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16092h = (NoNetworkView) this.f16086b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f16086b.getPageContext().getPageActivity());
        this.f16085a = pbListView;
        pbListView.a();
        this.f16085a.O();
        this.f16089e = (BdTypeListView) this.f16086b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f16086b.getPageContext());
        this.f16090f = gVar;
        BaseActivity baseActivity2 = this.f16086b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f16086b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f16089e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f16089e.setPullRefresh(this.f16090f);
        c.a.r0.c1.b.a aVar = new c.a.r0.c1.b.a(this.f16086b.getPageContext(), this.f16089e);
        this.f16091g = aVar;
        this.f16089e.addAdapters(aVar.a());
        this.f16089e.setNextPage(this.f16085a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16089e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16089e.setVisibility(0);
            this.f16086b.hideLoadingView(this.f16087c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16089e.setVisibility(0);
            this.f16086b.hideNetRefreshView(this.f16087c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16085a.A(this.f16086b.getResources().getString(R.string.network_ungeilivable));
            this.f16085a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16085a.A(this.f16086b.getResources().getString(R.string.list_no_more));
            this.f16085a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16085a.O();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16091g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f16088d.onChangeSkinType(this.f16086b.getPageContext(), i2);
            this.f16085a.o(R.color.CAM_X0204);
            this.f16085a.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f16085a.d(i2);
            this.f16092h.onChangeSkinType(this.f16086b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f16092h.addNetworkChangeListener(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16089e.setVisibility(8);
            this.f16086b.showLoadingView(this.f16087c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f16089e.setVisibility(8);
            this.f16086b.showNetRefreshView(this.f16087c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f16089e.startPullRefresh();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f16089e.setData(list);
    }
}
