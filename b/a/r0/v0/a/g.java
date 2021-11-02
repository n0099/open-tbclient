package b.a.r0.v0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.v0.a.h;
import b.a.r0.v0.c.l;
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

    /* renamed from: a  reason: collision with root package name */
    public BawuTeamInfoActivity f24228a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f24229b;

    /* renamed from: c  reason: collision with root package name */
    public h f24230c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24231d;

    /* renamed from: e  reason: collision with root package name */
    public View f24232e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f24233f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24234g;

    /* renamed from: h  reason: collision with root package name */
    public View f24235h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.t.i.b f24236i;
    public h.d j;

    /* loaded from: classes5.dex */
    public class a implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f24237a;

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
            this.f24237a = gVar;
        }

        @Override // b.a.r0.v0.a.h.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    UrlManager.getInstance().dealOneLink(this.f24237a.f24228a.getPageContext(), new String[]{str});
                } else {
                    this.f24237a.i(TbadkCoreApplication.getCurrentAccountInfo());
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
        this.f24234g = false;
        this.f24228a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.f24232e = inflate;
        this.f24228a.setContentView(inflate);
        this.f24235h = this.f24232e.findViewById(R.id.root_bawu_team_info);
        NavigationBar navigationBar = (NavigationBar) this.f24232e.findViewById(R.id.view_navigation_bar);
        this.f24231d = navigationBar;
        navigationBar.setCenterTextTitle(this.f24228a.getString(R.string.bawu_manager_team));
        this.f24231d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24231d.showBottomLine();
        this.f24233f = (NoNetworkView) this.f24232e.findViewById(R.id.view_no_network);
        this.f24229b = (BdListView) this.f24232e.findViewById(R.id.listview_bawu_team_info);
        h hVar = new h(this.f24228a.getPageContext());
        this.f24230c = hVar;
        this.f24229b.setAdapter((ListAdapter) hVar);
        a aVar = new a(this);
        this.j = aVar;
        this.f24230c.f(aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24228a.hideNetRefreshView(this.f24232e);
            this.f24229b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24235h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24234g : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f24228a.getLayoutMode().k(i2 == 1);
            this.f24228a.getLayoutMode().j(this.f24232e);
            this.f24231d.onChangeSkinType(this.f24228a.getPageContext(), i2);
            this.f24233f.onChangeSkinType(this.f24228a.getPageContext(), i2);
            this.f24230c.notifyDataSetChanged();
        }
    }

    public void g() {
        b.a.q0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f24236i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f24233f.addNetworkChangeListener(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.f24236i == null) {
                this.f24236i = new b.a.q0.t.i.b(this.f24228a);
            }
            this.f24236i.p();
            this.f24236i.u(accountData);
            this.f24236i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24229b.setVisibility(8);
            this.f24228a.showNetRefreshView(this.f24232e, this.f24228a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f24234g = false;
            } else {
                this.f24234g = true;
            }
            if (z && this.f24234g) {
                j();
                return;
            }
            c();
            this.f24230c.d(arrayList);
            this.f24230c.e(lVar);
            this.f24230c.notifyDataSetChanged();
        }
    }
}
