package c.a.p0.w1.d;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27543a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27544b;

    /* renamed from: c  reason: collision with root package name */
    public View f27545c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f27546d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f27547e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27548f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f27549g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27550h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27551i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f27552j;
    public EditText k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;

    public a(MemberExchangeActivity memberExchangeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberExchangeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 3;
        TbPageContext<MemberExchangeActivity> pageContext = memberExchangeActivity.getPageContext();
        this.f27543a = pageContext;
        this.f27544b = pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        View findViewById = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.f27545c = findViewById;
        findViewById.setOnClickListener(memberExchangeActivity);
        NavigationBar navigationBar = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.f27546d = navigationBar;
        navigationBar.setOnClickListener(memberExchangeActivity);
        this.f27548f = this.f27546d.setCenterTextTitle(this.f27543a.getString(R.string.exchange_member));
        this.f27547e = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.f27546d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f27546d.showBottomLine();
        HeadImageView headImageView = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.f27549g = headImageView;
        headImageView.setIsRound(true);
        this.f27550h = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.f27551i = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.f27552j = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.k = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.x(this.f27543a.getPageActivity(), this.k);
        TextView textView = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.l = textView;
        textView.setOnClickListener(memberExchangeActivity);
        TextView textView2 = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.m = textView2;
        textView2.setOnClickListener(null);
        TextView textView3 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.n = textView3;
        textView3.setClickable(false);
        TextView textView4 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.o = textView4;
        textView4.setClickable(false);
        TextView textView5 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.p = textView5;
        textView5.setClickable(false);
        c(TbadkApplication.getInst().getSkinType());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) == null) {
            this.f27549g.startLoad(str, 12, false);
            this.f27550h.setText(str2);
            if (!k.isEmpty(str3)) {
                this.f27552j.setVisibility(0);
                this.f27552j.startLoad(str3, 10, false);
            } else {
                this.f27552j.setVisibility(8);
            }
            if (!k.isEmpty(str4)) {
                TextView textView = this.f27551i;
                textView.setText(this.f27543a.getString(R.string.vip_member_end_time_tips) + str4);
                return;
            }
            this.f27551i.setText(str5);
        }
    }

    public EditText b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (EditText) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.q != i2) {
                this.f27546d.onChangeSkinType(this.f27543a, i2);
                this.f27547e.onChangeSkinType(this.f27543a, i2);
                SkinManager.setViewTextColor(this.f27550h, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f27551i, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
                this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
                SkinManager.setBackgroundResource(this.k, R.drawable.exchange_edit_text_bg);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.l, R.drawable.btn_all_orange);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            }
            this.q = i2;
        }
    }
}
