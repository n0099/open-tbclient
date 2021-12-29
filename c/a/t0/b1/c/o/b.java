package c.a.t0.b1.c.o;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.i0.f;
import c.a.s0.s.i0.g;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15557b;

    /* renamed from: c  reason: collision with root package name */
    public View f15558c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15559d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f15560e;

    /* renamed from: f  reason: collision with root package name */
    public g f15561f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f15562g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.b1.c.o.a f15563h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15564e;

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
            this.f15564e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15564e.a.finish();
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
        this.a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f15557b = this.a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f15559d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f15559d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.f15562g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        this.f15560e = (BdTypeListView) this.a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.a.getPageContext());
        this.f15561f = gVar;
        gVar.V(this.a.getUniqueId());
        BaseActivity baseActivity2 = this.a;
        if (baseActivity2 instanceof f.g) {
            this.f15561f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f15560e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f15560e.setPullRefresh(this.f15561f);
        this.f15558c = BdListViewHelper.d(this.a.getPageContext().getPageActivity(), this.f15560e, BdListViewHelper.HeadType.DEFAULT);
        c.a.t0.b1.c.o.a aVar = new c.a.t0.b1.c.o.a(this.a, this.f15560e);
        this.f15563h = aVar;
        this.f15560e.addAdapters(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f15558c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15560e.completePullRefreshPostDelayed(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15560e.setVisibility(0);
            this.a.hideLoadingView(this.f15557b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15560e.setVisibility(0);
            this.a.hideNetRefreshView(this.f15557b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f15560e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15563h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15559d.onChangeSkinType(this.a.getPageContext(), i2);
            this.f15562g.onChangeSkinType(this.a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f15557b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15563h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f15562g.addNetworkChangeListener(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15560e.setVisibility(8);
            this.a.showLoadingView(this.f15557b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f15560e.setVisibility(8);
            this.a.showNetRefreshView(this.f15557b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15560e.startPullRefresh();
        }
    }
}
