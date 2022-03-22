package c.a.p0.j2.d;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f15681b;

    /* renamed from: c  reason: collision with root package name */
    public View f15682c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15683d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15684e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15685f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15686g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15687h;
    public TextView i;
    public TbImageView j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 3;
        TbPageContext<MemberExchangeActivity> pageContext = memberExchangeActivity.getPageContext();
        this.a = pageContext;
        this.f15681b = pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.obfuscated_res_0x7f0d0540);
        View findViewById = memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d4);
        this.f15682c = findViewById;
        findViewById.setOnClickListener(memberExchangeActivity);
        NavigationBar navigationBar = (NavigationBar) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091519);
        this.f15683d = navigationBar;
        navigationBar.setOnClickListener(memberExchangeActivity);
        this.f15685f = this.f15683d.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f05a6));
        this.f15684e = (NoNetworkView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f09159c);
        this.f15683d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15683d.showBottomLine();
        HeadImageView headImageView = (HeadImageView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d5);
        this.f15686g = headImageView;
        headImageView.setIsRound(true);
        this.f15687h = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d9);
        this.i = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d0);
        this.j = (TbImageView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d8);
        this.k = (EditText) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f090917);
        n.w(this.a.getPageActivity(), this.k);
        TextView textView = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f090cc1);
        this.l = textView;
        textView.setOnClickListener(memberExchangeActivity);
        TextView textView2 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091b04);
        this.m = textView2;
        textView2.setOnClickListener(null);
        TextView textView3 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091b01);
        this.n = textView3;
        textView3.setClickable(false);
        TextView textView4 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091b02);
        this.o = textView4;
        textView4.setClickable(false);
        TextView textView5 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091b03);
        this.p = textView5;
        textView5.setClickable(false);
        c(TbadkApplication.getInst().getSkinType());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) == null) {
            this.f15686g.J(str, 12, false);
            this.f15687h.setText(str2);
            if (!m.isEmpty(str3)) {
                this.j.setVisibility(0);
                this.j.J(str3, 10, false);
            } else {
                this.j.setVisibility(8);
            }
            if (!m.isEmpty(str4)) {
                TextView textView = this.i;
                textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f150b) + str4);
                return;
            }
            this.i.setText(str5);
        }
    }

    public EditText b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (EditText) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.q != i) {
                this.f15683d.onChangeSkinType(this.a, i);
                this.f15684e.c(this.a, i);
                SkinManager.setViewTextColor(this.f15687h, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
                this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
                SkinManager.setBackgroundResource(this.k, R.drawable.exchange_edit_text_bg);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.l, R.drawable.btn_all_orange);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            }
            this.q = i;
        }
    }
}
