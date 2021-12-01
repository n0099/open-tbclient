package c.a.r0.o3;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.g0.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j extends c.a.d.a.d<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public SignAllForumActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f20981b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20982c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f20983d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f20984e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f20985f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.g0.g f20986g;

    /* renamed from: h  reason: collision with root package name */
    public g f20987h;

    /* renamed from: i  reason: collision with root package name */
    public c f20988i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f20989j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f20990k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f20991e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20991e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20991e.a.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20986g = null;
        this.a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f20982c = (RelativeLayout) this.a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f20981b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.signallforum));
        this.f20981b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f20981b.showBottomLine();
        BdListView bdListView = (BdListView) this.a.findViewById(R.id.signallforum_list);
        this.f20985f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(signAllForumActivity.getPageContext());
        this.f20986g = gVar;
        this.f20985f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f20985f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.a.getPageContext().getPageActivity());
        this.f20983d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f20984e = progressBar;
        progressBar.setOnClickListener(this.a);
        this.f20985f.addHeaderView(this.f20983d);
        this.f20983d.setVisibility(8);
        this.f20989j = (RelativeLayout) this.f20983d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f20983d.findViewById(R.id.guideopenbtn);
        this.f20990k = (TextView) this.f20983d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f20983d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.a);
        g gVar2 = new g(this.a, null);
        this.f20987h = gVar2;
        this.f20985f.setAdapter((ListAdapter) gVar2);
        this.f20985f.setOnScrollListener(this.f20987h);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20985f.completePullRefreshPostDelayed(0L);
        }
    }

    public final void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f20988i) == null) {
            return;
        }
        this.f20983d.setHasPrivilege(cVar.B());
        this.f20983d.setmCurrentStatus(this.f20988i.q());
        TextView message1 = this.f20983d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f20988i.v() + this.f20988i.t() + this.f20988i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f20988i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f20988i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f20983d.getMessage2().setText(this.f20988i.w());
        this.f20990k.setText(this.f20988i.h());
        if (TextUtils.isEmpty(this.f20988i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f20988i.g());
        }
        this.f20983d.setVisibility(0);
        if (!this.f20988i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.f20989j.setVisibility(0);
        } else {
            this.f20989j.setVisibility(8);
        }
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20987h : (g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20988i : (c) invokeV.objValue;
    }

    public LinearLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20985f : (BdListView) invokeV.objValue;
    }

    public ProgressBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20984e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20983d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20982c : (RelativeLayout) invokeV.objValue;
    }

    public void m(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f20988i = cVar;
        e();
        ArrayList<d> k2 = cVar.k();
        this.f20987h.h(this.f20988i);
        if (k2.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f20988i.y();
        if (!StringUtils.isNull(y)) {
            this.f20983d.showBanner(this.a, y, this.f20988i.z());
            return;
        }
        this.f20983d.hideBanner();
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f20986g.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f20985f.setSelection(i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f20982c);
            this.a.getLayoutMode().j(this.n);
            this.a.getLayoutMode().j(this.f20983d);
            SkinManager.setBackgroundColor(this.f20982c, R.color.CAM_X0201);
            this.f20981b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f20983d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.onChangeSkinType();
            }
            this.f20986g.C(i2);
            this.f20987h.notifyDataSetChanged();
        }
    }

    public void p(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f20985f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f20985f.startPullRefresh();
        }
    }
}
