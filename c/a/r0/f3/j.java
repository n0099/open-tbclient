package c.a.r0.f3;

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
import c.a.q0.s.f0.f;
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
    public SignAllForumActivity f17740a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17741b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f17742c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f17743d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f17744e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f17745f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.g f17746g;

    /* renamed from: h  reason: collision with root package name */
    public g f17747h;

    /* renamed from: i  reason: collision with root package name */
    public c f17748i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f17749j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f17750e;

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
            this.f17750e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17750e.f17740a.finish();
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
        this.f17746g = null;
        this.f17740a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f17742c = (RelativeLayout) this.f17740a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f17740a.findViewById(R.id.view_navigation_bar);
        this.f17741b = navigationBar;
        navigationBar.setCenterTextTitle(this.f17740a.getPageContext().getString(R.string.signallforum));
        this.f17741b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f17741b.showBottomLine();
        BdListView bdListView = (BdListView) this.f17740a.findViewById(R.id.signallforum_list);
        this.f17745f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(signAllForumActivity.getPageContext());
        this.f17746g = gVar;
        this.f17745f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f17740a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f17745f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f17740a.getPageContext().getPageActivity());
        this.f17743d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f17744e = progressBar;
        progressBar.setOnClickListener(this.f17740a);
        this.f17745f.addHeaderView(this.f17743d);
        this.f17743d.setVisibility(8);
        this.f17749j = (RelativeLayout) this.f17743d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f17743d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f17743d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f17743d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f17740a);
        g gVar2 = new g(this.f17740a, null);
        this.f17747h = gVar2;
        this.f17745f.setAdapter((ListAdapter) gVar2);
        this.f17745f.setOnScrollListener(this.f17747h);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17745f.completePullRefreshPostDelayed(0L);
        }
    }

    public final void e() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f17748i) == null) {
            return;
        }
        this.f17743d.setHasPrivilege(cVar.B());
        this.f17743d.setmCurrentStatus(this.f17748i.q());
        TextView message1 = this.f17743d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f17748i.v() + this.f17748i.t() + this.f17748i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f17748i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f17748i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f17743d.getMessage2().setText(this.f17748i.w());
        this.k.setText(this.f17748i.h());
        if (TextUtils.isEmpty(this.f17748i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f17748i.g());
        }
        this.f17743d.setVisibility(0);
        if (!this.f17748i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.f17749j.setVisibility(0);
        } else {
            this.f17749j.setVisibility(8);
        }
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17747h : (g) invokeV.objValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17748i : (c) invokeV.objValue;
    }

    public LinearLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17745f : (BdListView) invokeV.objValue;
    }

    public ProgressBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17744e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f17743d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f17742c : (RelativeLayout) invokeV.objValue;
    }

    public void m(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f17748i = cVar;
        e();
        ArrayList<d> k = cVar.k();
        this.f17747h.h(this.f17748i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f17748i.y();
        if (!StringUtils.isNull(y)) {
            this.f17743d.showBanner(this.f17740a, y, this.f17748i.z());
            return;
        }
        this.f17743d.hideBanner();
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f17746g.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f17745f.setSelection(i2);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f17740a.getLayoutMode().k(i2 == 1);
            this.f17740a.getLayoutMode().j(this.f17742c);
            this.f17740a.getLayoutMode().j(this.n);
            this.f17740a.getLayoutMode().j(this.f17743d);
            SkinManager.setBackgroundColor(this.f17742c, R.color.CAM_X0201);
            this.f17741b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f17743d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.onChangeSkinType();
            }
            this.f17746g.D(i2);
            this.f17747h.notifyDataSetChanged();
        }
    }

    public void p(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f17745f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17745f.startPullRefresh();
        }
    }
}
