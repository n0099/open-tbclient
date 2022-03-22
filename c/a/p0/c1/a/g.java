package c.a.p0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.c1.a.h;
import c.a.p0.c1.c.l;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeamInfoActivity a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f13386b;

    /* renamed from: c  reason: collision with root package name */
    public h f13387c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f13388d;

    /* renamed from: e  reason: collision with root package name */
    public View f13389e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f13390f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13391g;

    /* renamed from: h  reason: collision with root package name */
    public View f13392h;
    public c.a.o0.s.i.b i;
    public h.d j;
    public TextView k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BawuTeamInfoActivity f13393b;

        public a(g gVar, long j, BawuTeamInfoActivity bawuTeamInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j), bawuTeamInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.f13393b = bawuTeamInfoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13393b.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f13393b, "", "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.a, true)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.p0.c1.a.h.d
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

    public g(BawuTeamInfoActivity bawuTeamInfoActivity, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bawuTeamInfoActivity, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13391g = false;
        this.a = bawuTeamInfoActivity;
        View inflate = LayoutInflater.from(bawuTeamInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d014a, (ViewGroup) null);
        this.f13389e = inflate;
        this.a.setContentView(inflate);
        this.f13392h = this.f13389e.findViewById(R.id.obfuscated_res_0x7f091ada);
        NavigationBar navigationBar = (NavigationBar) this.f13389e.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f13388d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f02e9));
        this.f13388d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = new TextView(bawuTeamInfoActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(bawuTeamInfoActivity, R.dimen.tbds160), -2);
        layoutParams.rightMargin = n.f(bawuTeamInfoActivity, R.dimen.M_W_X011);
        this.k.setText(R.string.obfuscated_res_0x7f0f040a);
        this.k.setTextColor(R.color.CAM_X0107);
        this.k.setLayoutParams(layoutParams);
        this.k.setOnClickListener(new a(this, j, bawuTeamInfoActivity));
        this.f13388d.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).addView(this.k);
        this.f13388d.showBottomLine();
        this.f13390f = (NoNetworkView) this.f13389e.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f13386b = (BdListView) this.f13389e.findViewById(R.id.obfuscated_res_0x7f091282);
        h hVar = new h(this.a.getPageContext());
        this.f13387c = hVar;
        this.f13386b.setAdapter((ListAdapter) hVar);
        b bVar = new b(this);
        this.j = bVar;
        this.f13387c.f(bVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.hideNetRefreshView(this.f13389e);
            this.f13386b.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13392h : (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13391g : invokeV.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f13389e);
            this.f13388d.onChangeSkinType(this.a.getPageContext(), i);
            this.f13390f.c(this.a.getPageContext(), i);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.k);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0107);
            this.f13387c.notifyDataSetChanged();
        }
    }

    public void g() {
        c.a.o0.s.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.s();
    }

    public void h(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f13390f.a(bVar);
        }
    }

    public final void i(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, accountData) == null) {
            if (this.i == null) {
                this.i = new c.a.o0.s.i.b(this.a);
            }
            this.i.p();
            this.i.u(accountData);
            this.i.z(1);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f13386b.setVisibility(8);
            this.a.showNetRefreshView(this.f13389e, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d), true);
        }
    }

    public void k(ArrayList<i> arrayList, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, lVar, z) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f13391g = false;
            } else {
                this.f13391g = true;
            }
            if (z && this.f13391g) {
                j();
                return;
            }
            c();
            this.f13387c.d(arrayList);
            this.f13387c.e(lVar);
            this.f13387c.notifyDataSetChanged();
        }
    }
}
