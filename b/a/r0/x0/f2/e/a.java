package b.a.r0.x0.f2.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.m.e.n;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27311a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.x0.f2.b.a f27312b;

    /* renamed from: c  reason: collision with root package name */
    public View f27313c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f27314d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f27315e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f27316f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f27317g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f27318h;

    /* renamed from: i  reason: collision with root package name */
    public g f27319i;
    public String j;
    public String k;

    /* renamed from: b.a.r0.x0.f2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1340a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27320e;

        public View$OnClickListenerC1340a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27320e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27320e.g();
            }
        }
    }

    public a(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27311a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27316f.completePullRefresh();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f27316f != null && j.z()) {
            this.f27316f.startPullRefresh();
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27314d : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27315e : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27313c : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f27311a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f27311a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
            this.f27313c = inflate;
            this.f27317g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f27314d = (FrameLayout) this.f27313c.findViewById(R.id.game_recom_container);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f27313c.findViewById(R.id.game_recom_listview);
            this.f27316f = bdTypeListView;
            bdTypeListView.setDivider(null);
            g gVar = new g(this.f27311a);
            this.f27319i = gVar;
            gVar.U(this.f27311a.getUniqueId());
            this.f27316f.setPullRefresh(this.f27319i);
            NavigationBar navigationBar = (NavigationBar) this.f27313c.findViewById(R.id.view_navigation_bar);
            this.f27315e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1340a(this));
            this.f27315e.showBottomLine();
            PbListView pbListView = new PbListView(this.f27311a.getPageActivity());
            this.f27318h = pbListView;
            pbListView.a();
            this.f27312b = new b.a.r0.x0.f2.b.a(this.f27311a, this.f27316f, this.j, this.k);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NoNetworkView noNetworkView = this.f27317g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f27311a, i2);
            }
            NavigationBar navigationBar = this.f27315e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f27311a, i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void k(List<n> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) {
            if (z) {
                o();
            } else {
                p();
            }
            this.f27312b.c(list);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f27319i.a(gVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f27316f.setNextPage(null);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.f27316f.setOnSrollToBottomListener(pVar);
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f27318h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f27316f.setNextPage(this.f27318h);
        }
        this.f27318h.O();
        this.f27318h.Q();
    }

    public final void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f27318h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f27316f.setNextPage(this.f27318h);
        }
        this.f27318h.C(this.f27311a.getPageActivity().getResources().getString(R.string.list_no_more));
        this.f27318h.f();
    }
}
