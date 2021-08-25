package c.a.q0.e3;

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
import c.a.p0.s.f0.f;
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
/* loaded from: classes3.dex */
public class j extends c.a.e.a.d<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f17116a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17117b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f17118c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f17119d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f17120e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f17121f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.g f17122g;

    /* renamed from: h  reason: collision with root package name */
    public g f17123h;

    /* renamed from: i  reason: collision with root package name */
    public c f17124i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f17125j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f17126e;

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
            this.f17126e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17126e.f17116a.finish();
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17122g = null;
        this.f17116a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f17118c = (RelativeLayout) this.f17116a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f17116a.findViewById(R.id.view_navigation_bar);
        this.f17117b = navigationBar;
        navigationBar.setCenterTextTitle(this.f17116a.getPageContext().getString(R.string.signallforum));
        this.f17117b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f17117b.showBottomLine();
        BdListView bdListView = (BdListView) this.f17116a.findViewById(R.id.signallforum_list);
        this.f17121f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(signAllForumActivity.getPageContext());
        this.f17122g = gVar;
        this.f17121f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f17116a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f17121f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f17116a.getPageContext().getPageActivity());
        this.f17119d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f17120e = progressBar;
        progressBar.setOnClickListener(this.f17116a);
        this.f17121f.addHeaderView(this.f17119d);
        this.f17119d.setVisibility(8);
        this.f17125j = (RelativeLayout) this.f17119d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f17119d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f17119d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f17119d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f17116a);
        g gVar2 = new g(this.f17116a, null);
        this.f17123h = gVar2;
        this.f17121f.setAdapter((ListAdapter) gVar2);
        this.f17121f.setOnScrollListener(this.f17123h);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17121f.completePullRefreshPostDelayed(0L);
        }
    }

    public final void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f17124i) == null) {
            return;
        }
        this.f17119d.setHasPrivilege(cVar.B());
        this.f17119d.setmCurrentStatus(this.f17124i.q());
        TextView message1 = this.f17119d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f17124i.v() + this.f17124i.t() + this.f17124i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f17124i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f17124i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f17119d.getMessage2().setText(this.f17124i.w());
        this.k.setText(this.f17124i.h());
        if (TextUtils.isEmpty(this.f17124i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f17124i.g());
        }
        this.f17119d.setVisibility(0);
        if (!this.f17124i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.f17125j.setVisibility(0);
        } else {
            this.f17125j.setVisibility(8);
        }
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17123h : (g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17124i : (c) invokeV.objValue;
    }

    public LinearLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17121f : (BdListView) invokeV.objValue;
    }

    public ProgressBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17120e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17119d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f17118c : (RelativeLayout) invokeV.objValue;
    }

    public void m(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f17124i = cVar;
        e();
        ArrayList<d> k = cVar.k();
        this.f17123h.h(this.f17124i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f17124i.y();
        if (!StringUtils.isNull(y)) {
            this.f17119d.showBanner(this.f17116a, y, this.f17124i.z());
            return;
        }
        this.f17119d.hideBanner();
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f17122g.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f17121f.setSelection(i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f17116a.getLayoutMode().k(i2 == 1);
            this.f17116a.getLayoutMode().j(this.f17118c);
            this.f17116a.getLayoutMode().j(this.n);
            this.f17116a.getLayoutMode().j(this.f17119d);
            SkinManager.setBackgroundColor(this.f17118c, R.color.CAM_X0201);
            this.f17117b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f17119d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.onChangeSkinType();
            }
            this.f17122g.D(i2);
            this.f17123h.notifyDataSetChanged();
        }
    }

    public void p(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f17121f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17121f.startPullRefresh();
        }
    }
}
