package c.a.r0.u0.c.o;

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
    public BaseActivity f25270a;

    /* renamed from: b  reason: collision with root package name */
    public View f25271b;

    /* renamed from: c  reason: collision with root package name */
    public View f25272c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f25273d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f25274e;

    /* renamed from: f  reason: collision with root package name */
    public g f25275f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f25276g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.u0.c.o.a f25277h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25278e;

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
            this.f25278e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25278e.f25270a.finish();
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
        this.f25270a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f25271b = this.f25270a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f25270a.findViewById(R.id.view_navigation_bar);
        this.f25273d = navigationBar;
        navigationBar.setCenterTextTitle(this.f25270a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f25273d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25270a.setNetRefreshViewTopMargin(BdListViewHelper.f48502a);
        this.f25276g = (NoNetworkView) this.f25270a.findViewById(R.id.view_no_network);
        this.f25274e = (BdTypeListView) this.f25270a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f25270a.getPageContext());
        this.f25275f = gVar;
        gVar.V(this.f25270a.getUniqueId());
        BaseActivity baseActivity2 = this.f25270a;
        if (baseActivity2 instanceof f.g) {
            this.f25275f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f25270a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f25274e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f25274e.setPullRefresh(this.f25275f);
        this.f25272c = BdListViewHelper.d(this.f25270a.getPageContext().getPageActivity(), this.f25274e, BdListViewHelper.HeadType.DEFAULT);
        c.a.r0.u0.c.o.a aVar = new c.a.r0.u0.c.o.a(this.f25270a, this.f25274e);
        this.f25277h = aVar;
        this.f25274e.addAdapters(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f25272c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25274e.completePullRefreshPostDelayed(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25274e.setVisibility(0);
            this.f25270a.hideLoadingView(this.f25271b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25274e.setVisibility(0);
            this.f25270a.hideNetRefreshView(this.f25271b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f25274e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25277h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f25273d.onChangeSkinType(this.f25270a.getPageContext(), i2);
            this.f25276g.onChangeSkinType(this.f25270a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f25271b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25277h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f25276g.addNetworkChangeListener(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f25274e.setVisibility(8);
            this.f25270a.showLoadingView(this.f25271b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f25274e.setVisibility(8);
            this.f25270a.showNetRefreshView(this.f25271b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25274e.startPullRefresh();
        }
    }
}
