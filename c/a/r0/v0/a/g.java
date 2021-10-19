package c.a.r0.v0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.v0.a.h;
import c.a.r0.v0.c.l;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f25391a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f25392b;

    /* renamed from: c  reason: collision with root package name */
    public h f25393c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f25394d;

    /* renamed from: e  reason: collision with root package name */
    public View f25395e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f25396f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25397g;

    /* renamed from: h  reason: collision with root package name */
    public View f25398h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.t.i.b f25399i;

    /* renamed from: j  reason: collision with root package name */
    public h.d f25400j;

    /* loaded from: classes3.dex */
    public class a implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f25401a;

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
            this.f25401a = gVar;
        }

        @Override // c.a.r0.v0.a.h.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.f25401a.f25391a.getPageContext(), new String[]{str});
                } else {
                    this.f25401a.i(TbadkCoreApplication.getCurrentAccountInfo());
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
        this.f25397g = false;
        this.f25391a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f25395e = inflate;
        this.f25391a.setContentView(inflate);
        this.f25398h = this.f25395e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f25395e.findViewById(R.id.view_navigation_bar);
        this.f25394d = navigationBar;
        navigationBar.setCenterTextTitle(this.f25391a.getString(R.string.bawu_manager_team));
        this.f25394d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25394d.showBottomLine();
        this.f25396f = (NoNetworkView) this.f25395e.findViewById(R.id.view_no_network);
        this.f25392b = (BdListView) this.f25395e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f25391a.getPageContext());
        this.f25393c = hVar;
        this.f25392b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.f25400j = aVar;
        this.f25393c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25391a.hideNetRefreshView(this.f25395e);
            this.f25392b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25398h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25397g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f25391a.getLayoutMode().k(i2 == 1);
            this.f25391a.getLayoutMode().j(this.f25395e);
            this.f25394d.onChangeSkinType(this.f25391a.getPageContext(), i2);
            this.f25396f.onChangeSkinType(this.f25391a.getPageContext(), i2);
            this.f25393c.notifyDataSetChanged();
        }
    }

    public void g() {
        c.a.q0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f25399i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f25396f.addNetworkChangeListener(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f25399i == null) {
                this.f25399i = new c.a.q0.t.i.b(this.f25391a);
            }
            this.f25399i.p();
            this.f25399i.u(accountData);
            this.f25399i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25392b.setVisibility(8);
            this.f25391a.showNetRefreshView(this.f25395e, this.f25391a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f25397g = false;
            } else {
                this.f25397g = true;
            }
            if (z && this.f25397g) {
                j();
                return;
            }
            c();
            this.f25393c.d(arrayList);
            this.f25393c.e(lVar);
            this.f25393c.notifyDataSetChanged();
        }
    }
}
