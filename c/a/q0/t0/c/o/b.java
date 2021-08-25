package c.a.q0.t0.c.o;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f24588a;

    /* renamed from: b  reason: collision with root package name */
    public View f24589b;

    /* renamed from: c  reason: collision with root package name */
    public View f24590c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24591d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f24592e;

    /* renamed from: f  reason: collision with root package name */
    public g f24593f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f24594g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.t0.c.o.a f24595h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24596e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24596e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24596e.f24588a.finish();
            }
        }
    }

    public b(BaseActivity baseActivity) {
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
        this.f24588a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f24589b = this.f24588a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f24588a.findViewById(R.id.view_navigation_bar);
        this.f24591d = navigationBar;
        navigationBar.setCenterTextTitle(this.f24588a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f24591d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24588a.setNetRefreshViewTopMargin(BdListViewHelper.f48369a);
        this.f24594g = (NoNetworkView) this.f24588a.findViewById(R.id.view_no_network);
        this.f24592e = (BdTypeListView) this.f24588a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f24588a.getPageContext());
        this.f24593f = gVar;
        gVar.V(this.f24588a.getUniqueId());
        BaseActivity baseActivity2 = this.f24588a;
        if (baseActivity2 instanceof f.g) {
            this.f24593f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f24588a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f24592e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f24592e.setPullRefresh(this.f24593f);
        this.f24590c = BdListViewHelper.d(this.f24588a.getPageContext().getPageActivity(), this.f24592e, BdListViewHelper.HeadType.DEFAULT);
        c.a.q0.t0.c.o.a aVar = new c.a.q0.t0.c.o.a(this.f24588a, this.f24592e);
        this.f24595h = aVar;
        this.f24592e.addAdapters(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f24590c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24592e.completePullRefreshPostDelayed(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24592e.setVisibility(0);
            this.f24588a.hideLoadingView(this.f24589b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24592e.setVisibility(0);
            this.f24588a.hideNetRefreshView(this.f24589b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f24592e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24595h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f24591d.onChangeSkinType(this.f24588a.getPageContext(), i2);
            this.f24594g.onChangeSkinType(this.f24588a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f24589b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24595h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f24594g.addNetworkChangeListener(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f24592e.setVisibility(8);
            this.f24588a.showLoadingView(this.f24589b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f24592e.setVisibility(8);
            this.f24588a.showNetRefreshView(this.f24589b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24592e.startPullRefresh();
        }
    }
}
