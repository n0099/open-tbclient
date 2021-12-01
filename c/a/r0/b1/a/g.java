package c.a.r0.b1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.b1.a.h;
import c.a.r0.b1.c.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f14686b;

    /* renamed from: c  reason: collision with root package name */
    public h f14687c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f14688d;

    /* renamed from: e  reason: collision with root package name */
    public View f14689e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f14690f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14691g;

    /* renamed from: h  reason: collision with root package name */
    public View f14692h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.t.i.b f14693i;

    /* renamed from: j  reason: collision with root package name */
    public h.d f14694j;

    /* loaded from: classes5.dex */
    public class a implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.r0.b1.a.h.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                } else {
                    this.a.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        }
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bawuTeamInfoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14691g = false;
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f14689e = inflate;
        this.a.setContentView(inflate);
        this.f14692h = this.f14689e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f14689e.findViewById(R.id.view_navigation_bar);
        this.f14688d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.bawu_manager_team));
        this.f14688d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f14688d.showBottomLine();
        this.f14690f = (NoNetworkView) this.f14689e.findViewById(R.id.view_no_network);
        this.f14686b = (BdListView) this.f14689e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.a.getPageContext());
        this.f14687c = hVar;
        this.f14686b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.f14694j = aVar;
        this.f14687c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.f14689e);
            this.f14686b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14692h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14691g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f14689e);
            this.f14688d.onChangeSkinType(this.a.getPageContext(), i2);
            this.f14690f.onChangeSkinType(this.a.getPageContext(), i2);
            this.f14687c.notifyDataSetChanged();
        }
    }

    public void g() {
        c.a.q0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f14693i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f14690f.addNetworkChangeListener(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f14693i == null) {
                this.f14693i = new c.a.q0.t.i.b(this.a);
            }
            this.f14693i.p();
            this.f14693i.u(accountData);
            this.f14693i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14686b.setVisibility(8);
            this.a.showNetRefreshView(this.f14689e, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f14691g = false;
            } else {
                this.f14691g = true;
            }
            if (z && this.f14691g) {
                j();
                return;
            }
            c();
            this.f14687c.d(arrayList);
            this.f14687c.e(lVar);
            this.f14687c.notifyDataSetChanged();
        }
    }
}
