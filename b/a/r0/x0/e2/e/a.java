package b.a.r0.x0.e2.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25716a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.x0.e2.b.a f25717b;

    /* renamed from: c  reason: collision with root package name */
    public View f25718c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f25719d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f25720e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f25721f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f25722g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f25723h;

    /* renamed from: i  reason: collision with root package name */
    public g f25724i;
    public String j;
    public String k;

    /* renamed from: b.a.r0.x0.e2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1267a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25725e;

        public View$OnClickListenerC1267a(a aVar) {
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
            this.f25725e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25725e.g();
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
        this.f25716a = tbPageContext;
        this.j = str;
        this.k = str2;
        h();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25721f.completePullRefresh();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f25721f != null && j.z()) {
            this.f25721f.startPullRefresh();
        }
    }

    public FrameLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25719d : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25720e : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25718c : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f25716a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.f25716a.getPageActivity()).inflate(R.layout.frs_game_recommend_layout, (ViewGroup) null);
            this.f25718c = inflate;
            this.f25722g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.f25719d = (FrameLayout) this.f25718c.findViewById(R.id.game_recom_container);
            BdTypeListView bdTypeListView = (BdTypeListView) this.f25718c.findViewById(R.id.game_recom_listview);
            this.f25721f = bdTypeListView;
            bdTypeListView.setDivider(null);
            g gVar = new g(this.f25716a);
            this.f25724i = gVar;
            gVar.U(this.f25716a.getUniqueId());
            this.f25721f.setPullRefresh(this.f25724i);
            NavigationBar navigationBar = (NavigationBar) this.f25718c.findViewById(R.id.view_navigation_bar);
            this.f25720e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1267a(this));
            this.f25720e.showBottomLine();
            PbListView pbListView = new PbListView(this.f25716a.getPageActivity());
            this.f25723h = pbListView;
            pbListView.a();
            this.f25717b = new b.a.r0.x0.e2.b.a(this.f25716a, this.f25721f, this.j, this.k);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NoNetworkView noNetworkView = this.f25722g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f25716a, i2);
            }
            NavigationBar navigationBar = this.f25720e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f25716a, i2);
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
            this.f25717b.c(list);
        }
    }

    public void l(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f25724i.a(gVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25721f.setNextPage(null);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.f25721f.setOnSrollToBottomListener(pVar);
        }
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f25723h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25721f.setNextPage(this.f25723h);
        }
        this.f25723h.O();
        this.f25723h.Q();
    }

    public final void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f25723h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25721f.setNextPage(this.f25723h);
        }
        this.f25723h.C(this.f25716a.getPageActivity().getResources().getString(R.string.list_no_more));
        this.f25723h.f();
    }
}
