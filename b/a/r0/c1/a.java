package b.a.r0.c1;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
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
    public PbListView f15120a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f15121b;

    /* renamed from: c  reason: collision with root package name */
    public View f15122c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15123d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15124e;

    /* renamed from: f  reason: collision with root package name */
    public g f15125f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.c1.b.a f15126g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f15127h;

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
        this.f15121b = baseActivity;
        baseActivity.setContentView(R.layout.god_square_activity);
        this.f15122c = this.f15121b.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f15121b.findViewById(R.id.view_navigation_bar);
        this.f15123d = navigationBar;
        navigationBar.setTitleText(R.string.god_square);
        this.f15123d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15127h = (NoNetworkView) this.f15121b.findViewById(R.id.view_no_network);
        PbListView pbListView = new PbListView(this.f15121b.getPageContext().getPageActivity());
        this.f15120a = pbListView;
        pbListView.a();
        this.f15120a.Q();
        this.f15124e = (BdTypeListView) this.f15121b.findViewById(R.id.god_square_list_view);
        g gVar = new g(this.f15121b.getPageContext());
        this.f15125f = gVar;
        BaseActivity baseActivity2 = this.f15121b;
        if (baseActivity2 instanceof f.g) {
            gVar.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f15121b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f15124e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f15124e.setPullRefresh(this.f15125f);
        b.a.r0.c1.b.a aVar = new b.a.r0.c1.b.a(this.f15121b.getPageContext(), this.f15124e);
        this.f15126g = aVar;
        this.f15124e.addAdapters(aVar.a());
        this.f15124e.setNextPage(this.f15120a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15124e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15124e.setVisibility(0);
            this.f15121b.hideLoadingView(this.f15122c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15124e.setVisibility(0);
            this.f15121b.hideNetRefreshView(this.f15122c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15120a.C(this.f15121b.getResources().getString(R.string.network_ungeilivable));
            this.f15120a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15120a.C(this.f15121b.getResources().getString(R.string.list_no_more));
            this.f15120a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15120a.Q();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15126g.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f15123d.onChangeSkinType(this.f15121b.getPageContext(), i2);
            this.f15120a.p(R.color.CAM_X0204);
            this.f15120a.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f15120a.d(i2);
            this.f15127h.onChangeSkinType(this.f15121b.getPageContext(), i2);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f15127h.addNetworkChangeListener(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15124e.setVisibility(8);
            this.f15121b.showLoadingView(this.f15122c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f15124e.setVisibility(8);
            this.f15121b.showNetRefreshView(this.f15122c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15124e.startPullRefresh();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f15124e.setData(list);
    }
}
