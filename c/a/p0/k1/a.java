package c.a.p0.k1;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbListView a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f15934b;

    /* renamed from: c  reason: collision with root package name */
    public View f15935c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15936d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15937e;

    /* renamed from: f  reason: collision with root package name */
    public g f15938f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.k1.b.a f15939g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f15940h;

    public a(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15934b = baseActivity;
        baseActivity.setContentView(R.layout.obfuscated_res_0x7f0d0389);
        this.f15935c = this.f15934b.findViewById(R.id.obfuscated_res_0x7f090077);
        NavigationBar navigationBar = (NavigationBar) this.f15934b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15936d = navigationBar;
        navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f07c1);
        this.f15936d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15940h = (NoNetworkView) this.f15934b.findViewById(R.id.obfuscated_res_0x7f0923d1);
        PbListView pbListView = new PbListView(this.f15934b.getPageContext().getPageActivity());
        this.a = pbListView;
        pbListView.a();
        this.a.R();
        this.f15937e = (BdTypeListView) this.f15934b.findViewById(R.id.obfuscated_res_0x7f090cd3);
        g gVar = new g(this.f15934b.getPageContext());
        this.f15938f = gVar;
        BaseActivity baseActivity2 = this.f15934b;
        if (baseActivity2 instanceof f.g) {
            gVar.f((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f15934b;
        if (baseActivity3 instanceof BdListView.p) {
            this.f15937e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f15937e.setPullRefresh(this.f15938f);
        c.a.p0.k1.b.a aVar = new c.a.p0.k1.b.a(this.f15934b.getPageContext(), this.f15937e);
        this.f15939g = aVar;
        this.f15937e.a(aVar.a());
        this.f15937e.setNextPage(this.a);
    }

    public BdTypeListView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15937e : (BdTypeListView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15937e.setVisibility(0);
            this.f15934b.hideLoadingView(this.f15935c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15937e.setVisibility(0);
            this.f15934b.hideNetRefreshView(this.f15935c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.D(this.f15934b.getResources().getString(R.string.obfuscated_res_0x7f0f0c17));
            this.a.f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.D(this.f15934b.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
            this.a.f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.R();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15939g.b();
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f15936d.onChangeSkinType(this.f15934b.getPageContext(), i);
            this.a.p(R.color.CAM_X0204);
            this.a.F(SkinManager.getColor(R.color.CAM_X0109));
            this.a.d(i);
            this.f15940h.c(this.f15934b.getPageContext(), i);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f15940h.a(bVar);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15937e.setVisibility(8);
            this.f15934b.showLoadingView(this.f15935c, true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f15937e.setVisibility(8);
            this.f15934b.showNetRefreshView(this.f15935c, str, true);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15937e.F();
        }
    }

    public void m(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null) {
            return;
        }
        this.f15937e.setData(list);
    }
}
