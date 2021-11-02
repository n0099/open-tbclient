package b.a.r0.g3;

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
import b.a.q0.s.g0.f;
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
/* loaded from: classes4.dex */
public class j extends b.a.e.a.d<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f16862a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f16863b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f16864c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f16865d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f16866e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f16867f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.g f16868g;

    /* renamed from: h  reason: collision with root package name */
    public g f16869h;

    /* renamed from: i  reason: collision with root package name */
    public c f16870i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16871e;

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
            this.f16871e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16871e.f16862a.finish();
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16868g = null;
        this.f16862a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f16864c = (RelativeLayout) this.f16862a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f16862a.findViewById(R.id.view_navigation_bar);
        this.f16863b = navigationBar;
        navigationBar.setCenterTextTitle(this.f16862a.getPageContext().getString(R.string.signallforum));
        this.f16863b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f16863b.showBottomLine();
        BdListView bdListView = (BdListView) this.f16862a.findViewById(R.id.signallforum_list);
        this.f16867f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(signAllForumActivity.getPageContext());
        this.f16868g = gVar;
        this.f16867f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f16862a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f16867f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f16862a.getPageContext().getPageActivity());
        this.f16865d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f16866e = progressBar;
        progressBar.setOnClickListener(this.f16862a);
        this.f16867f.addHeaderView(this.f16865d);
        this.f16865d.setVisibility(8);
        this.j = (RelativeLayout) this.f16865d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f16865d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f16865d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f16865d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f16862a);
        g gVar2 = new g(this.f16862a, null);
        this.f16869h = gVar2;
        this.f16867f.setAdapter((ListAdapter) gVar2);
        this.f16867f.setOnScrollListener(this.f16869h);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16867f.completePullRefreshPostDelayed(0L);
        }
    }

    public final void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f16870i) == null) {
            return;
        }
        this.f16865d.setHasPrivilege(cVar.B());
        this.f16865d.setmCurrentStatus(this.f16870i.q());
        TextView message1 = this.f16865d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f16870i.v() + this.f16870i.t() + this.f16870i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f16870i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f16870i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f16865d.getMessage2().setText(this.f16870i.w());
        this.k.setText(this.f16870i.h());
        if (TextUtils.isEmpty(this.f16870i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f16870i.g());
        }
        this.f16865d.setVisibility(0);
        if (!this.f16870i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16869h : (g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16870i : (c) invokeV.objValue;
    }

    public LinearLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16867f : (BdListView) invokeV.objValue;
    }

    public ProgressBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16866e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16865d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16864c : (RelativeLayout) invokeV.objValue;
    }

    public void m(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f16870i = cVar;
        e();
        ArrayList<d> k = cVar.k();
        this.f16869h.h(this.f16870i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f16870i.y();
        if (!StringUtils.isNull(y)) {
            this.f16865d.showBanner(this.f16862a, y, this.f16870i.z());
            return;
        }
        this.f16865d.hideBanner();
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f16868g.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f16867f.setSelection(i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f16862a.getLayoutMode().k(i2 == 1);
            this.f16862a.getLayoutMode().j(this.f16864c);
            this.f16862a.getLayoutMode().j(this.n);
            this.f16862a.getLayoutMode().j(this.f16865d);
            SkinManager.setBackgroundColor(this.f16864c, R.color.CAM_X0201);
            this.f16863b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f16865d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.onChangeSkinType();
            }
            this.f16868g.C(i2);
            this.f16869h.notifyDataSetChanged();
        }
    }

    public void p(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f16867f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16867f.startPullRefresh();
        }
    }
}
