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
    public BaseActivity f25291a;

    /* renamed from: b  reason: collision with root package name */
    public View f25292b;

    /* renamed from: c  reason: collision with root package name */
    public View f25293c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f25294d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f25295e;

    /* renamed from: f  reason: collision with root package name */
    public g f25296f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f25297g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.u0.c.o.a f25298h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25299e;

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
            this.f25299e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25299e.f25291a.finish();
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
        this.f25291a = baseActivity;
        baseActivity.setContentView(R.layout.forum_member_activity);
        this.f25292b = this.f25291a.findViewById(R.id.activity_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f25291a.findViewById(R.id.view_navigation_bar);
        this.f25294d = navigationBar;
        navigationBar.setCenterTextTitle(this.f25291a.getString(R.string.forummember)).setOnClickListener(new a(this));
        this.f25294d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25291a.setNetRefreshViewTopMargin(BdListViewHelper.f48610a);
        this.f25297g = (NoNetworkView) this.f25291a.findViewById(R.id.view_no_network);
        this.f25295e = (BdTypeListView) this.f25291a.findViewById(R.id.forum_member_listview);
        g gVar = new g(this.f25291a.getPageContext());
        this.f25296f = gVar;
        gVar.V(this.f25291a.getUniqueId());
        BaseActivity baseActivity2 = this.f25291a;
        if (baseActivity2 instanceof f.g) {
            this.f25296f.a((f.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.f25291a;
        if (baseActivity3 instanceof BdListView.p) {
            this.f25295e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.f25295e.setPullRefresh(this.f25296f);
        this.f25293c = BdListViewHelper.d(this.f25291a.getPageContext().getPageActivity(), this.f25295e, BdListViewHelper.HeadType.DEFAULT);
        c.a.r0.u0.c.o.a aVar = new c.a.r0.u0.c.o.a(this.f25291a, this.f25295e);
        this.f25298h = aVar;
        this.f25295e.addAdapters(aVar.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.f25293c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25295e.completePullRefreshPostDelayed(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25295e.setVisibility(0);
            this.f25291a.hideLoadingView(this.f25292b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25295e.setVisibility(0);
            this.f25291a.hideNetRefreshView(this.f25292b);
        }
    }

    public void f(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f25295e.setData(list);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25298h.b();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f25294d.onChangeSkinType(this.f25291a.getPageContext(), i2);
            this.f25297g.onChangeSkinType(this.f25291a.getPageContext(), i2);
            g();
            SkinManager.setBackgroundColor(this.f25292b, R.color.CAM_X0204);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25298h.c();
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f25297g.addNetworkChangeListener(bVar);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f25295e.setVisibility(8);
            this.f25291a.showLoadingView(this.f25292b, true);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f25295e.setVisibility(8);
            this.f25291a.showNetRefreshView(this.f25292b, str, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25295e.startPullRefresh();
        }
    }
}
