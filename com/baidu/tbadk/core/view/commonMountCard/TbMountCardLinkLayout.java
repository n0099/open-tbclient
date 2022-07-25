package com.baidu.tbadk.core.view.commonMountCard;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMountCardLinkHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cu4;
import com.repackage.cv4;
import com.repackage.pi;
import com.repackage.q85;
import com.repackage.sg8;
import com.repackage.vr4;
import com.repackage.wu4;
/* loaded from: classes3.dex */
public class TbMountCardLinkLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CardLinkInfoData b;
    public cv4 c;
    public View d;
    public TbImageView e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public FrameLayout j;
    public TBSpecificationBtn k;
    public ImageView l;
    public ImageView m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1742149398, "Lcom/baidu/tbadk/core/view/commonMountCard/TbMountCardLinkLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1742149398, "Lcom/baidu/tbadk/core/view/commonMountCard/TbMountCardLinkLayout;");
                return;
            }
        }
        n = pi.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        o = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        p = pi.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        q = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        r = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        s = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        t = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int getTagColorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            CardLinkInfoData cardLinkInfoData = this.b;
            int d = (cardLinkInfoData == null || StringUtils.isNull(cardLinkInfoData.getTagColor()) || !this.b.getTagColor().startsWith("CAM_")) ? 0 : sg8.d(this.a, this.b.getTagColor());
            return d == 0 ? R.color.CAM_X0304 : d;
        }
        return invokeV.intValue;
    }

    private void setTextBtnInfo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || this.k == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f096a);
        }
        this.k.setText(str);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            CardLinkInfoData cardLinkInfoData = this.b;
            TbMountCardLinkHelper.tbCardLinkClickStatistic(cardLinkInfoData != null ? cardLinkInfoData.getType() : "", getUseSource(), str);
        }
    }

    public final void b() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cardLinkInfoData = this.b) == null) {
            return;
        }
        if (!StringUtils.isNull(cardLinkInfoData.getImageUrl())) {
            this.e.J(this.b.getImageUrl(), 10, false);
        }
        if (StringUtils.isNull(this.b.getContent1())) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(this.b.getContent1());
        }
        if (StringUtils.isNull(this.b.getContent2())) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.i.setText(this.b.getContent2());
        }
        e();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d081d, (ViewGroup) this, true);
            this.e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f8f);
            this.f = findViewById(R.id.obfuscated_res_0x7f091f90);
            this.e.setDrawCorner(true);
            this.e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080939);
            this.e.setRadiusById(R.string.J_X04);
            this.e.setConrers(15);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091f92);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091f8c);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091f8d);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091f93);
            this.k = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f091f91);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f8b);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f8e);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(pi.f(getContext(), R.dimen.M_W_X003), pi.f(getContext(), R.dimen.M_H_X002), pi.f(getContext(), R.dimen.M_W_X006), pi.f(getContext(), R.dimen.M_H_X002));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vr4 d = vr4.d(this);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0206);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            vr4 d2 = vr4.d(this.f);
            d2.n(R.string.J_X04);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0203);
            f();
            TextView textView = this.g;
            if (textView != null) {
                vr4 d3 = vr4.d(textView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0107);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                vr4 d4 = vr4.d(textView2);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0109);
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                vr4 d5 = vr4.d(textView3);
                d5.A(R.string.F_X01);
                d5.v(R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f08093a, R.color.CAM_X0110, null);
            WebPManager.setPureDrawable(this.m, R.drawable.obfuscated_res_0x7f08093b, R.color.CAM_X0110, null);
        }
    }

    public final void e() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cardLinkInfoData = this.b) == null) {
            return;
        }
        String btnStyle = cardLinkInfoData.getBtnStyle();
        if ("0".equals(btnStyle)) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else if ("1".equals(btnStyle)) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            setTextBtnInfo(this.b.getBtnText());
            String textBtnStatus = this.b.getTextBtnStatus();
            if ("1".equals(textBtnStatus)) {
                this.k.setConfig(new wu4());
                this.k.setUseDisableState(true);
            } else if ("2".equals(textBtnStatus)) {
                wu4 wu4Var = new wu4();
                wu4Var.r(R.color.CAM_X0110);
                this.k.setConfig(wu4Var);
            } else {
                this.k.setConfig(new wu4());
            }
        } else if ("2".equals(btnStyle)) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.m.setVisibility(8);
        } else if ("3".equals(btnStyle)) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    public final void f() {
        CardLinkInfoData cardLinkInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cardLinkInfoData = this.b) == null) {
            return;
        }
        String tagText = cardLinkInfoData.getTagText();
        if (!StringUtils.isNull(tagText)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) tagText);
            int tagColorId = getTagColorId();
            cu4 cu4Var = new cu4(n, -1, tagColorId, p, tagColorId, q, t);
            cu4Var.b(o);
            cu4Var.h(r);
            cu4Var.i(s);
            spannableStringBuilder.setSpan(cu4Var, 0, tagText.length(), 17);
            spannableStringBuilder.append((CharSequence) this.b.getTitle());
            this.g.setText(spannableStringBuilder);
        } else {
            this.g.setText(this.b.getTitle());
        }
        if (!StringUtils.isNull(this.b.getContent1()) && !StringUtils.isNull(this.b.getContent2())) {
            this.g.setMaxLines(1);
        } else {
            this.g.setMaxLines(2);
        }
    }

    public String getUseSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a);
            return currentVisiblePageExtra != null ? currentVisiblePageExtra.a() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            CardLinkInfoData cardLinkInfoData = this.b;
            TbMountCardLinkHelper.tbCardLinkShowStatistic(cardLinkInfoData != null ? cardLinkInfoData.getType() : "", getUseSource());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091f8f) {
                cv4 cv4Var = this.c;
                if (cv4Var != null) {
                    cv4Var.a("2");
                }
                a("2");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f91) {
                cv4 cv4Var2 = this.c;
                if (cv4Var2 != null) {
                    cv4Var2.a("3");
                }
                a("3");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f8b) {
                cv4 cv4Var3 = this.c;
                if (cv4Var3 != null) {
                    cv4Var3.a("5");
                }
                a("5");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f8e) {
                cv4 cv4Var4 = this.c;
                if (cv4Var4 != null) {
                    cv4Var4.a("4");
                }
                a("4");
            } else {
                cv4 cv4Var5 = this.c;
                if (cv4Var5 != null) {
                    cv4Var5.a("1");
                }
                a("1");
            }
        }
    }

    public void setClickListener(cv4 cv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cv4Var) == null) {
            this.c = cv4Var;
        }
    }

    public void setData(CardLinkInfoData cardLinkInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cardLinkInfoData) == null) {
            this.b = cardLinkInfoData;
            b();
            d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMountCardLinkLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
    }
}
