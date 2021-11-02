package b.a.r0.v0.c.o;

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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f24299a;

    /* renamed from: b  reason: collision with root package name */
    public View f24300b;

    /* renamed from: c  reason: collision with root package name */
    public View f24301c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24302d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f24303e;

    /* renamed from: f  reason: collision with root package name */
    public g f24304f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f24305g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.v0.c.o.a f24306h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24307e;

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
            this.f24307e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24307e.f24299a.finish();
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
        this.f24299a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f24300b = this.f24299a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f24299a.findViewById(R.id.view_navigation_bar);
        this.f24302d = navigationBar;
        navigationBar.setCenterTextTitle(this.f24299a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f24302d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24299a.setNetRefreshViewTopMargin(BdListViewHelper.f46057a);
        this.f24305g = (NoNetworkView) this.f24299a.findViewById(R.id.view_no_network);
        this.f24303e = (BdTypeListView) this.f24299a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f24299a.getPageContext());
        this.f24304f = gVar;
        gVar.U(this.f24299a.getUniqueId());
        BaseActivity baseActivity2 = this.f24299a;
        if (baseActivity2 instanceof f.g) {
            this.f24304f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f24299a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f24303e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f24303e.setPullRefresh(this.f24304f);
        this.f24301c = BdListViewHelper.d(this.f24299a.getPageContext().getPageActivity(), this.f24303e, BdListViewHelper.HeadType.DEFAULT);
        b.a.r0.v0.c.o.a aVar = new b.a.r0.v0.c.o.a(this.f24299a, this.f24303e);
        this.f24306h = aVar;
        this.f24303e.addAdapters(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f24301c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24303e.completePullRefreshPostDelayed(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24303e.setVisibility(0);
            this.f24299a.hideLoadingView(this.f24300b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24303e.setVisibility(0);
            this.f24299a.hideNetRefreshView(this.f24300b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f24303e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24306h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f24302d.onChangeSkinType(this.f24299a.getPageContext(), i2);
            this.f24305g.onChangeSkinType(this.f24299a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f24300b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24306h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f24305g.addNetworkChangeListener(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f24303e.setVisibility(8);
            this.f24299a.showLoadingView(this.f24300b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f24303e.setVisibility(8);
            this.f24299a.showNetRefreshView(this.f24300b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24303e.startPullRefresh();
        }
    }
}
