package c.a.t0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.c1.a.h;
import c.a.t0.c1.c.l;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f15486b;

    /* renamed from: c  reason: collision with root package name */
    public h f15487c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15488d;

    /* renamed from: e  reason: collision with root package name */
    public View f15489e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f15490f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15491g;

    /* renamed from: h  reason: collision with root package name */
    public View f15492h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.t.i.b f15493i;

    /* renamed from: j  reason: collision with root package name */
    public h.d f15494j;

    /* loaded from: classes6.dex */
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

        @Override // c.a.t0.c1.a.h.d
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
        this.f15491g = false;
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f15489e = inflate;
        this.a.setContentView(inflate);
        this.f15492h = this.f15489e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f15489e.findViewById(R.id.view_navigation_bar);
        this.f15488d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.bawu_manager_team));
        this.f15488d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15488d.showBottomLine();
        this.f15490f = (NoNetworkView) this.f15489e.findViewById(R.id.view_no_network);
        this.f15486b = (BdListView) this.f15489e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.a.getPageContext());
        this.f15487c = hVar;
        this.f15486b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.f15494j = aVar;
        this.f15487c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.f15489e);
            this.f15486b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15492h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15491g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f15489e);
            this.f15488d.onChangeSkinType(this.a.getPageContext(), i2);
            this.f15490f.onChangeSkinType(this.a.getPageContext(), i2);
            this.f15487c.notifyDataSetChanged();
        }
    }

    public void g() {
        c.a.s0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f15493i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15490f.addNetworkChangeListener(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f15493i == null) {
                this.f15493i = new c.a.s0.t.i.b(this.a);
            }
            this.f15493i.p();
            this.f15493i.u(accountData);
            this.f15493i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15486b.setVisibility(8);
            this.a.showNetRefreshView(this.f15489e, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f15491g = false;
            } else {
                this.f15491g = true;
            }
            if (z && this.f15491g) {
                j();
                return;
            }
            c();
            this.f15487c.d(arrayList);
            this.f15487c.e(lVar);
            this.f15487c.notifyDataSetChanged();
        }
    }
}
